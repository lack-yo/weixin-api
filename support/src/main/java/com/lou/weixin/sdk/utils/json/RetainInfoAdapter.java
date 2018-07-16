package com.lou.weixin.sdk.utils.json;

import com.google.gson.*;
import com.google.gson.internal.Streams;
import com.google.gson.stream.JsonReader;
import com.lou.weixin.sdk.bean.result.weapp.RetainInfo;
import com.lou.weixin.sdk.utils.GsonConvertUtil;

import java.io.StringReader;
import java.lang.reflect.Type;

/**
 * 小程序用户留存数据Gson适配
 *
 * @author loufeng
 * @date 2018/7/9 下午3:09.
 */
public class RetainInfoAdapter implements JsonDeserializer<RetainInfo> {

    @Override
    public RetainInfo deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
            throws JsonParseException {
        JsonObject o = json.getAsJsonObject();
        RetainInfo ri = new RetainInfo();
        ri.setRefDate(GsonConvertUtil.getString(o, "ref_date"));
        JsonArray uvNew = o.get("visit_uv_new").getAsJsonArray();
        if (uvNew.size() > 0) {
            ri.setVisitUvNew(o.get("visit_uv_new").toString());
        }
        JsonArray uv = o.get("visit_uv").getAsJsonArray();
        if (uv.size() > 0) {
            ri.setVisitUv(o.get("visit_uv").toString());
        }
        return ri;
    }

    public static void main(String[] args) {
        String str = "{\n" +
                "  \"ref_date\": \"20170313\",\n" +
                "  \"visit_uv_new\": [\n" +
                "    {\n" +
                "      \"key\": 0,\n" +
                "      \"value\": 5464\n" +
                "    }\n" +
                "  ],\n" +
                "  \"visit_uv\": [\n" +
                "    {\n" +
                "      \"key\": 0,\n" +
                "      \"value\": 55500\n" +
                "    }\n" +
                "  ]\n" +
                "}";
        JsonElement json = Streams.parse(new JsonReader(new StringReader(str)));
        JsonObject o = json.getAsJsonObject();
        RetainInfo ri = new RetainInfo();
        ri.setRefDate(o.get("ref_date").toString());
        ri.setVisitUvNew(o.get("visit_uv_new").toString());
        ri.setVisitUv(o.get("visit_uv").toString());
    }

}
