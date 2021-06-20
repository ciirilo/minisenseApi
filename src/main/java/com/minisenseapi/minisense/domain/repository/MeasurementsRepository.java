package com.minisenseapi.minisense.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.minisenseapi.minisense.domain.model.Measurements;

@Repository
public interface MeasurementsRepository extends JpaRepository<Measurements, Long> {
	
	@Query(value = "SELECT * FROM measurements WHERE measurements.data_stream_id = ?1 ORDER BY measurements.id DESC LIMIT 0, 5 ", nativeQuery = true)
	List<Measurements> list(@Param("?1") Long streamId);
}
