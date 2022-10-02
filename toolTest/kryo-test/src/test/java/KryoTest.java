import com.zsx.kryotest.KryoUtil;
import com.zsx.kryotest.User;
import org.junit.jupiter.api.Test;

import java.util.Date;

/**
 * @author
 * @date 2022/6/10
 */
public class KryoTest {


    @Test
    void t() {
        User user = new User();
        user.setId(1L);
        user.setUsername("test");
        user.setBirthday(new Date());

        byte[] bytes = KryoUtil.serialize(user);

        Object deserialize = KryoUtil.deserialize(bytes);

        user = (User) deserialize;

        System.out.println(user);

    }

}
