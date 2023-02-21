package tool.groovy;

import groovy.lang.Script;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @date 2023/2/21
 */
public class EvalBaseScript extends Script {
    @Override
    public Object run() {
        Method[] methods = EvalBaseScript.class.getDeclaredMethods();
        StringBuilder stringBuilder = new StringBuilder();
        for (Method method : methods) {
            stringBuilder.append(method);
        }
        return stringBuilder.substring(0, stringBuilder.length() - 1);
    }

    public static double round(String value, int scale) {
        BigDecimal bigDecimal = new BigDecimal(value);
        return bigDecimal.setScale(scale, RoundingMode.HALF_UP).doubleValue();
    }

    public static BigDecimal round(BigDecimal value, int scale) {
        BigDecimal bigDecimal = value;
        return bigDecimal.setScale(scale, RoundingMode.HALF_UP);
    }
}
