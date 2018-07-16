package com.lou.weixin.sdk.utils.json;

import com.google.gson.*;
import com.lou.weixin.sdk.bean.result.WxMediaUploadResult;
import com.lou.weixin.sdk.constants.MediaType;
import com.lou.weixin.sdk.utils.GsonConvertUtil;

import java.lang.reflect.Type;

/**
 * 公众号素材上传Gson适配
 *
 * @author loufeng
 * @date 2018/7/9 下午3:09.
 */
public class WxMediaUploadResultAdapter implements JsonDeserializer<WxMediaUploadResult> {

    @Override
    public WxMediaUploadResult deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
            throws JsonParseException {
        WxMediaUploadResult uploadResult = new WxMediaUploadResult();
        JsonObject uploadResultJsonObject = json.getAsJsonObject();

        if (uploadResultJsonObject.get("type") != null && !uploadResultJsonObject.get("type").isJsonNull()) {
            uploadResult.setType(MediaType.parseFromStr(GsonConvertUtil.getAsString(uploadResultJsonObject.get("type"))));
        }
        if (uploadResultJsonObject.get("media_id") != null && !uploadResultJsonObject.get("media_id").isJsonNull()) {
            uploadResult.setMediaId(GsonConvertUtil.getAsString(uploadResultJsonObject.get("media_id")));
        }
        if (uploadResultJsonObject.get("thumb_media_id") != null && !uploadResultJsonObject.get("thumb_media_id").isJsonNull()) {
            uploadResult.setThumbMediaId(GsonConvertUtil.getAsString(uploadResultJsonObject.get("thumb_media_id")));
        }
        if (uploadResultJsonObject.get("created_at") != null && !uploadResultJsonObject.get("created_at").isJsonNull()) {
            uploadResult.setCreatedAt(GsonConvertUtil.getAsPrimitiveLong(uploadResultJsonObject.get("created_at")));
        }
        return uploadResult;
    }

}
