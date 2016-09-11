package com.lab.housing.dao;

import java.util.List;

import com.lab.housing.model.House;

public interface HouseDao {

    static final int PAGE_SIZE = 40;

    int count();
    List<House> list(int cityId, int page);
}
