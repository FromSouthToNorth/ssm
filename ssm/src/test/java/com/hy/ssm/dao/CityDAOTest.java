package com.hy.ssm.dao;

import com.hy.ssm.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

public class CityDAOTest extends BaseTest {

    @Autowired
    private CityDAO cityDAO;

    @Test
    public void findAll() {
        for (Map<String, Object> stringObjectMap : cityDAO.findAll()) {
            System.out.println(stringObjectMap);
        }
    }

    @Test
    public void findByProvinceId() {
        Long provinceId = 1L;
        List<Map<String, Object>> byProvinceId = cityDAO.findByProvinceId(provinceId);
        for (Map<String, Object> stringObjectMap : byProvinceId) {
            System.out.println(stringObjectMap);
        }
    }

}
