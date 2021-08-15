package com.example.curd.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultrequestController {
	
	  //TODO need to create API Documentation and assumption page here and return it.
		@GetMapping("/")
		public String home() {
			
			return "this is home page";
		}

}
