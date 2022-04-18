package debug;

import org.junit.jupiter.api.Test;

/**
 * @date 2022/4/18
 */
public class DebugTest1 {

    @Test
    public void t1() {
        for (int i = 0; i < 5; i++) {
            System.out.println(i);
        }
    }

    private String num = "a";

    @Test
    void t2() {
        System.out.println(num);

        try {
            Integer.valueOf(num);
        }catch (Exception e){
            e.printStackTrace();
            throw new NumberFormatException();
        }

    }

}
