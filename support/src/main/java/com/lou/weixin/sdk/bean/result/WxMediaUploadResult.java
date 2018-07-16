package com.lou.weixin.sdk.bean.result;


import com.lou.weixin.sdk.constants.MediaType;
import com.lou.weixin.sdk.utils.json.WxGsonBuilder;

/**
 * 素材上传result
 *
 * @author loufeng
 * @date 2018/7/9 下午2:06.
 */
public class WxMediaUploadResult {
    /**
     * 上传的多媒体类型
     */
    private MediaType type;
    /**
     * 媒体文件上传后，获取时的唯一标识
     */
    private String mediaId;
    /**
     * 临时素材id
     */
    private String thumbMediaId;
    /**
     * 媒体文件上传时间戳
     */
    private Long createdAt;

    public MediaType getType() {
        return type;
    }

    public void setType(MediaType type) {
        this.type = type;
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public String getThumbMediaId() {
        return thumbMediaId;
    }

    public void setThumbMediaId(String thumbMediaId) {
        this.thumbMediaId = thumbMediaId;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    public String getTypeAsString() {
        return type.toString();
    }

    public static WxMediaUploadResult fromJson(String json) {
        return WxGsonBuilder.create().fromJson(json, WxMediaUploadResult.class);
    }

    @Override
    public String toString() {
        return "WxMediaUploadResult{" +
                "type=" + type +
                ", mediaId='" + mediaId + '\'' +
                ", thumbMediaId='" + thumbMediaId + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
