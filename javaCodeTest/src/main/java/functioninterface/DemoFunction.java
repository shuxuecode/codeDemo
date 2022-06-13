package functioninterface;

/**
 * 函数式接口主要分为：
 * - Supplier供给型函数
 * - Consumer消费型函数
 * - Runnable无参无返回型函数
 * - Function有参有返回型函数
 *
 * @date 2022/6/12
 */
@FunctionalInterface
public interface DemoFunction {

    void test(String str);

    public static DemoFunction isTrue(boolean bool) {
        return (str -> {
            if (bool) {
                throw new RuntimeException(str);
            }
        });
    }
}
