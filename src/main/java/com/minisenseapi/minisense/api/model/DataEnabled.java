package com.minisenseapi.minisense.api.model;

import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.minisenseapi.minisense.domain.model.Measurements;

public class DataEnabled {

	private Long id;
	private String chave;
	private String label;
	private Boolean enabled;
	private Long unit_Id;
	private Long measurementCount;
	

	
	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
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

}
