package com.lou.weixin.sdk.constants;


import org.apache.commons.lang3.StringUtils;

/**
 * 菜单类型
 *
 * @author loufeng
 * @date 2018/7/4 下午4:12.
 */
public enum MenuType {
    // 点击推事件
    click,
    // 跳转URL
    view,
    //小程序
    miniprogram,
    // 扫码推事件
    scancode_push,
    // 扫码推事件且弹出“消息接收中”提示框
    scancode_waitmsg,
    // 弹出系统拍照发图
    pic_sysphoto,
    // 弹出拍照或者相册发图
    pic_photo_or_album,
    // 弹出微信相册发图器
    pic_weixin,
    // 弹出地理位置选择器
    location_select,
    // 文本
    text,
    //图片
    img,
    photo,
    //视频
    video,
    //语音
    voice;

    public static MenuType parseFromStr(String str) {
        if (StringUtils.isEmpty(str)) {
            return MenuType.view;
        }

        for (MenuType type : MenuType.values()) {
            if (type.toString().equalsIgnoreCase(str)) {
                return type;
            }
        }

        return MenuType.view;
    }

}
