package com.lab.housing.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HousingController {
	
	@RequestMapping("/hello")
	public String hello() {
		System.out.println("-------------------");
		return "hello";
	}

}
