package com.minisenseapi.minisense.domain.model;

import java.math.BigDecimal;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * List of measures
 */

@Entity
public class Measurements   {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id = null;
  private BigDecimal timestamp = null;
  private Float value = null;
  private Long unitId = null;
  
  @ManyToOne
  @JoinColumn(name = "data_stream.id")
  private DataStream data_stream;

  public Measurements id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  **/
 

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Measurements timestamp(BigDecimal timestamp) {
    this.timestamp = timestamp;
    return this;
  }

  /**
   * Get timestamp
   * @return timestamp
  **/
  @ApiModelProperty(example = "1.506521102E9", value = "")

  @Valid

  public BigDecimal getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(BigDecimal timestamp) {
    this.timestamp = timestamp;
  }

  public Measurements value(Float value) {
    this.value = value;
    return this;
  }

  /**
   * Get value
   * @return value
  **/
  @ApiModelProperty(value = "")


  public Float getValue() {
    return value;
  }

  public void setValue(Float value) {
    this.value = value;
  }

  public Measurements unitId(Long unitId) {
    this.unitId = unitId;
    return this;
  }

  /**
   * Get unitId
   * @return unitId
  **/
  @ApiModelProperty(value = "")


  public Long getUnitId() {
    return unitId;
  }

  public void setUnitId(Long unitId) {
    this.unitId = unitId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Measurements measurements = (Measurements) o;
    return Objects.equals(this.id, measurements.id) &&
        Objects.equals(this.timestamp, measurements.timestamp) &&
        Objects.equals(this.value, measurements.value) &&
        Objects.equals(this.unitId, measurements.unitId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, timestamp, value, unitId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Measurements {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    timestamp: ").append(toIndentedString(timestamp)).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
    sb.append("    unitId: ").append(toIndentedString(unitId)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

