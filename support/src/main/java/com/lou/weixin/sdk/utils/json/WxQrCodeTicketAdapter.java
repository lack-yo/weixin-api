package com.lou.weixin.sdk.utils.json;

import com.google.gson.*;
import com.lou.weixin.sdk.bean.result.WxQrCodeTicket;
import com.lou.weixin.sdk.utils.GsonConvertUtil;

import java.lang.reflect.Type;

/**
 * 公众号带参数二维码Gson适配
 *
 * @author loufeng
 * @date 2018/7/9 下午3:09.
 */
public class WxQrCodeTicketAdapter implements JsonDeserializer<WxQrCodeTicket> {

    @Override
    public WxQrCodeTicket deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
            throws JsonParseException {
        WxQrCodeTicket ticket = new WxQrCodeTicket();
        JsonObject ticketJsonObject = json.getAsJsonObject();

        if (ticketJsonObject.get("ticket") != null && !ticketJsonObject.get("ticket").isJsonNull()) {
            ticket.setTicket(GsonConvertUtil.getAsString(ticketJsonObject.get("ticket")));
        }
        if (ticketJsonObject.get("expire_seconds") != null && !ticketJsonObject.get("expire_seconds").isJsonNull()) {
            ticket.setExpireSeconds(GsonConvertUtil.getAsPrimitiveInt(ticketJsonObject.get("expire_seconds")));
        }
        if (ticketJsonObject.get("url") != null && !ticketJsonObject.get("url").isJsonNull()) {
            ticket.setUrl(GsonConvertUtil.getAsString(ticketJsonObject.get("url")));
        }
        return ticket;
    }

}
