package com.united.parse;

import java.io.File;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import net.anthavio.phanbedder.Phanbedder;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.google.common.base.Function;
import com.united.entity.AirLines;
import com.united.entity.Award;
import com.united.entity.ClassList;
import com.united.entity.FlightList;

/**
 * 
 * @author Labotski_SV
 *
 */
public class AirLinesParser {

  private static final String AVAILABLE = "AVAILABLE";

  private WebDriver driver;

  private JavascriptExecutor jse;

  private String url;

  private Wait<WebDriver> wait;

  private ParseUtil parseUtil = new ParseUtil();

  public List<Award> fullParseAirLines(AirLines airLines) {
    List<Award> fullListAward = new ArrayList<Award>();
    for (LocalDate date = LocalDate.parse(airLines.getStartDate()); date.isBefore(LocalDate.parse(airLines.getEndDate()).plusDays(1)); date = date.plusDays(1)) {
      List<Award> listAward = parse(airLines, date.toString());
      fullListAward.addAll(listAward);
    }
    return fullListAward;
  }

  private void waitElement(String cssSelector) {
    wait.until(new Function<WebDriver, WebElement>() {
      public WebElement apply(WebDriver driver) {
        return driver.findElement(By.cssSelector(cssSelector));
      }
    });
  }

  private List<Award> parse(AirLines airLines, String date) {
    setup(airLines, date);
    jse = (JavascriptExecutor) driver;
    waitElement(".flight-result-list");
    String size = (String) jse.executeScript("return $('#fl-results-pager-container li:last').prev().text()");
    int sizeInt = Integer.valueOf(size);
    List<Award> fullListAward = new ArrayList<Award>();
    for (int k = 1; k <= sizeInt; k++) {
      waitElement("#resultViewTypeExpanded");
      waitElement(".toggle-flight-block-details");
      waitElement(".flight-duration span");
      jse.executeScript("$('#resultViewTypeExpanded').click()");
      jse.executeScript("$('.toggle-flight-block-details').click()");
      jse.executeScript("$('.flight-duration span').remove()");
      List<Award> awardList = createObject(airLines, Jsoup.parse(driver.getPageSource()));
      fullListAward.addAll(awardList);
      if (sizeInt != 1) {
        jse.executeScript("$('#fl-results-pager-container li:last a').click()");
      }
    }
    driver.close();
    driver = null;
    return fullListAward;
  }

