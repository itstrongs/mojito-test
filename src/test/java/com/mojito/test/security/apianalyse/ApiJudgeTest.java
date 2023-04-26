package com.mojito.test.security.apianalyse;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.ReadListener;
import com.alibaba.excel.util.ListUtils;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.List;

/**
 * API安全预研：判断输入数据是否是API站点
 *
 * @author liufq
 * @since 2023-04-25 09:20:57
 */
@Slf4j
public class ApiJudgeTest {

    @Test
    public void test() {
        ApiAnalyseModel analyseModel = new ApiAnalyseModel();
        InputStream stream = this.getClass().getResourceAsStream("/原始日志.xls");
        EasyExcel.read(stream, WebInfoBo.class, new WebInfoListener(analyseModel)).sheet().doRead();
    }

    public static class WebInfoListener implements ReadListener<WebInfoBo> {

        private static final int BATCH_COUNT = 100;

        private List<WebInfoBo> cachedDataList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);

        private final ApiAnalyseModel analyseModel;

        public WebInfoListener(ApiAnalyseModel analyseModel) {
            this.analyseModel = analyseModel;
        }

        @Override
        public void invoke(WebInfoBo webInfoBo, AnalysisContext analysisContext) {
            log.info(JSON.toJSONString(webInfoBo));
            cachedDataList.add(webInfoBo);
            if (cachedDataList.size() >= BATCH_COUNT) {
                cachedDataList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);
            }
            analyseModel.analyse(webInfoBo);
        }

        @Override
        public void doAfterAllAnalysed(AnalysisContext analysisContext) {
            log.info("所有数据解析完成！");
            analyseModel.finish();
        }
    }
}
