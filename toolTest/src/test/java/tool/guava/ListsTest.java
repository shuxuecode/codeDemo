package tool.guava;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @date 2022/7/26
 */
public class ListsTest {


    @Test
    void t2(){
        ImmutableList<String> list = ImmutableList.of("a", "b");

        ImmutableList<String> build = ImmutableList.<String>builder()
                .add("")
                .add("")
                .build();

        List<String> list1 = new ArrayList<>();
        list1.add("a");
        list1.add("b");
        ImmutableList<String> objects = ImmutableList.copyOf(list1);

        list.add("");
    }

    @Test
    void t1() {
        ArrayList<Demo> list = new ArrayList<>();
        list.add(new Demo(1, "a"));
        list.add(new Demo(2, "b"));
        list.add(new Demo(3, "c"));

        List<Demo> newList = Lists.newArrayList();
        newList = JSONArray.parseArray(JSON.toJSONString(list), Demo.class);

        newList.stream().forEach(item -> {
            if (item.getId() == 2) {
                item.setName("bb");
            }
        });

        System.out.println(JSON.toJSONString(list, true));
    }


    public class Demo {
        private Integer id;
        private String name;

        public Demo(Integer id, String name) {
            this.id = id;
            this.name = name;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
