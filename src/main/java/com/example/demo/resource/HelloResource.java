package com.example.demo.resource;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/docker/hello")
public class HelloResource {
	
	@GetMapping
	public String hello() {
		return "Hello Youtube";
	}
	
	@GetMapping(value= "/json", produces = MediaType.APPLICATION_JSON_VALUE)
	public Hello json() {
		return new Hello("trance", "100");
		
	}


}
