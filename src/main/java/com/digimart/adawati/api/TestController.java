package com.digimart.adawati.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	@GetMapping("/v1/test")
	public String test(@RequestParam(name="testParam") String testParam) {
		ResponseEntity<String> response  = new ResponseEntity<>(HttpStatus.OK);
		return testParam;
		
	}

}
