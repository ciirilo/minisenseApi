package com.minisenseapi.minisense.domain.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.minisenseapi.minisense.domain.model.Unit;

@Repository
public interface UnitRepository extends JpaRepository<Unit, Long>{
	
	boolean existsBySymbol(String symbol);
	boolean existsById(Long id);
	
}