package com.lou.weixin.sdk.utils.http;

import com.lou.weixin.sdk.exception.WxErrorException;
import okhttp3.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author loufeng
 * @date 2018/7/9 下午3:16.
 */
public class OkHttpUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(OkHttpUtil.class);

    private static final OkHttpClient CLIENT = new OkHttpClient().newBuilder().connectTimeout(30, TimeUnit.SECONDS).build();

    private static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    private OkHttpUtil() {
    }

    /**
     * get 请求
     *
     * @param url url
     * @return 结果
     */
    public static String get(String url) throws WxErrorException {
        LOGGER.info("start to request get {}", url);
        long startTime = System.currentTimeMillis();
        Request request = new Request.Builder().url(url).build();
        try {
            Response response = CLIENT.newCall(request).execute();
            LOGGER.info("finish request get:{},cost:{}ms", url, (System.currentTimeMillis() - startTime));
            return response.body().string();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * post 方式提交表单数据
     *
     * @param url  url
     * @param json 请求参数
     * @return 结果
     */
    public static String postForm(String url, String json) {
        return postForm(url, json, null);
    }

    /**
     * post 方式提交表单数据
     *
     * @param url     url
     * @param json    请求参数
     * @param headers header
     * @return result
     */
    public static String postForm(String url, String json, Map<String, Object> headers) {
        LOGGER.info("start to post url {}, params: {}", url, json);
        long startTime = System.currentTimeMillis();
        RequestBody body = RequestBody.create(JSON, json);
        Request.Builder requestBuilder = new Request.Builder()
                .url(url)
                .post(body);

        if (headers != null && !headers.isEmpty()) {
            for (String key : headers.keySet()) {
                requestBuilder.header(key, String.valueOf(headers.get(key)));
            }
        }

        Request request = requestBuilder.build();
        Response response;
        try {
            response = CLIENT.newCall(request).execute();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String result;
        try {
            result = response.body().string();
            LOGGER.info("finish request post:{},cost:{}ms", url, (System.currentTimeMillis() - startTime));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    /**
     * 下载图片并上传到oss
     *
     * @param url url
     * @return result
     */
    public static InputStream getDownload(String url) {
        LOGGER.info("start to get url {}, params: {}", url);
        Request request = new Request.Builder()
                .url(url).build();
        Response response;
        try {
            response = CLIENT.newCall(request).execute();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return response.body().byteStream();
    }

    /**
     * 上传文件
     *
     * @param url  url
     * @param file 文件
     * @return 结果
     */
    public static String uploadFile(String url, File file) throws IOException {
        RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), file);// 根据文件格式封装文件
        RequestBody requestBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("media", file.getName(), requestFile).build();// 初始化请求体对象，设置Content-Type以及文件数据流
        Request request = new Request.Builder().url(url).post(requestBody).build();// 封装OkHttp请求对象，初始化请求参数
        Call newCall = CLIENT.newCall(request);
        Response response = newCall.execute();
        return response.body().string();

    }


    /**
     * 获取完整链接
     *
     * @param url    url
     * @param params 请求参数
     * @return result
     */
    private static String getCompleteUrl(String url, Map<String, Object> params) {
        if (params == null || params.isEmpty()) {
            return url;
        }

        StringBuilder sb = new StringBuilder();
        for (String key : params.keySet()) {
            if (params.get(key) != null) {
                sb.append(key).append("=").append(params.get(key)).append("&");
            }
        }
        String paramUrl = sb.toString();
        return url + "?" + paramUrl;
    }


    public static InputStream postDownload(String url, String json) {
        LOGGER.info("start to post url {}, params: {}", url, json);
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        Response response;
        try {
            response = CLIENT.newCall(request).execute();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return response.body().byteStream();
    }
}
