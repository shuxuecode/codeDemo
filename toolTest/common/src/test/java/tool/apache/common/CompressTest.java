package tool.apache.common;

import groovy.util.GroovyTestCase;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream;

import java.io.*;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * @author shuxuecode
 * @date 2024/12/16
 */
public class CompressTest extends GroovyTestCase {


    public void test() {

        String userHomePath = System.getProperty("user.home");
        System.out.println(userHomePath);

        File outputFile = new File(userHomePath + "/tmp/testZip.zip");
        File inputFile = new File(userHomePath + "/tmp/0.txt");

        try (
                ZipArchiveOutputStream zipOutput = new ZipArchiveOutputStream(new FileOutputStream(outputFile));
                FileInputStream fis = new FileInputStream(inputFile)
        ) {

            ZipArchiveEntry entry = new ZipArchiveEntry(inputFile.getName());
            zipOutput.putArchiveEntry(entry);

            byte[] buffer = new byte[1024];
            int len;
            while ((len = fis.read(buffer)) != -1) {
                zipOutput.write(buffer, 0, len);
            }

            zipOutput.closeArchiveEntry();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void testJieYa() {
        String userHomePath = System.getProperty("user.home");
        System.out.println(userHomePath);

        File zipFile = new File(userHomePath + "/tmp/testZip.zip");
        File outputDir = new File(userHomePath + "/tmp/1");

        if (!outputDir.exists()) {
            outputDir.mkdir();
        }

        try (ZipFile zip = new ZipFile(zipFile)) {
            Enumeration<? extends ZipEntry> entries = zip.entries();
            while (entries.hasMoreElements()) {
                ZipEntry entry = entries.nextElement();

                if (!entry.isDirectory()) {
                    File outFile = new File(outputDir, entry.getName());

                    try (InputStream is = zip.getInputStream(entry);
                         FileOutputStream fos = new FileOutputStream(outFile)) {

                        byte[] buffer = new byte[1024];
                        int len;
                        while ((len = is.read(buffer)) != -1) {
                            fos.write(buffer, 0, len);
                        }
                    }

                }


            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
