package com.lab.housing.test;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lab.housing.dao.CityDao;
import com.lab.housing.dao.ProvinceDao;
import com.lab.housing.model.City;
import com.lab.housing.model.Province;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/springmvc.xml")
public class CityDaoTest {

    @Resource
    ProvinceDao provinceDao;

    @Resource
    CityDao cityDao;

    @Test
    public void testGet() {
        City city = cityDao.get(1);
        System.out.println("---->" + city);
    }

    @Test
    public void testList() {
        Province p = provinceDao.get(1);
        List<City> cs = cityDao.list(p.getId());
        for (City c : cs) {
            System.out.println(c);
        }
    }
}
