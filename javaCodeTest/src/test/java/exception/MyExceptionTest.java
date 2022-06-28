package exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @date 2022/6/27
 */
class MyExceptionTest {


    public void test() {

        try {
            if (1 < 2) {
                throw new MyException("1", "2");
            }
        } catch (MyException e) {
            e.printStackTrace();
            throw e;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Test
    void t1() {
        try {
            test();
        } catch (MyException e) {
            System.out.println(111);
        } catch (Exception e) {
            System.out.println(222);
        }

    }


}