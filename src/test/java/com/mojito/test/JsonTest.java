package com.mojito.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.mojito.test.utils.log;
import org.junit.jupiter.api.Test;

/**
 * @author liufq
 * @since 2023-05-09 16:23:45
 */
public class JsonTest {

    @Test
    public void test() {
        String json = "[[\\\"远程控制->恶意域名APT\\\",{\\\"id\\\":\\\"1575035868001255425\\\",\\\"model_name\\\":\\\"远程控制->恶意域名APT\\\",\\\"model_scope\\\":\\\"PUBLIC\\\",\\\"model_tenant\\\":\\\"[]\\\",\\\"white_list_tag\\\":\\\"0\\\",\\\"tags\\\":\\\"[\\\\\\\"GLOBAL_DEFAULT\\\\\\\"]\\\",\\\"model_content\\\":\\\"{\\\\\\\"filterFrontExprs\\\\\\\":\\\\\\\"{\\\\\\\\\\\\\\\"parent\\\\\\\\\\\\\\\":-1,\\\\\\\\\\\\\\\"children2\\\\\\\\\\\\\\\":[{\\\\\\\\\\\\\\\"parent\\\\\\\\\\\\\\\":0,\\\\\\\\\\\\\\\"children2\\\\\\\\\\\\\\\":[{\\\\\\\\\\\\\\\"parent\\\\\\\\\\\\\\\":1,\\\\\\\\\\\\\\\"children2\\\\\\\\\\\\\\\":[],\\\\\\\\\\\\\\\"querySqlStr\\\\\\\\\\\\\\\":\\\\\\\\\\\\\\\"\\\\\\\\\\\\\\\",\\\\\\\\\\\\\\\"children1\\\\\\\\\\\\\\\":[{\\\\\\\\\\\\\\\"parent\\\\\\\\\\\\\\\":2,\\\\\\\\\\\\\\\"querySqlStr\\\\\\\\\\\\\\\":\\\\\\\\\\\\\\\"direction-String=01\\\\\\\\\\\\\\\",\\\\\\\\\\\\\\\"level\\\\\\\\\\\\\\\":\\\\\\\\\\\\\\\"3\\\\\\\\\\\\\\\",\\\\\\\\\\\\\\\"name\\\\\\\\\\\\\\\":1664352788339,\\\\\\\\\\\\\\\"queryObj\\\\\\\\\\\\\\\":{\\\\\\\\\\\\\\\"selectText\\\\\\\\\\\\\\\":\\\\\\\\\\\\\\\"direction-String\\\\\\\\\\\\\\\",\\\\\\\\\\\\\\\"inputText\\\\\\\\\\\\\\\":\\\\\\\\\\\\\\\"01\\\\\\\\\\\\\\\",\\\\\\\\\\\\\\\"operation\\\\\\\\\\\\\\\":\\\\\\\\\\\\\\\"=\\\\\\\\\\\\\\\"},\\\\\\\\\\\\\\\"id\\\\\\\\\\\\\\\":\\\\\\\\\\\\\\\"2864506f3eae37c9931b98fee81ef605\\\\\\\\\\\\\\\",\\\\\\\\\\\\\\\"relation\\\\\\\\\\\\\\\":\\\\\\\\\\\\\\\"AND\\\\\\\\\\\\\\\"},{\\\\\\\\\\\\\\\"parent\\\\\\\\\\\\\\\":2,\\\\\\\\\\\\\\\"querySqlStr\\\\\\\\\\\\\\\":\\\\\\\\\\\\\\\"direction-String=00\\\\\\\\\\\\\\\",\\\\\\\\\\\\\\\"level\\\\\\\\\\\\\\\":\\\\\\\\\\\\\\\"3\\\\\\\\\\\\\\\",\\\\\\\\\\\\\\\"name\\\\\\\\\\\\\\\":1664352788339,\\\\\\\\\\\\\\\"queryObj\\\\\\\\\\\\\\\":{\\\\\\\\\\\\\\\"selectText\\\\\\\\\\\\\\\":\\\\\\\\\\\\\\\"direction-String\\\\\\\\\\\\\\\",\\\\\\\\\\\\\\\"inputText\\\\\\\\\\\\\\\":\\\\\\\\\\\\\\\"00\\\\\\\\\\\\\\\",\\\\\\\\\\\\\\\"operation\\\\\\\\\\\\\\\":\\\\\\\\\\\\\\\"=\\\\\\\\\\\\\\\"},\\\\\\\\\\\\\\\"id\\\\\\\\\\\\\\\":\\\\\\\\\\\\\\\"4c792d5facfefa129a8958f6c021845c\\\\\\\\\\\\\\\",\\\\\\\\\\\\\\\"relation\\\\\\\\\\\\\\\":\\\\\\\\\\\\\\\"AND\\\\\\\\\\\\\\\"}],\\\\\\\\\\\\\\\"level\\\\\\\\\\\\\\\":\\\\\\\\\\\\\\\"2\\\\\\\\\\\\\\\",\\\\\\\\\\\\\\\"name\\\\\\\\\\\\\\\":1664352788339,\\\\\\\\\\\\\\\"id\\\\\\\\\\\\\\\":\\\\\\\\\\\\\\\"aa7746e21b5ef1cbd94d01162f149b82\\\\\\\\\\\\\\\",\\\\\\\\\\\\\\\"relation\\\\\\\\\\\\\\\":\\\\\\\\\\\\\\\"OR\\\\\\\\\\\\\\\"}],\\\\\\\\\\\\\\\"querySqlStr\\\\\\\\\\\\\\\":\\\\\\\\\\\\\\\"\\\\\\\\\\\\\\\",\\\\\\\\\\\\\\\"children1\\\\\\\\\\\\\\\":[{\\\\\\\\\\\\\\\"parent\\\\\\\\\\\\\\\":1,\\\\\\\\\\\\\\\"querySqlStr\\\\\\\\\\\\\\\":\\\\\\\\\\\\\\\"alarmResults-String=OK\\\\\\\\\\\\\\\",\\\\\\\\\\\\\\\"level\\\\\\\\\\\\\\\":\\\\\\\\\\\\\\\"2\\\\\\\\\\\\\\\",\\\\\\\\\\\\\\\"name\\\\\\\\\\\\\\\":1664352788339,\\\\\\\\\\\\\\\"queryObj\\\\\\\\\\\\\\\":{\\\\\\\\\\\\\\\"selectText\\\\\\\\\\\\\\\":\\\\\\\\\\\\\\\"alarmResults-String\\\\\\\\\\\\\\\",\\\\\\\\\\\\\\\"inputText\\\\\\\\\\\\\\\":\\\\\\\\\\\\\\\"OK\\\\\\\\\\\\\\\",\\\\\\\\\\\\\\\"operation\\\\\\\\\\\\\\\":\\\\\\\\\\\\\\\"=\\\\\\\\\\\\\\\"},\\\\\\\\\\\\\\\"id\\\\\\\\\\\\\\\":\\\\\\\\\\\\\\\"807bde070cc1bc219d7e5c8899401c6c\\\\\\\\\\\\\\\",\\\\\\\\\\\\\\\"relation\\\\\\\\\\\\\\\":\\\\\\\\\\\\\\\"AND\\\\\\\\\\\\\\\"}],\\\\\\\\\\\\\\\"level\\\\\\\\\\\\\\\":\\\\\\\\\\\\\\\"1\\\\\\\\\\\\\\\",\\\\\\\\\\\\\\\"name\\\\\\\\\\\\\\\":1664352788339,\\\\\\\\\\\\\\\"id\\\\\\\\\\\\\\\":\\\\\\\\\\\\\\\"079a60ba746ca63d439736b4777acb1e\\\\\\\\\\\\\\\",\\\\\\\\\\\\\\\"relation\\\\\\\\\\\\\\\":\\\\\\\\\\\\\\\"AND\\\\\\\\\\\\\\\"}],\\\\\\\\\\\\\\\"querySqlStr\\\\\\\\\\\\\\\":\\\\\\\\\\\\\\\"\\\\\\\\\\\\\\\",\\\\\\\\\\\\\\\"children1\\\\\\\\\\\\\\\":[{\\\\\\\\\\\\\\\"parent\\\\\\\\\\\\\\\":0,\\\\\\\\\\\\\\\"querySqlStr\\\\\\\\\\\\\\\":\\\\\\\\\\\\\\\"subCategory-String=\\\\/SuspTraffic\\\\/MaliciousDomain\\\\\\\\\\\\\\\",\\\\\\\\\\\\\\\"level\\\\\\\\\\\\\\\":\\\\\\\\\\\\\\\"1\\\\\\\\\\\\\\\",\\\\\\\\\\\\\\\"name\\\\\\\\\\\\\\\":1664352788339,\\\\\\\\\\\\\\\"queryObj\\\\\\\\\\\\\\\":{\\\\\\\\\\\\\\\"selectText\\\\\\\\\\\\\\\":\\\\\\\\\\\\\\\"subCategory-String\\\\\\\\\\\\\\\",\\\\\\\\\\\\\\\"inputText\\\\\\\\\\\\\\\":\\\\\\\\\\\\\\\"\\\\/SuspTraffic\\\\/MaliciousDomain\\\\\\\\\\\\\\\",\\\\\\\\\\\\\\\"operation\\\\\\\\\\\\\\\":\\\\\\\\\\\\\\\"=\\\\\\\\\\\\\\\"},\\\\\\\\\\\\\\\"id\\\\\\\\\\\\\\\":\\\\\\\\\\\\\\\"cbb51305aa64f61bb5de542521e9d39c\\\\\\\\\\\\\\\",\\\\\\\\\\\\\\\"relation\\\\\\\\\\\\\\\":\\\\\\\\\\\\\\\"AND\\\\\\\\\\\\\\\"}],\\\\\\\\\\\\\\\"level\\\\\\\\\\\\\\\":\\\\\\\\\\\\\\\"0\\\\\\\\\\\\\\\",\\\\\\\\\\\\\\\"name\\\\\\\\\\\\\\\":1664352788339,\\\\\\\\\\\\\\\"id\\\\\\\\\\\\\\\":\\\\\\\\\\\\\\\"66485e31a74e4576c76e18b4f129b1de\\\\\\\\\\\\\\\",\\\\\\\\\\\\\\\"relation\\\\\\\\\\\\\\\":\\\\\\\\\\\\\\\"AND\\\\\\\\\\\\\\\"}\\\\\\\",\\\\\\\"filterGroup\\\\\\\":{\\\\\\\"logicType\\\\\\\":\\\\\\\"AND\\\\\\\",\\\\\\\"subExprs\\\\\\\":[{\\\\\\\"columnName\\\\\\\":\\\\\\\"subCategory\\\\\\\",\\\\\\\"columnType\\\\\\\":\\\\\\\"String\\\\\\\",\\\\\\\"compareType\\\\\\\":\\\\\\\"=\\\\\\\",\\\\\\\"value\\\\\\\":\\\\\\\"\\\\/SuspTraffic\\\\/MaliciousDomain\\\\\\\"}],\\\\\\\"subGroups\\\\\\\":[{\\\\\\\"logicType\\\\\\\":\\\\\\\"AND\\\\\\\",\\\\\\\"subExprs\\\\\\\":[{\\\\\\\"columnName\\\\\\\":\\\\\\\"alarmResults\\\\\\\",\\\\\\\"columnType\\\\\\\":\\\\\\\"String\\\\\\\",\\\\\\\"compareType\\\\\\\":\\\\\\\"=\\\\\\\",\\\\\\\"value\\\\\\\":\\\\\\\"OK\\\\\\\"}],\\\\\\\"subGroups\\\\\\\":[{\\\\\\\"logicType\\\\\\\":\\\\\\\"OR\\\\\\\",\\\\\\\"subExprs\\\\\\\":[{\\\\\\\"columnName\\\\\\\":\\\\\\\"direction\\\\\\\",\\\\\\\"columnType\\\\\\\":\\\\\\\"String\\\\\\\",\\\\\\\"compareType\\\\\\\":\\\\\\\"=\\\\\\\",\\\\\\\"value\\\\\\\":\\\\\\\"01\\\\\\\"},{\\\\\\\"columnName\\\\\\\":\\\\\\\"direction\\\\\\\",\\\\\\\"columnType\\\\\\\":\\\\\\\"String\\\\\\\",\\\\\\\"compareType\\\\\\\":\\\\\\\"=\\\\\\\",\\\\\\\"value\\\\\\\":\\\\\\\"00\\\\\\\"}],\\\\\\\"subGroups\\\\\\\":[]}]}]},\\\\\\\"sourceTableName\\\\\\\":\\\\\\\"dwd_detail_mss_ailpha_alert\\\\\\\"}\\\",\\\"filter_exprs\\\":\\\"( subCategory = '\\\\/SuspTraffic\\\\/MaliciousDomain' AND ( alarmResults = 'OK' AND ( direction = '01' OR direction = '00' )))\\\",\\\"model_confidence\\\":\\\"1\\\",\\\"model_type\\\":\\\"1\\\",\\\"model_description\\\":\\\"远程控制->恶意域名APT\\\",\\\"duplicate_removal_minute\\\":\\\"1\\\",\\\"duplicate_removal_interval\\\":\\\"1\\\",\\\"sql_version\\\":\\\"1\\\",\\\"advice\\\":\\\"监测内部主机172.16.48.133访问外部恶意地址pool.carteldesinaloa.ru，该主机疑似感染木马。请及时阻断连接拉黑恶意域名或IP并安装EDR对恶意程序进行查杀。\\\",\\\"sla\\\":\\\"3\\\"}]]";
        JSONArray jsonArray = JSON.parseArray(json);
        log.info(JSON.toJSONString(jsonArray));
    }
}
