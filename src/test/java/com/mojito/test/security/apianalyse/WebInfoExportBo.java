package com.mojito.test.security.apianalyse;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @author liufq
 * @since 2023-04-25 10:22:20
 */
@Data
public class WebInfoExportBo {

    private String dest_hostname;

    private String http_referer;

    private String request_url;

    private String request_method;

    private String user_agent;

    @ExcelProperty("所有特征")
    private String features;

    @ExcelProperty("分析结果")
    private String result;

    @ExcelProperty("特征不为空的比率")
    private String scale;
}
