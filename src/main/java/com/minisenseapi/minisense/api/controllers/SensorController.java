package com.minisenseapi.minisense.api.controllers;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Query;
import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.minisenseapi.minisense.api.model.SensorDeviceInput;
import com.minisenseapi.minisense.api.model.SensorDeviceModel;
import com.minisenseapi.minisense.domain.exception.HandlerException;
import com.minisenseapi.minisense.domain.model.DataStream;
import com.minisenseapi.minisense.domain.model.Measurements;
import com.minisenseapi.minisense.domain.model.SensorDevice;
import com.minisenseapi.minisense.domain.repository.MeasurementsRepository;
import com.minisenseapi.minisense.domain.repository.SensorRepository;
import com.minisenseapi.minisense.domain.repository.UserRepository;
import com.minisenseapi.minisense.domain.service.CadastroSensorService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@ApiResponses(value = {
	    @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
	    @ApiResponse(code = 500, message = "Foi gerada uma exceção")
	})
@RestController
public class SensorController {
	
	@Autowired
	private CadastroSensorService cadastroSensorService;

	@Autowired
    private SensorRepository sensorRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private MeasurementsRepository measurementsRepository;
    
	@Autowired
    private UserRepository userRepository;
	

	@ApiOperation("Retorna um dispositivo específico")
	@GetMapping
	@RequestMapping( value = "/sensor/{chave}", method = RequestMethod.GET, produces="application/json")
    public SensorDevice find(@PathVariable String chave){
    	
		SensorDevice sensor = sensorRepository.findByChave(chave);
		if(sensor == null) {
			throw new HandlerException("Sensor não existe");
		}
		
		List<DataStream> stream = sensor.getStreams();
		stream.stream()
			.map(s -> toMaxResults(s))
			.collect(Collectors.toList());
		sensor.setStreams(stream);
		
    	return sensor;
    	
    }
	
	@ApiOperation("Registra dispositivo para um usuário")
	@PostMapping
	@RequestMapping( value = "/sensor/{userId}", method = RequestMethod.POST, produces="application/json" , consumes="application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public SensorDeviceModel create(@Valid @RequestBody SensorDeviceInput sensorDeviceInput, @PathVariable Long userId) {
		
		SensorDevice sensor = cadastroSensorService.salvar(userId, sensorDeviceInput);
		
		return toModel(sensorRepository.save(sensor));
		
	}
	
	private SensorDeviceModel toModel(SensorDevice sensor) {
		return modelMapper.map(sensor, SensorDeviceModel.class);
	}
	
	
	private List<SensorDeviceModel> toCollectionModel(List<SensorDevice> sensorDevice) {
		return sensorDevice.stream()
				.map(sensor -> toModel(sensor))
				.collect(Collectors.toList());
	}
	
	private DataStream toMaxResults(DataStream stream){
		
		Long streamId = stream.getId();
		List<Measurements> measurements = measurementsRepository.list(streamId);
		stream.setMeasurement(measurements);
		
		return stream;
		
	
	}
	
	

}
