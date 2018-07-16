package com.lou.weixin.sdk.utils.json;

import com.google.gson.*;
import com.lou.weixin.sdk.bean.result.Oauth2TokenResult;

import java.lang.reflect.Type;

/**
 * 网页授权适配
 * https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1421140842
 *
 * @author loufeng
 * @date 2018/7/13 上午11:21.
 */
public class Oauth2TokenResultAdapter implements JsonDeserializer<Oauth2TokenResult> {
    @Override
    public Oauth2TokenResult deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject o = jsonElement.getAsJsonObject();
        Oauth2TokenResult result = new Oauth2TokenResult();
        String accessToken = o.get("access_token").getAsString();
        result.setAccessToken(accessToken);
        String expires = o.get("expires_in").getAsString();
        result.setExpiresIn(expires);
        String openid = o.get("openid").getAsString();
        result.setOpenid(openid);
        String refreshToken = o.get("refresh_token").getAsString();
        result.setRefreshToken(refreshToken);
        String scope = o.get("scope").getAsString();
        result.setScope(scope);
        return result;
    }
}
