package com.hy.ssm.entity;

/**
 * 员工
 */
public class Staff {

    private Long    id;
    private String  name;
    private Integer age;
    private String  sex;
    private String  avatar;
    private Long    provinceId;
    private Long    cityId;

    public Staff() {
    }

    public Staff(Long id, String name, Integer age, String sex, String avatar, Long provinceId, Long cityId) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.avatar = avatar;
        this.provinceId = provinceId;
        this.cityId = cityId;
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

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Long getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Long provinceId) {
        this.provinceId = provinceId;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

}
