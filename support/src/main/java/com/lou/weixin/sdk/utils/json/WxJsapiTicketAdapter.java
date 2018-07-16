package com.lou.weixin.sdk.utils.json;

import com.google.gson.*;
import com.lou.weixin.sdk.bean.result.WxJsapiTicket;
import com.lou.weixin.sdk.utils.GsonConvertUtil;

import java.lang.reflect.Type;

/**
 * 公众号js ticket的Gson适配
 *
 * @author loufeng
 * @date 2018/7/9 下午3:09.
 */
public class WxJsapiTicketAdapter implements JsonDeserializer<WxJsapiTicket> {

    @Override
    public WxJsapiTicket deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
            throws JsonParseException {
        WxJsapiTicket ticket = new WxJsapiTicket();
        JsonObject ticketJsonObject = json.getAsJsonObject();

        if (ticketJsonObject.get("ticket") != null && !ticketJsonObject.get("ticket").isJsonNull()) {
            ticket.setTicket(GsonConvertUtil.getAsString(ticketJsonObject.get("ticket")));
        }
        if (ticketJsonObject.get("expires_in") != null && !ticketJsonObject.get("expires_in").isJsonNull()) {
            ticket.setExpiresIn(GsonConvertUtil.getAsPrimitiveInt(ticketJsonObject.get("expires_in")));
        }
        return ticket;
    }

}
