import com.zsx.mockito.UserService;
import com.zsx.mockito.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class MockitoTest {


    @Test
    void test01() {

        // 创建mock对象
        UserService userService = mock(UserService.class);

        // 定义预期行为
        when(userService.getUserName("1")).thenReturn("zsx");

        String userName = userService.getUserName("1");

        verify(userService).getUserName("1");
        //verify(userService, Mockito.times(10)).getUserName("1");
    }


    // todo zsx 待验证和补充
}
