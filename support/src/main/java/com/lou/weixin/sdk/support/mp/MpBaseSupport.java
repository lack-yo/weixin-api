package com.lou.weixin.sdk.support.mp;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lou.weixin.sdk.bean.result.WxToken;
import com.lou.weixin.sdk.exception.WxErrorException;
import com.lou.weixin.sdk.utils.http.WxHttpUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * 公众号基础API集成
 *
 * @author loufeng
 * @date 2018/7/5 上午10:17.
 */
@SuppressWarnings("unused")
public class MpBaseSupport {
    private static final Logger LOGGER = LoggerFactory.getLogger(MpBaseSupport.class);
    /**
     * 获取access token接口
     **/
    private static final String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
    /**
     * 获取公众号/小程序所绑定的开放平台帐号
     */
    private static final String OPEN_PLATFORM_GET = "https://api.weixin.qq.com/cgi-bin/open/get?access_token=ACCESS_TOKEN";
    /**
     * 创建开放平台帐号并绑定公众号/小程序
     */
    private static final String OPEN_PLATFORM_CREATE = "https://api.weixin.qq.com/cgi-bin/open/create?access_token=ACCESS_TOKEN";
    /**
     * 将公众号/小程序绑定到开放平台帐号下
     */
    private static final String OPEN_PLATFORM_BIND = "https://api.weixin.qq.com/cgi-bin/open/bind?access_token=ACCESS_TOKEN";
    /**
     * 将公众号/小程序从开放平台帐号下解绑
     */
    private static final String OPEN_PLATFORM_UNBIND = "https://api.weixin.qq.com/cgi-bin/open/unbind?access_token=ACCESS_TOKEN";
    /**
     * 将公众号API次数清零
     */
    private static final String POST_CLEAR_QUOTA_URL = "https://api.weixin.qq.com/cgi-bin/clear_quota?access_token=ACCESS_TOKEN";


    /**
     * 获取开发者模式的token
     *
     * @param appId     公众号appId
     * @param appsecret 公众号密钥
     * @return token
     * @throws WxErrorException error
     */
    public static WxToken tokenAccess(String appId, String appsecret) throws WxErrorException {
        String url = ACCESS_TOKEN_URL.replace("APPID", appId).replace("APPSECRET", appsecret);
        String result = WxHttpUtil.get(url);
        return WxToken.fromJson(result);
    }

    /**
     * 获取公众号/小程序所绑定的开放平台帐号
     *
     * @param appId 公众号/小程序 appId
     * @param token 公众号token
     * @throws WxErrorException 微信异常
     */
    public static String getOpenPlatform(String appId, String token) throws WxErrorException {
        String url = OPEN_PLATFORM_GET.replace("ACCESS_TOKEN", token);
        Map<String, String> map = new HashMap<>(2);
        map.put("appid", appId);
        String result = WxHttpUtil.post(url, map);
        LOGGER.info("获取平台 appid，" + result);

        JSONObject json = JSON.parseObject(result);
        if (json != null) {
            return json.getString("open_appid");
        }
        return null;
    }

    /**
     * 创建开放平台帐号并绑定公众号/小程序
     *
     * @param appId 公众号/小程序 appId
     * @param token 公众号token
     * @throws WxErrorException 微信异常
     */
    public static String createOpenPlatform(String appId, String token) throws WxErrorException {
        String url = OPEN_PLATFORM_CREATE.replace("ACCESS_TOKEN", token);
        Map<String, String> map = new HashMap<>(2);
        map.put("appid", appId);
        String result = WxHttpUtil.post(url, map);
        LOGGER.info("创建平台，" + result);

        JSONObject json = JSON.parseObject(result);
        if (json != null) {
            return json.getString("open_appid");
        }
        return null;
    }

    /**
     * 创建开放平台帐号并绑定公众号/小程序
     *
     * @param appId     公众号/小程序 appId
     * @param token     公众号token
     * @param openAppId 开发平台 appId
     * @throws WxErrorException 微信异常
     */
    public static void bindOpenPlatform(String appId, String token, String openAppId) throws WxErrorException {
        String url = OPEN_PLATFORM_BIND.replace("ACCESS_TOKEN", token);
        Map<String, String> map = new HashMap<>(2);
        map.put("appid", appId);
        map.put("open_appid", openAppId);
        String result = WxHttpUtil.post(url, map);
        LOGGER.info("绑定平台，" + result);
    }

    /**
     * 将公众号/小程序从开放平台帐号下解绑
     *
     * @param appId     公众号/小程序 appId
     * @param token     公众号token
     * @param openAppId 开发平台 appId
     * @throws WxErrorException 微信异常
     */
    public static void unbindOpenPlatform(String appId, String token, String openAppId) throws WxErrorException {
        String url = OPEN_PLATFORM_UNBIND.replace("ACCESS_TOKEN", token);
        Map<String, String> map = new HashMap<>(2);
        map.put("appid", appId);
        map.put("open_appid", openAppId);
        String result = WxHttpUtil.post(url, map);
        LOGGER.info("解绑平台，" + result);
    }

    /**
     * api调用次数清零
     *
     * @param appId 公众号id
     * @param token 公众号token
     * @throws WxErrorException error
     */
    public static void clearQuota(String appId, String token) throws WxErrorException {
        String url = POST_CLEAR_QUOTA_URL.replace("ACCESS_TOKEN", token);
        Map<String, String> map = new HashMap<>(2);
        map.put("appid", appId);
        String result = WxHttpUtil.post(url, map);
        LOGGER.info("清除公众号或者小程序API调用次数，" + result);
    }
}