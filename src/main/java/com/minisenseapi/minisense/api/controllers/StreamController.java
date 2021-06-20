package com.minisenseapi.minisense.api.controllers;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.minisenseapi.minisense.api.model.DataStreamInput;
import com.minisenseapi.minisense.api.model.DataStreamModel;
import com.minisenseapi.minisense.domain.exception.HandlerException;
import com.minisenseapi.minisense.domain.model.DataStream;
import com.minisenseapi.minisense.domain.repository.DataStreamRepository;
import com.minisenseapi.minisense.domain.repository.SensorRepository;
import com.minisenseapi.minisense.domain.repository.UnitRepository;
import com.minisenseapi.minisense.domain.service.CadastroStreamService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@ApiResponses(value = {
	    @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
	    @ApiResponse(code = 500, message = "Foi gerada uma exceção")
	})
@RestController
public class StreamController {

	@Autowired
	private CadastroStreamService cadastroStreamService;
	
	@Autowired
    private SensorRepository sensorRepository;
    
	@Autowired
    private DataStreamRepository streamRepository;
	
	@Autowired
	private UnitRepository unitRepository;
	
	@Autowired 
	private ModelMapper modelMapper;
	
	
	@ApiOperation("Retorna uma stream específica")
	@GetMapping
	@RequestMapping( value = "/stream/{streamId}", method = RequestMethod.GET, produces="application/json")
    public ResponseEntity<DataStream> list(@PathVariable Long streamId){
    	
		Optional<DataStream> stream = streamRepository.findById(streamId);
    	
		if(stream.isEmpty()) {
			throw new HandlerException("DataStream não existe");
		}
    	return ResponseEntity.ok(stream.get());
    }
	
	@ApiOperation("Registra uma datastream em um dispositivo")
	@PostMapping
	@RequestMapping( value = "/stream/{sensor_device_id}", method = RequestMethod.POST, produces="application/json" , consumes="application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public DataStreamModel create(@RequestBody DataStreamInput dataStream, @PathVariable Long sensor_device_id) {
		
		
		unitRepository.findById(dataStream.getUnit_Id())
		.orElseThrow(() -> new HandlerException("Unidade não existe"));
		
		DataStream data = cadastroStreamService.salvar(sensor_device_id, dataStream);
		DataStreamModel model = toModel(data);
		model.setMeasurementCount(0L);
		model.setDevice_id(sensor_device_id);
		return model;
	}
	
	private DataStreamModel toModel(DataStream data) {
		return modelMapper.map(data, DataStreamModel.class);
	}
	
}
