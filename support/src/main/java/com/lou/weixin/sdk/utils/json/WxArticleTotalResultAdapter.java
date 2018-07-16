package com.lou.weixin.sdk.utils.json;

import com.google.common.collect.Lists;
import com.google.gson.*;
import com.lou.weixin.sdk.bean.result.WxArticleTotalResult;

import java.lang.reflect.Type;
import java.util.List;

/**
 * 图文数据详情适配
 * https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1421141084
 *
 * @author loufeng
 * @date 2018/7/13 上午10:00.
 */
public class WxArticleTotalResultAdapter implements JsonDeserializer<WxArticleTotalResult> {
    @Override
    public WxArticleTotalResult deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject o = jsonElement.getAsJsonObject();
        JsonArray array = o.get("list").getAsJsonArray();
        List<WxArticleTotalResult.DataList> list = Lists.newArrayList();
        if (array.size() == 0) {
            return null;
        }
        for (JsonElement e : array) {
            WxArticleTotalResult.DataList item = new WxArticleTotalResult.DataList();
            JsonObject temp = e.getAsJsonObject();
            String refDate = temp.get("ref_date").getAsString();
            item.setRefDate(refDate);
            String msgid = temp.get("msgid").getAsString();
            item.setMsgid(msgid);
            String title = temp.get("title").getAsString();
            item.setTitle(title);

            List<WxArticleTotalResult.DataDetails> details = Lists.newArrayList();
            JsonArray arrayDetail = temp.get("details").getAsJsonArray();
            for (JsonElement element : arrayDetail) {
                WxArticleTotalResult.DataDetails detail = new WxArticleTotalResult.DataDetails();
                JsonObject tempDetail = e.getAsJsonObject();
                int addToFavUser = temp.get("add_to_fav_user").getAsInt();
                detail.setAddToFavUser(addToFavUser);
                int feedShareFromFeedUser = temp.get("feed_share_from_feed_user").getAsInt();
                detail.setFeedsharefromfeeduser(feedShareFromFeedUser);
                int feedShareFromOtherUser = temp.get("feed_share_from_other_user").getAsInt();
                detail.setFeedsharefromotheruser(feedShareFromOtherUser);
                int feedShareFromSessionUser = temp.get("feed_share_from_session_user").getAsInt();
                detail.setFeedsharefromsessionuser(feedShareFromSessionUser);
                int intPageReadCount = temp.get("int_page_read_count").getAsInt();
                detail.setIntPageReadCount(intPageReadCount);
                int intPageReadUser = temp.get("int_page_read_user").getAsInt();
                detail.setIntPageReadUser(intPageReadUser);
                int oriPageReadUser = temp.get("ori_page_read_user").getAsInt();
                detail.setOriPageReadUser(oriPageReadUser);
                int shareUser = temp.get("share_user").getAsInt();
                detail.setShareUser(shareUser);
                String statDate = temp.get("stat_date").getAsString();
                detail.setStatDate(statDate);
                int targetUser = temp.get("target_user").getAsInt();
                detail.setTargetUser(targetUser);
                details.add(detail);
            }
            item.setDetails(details);

        }
        WxArticleTotalResult result = new WxArticleTotalResult();
        result.setList(list);
        return result;
    }
}
