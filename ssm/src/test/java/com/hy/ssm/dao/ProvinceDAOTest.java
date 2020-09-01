package com.hy.ssm.dao;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hy.ssm.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

public class ProvinceDAOTest extends BaseTest {

    @Autowired
    private ProvinceDAO provinceDAO;

    @Test
    public void findAll() {
        PageHelper.startPage(1, 2);
        List<Map<String, Object>> all = provinceDAO.findAll();
        PageInfo<Map<String, Object>> mapPageInfo = new PageInfo<>(all);
        System.out.println(mapPageInfo);
    }

}
