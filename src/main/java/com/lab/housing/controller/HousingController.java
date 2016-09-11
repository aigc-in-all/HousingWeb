package com.lab.housing.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

    @RequestMapping(value = "/", method = RequestMethod.GET)
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

    @RequestMapping(value="/house", method = RequestMethod.GET)
    public ModelAndView house(
            @RequestParam(value = "cid") int cityId,
            @RequestParam(value = "page", required = false) Integer page) {

        ModelAndView view = new ModelAndView("house_list");

        page = page == null ? 1 : page;

        int count = houseDao.count();
        List<House> houses = houseDao.list(cityId, page - 1);

        if (count > 0) {
            int mod = count % HouseDao.PAGE_SIZE;
            int pageCount = mod > 0 ? count / HouseDao.PAGE_SIZE + 1 : count / HouseDao.PAGE_SIZE;

            int[] pages = new int[pageCount];
            for (int i = 0; i < pageCount; i++) {
                pages[i] = i + 1;
            }

            view.addObject("pages", pages);
            view.addObject("list", houses);
            view.addObject("pageSize", pages.length);
        }

        view.addObject("curPage", page);
        view.addObject("cityId", cityId);
        return view;
    }

}
