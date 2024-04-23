package com.zsx.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

/**
 * @author shuxuecode
 * @date 2024/4/23
 */
@Data
@Builder
public class Demo {

    private Long id;

    private String name;

    private Date birthday;


}
