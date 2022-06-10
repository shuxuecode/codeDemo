package com.zsx.kryotest;

import com.esotericsoftware.kryo.Kryo;
import de.javakaffee.kryoserializers.UUIDSerializer;

import java.util.UUID;

/**
 * @author
 * @date 2022/6/10
 */
public class KryoFactory {

    public static Kryo createKryo() {
        Kryo kryo = new Kryo();

        kryo.setRegistrationRequired(false);

        kryo.register(UUID.class, new UUIDSerializer());

        return kryo;
    }

}
