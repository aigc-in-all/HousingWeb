package com.lab.housing.dao;

import java.util.List;

import com.lab.housing.model.Province;

public interface ProvinceDao {
	void add(Province province);

	void delete(int id);

	void update(Province province);

	Province get(int id);

	List<Province> list();
}
