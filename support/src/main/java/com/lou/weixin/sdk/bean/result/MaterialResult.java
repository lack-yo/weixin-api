package com.lou.weixin.sdk.bean.result;

/**
 * 图文素材
 *
 * @author loufeng
 * @date 2018/7/9 上午11:21.
 */
public class MaterialResult {
    /**
     * 标题
     */
    private String title;
    /**
     * 封面素材
     */
    private String thumbMediaId;
    /**
     * 是否显示封面
     */
    private String showCoverPic;
    /**
     * 作者
     */
    private String author;
    /**
     * 图文消息的摘要
     */
    private String digest;
    /**
     * 图文正文内容
     */
    private String content;
    /**
     * 图文页的URL
     */
    private String url;
    /**
     * 图文消息的原文地址
     */
    private String contentSourceUrl;
    /**
     * 开启评论留言
     */
    private String needOpenComment;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getThumbMediaId() {
        return thumbMediaId;
    }

    public void setThumbMediaId(String thumbMediaId) {
        this.thumbMediaId = thumbMediaId;
    }

    public String getShowCoverPic() {
        return showCoverPic;
    }

    public void setShowCoverPic(String showCoverPic) {
        this.showCoverPic = showCoverPic;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDigest() {
        return digest;
    }

    public void setDigest(String digest) {
        this.digest = digest;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getContentSourceUrl() {
        return contentSourceUrl;
    }

    public void setContentSourceUrl(String contentSourceUrl) {
        this.contentSourceUrl = contentSourceUrl;
    }

    public String getNeedOpenComment() {
        return needOpenComment;
    }

    public void setNeedOpenComment(String needOpenComment) {
        this.needOpenComment = needOpenComment;
    }
}
