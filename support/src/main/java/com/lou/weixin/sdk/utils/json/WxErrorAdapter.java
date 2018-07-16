package com.lou.weixin.sdk.utils.json;

import com.google.gson.*;
import com.lou.weixin.sdk.bean.WxError;
import com.lou.weixin.sdk.utils.GsonConvertUtil;

import java.lang.reflect.Type;

/**
 * 微信异常Gson适配
 *
 * @author loufeng
 * @date 2018/7/9 下午3:09.
 */
public class WxErrorAdapter implements JsonDeserializer<WxError> {

    @Override
    public WxError deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
            throws JsonParseException {
        WxError error = new WxError();
        JsonObject errorJson = json.getAsJsonObject();

        if (errorJson.get("errcode") != null && !errorJson.get("errcode").isJsonNull()) {
            error.setErrcode(GsonConvertUtil.getAsInteger(errorJson.get("errcode")));
        }
        if (errorJson.get("errmsg") != null && !errorJson.get("errmsg").isJsonNull()) {
            error.setErrmsg(GsonConvertUtil.getAsString(errorJson.get("errmsg")));
        }

        error.setJson(json.toString());
        return error;
    }

}
