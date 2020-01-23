package com.camel.main;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

@Service
public class ApplicationBootStrap {

	@PostConstruct
	public void init() {

		// can instantiate required beans before application startup
		// will use it later depending on use-case
		
	}
}
