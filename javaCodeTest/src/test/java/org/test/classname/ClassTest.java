package org.test.classname;

import org.junit.jupiter.api.Test;
import org.test.classname.po.Parent;
import org.test.classname.po.Sub;

/**
 * @date 2022/4/7
 */
public class ClassTest {


    public Parent get(){
        Sub sub = new Sub();
        sub.setName("a");
        sub.setNum(123);

        sub.setTestName("abc");

        return sub;
    }

    @Test void t1(){
        Parent parent = get();
        System.out.println(parent.getName());
    }

}
