package com.minisenseapi.minisense.domain.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * DataStream
 */
@Table(name = "data_stream")
@Entity
public class DataStream   {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
  	private Long id;

  
  private String chave;

  
  private String label;

  
  private Boolean enabled;

  
  private Long unitId;

  @ManyToOne
  @JoinColumn(name = "sensor_device.streams")
  private SensorDevice sensor_device;

  
  private Long measurementCount;
  
  
  @OneToMany(mappedBy = "data_stream")
  private List<Measurements> measurement;
	
  public DataStream id(Long id) {
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

  public DataStream key(String chave) {
    this.chave = chave;
    return this;
  }

  /**
   * Get key
   * @return key
  **/
  @ApiModelProperty(example = "10dd35008a0f4d838c3dc22856660928")


  public String getKey() {
    return chave;
  }

  public void setKey(String chave) {
    this.chave = chave;
  }

  public DataStream label(String label) {
    this.label = label;
    return this;
  }

  /**
   * Get label
   * @return label
  **/
  @ApiModelProperty


  public String getLabel() {
    return label;
  }

  public void setLabel(String label) {
    this.label = label;
  }

  public DataStream enabled(Boolean enabled) {
    this.enabled = enabled;
    return this;
  }

  /**
   * Get enabled
   * @return enabled
  **/
  @ApiModelProperty


  public Boolean isEnabled() {
    return enabled;
  }

  public void setEnabled(Boolean enabled) {
    this.enabled = enabled;
  }

  public DataStream unitId(Long unitId) {
    this.unitId = unitId;
    return this;
  }

  /**
   * Get unitId
   * @return unitId
  **/
  @ApiModelProperty


  public Long getUnitId() {
    return unitId;
  }

  public void setUnitId(Long unitId) {
    this.unitId = unitId;
  }

  public DataStream measurementCount(Long measurementCount) {
    this.measurementCount = measurementCount;
    return this;
  }

  /**
   * Get measurementCount
   * @return measurementCount
  **/
  @ApiModelProperty


  public Long getMeasurementCount() {
    return measurementCount;
  }

  public void setMeasurementCount(Long measurementCount) {
    this.measurementCount = measurementCount;
  }

  public DataStream measurement(List<Measurements> measurement) {
    this.measurement = measurement;
    return this;
  }

  public DataStream addMeasurementItem(Measurements measurementItem) {
    if (this.measurement == null) {
      this.measurement = new ArrayList<Measurements>();
    }
    this.measurement.add(measurementItem);
    return this;
  }

  /**
   * Get measurement
   * @return measurement
  **/
  @ApiModelProperty

  @Valid

  public List<Measurements> getMeasurement() {
    return measurement;
  }

  public void setMeasurement(List<Measurements> measurement) {
    this.measurement = measurement;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DataStream dataStream = (DataStream) o;
    return Objects.equals(this.id, dataStream.id) &&
        Objects.equals(this.chave, dataStream.chave) &&
        Objects.equals(this.label, dataStream.label) &&
        Objects.equals(this.enabled, dataStream.enabled) &&
        Objects.equals(this.unitId, dataStream.unitId) &&
        Objects.equals(this.sensor_device, dataStream.sensor_device) &&
        Objects.equals(this.measurementCount, dataStream.measurementCount) &&
        Objects.equals(this.measurement, dataStream.measurement);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, chave, label, enabled, unitId, sensor_device, measurementCount, measurement);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DataStream {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    key: ").append(toIndentedString(chave)).append("\n");
    sb.append("    label: ").append(toIndentedString(label)).append("\n");
    sb.append("    enabled: ").append(toIndentedString(enabled)).append("\n");
    sb.append("    unitId: ").append(toIndentedString(unitId)).append("\n");
    sb.append("    deviceId: ").append(toIndentedString(sensor_device)).append("\n");
    sb.append("    measurementCount: ").append(toIndentedString(measurementCount)).append("\n");
    sb.append("    measurement: ").append(toIndentedString(measurement)).append("\n");
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

