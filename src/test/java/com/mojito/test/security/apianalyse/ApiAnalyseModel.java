package com.mojito.test.security.apianalyse;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.stream.Collectors;

/**
 * API站点分析模型
 *
 * @author liufq
 * @since 2023-04-25 10:19:40
 */
@Slf4j
public class ApiAnalyseModel {

    //    private final List<WebInfoExportBo> exportBos = new ArrayList<>();
    private final List<WebInfoBo> exportBos = new ArrayList<>();

    /**
     * 找出API站点特征和非API站点特征，如果这个站点全符合API站点特殊或全符合非API站点特征，那直接得出判断
     * 如果既有API站点特征又有非API站点特征，那根据不同特征得分确定结果
     * <p>
     * 特征分成：肯定是、大概率、有可能、肯定不是
     */
    public void analyse(WebInfoBo webInfoBo) {
        List<AnalyseResult> analyseResults = new ArrayList<>();
        analyseResults.add(hostnameAnalyse(webInfoBo));
        analyseResults.add(refererAnalyse(webInfoBo));
        analyseResults.add(requestUrlAnalyse(webInfoBo));
        analyseResults.add(requestMethodAnalyse(webInfoBo));
        analyseResults.add(userAgentAnalyse(webInfoBo));
        analyseResults.add(userAgentAnalyse(webInfoBo));

        analyseResults = analyseResults.stream().filter(Objects::nonNull).collect(Collectors.toList());
        long apiCount = analyseResults.stream().filter(o -> o != null && o.getIsApiWeb()).count();
        long commonCount = analyseResults.stream().filter(o -> o != null && !o.getIsApiWeb()).count();

        String result;
        if (CollectionUtils.isEmpty(analyseResults)) {
            result = "未识别";
        } else {
            result = apiCount > commonCount ? "API站点" : "普通站点";
        }
        String desc = String.format("符合%s条API站点特征，%s条普通站点特征，是否既有API特征又有普通特征：%s",
                apiCount, commonCount, (apiCount != 0 && commonCount != 0 ? "是" : "否"));
        log.info(desc);

//        WebInfoExportBo exportBo = BaseHelper.r2t(webInfoBo, WebInfoExportBo.class);
//        exportBo.setFeatures(CollectionUtils.isEmpty(analyseResults) ? null : JSON.toJSONString(analyseResults));
//        exportBo.setResult(result);
//        exportBo.setDesc(desc);
//        exportBos.add(exportBo);
        webInfoBo.setResult(result);
        exportBos.add(webInfoBo);
    }

    private AnalyseResult userAgentAnalyse(WebInfoBo webInfoBo) {
        if (StringUtils.isBlank(webInfoBo.getUser_agent())) {
            return null;
        }
        List<String> features = Arrays.asList("Apache-HttpClient", "Go-http-client", "python-requests");
        AnalyseResult result = new AnalyseResult("user_agent");

        if (features.stream().anyMatch(o -> webInfoBo.getUser_agent().contains(o))) {
            return result.setIsApiWeb(true);
        }
        return null;
    }

    /**
     * 根据request_method分析
     * 如果request_method为POST、PUT、DELETE（不为GET），大概率是API站点
     */
    private AnalyseResult requestMethodAnalyse(WebInfoBo webInfoBo) {
        if (StringUtils.isNotBlank(webInfoBo.getRequest_method()) && !webInfoBo.getRequest_method().equals("GET")) {
            return new AnalyseResult("request_method").setIsApiWeb(true).setCoincidence(FeatureType.MATCH);
        }
        return null;
    }

    /**
     * 根据request_url分析
     * 如果包括/api，可能是API站点；如果结尾是.js、.htm、.git，可能是普通站点
     */
    private AnalyseResult requestUrlAnalyse(WebInfoBo webInfoBo) {
        List<String> features1 = Arrays.asList(".js", ".htm", ".html", ".gif", ".jpg", ".jpeg", ".tar.gz", ".png", ".css", ".shtml", ".aspx");
        List<String> features2 = Arrays.asList("/api", "/v1", "/v2", "/v3");
        AnalyseResult result = new AnalyseResult("request_url");

        if (StringUtils.isNotBlank(webInfoBo.getRequest_url())) {
            if (features1.stream().anyMatch(o -> webInfoBo.getRequest_url().contains(o))) {
                return result.setIsApiWeb(false);
            }
            if (features2.stream().anyMatch(o -> webInfoBo.getRequest_url().contains(o))) {
                return result.setIsApiWeb(true);
            }
        }
        return null;
    }

