package com.lab.housing.dao.imp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.lab.housing.dao.HouseDao;
import com.lab.housing.model.House;

@Repository("houseDao")
public class HouseDaoImpl implements HouseDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<House> list(int cityId) {
        String sql = "SELECT * FROM house WHERE c_id=?";
        List<House> list = jdbcTemplate.query(sql, new Object[] { cityId }, new RowMapper<House>() {

            @Override
            public House mapRow(ResultSet rs, int rowNum) throws SQLException {
                House house = new House();
                house.setId(rs.getInt("id"));
                house.setBuildName(rs.getString("build_name"));
                house.setBuildRegion(rs.getString("build_region"));
                house.setHouseType(rs.getString("house_type"));
                house.setHouseArea(rs.getString("house_area"));
                house.setHouseFloor(rs.getString("house_floor"));
                house.setRentType(rs.getString("rent_type"));
                house.setRentRoom(rs.getString("rent_room"));
                house.setRentPrice(rs.getFloat("rent_price"));
                house.setImg(rs.getString("img"));
                house.setUrl(rs.getString("url"));
                house.setCityId(rs.getInt("c_id"));
                return house;
            }
        });
        return list;
    }

}
