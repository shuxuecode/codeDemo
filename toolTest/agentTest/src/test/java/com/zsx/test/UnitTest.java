package com.zsx.test;

import org.junit.Test;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.commons.AdviceAdapter;

import java.io.IOException;

/**
 * @date 2024/3/11
 */
public class UnitTest {



    @Test
    public void t1() throws IOException {




    }


    class TTT extends AdviceAdapter {

        protected TTT(int i, MethodVisitor methodVisitor, int i1, String s, String s1) {
            super(i, methodVisitor, i1, s, s1);
        }

        @Override
        protected void onMethodEnter() {
            super.visitMethodInsn(INVOKESTATIC, "com.zsx.test.agent.MyAgent", "test", "()V", false);
            super.onMethodEnter();
        }
    }

}
