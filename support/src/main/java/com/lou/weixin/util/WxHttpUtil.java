package com.lou.weixin.util;

import com.google.gson.Gson;
import com.lou.weixin.exception.WxException;
import com.lou.weixin.model.result.WxError;

import java.io.File;
import java.io.IOException;

/**
 * @author loufeng
 * @date 2017/8/29 上午11:02.
 */
public class WxHttpUtil {
    private static final Gson GSON = new Gson();

    /**
     * get请求
     *
     * @param url 请求url
     * @return result
     * @throws WxException 微信error
     */
    public static String get(String url) throws WxException {
        String result = OkHttpUtil.get(url);
        WxError error = GSON.fromJson(result, WxError.class);
        if (error.getErrcode() != null && error.getErrcode() != 0) {
            throw new WxException(error.getErrcode(),error.getErrmsg());
        }
        return result;
    }

    /**
     * post请求
     *
     * @param url  请求url
     * @param bean 请求参数
     * @return result
     * @throws WxException 微信error
     */
    public static String post(String url, Object bean) throws WxException {
        String json = GSON.toJson(bean);
        String result = OkHttpUtil.postForm(url, json);
        WxError error = GSON.fromJson(result, WxError.class);
        if (error.getErrcode() != null && error.getErrcode() != 0) {
            throw new WxException(error.getErrcode(),error.getErrmsg());
        }
        return result;
    }


    /**
     * 上传文件
     *
     * @param url  请求url
     * @param file 文件
     * @return result
     * @throws WxException 微信error
     */
    public static String uploadFile(String url, File file) throws WxException {
        try {
            String result = OkHttpUtil.uploadFile(url, file);
            WxError error = GSON.fromJson(result, WxError.class);
            if (error.getErrcode() != null && error.getErrcode() != 0) {
                throw new WxException(error.getErrcode(),error.getErrmsg());
            }
            return result;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
