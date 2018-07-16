package com.lou.weixin.sdk.utils.json;

import com.google.common.collect.Lists;
import com.google.gson.*;
import com.lou.weixin.sdk.bean.result.weapp.CodeTemplate;
import com.lou.weixin.sdk.bean.result.weapp.CodeTemplateResult;

import java.lang.reflect.Type;
import java.util.List;

/**
 * @author loufeng
 * @date 2018/7/12 下午2:52.
 */
public class CodeTemplateResultAdapter implements JsonDeserializer<CodeTemplateResult> {
    @Override
    public CodeTemplateResult deserialize(JsonElement json, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        CodeTemplateResult result = new CodeTemplateResult();
        JsonObject o = json.getAsJsonObject();
        JsonArray array = o.get("template_list").getAsJsonArray();
        List<CodeTemplate> list = Lists.newArrayList();
        for (JsonElement element : array) {
            CodeTemplate template = new CodeTemplate();
            JsonObject temp = element.getAsJsonObject();
            long createTime = temp.get("create_time").getAsLong();
            template.setCreateTime(createTime);
            int templateId = temp.get("template_id").getAsInt();
            template.setTemplateId(templateId);
            String userDesc = temp.get("user_desc").getAsString();
            template.setUserDesc(userDesc);
            String userVersion = temp.get("user_version").getAsString();
            template.setUserVersion(userVersion);
            list.add(template);
        }
        result.setTemplateList(list);
        return result;
    }
}
