package com.hy.ssm.service.impl;

import com.hy.ssm.dao.StaffDAO;
import com.hy.ssm.entity.Staff;
import com.hy.ssm.service.StaffService;
import com.hy.ssm.vo.StaffVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional
    public int insertStaff(Staff staff) {
        // 新增用户信息
        int rows = staffDAO.insertStaff(staff);
        return rows;
    }

    @Override
    public Staff selectStaffById(Long staffId) {
        return staffDAO.selectStaffById(staffId);
    }

    @Override
    @Transactional
    public int updateStaff(Staff staff) {
        return staffDAO.updateStaff(staff);
    }

    @Override
    @Transactional
    public int deleteStaffById(Long staffId) {
        return staffDAO.deleteStaffById(staffId);
    }
}
