package com.lou.weixin.sdk.utils.json;

import com.google.gson.*;
import com.lou.weixin.sdk.bean.result.WxMessageSendResult;
import com.lou.weixin.sdk.utils.GsonConvertUtil;

import java.lang.reflect.Type;

/**
 * 公众号消息发送Gson适配
 *
 * @author loufeng
 * @date 2018/7/9 下午3:09.
 */
public class WxMassSendResultAdapter implements JsonDeserializer<WxMessageSendResult> {

    @Override
    public WxMessageSendResult deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
            throws JsonParseException {
        WxMessageSendResult sendResult = new WxMessageSendResult();
        JsonObject sendResultJsonObject = json.getAsJsonObject();

        JsonElement errcode = sendResultJsonObject.get("errcode");
        if (errcode != null && !errcode.isJsonNull()) {
            sendResult.setErrcode(GsonConvertUtil.getAsInteger(errcode));
        }
        JsonElement errmsg = sendResultJsonObject.get("errmsg");
        if (errmsg != null && !errmsg.isJsonNull()) {
            sendResult.setErrmsg(GsonConvertUtil.getAsString(errmsg));
        }
        JsonElement msgId = sendResultJsonObject.get("msg_id");
        if (msgId != null && !msgId.isJsonNull()) {
            sendResult.setMsgId(GsonConvertUtil.getAsString(msgId));
        }

        JsonElement msgDataId = sendResultJsonObject.get("msg_data_id");
        if (msgDataId != null && !msgDataId.isJsonNull()) {
            sendResult.setMsgDataId(GsonConvertUtil.getAsString(msgDataId));
        }
        return sendResult;
    }

}
