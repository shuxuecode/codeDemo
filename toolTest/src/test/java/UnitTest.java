import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;
import com.google.common.collect.Lists;
import com.zsx.demo.Demo;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * @author
 * @date 2022/4/26
 */
public class UnitTest {



    @Test void t6(){
        String str = "009121,222,345678";
        System.out.println(str.lastIndexOf(","));
        System.out.println(str.substring(10+1));
    }

    @Test
    void t5() {
        String json = "{\"issue\":\"abc\",\"ext\":{\"outBizId\":\"123\",\"code\":\"world_cup\"},\"count\":11000,\"list\":[{\"a\":\"b\"}]}";

        System.out.println(JSONPath.contains(json, "$['issue']"));

        Object extract = JSONPath.extract(json, "$['issue']");
        System.out.println(extract);

        System.out.println(JSONPath.extract(json, "$['ext']['outBizId']"));

        System.out.println((Integer) JSONPath.extract(json, "$['count']"));
        System.out.println(Long.valueOf(JSONPath.extract(json, "$['count']").toString()));

        System.out.println(JSONPath.extract(json, "$['list'][0]['a']"));
        System.out.println(JSONPath.extract(json, "$['list'][1]['a']"));
    }


    @Test
    void t4() {
        ArrayList<@Nullable Demo> list = Lists.newArrayList();
        list.add(new Demo(2));
        list.add(new Demo(5));
        list.add(new Demo(1));
        list.add(new Demo(4));
        list.add(new Demo(3));

        ArrayList<Demo> resultList = list.stream().map(item -> {
            if (item.getNum() > 3) {
                return null;
            }
            return item;
        }).collect(Collectors.collectingAndThen(
                Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Demo::getNum))), ArrayList::new));

        System.out.println(JSON.toJSONString(resultList));
    }

    @Test
    void t3() {
        Map<String, Object> map = new HashMap<>();

        List<Demo> key = (List<Demo>) map.get("key");
        //List<Demo> key = (List<Demo>) map.getOrDefault("key", new ArrayList<>());

        System.out.println(key);
    }

    @Test
    void t2() {
        String str = (String) null;
        System.out.println(str);

        Date date = new Date();
        System.out.println(date);
        System.out.println(new Date(date.getTime() + 2000));
    }

    @Test
    void t1() {
        Demo demo = new Demo();
        demo.setNum(123);

        String str1 = JSON.toJSONString(demo);
        System.out.println(str1);

        HashMap<String, String> map = new HashMap<>();
        map.put("num", "222");

        String str2 = JSON.toJSONString(map);
        System.out.println(str2);

        Demo demo1 = JSONObject.parseObject(str2, Demo.class);
        String str3 = JSON.toJSONString(demo1);
        System.out.println(str3);

    }

    static class Demo {
        private int num;

        public Demo() {
        }

        public Demo(int num) {
            this.num = num;
        }

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }
    }
}
