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
@JsonPropertyOrder({ "field_name", "field_type", "field_value", "field_lvl", "field_id" })
public class ExtraDatum {

  @JsonProperty("field_name")
  private String fieldName;

  @JsonProperty("field_type")
  private String fieldType;

  @JsonProperty("field_value")
  private String fieldValue;

  @JsonProperty("field_lvl")
  private String fieldLvl;

  @JsonProperty("field_id")
  private String fieldId;

  @Override
  public String toString() {
    return "ExtraDatum [fieldName=" + fieldName + ", fieldType=" + fieldType + ", fieldValue=" + fieldValue + ", fieldLvl=" + fieldLvl + ", fieldId=" + fieldId
        + "]";
  }

  /**
   * 
   * @return The fieldName
   */
  @JsonProperty("field_name")
  public String getFieldName() {
    return fieldName;
  }

  /**
   * 
   * @param fieldName
   *          The field_name
   */
  @JsonProperty("field_name")
  public void setFieldName(String fieldName) {
    this.fieldName = fieldName;
  }

  /**
   * 
   * @return The fieldType
   */
  @JsonProperty("field_type")
  public String getFieldType() {
    return fieldType;
  }

  /**
   * 
   * @param fieldType
   *          The field_type
   */
  @JsonProperty("field_type")
  public void setFieldType(String fieldType) {
    this.fieldType = fieldType;
  }

  /**
   * 
   * @return The fieldValue
   */
  @JsonProperty("field_value")
  public String getFieldValue() {
    return fieldValue;
  }

  /**
   * 
   * @param fieldValue
   *          The field_value
   */
  @JsonProperty("field_value")
  public void setFieldValue(String fieldValue) {
    this.fieldValue = fieldValue;
  }

  /**
   * 
   * @return The fieldLvl
   */
  @JsonProperty("field_lvl")
  public String getFieldLvl() {
    return fieldLvl;
  }

  /**
   * 
   * @param fieldLvl
   *          The field_lvl
   */
  @JsonProperty("field_lvl")
  public void setFieldLvl(String fieldLvl) {
    this.fieldLvl = fieldLvl;
  }

  /**
   * 
   * @return The fieldId
   */
  @JsonProperty("field_id")
  public String getFieldId() {
    return fieldId;
  }

  /**
   * 
   * @param fieldId
   *          The field_id
   */
  @JsonProperty("field_id")
  public void setFieldId(String fieldId) {
    this.fieldId = fieldId;
  }

}
