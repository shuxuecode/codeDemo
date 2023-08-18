package jsonpath;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jayway.jsonpath.JsonPath;
import groovy.util.GroovyTestCase;

import java.util.Date;

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


        Object read = JsonPath.read(JSON.toJSONString(str), "$.id");
        System.out.println(read);
    }
}
