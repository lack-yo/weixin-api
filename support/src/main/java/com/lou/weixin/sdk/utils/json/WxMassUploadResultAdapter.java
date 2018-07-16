package com.lou.weixin.sdk.utils.json;

import com.google.gson.*;
import com.lou.weixin.sdk.bean.result.WxMassUploadResult;
import com.lou.weixin.sdk.utils.GsonConvertUtil;

import java.lang.reflect.Type;

/**
 * 公众号消息Gson适配
 *
 * @author loufeng
 * @date 2018/7/9 下午3:09.
 */
public class WxMassUploadResultAdapter implements JsonDeserializer<WxMassUploadResult> {

    @Override
    public WxMassUploadResult deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
            throws JsonParseException {
        WxMassUploadResult uploadResult = new WxMassUploadResult();
        JsonObject uploadResultJsonObject = json.getAsJsonObject();

        if (uploadResultJsonObject.get("type") != null && !uploadResultJsonObject.get("type").isJsonNull()) {
            uploadResult.setType(GsonConvertUtil.getAsString(uploadResultJsonObject.get("type")));
        }
        if (uploadResultJsonObject.get("media_id") != null && !uploadResultJsonObject.get("media_id").isJsonNull()) {
            uploadResult.setMediaId(GsonConvertUtil.getAsString(uploadResultJsonObject.get("media_id")));
        }
        if (uploadResultJsonObject.get("created_at") != null && !uploadResultJsonObject.get("created_at").isJsonNull()) {
            uploadResult.setCreatedAt(GsonConvertUtil.getAsPrimitiveLong(uploadResultJsonObject.get("created_at")));
        }
        return uploadResult;
    }

}
