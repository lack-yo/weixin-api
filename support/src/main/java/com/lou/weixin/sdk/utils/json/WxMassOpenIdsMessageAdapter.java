package com.lou.weixin.sdk.utils.json;

import com.google.gson.*;
import com.lou.weixin.sdk.bean.WxMassOpenIdsMessage;

import java.lang.reflect.Type;

/**
 * 公众号根据openid发送信息Gson适配
 *
 * @author loufeng
 * @date 2018/7/9 下午3:09.
 */
public class WxMassOpenIdsMessageAdapter implements JsonSerializer<WxMassOpenIdsMessage> {

    @Override
    public JsonElement serialize(WxMassOpenIdsMessage msg, Type typeOfmsg, JsonSerializationContext context) {
        JsonObject messageJson = new JsonObject();

        JsonArray toUsers = new JsonArray();
        for (String openId : msg.getToUsers()) {
            toUsers.add(new JsonPrimitive(openId));
        }
        messageJson.add("touser", toUsers);

        JsonObject sub = new JsonObject();
        String msgType = msg.getMsgType().toString();

        switch (msg.getMsgType()) {
            case mpnews:
                sub.addProperty("media_id", msg.getMediaId());
                messageJson.add(msgType, sub);
                break;
            case voice:
                sub.addProperty("media_id", msg.getMediaId());
                messageJson.add(msgType, sub);
                break;
            case video:
                sub.addProperty("media_id", msg.getMediaId());
                sub.addProperty("title", msg.getTitle());
                sub.addProperty("description", msg.getDescription());
                messageJson.add(msgType, sub);
                break;
            case text:
                sub.addProperty("content", msg.getContent());
                messageJson.add(msgType, sub);
                break;
            case image:
                sub.addProperty("media_id", msg.getMediaId());
                messageJson.add(msgType, sub);
                break;
            default:
                break;
        }
        messageJson.addProperty("msgtype", msgType);
        return messageJson;
    }
}
