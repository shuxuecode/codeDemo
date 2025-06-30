import org.junit.jupiter.api.Test;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;

import java.util.Collections;
import java.util.List;

/**
 * @author shuxuecode
 * @date 2024/3/19
 */
public class SpringUtilTest {


    @Test
    public void test() {

        String abc = StringUtils.capitalize("abc");
        System.out.println(abc);

        String delete = StringUtils.delete("abc", "a");
        System.out.println(delete);

    }


    @Test
    public void test1() {
        String s = "123";
        String md5DigestAsHex = DigestUtils.md5DigestAsHex(s.getBytes());
        System.out.println(md5DigestAsHex);
    }


    @Test
    public void test2() {
        // 判断字符串是否为空
        String emptyStr = "";
        String nonEmptyStr = "hello";

        System.out.println("isEmpty(emptyStr): " + StringUtils.isEmpty(emptyStr)); // true
        //System.out.println("isNotEmpty(nonEmptyStr): " + StringUtils.isNotEmpty(nonEmptyStr)); // true

        System.out.println("hasLength(emptyStr): " + StringUtils.hasLength(emptyStr)); // false
        System.out.println("hasText(nonEmptyStr): " + StringUtils.hasText(nonEmptyStr)); // true

        // 字符串替换
        String originalStr = "hello world";
        System.out.println("replace('world', 'Java'): " + StringUtils.replace(originalStr, "world", "Java")); // hello Java

        // 截取字符串
        System.out.println("substringBefore(' ', originalStr): " + org.apache.commons.lang3.StringUtils.substringBefore(originalStr, " ")); // hello
        System.out.println("substringAfter(' ', originalStr): " + org.apache.commons.lang3.StringUtils.substringAfter(originalStr, " ")); // world

        // 字符串拼接
        List<String> list = Collections.singletonList("item1");
        System.out.println("collectionToDelimitedString(list, ','): " + StringUtils.collectionToDelimitedString(list, ",")); // item1

        String[] array = {"a", "b", "c"};
        System.out.println("arrayToCommaDelimitedString(array): " + StringUtils.arrayToCommaDelimitedString(array)); // a,b,c

        // 其他操作
        System.out.println("capitalize(nonEmptyStr): " + StringUtils.capitalize(nonEmptyStr)); // Hello
        System.out.println("uncapitalize(nonEmptyStr): " + StringUtils.uncapitalize(nonEmptyStr)); // hELLO

        System.out.println("strip('  hello  '): " + org.apache.commons.lang3.StringUtils.strip("  hello  ")); // hello
        System.out.println("stripStart('abc', 'ab'): " + org.apache.commons.lang3.StringUtils.stripStart("abc", "ab")); // c
        System.out.println("stripEnd('abc', 'bc'): " + org.apache.commons.lang3.StringUtils.stripEnd("abc", "bc")); // a

        // todo zsx
    }


}
