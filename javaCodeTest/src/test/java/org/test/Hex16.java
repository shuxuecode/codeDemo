package org.test;

import com.sun.javafx.scene.traversal.Algorithm;

import java.nio.charset.StandardCharsets;
import java.security.AlgorithmConstraints;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * todo
 * @author
 * @date 2022/4/12
 */
public class Hex16 {

    static char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static String encode(String str) {
        try {
            byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
            MessageDigest md5 = MessageDigest.getInstance("MD5");

            md5.update(bytes);

            byte[] md = md5.digest();

            int len = md.length;

            char[] chars = new char[len * 2];

            int k = 0;

            for (int i = 0; i < len; i++) {
                byte b = md[i];

                chars[k++] = hexDigits[b >>> 4 & 0xf];
                chars[k++] = hexDigits[b & 0xf];
            }

            return new String(chars);

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {

        String str = "hello world";
        String encode = encode(str);

        System.out.println(encode);
    }

}
