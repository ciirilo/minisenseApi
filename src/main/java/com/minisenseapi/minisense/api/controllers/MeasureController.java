package com.minisenseapi.minisense.api.controllers;

import javax.swing.JOptionPane;
import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.minisenseapi.minisense.api.model.DataEnabled;
import com.minisenseapi.minisense.api.model.EnabledInput;
import com.minisenseapi.minisense.api.model.MeasurementsInput;
import com.minisenseapi.minisense.api.model.MeasurementsModel;
import com.minisenseapi.minisense.domain.exception.HandlerException;
import com.minisenseapi.minisense.domain.model.DataStream;
import com.minisenseapi.minisense.domain.model.Measurements;
import com.minisenseapi.minisense.domain.repository.DataStreamRepository;
import com.minisenseapi.minisense.domain.repository.MeasurementsRepository;
import com.minisenseapi.minisense.domain.service.CadastroMeasurementsService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@ApiResponses(value = {
	    @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
	    @ApiResponse(code = 500, message = "Foi gerada uma exceção")
	})
@RestController
public class MeasureController  {

	@Autowired
    private MeasurementsRepository measurementsRepository;
	
	@Autowired
	private CadastroMeasurementsService cadastroMeasurementsService;
	
	@Autowired
	private DataStreamRepository dataStreamRepository;
    
	@Autowired
	private ModelMapper modelMapper;
	
	@ApiOperation("Registra um medição em uma datastream")
	@PostMapping
	@RequestMapping(value = "/stream/{stream_id}/measure", method = RequestMethod.POST, produces="application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public MeasurementsModel create(@Valid @RequestBody MeasurementsInput measurements, @PathVariable Long stream_id) {
		
		DataStream data = dataStreamRepository.findById(stream_id)
				.orElseThrow(() -> new HandlerException("DataStream não existe"));
		Float value =  measurements.getValue();
		
		
		if(!data.getEnabled()) {
			throw new HandlerException("Stream está desativada");
		}
		
		Measurements measure = cadastroMeasurementsService.create(stream_id, measurements);
		
		data.setMeasurementCount(data.getMeasurementCount() +1L);
		
		measurementsRepository.save(measure);
		
		if(value > data.getAlertMaxValue() || value < data.getAlertMinValue()) {
			throw new HandlerException("Alerta! Medição ultrapassou os limites!");
		}
		
		return toModel(measure);
		
		
	}
	
	@ApiOperation("Modifica o estado da stream")
	@PostMapping
	@RequestMapping(value = "/stream/{stream_id}/enable", method = RequestMethod.POST, produces="application/json")
	public DataEnabled enabled(@RequestBody EnabledInput set,@PathVariable Long stream_id) {
		
		DataStream data = dataStreamRepository.findById(stream_id).get();
		
		data.setEnabled(set.isSet());
		
		return toModel(dataStreamRepository.save(data));
	}
	
	private MeasurementsModel toModel(Measurements measure) {
		return modelMapper.map(measure, MeasurementsModel.class);
	}
	
	private DataEnabled toModel(DataStream data) {
		return modelMapper.map(data, DataEnabled.class);
	}
	
	
}
