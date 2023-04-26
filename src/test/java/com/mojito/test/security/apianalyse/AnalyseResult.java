package com.mojito.test.security.apianalyse;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author liufq
 * @since 2023-04-25 10:56:06
 */
@Data
@Accessors(chain = true)
public class AnalyseResult {

    /**
     * 特征字段
     */
    private String field;

    /**
     * true 符合API特征；false 符合普通站点特征
     */
    private Boolean isApiWeb;

    /**
     * 符合程度
     */
    private FeatureType coincidence;

    public AnalyseResult(String field) {
        this.field = field;
    }

    public void setApiWeb(Boolean isApiWeb) {
        this.isApiWeb = isApiWeb;
        this.coincidence = FeatureType.COMMON;
    }
}