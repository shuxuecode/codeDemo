import junit.framework.TestCase;
import junit.textui.TestRunner;

public class JunitTest {


    // todo xue
    public static void main(String[] args) {
        TestRunner.run(new Ttt());
    }

}

class Ttt extends TestCase {
    public Ttt() {
        System.out.println("123");
    }
}