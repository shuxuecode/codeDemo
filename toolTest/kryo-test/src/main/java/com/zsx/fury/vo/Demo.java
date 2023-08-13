package com.zsx.fury.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Demo {

    private Integer id;

    private String name;

    private Date birthday;


}
