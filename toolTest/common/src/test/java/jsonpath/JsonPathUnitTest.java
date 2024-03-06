package jsonpath;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;
import com.google.common.collect.Lists;
import com.jayway.jsonpath.JsonPath;
import groovy.util.GroovyTestCase;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * @date 2023/5/19
 */
public class JsonPathUnitTest extends GroovyTestCase {

    public void test01() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("a", 1);

        Object read = JsonPath.read(jsonObject.toJSONString(), "$.a");
        System.out.println(read);
    }

    public void test02() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("a", 1);

        String str = "{\"ext\":{\"test\":\"true\"},\"id\":123,\"name\":\"demo\"}";


        //Object read = JsonPath.read(JSON.toJSONString(str), "$.id");
        Object read = JsonPath.read(str, "$.id");
        System.out.println(read);
    }

    public void test03() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("a", 1);
        jsonObject.put("b", 2);
        jsonObject.put("c", 3);

        Collection<String> set = (Collection<String>) JSONPath.eval(jsonObject, "$.keySet()");

        set.stream().forEach(System.out::println);

    }

    public void test04() {
        JSONObject jsonObject1 = new JSONObject();
        jsonObject1.put("a", 1);

        JSONObject jsonObject2 = new JSONObject();
        jsonObject2.put("a", 2);

        JSONObject jsonObject3 = new JSONObject();
        jsonObject3.put("a", 3);

        JSONArray jsonArray = new JSONArray();
        jsonArray.add(jsonObject1);
        jsonArray.add(jsonObject2);
        jsonArray.add(jsonObject3);

        System.out.println(jsonArray.toJSONString());

        System.out.println(JSONPath.eval(jsonArray, "$[1]"));
        System.out.println(JSONPath.eval(jsonArray, "$[1].a"));
        System.out.println(JSONPath.eval(jsonArray, "$[1].b"));
    }


    public void test05() {

        TT tt = new TT();
        tt.name = "test";
        tt.list = Lists.newArrayList("\"1\"", "2", "3");

        System.out.println(JSON.toJSONString(tt));


        String json = "{\"list\":\"[\"1\"]\",\"name\":\"test\"}";

        TT ttt = JSONObject.parseObject(json, TT.class);
        System.out.println(JSON.toJSONString(ttt));


    }

    public static class TT {
        public String name;
        public List<String> list;
    }
}
