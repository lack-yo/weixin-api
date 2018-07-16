package com.lou.weixin.sdk.bean;


import com.lou.weixin.sdk.constants.MenuType;
import com.lou.weixin.sdk.utils.json.WxGsonBuilder;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 公众号菜单
 *
 * @author loufeng
 * @date 2018/7/9 下午2:26.
 */
public class WxMenu {
    private List<WxMenuButton> buttons = new ArrayList<WxMenuButton>();

    public List<WxMenuButton> getButtons() {
        return buttons;
    }

    public void setButtons(List<WxMenuButton> buttons) {
        this.buttons = buttons;
    }

    public void addButton(WxMenuButton button) {
        this.buttons.add(button);
    }

    public String toJson() {
        return WxGsonBuilder.create().toJson(this);
    }

    public static WxMenu fromJson(String json) {
        return WxGsonBuilder.create().fromJson(json, WxMenu.class);
    }

    public static WxMenu fromJson(InputStream is) {
        return WxGsonBuilder.create().fromJson(new InputStreamReader(is), WxMenu.class);
    }

    public static class WxMenuButton {

        private String appId;
        private String pagePath;
        private MenuType type;
        private String name;
        private String key;
        private String url;
        private String value;
        private String newsInfo;

        private List<WxMenuButton> subButtons = new ArrayList<WxMenuButton>();

        public String getAppId() {
            return appId;
        }

        public void setAppId(String appId) {
            this.appId = appId;
        }

        public String getPagePath() {
            return pagePath;
        }

        public void setPagePath(String pagePath) {
            this.pagePath = pagePath;
        }

        public MenuType getType() {
            return type;
        }

        public void setType(MenuType type) {
            this.type = type;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getNewsInfo() {
            return newsInfo;
        }

        public void setNewsInfo(String newsInfo) {
            this.newsInfo = newsInfo;
        }

        public List<WxMenuButton> getSubButtons() {
            return subButtons;
        }

        public void setSubButtons(List<WxMenuButton> subButtons) {
            this.subButtons = subButtons;
        }

        public void addSubButton(WxMenuButton subButton) {
            this.subButtons.add(subButton);
        }

    }
}
