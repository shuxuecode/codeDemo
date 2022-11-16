package com.zsx.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

/**
 * @date 2022/11/16
 */
public class BizIdUtil {

    public static void main(String[] args) {

        String format = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(Calendar.getInstance().getTime());

        System.out.println(format);
        System.out.println(format + "-" + getRandomNumber(8));


    }

    public static String getRandomNumber(int codeLength) {
        final int maxNum = 10;
        int i;
        int count = 0;
        char[] str = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        while (count < codeLength) {
            i = Math.abs(random.nextInt(maxNum));
            sb.append(str[i]);
            count++;
        }
        return sb.toString();
    }

}
