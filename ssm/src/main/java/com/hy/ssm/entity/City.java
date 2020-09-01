package com.hy.ssm.entity;

/**
 * 市
 */
public class City {

    private Long    id;
    private String  name;
    private Long    provinceId;

    public City() {
    }

    public City(Long id, String name, Long provinceId) {
        this.id = id;
        this.name = name;
        this.provinceId = provinceId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Long provinceId) {
        this.provinceId = provinceId;
    }

}
