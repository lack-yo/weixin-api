package com.lou.weixin.sdk.bean.msg;

import com.lou.weixin.sdk.constants.MsgType;
import com.lou.weixin.sdk.utils.XmlParseUtil;
import org.dom4j.Element;

/**
 * 视频消息
 *
 * @author loufeng
 * @date 2018/7/9 下午3:22.
 */
public class VideoMessage extends WxMessage {

    private static final long serialVersionUID = 5146793569775233077L;

    /**
     * 视频消息媒体id，可以调用多媒体文件下载接口拉取数据
     */
    private String mediaId;
    /**
     * 视频消息缩略图的媒体id，可以调用多媒体文件下载接口拉取数据
     */
    private String thumbMediaId;

    public VideoMessage() {
        this.setMsgType(MsgType.video);
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

    @Override
    public void fromXmlNode(Element element) {
        this.thumbMediaId = XmlParseUtil.getSubElementString(element, "thumbMediaId");
        this.mediaId = XmlParseUtil.getSubElementString(element, "mediaId");
    }

    @Override
    public void toXmlNode(Element element) {
    }

}
