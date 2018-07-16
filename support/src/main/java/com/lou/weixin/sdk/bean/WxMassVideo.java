package com.lou.weixin.sdk.bean;


import com.lou.weixin.sdk.utils.json.WxGsonBuilder;

/**
 * 消息群发时用到的视频素材
 *
 * @author loufeng
 * @date 2018/7/9 下午2:26.
 */
public class WxMassVideo {
    /**
     * 用于群发的消息的media_id(此处的mediaId应该从上传下多媒体文件来得到)
     */
    private String mediaId;
    /**
     * 消息的标题
     */
    private String title;
    /**
     * 消息的描述
     */
    private String description;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public String toJson() {
        return WxGsonBuilder.INSTANCE.create().toJson(this);
    }
}
