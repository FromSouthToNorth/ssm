package com.hy.ssm.dao;

import com.hy.ssm.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

public class StaffDAOTest extends BaseTest {

    @Autowired
    private StaffDAO staffDAO;

    @Test
    public void findAll() {
        for (Map<String, Object> stringObjectMap : staffDAO.findAll()) {
            System.out.println(stringObjectMap);
        }
    }

}
