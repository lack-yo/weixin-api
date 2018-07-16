package com.lou.weixin.sdk.support.mp;


import com.lou.weixin.sdk.bean.result.Oauth2TokenResult;
import com.lou.weixin.sdk.bean.result.WxUser;
import com.lou.weixin.sdk.exception.WxErrorException;
import com.lou.weixin.sdk.utils.http.WxHttpUtil;
import com.lou.weixin.sdk.utils.json.WxGsonBuilder;

/**
 * @author loufeng
 * @date 2018/7/9 下午4:41.
 */
@SuppressWarnings("unused")
public class MpWebOauth2Support {
    /**
     * 公众号网页授权
     */
    private static final String OAUTH2_URL =
            "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";
    /**
     * 公众号网页授权刷新
     */
    private static final String REFRESH_OAUTH2_URL =
            "https://api.weixin.qq.com/sns/oauth2/refresh_token?appid=APPID&grant_type=refresh_token&refresh_token=REFRESH_TOKEN ";
    /**
     * 开放平台网页授权
     */
    private static final String PLATFORM_OAUTH2_URL = "https://api.weixin.qq.com/sns/oauth2/component/access_token?appid=APPID&code=CODE&grant_type=authorization_code&component_appid=COMPONENT_APPID&component_access_token=COMPONENT_ACCESS_TOKEN";
    /**
     * 公众号网页授权获取用户信息
     */
    private static final String GET_USER_INFO_URL = "https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";


    /**
     * 网页授权
     *
     * @param appid  公众号
     * @param secret 密钥
     * @param code   网页授权code
     * @return 结果
     * @throws WxErrorException error
     */
    public static Oauth2TokenResult tokenWithOauth2(String appid, String secret, String code) throws WxErrorException {
        String url = OAUTH2_URL.replace("APPID", appid).replace("SECRET", secret).replace("CODE", code);
        String result = WxHttpUtil.get(url);
        return WxGsonBuilder.create().fromJson(result, Oauth2TokenResult.class);
    }

    /**
     * 网页授权获取用户信息
     *
     * @param openId      粉丝id
     * @param accessToken 网页授权token
     * @return 结果
     * @throws WxErrorException error
     */
    public static WxUser getWxOauth2UserInfo(String openId, String accessToken) throws WxErrorException {
        String url = GET_USER_INFO_URL.replace("ACCESS_TOKEN", accessToken).replace("OPENID", openId);
        String result = WxHttpUtil.get(url);

        return WxGsonBuilder.create().fromJson(result, WxUser.class);
    }

    /**
     * 获取开放平台网页授权token
     *
     * @param appid          公众号id
     * @param componentAppid 第三方平台id
     * @param code           授权code
     * @param token          第三方平台token
     * @return token
     */
    public static Oauth2TokenResult tokenWithPlatformOauth2(String appid, String componentAppid, String code, String token) throws WxErrorException {
        String url = PLATFORM_OAUTH2_URL
                .replace("COMPONENT_APPID", componentAppid)
                .replace("APPID", appid)
                .replace("CODE", code)
                .replace("COMPONENT_ACCESS_TOKEN", token);
        String result = WxHttpUtil.get(url);
        return WxGsonBuilder.create().fromJson(result, Oauth2TokenResult.class);
    }

}
