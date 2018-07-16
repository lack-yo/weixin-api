package com.lou.weixin.sdk.bean.result;


import com.lou.weixin.sdk.utils.json.WxGsonBuilder;

/**
 * token
 *
 * @author loufeng
 * @date 2018/7/9 下午2:11.
 */
public class WxToken {
    /**
     * 获取到的凭证
     */
    private String token;

    /**
     * 凭证有效时间，单位：秒
     */
    private Integer expiresIn = -1;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(Integer expiresIn) {
        this.expiresIn = expiresIn;
    }

    public static WxToken fromJson(String json) {
        return WxGsonBuilder.create().fromJson(json, WxToken.class);
    }

    @Override
    public String toString() {
        return "WxToken [token=" + token + ", expiresIn=" + expiresIn + "]";
    }
}
