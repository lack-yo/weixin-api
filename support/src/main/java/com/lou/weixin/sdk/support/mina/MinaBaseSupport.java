package com.lou.weixin.sdk.support.mina;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import com.google.gson.JsonObject;
import com.lou.weixin.sdk.exception.WxErrorException;
import com.lou.weixin.sdk.utils.http.WxHttpUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.util.Map;

/**
 * 小程序基础API基础
 *
 * @author loufeng
 * @date 2018/7/5 上午10:16.
 */
@SuppressWarnings("unused")
public class MinaBaseSupport {
    private static final Logger LOGGER = LoggerFactory.getLogger(MinaBaseSupport.class);
    /**
     * 获取小程序码
     */
    private static final String URL_WXACODE_GET = "https://api.weixin.qq.com/wxa/getwxacode?access_token=ACCESS_TOKEN";
    /**
     * 获取临时场景小程序码
     */
    private static final String URL_WXACODE_LIMIT_GET = "https://api.weixin.qq.com/wxa/getwxacodeunlimit?access_token=ACCESS_TOKEN";
    /**
     * 绑定小程序
     */
    private static final String URL_PLATFORM_BIND = "https://api.weixin.qq.com/cgi-bin/open/bind?access_token=ACCESS_TOKEN";
    /**
     * 创建开放平台
     */
    private static final String URL_PLATFORM_CREATE = "https://api.weixin.qq.com/cgi-bin/open/create?access_token=ACCESS_TOKEN";
    /**
     * 解绑小程序
     */
    private static final String URL_PLATFORM_UNBIND = "https://api.weixin.qq.com/cgi-bin/open/unbind?access_token=ACCESS_TOKEN";
    /**
     * 获取绑定的开放平台
     */
    private static final String URL_PLATFORM_GET = "https://api.weixin.qq.com/cgi-bin/open/get?access_token=ACCESS_TOKEN";


    /**
     * 获取小程序码
     *
     * @param token 小程序token
     * @param path  小程序页面路径
     * @return 小程序码地址
     * @throws WxErrorException 微信错误
     */
    public static InputStream getWxaCodeUrl(String token, String path) throws WxErrorException {
        String url = URL_WXACODE_GET.replace("ACCESS_TOKEN", token);
        JsonObject params = new JsonObject();
        params.addProperty("path", path);
        return WxHttpUtil.postDownload(url, params);
    }

    /**
     * 获取小程序码
     *
     * @param token   小程序token
     * @param sceneId 场景id
     * @param path    小程序页面路径
     * @param width   小程序码宽度
     * @param rgb     小程序码颜色
     * @return 小程序码url
     * @throws WxErrorException 微信错误
     */
    public static InputStream getSceneQrcode(
            String token,
            String sceneId,
            String path,
            int width,
            Map<String, String> rgb
    ) throws WxErrorException {
        String url = URL_WXACODE_LIMIT_GET.replace("ACCESS_TOKEN", token);
        Map<String, Object> params = Maps.newHashMap();
        params.put("scene", sceneId);
        if (StringUtils.isNotBlank(path)) {
            //默认是主页
            params.put("page", path);
        }
        params.put("width", width);
        params.put("auto_color", false);
        params.put("line_color", rgb);
        return WxHttpUtil.postDownload(url, params);
    }

    /**
     * 绑定开放平台
     *
     * @param appId     小程序
     * @param token     小程序token
     * @param openAppId 开放平台
     * @throws WxErrorException 微信错误
     */
    public static void bindPlatform(String appId, String token, String openAppId) throws WxErrorException {
        String url = URL_PLATFORM_BIND.replace("ACCESS_TOKEN", token);
        JsonObject params = new JsonObject();
        params.addProperty("appid", appId);
        params.addProperty("open_appid", openAppId);
        String result = WxHttpUtil.post(url, params);
        LOGGER.info("绑定小程序结果，appId：" + appId + ",result: " + result);
    }

    /**
     * 绑定开放平台
     *
     * @param appId 小程序id
     * @param token 小程序token
     * @return 开放平台id
     * @throws WxErrorException 微信错误
     */
    public static String createPlatform(String appId, String token) throws WxErrorException {
        String url = URL_PLATFORM_CREATE.replace("ACCESS_TOKEN", token);
        JsonObject params = new JsonObject();
        params.addProperty("appid", appId);
        String result = WxHttpUtil.post(url, params);
        LOGGER.info("创建结果，appId：" + appId + ",result: " + result);
        JSONObject json = JSON.parseObject(result);
        return json.getString("open_appid");
    }

    /**
     * 解绑开放平台小程序
     *
     * @param appId     小程序id
     * @param token     小程序token
     * @param openAppId 开放平台id
     * @throws WxErrorException 微信错误
     */
    public static void unBindPlatform(String appId, String token, String openAppId) throws WxErrorException {
        String url = URL_PLATFORM_UNBIND.replace("ACCESS_TOKEN", token);
        JsonObject params = new JsonObject();
        params.addProperty("appid", appId);
        params.addProperty("open_appid", openAppId);
        String result = WxHttpUtil.post(url, params);
        LOGGER.info("解绑小程序信息，appId：" + appId + ",result: " + result);
    }

    /**
     * 获取绑定的开放平台
     *
     * @param appId 小程序id
     * @param token 小程序token
     * @return 开放平台
     * @throws WxErrorException 微信错误
     */
    public static String getBindPlatform(String appId, String token) throws WxErrorException {
        String url = URL_PLATFORM_GET.replace("ACCESS_TOKEN", token);
        JsonObject params = new JsonObject();
        params.addProperty("appid", appId);
        String result = WxHttpUtil.post(url, params);
        LOGGER.info("获取绑定小程序信息，appId：" + appId + ",result: " + result);
        JSONObject json = JSON.parseObject(result);
        return json.getString("open_appid");
    }
}
