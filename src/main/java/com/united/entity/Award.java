package com.united.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * 
 * @author Labotski_SV
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "class_list", "flight_list", "total_duration", "extra_data", "split" })
public class Award {

  @JsonProperty("class_list")
  private List<ClassList> classList = new ArrayList<ClassList>();

  @JsonProperty("flight_list")
  private List<FlightList> flightList = new ArrayList<FlightList>();

  @JsonProperty("total_duration")
  private String totalDuration;

  @JsonProperty("extra_data")
  private List<ExtraDatum> extraData = new ArrayList<ExtraDatum>();

  @JsonProperty("split")
  private Boolean split;

  @Override
  public String toString() {
    return "AwardList [classList=" + classList + ", flightList=" + flightList + ", totalDuration=" + totalDuration + ", extraData=" + extraData + ", split="
        + split + "]";
  }

  /**
   * 
   * @return The classList
   */
  @JsonProperty("class_list")
  public List<ClassList> getClassList() {
    return classList;
  }

  /**
   * 
   * @param classList
   *          The class_list
   */
  @JsonProperty("class_list")
  public void setClassList(List<ClassList> classList) {
    this.classList = classList;
  }

  /**
   * 
   * @return The flightList
   */
  @JsonProperty("flight_list")
  public List<FlightList> getFlightList() {
    return flightList;
  }

  /**
   * 
   * @param flightList
   *          The flight_list
   */
  @JsonProperty("flight_list")
  public void setFlightList(List<FlightList> flightList) {
    this.flightList = flightList;
  }

  /**
   * 
   * @return The totalDuration
   */
  @JsonProperty("total_duration")
  public String getTotalDuration() {
    return totalDuration;
  }

  /**
   * 
   * @param totalDuration
   *          The total_duration
   */
  @JsonProperty("total_duration")
  public void setTotalDuration(String totalDuration) {
    this.totalDuration = totalDuration;
  }

  /**
   * 
   * @return The extraData
   */
  @JsonProperty("extra_data")
  public List<ExtraDatum> getExtraData() {
    return extraData;
  }

  /**
   * 
   * @param extraData
   *          The extra_data
   */
  @JsonProperty("extra_data")
  public void setExtraData(List<ExtraDatum> extraData) {
    this.extraData = extraData;
  }

  /**
   * 
   * @return The split
   */
  @JsonProperty("split")
  public Boolean getSplit() {
    return split;
  }

  /**
   * 
   * @param split
   *          The split
   */
  @JsonProperty("split")
  public void setSplit(Boolean split) {
    this.split = split;
  }

}
