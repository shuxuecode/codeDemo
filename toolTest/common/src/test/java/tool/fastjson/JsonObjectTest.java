package tool.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import groovy.util.GroovyTestCase;
import org.apache.commons.lang3.ObjectUtils;
import tool.fastjson.model.Children;

/**
 * @date 2023/6/15
 */
public class JsonObjectTest extends GroovyTestCase {


    public void test01() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("a", 123);


        Object b = jsonObject.get("b");
        System.out.println(b);

        Object c = ObjectUtils.defaultIfNull(b, "");
        System.out.println(c);

    }


    public void test02() {
        Children children = new Children();
        children.setId(1);
        children.setName("a");

        JSONObject jsonObject = JSONObject.parseObject(JSON.toJSONString(children));

        System.out.println(jsonObject.toJSONString());
    }


}
