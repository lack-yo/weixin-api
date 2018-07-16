package com.lou.weixin.sdk.utils.json;

import com.google.gson.*;
import com.lou.weixin.sdk.bean.WxArticle;
import com.lou.weixin.sdk.bean.WxCustomMessage;

import java.lang.reflect.Type;

/**
 * 公众号客服消息Gson适配
 *
 * @author loufeng
 * @date 2018/7/9 下午3:09.
 */
public class WxCustomMessageAdapter implements JsonSerializer<WxCustomMessage> {

    @Override
    public JsonElement serialize(WxCustomMessage message, Type typeOfMsg, JsonSerializationContext context) {
        JsonObject messageJson = new JsonObject();
        messageJson.addProperty("touser", message.getToUser());
        String msgType = message.getMsgType().toString();
        messageJson.addProperty("msgtype", msgType);

        JsonObject sub = new JsonObject();
        switch (message.getMsgType()) {
            case news:
                JsonObject newsJsonObject = new JsonObject();
                JsonArray articleJsonArray = new JsonArray();
                for (WxArticle article : message.getArticles()) {
                    JsonObject articleJson = new JsonObject();
                    articleJson.addProperty("title", article.getTitle());
                    articleJson.addProperty("description", article.getDescription());
                    articleJson.addProperty("url", article.getUrl());
                    articleJson.addProperty("picurl", article.getPicUrl());
                    articleJsonArray.add(articleJson);
                }
                newsJsonObject.add("articles", articleJsonArray);
                messageJson.add("news", newsJsonObject);
                break;
            case voice:
                sub.addProperty("media_id", message.getMediaId());
                messageJson.add("voice", sub);
                break;
            case video:
                sub.addProperty("media_id", message.getMediaId());
                sub.addProperty("thumb_media_id", message.getThumbMediaId());
                sub.addProperty("title", message.getTitle());
                sub.addProperty("description", message.getDescription());
                messageJson.add("video", sub);
                break;
            case text:
                sub.addProperty("content", message.getContent());
                messageJson.add("text", sub);
                break;
            case image:
                sub.addProperty("media_id", message.getMediaId());
                messageJson.add("image", sub);
                break;
            case music:
                sub.addProperty("title", message.getTitle());
                sub.addProperty("description", message.getDescription());
                sub.addProperty("thumb_media_id", message.getThumbMediaId());
                sub.addProperty("musicurl", message.getMusicUrl());
                sub.addProperty("hqmusicurl", message.getHqMusicUrl());
                messageJson.add("music", sub);
                break;
            default:
                break;
        }
        return messageJson;
    }

}
