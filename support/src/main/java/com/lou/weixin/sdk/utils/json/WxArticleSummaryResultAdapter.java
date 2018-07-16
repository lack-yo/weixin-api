package com.lou.weixin.sdk.utils.json;

import com.google.common.collect.Lists;
import com.google.gson.*;
import com.lou.weixin.sdk.bean.result.WxArticleSummaryDetail;
import com.lou.weixin.sdk.bean.result.WxArticleSummaryResult;

import java.lang.reflect.Type;
import java.util.List;

/**
 * 图文分析数据转换
 * https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1421141084
 *
 * @author loufeng
 * @date 2018/7/13 上午9:35.
 */
public class WxArticleSummaryResultAdapter implements JsonDeserializer<WxArticleSummaryResult> {
    @Override
    public WxArticleSummaryResult deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject o = jsonElement.getAsJsonObject();
        JsonArray array = o.get("list").getAsJsonArray();
        List<WxArticleSummaryDetail> list = Lists.newArrayList();
        if (array.size() == 0) {
            return null;
        }
        for (JsonElement e : array) {
            JsonObject temp = e.getAsJsonObject();
            WxArticleSummaryDetail detail = new WxArticleSummaryDetail();
            String refDate = temp.get("ref_date").getAsString();
            detail.setRefDate(refDate);
            String msgid = temp.get("msgid").getAsString();
            detail.setMsgid(msgid);
            String title = temp.get("title").getAsString();
            detail.setTitle(title);
            int intPageReadUser = temp.get("int_page_read_user").getAsInt();
            detail.setIntPageReadUser(intPageReadUser);
            int intPageReadCount = temp.get("int_page_read_count").getAsInt();
            detail.setIntPageReadCount(intPageReadCount);
            int oriPageReadUser = temp.get("ori_page_read_user").getAsInt();
            detail.setOriPageReadUser(oriPageReadUser);
            int oriPageReadCount = temp.get("ori_page_read_count").getAsInt();
            detail.setOriPageReadCount(oriPageReadCount);
            int shareUser = temp.get("share_user").getAsInt();
            detail.setShareUser(shareUser);
            int shareCount = temp.get("share_count").getAsInt();
            detail.setShareCount(shareCount);
            int addToFavUser = temp.get("add_to_fav_user").getAsInt();
            detail.setAddToFavUser(addToFavUser);
            int addToFavCount = temp.get("add_to_fav_count").getAsInt();
            detail.setAddToFavCount(addToFavCount);
            list.add(detail);
        }
        WxArticleSummaryResult result = new WxArticleSummaryResult();
        result.setList(list);
        return result;
    }
}
