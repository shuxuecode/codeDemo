package com.zsx.dto;

/**
 * @author 
 * @date 2023/6/8
 */
public class ParentDTO {


    private Integer id;

    private String name;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "ParentDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
