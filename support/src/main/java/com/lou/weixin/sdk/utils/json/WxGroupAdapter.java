package com.lou.weixin.sdk.utils.json;

import com.google.gson.*;
import com.lou.weixin.sdk.bean.WxGroup;
import com.lou.weixin.sdk.utils.GsonConvertUtil;

import java.lang.reflect.Type;

/**
 * 公众号用户组Gson适配
 *
 * @author loufeng
 * @date 2018/7/9 下午3:09.
 */
public class WxGroupAdapter implements JsonSerializer<WxGroup>, JsonDeserializer<WxGroup> {

    @Override
    public WxGroup deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
            throws JsonParseException {
        WxGroup group = new WxGroup();
        JsonObject groupJson = json.getAsJsonObject();
        if (json.getAsJsonObject().get("group") != null) {
            groupJson = json.getAsJsonObject().get("group").getAsJsonObject();
        }
        if (groupJson.get("name") != null && !groupJson.get("name").isJsonNull()) {
            group.setName(GsonConvertUtil.getAsString(groupJson.get("name")));
        }
        if (groupJson.get("id") != null && !groupJson.get("id").isJsonNull()) {
            group.setId(GsonConvertUtil.getAsPrimitiveLong(groupJson.get("id")));
        }
        if (groupJson.get("count") != null && !groupJson.get("count").isJsonNull()) {
            group.setCount(GsonConvertUtil.getAsPrimitiveLong(groupJson.get("count")));
        }
        return group;
    }

    @Override
    public JsonElement serialize(WxGroup group, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject json = new JsonObject();
        JsonObject groupJson = new JsonObject();
        groupJson.addProperty("name", group.getName());
        groupJson.addProperty("id", group.getId());
        groupJson.addProperty("count", group.getCount());
        json.add("group", groupJson);
        return json;
    }

}
