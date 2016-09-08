package com.lab.housing.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lab.housing.dao.CityDao;

@Controller
public class HousingController {

	@Resource
	CityDao cityDao;

	@RequestMapping("/hello")
	public String hello() {
		return "hello";
	}

	@RequestMapping("/world")
	public ModelAndView world() {
		System.out.println(cityDao);
		ModelAndView view = new ModelAndView("world");
		return view;
	}

}
