import com.zsx.fury.vo.Demo;
import io.fury.Fury;
import io.fury.Language;
import io.fury.ThreadSafeFury;
import io.fury.serializer.CompatibleMode;
import org.junit.jupiter.api.Test;

import java.io.FileReader;
import java.util.Date;

public class FuryTest {


    @Test
    void t1() {
        Demo demo = new Demo();
        demo.setId(1);
        demo.setName("test");
        demo.setBirthday(new Date());


        Fury fury = Fury.builder().withLanguage(Language.JAVA).build();

        fury.register(Demo.class);
        fury.register(Demo.class);
        fury.register(Demo.class);

        byte[] bytes = fury.serialize(demo);

        System.out.println(fury.deserialize(bytes));


    }


    @Test
    void t2() {
        // 线程安全
        ThreadSafeFury fury = Fury.builder()
                .withLanguage(Language.JAVA)
                .withRefTracking(false)
                .withCompatibleMode(CompatibleMode.SCHEMA_CONSISTENT)
                .withAsyncCompilation(true)
                .buildThreadSafeFury();

        fury.getCurrentFury().register(Demo.class);

        Demo demo = new Demo(1, "123", new Date());

        byte[] bytes = fury.serialize(demo);

        System.out.println(fury.deserialize(bytes));

    }

}
