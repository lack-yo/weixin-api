package com.lou.weixin.sdk.support.mp;

import com.google.common.collect.Maps;
import com.lou.weixin.sdk.bean.result.LinkAppResult;
import com.lou.weixin.sdk.exception.WxErrorException;
import com.lou.weixin.sdk.utils.http.WxHttpUtil;
import com.lou.weixin.sdk.utils.json.WxGsonBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * 公众号关联小程序API集成
 *
 * @author loufeng
 * @date 2018/7/5 上午10:21.
 */
@SuppressWarnings("unused")
public class MpLinkSupport {
    private static final Logger LOGGER = LoggerFactory.getLogger(MpLinkSupport.class);
    /**
     * 获取公众号关联的小程序
     */
    private static final String POST_MINIAPP_GET = "https://api.weixin.qq.com/cgi-bin/wxopen/wxamplinkget?access_token=ACCESS_TOKEN";
    /**
     * 关联小程序
     */
    private static final String POST_MINIAPP_LINK = "https://api.weixin.qq.com/cgi-bin/wxopen/wxamplink?access_token=ACCESS_TOKEN";
    /**
     * 解除关联小程序
     */
    private static final String POST_MINIAPP_UNLINK = "https://api.weixin.qq.com/cgi-bin/wxopen/wxampunlink?access_token=ACCESS_TOKEN";


    /**
     * 获取公众号关联的小程序列表
     *
     * @param appId 公众号id
     * @param token 公众号token
     * @throws WxErrorException error
     */
    public static LinkAppResult getMiniAppLink(String appId, String token) throws WxErrorException {
        String url = POST_MINIAPP_GET.replace("ACCESS_TOKEN", token);

        String result = WxHttpUtil.post(url, Maps.newHashMap());
        LOGGER.info("获取关联的小程序，" + result);
        return WxGsonBuilder.create().fromJson(result, LinkAppResult.class);
    }

    /**
     * 公众号关联小程序,不推送信息
     *
     * @param appId     公众号id
     * @param token     公众号token
     * @param miniAppId 小程序id
     * @throws WxErrorException error
     */
    public static void linkMiniApp(String appId, String token, String miniAppId, boolean notify) throws WxErrorException {
        String url = POST_MINIAPP_LINK.replace("ACCESS_TOKEN", token);
        Map<String, String> map = new HashMap<>(2);
        map.put("appid", appId);
        String value = notify ? "1" : "0";
        map.put("notify_users", value);
        map.put("show_profile", value);
        String result = WxHttpUtil.post(url, map);
        LOGGER.info("关联小程序，" + result);
    }


    /**
     * 公众号解绑小程序
     *
     * @param appId     公众号id
     * @param token     公众号token
     * @param miniAppId 小程序id
     * @throws WxErrorException error
     */
    public static  void unLinkMiniApp(String appId, String token, String miniAppId) throws WxErrorException {
        String url = POST_MINIAPP_UNLINK.replace("ACCESS_TOKEN", token);
        Map<String, String> map = new HashMap<>(2);
        map.put("appid", appId);
        WxHttpUtil.post(url, map);
    }
}
