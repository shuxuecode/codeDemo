import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

/**
 * @date 2022/6/20
 */
public class JavaTest1 {

    @Test
    void t1() {
        int num = 3;
        if (!(num == 1 || num == 2)) {
            System.out.println(123);
        }

    }

    @Test
    void t2() {
        System.out.println(Long.MAX_VALUE); // 9223372036854775807  19位
        System.out.println(Integer.MAX_VALUE); // 2147483647  10位
    }

    @Test
    void t3(){
        System.out.println(Double.parseDouble("12.5"));

        BigDecimal bigDecimal = new BigDecimal(Double.parseDouble("12.5")).multiply(BigDecimal.valueOf(100));
        bigDecimal = bigDecimal.setScale(0, BigDecimal.ROUND_HALF_UP);
        int intValue = bigDecimal.intValue();
        System.out.println(intValue);
    }

    @Test void t4(){
        int hashCode = UUID.randomUUID().toString().hashCode();
        if (hashCode<0) {
            hashCode = -hashCode;
        }
        System.out.println(Long.valueOf(hashCode));
        String format = String.format("%015d", hashCode);
        System.out.println(Long.valueOf(format));
    }
}
