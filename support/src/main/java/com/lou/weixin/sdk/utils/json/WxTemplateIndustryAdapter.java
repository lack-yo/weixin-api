package com.lou.weixin.sdk.utils.json;

import com.google.gson.*;
import com.lou.weixin.sdk.bean.result.WxTemplateIndustry;

import java.lang.reflect.Type;

/**
 * @author loufeng
 * @date 2018/7/13 上午10:59.
 */
public class WxTemplateIndustryAdapter implements JsonDeserializer<WxTemplateIndustry> {
    @Override
    public WxTemplateIndustry deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject o = jsonElement.getAsJsonObject();
        WxTemplateIndustry industryResult = new WxTemplateIndustry();
        JsonObject pi = o.get("primary_industry").getAsJsonObject();
        WxTemplateIndustry.Industry industry = getIndustry(pi);
        industryResult.setPrimaryIndustry(industry);
        JsonObject si = o.get("secondary_industry").getAsJsonObject();
        WxTemplateIndustry.Industry industry2 = getIndustry(si);
        industryResult.setPrimaryIndustry(industry2);
        return industryResult;
    }

    private WxTemplateIndustry.Industry getIndustry(JsonObject pi) {
        String firstClass = pi.get("first_class").getAsString();
        String secondClass = pi.get("second_class").getAsString();
        WxTemplateIndustry.Industry industry = new WxTemplateIndustry.Industry();
        industry.setFirstClass(firstClass);
        industry.setSecondClass(secondClass);
        return industry;
    }
}
