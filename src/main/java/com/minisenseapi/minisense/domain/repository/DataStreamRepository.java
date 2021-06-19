package com.minisenseapi.minisense.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.minisenseapi.minisense.domain.model.DataStream;

@Repository
public interface DataStreamRepository extends JpaRepository<DataStream, Long> {
	
	boolean existsByChave(String chave);

}
