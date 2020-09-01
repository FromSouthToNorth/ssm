package com.hy.ssm.dao;

import com.hy.ssm.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

public class ProvinceDAOTest extends BaseTest {

    @Autowired
    private ProvinceDAO provinceDAO;

    @Test
    public void findAll() {
        for (Map<String, Object> stringObjectMap : provinceDAO.findAll()) {
            System.out.println(stringObjectMap);
        }
    }

}
