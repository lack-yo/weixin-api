package com.lou.weixin.sdk.utils.json;

import com.google.common.collect.Lists;
import com.google.gson.*;
import com.lou.weixin.sdk.bean.result.UpstreamMsgDetail;
import com.lou.weixin.sdk.bean.result.UpstreamMsgResult;

import java.lang.reflect.Type;
import java.util.List;

/**
 * 消息分析数据转换
 *
 * @author loufeng
 * @date 2018/7/13 上午9:27.
 */
public class UpstreamMsgResultAdapter implements JsonDeserializer<UpstreamMsgResult> {
    @Override
    public UpstreamMsgResult deserialize(JsonElement json, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject o = json.getAsJsonObject();
        JsonArray array = o.get("list").getAsJsonArray();
        List<UpstreamMsgDetail> list = Lists.newArrayList();
        if (array.size() == 0) {
            return null;
        }
        for (JsonElement e : array) {
            JsonObject temp = e.getAsJsonObject();
            UpstreamMsgDetail detail = new UpstreamMsgDetail();
            String refDate = temp.get("ref_date").getAsString();
            detail.setRefDate(refDate);
            int msgType = temp.get("msg_type").getAsInt();
            detail.setMsgType(msgType);
            int msgUser = temp.get("msg_user").getAsInt();
            detail.setMsgUser(msgUser);
            int msgCount = temp.get("msg_count").getAsInt();
            detail.setMsgCount(msgCount);
            list.add(detail);
        }
        UpstreamMsgResult result = new UpstreamMsgResult();
        result.setList(list);
        return result;
    }
}
