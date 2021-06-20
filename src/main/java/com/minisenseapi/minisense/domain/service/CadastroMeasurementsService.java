package com.minisenseapi.minisense.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.minisenseapi.minisense.api.model.MeasurementsInput;
import com.minisenseapi.minisense.domain.exception.HandlerException;
import com.minisenseapi.minisense.domain.model.DataStream;
import com.minisenseapi.minisense.domain.model.Measurements;
import com.minisenseapi.minisense.domain.repository.DataStreamRepository;
import com.minisenseapi.minisense.domain.repository.MeasurementsRepository;

@Service
public class CadastroMeasurementsService {

	@Autowired
	private MeasurementsRepository measurementsRepository;
	
	@Autowired
	private DataStreamRepository dataStreamRepository;
	
	public Measurements create(@PathVariable Long data_stream_id
			,@RequestBody MeasurementsInput measureInput) {
		
		DataStream data = dataStreamRepository.findById(data_stream_id)
				.orElseThrow(() -> new HandlerException("Sensor não existe"));
		Measurements measure = new Measurements();
		
		measure.setTime(measureInput.getTime());
		measure.setData_stream(data);
		measure.setUnitId(data.getUnit_Id());
		measure.setValue(measureInput.getValue());
		
		
		return measurementsRepository.save(measure);
	}
	
	
}	

