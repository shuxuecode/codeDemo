package tool.pinyin;

import com.github.promeg.pinyinhelper.Pinyin;
import groovy.util.GroovyTestCase;

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


}
