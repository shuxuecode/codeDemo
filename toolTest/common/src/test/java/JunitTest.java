import junit.framework.TestCase;
import junit.textui.TestRunner;

public class JunitTest {


    public static void main(String[] args) {
        TestRunner.run(T.class);
    }

    public class T extends TestCase {

        {
            System.out.println("123");
        }
    }
}

