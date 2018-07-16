package com.lou.weixin.sdk.bean.result;


import com.lou.weixin.sdk.utils.json.WxGsonBuilder;

/**
 * @author loufeng
 * @date 2018/7/9 下午2:00.
 */
public class WxMassUploadResult {
    /**
     * 媒体文件类型，分别有图片（image）、语音（voice）、视频（video）和缩略图（thumb），图文(news)
     */
    private String type;
    /**
     * 媒体文件/图文消息上传后获取的唯一标识
     */
    private String mediaId;
    /**
     * 媒体文件上传时间
     */
    private long createdAt;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    public static WxMassUploadResult fromJson(String json) {
        return WxGsonBuilder.create().fromJson(json, WxMassUploadResult.class);
    }

    @Override
    public String toString() {
        return "WxMassUploadResult [type=" + type + ", media_id=" + mediaId + ", created_at=" + createdAt + "]";
    }
}
