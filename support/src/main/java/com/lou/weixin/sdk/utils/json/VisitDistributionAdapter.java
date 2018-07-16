package com.lou.weixin.sdk.utils.json;

import com.google.common.collect.Lists;
import com.google.gson.*;
import com.google.gson.internal.Streams;
import com.google.gson.stream.JsonReader;
import com.lou.weixin.sdk.bean.result.weapp.BaseDistributionItem;
import com.lou.weixin.sdk.bean.result.weapp.IndexDistribution;
import com.lou.weixin.sdk.bean.result.weapp.VisitDistributionResult;
import com.lou.weixin.sdk.utils.GsonConvertUtil;

import java.io.StringReader;
import java.lang.reflect.Type;
import java.util.List;

/**
 * 浏览分布数据适配
 *
 * @author loufeng
 * @date 2017/11/30 下午2:09.
 */
public class VisitDistributionAdapter implements JsonDeserializer<VisitDistributionResult> {
    private final String TYPE_SOURCE = "access_source_session_cnt";
    private final String TYPE_DEPTH = "access_staytime_info";
    private final String TYPE_TIME = "access_depth_info";

    @Override
    public VisitDistributionResult deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
            throws JsonParseException {
        JsonObject o = json.getAsJsonObject();
        VisitDistributionResult vd = new VisitDistributionResult();
        vd.setRefDate(GsonConvertUtil.getString(o, "ref_date"));
        JsonArray list = o.get("list").getAsJsonArray();
        List<IndexDistribution> indexDistributionList = Lists.newArrayList();
        for (JsonElement e : list) {
            JsonObject temp = e.getAsJsonObject();
            String index = GsonConvertUtil.getString(temp, "index");
            JsonArray array = temp.getAsJsonArray("item_list");
            List<BaseDistributionItem> baseList = Lists.newArrayList();
            for (JsonElement f : array) {
                BaseDistributionItem baseDistributionItem = new BaseDistributionItem();
                JsonObject ff = f.getAsJsonObject();
                baseDistributionItem.setKey(GsonConvertUtil.getInteger(ff, "key"));
                baseDistributionItem.setValue(GsonConvertUtil.getInteger(ff, "value"));
                baseList.add(baseDistributionItem);
            }
            IndexDistribution indexDistribution = new IndexDistribution(index, baseList);
            indexDistributionList.add(indexDistribution);
        }
        vd.setIndexDistributionList(indexDistributionList);
        return vd;
    }

    public static void main(String[] args) {
        String str = "{\n" +
                "  \"ref_date\": \"20170313\",\n" +
                "  \"list\": [\n" +
                "    {\n" +
                "      \"index\": \"access_source_session_cnt\",\n" +
                "      \"item_list\": [\n" +
                "        {\n" +
                "          \"key\": 10,\n" +
                "          \"value\": 5\n" +
                "        },\n" +
                "        {\n" +
                "          \"key\": 8,\n" +
                "          \"value\": 687\n" +
                "        },\n" +
                "        {\n" +
                "          \"key\": 7,\n" +
                "          \"value\": 10740\n" +
                "        },\n" +
                "        {\n" +
                "          \"key\": 6,\n" +
                "          \"value\": 1961\n" +
                "        },\n" +
                "        {\n" +
                "          \"key\": 5,\n" +
                "          \"value\": 677\n" +
                "        },\n" +
                "        {\n" +
                "          \"key\": 4,\n" +
                "          \"value\": 653\n" +
                "        },\n" +
                "        {\n" +
                "          \"key\": 3,\n" +
                "          \"value\": 1120\n" +
                "        },\n" +
                "        {\n" +
                "          \"key\": 2,\n" +
                "          \"value\": 10243\n" +
                "        },\n" +
                "        {\n" +
                "          \"key\": 1,\n" +
                "          \"value\": 116578\n" +
                "        }\n" +
                "      ]\n" +
                "    },\n" +
                "    {\n" +
                "      \"index\": \"access_staytime_info\",\n" +
                "      \"item_list\": [\n" +
                "        {\n" +
                "          \"key\": 8,\n" +
                "          \"value\": 16329\n" +
                "        },\n" +
                "        {\n" +
                "          \"key\": 7,\n" +
                "          \"value\": 19322\n" +
                "        },\n" +
                "        {\n" +
                "          \"key\": 6,\n" +
                "          \"value\": 21832\n" +
                "        },\n" +
                "        {\n" +
                "          \"key\": 5,\n" +
                "          \"value\": 19539\n" +
                "        },\n" +
                "        {\n" +
                "          \"key\": 4,\n" +
                "          \"value\": 29670\n" +
                "        },\n" +
                "        {\n" +
                "          \"key\": 3,\n" +
                "          \"value\": 19667\n" +
                "        },\n" +
                "        {\n" +
                "          \"key\": 2,\n" +
                "          \"value\": 11794\n" +
                "        },\n" +
                "        {\n" +
                "          \"key\": 1,\n" +
                "          \"value\": 4511\n" +
                "        }\n" +
                "      ]\n" +
                "    },\n" +
                "    {\n" +
                "      \"index\": \"access_depth_info\",\n" +
                "      \"item_list\": [\n" +
                "        {\n" +
                "          \"key\": 5,\n" +
                "          \"value\": 217\n" +
                "        },\n" +
                "        {\n" +
                "          \"key\": 4,\n" +
                "          \"value\": 3259\n" +
                "        },\n" +
                "        {\n" +
                "          \"key\": 3,\n" +
                "          \"value\": 32445\n" +
                "        },\n" +
                "        {\n" +
                "          \"key\": 2,\n" +
                "          \"value\": 63542\n" +
                "        },\n" +
                "        {\n" +
                "          \"key\": 1,\n" +
                "          \"value\": 43201\n" +
                "        }\n" +
                "      ]\n" +
                "    }\n" +
                "  ]\n" +
                "}";
        JsonElement json = Streams.parse(new JsonReader(new StringReader(str)));
    }

}
