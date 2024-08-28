package tool.apache.common;

import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.ImmutableTriple;
import org.junit.jupiter.api.Test;

import java.util.Date;

/**
 * @date 2022/9/26
 */
public class Lang3Test {



    @Test void t1(){
        ImmutablePair<String, String> pair = ImmutablePair.of("a", "b");
        System.out.println(pair);
        pair.getLeft();
        pair.getRight();

        ImmutableTriple<String, Integer, Date> triple = ImmutableTriple.of("name", 18, new Date());
        System.out.println(triple);
        String left = triple.getLeft();
        Integer middle = triple.getMiddle();
        Date right = triple.getRight();

        System.out.println();
    }

    @Test void t2(){
        System.out.println(BooleanUtils.toBoolean("y"));
        System.out.println(BooleanUtils.toBoolean("Y"));
        System.out.println(BooleanUtils.toBooleanObject("null"));
    }
}
