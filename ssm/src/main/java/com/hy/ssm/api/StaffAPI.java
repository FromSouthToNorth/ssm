package com.hy.ssm.api;

import com.hy.ssm.core.controller.BaseController;
import com.hy.ssm.core.page.TableDataInfo;
import com.hy.ssm.dto.Result;
import com.hy.ssm.entity.Staff;
import com.hy.ssm.service.StaffService;
import com.hy.ssm.vo.StaffVO;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


@RestController
public class StaffAPI extends BaseController {

    @Resource
    private StaffService staffService;

    /**
     * 获取员工列表
     */
    @GetMapping(value = "/staff/list")
    @ResponseBody
    public TableDataInfo getAllStaff(Staff staff) {
        // 封装分页请求数据
        starPage();
        List<StaffVO> all = staffService.selectStaffList(staff);
        return getDataTable(all);
    }

    /**
     * 新增员工
     */
    @PostMapping(value = "/staff")
    @ResponseBody
    public Result add(@Validated @RequestBody Staff staff) {
        System.out.println(staff);
        return toAjax(staffService.insertStaff(staff));
    }

}
