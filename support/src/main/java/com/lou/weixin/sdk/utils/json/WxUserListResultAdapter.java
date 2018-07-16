package com.lou.weixin.sdk.utils.json;

import com.google.common.collect.Lists;
import com.google.gson.*;
import com.lou.weixin.sdk.bean.result.WxUserListResult;

import java.lang.reflect.Type;
import java.util.List;

/**
 * @author loufeng
 * @date 2018/7/13 上午11:11.
 */
public class WxUserListResultAdapter implements JsonDeserializer<WxUserListResult> {
    @Override
    public WxUserListResult deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        WxUserListResult result = new WxUserListResult();
        JsonObject o = jsonElement.getAsJsonObject();
        int count = o.get("count").getAsInt();
        result.setCount(count);
        JsonObject data = o.get("data").getAsJsonObject();
        JsonArray array = data.get("openid").getAsJsonArray();
        List<String> openids = Lists.newArrayList();
        for (JsonElement e : array) {
            String id = e.getAsString();
            openids.add(id);
        }
        WxUserListResult.OpenIdArray openIdArray = new WxUserListResult.OpenIdArray();
        openIdArray.setOpenid(openids);
        result.setData(openIdArray);
        String nextOpenid = o.get("next_openid").getAsString();
        result.setNextOpenid(nextOpenid);
        int total = o.get("total").getAsInt();
        result.setTotal(total);
        return result;
    }
}
