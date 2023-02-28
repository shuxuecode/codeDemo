// 导包，别名导入
import java.util.Date as MyDate


static void main(String[] args) {

    def user = new User();
//    user.name = "abc"
    user.@name = "abc"  // todo zsx

    println(user)
    println(user.name)

    println(new MyDate())
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