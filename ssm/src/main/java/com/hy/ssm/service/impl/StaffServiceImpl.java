package com.hy.ssm.service.impl;

import com.hy.ssm.dao.StaffDAO;
import com.hy.ssm.entity.Staff;
import com.hy.ssm.service.StaffService;
import com.hy.ssm.vo.StaffVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StaffServiceImpl implements StaffService {

    @Resource
    private StaffDAO staffDAO;

    @Override
    public List<StaffVO> selectStaffList(Staff staff) {
        return staffDAO.selectStaffList(staff);
    }

    @Override
    public int insertStaff(Staff staff) {
        // 新增用户信息
        int rows = staffDAO.insertStaff(staff);
        return rows;
    }
}
