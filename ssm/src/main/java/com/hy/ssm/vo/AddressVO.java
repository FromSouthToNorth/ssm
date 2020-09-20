package com.hy.ssm.vo;

import com.hy.ssm.entity.City;
import com.hy.ssm.entity.Province;

import java.util.List;

public class AddressVO {

    private Province province;

    private List<City> cities;

    public AddressVO() {
    }

    public AddressVO(Province province, List<City> cities) {
        this.province = province;
        this.cities = cities;
    }

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }
}
