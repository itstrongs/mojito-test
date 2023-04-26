package com.mojito.test.security.apianalyse;

/**
 * @author liufq
 * @since 2023-04-25 10:48:08
 */
public enum FeatureType {

//    /**
//     * 符合API站点特征
//     */
//    API,
//
//    /**
//     * 符合普通站点特征
//     */
//    COMMON,
//
//    /**
//     * 大概率是普通站点
//     */
//    LARGE_COMMON,

    /**
     * 一般
     */
    COMMON,

    /**
     * 大概率
     */
    MATCH,

    /**
     * 肯定符合
     */
    MUST,
}
