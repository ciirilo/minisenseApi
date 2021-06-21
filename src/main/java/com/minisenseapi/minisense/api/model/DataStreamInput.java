package com.minisenseapi.minisense.api.model;



public class DataStreamInput {
	
	private String label;
	private Long unit_Id;
	private Integer alertMaxValue;
	private Integer alertMinValue;
	
	
	
	
	public Integer getAlertMaxValue() {
		return alertMaxValue;
	}
	public void setAlertMaxValue(Integer alertMaxValue) {
		this.alertMaxValue = alertMaxValue;
	}
	public Integer getAlertMinValue() {
		return alertMinValue;
	}
	public void setAlertMinValue(Integer alertMinValue) {
		this.alertMinValue = alertMinValue;
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
	
	
	
	
}
