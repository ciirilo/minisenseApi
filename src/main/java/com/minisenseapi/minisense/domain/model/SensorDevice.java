package com.minisenseapi.minisense.domain.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * SensorDevice
 */
@Table(name = "sensor_device")
@Entity
public class SensorDevice   {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
 

  @NotBlank
  private String chave;
  

  @Column
  private Long userId;

  @NotBlank
  private String label;

  @NotBlank
  private String description;
  
  @JsonManagedReference 
  @OneToMany(mappedBy = "sensor_device")
  private List<DataStream> streams;

  public SensorDevice id(Long id) {
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

public Long getUserId() {
	return userId;
}

public void setUserId(Long userId) {
	this.userId = userId;
}

public String getLabel() {
	return label;
}

public void setLabel(String label) {
	this.label = label;
}

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

public List<DataStream> getStreams() {
	return streams;
}

public void setStreams(List<DataStream> streams) {
	this.streams = streams;
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
	SensorDevice other = (SensorDevice) obj;
	if (id == null) {
		if (other.id != null)
			return false;
	} else if (!id.equals(other.id))
		return false;
	return true;
}

  
}

