package com.lou.weixin.sdk.utils.json;

import com.google.gson.*;
import com.google.gson.internal.Streams;
import com.google.gson.stream.JsonReader;
import com.lou.weixin.sdk.bean.result.weapp.UserPortrait;
import com.lou.weixin.sdk.bean.result.weapp.UserPortraitItem;
import com.lou.weixin.sdk.utils.GsonConvertUtil;

import java.io.StringReader;
import java.lang.reflect.Type;

/**
 * 小程序用户画像Gson适配
 *
 * @author loufeng
 * @date 2018/7/9 下午3:09.
 */
public class UserPortraitItemAdapter implements JsonDeserializer<UserPortrait> {

    @Override
    public UserPortrait deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
            throws JsonParseException {
        JsonObject o = json.getAsJsonObject();
        UserPortrait userPortrait = new UserPortrait();
        userPortrait.setRefDate(GsonConvertUtil.getString(o, "ref_date"));
        JsonObject uvNew = o.get("visit_uv_new").getAsJsonObject();
        UserPortraitItem userNew = getUser(uvNew);
        JsonObject uv = o.get("visit_uv").getAsJsonObject();
        UserPortraitItem user = getUser(uv);
        userPortrait.setVisitUv(user);
        userPortrait.setVisitUvNew(userNew);
        return userPortrait;
    }

    public static void main(String[] args) {
        String str = "{\n" +
                "  \"ref_date\": \"20170611\",\n" +
                "  \"visit_uv_new\": {\n" +
                "    \"province\": [\n" +
                "      {\n" +
                "        \"id\": 31,\n" +
                "        \"name\": \"广东省\",\n" +
                "        \"value\": 215\n" +
                "      }\n" +
                "    ],\n" +
                "    \"city\": [\n" +
                "     {\n" +
                "        \"id\": 3102,\n" +
                "        \"name\": \"广州\",\n" +
                "        \"value\": 78\n" +
                "      }\n" +
                "    ],\n" +
                "    \"genders\": [\n" +
                "      {\n" +
                "        \"id\": 1,\n" +
                "        \"name\": \"男\",\n" +
                "        \"value\": 2146\n" +
                "      }\n" +
                "    ],\n" +
                "    \"platforms\": [\n" +
                "      {\n" +
                "        \"id\": 1,\n" +
                "        \"name\": \"iPhone\",\n" +
                "        \"value\": 27642\n" +
                "      }\n" +
                "    ],\n" +
                "    \"devices\": [\n" +
                "      {\n" +
                "        \"name\": \"OPPO R9\",\n" +
                "        \"value\": 61\n" +
                "      }\n" +
                "    ],\n" +
                "    \"ages\": [\n" +
                "      {\n" +
                "        \"id\": 1,\n" +
                "        \"name\": \"17岁以下\",\n" +
                "        \"value\": 151\n" +
                "      }\n" +
                "    ]\n" +
                "  },\n" +
                "  \"visit_uv\": {\n" +
                "    \"province\": [\n" +
                "      {\n" +
                "        \"id\": 31,\n" +
                "        \"name\": \"广东省\",\n" +
                "        \"value\": 1341\n" +
                "      }\n" +
                "    ],\n" +
                "    \"city\": [\n" +
                "     {\n" +
                "        \"id\": 3102,\n" +
                "        \"name\": \"广州\",\n" +
                "        \"value\": 234\n" +
                "      }\n" +
                "    ],\n" +
                "    \"genders\": [\n" +
                "      {\n" +
                "        \"id\": 1,\n" +
                "        \"name\": \"男\",\n" +
                "        \"value\": 14534\n" +
                "      }\n" +
                "    ],\n" +
                "    \"platforms\": [\n" +
                "      {\n" +
                "        \"id\": 1,\n" +
                "        \"name\": \"iPhone\",\n" +
                "        \"value\": 21750\n" +
                "      }\n" +
                "    ],\n" +
                "    \"devices\": [\n" +
                "      {\n" +
                "        \"name\": \"OPPO R9\",\n" +
                "        \"value\": 617\n" +
                "      }\n" +
                "    ],\n" +
                "    \"ages\": [\n" +
                "      {\n" +
                "        \"id\": 1,\n" +
                "        \"name\": \"17岁以下\",\n" +
                "        \"value\": 3156\n" +
                "      }\n" +
                "    ]\n" +
                "  }\n" +
                "}";
        JsonElement json = Streams.parse(new JsonReader(new StringReader(str)));
    }

    private static UserPortraitItem getUser(JsonObject u) {
        UserPortraitItem user = new UserPortraitItem();
        user.setProvince(u.get("province").toString());
        user.setCity(u.get("city").toString());
        user.setGenders(u.get("genders").toString());
        user.setPlatfomrs(u.get("platforms").toString());
        user.setDevices(u.get("devices").toString());
        user.setAges(u.get("ages").toString());
        return user;
    }

}
