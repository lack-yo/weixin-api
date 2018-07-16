package com.lou.weixin.sdk.support.mp;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonObject;
import com.lou.weixin.sdk.bean.result.MaterialResult;
import com.lou.weixin.sdk.bean.result.Result;
import com.lou.weixin.sdk.bean.result.WxMaterialListResult;
import com.lou.weixin.sdk.bean.result.WxMediaUploadResult;
import com.lou.weixin.sdk.constants.MediaType;
import com.lou.weixin.sdk.exception.WxErrorException;
import com.lou.weixin.sdk.utils.FileUtil;
import com.lou.weixin.sdk.utils.http.WxHttpUtil;
import com.lou.weixin.sdk.utils.json.WxGsonBuilder;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

/**
 * 素材管理
 *
 * @author loufeng
 * @date 2018/7/5 上午10:17.
 */
@SuppressWarnings("unused")
public class MpMediaSupport {
    /**
     * 多媒体文件上传接口
     **/
    private static final String MEDIA_UPLOAD_URL = "http://file.api.weixin.qq.com/cgi-bin/media/upload?access_token=ACCESS_TOKEN&type=TYPE";
    /**
     * 上传图文消息
     **/
    private static final String MATERIAL_ADD_NEWS = "https://api.weixin.qq.com/cgi-bin/material/add_news?access_token=ACCESS_TOKEN";
    /**
     * 获取素材总数
     */
    private static final String MATERIAL_GET_MATERIAL_COUNT = "https://api.weixin.qq.com/cgi-bin/material/get_materialcount?access_token=ACCESS_TOKEN";
    /**
     * 获取素材列表
     **/
    private static final String MATERIAL_BATCH_GET_MATERIAL = "https://api.weixin.qq.com/cgi-bin/material/batchget_material?access_token=ACCESS_TOKEN";
    /**
     * 获取永久素材
     **/
    private static final String MATERIAL_GET_MATERIAL = "https://api.weixin.qq.com/cgi-bin/material/get_material?access_token=ACCESS_TOKEN";
    /**
     * 删除永久素材
     **/
    private static final String MATERIAL_DEL_MATERIAL = "https://api.weixin.qq.com/cgi-bin/material/del_material?access_token=ACCESS_TOKEN";
    /**
     * 新增其他类型永久素材
     **/
    private static final String MATERIAL_ADD_MATERIAL = "https://api.weixin.qq.com/cgi-bin/material/add_material?access_token=ACCESS_TOKEN&type=TYPE";
    /**
     * 上传图文消息内的图片获取URL
     **/
    private static final String MEDIA_UPLOADIMG = "https://api.weixin.qq.com/cgi-bin/media/uploadimg?access_token=ACCESS_TOKEN";


    /**
     * 上传临时素材接口
     *
     * @param token       公众号token
     * @param mediaType   素材类型 {@link MediaType}
     * @param fileType    文件类型
     * @param inputStream io
     * @return 上传结果
     * @throws WxErrorException wx-error
     * @throws IOException      io-error
     */
    public static WxMediaUploadResult mediaUpload(String token, MediaType mediaType, String fileType,
                                                  InputStream inputStream) throws WxErrorException, IOException {
        return mediaUpload(token, mediaType,
                FileUtil.createTmpFile(inputStream, UUID.randomUUID().toString(), fileType));
    }

    /**
     * 上传临时素材接口
     *
     * @param token     公众号token
     * @param mediaType 素菜类型 {@link MediaType}
     * @param file      文件
     * @return 上传结果
     * @throws WxErrorException wx-error
     */
    public static WxMediaUploadResult mediaUpload(String token, MediaType mediaType, File file)
            throws WxErrorException {
        String urlWithToken = MEDIA_UPLOAD_URL.replace("ACCESS_TOKEN", token).replace("TYPE",
                mediaType.toString());
        String result = WxHttpUtil.uploadFile(urlWithToken, file);
        return WxMediaUploadResult.fromJson(result);
    }

    /**
     * 批量获取素材
     *
     * @param token  公众号token
     * @param offset 位置
     * @param count  数量
     * @param type   类型
     * @return 素材信息
     * @throws WxErrorException error
     */
    public static WxMaterialListResult batchGetMaterial(String token, int offset, int count, MediaType type) throws WxErrorException {
        String url = MATERIAL_BATCH_GET_MATERIAL.replace("ACCESS_TOKEN", token);
        JsonObject json = new JsonObject();
        json.addProperty("type", type.toString());
        json.addProperty("offset", offset);
        json.addProperty("count", count);
        String result = WxHttpUtil.post(url, json);
        return WxGsonBuilder.create().fromJson(result,
                WxMaterialListResult.class);
    }


