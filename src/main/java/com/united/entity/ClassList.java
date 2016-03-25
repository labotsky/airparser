package com.united.entity;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * 
 * @author Labotski_SV
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "name", "status", "mileage", "tax", "id" })
public class ClassList {

  @JsonProperty("name")
  private String name;

  @JsonProperty("status")
  private String status;

  @JsonProperty("mileage")
  private String mileage;

  @JsonProperty("tax")
  private String tax;

  @JsonProperty("id")
  private Integer id;

  @JsonIgnore
  private Map<String, Object> additionalProperties = new HashMap<String, Object>();

  @Override
  public String toString() {
    return "ClassList [name=" + name + ", status=" + status + ", mileage=" + mileage + ", tax=" + tax + ", id=" + id + ", additionalProperties="
        + additionalProperties + "]";
  }

  /**
   * 
   * @return The name
   */
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  /**
   * 
   * @param name
   *          The name
   */
  @JsonProperty("name")
  public void setName(String name) {
    this.name = name;
  }

  /**
   * 
   * @return The status
   */
  @JsonProperty("status")
  public String getStatus() {
    return status;
  }

  /**
   * 
   * @param status
   *          The status
   */
  @JsonProperty("status")
  public void setStatus(String status) {
    this.status = status;
  }

  /**
   * 
   * @return The mileage
   */
  @JsonProperty("mileage")
  public String getMileage() {
    return mileage;
  }

  /**
   * 
   * @param mileage
   *          The mileage
   */
  @JsonProperty("mileage")
  public void setMileage(String mileage) {
    this.mileage = mileage;
  }

  /**
   * 
   * @return The tax
   */
  @JsonProperty("tax")
  public String getTax() {
    return tax;
  }

  /**
   * 
   * @param tax
   *          The tax
   */
  @JsonProperty("tax")
  public void setTax(String tax) {
    this.tax = tax;
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

  @JsonAnyGetter
  public Map<String, Object> getAdditionalProperties() {
    return this.additionalProperties;
  }

  @JsonAnySetter
  public void setAdditionalProperty(String name, Object value) {
    this.additionalProperties.put(name, value);
  }

}