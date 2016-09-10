package com.lab.housing.dao.imp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.lab.housing.dao.CityDao;
import com.lab.housing.model.City;

@Repository("cityDao")
public class CityDaoImpl implements CityDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public CityDaoImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void add(City city) {
        String sql = "INSERT INTO city (name, abbr)" + " VALUES (?, ?)";
        jdbcTemplate.update(sql, city.getName(), city.getAbbr());
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM city WHERE id=?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public void upate(City city) {
        String sql = "UPDATE city SET name=? WHERE abbr=?";
        jdbcTemplate.update(sql, city.getName(), city.getAbbr());
    }

    @Override
    public City get(int id) {
        String sql = "SELECT * FROM city WHERE id=?";
        return jdbcTemplate.queryForObject(sql, new Object[] { id }, new RowMapper<City>() {

            @Override
            public City mapRow(ResultSet rs, int rowNum) throws SQLException {
                City c = new City();
                c.setId(rs.getInt("id"));
                c.setName(rs.getString("name"));
                c.setAbbr(rs.getString("abbr"));
                c.setProvinceId(rs.getInt("p_id"));
                return c;
            }
        });
    }

    @Override
    public List<City> list(int provinceId) {
        String sql = "SELECT * FROM city where p_id = " + provinceId;
        List<City> cities = jdbcTemplate.query(sql, new RowMapper<City>() {

            @Override
            public City mapRow(ResultSet rs, int rowNum) throws SQLException {
                City c = new City();
                c.setId(rs.getInt("id"));
                c.setName(rs.getString("name"));
                c.setAbbr(rs.getString("abbr"));
                c.setProvinceId(rs.getInt("p_id"));
                return c;
            }
        });

        return cities;
    }

}
