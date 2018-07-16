package com.lou.weixin.sdk.bean;

/**
 * @author loufeng
 * @date 2018/7/4 下午3:57.
 */
public class AuthorizationInfo {
    public static final int TYPE_GZH = 1;
    public static final int TYPE_MINA = 2;
    /**
     * 授权方appid
     */
    private String authorizerAppid;
    /**
     * 授权方接口调用凭据（在授权的公众号具备API权限时，才有此返回值），也简称为令牌
     */
    private String authorizerAccessToken;
    /**
     * 有效期（在授权的公众号具备API权限时，才有此返回值）
     */
    private Integer expiresIn;
    /**
     * 接口调用凭据刷新令牌（在授权的公众号具备API权限时，才有此返回值），刷新令牌主要用于公众号第三方平台获取和刷新已授权用户的access_token，只会在授权时刻提供，请妥善保存。 一旦丢失，只能让用户重新授权，才能再次拿到新的刷新令牌
     */
    private String authorizerRefreshToken;

    /**
     * 授权来源，为0/null表示经过web授权，为1表示经过客户端授权
     */
    private int authorizerSource;
    /**
     * 授权主体类型，为1/null表示公众号授权，为2表示小程序授权
     */
    private Integer type;

    public String getAuthorizerAppid() {
        return authorizerAppid;
    }

    public void setAuthorizerAppid(String authorizerAppid) {
        this.authorizerAppid = authorizerAppid;
    }

    public String getAuthorizerAccessToken() {
        return authorizerAccessToken;
    }

    public void setAuthorizerAccessToken(String authorizerAccessToken) {
        this.authorizerAccessToken = authorizerAccessToken;
    }

    public Integer getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(Integer expiresIn) {
        this.expiresIn = expiresIn;
    }

    public String getAuthorizerRefreshToken() {
        return authorizerRefreshToken;
    }

    public void setAuthorizerRefreshToken(String authorizerRefreshToken) {
        this.authorizerRefreshToken = authorizerRefreshToken;
    }

    public int getAuthorizerSource() {
        return authorizerSource;
    }

    public void setAuthorizerSource(int authorizerSource) {
        this.authorizerSource = authorizerSource;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "AuthorizationInfoVO{" + "authorizerAppid='" + authorizerAppid + '\'' +
                ", authorizerAccessToken='" + authorizerAccessToken + '\'' +
                ", expiresIn=" + expiresIn +
                ", authorizerRefreshToken='" + authorizerRefreshToken + '\'' +
                ", authorizerSource=" + authorizerSource +
                ", type=" + type +
                '}';
    }
}
