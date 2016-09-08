package com.lab.housing.dao;

import java.util.List;

import com.lab.housing.model.City;

public interface CityDao {

	void add(City city);

	void delete(String abbr);

	void upate(City city);

	City get(String abbr);

	List<City> list();
}
