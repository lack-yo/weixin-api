package com.lou.weixin.sdk.utils.json;

import com.google.gson.*;
import com.lou.weixin.sdk.bean.result.WxUser;
import com.lou.weixin.sdk.utils.GsonConvertUtil;

import java.lang.reflect.Type;

/**
 * 用户信息Gson适配
 *
 * @author loufeng
 * @date 2018/7/9 下午3:09.
 */
public class WxUserAdapter implements JsonDeserializer<WxUser> {

    @Override
    public WxUser deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
            throws JsonParseException {
        JsonObject o = json.getAsJsonObject();
        WxUser wxUser = new WxUser();
        wxUser.setSubscribe(GsonConvertUtil.getInteger(o, "subscribe"));
        wxUser.setCity(GsonConvertUtil.getString(o, "city"));
        wxUser.setCountry(GsonConvertUtil.getString(o, "country"));
        wxUser.setHeadImgUrl(GsonConvertUtil.getString(o, "headimgurl"));
        wxUser.setLanguage(GsonConvertUtil.getString(o, "language"));
        wxUser.setNickName(GsonConvertUtil.getString(o, "nickname"));
        wxUser.setOpenId(GsonConvertUtil.getString(o, "openid"));
        wxUser.setProvince(GsonConvertUtil.getString(o, "province"));
        wxUser.setSubscribeTime(GsonConvertUtil.getLong(o, "subscribe_time"));
        wxUser.setUnionId(GsonConvertUtil.getString(o, "unionid"));
        wxUser.setSex(GsonConvertUtil.getInteger(o, "sex"));
        return wxUser;
    }

}
