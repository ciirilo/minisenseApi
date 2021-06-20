package com.minisenseapi.minisense.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minisenseapi.minisense.api.model.SensorDeviceInput;
import com.minisenseapi.minisense.domain.exception.HandlerException;
import com.minisenseapi.minisense.domain.model.SensorDevice;
import com.minisenseapi.minisense.domain.model.User;
import com.minisenseapi.minisense.domain.repository.SensorRepository;
import com.minisenseapi.minisense.domain.repository.UserRepository;

@Service
public class CadastroSensorService {
	
	@Autowired
	private SensorRepository sensorRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private GerarHash gerarHash;
	
	public SensorDevice salvar(Long user_id, SensorDeviceInput sensorInput) {
		
		User user = userRepository.findById(user_id)
				.orElseThrow(() -> new HandlerException("Usuário não existe"));
		
		SensorDevice sensor = new SensorDevice();
		
		sensor.setUserId(user_id);
		sensor.setChave(gerarHash.generate());
		sensor.setDescription(sensorInput.getDescription());
		sensor.setLabel(sensorInput.getLabel());
		
		return sensorRepository.save(sensor);
	}
	
	public void excluir(Long sensor_id) {
		sensorRepository.deleteById(sensor_id);
	}
	
	private User buscar(Long user_id) {
		
		return userRepository.findById(user_id)
				.orElseThrow(() -> new HandlerException("Usuário não existe"));
	}
	
}
