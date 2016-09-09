package com.lab.housing.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.lab.housing.dao.CityDao;
import com.lab.housing.dao.HouseDao;
import com.lab.housing.model.City;
import com.lab.housing.model.House;

@Controller
public class HousingController {

    @Resource
    private CityDao cityDao;

    @Resource
    private HouseDao houseDao;

    @RequestMapping("/")
    public ModelAndView home() {
        List<City> data = cityDao.list();
        
        Map<String, List<City>> map = new LinkedHashMap<>();
        
        List<City> cs = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            if (i % 20 == 0) {
                cs = new ArrayList<>();
                map.put("省" + i, cs);
            }
            cs.add(data.get(i));
        }
        ModelAndView view = new ModelAndView("city_list");
        view.addObject("map", map);
        return view;
    }

    @RequestMapping("/house")
    public ModelAndView house(@RequestParam String abbr) {
        List<House> houses = houseDao.list(abbr);
        ModelAndView view = new ModelAndView("house_list");
        view.addObject("list", houses);
        return view;
    }

}
