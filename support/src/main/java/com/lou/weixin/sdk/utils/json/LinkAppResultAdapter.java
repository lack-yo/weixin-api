package com.lou.weixin.sdk.utils.json;

import com.google.common.collect.Lists;
import com.google.gson.*;
import com.lou.weixin.sdk.bean.result.LinkApp;
import com.lou.weixin.sdk.bean.result.LinkAppResult;

import java.lang.reflect.Type;
import java.util.List;

/**
 * 公众号关联小程序信息Gson适配
 *
 * @author loufeng
 * @date 2018/7/9 下午3:09.
 */
public class LinkAppResultAdapter implements JsonDeserializer<LinkAppResult> {

    @Override
    public LinkAppResult deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
            throws JsonParseException {
        JsonObject o = json.getAsJsonObject();
        LinkAppResult la = new LinkAppResult();
        JsonObject item = o.get("wxopens").getAsJsonObject();
        JsonArray array = item.get("items").getAsJsonArray();
        List<LinkApp> list = Lists.newArrayList();
        for (JsonElement j : array) {
            JsonObject temp = j.getAsJsonObject();
            LinkApp linkApp = new LinkApp();
            if (temp.get("email") != null) {
                linkApp.setEmail(temp.get("email").getAsString());
            }
            if (temp.get("nearby_display_status") != null) {
                linkApp.setNearbyDisplay(temp.get("nearby_display_status").getAsBoolean());
            }
            if (temp.get("nickname") != null) {
                linkApp.setNickname(temp.get("nickname").getAsString());
            }
            if (temp.get("released") != null) {
                linkApp.setReleased(temp.get("released").getAsBoolean());
            }
            if (temp.get("selected") != null) {
                linkApp.setSelected(temp.get("selected").getAsBoolean());
            }
            if (temp.get("username") != null) {
                linkApp.setUsername(temp.get("username").getAsString());
            }
            if (temp.get("status") != null) {
                linkApp.setStatus(temp.get("status").getAsInt());
            }
            list.add(linkApp);
        }
        la.setItems(list);
        return la;
    }


}
