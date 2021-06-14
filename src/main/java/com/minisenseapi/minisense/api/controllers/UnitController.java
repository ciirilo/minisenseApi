package com.minisenseapi.minisense.api.controllers;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.minisenseapi.minisense.domain.model.Unit;
import com.minisenseapi.minisense.domain.repository.UnitRepository;

import com.minisenseapi.minisense.domain.model.Measurements;


import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/unit")
public class UnitController {

	@Autowired
    private UnitRepository unitRepository;
    
    @GetMapping
	public List<Unit> read() {
		return unitRepository.findAll();
	}
	
	
    @PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Unit> create(@RequestBody Unit unit) {
		
		if(unitRepository.existsBySymbol(unit.getSymbol())) {
			
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
		
		return ResponseEntity.ok(unitRepository.save(unit));
		
	}

}
