package com.lou.weixin.sdk.utils.http;

import com.google.gson.Gson;
import com.lou.weixin.sdk.bean.WxError;
import com.lou.weixin.sdk.exception.WxErrorException;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

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
     * @throws WxErrorException 微信error
     */
    public static String get(String url) throws WxErrorException {
        String result = OkHttpUtil.get(url);
        WxError error = WxError.fromJson(result);
        if (error.getErrcode() != null && error.getErrcode() != 0) {
            throw new WxErrorException(error);
        }
        return result;
    }

    /**
     * post请求
     *
     * @param url  请求url
     * @param bean 请求参数
     * @return result
     * @throws WxErrorException 微信error
     */
    public static String post(String url, Object bean) throws WxErrorException {
        String json = GSON.toJson(bean);
        return post(url, json);
    }

    /**
     * post请求
     *
     * @param url  请求url
     * @param json 请求参数
     * @return result
     * @throws WxErrorException 微信error
     */
    public static String post(String url, String json) throws WxErrorException {
        String result = OkHttpUtil.postForm(url, json);
        WxError error = WxError.fromJson(result);
        if (error.getErrcode() != null && error.getErrcode() != 0) {
            throw new WxErrorException(error);
        }
        return result;
    }

    /**
     * 请求下载文件，转oss域名文件
     *
     * @return oss下载地址
     */
    public static InputStream getDownload(String url) {
        return OkHttpUtil.getDownload(url);
    }

    /**
     * 上传文件
     *
     * @param url  请求url
     * @param file 文件
     * @return result
     * @throws WxErrorException 微信error
     */
    public static String uploadFile(String url, File file) throws WxErrorException {
        try {
            String result = OkHttpUtil.uploadFile(url, file);
            WxError error = WxError.fromJson(result);
            if (error.getErrcode() != null) {
                throw new WxErrorException(error);
            }
            return result;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static InputStream postDownload(String url, Object json) {
        String bean = GSON.toJson(json);
        return OkHttpUtil.postDownload(url, bean);
    }
}
