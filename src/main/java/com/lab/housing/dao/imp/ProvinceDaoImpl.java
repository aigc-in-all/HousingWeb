package com.lab.housing.dao.imp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.lab.housing.dao.ProvinceDao;
import com.lab.housing.model.Province;

@Repository("provinceDao")
public class ProvinceDaoImpl implements ProvinceDao {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setJdbcTmplate(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void add(Province province) {
		String sql = "INSERT INTO province (name)" + " VALUES (?)";
		jdbcTemplate.update(sql, province.getName());
	}

	@Override
	public void delete(int id) {
		String sql = "DELETE FROM province WHERE id = ?";
		jdbcTemplate.update(sql, id);
	}

	@Override
	public void update(Province province) {
	}

	@Override
	public Province get(int id) {
		String sql = "SELECT * FROM province WHERE id = ?";
		return jdbcTemplate.queryForObject(sql, new Object[] { id }, new RowMapper<Province>() {

			@Override
			public Province mapRow(ResultSet rs, int rowNum) throws SQLException {
				Province p = new Province();
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				return p;
			}
		});
	}

	@Override
	public List<Province> list() {
		String sql = "SELECT * FROM province";
		return jdbcTemplate.query(sql, new RowMapper<Province>() {

			@Override
			public Province mapRow(ResultSet rs, int rowNum) throws SQLException {
				Province p = new Province();
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				return p;
			}
		});
	}

}
