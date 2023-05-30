package com.mojito.test;

import org.junit.jupiter.api.Test;

/**
 * @author liufq
 * @since 2023-05-10 15:46:16
 */
public class CommonTest {

    @Test
    public void test() throws InterruptedException {
        int from = 0;
        int batch = 1000;
        do {
            int fromVal = from++ * batch;
            System.out.println(fromVal);
            Thread.sleep(1000);
        } while (from > 0);
    }
}
