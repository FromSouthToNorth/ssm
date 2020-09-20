package com.hy.ssm.service.impl;

import com.hy.ssm.dao.CityDAO;
import com.hy.ssm.dao.ProvinceDAO;
import com.hy.ssm.entity.Province;
import com.hy.ssm.service.AddressService;
import com.hy.ssm.vo.AddressVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    @Resource
    private CityDAO cityDAO;

    @Resource
    private ProvinceDAO provinceDAO;

    @Override
    public List<AddressVO> selectAddress() {

        AddressVO addressVO = new AddressVO();
        List<AddressVO> addressVOS = new ArrayList<>();
        List<Province> all = provinceDAO.findAll();
        for (Province province : all) {
            addressVO.setProvince(province);
            addressVO.setCities(cityDAO.findByProvinceId(province.getId()));
            addressVOS.add(addressVO);
        }
        return addressVOS;
    }
}
