package com.test;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class AsmTest {

    public static void main(String[] args) {
        // 创建一个ClassWriter实例，用于生成一个新的类
        ClassWriter classWriter = new ClassWriter(ClassWriter.COMPUTE_FRAMES);

        //
        classWriter.visit(Opcodes.V11, Opcodes.ACC_PUBLIC, "hello", null, "java/lang/Object", null);

        MethodVisitor method = classWriter.visitMethod(
                Opcodes.ACC_PUBLIC + Opcodes.ACC_STATIC,
                "main",
                "([Ljava/lang/String;)V",
                null,
                null
        );

        method.visitCode();
        method.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
        method.visitLdcInsn("hello World!@#");
        method.visitMethodInsn(
                Opcodes.INVOKEVIRTUAL,
                "java/io/PrintStream",
                "println",
                "(Ljava/lang/String;)V",
                false
        );
        method.visitInsn(Opcodes.RETURN);
        method.visitMaxs(2, 1);
        method.visitEnd();

        classWriter.visitEnd();

        byte[] byteArray = classWriter.toByteArray();
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("Hello.class");
            fos.write(byteArray);
            fos.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
