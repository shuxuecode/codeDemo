import demo.DemoReq;
import org.junit.jupiter.api.Test;
import org.springframework.core.DefaultParameterNameDiscoverer;
import org.springframework.core.ParameterNameDiscoverer;
import org.springframework.expression.Expression;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class SpringSpelTest {


    @Test
    void t1() throws ClassNotFoundException, NoSuchMethodException {
        // 测试Spring Spel
        SpelExpressionParser parser = new SpelExpressionParser();

        Expression exp = parser.parseExpression("#arg0.name");


        System.out.println(exp);

        ParameterNameDiscoverer parameterNameDiscoverer = new DefaultParameterNameDiscoverer();

        StandardEvaluationContext context = new StandardEvaluationContext();

        Class<?> cls = Class.forName("demo.DemoService");

        Method method = cls.getDeclaredMethod("test", DemoReq.class);
        System.out.println(method.getParameters()[0].getName());

        Method[] declaredMethods = cls.getDeclaredMethods();

        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod);
        }

        Method declaredMethod = declaredMethods[0];
        //Parameter[] parameters = declaredMethod.getParameters();
        Class<?>[] parameterTypes = declaredMethod.getParameterTypes();


        //System.out.println(parameters.length);
        //System.out.println(parameterTypes.length);

        //declaredMethod = cls.getDeclaredMethod(declaredMethod.getName(), parameterTypes);

        Parameter[] parameters = declaredMethod.getParameters();


        for (Parameter parameter : parameters) {
            context.setVariable(parameter.getName(), "");
            System.out.println(parameter);
            System.out.println(parameter.getName());
        }


        String[] parameterNames = parameterNameDiscoverer.getParameterNames(declaredMethod);

        System.out.println(parameterNames);



        System.out.println(exp.getValue(context));

    }



}
