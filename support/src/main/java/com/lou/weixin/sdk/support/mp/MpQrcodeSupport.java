package com.lou.weixin.sdk.support.mp;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.internal.Streams;
import com.google.gson.stream.JsonReader;
import com.lou.weixin.sdk.bean.result.WxQrCodeTicket;
import com.lou.weixin.sdk.exception.WxErrorException;
import com.lou.weixin.sdk.utils.http.WxHttpUtil;

import java.io.StringReader;

/**
 * @author loufeng
 * @date 2018/7/5 上午10:17.
 */
@SuppressWarnings("unused")
public class MpQrcodeSupport {
    /**
     * 二维码ticket创建接口
     * 注意,坑爹微信原始接口是https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=TOKEN
     * 为了统一，将TOKEN改为ACCESS_TOKEN
     **/
    private static final String QRCODE_CREATE_URL = "https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=ACCESS_TOKEN";
    /**
     * 长链接转化为短链接
     **/
    private static final String SHORT_URL = "https://api.weixin.qq.com/cgi-bin/shorturl?access_token=ACCESS_TOKEN";


    /**
     * 创建临时二维码
     *
     * @param token         公众号token
     * @param sceneId       场景值
     * @param expireSeconds 过期时间，以秒为单位。 最大不超过1800
     * @return 结果
     * @throws WxErrorException error
     */
    public static WxQrCodeTicket qrCodeCreateTmpTicket(String token, Integer sceneId, Integer expireSeconds)
            throws WxErrorException {
        String url = QRCODE_CREATE_URL.replace("ACCESS_TOKEN", token);
        JsonObject json = new JsonObject();
        json.addProperty("action_name", "QR_SCENE");
        if (expireSeconds != null) {
            json.addProperty("expire_seconds", expireSeconds);
        }
        JsonObject actionInfo = new JsonObject();
        JsonObject scene = new JsonObject();
        scene.addProperty("scene_id", sceneId);
        actionInfo.add("scene", scene);
        json.add("action_info", actionInfo);
        String responseContent = WxHttpUtil.post(url, json);
        return WxQrCodeTicket.fromJson(responseContent);
    }

    /**
     * 永久二维码
     *
     * @param token   公众号token
     * @param sceneId 场景值
     * @return 结果
     * @throws WxErrorException error
     */
    public static WxQrCodeTicket qrCodeCreateLastTicket(String token, Integer sceneId) throws WxErrorException {
        String url = QRCODE_CREATE_URL.replace("ACCESS_TOKEN", token);
        JsonObject json = new JsonObject();
        json.addProperty("action_name", "QR_LIMIT_SCENE");
        JsonObject actionInfo = new JsonObject();
        JsonObject scene = new JsonObject();
        scene.addProperty("scene_id", sceneId);
        actionInfo.add("scene", scene);
        json.add("action_info", actionInfo);
        String responseContent = WxHttpUtil.post(url, json);
        return WxQrCodeTicket.fromJson(responseContent);
    }

    /**
     * 长链接转短链接
     *
     * @param token   公众号token
     * @param longUrl 链接
     * @return 结果
     * @throws WxErrorException error
     */
    public static String shortUrl(String token, String longUrl) throws WxErrorException {
        String url = SHORT_URL.replace("ACCESS_TOKEN", token);
        JsonObject o = new JsonObject();
        o.addProperty("action", "long2short");
        o.addProperty("long_url", longUrl);
        String responseContent = WxHttpUtil.post(url, o);
        JsonElement tmpJsonElement = Streams.parse(new JsonReader(new StringReader(responseContent)));
        return tmpJsonElement.getAsJsonObject().get("short_url").getAsString();
    }
}
