package com.lou.weixin.sdk.bean.msg;

import com.lou.weixin.sdk.constants.MsgType;
import com.lou.weixin.sdk.utils.XmlParseUtil;
import org.dom4j.Element;

/**
 * 图片消息
 *
 * @author loufeng
 * @date 2018/7/9 下午3:22.
 */
public class ImageMessage extends WxMessage {

    private static final long serialVersionUID = -1026377372181211630L;

    /**
     * 图片链接
     */
    private String picUrl;
    /**
     * 图片消息媒体id，可以调用多媒体文件下载接口拉取数据
     */
    private String mediaId;

    public ImageMessage() {
        this.setMsgType(MsgType.image);
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    @Override
    public void fromXmlNode(Element element) {
        this.picUrl = XmlParseUtil.getSubElementString(element, "picUrl");
        this.mediaId = XmlParseUtil.getSubElementString(element, "mediaId");
    }

    @Override
    public void toXmlNode(Element element) {

    }

    @Override
    public String toString() {
        return "ImageMessage[msgId=" + this.getMsgId() + ",msgType="
                + (null == this.getMsgType() ? "" : this.getMsgType().toString()) + ",picUrl=" + this.picUrl
                + ",mediaId=" + this.mediaId + "]";
    }
}
