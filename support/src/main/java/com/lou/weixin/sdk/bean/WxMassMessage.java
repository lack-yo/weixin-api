package com.lou.weixin.sdk.bean;


import com.lou.weixin.sdk.constants.MassSendMsgType;

/**
 * 消息
 *
 * @author loufeng
 * @date 2018/7/9 下午2:26.
 */
public abstract class WxMassMessage {
    /**
     * 类型
     */
    private MassSendMsgType msgType;

    /**
     * 文本消息的内容<br>
     * 该字段仅群发文本消息时用到
     */
    private String content;

    /**
     * 群发非文本消息时，该字段必须要填写
     */
    private String mediaId;

    /**
     * 视频消息的标题<br>
     * 该字段仅群发视频消息时用到
     */
    private String title;

    /**
     * 视频消息的描述<br>
     * 该字段仅群发视频消息时用到
     */
    private String description;

    public MassSendMsgType getMsgType() {
        return msgType;
    }

    public void setMsgType(MassSendMsgType msgType) {
        this.msgType = msgType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

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

    public abstract String toJson();
}
