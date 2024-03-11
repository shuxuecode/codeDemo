package com.zsx.test.agent;


import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.commons.AdviceAdapter;

/**
 * @date 2024/3/11
 */
public class MyAdviceAdapter extends AdviceAdapter {
    protected MyAdviceAdapter(int api, MethodVisitor methodVisitor, int access, String name, String descriptor) {
        super(api, methodVisitor, access, name, descriptor);
    }


    @Override
    protected void onMethodEnter() {
        super.visitMethodInsn(Opcodes.INVOKESTATIC, "com/zsx/test/agent/TimeStatistics", "start", "()V", false);
        super.onMethodEnter();
    }

    @Override
    protected void onMethodExit(int i) {
        super.onMethodExit(i);
        super.visitMethodInsn(Opcodes.INVOKESTATIC, "com/zsx/test/agent/TimeStatistics", "end", "()V", false);
    }
}
