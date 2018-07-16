package com.lou.weixin.sdk.utils.json;

import com.google.gson.*;
import com.lou.weixin.sdk.bean.result.WxToken;
import com.lou.weixin.sdk.utils.GsonConvertUtil;

import java.lang.reflect.Type;

/**
 * 公众号令牌Gson适配
 *
 * @author loufeng
 * @date 2018/7/9 下午3:09.
 */
public class WxTokenAdapter implements JsonDeserializer<WxToken> {

    @Override
    public WxToken deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
            throws JsonParseException {
        WxToken token = new WxToken();
        JsonObject tokenJson = json.getAsJsonObject();

        if (tokenJson.get("access_token") != null && !tokenJson.get("access_token").isJsonNull()) {
            token.setToken(GsonConvertUtil.getAsString(tokenJson.get("access_token")));
        }
        if (tokenJson.get("expires_in") != null && !tokenJson.get("expires_in").isJsonNull()) {
            token.setExpiresIn(GsonConvertUtil.getAsInteger(tokenJson.get("expires_in")));
        }
        return token;
    }

}
