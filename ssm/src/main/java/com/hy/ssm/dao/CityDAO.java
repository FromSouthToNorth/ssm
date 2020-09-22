package com.hy.ssm.dao;

import com.hy.ssm.entity.City;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface CityDAO {

    List<City> findAll();

    List<City> findByProvinceId(Long id);

}
