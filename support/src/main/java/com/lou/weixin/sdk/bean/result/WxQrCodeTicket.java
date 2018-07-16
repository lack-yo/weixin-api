package com.lou.weixin.sdk.bean.result;


import com.lou.weixin.sdk.utils.json.WxGsonBuilder;

/**
 * 带参数二维码ticket
 *
 * @author loufeng
 * @date 2018/7/9 下午2:09.
 */
public class WxQrCodeTicket {
    /**
     * 获取的二维码ticket，凭借此ticket可以在有效时间内换取二维码。
     */
    private String ticket;
    /**
     * 二维码的有效时间，以秒为单位。最大不超过1800。
     */
    private Integer expireSeconds;
    /**
     * 二维码图片解析后的地址，开发者可根据该地址自行生成需要的二维码图片
     */
    private String url;

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public Integer getExpireSeconds() {
        return expireSeconds;
    }

    public void setExpireSeconds(Integer expireSeconds) {
        this.expireSeconds = expireSeconds;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public static WxQrCodeTicket fromJson(String json) {
        return WxGsonBuilder.INSTANCE.create().fromJson(json, WxQrCodeTicket.class);
    }

    @Override
    public String toString() {
        return "WxQrCodeTicket[ticket=" + ticket + ",expireSeconds=" + expireSeconds + ",url=" + url + "]";
    }
}
