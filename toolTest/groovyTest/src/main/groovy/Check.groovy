/**
 *
 * @date 2023/2/25
 */
static void main(String[] args) {
    println "Hello world!"
    def res = new Check().check(20)
    println res
}

def check(int score) {
    if (0 <= score && score < 10) {
        return "小于10";
    } else if (10 <= score && score < 100) {
        return "大于10";
    } else {
        return "默认";
    }
}
