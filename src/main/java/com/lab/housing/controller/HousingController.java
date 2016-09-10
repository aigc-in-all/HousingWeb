package com.lab.housing.controller;

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
import com.lab.housing.dao.ProvinceDao;
import com.lab.housing.model.City;
import com.lab.housing.model.House;
import com.lab.housing.model.Province;

@Controller
public class HousingController {

    @Resource
    private ProvinceDao provinceDao;

    @Resource
    private CityDao cityDao;

    @Resource
    private HouseDao houseDao;

    @RequestMapping("/")
    public ModelAndView home() {
        Map<String, List<City>> map = new LinkedHashMap<>();

        List<Province> ps = provinceDao.list();
        for (Province p : ps) {
            List<City> cs = cityDao.list(p.getId());
            map.put(p.getName(), cs);
        }

        ModelAndView view = new ModelAndView("city_list");
        view.addObject("map", map);
        return view;
    }

    @RequestMapping("/house")
    public ModelAndView house(@RequestParam(value = "cid") int cityId) {
        List<House> houses = houseDao.list(cityId);
        ModelAndView view = new ModelAndView("house_list");
        view.addObject("list", houses);
        return view;
    }

}
