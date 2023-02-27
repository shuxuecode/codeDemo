/**
 *
 * @author shuxuezhao.zsx
 * @date 2023/2/27
 */
static void main(String[] args) {
    println "Hello world!"

    // 变量
    String str = ""
    def str2 = ""
    var str3 = ""


// 单引号，不支持值替换
    def a1 = 'aaa'

// 双引号，支持值替换
    def a2 = "hello ${name}"

// 三引号，是多行的
    def a3 = ''' a b c 
123
!@#
'''
}

def Study() {
// 列表 List
    def numbers = [1, 2, 3]
    assert numbers instanceof java.util.List
    assert numbers.size() == 3

    def list = [1, "1", true]

// 指定列表类型
    def linkedlist = [1, 2, 3] as LinkedList

// 数组
    String[] array1 = ['a', 'b', 'c']
    assert array1[0] == 'a'
}


def Maps() {
    // 定义并初始化
    def map = [a: 1, b: 2, c: 3]

    assert map['a'] == 1  // 根据key取值
    assert map.a == 1     // 根据属性取值

    // 赋值
    map['b'] = 5
    map.c = 6

}

def 运算符() {
    // java
    if (a != null) {
        if (a.getB() != null) {
            return a.getB().getC();
        }
    }
    // groovy 写法，?.操作符只有在引用不为null时才会调用指定的方法或属性，如果有一个为null则直接返回null
    a?.b?.c
}