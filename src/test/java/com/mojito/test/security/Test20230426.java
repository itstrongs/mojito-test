package com.mojito.test.security;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mojito.test.utils.log;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * 更新sla表达式
 *
 * @author liufq
 * @since 2023-03-30 15:28:09
 */
public class Test20230426 {

    @Test
    public void test() throws IOException {
        InputStream path = this.getClass().getResourceAsStream("/sla-国信.txt");
        assert path != null;
        BufferedReader reader = new BufferedReader(new InputStreamReader(path));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] split = line.split("\t");
            JSONArray jsonArray = JSON.parseArray(split[1]);
            for (int i = 0; i < jsonArray.size(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                if ("sla".equals(jsonObject.getString("columnAlis"))) {
                    String content = jsonObject.getString("content");
                    String temp = content.substring(3, content.length() - 1);

                    String[] tempSplit = temp.split(",");
                    String fun = tempSplit[tempSplit.length - 1];
                    String newContent = String.format("if(%s, %s, %s)", "asset_sla=3", fun.replace("ceil", "round"), fun);
                    jsonObject.put("content", newContent);
                }
            }
            // 更新脚本
            log.info(String.format("update analysis_model_table set extend_column='%s' where id='%s';", jsonArray.toJSONString(), split[0]));
            // 回退脚本
//            log.info(String.format("update analysis_model_table set extend_column='%s' where id='%s';", split[2], split[0]));
        }
    }
}
