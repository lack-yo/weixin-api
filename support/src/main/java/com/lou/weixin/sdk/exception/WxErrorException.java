package com.lou.weixin.sdk.exception;


import com.lou.weixin.sdk.bean.WxError;

/**
 * 统一异常
 *
 * @author loufeng
 * @date 2018/7/06 上午11:13.
 */
public class WxErrorException extends Exception {

    private static final long serialVersionUID = 1L;

    private WxError error;

    public WxErrorException(WxError error) {
        super(error.toString());
        this.error = error;
    }

    public WxError getWxError() {
        return error;
    }
}
