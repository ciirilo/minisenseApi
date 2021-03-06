package com.minisenseapi.minisense.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * List of measures
 */

@Entity
public class Measurements   {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
	
	@NotBlank
	@Size(max = 10)
  private String time;
	
	@NotBlank
  private Float value;
	
	@NotBlank
  private Long unitId;
  
  @JsonBackReference 
  @ManyToOne
  private DataStream data_stream;

  public Measurements id(Long id) {
    this.id = id;
    return this;
  }

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

public DataStream getData_stream() {
	return data_stream;
}

public void setData_stream(DataStream data_stream) {
	this.data_stream = data_stream;
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
	Measurements other = (Measurements) obj;
	if (id == null) {
		if (other.id != null)
			return false;
	} else if (!id.equals(other.id))
		return false;
	return true;
}

 
}

