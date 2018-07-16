package com.lou.weixin.sdk.utils.json;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.lou.weixin.sdk.bean.WxMassGroupMessage;
import com.lou.weixin.sdk.constants.MassSendMsgType;

import java.lang.reflect.Type;

/**
 * 公众号按group发送信息Gson适配
 *
 * @author loufeng
 * @date 2018/7/9 下午3:09.
 */
public class WxMassGroupMessageAdapter implements JsonSerializer<WxMassGroupMessage> {

    @Override
    public JsonElement serialize(WxMassGroupMessage msg, Type typeOfMsg, JsonSerializationContext context) {
        JsonObject messageJson = new JsonObject();

        JsonObject filter = new JsonObject();
        if (null == msg.getGroupId()) {
            filter.addProperty("is_to_all", true);
        } else {
            filter.addProperty("is_to_all", true);
            filter.addProperty("group_id", msg.getGroupId());
        }
        messageJson.add("filter", filter);

        JsonObject sub = new JsonObject();
        String msgType = msg.getMsgType().toString();
        // 坑爹的微信，根据OpenId列表群发时,视频类型为video
        // 根据Group群发时，视频类型居然为mpvideo
        if (MassSendMsgType.video == msg.getMsgType()) {
            msgType = "mpvideo";
        }
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
