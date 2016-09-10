package com.lab.housing.test;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lab.housing.dao.ProvinceDao;
import com.lab.housing.model.Province;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/springmvc.xml")
public class ProvinceDaoTest {

    @Resource
    ProvinceDao provinceDao;

    @Test
    public void testGet() {
        Province p = provinceDao.get(1);
        System.out.println("---->" + p);
    }

    @Test
    public void testList() {
        List<Province> ps = provinceDao.list();
        for (Province p : ps) {
            System.out.println(p);
        }
    }
}
