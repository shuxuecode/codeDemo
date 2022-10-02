package com.zsx.kryotest;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

import java.io.ByteArrayOutputStream;

/**
 * @author
 * @date 2022/6/10
 */
public class KryoUtil {

    private static final ThreadLocal<Kryo> kryoPool = ThreadLocal.withInitial(() -> {
        Kryo kryo = KryoFactory.createKryo();
        kryo.setReferences(false);
        return kryo;
    });

    public static byte[] serialize(Object object) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream(4096);
        Output output = new Output(baos, 1024);
        kryoPool.get().writeClassAndObject(output, object);
        output.flush();
        return baos.toByteArray();
    }

    public static Object deserialize(byte[] bytes){
        Input input = new Input(bytes);
        return kryoPool.get().readClassAndObject(input);
    }


}
