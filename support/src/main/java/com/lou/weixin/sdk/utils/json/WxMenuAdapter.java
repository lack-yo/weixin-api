package com.lou.weixin.sdk.utils.json;

import com.google.gson.*;
import com.lou.weixin.sdk.bean.WxMenu;
import com.lou.weixin.sdk.constants.MenuType;
import com.lou.weixin.sdk.utils.GsonConvertUtil;

import java.lang.reflect.Type;

/**
 * 公众号菜单Gson适配
 *
 * @author loufeng
 * @date 2018/7/9 下午3:09.
 */
public class WxMenuAdapter implements JsonSerializer<WxMenu>, JsonDeserializer<WxMenu> {
    public JsonElement serialize(WxMenu menu, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject json = new JsonObject();

        JsonArray buttonArray = new JsonArray();
        for (WxMenu.WxMenuButton button : menu.getButtons()) {
            JsonObject buttonJson = convertToJson(button);
            buttonArray.add(buttonJson);
        }
        json.add("button", buttonArray);

        return json;
    }

    protected JsonObject convertToJson(WxMenu.WxMenuButton button) {
        JsonObject buttonJson = new JsonObject();
        buttonJson.addProperty("appid", button.getAppId());
        buttonJson.addProperty("type", button.getType() == null ? null : button.getType().toString());
        buttonJson.addProperty("name", button.getName());
        buttonJson.addProperty("pagepath", button.getPagePath());
        buttonJson.addProperty("key", button.getKey());
        buttonJson.addProperty("url", button.getUrl());
        if (button.getSubButtons() != null && button.getSubButtons().size() > 0) {
            JsonArray buttonArray = new JsonArray();
            for (WxMenu.WxMenuButton sub_button : button.getSubButtons()) {
                buttonArray.add(convertToJson(sub_button));
            }
            buttonJson.add("sub_button", buttonArray);
        }
        return buttonJson;
    }

    public WxMenu deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        /*
         * 操蛋的微信
         * 创建菜单时是 { button : ... }
         * 查询菜单时是 { menu : { button : ... } }
         */
        WxMenu menu = new WxMenu();
        JsonObject menuJson = null;
        if (json.getAsJsonObject().get("menu") != null) {
            menuJson = json.getAsJsonObject().get("menu").getAsJsonObject();
        }
        if (menuJson == null) {
            //个性化菜单接口嵌套了selfmenu_info
            JsonElement menuElement = json.getAsJsonObject().get("selfmenu_info");
            if (menuElement == null) {
                return null;
            }
            menuJson = menuElement.getAsJsonObject();
        }
        JsonArray buttonsJson = menuJson.get("button").getAsJsonArray();
        for (int i = 0; i < buttonsJson.size(); i++) {
            JsonObject buttonJson = buttonsJson.get(i).getAsJsonObject();
            WxMenu.WxMenuButton button = convertFromJson(buttonJson);
            menu.getButtons().add(button);
            if (buttonJson.get("sub_button") == null || buttonJson.get("sub_button").isJsonNull()) {
                continue;
            }
            JsonArray sub_buttonsJson = null;
            JsonElement subButton = buttonJson.get("sub_button");
            if (subButton.getAsJsonObject().get("list") != null) {
                //个性化菜单接口嵌套了list
                sub_buttonsJson = subButton.getAsJsonObject().get("list").getAsJsonArray();
            } else {
                //自定义菜单查询是已sub_button数组返回的
                sub_buttonsJson = subButton.getAsJsonArray();
            }

            for (int j = 0; j < sub_buttonsJson.size(); j++) {
                JsonObject sub_buttonJson = sub_buttonsJson.get(j).getAsJsonObject();
                button.getSubButtons().add(convertFromJson(sub_buttonJson));
            }
        }
        return menu;
    }

    protected WxMenu.WxMenuButton convertFromJson(JsonObject json) {
        WxMenu.WxMenuButton button = new WxMenu.WxMenuButton();
        button.setAppId(GsonConvertUtil.getString(json, "appid"));
        button.setPagePath(GsonConvertUtil.getString(json, "pagepath"));
        button.setName(GsonConvertUtil.getString(json, "name"));
        button.setKey(GsonConvertUtil.getString(json, "key"));
        button.setUrl(GsonConvertUtil.getString(json, "url"));
        button.setValue(GsonConvertUtil.getString(json, "value"));
        button.setNewsInfo(GsonConvertUtil.getString(json, "news_info"));
        button.setType(MenuType.parseFromStr(GsonConvertUtil.getString(json, "type")));
        return button;
    }
}
