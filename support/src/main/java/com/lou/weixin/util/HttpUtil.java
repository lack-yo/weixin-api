package com.lou.weixin.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lou.weixin.exception.WxException;
import okhttp3.*;

import java.io.IOException;

/**
 * @author loufeng
 * @date 2017/7/11 下午3:36.
 * 基本http支持
 */
public class HttpUtil {
    public static final MediaType TYPE
            = MediaType.parse("application/json; charset=utf-8");

    private static OkHttpClient client = new OkHttpClient();

    public static String doPost(String url, String json) throws IOException {
        RequestBody body = RequestBody.create(TYPE, json);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    public static String doGet(String url) throws IOException {
        System.out.println("doget url: " + url);
        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();
        Response response = client.newCall(request).execute();
        String result = response.body().string();
        JSONObject json = JSON.parseObject(result);
        Integer code = (Integer) json.get("errcode");
        if (code != null && code != 0) {
            String msg = (String) json.get("errmsg");
            throw new WxException(code, msg);
        }
        System.out.println("doget response: " + result);
        return result;
    }

    public static <T> T get(String url, Class<T> clazz) throws IOException {
        String result = doGet(url);
        return JSON.parseObject(result, clazz);
    }
}
