package com.minisenseapi.minisense.api.controllers;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.minisenseapi.minisense.domain.exception.HandlerException;
import com.minisenseapi.minisense.domain.model.Unit;
import com.minisenseapi.minisense.domain.repository.UnitRepository;

import io.swagger.annotations.ApiOperation;

@RestController
public class UnitController {

	@Autowired
    private UnitRepository unitRepository;
    
	@ApiOperation("Retorna uma lista de unidades de medida")
    @GetMapping
    @RequestMapping( value = "/unit", method = RequestMethod.GET, produces="application/json")
	public List<Unit> read() {
		return unitRepository.findAll();
	}
	
	
    @ApiOperation("Registra uma unidade de medida")
    @PostMapping
    @RequestMapping( value = "/unit", method = RequestMethod.POST, produces="application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Unit> create(@Valid @RequestBody Unit unit) {
		
		if(unitRepository.existsBySymbol(unit.getSymbol())) {
			
			throw new HandlerException("Símbolo já existe");
		}
		
		return ResponseEntity.ok(unitRepository.save(unit));
		
	}

}
