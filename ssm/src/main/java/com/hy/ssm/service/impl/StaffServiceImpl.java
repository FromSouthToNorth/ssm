package com.hy.ssm.service.impl;

import com.hy.ssm.dao.StaffDAO;
import com.hy.ssm.service.StaffService;
import com.hy.ssm.vo.StaffVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class StaffServiceImpl implements StaffService {

    @Resource
    private StaffDAO staffDAO;

    @Override
    public List<StaffVO> findAll() {
        List<Map<String, Object>> all = staffDAO.findAll();
        List<StaffVO> staffVOS = new ArrayList<>();
        for (Map<String, Object> stringObjectMap : all) {
            StaffVO staffVO = new StaffVO();
            if (stringObjectMap.get("id") != null) {
                staffVO.setId(Long.valueOf(stringObjectMap.get("id").toString()));
            }
            if (stringObjectMap.get("name") != null) {
                staffVO.setName(stringObjectMap.get("name").toString());
            }
            if (stringObjectMap.get("age") != null) {
                staffVO.setAge(Integer.parseInt(stringObjectMap.get("age").toString()));
            }
            if (stringObjectMap.get("sex") != null) {
                staffVO.setSex(stringObjectMap.get("sex").toString());
            }
            if (stringObjectMap.get("province_name") != null) {
                staffVO.setProvinceName(stringObjectMap.get("province_name").toString());
            }
            if (stringObjectMap.get("city_name") != null) {
                staffVO.setCityName(stringObjectMap.get("city_name").toString());
            }
            staffVOS.add(staffVO);
        }
        return staffVOS;
    }
}
