package com.lab.housing.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HousingController {

	@RequestMapping("/hello")
	public String hello() {
		return "hello";
	}

	@RequestMapping("/world")
	public ModelAndView world() {
		ModelAndView view = new ModelAndView("world");
		return view;
	}

}
