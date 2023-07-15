package org.test;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * todo
 *
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


    public static String str2HexStr(String str) {
        char[] chars = "0123456789ABCDEF".toCharArray();// toCharArray() 方法将字符串转换为字符数组。
        StringBuilder sb = new StringBuilder(""); // StringBuilder是一个类，可以用来处理字符串,sb.append()字符串相加效率高
        byte[] bs = str.getBytes();// String的getBytes()方法是得到一个操作系统默认的编码格式的字节数组
        int bit;
        for (int i = 0; i < bs.length; i++) {
            bit = (bs[i] & 0x0f0) >> 4; // 高4位, 与操作 1111 0000
            sb.append(chars[bit]);
            bit = bs[i] & 0x0f;  // 低四位, 与操作 0000 1111
            sb.append(chars[bit]);
            // sb.append(' ');// 每个Byte之间空格分隔
        }
        return sb.toString().trim();
    }


    public static String decode(String hexStr) throws UnsupportedEncodingException {

        String str = "0123456789ABCDEF";

        char[] hexs = hexStr.toCharArray();
        byte[] bytes = new byte[hexStr.length() / 2]; // 1个byte数值 -> 两个16进制字符
        int n;
        for (int i = 0; i < bytes.length; i++) {

            // 2 * i 两个16进制字符 -> 1个byte数值
            n = str.indexOf(hexs[2 * i]) * 16;
            n += str.indexOf(hexs[2 * i + 1]);

            // 保持二进制补码的一致性 因为byte类型字符是8bit的  而int为32bit 会自动补齐高位1  所以与上0xFF之后可以保持高位一致性
            // 当byte要转化为int的时候，高的24位必然会补1，这样，其二进制补码其实已经不一致了，&0xff可以将高的24位置为0，低8位保持原样，这样做的目的就是为了保证二进制数据的一致性。
            bytes[i] = (byte) (n & 0xff);
        }
        return new String(bytes, "UTF-8");
    }

    public static void main(String[] args) throws UnsupportedEncodingException {

        String str = "hello world";
        // String encode = encode(str);
        String encode = str2HexStr(str);

        System.out.println(encode);


        String decode = decode(encode);

        System.out.println(decode);

    }

}
