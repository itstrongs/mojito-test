package com.mojito.test.security.apianalyse;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author liufq
 * @since 2023-04-25 10:22:20
 */
@Data
@Accessors(chain = true)
public class WebInfoExportBo {

    @ExcelProperty("站点host")
    private String dest_hostname;

    @ExcelProperty("API站点数量")
    private long apiCount;

    @ExcelProperty("普通站点数量")
    private long commonCount;

    @ExcelProperty("未识别数量")
    private long unknownCount;

    @ExcelProperty("API站点比率")
    private String apiScale;

    @ExcelProperty("普通站点比率")
    private String commonScale;
//
//    @ExcelProperty("分析结果")
//    private String result;
//
//    @ExcelProperty("结果说明")
//    private String desc;
//
//    @ExcelProperty("所有特征")
//    private String features;

//    @ExcelProperty("特征不为空的比率")
//    private String scale;
}
