package tool.fastjson.model;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @date 2022/6/17
 */
public class Test {


    @org.junit.jupiter.api.Test
    void t1() {
        Parent parent = new Parent();
        parent.setId(1);
        parent.setName("parent");

        Children children = new Children();
        children.setId(2);
        children.setName("child");

        List<Children> childrenList = new ArrayList<>();
        childrenList.add(children);

        //parent.setChildren(childrenList);

        Map<String, String> map = JSON.parseObject(JSON.toJSONString(parent), new TypeReference<Map<String, String>>() {
        });

        //map.remove("children");

        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }

        System.out.println(JSON.toJSONString(map));
    }

}
