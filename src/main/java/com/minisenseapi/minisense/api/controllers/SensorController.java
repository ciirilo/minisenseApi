package com.minisenseapi.minisense.api.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.minisenseapi.minisense.domain.model.SensorDevice;
import com.minisenseapi.minisense.domain.model.User;
import com.minisenseapi.minisense.domain.repository.SensorRepository;
import com.minisenseapi.minisense.domain.repository.UserRepository;


@RestController
@RequestMapping("/sensor")
public class SensorController {

	@Autowired
    private SensorRepository sensorRepository;
    
	@Autowired
    private UserRepository userRepository;
	
	@GetMapping
	public List<SensorDevice> read(){
		return sensorRepository.findAll();
	}
    
	@GetMapping("/{userId}")
    public ResponseEntity<List<SensorDevice>> list(@PathVariable Long userId){
    	
    	Optional<User> user = userRepository.findById(userId);
    	
    	if(user.isPresent()) {
    		List<SensorDevice> list = sensorRepository.findByUserId(userId);
    		return ResponseEntity.ok(list);
    	}
    	return ResponseEntity.notFound().build();
    }
	
	@PostMapping("{userId}")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<SensorDevice> create(@RequestBody SensorDevice sensor, @PathVariable Long userId) {
		
		/*
		if(!sensorRepository.existsByChave(sensor.getKey())) {
			
			return ResponseEntity.badRequest().build();
		}
		*/
		sensor.setUserId(userId);
		
		
		return ResponseEntity.ok(sensorRepository.save(sensor));
		
	}
	
	

}
