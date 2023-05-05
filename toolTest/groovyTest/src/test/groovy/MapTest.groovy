import org.junit.Test

/**
 *
 * @date 2023/3/14
 */

public class MapTest extends GroovyTestCase {
//    @Test
//    方法必须以test开头，@Test可以不加
    public void test01() {
        def map = ["a": 1, "b": 2]
        assert ((map instanceof HashMap) == true)
        assert ((map instanceof LinkedHashMap) == true)
    }

    void test02() {
        def a = 'demo'
        def map = [a:1]
        assert map['demo'] == null // 找不到demo
        assert map['a'] == 1       // 因为a是字面值

        map = [(a): 1]          // 将a用()括起来
        assert map['demo'] == 1 // 这样就可以找到demo的值了
    }



}
