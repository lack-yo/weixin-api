package com.lou.weixin.sdk.utils.json;

import com.google.gson.*;
import com.google.gson.internal.Streams;
import com.google.gson.stream.JsonReader;
import com.lou.weixin.sdk.bean.result.weapp.DailySummary;
import com.lou.weixin.sdk.utils.GsonConvertUtil;

import java.io.StringReader;
import java.lang.reflect.Type;

/**
 * 小程序访问概况Gson适配
 *
 * @author loufeng
 * @date 2018/7/9 下午3:09.
 */
public class DailySummaryAdapter implements JsonDeserializer<DailySummary> {

    @Override
    public DailySummary deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
            throws JsonParseException {
        JsonObject o = json.getAsJsonObject();
        JsonArray list = o.get("list").getAsJsonArray();
        if (list.size() == 0) {
            return null;
        }
        JsonObject item = list.get(0).getAsJsonObject();
        DailySummary ds = new DailySummary();
        ds.setRefDate(GsonConvertUtil.getString(item, "ref_date"));
        ds.setVisitTotal(GsonConvertUtil.getInteger(item, "visit_total"));
        ds.setSharePv(GsonConvertUtil.getInteger(item, "share_pv"));
        ds.setShareUv(GsonConvertUtil.getInteger(item, "share_uv"));
        return ds;
    }

    public static void main(String[] args) {
        String str = "{\n" +
                "  \"list\": [\n" +
                "    {\n" +
                "      \"ref_date\": \"20170313\",\n" +
                "      \"visit_total\": 391,\n" +
                "      \"share_pv\": 572,\n" +
                "      \"share_uv\": 383\n" +
                "    }\n" +
                "  ]\n" +
                "}";
        JsonElement json = Streams.parse(new JsonReader(new StringReader(str)));
    }

}
