package com.lou.weixin.sdk.bean;


import com.lou.weixin.sdk.utils.json.WxGsonBuilder;

import java.io.Serializable;

/**
 * 微信错误码说明
 *
 * @link http://mp.weixin.qq.com/wiki/17/fa4e1434e57290788bde25603fa2fcbd.html
 */
public class WxError implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private Integer errcode;

    private String errmsg;

    private String json;

    public Integer getErrcode() {
        return errcode;
    }

    public void setErrcode(Integer errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }

    public static WxError fromJson(String json) {
        return WxGsonBuilder.create().fromJson(json, WxError.class);
    }

    @Override
    public String toString() {
        return "WeixinError [errcode=" + errcode + ", errmsg=" + errmsg + "]";
    }
}
