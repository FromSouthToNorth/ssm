package com.hy.ssm.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface CityDAO {

    List<Map<String, Object>> findAll();

    List<Map<String, Object>> findByProvinceId(@Param("id") Long id);

}
