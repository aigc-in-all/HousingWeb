package com.lab.housing.dao;

import java.util.List;

import com.lab.housing.model.City;

public interface CityDao {

    void add(City city);

    void delete(int id);

    void upate(City city);

    City get(int id);

    List<City> list(int provinceId);
}
