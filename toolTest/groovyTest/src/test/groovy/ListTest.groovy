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

    void test04() {
        [1, 2, 3].each {
            println it // it是对应于当前元素的隐式参数
        }

        [1, 2, 3, 4].eachWithIndex { int it, int i -> // it是当前元素，i是索引位置
            println(i + " : " + it)
        }
//        0 : 1
//        1 : 2
//        2 : 3
//        3 : 4
    }

    void test05() {
        // 过滤和搜索
        assert [1, 2, 3].find { it > 1 } == 2 // 找到第一个符合条件的元素
        assert [1, 2, 3].findAll { it > 1 } == [2, 3] // 找到所有符合条件的元素

        assert [1, 2, 3].every { it < 5 }               // 如果每一个元素都符合条件则返回true
        assert ![1, 2, 3].every { it < 3 }
        assert [1, 2, 3].any { it > 2 }                 // 如果有一个元素符合条件就返回true
        assert ![1, 2, 3].any { it > 3 }

        assert [1, 2, 3, 4, 5, 6].sum() == 21                // 所有元素求和
        assert ['a', 'b', 'c', 'd', 'e'].sum {
            it == 'a' ? 1 : it == 'b' ? 2 : it == 'c' ? 3 : it == 'd' ? 4 : it == 'e' ? 5 : 0
            // 求和的时候可以自定义元素的值
        } == 15
        assert ['a', 'b', 'c', 'd', 'e'].sum { ((char) it) - ((char) 'a') } == 10
        assert ['a', 'b', 'c', 'd', 'e'].sum() == 'abcde'
        assert [['a', 'b'], ['c', 'd']].sum() == ['a', 'b', 'c', 'd']

        assert [1, 2, 3].sum(1000) == 1006

        assert [1, 2, 3].join('-') == '1-2-3'           // 每个元素之间添加字符串
    }

    void test06() {
        // 最大值，最小值
        assert [1, 2, 3, 4].max() == 4
        assert [1, 2, 3, 4].min() == 1

        // 单字符的list也可以查找最大值和最小值
        assert ['x', 'y', 'a', 'z'].min() == 'a'

        // 我们可以用Closure闭包来描述元素的大小
        def list2 = ['abc', 'z', 'xyzuvw', 'Hello', '321']
        assert list2.max { it.size() } == 'xyzuvw'
        assert list2.min { it.size() } == 'z'
    }

    void test07() {
//        使用Comparator来定义比较条件
        Comparator mc = { a, b -> a == b ? 0 : (a < b ? -1 : 1) }

        def list = [7, 4, 9, -6, -1, 11, 2, 3, -9, 5, -13]
        assert list.max(mc) == 11
        assert list.min(mc) == -13

        Comparator mc2 = { a, b -> a == b ? 0 : (Math.abs(a) < Math.abs(b)) ? -1 : 1 }

        assert list.max(mc2) == -13
        assert list.min(mc2) == -1

        assert list.max { a, b -> a.equals(b) ? 0 : Math.abs(a) < Math.abs(b) ? -1 : 1 } == -13
        assert list.min { a, b -> a.equals(b) ? 0 : Math.abs(a) < Math.abs(b) ? -1 : 1 } == -1

    }

    void test09() {
//        使用<<为List添加项目
        def list = []
        assert list.empty

        list << 5
        assert list.size() == 1

        list << 7 << 'i' << 11
        assert list == [5, 7, 'i', 11]

        list << ['m', 'o']
        assert list == [5, 7, 'i', 11, ['m', 'o']]

//在<<表达式最前端的list是目标list
        assert ([1, 2] << 3 << [4, 5] << 6) == [1, 2, 3, [4, 5], 6]

//使用leftShift方法等价于使用 <<
        assert ([1, 2, 3] << 4) == ([1, 2, 3].leftShift(4))

    }


}

//static void main(String[] args) {
//    def list = [1,2,3,4]
//    assert list.get(2) == 2
//    assert list[2] == 2
//
//}


