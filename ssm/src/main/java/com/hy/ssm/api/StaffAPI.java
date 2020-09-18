package com.hy.ssm.api;

import com.alibaba.fastjson.JSON;
import com.hy.ssm.core.controller.BaseController;
import com.hy.ssm.entity.Staff;
import com.hy.ssm.service.StaffService;
import com.hy.ssm.vo.StaffVO;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


@RestController
public class StaffAPI extends BaseController {

    @Resource
    private StaffService staffService;

    @GetMapping(value = "/staff/list", produces = {"application/json; charset=utf-8"})
    @ResponseBody
    public String getAllStaff(Staff staff) {
        starPage();
        List<StaffVO> all = staffService.selectStaffList(staff);
        return JSON.toJSONString(getDataTable(all));
    }

}
