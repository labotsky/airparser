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
@JsonPropertyOrder({ "award_list" })
public class AwardList {

  @JsonProperty("award_list")
  private List<Award> awardList = new ArrayList<Award>();

  /**
   * 
   * @return The awardList
   */
  @JsonProperty("award_list")
  public List<Award> getAwardList() {
    return awardList;
  }

  /**
   * 
   * @param awardList
   *          The award_list
   */
  @JsonProperty("award_list")
  public void setAwardList(List<Award> awardList) {
    this.awardList = awardList;
  }

}
