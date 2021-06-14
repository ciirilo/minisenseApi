package com.minisenseapi.minisense.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.minisenseapi.minisense.domain.model.Measurements;

@Repository
public interface MeasurementsRepository extends JpaRepository<Measurements, Long> {
	
	
}
