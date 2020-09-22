package com.hy.ssm.service;

import com.hy.ssm.entity.Staff;
import com.hy.ssm.vo.StaffVO;

import java.util.List;
import java.util.Map;

public interface StaffService {

    /**
     * 查询员工列表
     * @param staff
     * @return
     */
    List<StaffVO> selectStaffList(Staff staff);

    /**
     * 添加员工
     * @param staff
     * @return
     */
    int insertStaff(Staff staff);

    /**
     * 查询员工详情
     * @param staffId
     * @return
     */
    Staff selectStaffById(Long staffId);

    /**
     * 修改员工
     * @param staff
     * @return
     */
    int updateStaff(Staff staff);


    /**
     * 删除员工
     * @param staffId
     * @return
     */
    int deleteStaffById(Long staffId);

}
