package com.hy.ssm.api;

import com.alibaba.fastjson.JSON;
import com.hy.ssm.core.controller.BaseController;
import com.hy.ssm.dto.Result;
import com.hy.ssm.service.AddressService;
import com.hy.ssm.vo.AddressVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class AddressAPI extends BaseController {

    @Resource
    private AddressService addressService;

    @GetMapping(value = "/address/list", produces = {"application/json; charset=utf-8"})
    @ResponseBody
    public String addressList() {
        List<AddressVO> addressVOS = addressService.selectAddress();
        return JSON.toJSONString(Result.success(addressVOS));
    }

}
