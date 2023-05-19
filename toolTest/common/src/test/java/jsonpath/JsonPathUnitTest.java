package jsonpath;

import com.alibaba.fastjson.JSONObject;
import com.jayway.jsonpath.JsonPath;
import groovy.util.GroovyTestCase;

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


}
