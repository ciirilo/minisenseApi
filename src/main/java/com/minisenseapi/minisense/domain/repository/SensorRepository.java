package com.minisenseapi.minisense.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.minisenseapi.minisense.domain.model.SensorDevice;

@Repository
public interface SensorRepository extends JpaRepository<SensorDevice, Long> {
	
	boolean existsByChave(String chave);
	List<SensorDevice> findByUserId(Long num);
	SensorDevice findByChave(String chave);
	
	
}
