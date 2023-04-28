package com.mojito.test.security.apianalyse;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @author liufq
 * @since 2023-04-25 10:22:20
 */
@Data
public class WebInfoBo {

    @ExcelProperty(index = 0)
    private String dest_hostname;

    @ExcelProperty(index = 3)
    private String http_referer;

    @ExcelProperty(index = 5)
    private String request_url;

    @ExcelProperty(index = 14)
    private String request_method;

    @ExcelProperty(index = 15)
    private String user_agent;

    private String result;
}
