package com.zsx.tool;

import com.github.luben.zstd.Zstd;

import java.nio.charset.StandardCharsets;

/**
 * @author
 * @date 2024/12/13
 */
public class ZstdUtil {


    public static void main(String[] args) {

        byte[] compress1 = Zstd.compress("123".getBytes(StandardCharsets.UTF_8), 3);
        byte[] compress = Zstd.compress("123".getBytes(), 3);

        System.out.println(new String(compress1, StandardCharsets.UTF_8));
        System.out.println(new String(compress));

        byte[] decompress = Zstd.decompress(compress1, (int) Zstd.getFrameContentSize(compress1));

        System.out.println(new String(decompress));

        System.out.println("============================================");

        byte[] compressByte = compress("123456");
        System.out.println(compressByte);

        String uncompress = uncompress(compressByte);
        System.out.println(uncompress);
    }


    /**
     * 压缩
     *
     * @param sourceStr
     * @return
     */
    public static byte[] compress(String sourceStr) {

        byte[] bytes = sourceStr.getBytes(StandardCharsets.UTF_8);

        // 第二个参数标识压缩级别，默认为3
        byte[] compressedData = Zstd.compress(bytes, 3);

        System.out.println(compressedData.length);
        return compressedData;
    }


    /**
     * 解压
     *
     * @param compressedData
     * @return
     */
    public static String uncompress(byte[] compressedData) {

        byte[] uncompressedData = new byte[(int) Zstd.getFrameContentSize(compressedData)];

        Zstd.decompress(uncompressedData, compressedData);

        return new String(uncompressedData, StandardCharsets.UTF_8);
    }

}
