package com.hy.ssm.api;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hy.ssm.dto.Result;
import com.hy.ssm.enums.ResultEnums;
import com.hy.ssm.service.StaffService;
import com.hy.ssm.vo.StaffVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;


@Controller
public class StaffAPI {

    @Resource
    private StaffService staffService;

    @RequestMapping(value = "/getall", method = RequestMethod.GET, produces = {"application/json; charset=utf-8"})
    @ResponseBody
    public String getAllStaff(@RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum) {
        PageHelper.startPage(pageNum, 5);
        List<StaffVO> all = staffService.findAll();
        PageInfo<StaffVO> staffVOPageInfo = new PageInfo<>(all, 4);
        Result result = new Result(ResultEnums.SUCCESS, staffVOPageInfo);
        return JSON.toJSONString(result);
    }


}
