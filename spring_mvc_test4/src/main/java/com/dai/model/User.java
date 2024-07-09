package com.dai.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author daihongli
 * @version 1.0
 * @ClassName User
 * @Description: TODO
 * @Date 2024-07-09 20:26
 */
public class User {
    private String username;
    private Integer age;
    private String[] hobbies;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    private Address address;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String[] getHobbies() {
        return hobbies;
    }

    public void setHobbies(String[] hobbies) {
        this.hobbies = hobbies;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