    /**
     * 根据来源分析
     * 如果来源不为空，有普通站点特征；如果是百度等搜索引擎，大概率是普通站点
     */
    private AnalyseResult refererAnalyse(WebInfoBo webInfoBo) {
        List<String> features = Arrays.asList("baidu.com", "bing.com");
        AnalyseResult result = new AnalyseResult("http_referer");

        if (StringUtils.isNotBlank(webInfoBo.getHttp_referer())) {
            result.setApiWeb(false);
            if (features.stream().anyMatch(o -> webInfoBo.getHttp_referer().contains(o))) {
                return result.setCoincidence(FeatureType.MATCH);
            }
        }
        return null;
    }

    /**
     * 根据hostname分析
     * hostname如果是edu等政府网站结尾，大概率是普通站点
     */
    private AnalyseResult hostnameAnalyse(WebInfoBo webInfoBo) {
        List<String> features = Arrays.asList(".gov.cn", ".edu.cn");
        AnalyseResult result = new AnalyseResult("dest_hostname");

        if (features.stream().anyMatch(o -> webInfoBo.getDest_hostname().endsWith(o))) {
            return result.setIsApiWeb(false).setCoincidence(FeatureType.MATCH);
        }
        return null;
    }

    public void finish() {
//        long count = exportBos.stream().filter(o -> StringUtils.isNotBlank(o.getFeatures())).count();
//        String scale = new BigDecimal(count).multiply(new BigDecimal(100)).divide(new BigDecimal(exportBos.size()), 2, RoundingMode.HALF_UP).toString();
//        log.info("特征不为空的比率：{}%", scale);
//        exportBos.forEach(o -> o.setScale(scale + "%"));

//        String fileName = "/Users/mojito/Documents/分析结果.xlsx";
//        try (ExcelWriter excelWriter = EasyExcel.write(fileName, WebInfoExportBo.class).build()) {
//            excelWriter.write(exportBos.stream().filter(o -> "API站点".equals(o.getResult())).collect(Collectors.toList()),
//                    EasyExcel.writerSheet("API站点").build());
//            excelWriter.write(exportBos.stream().filter(o -> "普通站点".equals(o.getResult())).collect(Collectors.toList()),
//                    EasyExcel.writerSheet("普通站点").build());
//            excelWriter.write(exportBos.stream().filter(o -> "未识别".equals(o.getResult())).collect(Collectors.toList()),
//                    EasyExcel.writerSheet("未识别").build());
//        }

        List<WebInfoExportBo> result = new ArrayList<>();
        Map<String, List<WebInfoBo>> map = exportBos.stream().collect(Collectors.groupingBy(WebInfoBo::getDest_hostname));
        map.forEach((k, v) -> {
            long apiCount = v.stream().filter(o -> "API站点".equals(o.getResult())).count();
            long commonCount = v.stream().filter(o -> "普通站点".equals(o.getResult())).count();
            long unknownCount = v.stream().filter(o -> "未识别".equals(o.getResult())).count();

            result.add(new WebInfoExportBo()
                    .setDest_hostname(k)
                    .setApiCount(apiCount)
                    .setCommonCount(commonCount)
                    .setUnknownCount(unknownCount)
                    .setApiScale(getScale(apiCount, v.size()))
                    .setCommonScale(getScale(commonCount, v.size()))
            );
        });

        String fileName = "/Users/mojito/Documents/分析结果.xlsx";
        try (ExcelWriter excelWriter = EasyExcel.write(fileName, WebInfoExportBo.class).build()) {
            excelWriter.write(result.stream().sorted(Comparator.comparing(WebInfoExportBo::getApiCount).reversed())
                            .collect(Collectors.toList()),
                    EasyExcel.writerSheet("Sheet").build());
        }
    }

    private String getScale(long count, Integer total) {
        return new BigDecimal(count)
                .multiply(new BigDecimal(100))
                .divide(new BigDecimal(total), 2, RoundingMode.HALF_UP) + "%";
    }
}
