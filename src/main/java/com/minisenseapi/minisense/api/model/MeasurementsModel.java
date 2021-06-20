package com.minisenseapi.minisense.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class MeasurementsModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	

	private String time;
	private Float value;
	private Long unitId;
  
	

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getTime() {
	return time;
}

public void setTime(String time) {
	this.time = time;
}

public Float getValue() {
	return value;
}

public void setValue(Float value) {
	this.value = value;
}

public Long getUnitId() {
	return unitId;
}

public void setUnitId(Long unitId) {
	this.unitId = unitId;
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
	MeasurementsModel other = (MeasurementsModel) obj;
	if (id == null) {
		if (other.id != null)
			return false;
	} else if (!id.equals(other.id))
		return false;
	return true;
}
  
  
	
}
