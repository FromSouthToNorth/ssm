package com.hy.ssm.dao;

import com.hy.ssm.entity.Staff;
import com.hy.ssm.vo.StaffVO;

import java.util.List;
import java.util.Map;

public interface StaffDAO {

    List<StaffVO> selectStaffList(Staff staff);

    int insertStaff(Staff staff);

}
