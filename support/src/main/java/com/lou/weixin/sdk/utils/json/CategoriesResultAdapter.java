package com.lou.weixin.sdk.utils.json;

import com.google.common.collect.Lists;
import com.google.gson.*;
import com.lou.weixin.sdk.bean.mina.MinaCategory;
import com.lou.weixin.sdk.bean.result.weapp.CategoriesResult;

import java.lang.reflect.Type;
import java.util.List;

/**
 * @author loufeng
 * @date 2018/7/12 下午2:38.
 */
public class CategoriesResultAdapter implements JsonDeserializer<CategoriesResult> {
    @Override
    public CategoriesResult deserialize(JsonElement json, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        CategoriesResult result = new CategoriesResult();
        JsonObject o = json.getAsJsonObject();
        JsonArray array = o.get("category_list").getAsJsonArray();
        List<MinaCategory> list = Lists.newArrayList();
        for (JsonElement element : array) {
            MinaCategory category = new MinaCategory();
            JsonObject temp = element.getAsJsonObject();
            String firstClass = temp.get("first_class").getAsString();
            category.setFirstClass(firstClass);
            int firstId = temp.get("first_id").getAsInt();
            category.setFirstId(firstId);

            String secondClass = temp.get("second_class").getAsString();
            category.setFirstClass(secondClass);
            int secondId = temp.get("second_id").getAsInt();
            category.setSecondId(secondId);
            list.add(category);
        }
        result.setCategoryList(list);
        return result;
    }
}
