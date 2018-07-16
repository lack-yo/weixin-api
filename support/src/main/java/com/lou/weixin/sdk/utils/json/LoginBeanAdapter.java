package com.lou.weixin.sdk.utils.json;

import com.google.gson.*;
import com.lou.weixin.sdk.bean.LoginBean;
import com.lou.weixin.sdk.utils.GsonConvertUtil;

import java.lang.reflect.Type;

/**
 * 小程序登录bean Gson适配
 *
 * @author loufeng
 * @date 2018/7/9 下午3:09.
 */
public class LoginBeanAdapter implements JsonDeserializer<LoginBean> {

    @Override
    public LoginBean deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
            throws JsonParseException {
        JsonObject o = json.getAsJsonObject();
        LoginBean login = new LoginBean();
        login.setOpenid(GsonConvertUtil.getString(o, "openid"));
        login.setSessionKey(GsonConvertUtil.getString(o, "session_key"));
        login.setUnionId(GsonConvertUtil.getString(o, "unionid"));
        return login;
    }

}
