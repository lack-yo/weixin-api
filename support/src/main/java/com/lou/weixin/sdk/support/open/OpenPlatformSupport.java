package com.lou.weixin.sdk.support.open;

import com.alibaba.fastjson.JSONObject;
import com.lou.weixin.sdk.bean.AuthorizationInfo;
import com.lou.weixin.sdk.bean.LoginBean;
import com.lou.weixin.sdk.bean.result.auth.AuthInfoResult;
import com.lou.weixin.sdk.exception.WxErrorException;
import com.lou.weixin.sdk.utils.http.WxHttpUtil;
import com.lou.weixin.sdk.utils.json.WxGsonBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 第三方平台服务提供SDK
 *
 * @author loufeng
 * @date 2018/7/4 下午4:03.
 */
@SuppressWarnings("unused")
public class OpenPlatformSupport {
    private static final Logger LOGGER = LoggerFactory.getLogger(OpenPlatformSupport.class);
    /**
     * 调用次数清零
     */
    private static final String POST_CLEAR_QUOTA_URL = "https://api.weixin.qq.com/cgi-bin/component/clear_quota?component_access_token=COMPONENT_ACCESS_TOKEN";
    /**
     * 获取小程序openid
     */
    private static final String URL_GET_OPENID = "https://api.weixin.qq.com/sns/component/jscode2session?appid=APPID&js_code=JSCODE&grant_type=authorization_code&component_appid=COMPONENT_APPID&component_access_token=COMPONENT_ACCESS_TOKEN";
    /**
     * 获取component access token
     */
    private static String POST_COMPONENT_TOKEN_URL =
            "https://api.weixin.qq.com/cgi-bin/component/api_component_token";
    /**
     * 获取授权token
     */
    private static String POST_AUTHORIZER_TOKEN_URL =
            "https://api.weixin.qq.com/cgi-bin/component/api_authorizer_token?component_access_token=COMPONENT_ACCESS_TOKEN";
    /**
     * 查询授权信息
     */
    private static String POST_QUERY_AUTH_URL =
            "https://api.weixin.qq.com/cgi-bin/component/api_query_auth?component_access_token=COMPONENT_ACCESS_TOKEN";
    /**
     * 获取预授权码
     */
    private static String POST_CREATE_PREAUTHCODE_URL =
            "https://api.weixin.qq.com/cgi-bin/component/api_create_preauthcode?component_access_token=COMPONENT_ACCESS_TOKEN";
    /**
     * 获取授权主体信息
     */
    private static String POST_AUTHORIZER_INFO_URL = "https://api.weixin.qq.com/cgi-bin/component/api_get_authorizer_info?component_access_token=COMPONENT_ACCESS_TOKEN";


    /**
     * 获取授权信息（需要拦截）
     *
     * @param code  授权码
     * @param token 平台token
     * @return 信息
     */
    public static AuthorizationInfo getAuthInfo(String componentAppId, String code, String token) throws WxErrorException {
        JSONObject param = new JSONObject();
        param.put("component_appid", componentAppId);
        param.put("authorization_code", code);
        String url = POST_QUERY_AUTH_URL.replace("COMPONENT_ACCESS_TOKEN", token);
        LOGGER.info("getAuthorizerInfo-->参数：" + param.toString());
        String result = WxHttpUtil.post(url, param);

        if (null != result) {
            JSONObject resultJson = JSONObject.parseObject(result);
            result = resultJson.getString("authorization_info");
            resultJson = JSONObject.parseObject(result);
            AuthorizationInfo aiVO = new AuthorizationInfo();
            aiVO.setAuthorizerAccessToken(resultJson.getString("authorizer_access_token"));
            aiVO.setAuthorizerAppid(resultJson.getString("authorizer_appid"));
            aiVO.setExpiresIn(Integer.parseInt(resultJson.getString("expires_in")));
            aiVO.setAuthorizerRefreshToken(resultJson.getString("authorizer_refresh_token"));
            return aiVO;
        }
        return null;
    }

    /**
     * 获取授权主体（公众号或者小程序）信息（需要拦截）
     *
     * @param appId 公众号或小程序id
     * @param token 平台token
     * @return 信息
     */
    public static AuthInfoResult getAuthorizerInfo(String componentAppId, String appId, String token) throws WxErrorException {
        String url = POST_AUTHORIZER_INFO_URL.replace("COMPONENT_ACCESS_TOKEN", token);
        JSONObject json = new JSONObject();
        json.put("component_appid", componentAppId);
        json.put("authorizer_appid", appId);

        LOGGER.info("--------------------------checkTicket成功，准备与微信交互-------------------------");
        String result = WxHttpUtil.post(url, json);

        return WxGsonBuilder.create().fromJson(result,
                AuthInfoResult.class);
    }

