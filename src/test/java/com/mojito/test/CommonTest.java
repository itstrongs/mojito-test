package com.mojito.test;

import com.mojito.test.utils.log;
import org.junit.jupiter.api.Test;

/**
 * @author liufq
 * @since 2023-05-10 15:46:16
 */
public class CommonTest {

    @Test
    public void test() {
//        String str=;
        log.info("test $1, aaa $2".replace("$1","haha").replace("$2","seffsdf"));
    }
}
