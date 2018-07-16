package com.lou.weixin.sdk.constants;

/**
 * 素材类型
 *
 * @author loufeng
 * @date 2018/7/4 下午4:12.
 */
public enum MediaType {
    // 图片
    image,
    // 语音
    voice,
    // 视频
    video,
    // 缩略图
    thumb,
    // 图文
    news,
    // 未知的媒体类型
    unknown;

    public static MediaType parseFromStr(String str) {
        if (null == str || str.length() == 0) {
            return MediaType.unknown;
        }

        for (MediaType type : MediaType.values()) {
            if (type.toString().equalsIgnoreCase(str)) {
                return type;
            }
        }

        return MediaType.unknown;
    }

    @Override
    public String toString() {
        switch (this) {
            case image:
                return "image";
            case news:
                return "news";
            case voice:
                return "voice";
            case video:
                return "video";
            case thumb:
                return "thumb";
            default:
                return "unknow";
        }
    }
}
