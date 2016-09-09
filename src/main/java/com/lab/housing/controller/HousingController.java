package com.lab.housing.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lab.housing.dao.CityDao;
import com.lab.housing.model.City;

@Controller
public class HousingController {

    @Resource
    private CityDao cityDao;

    @RequestMapping("/")
    public ModelAndView home() {
        List<City> cs = cityDao.list();
        ModelAndView view = new ModelAndView("city_list");
        view.addObject("city_list", cs);
        return view;
    }

}
