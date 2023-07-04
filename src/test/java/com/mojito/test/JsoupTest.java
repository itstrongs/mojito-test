package com.mojito.test;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author liufq
 * @since 2023-07-03 18:52:15
 */
public class JsoupTest {

    @Test
    public void test() throws IOException {
        int start = 0;
        for (int i = 0; i < 10; i++) {
            String url = String.format("https://movie.douban.com/top250?start=%s&filter=", start++ * 25);
            Connection conn = Jsoup.connect(url).timeout(5000);
            conn.header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
            conn.header("Accept-Encoding", "gzip, deflate, sdch");
            conn.header("Accept-Language", "zh-CN,zh;q=0.8");
            conn.header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.87 Safari/537.36");
            Document document = conn.get();

            Elements item = document.getElementsByClass("item");
            List<String> list = new ArrayList<>();
            item.forEach(o -> {
                Element span = o.select("span").first();
                list.add(String.format("`%s`", span.text()));
            });
            System.out.println(String.join(" ", list) + "\n");
        }
    }
}
