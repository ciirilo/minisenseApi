package com.minisenseapi.minisense.api.model;

import javax.validation.constraints.NotBlank;

public class SensorDeviceInput {
	
	@NotBlank
	private String label;
	
	@NotBlank
	private String description;
	
	
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

	
	
	
}
