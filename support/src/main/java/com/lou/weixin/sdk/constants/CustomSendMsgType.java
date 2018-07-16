package com.lou.weixin.sdk.constants;

/**
 * 客服消息类型
 *
 * @author loufeng
 * @date 2018/7/4 下午4:02.
 */
public enum CustomSendMsgType {
    /**
     * 文本
     */
    text,
    /**
     * 图片
     */
    image,
    /**
     * 语音
     */
    voice,
    /**
     * 视频
     */
    video,
    /**
     * 音乐
     */
    music,
    /**
     * 图文
     */
    news;

    @Override
    public String toString() {
        switch (this) {
            case news:
                return "news";
            case voice:
                return "voice";
            case video:
                return "video";
            case text:
                return "text";
            case image:
                return "image";
            case music:
                return "music";
            default:
                return "unknow";
        }
    }
}
