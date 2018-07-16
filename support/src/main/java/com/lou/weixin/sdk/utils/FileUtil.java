package com.lou.weixin.sdk.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 文件工具类
 *
 * @author loufeng
 * @date 2018/7/9 下午3:09.
 */
public class FileUtil {
    /**
     * 创建临时文件
     *
     * @param inputStream io
     * @param name        文件名
     * @param ext         扩展名
     * @return file
     * @throws IOException io异常
     */
    public static File createTmpFile(InputStream inputStream, String name, String ext) throws IOException {
        FileOutputStream fos = null;
        try {
            File tmpFile = File.createTempFile(name, '.' + ext);
            tmpFile.deleteOnExit();
            fos = new FileOutputStream(tmpFile);
            int read = 0;
            byte[] bytes = new byte[1024 * 100];
            while ((read = inputStream.read(bytes)) != -1) {
                fos.write(bytes, 0, read);
            }
            fos.flush();
            return tmpFile;
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException ignored) {
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException ignored) {
                }
            }
        }
    }
}
