package com.lou.weixin.sdk.utils.json;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.lou.weixin.sdk.bean.WxTemplateData;
import com.lou.weixin.sdk.bean.WxTemplateMessage;

import java.lang.reflect.Type;

/**
 * 公众号模板消息Gson适配
 *
 * @author loufeng
 * @date 2018/7/9 下午3:09.
 */
public class WxTemplateMessageAdapter implements JsonSerializer<WxTemplateMessage> {

    @Override
    public JsonElement serialize(WxTemplateMessage message, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject messageJson = new JsonObject();
        messageJson.addProperty("touser", message.getToUser());
        messageJson.addProperty("template_id", message.getTemplateId());
        if (message.getUrl() != null) {
            messageJson.addProperty("url", message.getUrl());
        }
        if (message.getTopColor() != null) {
            messageJson.addProperty("topcolor", message.getTopColor());
        }
        JsonObject datas = new JsonObject();
        messageJson.add("data", datas);

        for (WxTemplateData data : message.getDatas()) {
            JsonObject dataJson = new JsonObject();
            dataJson.addProperty("value", data.getValue());
            if (data.getColor() != null) {
                dataJson.addProperty("color", data.getColor());
            }
            datas.add(data.getName(), dataJson);
        }

        return messageJson;
    }

}
