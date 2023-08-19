import com.googlecode.aviator.AviatorEvaluator;
import com.googlecode.aviator.AviatorEvaluatorInstance;
import com.googlecode.aviator.Expression;
import com.sun.xml.internal.ws.util.ReadAllStream;
import com.zsx.aviator.functions.AddFunction;
import org.junit.jupiter.api.Test;
import org.junit.platform.engine.discovery.ClasspathResourceSelector;
import org.junit.platform.engine.support.descriptor.ClasspathResourceSource;

import java.io.IOException;
import java.util.HashMap;

public class UnitTest {


    @Test
    void test自定义函数() {
        AviatorEvaluatorInstance instance = AviatorEvaluator.getInstance();
        // 注册函数
        instance.addFunction(new AddFunction());

        // 执行脚本
        Object res = instance.execute("add(1, 2)");

        System.out.println(res);
    }

    @Test
    void 参数test() {
        String script = "a + b > c";

        Expression compile = AviatorEvaluator.getInstance().compile(script);

        HashMap<String, Object> params = new HashMap<>();
        params.put("a", 1);
        params.put("b", 1);
        params.put("c", 1);

        Object res = compile.execute(params);

        System.out.println(res);
        System.out.println((Boolean) res);

    }


    @Test
    void 脚本文本() {
        // 定义脚本
        String script = "println(\"hello world!!!\");";
        //编译脚本文本
        Expression expression = AviatorEvaluator.getInstance().compile(script);
        //执行
        expression.execute();

    }

    @Test
    void 脚本文件() throws IOException {
        // 获取脚本路径
        ClasspathResourceSource source = ClasspathResourceSource.from("script/hello.av");
        System.out.println(source.getClasspathResourceName());

        // 编译脚本文件
        Expression expression = AviatorEvaluator.getInstance().compileScript(source.getClasspathResourceName());
        // 执行
        Object res = expression.execute();

    }
}
