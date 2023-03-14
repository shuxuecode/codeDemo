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




}
