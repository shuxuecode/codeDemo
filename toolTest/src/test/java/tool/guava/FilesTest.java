package tool.guava;

import com.google.common.collect.Sets;
import com.google.common.io.Files;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashSet;
import java.util.List;

/**
 * @date 2022/12/4
 */
public class FilesTest {

    static String file1 = "";
    static String file2 = "";

    @Test
    void t1() throws IOException {
        List<String> lines1 = Files.readLines(new File(file1), Charset.forName("UTF8"));
        List<String> lines2 = Files.readLines(new File(file2), Charset.forName("UTF8"));

        HashSet<String> set1 = Sets.newHashSet(lines1);
        HashSet<String> set2 = Sets.newHashSet(lines2);

        System.out.println("文件一中有的：");
        for (String str : lines1) {
            if (!set2.contains(str)) {
                System.out.println(str);
            }
        }


        System.out.println("===============================");
        System.out.println("文件二中有的：");
        for (String str : lines2) {
            if (!set1.contains(str)) {
                System.out.println(str);
            }
        }

    }


}
