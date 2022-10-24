package functioninterface.action;

import java.util.UUID;

/**
 * @date 2022/10/24
 */
public class ActionTest {


    public static void main(String[] args) {

        String res = ActionWrapper.wrapper(new Action<String>() {
            @Override
            public String action() throws Throwable {
                return UUID.randomUUID().toString();
            }
        });

        System.out.println(res);
        System.out.println(res.length()); // 36

    }

}
