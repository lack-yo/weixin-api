package com.lou.weixin.sdk.bean.result;


import com.lou.weixin.sdk.utils.json.WxGsonBuilder;

/**
 * js凭据
 *
 * @author loufeng
 * @date 2018/1/23 上午9:58.
 */
public class WxJsapiTicket {
    /**
     * 获取到的凭证
     */
    private String ticket;

    /**
     * 凭证有效时间，单位：秒
     */
    private Integer expiresIn = -1;

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public Integer getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(Integer expiresIn) {
        this.expiresIn = expiresIn;
    }

    public static WxJsapiTicket fromJson(String json) {
        return WxGsonBuilder.create().fromJson(json, WxJsapiTicket.class);
    }

    @Override
    public String toString() {
        return "WxJsapiTicket [ticket=" + ticket + ", expiresIn=" + expiresIn + "]";
    }
}
