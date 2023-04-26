package com.mojito.test.trance;//package com.mojito.test.trance;
//
//import java.lang.instrument.Instrumentation;
//
///**
// * @author liufq
// * @since 2023-03-01 15:26:48
// */
//public class PreMain {
//
//    //JVM 首先尝试在代理类上调用以下方法
//    public static void premain(String agentArgs, Instrumentation inst) {
//        inst.addTransformer(new ProfilingTransformer());
//    }
//
//    //如果代理类没有实现上面的方法，那么 JVM 将尝试调用该方法
//    public static void premain(String agentArgs) {
//    }
//}
