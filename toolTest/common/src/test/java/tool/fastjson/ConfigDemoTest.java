package tool.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.junit.jupiter.api.Test;
import tool.fastjson.model.ConfigDemo;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @date 2022/6/30
 */
class ConfigDemoTest {

    @Test
    void t1(){
        ConfigDemo config = new ConfigDemo();
        config.setId(1);
        config.setCode("test");

        ConfigDemo configDemo = JSONObject.parseObject("{\"code\":\"test\",\"id\":1}", ConfigDemo.class);

        System.out.println(JSON.toJSONString(configDemo));
    }

}