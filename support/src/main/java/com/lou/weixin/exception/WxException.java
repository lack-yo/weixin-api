package com.lou.weixin.exception;

/**
 * @author loufeng
 * @date 2017/7/11 下午4:15.
 */
public class WxException extends RuntimeException {
    private int code;
    private String msg;

    public WxException() {
    }

    public WxException(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "WxException{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                '}';
    }
}
