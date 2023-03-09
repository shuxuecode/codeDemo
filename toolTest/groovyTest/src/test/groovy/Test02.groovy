// 导包，别名导入

import com.alibaba.fastjson.JSON

import java.util.Date as MyDate


static void main(String[] args) {

    def user = new User();
//    user.name = "abc"
    user.@name = "abc"  // todo zsx

    println(user)
    println(user.name)

    println(new MyDate())

    String str = "{\"1\": {\"2\": \"3\", \"4\": \"5\"}, \"6\": {\"7\": \"8\", \"9\": \"0\"}, \"a\": \"b\"}"

    def map = com.alibaba.fastjson.JSON.parseObject(str, HashMap.class)

    println map["1"]["4"]
    println map["a"]
}


class User {
    private String name

// 可以不写get set

//    String getName() {
//        return name
//    }
//
//    void setName(String name) {
//        this.name = name
//    }
}