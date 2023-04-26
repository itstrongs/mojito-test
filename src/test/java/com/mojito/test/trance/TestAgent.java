package com.mojito.test.trance;

import java.lang.instrument.Instrumentation;

/**
 * @author liufq
 * @since 2023-03-01 16:21:13
 */
public class TestAgent {

    public static void agentmain(String args, Instrumentation inst) throws Exception {
        System.out.println("Args:" + args);
    }

    public static void premain(String args, Instrumentation inst) throws Exception {
        System.out.println("Pre Args:" + args);
        Class[] classes = inst.getAllLoadedClasses();
        for (Class clazz : classes) {
            System.out.println(clazz.getName());
        }
    }
}
