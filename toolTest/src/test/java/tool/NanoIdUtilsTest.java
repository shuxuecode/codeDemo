package tool;

import com.zsx.tool.NanoIdUtils;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.security.SecureRandom;
import java.util.HashSet;

/**
 * @date 2022/4/26
 */
public class NanoIdUtilsTest {
    @Test
    void t() {
        String str = NanoIdUtils.randomNanoId();
        System.out.println(str);
        System.out.println(str.length());
    }

    @RepeatedTest(value = 10)
    void t1(){
        SecureRandom random = new SecureRandom();
        //char[] alphabet = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        //char[] alphabet = "0123456789abcdefghijklmnopqrstuvwxyz".toCharArray();
        char[] alphabet = "23456789ABCDEFGHJKLMNPQRSTUVWXYZ".toCharArray();
        //char[] alphabet = "-8".toCharArray();

        //0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ
        //0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ

        HashSet<String> set = new HashSet<>();
        int count = 10000000;
        count = 1000;

        for (int i = 0; i < count; i++) {
            String str = NanoIdUtils.randomNanoId(random, alphabet, 16);
            set.add(str);
            //System.out.println(str);
        }

        System.out.println(set.size());



    }
}
