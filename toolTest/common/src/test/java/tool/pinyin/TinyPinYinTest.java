package tool.pinyin;

import com.github.promeg.pinyinhelper.Pinyin;
import com.google.common.collect.Lists;
import groovy.util.GroovyTestCase;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

/**
 * @date 2023/3/25
 */
public class TinyPinYinTest extends GroovyTestCase {

    public void test01() {
        String str = "中华人民共和国";
        for (char c : str.toCharArray()) {
            String pinyin = Pinyin.toPinyin(c);
            System.out.println(pinyin);
        }
    }


    public void test中文排序() {
        ArrayList<String> list = Lists.newArrayList("吴", "张", "王", "赵", "闫", "张", "徐");

        Collator collator = Collator.getInstance(Locale.CHINA);

        //List<String> res = list.stream().sorted((a, b) -> collator.compare(a, b)).collect(Collectors.toList());
        //
        //System.out.println(res);

        String[] array = list.toArray(new String[0]);

        Arrays.sort(array, collator);

        Arrays.stream(array).forEach(System.out::println);
    }
}
