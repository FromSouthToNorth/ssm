package com.hy.ssm.service;

import com.hy.ssm.entity.Staff;
import com.hy.ssm.vo.StaffVO;

import java.util.List;
import java.util.Map;

public interface StaffService {

    List<StaffVO> selectStaffList(Staff staff);

    int insertStaff(Staff staff);

}
