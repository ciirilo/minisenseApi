package com.minisenseapi.minisense.domain.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class GerarHash {

	  public static String generate() {
	       UUID idOne = UUID.randomUUID();
	       
	       return idOne.toString().substring(0, 32).replaceAll("-", "");
	  }
	
}
