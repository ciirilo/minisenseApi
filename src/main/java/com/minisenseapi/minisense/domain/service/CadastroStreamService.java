package com.minisenseapi.minisense.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minisenseapi.minisense.api.model.DataStreamInput;
import com.minisenseapi.minisense.domain.exception.HandlerException;
import com.minisenseapi.minisense.domain.model.DataStream;
import com.minisenseapi.minisense.domain.model.SensorDevice;
import com.minisenseapi.minisense.domain.repository.DataStreamRepository;
import com.minisenseapi.minisense.domain.repository.SensorRepository;
import com.minisenseapi.minisense.domain.repository.UnitRepository;

@Service
public class CadastroStreamService {

	@Autowired
	private DataStreamRepository streamRepository;
	
	@Autowired
	private SensorRepository sensorDeviceRepository;
	
	@Autowired
	private UnitRepository unitRepository;
	
	@Autowired
	private GerarHash gerarHash;
	
	
	
	public DataStream salvar(Long sensor_id, DataStreamInput streamInput) {
		
		SensorDevice sensor = sensorDeviceRepository.findById(sensor_id)
				.orElseThrow(() -> new HandlerException("Sensor não encontrado"));
		
		DataStream stream = new DataStream();
		
		
		stream.setChave(gerarHash.generate());
		stream.setEnabled(stream.getEnabled());
		stream.setLabel(streamInput.getLabel());
		stream.setUnit_Id(streamInput.getUnit_Id());
		stream.setSensor_device(sensor);
		
		
		return streamRepository.save(stream);
		
	}
	public void excluir(Long stream_id) {
		streamRepository.deleteById(stream_id);
	}
	
	private DataStream buscar(Long stream_id) {
		
		return streamRepository.findById(stream_id)
				.orElseThrow(() -> new HandlerException("Stream não encontrada"));
	}
	
	
	
	
}
