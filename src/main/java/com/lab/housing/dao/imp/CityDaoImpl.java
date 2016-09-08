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
		String sql = "INSERT INTO t_city (name, abbr)" + " VALUES (?, ?)";
		jdbcTemplate.update(sql, city.getName(), city.getAbbr());
	}

	@Override
	public void delete(String abbr) {
		String sql = "DELETE FROM t_city WHERE abbr=?";
		jdbcTemplate.update(sql, abbr);
	}

	@Override
	public void upate(City city) {
		String sql = "UPDATE t_city SET name=? WHERE abbr=?";
		jdbcTemplate.update(sql, city.getName(), city.getAbbr());
	}

	@Override
	public City get(String abbr) {
		String sql = "SELECT * FROM t_city WHERE abbr=?";
		return jdbcTemplate.queryForObject(sql, new Object[]{abbr}, new RowMapper<City>() {

			@Override
			public City mapRow(ResultSet rs, int rowNum) throws SQLException {
				City c = new City();
				c.setName(rs.getString("name"));
				c.setAbbr(rs.getString("abbr"));
				return c;
			}});
	}

	@Override
	public List<City> list() {
		String sql = "SELECT * FROM t_city";
		List<City> cities = jdbcTemplate.query(sql, new RowMapper<City>() {

			@Override
			public City mapRow(ResultSet rs, int rowNum) throws SQLException {
				City city = new City();
				city.setName(rs.getString("name"));
				city.setAbbr(rs.getString("abbr"));
				return city;
			}
		});

		return cities;
	}

}
