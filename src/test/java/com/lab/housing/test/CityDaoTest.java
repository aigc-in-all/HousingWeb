package com.lab.housing.test;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lab.housing.dao.CityDao;
import com.lab.housing.model.City;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/springmvc.xml")
public class CityDaoTest {

	@Resource
	CityDao cityDao;

	@Test
	public void testGet() {
		System.out.println("hello:" + cityDao);
		City city = cityDao.get("sz");
		System.out.println("---->" + city);
	}

	@Test
	public void testList() {
		List<City> cs = cityDao.list();
		for (City c : cs) {
			System.out.println(c);
		}
	}
}
