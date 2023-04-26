package com.mojito.test.trance;

/**
 * @author liufq
 * @since 2023-03-01 15:25:10
 */
public class ApiTest {

    public static void main(String[] args) throws InterruptedException {
        ApiTest apiTest = new ApiTest();
        String res01 = apiTest.queryUserInfo(111, 17);
        System.out.println("测试结果：" + res01 + "\r\n");
    }

    public String queryUserInfo(int uId, int age) throws InterruptedException {
        return "你好，bugstack虫洞栈 | 精神小伙！";
    }
}
