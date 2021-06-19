package com.minisenseapi.minisense.api.controllers;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

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

import com.minisenseapi.minisense.api.model.SensorModel;
import com.minisenseapi.minisense.domain.exception.HandlerException;
import com.minisenseapi.minisense.domain.model.SensorDevice;
import com.minisenseapi.minisense.domain.model.User;
import com.minisenseapi.minisense.domain.repository.SensorRepository;
import com.minisenseapi.minisense.domain.repository.UserRepository;

import eye2web.modelmapper.ModelMapper;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@ApiResponses(value = {
	    @ApiResponse(code = 200, message = "Retorna um usuário"),
	    @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
	    @ApiResponse(code = 500, message = "Foi gerada uma exceção")
	})
@RestController
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private SensorRepository sensorRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@ApiOperation("Retorna uma lista de usuários")
	@GetMapping
	@RequestMapping(value = "/user", method = RequestMethod.GET, produces="application/json")
	public List<User> read() {
		return userRepository.findAll();
	}
	
	
	@ApiOperation("Retorna uma lista de dispositivos de um usuário")
	@GetMapping
	@RequestMapping( value = "/user/{userId}", method = RequestMethod.GET, produces="application/json")
	public List<SensorModel> find(@PathVariable Long userId) {
		
		Optional<User> user = userRepository.findById(userId);

    	if(!user.isPresent()) {
    		throw new HandlerException("Usuário não existe");
    	}
		
		List<SensorDevice> list =sensorRepository.findByUserId(userId);
		
		if(list.isEmpty()) {
			throw new HandlerException("Usuário não possui Sensores");
		}
		
		return toCollectionModel(list);
					
	}
	
	@ApiOperation("Registra um usuário")
	@PostMapping
	@RequestMapping( value = "/user", method = RequestMethod.POST, produces="application/json" , consumes="application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<User> create(@Valid @RequestBody User user) {
		
		if(userRepository.existsByEmail(user.getEmail())) {
			
			 throw new HandlerException("Usuário já existe");
		}
		
		return ResponseEntity.ok(userRepository.save(user));
		
	}

	private SensorModel toModel(SensorDevice sensor) {
		return modelMapper.map(sensor, SensorModel.class);
	}
	
	
	private List<SensorModel> toCollectionModel(List<SensorDevice> sensorDevice) {
		return sensorDevice.stream()
				.map(sensor -> toModel(sensor))
				.collect(Collectors.toList());
	}
	
}
