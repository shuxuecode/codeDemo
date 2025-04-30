import com.zsx.mockito.UserService;
import com.zsx.mockito.UserServiceImpl;
import org.junit.After;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

/*
`@RunWith(MockitoJUnitRunner.class)` 是一个注解，用于指定 JUnit 测试类使用的测试运行器（Runner）。
在这个例子中，`MockitoJUnitRunner` 被用来初始化 `@Mock` 和 `@InjectMocks` 注解的字段。
具体来说，`MockitoJUnitRunner` 会在每个测试方法执行前调用 `MockitoAnnotations.initMocks(this)` 方法来初始化这些注解。
这样可以确保在测试方法中使用到的模拟对象已经被正确地创建和配置。
 */
//@RunWith(MockitoJUnitRunner.class)
public class MockitoTest {

    @Mock
    UserService userService;

    @InjectMocks
    UserServiceImpl userServiceImpl;

    @BeforeEach
    public void setUp() {
        // 初始化 @Mock 注解标记的对象
        MockitoAnnotations.openMocks(this);


    }

    @AfterEach
    public void after() throws Exception {
        System.out.println("after");
    }

    @Test
    public void test01() {

        // 创建mock对象
        //UserService userService = mock(UserService.class);

        // 定义预期行为
        when(userService.getUserName("1")).thenReturn("zsx");

        String userName = userService.getUserName("1");

        verify(userService).getUserName("1");
        //verify(userService, Mockito.times(10)).getUserName("1");
    }


    @Test
    void test02() {

        when(userService.getUserName(any())).thenReturn("test");
        when(userServiceImpl.getUserName(any())).thenReturn("test");

        userServiceImpl.getUserName(any());

        verify(userService).getUserName(any());
    }

    // todo zsx 待验证和补充
}
