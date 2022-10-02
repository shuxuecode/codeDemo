package tool.guava;

import com.google.common.collect.HashMultiset;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.junit.jupiter.api.Test;

/**
 * @date 2022/9/26
 */
public class SetsTest {



    @Test void t1(){
        HashMultiset<@Nullable String> multiset = HashMultiset.create();
        multiset.add("a");
        multiset.add("a");
        multiset.add("a");

        for (String key : multiset) {
            System.out.print(key + " : ");
            System.out.println(multiset.count(key));
        }
    }
}
