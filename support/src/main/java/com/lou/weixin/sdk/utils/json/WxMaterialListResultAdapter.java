package com.lou.weixin.sdk.utils.json;

import com.google.common.collect.Lists;
import com.google.gson.*;
import com.lou.weixin.sdk.bean.result.MaterialResult;
import com.lou.weixin.sdk.bean.result.WxMaterialListResult;

import java.lang.reflect.Type;
import java.util.List;

/**
 * @author loufeng
 * @date 2018/7/13 上午10:16.
 */
public class WxMaterialListResultAdapter implements JsonDeserializer<WxMaterialListResult> {
    @Override
    public WxMaterialListResult deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject o = jsonElement.getAsJsonObject();
        WxMaterialListResult result = new WxMaterialListResult();
        int totalCount = o.get("total_count").getAsInt();
        int itemCount = o.get("item_count").getAsInt();
        result.setItemCount(itemCount);
        result.setTotalCount(totalCount);
        JsonArray array = o.get("item").getAsJsonArray();
        List<WxMaterialListResult.ItemResult> list = Lists.newArrayList();
        for (JsonElement e : array) {
            WxMaterialListResult.ItemResult item = new WxMaterialListResult.ItemResult();
            JsonObject temp = e.getAsJsonObject();
            String mediaId = temp.get("media_id").getAsString();
            item.setMediaId(mediaId);
            String updateTime = temp.get("update_time").getAsString();
            item.setUpdateTime(updateTime);
            JsonObject contentObject = temp.get("content").getAsJsonObject();
            JsonArray newsArray = contentObject.get("news_item").getAsJsonArray();
            WxMaterialListResult.ContentResult contentResult = new WxMaterialListResult.ContentResult();
            List<MaterialResult> newsList = Lists.newArrayList();
            for (JsonElement element : newsArray) {
                JsonObject tempNews = element.getAsJsonObject();
                MaterialResult mr = new MaterialResult();
                String author = temp.get("author").getAsString();
                mr.setAuthor(author);
                String content = temp.get("content").getAsString();
                mr.setContent(content);
                String contentSourceUrl = temp.get("content_source_url").getAsString();
                mr.setContentSourceUrl(contentSourceUrl);
                String digest = temp.get("digest").getAsString();
                mr.setDigest(digest);
                String showCoverPic = temp.get("show_cover_pic").getAsString();
                mr.setShowCoverPic(showCoverPic);
                String thumbMediaId = temp.get("thumb_media_id").getAsString();
                mr.setThumbMediaId(thumbMediaId);
                String title = temp.get("title").getAsString();
                mr.setTitle(title);
                String url = temp.get("url").getAsString();
                mr.setUrl(url);
                newsList.add(mr);
            }
            String updateTimeContent = contentObject.get("update_time").getAsString();
            contentResult.setNewsItem(newsList);
            contentResult.setUpdateTime(updateTimeContent);
            item.setContent(contentResult);
        }
        result.setItem(list);
        return result;
    }
}
