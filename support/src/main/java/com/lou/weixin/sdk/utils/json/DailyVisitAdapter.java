package com.lou.weixin.sdk.utils.json;

import com.google.gson.*;
import com.google.gson.internal.Streams;
import com.google.gson.stream.JsonReader;
import com.lou.weixin.sdk.bean.result.weapp.DailyVisit;
import com.lou.weixin.sdk.utils.GsonConvertUtil;

import java.io.StringReader;
import java.lang.reflect.Type;

/**
 * 小程序访问数据Gson适配
 *
 * @author loufeng
 * @date 2018/7/9 下午3:09.
 */
public class DailyVisitAdapter implements JsonDeserializer<DailyVisit> {

    @Override
    public DailyVisit deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
            throws JsonParseException {
        JsonObject o = json.getAsJsonObject();
        JsonArray list = o.get("list").getAsJsonArray();
        if (list.size() == 0) {
            return null;
        }
        JsonObject item = list.get(0).getAsJsonObject();
        DailyVisit dv = new DailyVisit();
        dv.setRefDate(GsonConvertUtil.getString(item, "ref_date"));
        dv.setSessionCnt(GsonConvertUtil.getInteger(item, "session_cnt"));
        dv.setVisitPv(GsonConvertUtil.getInteger(item, "visit_pv"));
        dv.setVisitUv(GsonConvertUtil.getInteger(item, "visit_uv"));
        dv.setVisitUvNew(GsonConvertUtil.getInteger(item, "visit_uv_new"));
        dv.setStayTimeUv(GsonConvertUtil.getString(item, "stay_time_uv"));
        dv.setStayTimeSession(GsonConvertUtil.getString(item, "stay_time_session"));
        dv.setVisitDepth(GsonConvertUtil.getString(item, "visit_depth"));
        return dv;
    }

    public static void main(String[] args) {
        String str = "{\n" +
                "  \"list\": [\n" +
                "    {\n" +
                "      \"ref_date\": \"20170313\",\n" +
                "      \"session_cnt\": 142549,\n" +
                "      \"visit_pv\": 472351,\n" +
                "      \"visit_uv\": 55500,\n" +
                "      \"visit_uv_new\": 5464,\n" +
                "      \"stay_time_session\": 0,\n" +
                "      \"visit_depth\": 1.9838\n" +
                "    }\n" +
                "  ]\n" +
                "}";
        JsonElement json = Streams.parse(new JsonReader(new StringReader(str)));
    }

}
