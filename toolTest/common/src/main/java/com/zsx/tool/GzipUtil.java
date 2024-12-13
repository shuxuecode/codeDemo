package com.zsx.tool;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 * @author
 * @date 2022/6/13
 */
public class GzipUtil {

    /**
     * 压缩
     *
     * @param sourceStr
     * @return
     */
    public static String compress(String sourceStr) {
        if (sourceStr == null || sourceStr.length() == 0) {
            return sourceStr;
        }
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try (GZIPOutputStream gzip = new GZIPOutputStream(out)) {
            gzip.write(sourceStr.getBytes());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return new BASE64Encoder().encode(out.toByteArray());
    }

    /**
     * 解压
     *
     * @param zipStr
     * @return
     */
    public static String uncompress(String zipStr) {
        if (zipStr == null) {
            return null;
        }
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ByteArrayInputStream in = null;
        GZIPInputStream gzip = null;
        byte[] compressed;
        String result;
        try {
            compressed = new BASE64Decoder().decodeBuffer(zipStr);
            in = new ByteArrayInputStream(compressed);
            gzip = new GZIPInputStream(in);

            byte[] buffer = new byte[1024];
            int offset = -1;
            while ((offset = gzip.read(buffer)) != -1) {
                out.write(buffer, 0, offset);
            }
            result = out.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (gzip != null) {
                try {
                    gzip.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            try {
                out.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return result;
    }

}
