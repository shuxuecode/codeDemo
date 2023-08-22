import com.googlecode.aviator.AviatorEvaluator;
import com.googlecode.aviator.Expression;
import org.junit.jupiter.api.Test;
import org.junit.platform.engine.support.descriptor.ClasspathResourceSource;

import java.io.IOException;

public class ScriptTest {


    @Test void forTest() throws IOException {
        ClasspathResourceSource source = ClasspathResourceSource.from("script/test1.av");
        Expression expression = AviatorEvaluator.getInstance().compileScript(source.getClasspathResourceName());
        expression.execute();
    }

}
