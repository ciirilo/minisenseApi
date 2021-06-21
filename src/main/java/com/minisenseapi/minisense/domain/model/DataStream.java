package com.minisenseapi.minisense.domain.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
public class DataStream   {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
  	private Long id;

	@NotBlank
	private Integer alert_max_value;
	
	@NotBlank
	private Integer alert_min_value;
	
	@NotBlank
	private String chave;
	
	@NotBlank
  	private String label;

	@NotBlank
  	private Boolean enabled;

	@NotBlank
  	private Long unit_Id;
  
  	private Long measurementCount = 0L;
  
  	@JsonManagedReference 
	@OneToMany(mappedBy = "data_stream")
	private List<Measurements> measurement;
  
  	@JsonBackReference 
  	@ManyToOne 
  	private SensorDevice sensor_device;


  
public SensorDevice getSensor_device() {
	return sensor_device;
}

public void setSensor_device(SensorDevice sensor_device) {
	this.sensor_device = sensor_device;
}


  public DataStream id(Long id) {
    this.id = id;
    return this;
  }

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getChave() {
	return chave;
}

public void setChave(String chave) {
	this.chave = chave;
}

public String getLabel() {
	return label;
}

public void setLabel(String label) {
	this.label = label;
}

public Boolean getEnabled() {
	return enabled;
}

public void setEnabled(Boolean enabled) {
	this.enabled = enabled;
}

public Long getUnit_Id() {
	return unit_Id;
}

public void setUnit_Id(Long unit_Id) {
	this.unit_Id = unit_Id;
}

public Long getMeasurementCount() {
	return measurementCount;
}

public void setMeasurementCount(Long measurementCount) {
	this.measurementCount = measurementCount;
}

public List<Measurements> getMeasurement() {
	return measurement;
}

public Integer getAlertMaxValue() {
	return alert_max_value;
}

public void setAlertMaxValue(Integer alertMaxValue) {
	this.alert_max_value = alertMaxValue;
}

public Integer getAlertMinValue() {
	return alert_min_value;
}

public void setAlertMinValue(Integer alertMinValue) {
	this.alert_min_value = alertMinValue;
}

public void setMeasurement(List<Measurements> measurement) {
	this.measurement = measurement;
}



@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((id == null) ? 0 : id.hashCode());
	return result;
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	DataStream other = (DataStream) obj;
	if (id == null) {
		if (other.id != null)
			return false;
	} else if (!id.equals(other.id))
		return false;
	return true;
}


}

