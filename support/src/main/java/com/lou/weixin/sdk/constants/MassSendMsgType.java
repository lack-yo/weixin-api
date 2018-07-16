package com.lou.weixin.sdk.constants;

/**
 * 消息类型
 *
 * @author loufeng
 * @date 2018/1/4 下午4:12.
 */
public enum MassSendMsgType {
    // 图文
    mpnews,
    // 文本
    text,
    // 语音
    voice,
    // 图片
    image,
    // 视频
    video;

    @Override
    public String toString() {
        switch (this) {
            case mpnews:
                return "mpnews";
            case voice:
                return "voice";
            case video:
                return "video";
            case text:
                return "text";
            case image:
                return "image";
            default:
                return "unknow";
        }
    }
}
