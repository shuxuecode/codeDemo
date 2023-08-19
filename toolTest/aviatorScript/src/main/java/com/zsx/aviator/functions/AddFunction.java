package com.zsx.aviator.functions;

import com.googlecode.aviator.runtime.function.AbstractFunction;
import com.googlecode.aviator.runtime.function.FunctionUtils;
import com.googlecode.aviator.runtime.type.AviatorBigInt;
import com.googlecode.aviator.runtime.type.AviatorObject;

import java.util.Map;


/**
 * 自定义函数
 */
public class AddFunction extends AbstractFunction {

    /**
     * 定义函数的名称
     *
     * @return
     */
    @Override
    public String getName() {
        return "add";
    }

    /**
     * 函数调用
     *
     * @param env  当前执行的上下文
     * @param arg1 第一个参数
     * @param arg2 第二个参数
     * @return
     */
    @Override
    public AviatorObject call(Map<String, Object> env, AviatorObject arg1, AviatorObject arg2) {

        Number a = FunctionUtils.getNumberValue(arg1, env);
        Number b = FunctionUtils.getNumberValue(arg2, env);

        return new AviatorBigInt(a.intValue() + b.intValue());
    }
}
