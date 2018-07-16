package com.lou.weixin.sdk.utils.json;

import com.google.common.collect.Lists;
import com.google.gson.*;
import com.lou.weixin.sdk.bean.result.WxUserAnalyzeResult4Summary;
import com.lou.weixin.sdk.bean.result.WxUserSummaryResult;

import java.lang.reflect.Type;
import java.util.List;

/**
 * 用户增减数据适配
 *
 * @author loufeng
 * @date 2018/7/13 上午9:53.
 */
public class WxUserAnalyzeResult4SummaryAdapter implements JsonDeserializer<WxUserAnalyzeResult4Summary> {
    @Override
    public WxUserAnalyzeResult4Summary deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject o = jsonElement.getAsJsonObject();
        JsonArray array = o.get("list").getAsJsonArray();
        List<WxUserSummaryResult> list = Lists.newArrayList();
        if (array.size() == 0) {
            return null;
        }
        for (JsonElement e : array) {
            JsonObject temp = e.getAsJsonObject();
            WxUserSummaryResult detail = new WxUserSummaryResult();
            String refDate = temp.get("ref_date").getAsString();
            detail.setRefDate(refDate);
            String userSource = temp.get("user_source").getAsString();
            detail.setUserSource(userSource);
            int newUser = temp.get("new_user").getAsInt();
            detail.setNewUser(newUser);
            int cancelUser = temp.get("cancel_user").getAsInt();
            detail.setCancelUser(cancelUser);
            list.add(detail);
        }
        WxUserAnalyzeResult4Summary result4Summary = new WxUserAnalyzeResult4Summary();
        result4Summary.setList(list);
        return result4Summary;
    }
}
