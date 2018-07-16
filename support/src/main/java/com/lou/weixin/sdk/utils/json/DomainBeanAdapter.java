package com.lou.weixin.sdk.utils.json;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import com.lou.weixin.sdk.bean.mina.DomainBean;

import java.lang.reflect.Type;
import java.util.List;

/**
 * @author loufeng
 * @date 2018/7/12 下午2:21.
 */
public class DomainBeanAdapter implements JsonDeserializer<DomainBean> {
    @Override
    public DomainBean deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
            throws JsonParseException {
        JsonObject o = json.getAsJsonObject();
        DomainBean domainBean = new DomainBean();
        JsonArray requestdomain = o.get("requestdomain").getAsJsonArray();
        JsonArray wsrequestdomain = o.get("wsrequestdomain").getAsJsonArray();
        JsonArray uploaddomain = o.get("uploaddomain").getAsJsonArray();
        JsonArray downloaddomain = o.get("downloaddomain").getAsJsonArray();
        Gson gson = new Gson();
        List<String> rqDomainList = gson.fromJson(requestdomain, new TypeToken<List<String>>() {
        }.getType());
        List<String> wsDomainList = gson.fromJson(wsrequestdomain, new TypeToken<List<String>>() {
        }.getType());
        List<String> downDomainList = gson.fromJson(downloaddomain, new TypeToken<List<String>>() {
        }.getType());
        List<String> uploadDomainList = gson.fromJson(uploaddomain, new TypeToken<List<String>>() {
        }.getType());

        domainBean.setRequestdomain(rqDomainList);
        domainBean.setWsrequestdomain(wsDomainList);
        domainBean.setUploaddomain(uploadDomainList);
        domainBean.setDownloaddomain(downDomainList);
        return domainBean;
    }
}
