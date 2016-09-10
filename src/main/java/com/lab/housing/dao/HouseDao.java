package com.lab.housing.dao;

import java.util.List;

import com.lab.housing.model.House;

public interface HouseDao {
    List<House> list(int cityId);
}
