package com.zsx.dto;

import java.util.Date;

/**
 * @author 
 * @date 2023/6/8
 */
public class ChildrenDTO extends ParentDTO {

    private int age = 18;

    private String gender;

    private Date birthday;


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }


    @Override
    public String toString() {
        return "ChildrenDTO{" +
                "age=" + age +
                ", gender='" + gender + '\'' +
                ", birthday=" + birthday +
                "} " + super.toString();
    }
}
