package com.mojito.test.security;

import com.alibaba.excel.util.StringUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mojito.test.utils.FileUtils;
import com.mojito.test.utils.log;
import lombok.Data;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

/**
 * @author liufq
 * @since 2023-04-26 13:54:24
 */
public class Test20230427 {

    @Test
    public void test() throws IOException {
        String json = FileUtils.getString("增加sla值-预发.json");
//        String json = FileUtils.getString("增加sla值-MSS.json");
//        String json = FileUtils.getString("增加sla值-国信.json");
        List<SlaUpdate> slaUpdates = JSON.parseArray(json, SlaUpdate.class);
        for (SlaUpdate slaUpdate : slaUpdates) {
            JSONArray jsonArray = JSON.parseArray(slaUpdate.getExtend_column());

            String sla = null;
            String weight = null;
            for (int i = 0; i < jsonArray.size(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                if ("sla".equals(jsonObject.getString("columnAlis"))) {
                    String content = jsonObject.getString("content");

                    if (!content.contains("ceil")) {
                        sla = content;
                    } else {
                        String str = "ceil";
                        String substring = content.substring(content.indexOf(str) + str.length() + 1);
                        sla = substring.split("\\*")[0].trim();
                        weight = substring.split("\\*")[1].split("\\+")[0].trim();
                    }
                }
            }

            JSONObject rule_sla = JSON.parseObject("{\"columnAlis\":\"rule_sla\",\"extendColumnType\":\"TEMPLATE\"}");
            rule_sla.put("content", sla);
            jsonArray.add(rule_sla);

            if (StringUtils.isNotBlank(weight)) {
                JSONObject weightJSON = JSON.parseObject("{\"columnAlis\":\"rule_sla_weight\",\"extendColumnType\":\"TEMPLATE\"}");
                weightJSON.put("content", weight);
                jsonArray.add(weightJSON);
            }

            assert sla != null;
            String slqSql = "";
            if (!Integer.valueOf(sla).equals(slaUpdate.getSla())) {
                slqSql = String.format(", sla=%s", sla);
            }

            String extend_column = JSON.toJSONString(jsonArray);
            extend_column = extend_column.replace("'", "\\'");
            log.info(String.format("update analysis_model_table set extend_column='%s'%s where id='%s';",
                    extend_column, slqSql, slaUpdate.getId()));
        }
    }

    @Data
    public static class SlaUpdate {

        private String id;

        private Integer sla;

        private String extend_column;
    }
}
