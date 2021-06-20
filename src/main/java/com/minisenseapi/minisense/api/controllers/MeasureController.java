package com.minisenseapi.minisense.api.controllers;

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

import com.minisenseapi.minisense.api.model.MeasurementsInput;
import com.minisenseapi.minisense.api.model.MeasurementsModel;
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
	
	@ApiOperation("Registra um medição em uma stream")
	@PostMapping
	@RequestMapping(value = "/stream/{stream_id}/measure", method = RequestMethod.POST, produces="application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public MeasurementsModel create(@Valid @RequestBody MeasurementsInput measurements, @PathVariable Long stream_id) {
		
		Measurements measure = cadastroMeasurementsService.create(stream_id, measurements);
		DataStream data = dataStreamRepository.findById(stream_id).get();
		data.setMeasurementCount(data.getMeasurementCount() +1L);
		
		return toModel(measurementsRepository.save(measure));
	}
	
	private MeasurementsModel toModel(Measurements measure) {
		return modelMapper.map(measure, MeasurementsModel.class);
	}
	
	

}
