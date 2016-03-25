package com.united.parse;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.nodes.Element;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.united.entity.Award;

/**
 * 
 * @author Labotski_SV
 *
 */
public class ParseUtil {

  private String setupLocalTime(String[] hourMinutes) {
    int hour = 0;
    int minute = 0;
    String time = null;
    if (hourMinutes.length == 2) {
      hour = Integer.valueOf(hourMinutes[0].replace("h", "").trim());
      minute = Integer.valueOf(hourMinutes[1].replace("m", "").trim());
      time = String.valueOf(hour) + ":" + String.valueOf(minute);
    }
    else {
      if (hourMinutes.length == 1 && hourMinutes[0].contains("m")) {
        minute = Integer.valueOf(hourMinutes[0].replace("m", ""));
        time = "00:" + String.valueOf(minute);
        return time;
      }
      if (hourMinutes.length == 1 && hourMinutes[0].contains("h")) {
        hour = Integer.valueOf(hourMinutes[0].replace("h", ""));
        time = String.valueOf(hour) + ":00";
        return time;
      }
    }
    return time;
  }

  public String parseTime(String str) {
    return setupLocalTime(str.split(" "));
  }

  public boolean isTwoDaysTravel(Element arriveDepart) {
    if (arriveDepart.text().contains("Arrive") || arriveDepart.text().contains("Depart")) {
      return true;
    }
    return false;
  }

  public String getTime(String str) {
    Pattern p1 = Pattern.compile("\\((.*?)\\)");
    Matcher m = p1.matcher(str);
    if (m.find()) {
      String[] times = m.group(0).replace("(", "").replace(")", "").split(" ");
      return setupLocalTime(times);
    }
    return "00:00";
  }

  public String getArriveDepartCode(String str) {
    String code = null;
    Pattern p1 = Pattern.compile("\\((.*?)\\)");
    Matcher m = p1.matcher(str);
    if (m.find()) {
      code = m.group(0).replace("(", "").replace(")", "");
    }
    return code;
  }

  public int getMiles(String miles) {
    miles = miles.replaceAll("[^\\d]", "");
    int number = Integer.parseInt(miles);
    return number * 1000;
  }

  public double getTaxes(String taxes) {
    taxes = taxes.replaceAll("[^\\d\\.]", "");
    Double taxesDouble = Double.parseDouble(taxes);
    return taxesDouble;
  }

  public static String createJsonFromAwardList(List<Award> list) {
    ObjectMapper mapper = new ObjectMapper();
    String jsonInString = null;
    try {
      jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(list);
    }
    catch (JsonProcessingException e1) {
      e1.printStackTrace();
    }
    return jsonInString;
  }

}
