package com.lou.weixin.sdk.bean;

/**
 * @author loufeng
 * @date 2018/7/4 上午10:16.
 */
public class LoginBean {
    /**
     * 用户唯一标识的openid
     */
    private String openid;
    /**
     * 会话密钥
     */
    private String sessionKey;
    /**
     * 开放平台用户标识
     */
    private String unionId;

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getSessionKey() {
        return sessionKey;
    }

    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
    }

    public String getUnionId() {
        return unionId;
    }

    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }

    @Override
    public String toString() {
        return "LoginModel{" +
                "openid='" + openid + '\'' +
                ", sessionKey='" + sessionKey + '\'' +
                ", unionId='" + unionId + '\'' +
                '}';
    }
}
