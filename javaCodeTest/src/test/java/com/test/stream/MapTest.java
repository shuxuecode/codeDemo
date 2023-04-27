package com.test.stream;

import java.util.HashMap;
import java.util.Map;

/**
 * @date 2023/4/27
 */
public class MapTest {


    public static void main(String[] args) {
        Demo demo = new Demo();
        System.out.println(demo);
        Map<String, String> map = demo.getMap();
        System.out.println(map);

        setMap(map);

        System.out.println(map);
        System.out.println(demo.getMap());
    }


    public static void setMap(Map<String, String> map) {
        map.put("a", "1");
    }


    static class Demo {
        private Map<String, String> map = new HashMap<>();

        public Map<String, String> getMap() {
            return map;
        }

        public void setMap(Map<String, String> map) {
            this.map = map;
        }
    }

}
