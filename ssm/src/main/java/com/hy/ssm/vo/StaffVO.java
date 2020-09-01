package com.hy.ssm.vo;

public class StaffVO {

    private Long    id;
    private String  name;
    private Integer age;
    private String  sex;
    private String  provinceName;
    private String  cityName;

    public StaffVO() {
    }

    public StaffVO(Long id, String name, Integer age, String sex, String provinceName, String cityName) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.provinceName = provinceName;
        this.cityName = cityName;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
}
