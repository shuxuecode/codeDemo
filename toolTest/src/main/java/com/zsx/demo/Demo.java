package com.zsx.demo;

<<<<<<< HEAD
import lombok.Data;

=======
import lombok.Builder;
import lombok.Data;

import java.util.Date;

>>>>>>> 71be69ab5cf45e083419c9e7cae2d1848cbc4e3b
/**
 * @date 2022/8/26
 */
@Data
<<<<<<< HEAD
public class Demo {
=======
@Builder
public class Demo {
    private Integer id;

    private String name;

    private Date date;

    public static void test(){
        Demo build = Demo.builder()
                .id(1)
                .name("")
                .build();
    }
>>>>>>> 71be69ab5cf45e083419c9e7cae2d1848cbc4e3b
}
