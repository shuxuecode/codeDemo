import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

/**
 * @author
 * @date 2022/4/26
 */
public class UnitTest {

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

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }
    }
}
