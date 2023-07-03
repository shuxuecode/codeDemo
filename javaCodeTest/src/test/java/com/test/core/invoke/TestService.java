package com.test.core.invoke;

import java.util.UUID;

/**
 * @date 2023/7/3
 */
public class TestService {


    public String getUUID(String str) {
        return UUID.randomUUID().toString() + str;
    }

}
