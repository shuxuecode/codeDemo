import junit.framework.TestCase;
import junit.textui.TestRunner;

public class JunitTest {


    public static void main(String[] args) {
        TestRunner.run(new T());
    }

}

class T extends TestCase {
    public T() {
        System.out.println("123");
    }
}