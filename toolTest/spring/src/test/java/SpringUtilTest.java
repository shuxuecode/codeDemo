import org.junit.jupiter.api.Test;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;

/**
 * @author shuxuecode
 * @date 2024/3/19
 */
public class SpringUtilTest {



    @Test
    public void test() {

        String abc = StringUtils.capitalize("abc");
        System.out.println(abc);

        String delete = StringUtils.delete("abc", "a");
        System.out.println(delete);

    }


    @Test
    public void test1() {
        String s = "123";
        String md5DigestAsHex = DigestUtils.md5DigestAsHex(s.getBytes());
        System.out.println(md5DigestAsHex);
    }





}
