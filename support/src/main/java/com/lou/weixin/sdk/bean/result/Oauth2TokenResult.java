package com.lou.weixin.sdk.bean.result;

/**
 * 公众号网页授权获取openId
 *
 * @author loufeng
 * @date 2018/1/23 上午9:58.
 */
public class Oauth2TokenResult {
    /**
     * 网页授权token
     */
    private String accessToken;
    /**
     * 过期时间
     */
    private String expiresIn;
    /**
     * 刷新token
     */
    private String refreshToken;
    /**
     * 用户id
     */
    private String openid;
    /**
     * 授权域
     */
    private String scope;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(String expiresIn) {
        this.expiresIn = expiresIn;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }
}
