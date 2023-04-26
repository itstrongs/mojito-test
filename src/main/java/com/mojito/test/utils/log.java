package com.mojito.test.utils;

/**
 * @author liufq
 * @since 2023-04-26 11:13:19
 */
public class log {

    public static void info(String log) {
        System.out.println(log);
    }

    public static void error(String log) {
        System.out.println("ERROR: " + log);
    }
}
