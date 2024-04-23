import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 */
public class Java11Test {


    @Test
    void t1() {
        // 字符串新增 isEmpty  isBlank 方法判断字符串是否空字符
        String str = "   ";
        System.out.println(str.isEmpty()); // false
        System.out.println(str.isBlank()); // true
    }

    @Test
    void t2() {
        // 将一个字符串按照行终止符（换行符\n 或 回车符\r）进行分割，并转为stream流
        String str = " a \n b \r c";
        Stream<String> lines = str.lines();
        lines.forEach(System.out::println);
    }

    @Test
    void t3() {
        String str = "test\u3000";
        System.out.println(str.trim());
        System.out.println(str.strip());
        System.out.println(str.trim().length());
        System.out.println(str.strip().length());
        // trim()   只能去除半角空白符
        // strip()  去除字符串前后的 全角 和 半角 空白字符
        str.stripLeading();
        str.stripTrailing();
        // stripLeading   去除前面的全角半角空白符
        // stripTrailing  去除尾部的全角半角空白符
    }

    @Test
    void t4() {
        String str = "abc";
        System.out.println(str.repeat(0)); // 空字符
        System.out.println(str.repeat(1)); // abc
        System.out.println(str.repeat(2)); // abcabc
        // repeat 重复串联字符串n次
    }


    @Test
    void t5() {
        List<String> list = Arrays.asList("a", "b");
        // 之前想集合转对应的数组很麻烦，要么用迭代；要么用Stream流，现在可以这样
        String[] array = list.toArray(String[]::new);
    }

    @Test
    void t6() {
        // 断言取反
        // Predicate.not(null);
    }

    @Test
    void t7() {
        // var可以用于修饰Lambda局部变量
        // 在Java 10中引入的var来进行类型推断。在Java 10中它不能用于修饰Lambda表达式的入参，其实对于一个Lambda表达式来说它入参的类型其实是可以根据上下文推断出来的。
        Arrays.asList("", "").stream()
                .filter((var item) -> !item.isBlank())
                .collect(Collectors.toList());
    }

    @Test
    void t8() {
        // 文件中读写字符串内容更方便
        // Java 11中可以更轻松地从文件中读取和写入字符串内容了，我们可以通过Files工具类提供的新的静态方法readString和writeString分别进行读写文件的字符串内容
        try {
            Path path = Files.writeString(Path.of("filepath"), "文本内容");
            String fileContent = Files.readString(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void t9() {
        Stream.ofNullable(null) //
                .count(); // 0

        Stream.of(1, 2, 3, 2, 1)
                .dropWhile(n -> n < 3) // dropWhile 从流中放弃哪些元素
                .collect(Collectors.toList()); // [3,2,1]

        Stream.of(1, 2, 3, 2, 1)
                .takeWhile(n -> n < 3) // takeWhile 从流中选用哪些元素
                .collect(Collectors.toList()); // [1,2]
    }

    @Test
    void t10() {
        Optional.of("").orElseThrow();
        Optional.of("").stream().count();
        Optional.ofNullable(null)
                .or(() -> Optional.of(""))
                .get();
    }

    @Test
    void t11() {
        // 编译器会自动推断出类型
        var list = List.of("a", "b");
        list.forEach(System.out::println);

        list.stream().forEach((var item) -> {
            System.out.println(item);
        });
    }


    @Test
    void t12() {
        // 集合加强
        // 自 Java 9 开始，Jdk 里面为集合（List/ Set/ Map）都添加了 of 和 copyOf 方法，它们两个都用来创建不可变的集合，来看下它们的使用和区别。
        // 注意：使用of和copyOf创建的集合为不可变集合，不能进行添加、删除、替换、排序等操作，不然会报 java.lang.UnsupportedOperationException 异常。

        var list = List.of("a", "b");
        var copy = List.copyOf(list);

        // copy.add("c"); // java.lang.UnsupportedOperationException

        copy.forEach(System.out::println);
    }


    @Test
    void t13() throws IOException, InterruptedException {
        //  HTTP Client api
        // 自 Java 9 开始，Jdk 里面为 HttpClient 增加了新的 api，来看下它们的使用和区别。
        HttpRequest request = HttpRequest
                .newBuilder()
                .uri(URI.create("http://www.baidu.com"))
                .GET()
                .build();

        HttpClient client = HttpClient.newHttpClient();

        // 同步
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());

        //     异步
        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenAccept(System.out::println);

    }

}
