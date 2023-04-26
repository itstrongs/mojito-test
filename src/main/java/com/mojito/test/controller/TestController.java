package com.mojito.test.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.support.ExcelTypeEnum;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author liufq
 * @since 2023-04-23 10:26:23
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping
    public String test() throws IOException {
        List<List<Object>> lines = new ArrayList<>();
        List<List<String>> titles = new ArrayList<>();

        for (int i = 0; i < 1000; i++) {
            lines.add(Arrays.asList("aaa", "bbb", "ccc"));
            lines.add(Collections.singletonList("title"));
        }

        try (ByteArrayOutputStream bos = new ByteArrayOutputStream()) {
            EasyExcel.write(bos).head(titles)
                    .excelType(ExcelTypeEnum.XLSX).sheet("测试表")
                    .doWrite(lines);
        }

        return "SUCCESS";
    }
}