    /**
     * 删除图文素材
     *
     * @param token   公众号token
     * @param mediaId 素材id
     * @return 结果
     * @throws WxErrorException error
     */
    public static Result delGraphicMaterial(String token, String mediaId) throws WxErrorException {
        String url = MATERIAL_DEL_MATERIAL.replace("ACCESS_TOKEN", token);
        JsonObject json = new JsonObject();
        json.addProperty("media_id", mediaId);
        return WxGsonBuilder.create().fromJson(WxHttpUtil.post(url, json),
                Result.class);
    }

    /**
     * 获取永久素材
     *
     * @param token   公众号token
     * @param mediaId 素材id
     * @return 素材
     * @throws WxErrorException error
     */
    public static InputStream getThumbUrlByMediaId(String token, String mediaId) throws WxErrorException {
        String url = MATERIAL_GET_MATERIAL.replace("ACCESS_TOKEN", token);
        JsonObject json = new JsonObject();
        json.addProperty("media_id", mediaId);
        return WxHttpUtil.postDownload(url, json);
    }


    /**
     * 获取单篇图文素材内容
     *
     * @param token   公众号token
     * @param mediaId 素材id
     * @return 素材内容
     * @throws WxErrorException error
     */
    public static WxMaterialListResult.ContentResult getGraphicContent(String token, String mediaId) throws WxErrorException {
        String url = MATERIAL_GET_MATERIAL.replace("ACCESS_TOKEN", token);
        JsonObject json = new JsonObject();
        json.addProperty("media_id", mediaId);
        String result = WxHttpUtil.post(url, json);
        return WxGsonBuilder.create().fromJson(result,
                WxMaterialListResult.ContentResult.class);
    }


    /**
     * 获取图文素材总数
     *
     * @param token 公众号token
     * @return 素材数量
     * @throws WxErrorException error
     */
    public static Integer getNewsMaterialTotal(String token) throws WxErrorException {
        String url = MATERIAL_GET_MATERIAL_COUNT.replace("ACCESS_TOKEN", token);
        String result = WxHttpUtil.get(url);
        JSONObject json = JSON.parseObject(result);
        if (json != null) {
            return json.getInteger("news_count");
        }
        return null;
    }

    /**
     * 新增永久图文素材
     *
     * @param token    公众号token
     * @param articles 图文
     * @return 结果
     * @throws WxErrorException error
     */
    public static String addNewsMaterial(String token, List<MaterialResult> articles) throws WxErrorException {
        String url = MATERIAL_ADD_NEWS.replace("ACCESS_TOKEN", token);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("articles", articles);
        String mc = WxHttpUtil.post(url, jsonObject.toJSONString());
        if (StringUtils.isNotBlank(mc)) {
            JSONObject object = JSON.parseObject(mc);
            return object.getString("media_id");
        }
        return null;
    }

    /**
     * 新增永久素材
     *
     * @param token 公众号token
     * @param type  类型
     * @param file  文件
     * @return 结果
     * @throws WxErrorException error
     */
    public static WxMediaUploadResult addPermanentMaterial(String token, MediaType type, File file) throws WxErrorException {
        String url = MATERIAL_ADD_MATERIAL.replace("ACCESS_TOKEN", token).replace("type", type.toString());
        String result = WxHttpUtil.uploadFile(url, file);
        return WxMediaUploadResult.fromJson(result);
    }

    /**
     * 上传图文消息内的图片获取URL
     * 在图文消息的具体内容中，将过滤外部的图片链接，开发者可以通过下述接口上传图片得到URL，放到图文内容中使用。
     *
     * @param token 公众号token
     * @return url
     * @throws WxErrorException 微信异常
     */
    public static String addGraphicContentLink(String token, File file) throws WxErrorException, IOException {
        String url = MEDIA_UPLOADIMG.replace("ACCESS_TOKEN", token);
        String result = WxHttpUtil.uploadFile(url, file);
        JSONObject json = JSON.parseObject(result);
        if (json != null) {
            return json.getString("url");
        }
        return null;
    }

}
