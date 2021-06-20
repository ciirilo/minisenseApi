package com.minisenseapi.minisense.api.model;


public class DataStreamModel  {

	private Long id;

	private String chave;

	private String label;
	  
	private Long unit_Id;
	
	private Long device_id;  
	
	private Long measurementCount;


	
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

	public Long getDevice_id() {
		return device_id;
	}

	public void setDevice_id(Long device_id) {
		this.device_id = device_id;
	}

	public Long getMeasurementCount() {
		return measurementCount;
	}

	public void setMeasurementCount(Long measurementCount) {
		this.measurementCount = measurementCount;
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
		DataStreamModel other = (DataStreamModel) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
