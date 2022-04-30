package com.test.core.unsafe;

import org.junit.jupiter.api.Test;
import sun.misc.Unsafe;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * @date 2022/4/29
 */
public class UnsafeTest {

    @Test void t1() throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Class<Unsafe> unsafeClass = Unsafe.class;
        //Constructor<?>[] declaredConstructors = unsafeClass.getDeclaredConstructors();
        //for (Constructor<?> constructor : declaredConstructors) {
        //    constructor.setAccessible(true);
        //    Object instance = constructor.newInstance();
        //}
        Field theUnsafe = unsafeClass.getDeclaredField("theUnsafe");
        theUnsafe.setAccessible(true);
        Unsafe unsafe = (Unsafe) theUnsafe.get(null);

        System.out.println(unsafe); // sun.misc.Unsafe@2e3fc542


        User user = new User();
        user.setName("a");

        long fieldOffset = unsafe.objectFieldOffset(User.class.getDeclaredField("name"));
        unsafe.compareAndSwapObject(user, fieldOffset, "aa", "b");

        System.out.println(user);


    }

}

class User{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}
