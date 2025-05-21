package tool.guava;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Table;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @date 2022/9/25
 */
public class MapsTest {


    @Test void t5(){

        Map<String, String> map = new HashMap<>();
        map.put("a", "1");

        HashMap<String, String> newMap = Maps.newHashMap(map);

        System.out.println(newMap);
        System.out.println();
        map.put("b", "2");

        System.out.println(map);
        System.out.println(newMap);

        System.out.println();

        newMap.put("c", "3");

        System.out.println(map);
        System.out.println(newMap);


        HashMap< Object,  Object> objectObjectHashMap = Maps.newHashMap();
        objectObjectHashMap.put("666", null);

        System.out.println(JSON.toJSONString(objectObjectHashMap));

    }
    @Test void t4(){
        ImmutableMap<String, String> map = ImmutableMap.of("a", "b23");
        System.out.println(JSON.toJSONString(map));

        Map<String, String> map2 = ImmutableMap.of("a", "b23");
        System.out.println(JSON.toJSONString(map2));
        map2.put("bb", "b23");  // 报错 java.lang.UnsupportedOperationException
        System.out.println(JSON.toJSONString(map2));
    }

    @Test void t3(){
        BiMap< String,  String> biMap = HashBiMap.create();
        biMap.put("a", "1");

        System.out.println(biMap.get("a"));

        BiMap<String, String> inverse = biMap.inverse();

        System.out.println(biMap);
        System.out.println(inverse);
    }

    @Test void t2(){
        // 二维数组
        /*
        table | a  | b  | c  | d
        ------|-------------------
            1 | a1 | b1 | c1 | d1
            2 | a2 | b2 | c2 | d2
            3 | a3 | b3 | c3 | d3
         */

        Table<String, String, String> table = HashBasedTable.create();
        table.put("1", "a", "a1");
        table.put("1", "b", "b1");
        table.put("1", "c", "c1");

        table.put("2", "a", "a2");
        table.put("2", "b", "b2");
        table.put("2", "c", "c2");

        System.out.println(table.get("1", "a"));

        System.out.println(table.row("1"));
        System.out.println(table.column("b"));

        Map<String, Map<String, String>> rowMap = table.rowMap();
        for (Map.Entry<String, Map<String, String>> entry : rowMap.entrySet()) {
            System.out.println();
            System.out.print(entry.getKey());
            System.out.print(" : ");
            System.out.println(entry.getValue());
        }

    }

    @Test
    void t1() {
        Multimap<String, String> multimap = ArrayListMultimap.create();
        multimap.put("a", "1");
        multimap.put("a", "2");
        multimap.put("a", "3");

        Collection<String> values = multimap.get("a"); // [1, 2, 3]
        System.out.println(values);

        Map<String, List<String>> stringListHashMap = Maps.newHashMap();
        if (stringListHashMap.get("key") == null) {
            stringListHashMap.put("key", new ArrayList<>());
        }
        stringListHashMap.get("key").add("element");

        List<String> list = stringListHashMap.get("key");


    }

}