  private List<Award> createObject(AirLines airLines, Document doc) {
    Elements flightDetails = doc.getElementsByClass("flight-block-fares");
    List<Award> awardList = new ArrayList<Award>();
    for (int idClassList = 0; idClassList < flightDetails.size(); idClassList++) {
      List<ClassList> classList = new ArrayList<ClassList>();
      List<FlightList> flightList = new ArrayList<FlightList>();

      Elements economy = flightDetails.get(idClassList).getElementsByClass("bg-economy");
      Elements business = flightDetails.get(idClassList).getElementsByClass("bg-business");
      Elements first = flightDetails.get(idClassList).getElementsByClass("bg-first");
      int id = 0;
      for (Element e : economy) {
        classListParser(classList, id, e, "E");
      }
      for (Element e : business) {
        classListParser(classList, id, e, "B");
      }
      for (Element e : first) {
        classListParser(classList, id, e, "F");
      }

      Elements arriveDepart = flightDetails.get(idClassList).getElementsByClass("advisories-list");
      Elements arriveDepartTime = flightDetails.get(idClassList).getElementsByClass("segment-times");
      Elements arriveDepartPlace = flightDetails.get(idClassList).getElementsByClass("segment-orig-dest");
      Elements flightNumber = flightDetails.get(idClassList).getElementsByClass("flight-number");
      Elements aircraft = flightDetails.get(idClassList).getElementsByClass("segment-flight-equipment");
      Elements layoverTime = flightDetails.get(idClassList).getElementsByClass("width-restrictor");
      Elements flightDuration = doc.getElementsByClass("flight-duration");
      for (int i = 0; i < arriveDepartPlace.size(); i++) {
        FlightList list = new FlightList();
        if (arriveDepart.size() > i && parseUtil.isTwoDaysTravel(arriveDepart.get(i))) {
          list.setArriveDate(LocalDate.parse(airLines.getStartDate()).plusDays(1).toString());
          list.setDepartDate(LocalDate.parse(airLines.getStartDate()).toString());
        }
        else {
          list.setArriveDate(LocalDate.parse(airLines.getStartDate()).toString());
          list.setDepartDate(LocalDate.parse(airLines.getStartDate()).toString());
        }
        String time = arriveDepartTime.get(i).text();
        String place = arriveDepartPlace.get(i).text();
        String[] timeStr = time.split(" ");
        String[] placeStr = place.split("to");
        list.setDepartTime(timeStr[0].trim());
        list.setArriveTime(timeStr[3].trim());
        list.setDepartPlace(placeStr[0].trim());
        list.setArrivePlace(placeStr[1].trim());
        list.setDepartCode(parseUtil.getArriveDepartCode(placeStr[0].trim()));
        list.setArriveCode(parseUtil.getArriveDepartCode(placeStr[1].trim()));
        list.setTravelTime(parseUtil.getTime(time).toString().trim());
        list.setFlightNumber(flightNumber.get(i).text().replaceAll("\\s", ""));
        list.setAirlineCompany(flightNumber.get(i).text().substring(0, 2).trim());
        list.setAircraft(aircraft.get(i).text().split("\\|")[1].trim());
        list.setMeal("");
        if (layoverTime.size() >= i && i != 0) {
          list.setLayoverTime(parseUtil.parseTime(layoverTime.get(i - 1).text().replace("connection", "").trim()));
        }
        else {
          list.setLayoverTime(LocalTime.of(0, 0).toString());
        }
        list.setId(i);
        flightList.add(list);
      }
      Award award = new Award();
      award.setClassList(classList);
      award.setFlightList(flightList);
      award.setTotalDuration(parseUtil.parseTime(flightDuration.get(idClassList).text().trim()));
      award.setSplit(false);
      awardList.add(award);
    }
    return awardList;
  }

  private void classListParser(List<ClassList> classList, int id, Element e, String name) {
    Elements milesElements = e.getElementsByClass("pp-base-price");
    Elements taxesElements = e.getElementsByClass("pp-additional-fare");
    for (int i = 0; i < milesElements.size(); i++) {
      ClassList list = new ClassList();
      list.setId(id++);
      list.setStatus(AVAILABLE);
      list.setName(name);
      list.setTax(String.valueOf(parseUtil.getTaxes(taxesElements.get(i).text())));
      list.setMileage(String.valueOf(parseUtil.getMiles(milesElements.get(i).text())));
      classList.add(list);
    }
  }

  private void setup(AirLines airLines, String date) {
    File phantomjs = Phanbedder.unpack();
    DesiredCapabilities dcaps = new DesiredCapabilities();
    dcaps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, phantomjs.getAbsolutePath());
    driver = getInstanceDriver(dcaps);
    url =
        "https://www.united.com/ual/en/us/flight-search/book-a-flight/results/awd?f=" + airLines.getOrigin() + "&t=" + airLines.getDestination() + "&d=" + date
            + "&tt=1&at=1&sc=7&px=" + airLines.getSeats() + "&taxng=1&idx=1";
    driver.get(url);
    wait = new FluentWait<WebDriver>(driver).withTimeout(30, TimeUnit.SECONDS).pollingEvery(5, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
  }

  private WebDriver getInstanceDriver(DesiredCapabilities desireCaps) {
    if (driver == null) {
      driver = new PhantomJSDriver(desireCaps);
    }
    return driver;
  }

}
