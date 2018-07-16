package com.lou.weixin.sdk.constants;


import org.apache.commons.lang3.StringUtils;

/**
 * 接收普通消息的枚举类型
 *
 * @author loufeng
 * @date 2018/7/4 下午4:12.
 */
public enum MsgType {
    //文本消息
    text,
    //图片消息
    image,
    //语音消息
    voice,
    //视频消息
    video,
    //地理位置消息
    location,
    //链接消息
    link,
    //事件消息
    event,
    // 多客服
    transfer_customer_service,
    //图文消息
    news;

    public static MsgType parseFromStr(String str) {
        if (StringUtils.isEmpty(str)) {
            return MsgType.text;
        }

        for (MsgType type : MsgType.values()) {
            if (type.toString().equalsIgnoreCase(str)) {
                return type;
            }
        }

        return MsgType.text;
    }

    @Override
    public String toString() {
        switch (this) {
            case text:
                return "text";
            case image:
                return "image";
            case voice:
                return "voice";
            case video:
                return "video";
            case location:
                return "location";
            case link:
                return "link";
            case event:
                return "event";
            case news:
                return "news";
            case transfer_customer_service:
                return "transfer_customer_service";
            default:
                return "unknow";
        }
    }
}
