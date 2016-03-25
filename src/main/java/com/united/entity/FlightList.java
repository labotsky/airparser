package com.united.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * 
 * @author Labotski_SV
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "depart_time", "depart_date", "depart_place", "depart_code", "arrive_time", "arrive_date", "arrive_place", "arrive_code", "travel_time",
    "flight_number", "airline_company", "aircraft", "meal", "id", "layover_time" })
public class FlightList {

  @JsonProperty("depart_time")
  private String departTime;

  @JsonProperty("depart_date")
  private String departDate;

  @JsonProperty("depart_place")
  private String departPlace;

  @JsonProperty("depart_code")
  private String departCode;

  @JsonProperty("arrive_time")
  private String arriveTime;

  @JsonProperty("arrive_date")
  private String arriveDate;

  @JsonProperty("arrive_place")
  private String arrivePlace;

  @JsonProperty("arrive_code")
  private String arriveCode;

  @JsonProperty("travel_time")
  private String travelTime;

  @JsonProperty("flight_number")
  private String flightNumber;

  @JsonProperty("airline_company")
  private String airlineCompany;

  @JsonProperty("aircraft")
  private String aircraft;

  @JsonProperty("meal")
  private String meal;

  @JsonProperty("id")
  private Integer id;

  @JsonProperty("layover_time")
  private String layoverTime;

  @Override
  public String toString() {
    return "FlightList [departTime=" + departTime + ", departDate=" + departDate + ", departPlace=" + departPlace + ", departCode=" + departCode
        + ", arriveTime=" + arriveTime + ", arriveDate=" + arriveDate + ", arrivePlace=" + arrivePlace + ", arriveCode=" + arriveCode + ", travelTime="
        + travelTime + ", flightNumber=" + flightNumber + ", airlineCompany=" + airlineCompany + ", aircraft=" + aircraft + ", meal=" + meal + ", id=" + id
        + ", layoverTime=" + layoverTime + "]";
  }

  /**
   * 
   * @return The departTime
   */
  @JsonProperty("depart_time")
  public String getDepartTime() {
    return departTime;
  }

  /**
   * 
   * @param departTime
   *          The depart_time
   */
  @JsonProperty("depart_time")
  public void setDepartTime(String departTime) {
    this.departTime = departTime;
  }

  /**
   * 
   * @return The departDate
   */
  @JsonProperty("depart_date")
  public String getDepartDate() {
    return departDate;
  }

  /**
   * 
   * @param departDate
   *          The depart_date
   */
  @JsonProperty("depart_date")
  public void setDepartDate(String departDate) {
    this.departDate = departDate;
  }

  /**
   * 
   * @return The departPlace
   */
  @JsonProperty("depart_place")
  public String getDepartPlace() {
    return departPlace;
  }

  /**
   * 
   * @param departPlace
   *          The depart_place
   */
  @JsonProperty("depart_place")
  public void setDepartPlace(String departPlace) {
    this.departPlace = departPlace;
  }

  /**
   * 
   * @return The departCode
   */
  @JsonProperty("depart_code")
  public String getDepartCode() {
    return departCode;
  }

  /**
   * 
   * @param departCode
   *          The depart_code
   */
  @JsonProperty("depart_code")
  public void setDepartCode(String departCode) {
    this.departCode = departCode;
  }

  /**
   * 
   * @return The arriveTime
   */
  @JsonProperty("arrive_time")
  public String getArriveTime() {
    return arriveTime;
  }

  /**
   * 
   * @param arriveTime
   *          The arrive_time
   */
  @JsonProperty("arrive_time")
  public void setArriveTime(String arriveTime) {
    this.arriveTime = arriveTime;
  }

  /**
   * 
   * @return The arriveDate
   */
  @JsonProperty("arrive_date")
  public String getArriveDate() {
    return arriveDate;
  }

  /**
   * 
   * @param arriveDate
   *          The arrive_date
   */
  @JsonProperty("arrive_date")
  public void setArriveDate(String arriveDate) {
    this.arriveDate = arriveDate;
  }

  /**
   * 
   * @return The arrivePlace
   */
  @JsonProperty("arrive_place")
  public String getArrivePlace() {
    return arrivePlace;
  }

  /**
   * 
   * @param arrivePlace
   *          The arrive_place
   */
  @JsonProperty("arrive_place")
  public void setArrivePlace(String arrivePlace) {
    this.arrivePlace = arrivePlace;
  }

  /**
   * 
   * @return The arriveCode
   */
  @JsonProperty("arrive_code")
  public String getArriveCode() {
    return arriveCode;
  }

  /**
   * 
   * @param arriveCode
   *          The arrive_code
   */
  @JsonProperty("arrive_code")
  public void setArriveCode(String arriveCode) {
    this.arriveCode = arriveCode;
  }

  /**
   * 
   * @return The travelTime
   */
  @JsonProperty("travel_time")
  public String getTravelTime() {
    return travelTime;
  }

  /**
   * 
   * @param travelTime
   *          The travel_time
   */
  @JsonProperty("travel_time")
  public void setTravelTime(String travelTime) {
    this.travelTime = travelTime;
  }

  /**
   * 
   * @return The flightNumber
   */
  @JsonProperty("flight_number")
  public String getFlightNumber() {
    return flightNumber;
  }

  /**
   * 
   * @param flightNumber
   *          The flight_number
   */
  @JsonProperty("flight_number")
  public void setFlightNumber(String flightNumber) {
    this.flightNumber = flightNumber;
  }

  /**
   * 
   * @return The airlineCompany
   */
  @JsonProperty("airline_company")
  public String getAirlineCompany() {
    return airlineCompany;
  }

  /**
   * 
   * @param airlineCompany
   *          The airline_company
   */
  @JsonProperty("airline_company")
  public void setAirlineCompany(String airlineCompany) {
    this.airlineCompany = airlineCompany;
  }

  /**
   * 
   * @return The aircraft
   */
  @JsonProperty("aircraft")
  public String getAircraft() {
    return aircraft;
  }

  /**
   * 
   * @param aircraft
   *          The aircraft
   */
  @JsonProperty("aircraft")
  public void setAircraft(String aircraft) {
    this.aircraft = aircraft;
  }

  /**
   * 
   * @return The meal
   */
  @JsonProperty("meal")
  public String getMeal() {
    return meal;
  }

  /**
   * 
   * @param meal
   *          The meal
   */
  @JsonProperty("meal")
  public void setMeal(String meal) {
    this.meal = meal;
  }

  /**
   * 
   * @return The id
   */
  @JsonProperty("id")
  public Integer getId() {
    return id;
  }

  /**
   * 
   * @param id
   *          The id
   */
  @JsonProperty("id")
  public void setId(Integer id) {
    this.id = id;
  }

  /**
   * 
   * @return The layoverTime
   */
  @JsonProperty("layover_time")
  public String getLayoverTime() {
    return layoverTime;
  }

  /**
   * 
   * @param layoverTime
   *          The layover_time
   */
  @JsonProperty("layover_time")
  public void setLayoverTime(String layoverTime) {
    this.layoverTime = layoverTime;
  }

}
