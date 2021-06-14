package com.minisenseapi.minisense.domain.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * SensorDevice
 */
@Table(name = "sensor_device")
@Entity
public class SensorDevice   {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

  @Column(name = "chave")
  private String chave;
  

  @Column
  private Long userId;

  @JsonProperty("label")
  private String label;

  @JsonProperty("description")
  private String description;
  
  
  @OneToMany(mappedBy = "sensor_device")
  private List<DataStream> streams;

  public SensorDevice id(Long id) {
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

  public SensorDevice key(String key) {
    this.chave = key;
    return this;
  }

  /**
   * Get chave
   * @return chave
  **/
  


  public String getKey() {
    return chave;
  }

  public void setKey(String chave) {
    this.chave = chave;
  }

  public SensorDevice userId(Long userId) {
    this.userId = userId;
    return this;
  }

  /**
   * Get userId
   * @return userId
  **/
  @ApiModelProperty


  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public SensorDevice label(String label) {
    this.label = label;
    return this;
  }

  /**
   * Get label
   * @return label
  **/
  @ApiModelProperty(example = "Widget Adapter", required = true)
  @NotNull


  public String getLabel() {
    return label;
  }

  public void setLabel(String label) {
    this.label = label;
  }

  public SensorDevice description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Get description
   * @return description
  **/
 

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public SensorDevice streams(List<DataStream> streams) {
    this.streams = streams;
    return this;
  }

  public SensorDevice addStreamsItem(DataStream streamsItem) {
    if (this.streams == null) {
      this.streams = new ArrayList<DataStream>();
    }
    this.streams.add(streamsItem);
    return this;
  }

  /**
   * Get streams
   * @return streams
  **/
  
  @Valid

  public List<DataStream> getStreams() {
    return streams;
  }

  public void setStreams(List<DataStream> streams) {
    this.streams = streams;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SensorDevice sensorDevice = (SensorDevice) o;
    return Objects.equals(this.id, sensorDevice.id) &&
        Objects.equals(this.chave, sensorDevice.chave) &&
        Objects.equals(this.userId, sensorDevice.userId) &&
        Objects.equals(this.label, sensorDevice.label) &&
        Objects.equals(this.description, sensorDevice.description) &&
        Objects.equals(this.streams, sensorDevice.streams);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, chave, userId, label, description, streams);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SensorDevice {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    chave: ").append(toIndentedString(chave)).append("\n");
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
    sb.append("    label: ").append(toIndentedString(label)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    streams: ").append(toIndentedString(streams)).append("\n");
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

