package com.lab.housing.dao.imp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.lab.housing.dao.ProvinceDao;
import com.lab.housing.model.Province;
import com.lab.housing.util.Pinyin4jUtil;

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
        List<Province> ps = jdbcTemplate.query(sql, new RowMapper<Province>() {

            @Override
            public Province mapRow(ResultSet rs, int rowNum) throws SQLException {
                Province p = new Province();
                p.setId(rs.getInt("id"));
                p.setName(rs.getString("name"));
                return p;
            }
        });
        Collections.sort(ps, new Comparator<Province>() {
            @Override
            public int compare(Province o1, Province o2) {
                String s1 = Pinyin4jUtil.toPinyinAtFirstWord(o1.getName());
                String s2 = Pinyin4jUtil.toPinyinAtFirstWord(o2.getName());
                return s1.compareTo(s2);
            }
        });
        return ps;
    }

}
