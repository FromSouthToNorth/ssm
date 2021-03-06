package com.hy.ssm.api;

import com.hy.ssm.core.controller.BaseController;
import com.hy.ssm.dto.Result;
import com.hy.ssm.service.AddressService;
import com.hy.ssm.vo.AddressVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressAPI extends BaseController {

    @Resource
    private AddressService addressService;

    /**
     * 查询地址列表
     */
    @GetMapping("/list")
    @ResponseBody
    public Result addressList() {
        List<AddressVO> addressVOS = addressService.selectAddress();
        return Result.success(addressVOS);
    }

}
