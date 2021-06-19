package com.minisenseapi.minisense.api.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;



public class SensorModel {

	private Long id;
 
	private String chave;
  
	private String label;

	private String description;
  

  	private List<DataStreamModel> streams = new ArrayList<>();

 
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

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

	public List<DataStreamModel> getStreams() {
	return streams;
}

public void setStreams(List<DataStreamModel> streams) {
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
		SensorModel other = (SensorModel) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
	
}
