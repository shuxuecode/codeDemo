package com.zsx.test.agent;


import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

/**
 * @date 2024/3/11
 */
public class MyClassVisitor extends ClassVisitor {
    public MyClassVisitor(int i, ClassVisitor classVisitor) {
        // todo zsx
        super(Opcodes.ASM5, classVisitor);
    }

    @Override
    public MethodVisitor visitMethod(int access, String name, String descriptor, String signature, String[] exceptions) {

        MethodVisitor mv = cv.visitMethod(access, name, descriptor, signature, exceptions);
        if (name.equals("<init>")) {
            return mv;
        }
        return new MyAdviceAdapter(api, mv, access, name, descriptor);
    }
}
