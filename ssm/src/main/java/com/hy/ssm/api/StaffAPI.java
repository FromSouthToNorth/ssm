package com.hy.ssm.api;

import com.hy.ssm.core.controller.BaseController;
import com.hy.ssm.core.page.TableDataInfo;
import com.hy.ssm.dto.Result;
import com.hy.ssm.entity.Staff;
import com.hy.ssm.service.StaffService;
import com.hy.ssm.utils.StringUtils;
import com.hy.ssm.vo.StaffVO;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


@RestController
@RequestMapping("/staff")
public class StaffAPI extends BaseController {

    @Resource
    private StaffService staffService;

    /**
     * 获取员工列表
     */
    @GetMapping(value = "/list")
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
    @PostMapping
    @ResponseBody
    public Result add(@Validated @RequestBody Staff staff) {
        return toAjax(staffService.insertStaff(staff));
    }

    /**
     * 根据员工编号获取详情
     */
    @GetMapping(value = { "/", "/{staffId}" })
    @ResponseBody
    public Result getInfo(@PathVariable(value = "staffId", required = false) Long staffId) {
        Result result = Result.success();
        if (StringUtils.isNotNull(staffId)) {
            result.put(Result.DATA_TAG, staffService.selectStaffById(staffId));
        }
        return result;
    }

    /**
     * 修改用户
     */
    @PutMapping
    @ResponseBody
    public Result edit(@Validated @RequestBody Staff staff) {
        System.out.println(staff);
        return toAjax(staffService.updateStaff(staff));
    }

    /**
     * 删除用户
     */
    @DeleteMapping("/{staffId}")
    @ResponseBody
    public Result delete(@PathVariable Long staffId) {
        return toAjax(staffService.deleteStaffById(staffId));
    }

}
