package com.lou.weixin.sdk.bean;


import com.lou.weixin.sdk.constants.CustomSendMsgType;
import com.lou.weixin.sdk.utils.json.WxGsonBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * 客服消息构造
 *
 * @author loufeng
 * @date 2018/7/9 下午2:26.
 */
public class WxCustomMessage {
    /**
     * 用户openid
     */
    private String toUser;
    /**
     * 客服消息的类型
     *
     * @see CustomSendMsgType
     */
    private CustomSendMsgType msgType;
    /**
     * 文本消息内容
     */
    private String content;
    /**
     * 媒体ID,通过上传多媒体文件获得
     */
    private String mediaId;
    /**
     * 缩略图的媒体ID
     */
    private String thumbMediaId;
    /**
     * 标题
     */
    private String title;
    /**
     * 描述
     */
    private String description;
    /**
     * 音乐链接
     */
    private String musicUrl;
    /**
     * 高品质音乐链接，wifi环境优先使用该链接播放音乐
     */
    private String hqMusicUrl;
    /**
     * 图文消息
     */
    private List<WxArticle> articles = new ArrayList<WxArticle>();

    public String getToUser() {
        return toUser;
    }

    public void setToUser(String toUser) {
        this.toUser = toUser;
    }

    public CustomSendMsgType getMsgType() {
        return msgType;
    }

    public void setMsgType(CustomSendMsgType msgType) {
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

    public String getThumbMediaId() {
        return thumbMediaId;
    }

    public void setThumbMediaId(String thumbMediaId) {
        this.thumbMediaId = thumbMediaId;
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

    public String getMusicUrl() {
        return musicUrl;
    }

    public void setMusicUrl(String musicUrl) {
        this.musicUrl = musicUrl;
    }

    public String getHqMusicUrl() {
        return hqMusicUrl;
    }

    public void setHqMusicUrl(String hqMusicUrl) {
        this.hqMusicUrl = hqMusicUrl;
    }

    public List<WxArticle> getArticles() {
        return articles;
    }

    public void setArticles(List<WxArticle> articles) {
        this.articles = articles;
    }

    public String toJson() {
        return WxGsonBuilder.INSTANCE.create().toJson(this);
    }

    @Override
    public String toString() {
        return "WxCustomMessage{" +
                "toUser='" + toUser + '\'' +
                ", msgType=" + msgType +
                ", content='" + content + '\'' +
                ", mediaId='" + mediaId + '\'' +
                ", thumbMediaId='" + thumbMediaId + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", musicUrl='" + musicUrl + '\'' +
                ", hqMusicUrl='" + hqMusicUrl + '\'' +
                ", articles=" + articles +
                '}';
    }
}
