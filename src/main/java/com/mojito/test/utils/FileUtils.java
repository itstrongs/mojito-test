package com.mojito.test.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author liufq
 * @since 2023-04-26 14:14:42
 */
public class FileUtils {

    /**
     * 获取Resource下文件内容
     */
    public static String getString(String filename) throws IOException {
        InputStream path = FileUtils.class.getResourceAsStream("/" + filename);
        assert path != null;
        BufferedReader reader = new BufferedReader(new InputStreamReader(path));
        StringBuilder builder = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            builder.append(line);
        }
        return builder.toString();
    }
}
