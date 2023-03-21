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

    @org.junit.jupiter.api.Test
    void t2() {
        String json = "{\"a\":\"a\",\"b\":\"b\",\"c\":\"c\"}";
        System.out.println(JSON.toJSONString(json));


        System.out.println(JSON.parseObject(json, JsonDemo.class));
        System.out.println(JSON.parseObject(JSON.toJSONString(json), JsonDemo.class));
    }

    static class JsonDemo {
        private String a;
        private String b;

        public String getA() {
            return a;
        }

        public void setA(String a) {
            this.a = a;
        }

        public String getB() {
            return b;
        }

        public void setB(String b) {
            this.b = b;
        }
    }

}
