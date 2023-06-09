package com.mojito.test.trance;//package com.mojito.test.trance;
//
//import jdk.internal.org.objectweb.asm.ClassReader;
//import jdk.internal.org.objectweb.asm.ClassVisitor;
//import jdk.internal.org.objectweb.asm.ClassWriter;
//
//import java.lang.instrument.ClassFileTransformer;
//import java.lang.instrument.IllegalClassFormatException;
//import java.security.ProtectionDomain;
//
///**
// * @author liufq
// * @since 2023-03-01 15:29:38
// */
//public class ProfilingTransformer implements ClassFileTransformer {
//
//    @Override
//    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
//        try {
//
//            // 排除一些不需要处理的方法
//            if (ProfilingFilter.isNotNeedInject(className)) {
//                return classfileBuffer;
//            }
//
//            return getBytes(loader, className, classfileBuffer);;
//        } catch (Throwable e) {
//            System.out.println(e.getMessage());
//        }
//        return classfileBuffer;
//    }
//
//    private byte[] getBytes(ClassLoader loader, String className, byte[] classfileBuffer) {
//        ClassReader cr = new ClassReader(classfileBuffer);
//        ClassWriter cw = new ClassWriter(cr, ClassWriter.COMPUTE_MAXS);
//        ClassVisitor cv = new ProfilingClassAdapter(cw, className);
//        cr.accept(cv, ClassReader.EXPAND_FRAMES);return cw.toByteArray();
//    }
//}
