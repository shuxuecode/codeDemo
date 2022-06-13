package com.zsx.tool;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author
 * @date 2022/6/13
 */
class GzipUtilTest {

    static String str = "abcdefghijklmnopqrstuvwxyz";

    @BeforeAll
    static void before() {
        str += str;
        str += str;
        str += str;
        str += str;
        str += str;
        str += str;
        str += str;
    }

    @Test
    void compress() {

        String compress = GzipUtil.compress(str);
        System.out.println(compress);


        String uncompress = GzipUtil.uncompress(compress);
        System.out.println(uncompress);

        assert uncompress.equals(str);

    }

    @Test
    void uncompress() {
    }
}