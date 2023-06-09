package com.test;

import com.zsx.dto.ChildrenDTO;
import com.zsx.dto.ParentDTO;
import com.zsx.dto.WorkerDTO;
import org.junit.jupiter.api.Test;

import java.util.Date;

/**
 * @author 
 * @date 2023/6/8
 */
public class DtoTest {


    @Test
    void t1() {
        ParentDTO parentDTO = null;

        ChildrenDTO childrenDTO = new ChildrenDTO();
        childrenDTO.setId(1);
        childrenDTO.setName("a");
        childrenDTO.setAge(30);
        childrenDTO.setGender("f");
        childrenDTO.setBirthday(new Date());

        WorkerDTO workerDTO = new WorkerDTO();
        workerDTO.setId(2);
        workerDTO.setName("b");
        workerDTO.setTitle("title");

        ParentDTO parentDTO1 = childrenDTO;

        System.out.println(parentDTO1);

        ChildrenDTO childrenDTO1 = (ChildrenDTO) parentDTO1;

        System.out.println(childrenDTO1);




    }

}
