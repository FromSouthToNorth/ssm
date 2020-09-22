package com.hy.ssm.service;

import com.hy.ssm.vo.AddressVO;

import java.util.List;

public interface AddressService {

    /**
     * 查询地址
     * @return
     */
    List<AddressVO> selectAddress();

}
