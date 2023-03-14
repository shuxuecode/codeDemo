public class ListTest extends GroovyTestCase {

    void test01() {
        def list = [1, 2, 3, 4]
        assert list.get(2) == 3
        assert list[2] == 3
    }

    void test02() {
        def list = [1, 2, 3, 4]
        // 复制
        def newList = new ArrayList<Integer>(list)
        assert newList == list

        def list2 = list.clone()
        assert list2 == list
    }

    void test03() {
        // 元素可以不同类型
        def list = [1, "字符串", new Date(), 'a', null, 9 as byte]

        assert list[-1] == 9 // 允许负数index，从list尾部开始计数，-1开始
    }

    void test04(){
        [1,2,3].each {
            println it // it是对应于当前元素的隐式参数
        }

        [1,2,3,4].eachWithIndex { int it, int i -> // it是当前元素，i是索引位置
            println(i + " : " + it)
        }
//        0 : 1
//        1 : 2
//        2 : 3
//        3 : 4
    }
}

//static void main(String[] args) {
//    def list = [1,2,3,4]
//    assert list.get(2) == 2
//    assert list[2] == 2
//
//}