    /**
     * 获取平台预授权码（需要拦截）
     *
     * @param token 平台token
     * @return 预授权码
     */
    public static String getPreAuthCode(String componentAppId, String token) throws WxErrorException {
        JSONObject param = new JSONObject();
        param.put("component_appid", componentAppId);
        String url = POST_CREATE_PREAUTHCODE_URL.replace("COMPONENT_ACCESS_TOKEN", token);
        String result = WxHttpUtil.post(url, param);
        LOGGER.info("预授权码xml：" + result);
        if (null != result) {
            JSONObject resultJson = JSONObject.parseObject(result);
            return resultJson.getString("pre_auth_code");
        }
        return null;
    }

    /**
     * 获取开放平台access token
     *
     * @return token
     */
    public static String getComponentToken(String componentAppId, String componentAppSecret, String ticket) {
        JSONObject param = new JSONObject();
        param.put("component_appid", componentAppId);
        param.put("component_appsecret", componentAppSecret);
        param.put("component_verify_ticket", ticket);

        try {
            String result = WxHttpUtil.post(POST_COMPONENT_TOKEN_URL, param);
            LOGGER.info("COMPONENT_TOKEN xml：" + result);
            if (null != result) {
                JSONObject resultJson = JSONObject.parseObject(result);
                return resultJson.getString("component_access_token");
            }
        } catch (WxErrorException e) {
            LOGGER.error("getCurToken error,", e);
        }
        return null;
    }

    /**
     * 获取公众号或小程序开放平台授权token（需要拦截）
     *
     * @param appId        公众号或小程序id
     * @param refreshToken 公众号或小程序刷新token
     * @param token        开放平台token
     * @return token
     */
    public static AuthorizationInfo getPlatformToken(String componentAppId, String appId, String refreshToken, String token) throws WxErrorException {
        JSONObject param = new JSONObject();
        param.put("component_appid", componentAppId);
        param.put("authorizer_appid", appId);
        param.put("authorizer_refresh_token", refreshToken);

        String url = POST_AUTHORIZER_TOKEN_URL.replace("COMPONENT_ACCESS_TOKEN", token);

        String result = WxHttpUtil.post(url, param);
        LOGGER.info("getAccessTokenByRefreshToken xml：" + result);
        if (null != result) {
            JSONObject resultJson = JSONObject.parseObject(result);
            AuthorizationInfo aiVO = new AuthorizationInfo();
            aiVO.setAuthorizerAccessToken(resultJson.getString("authorizer_access_token"));
            aiVO.setExpiresIn(Integer.parseInt(resultJson.getString("expires_in")));
            aiVO.setAuthorizerAppid(appId);
            aiVO.setAuthorizerRefreshToken(resultJson.getString("authorizer_refresh_token"));

            return aiVO;
        }
        return null;
    }

    /**
     * 清除平台API调用次数
     *
     * @param token 平台token
     * @return true/false
     */
    public static boolean clearQuota(String componentAppId, String token) {
        String url = POST_CLEAR_QUOTA_URL.replace("COMPONENT_ACCESS_TOKEN", token);
        try {
            JSONObject param = new JSONObject();
            param.put("component_appid", componentAppId);
            WxHttpUtil.post(url, param);
            return true;
        } catch (WxErrorException e) {
            LOGGER.error("开发平台清零API失败", e);
        }
        return false;
    }

    /**
     * 微信登录获取openid
     *
     * @param appId          小程序appId
     * @param componentAppId 第三方平台appId
     * @param token          小程序token
     * @param code           登录code
     * @return 获取的openid
     * @throws WxErrorException 微信错误
     */
    public static LoginBean getMinaLoginBean(String appId, String componentAppId, String token, String code) throws WxErrorException {
        String url = URL_GET_OPENID.replace("COMPONENT_ACCESS_TOKEN", token).replace("COMPONENT_APPID", componentAppId)
                .replace("JSCODE", code).replace("APPID", appId);
        String result = WxHttpUtil.get(url);
        LOGGER.info("获取的小程序用户信息：" + result);
        return WxGsonBuilder.INSTANCE.create().fromJson(result, LoginBean.class);
    }
}
