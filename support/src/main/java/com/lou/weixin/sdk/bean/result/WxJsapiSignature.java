package com.lou.weixin.sdk.bean.result;

/**
 * 公众号js验签
 *
 * @author loufeng
 * @date 2018/1/23 上午9:58.
 */
public class WxJsapiSignature {
    /**
     * 随机串
     */
    private String noncestr;

    /**
     * 令牌凭据
     */
    private String jsapiTicket;
    /**
     * 时间戳
     */
    private long timestamp;
    /**
     * url
     */
    private String url;
    /**
     * 验签
     */
    private String signature;

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getNoncestr() {
        return noncestr;
    }

    public void setNoncestr(String noncestr) {
        this.noncestr = noncestr;
    }

    public String getJsapiTicket() {
        return jsapiTicket;
    }

    public void setJsapiTicket(String jsapiTicket) {
        this.jsapiTicket = jsapiTicket;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
