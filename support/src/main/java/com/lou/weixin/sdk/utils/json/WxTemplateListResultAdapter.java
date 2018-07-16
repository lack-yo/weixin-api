package com.lou.weixin.sdk.utils.json;

import com.google.common.collect.Lists;
import com.google.gson.*;
import com.lou.weixin.sdk.bean.result.WxTemplateListResult;

import java.lang.reflect.Type;
import java.util.List;

/**
 * @author loufeng
 * @date 2018/7/13 上午10:48.
 */
public class WxTemplateListResultAdapter implements JsonDeserializer<WxTemplateListResult> {
    @Override
    public WxTemplateListResult deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject o = jsonElement.getAsJsonObject();
        JsonArray array = o.get("template_list").getAsJsonArray();
        if (array.size() == 0) {
            return null;
        }
        List<WxTemplateListResult.WxTemplate> templateList = Lists.newArrayList();
        for (JsonElement e : array) {
            WxTemplateListResult.WxTemplate template = new WxTemplateListResult.WxTemplate();
            JsonObject temp = e.getAsJsonObject();
            String content = temp.get("content").getAsString();
            template.setContent(content);
            String deputyIndustry = temp.get("deputy_industry").getAsString();
            template.setDeputyIndustry(deputyIndustry);
            String example = temp.get("example").getAsString();
            template.setExample(example);
            String primaryIndustry = temp.get("primary_industry").getAsString();
            template.setPrimaryIndustry(primaryIndustry);
            String templateId = temp.get("template_id").getAsString();
            template.setTemplateId(templateId);
            String title = temp.get("title").getAsString();
            template.setTitle(title);
            templateList.add(template);
        }
        WxTemplateListResult result = new WxTemplateListResult();
        result.setTemplateList(templateList);
        return result;
    }
}
