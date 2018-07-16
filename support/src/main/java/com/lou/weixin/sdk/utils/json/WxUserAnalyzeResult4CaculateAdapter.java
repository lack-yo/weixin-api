package com.lou.weixin.sdk.utils.json;

import com.google.common.collect.Lists;
import com.google.gson.*;
import com.lou.weixin.sdk.bean.result.WxUserAnalyzeResult4Calculate;
import com.lou.weixin.sdk.bean.result.WxUserCumulateResult;

import java.lang.reflect.Type;
import java.util.List;

/**
 * @author loufeng
 * @date 2018/7/13 上午9:47.
 */
public class WxUserAnalyzeResult4CaculateAdapter implements JsonDeserializer<WxUserAnalyzeResult4Calculate> {
    @Override
    public WxUserAnalyzeResult4Calculate deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject o = jsonElement.getAsJsonObject();
        JsonArray array = o.get("list").getAsJsonArray();
        List<WxUserCumulateResult> list = Lists.newArrayList();
        if (array.size() == 0) {
            return null;
        }
        for (JsonElement e : array) {
            WxUserCumulateResult detail = new WxUserCumulateResult();
            JsonObject temp = e.getAsJsonObject();
            String refDate = temp.get("ref_date").getAsString();
            detail.setRefDate(refDate);
            int cumulateUser = temp.get("cumulate_user").getAsInt();
            detail.setCumulateUser(cumulateUser);
            list.add(detail);
        }
        WxUserAnalyzeResult4Calculate result = new WxUserAnalyzeResult4Calculate();
        result.setList(list);
        return result;
    }
}
