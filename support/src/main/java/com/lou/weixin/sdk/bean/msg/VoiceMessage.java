package com.lou.weixin.sdk.bean.msg;

import com.lou.weixin.sdk.constants.MsgType;
import com.lou.weixin.sdk.utils.XmlParseUtil;
import org.dom4j.Element;

/**
 * 语音消息
 *
 * @author loufeng
 * @date 2018/7/9 下午3:22.
 */
public class VoiceMessage extends WxMessage {

    private static final long serialVersionUID = -2352539933790232445L;

    /**
     * 语音消息媒体id，可以调用多媒体文件下载接口拉取数据
     */
    private String mediaId;
    /**
     * 语音格式，如amr，speex等
     */
    private String format;

    /**
     * 语音识别结果，UTF8编码
     */
    private String recognition;

    public VoiceMessage() {
        this.setMsgType(MsgType.voice);
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getRecognition() {
        return recognition;
    }

    public void setRecognition(String recognition) {
        this.recognition = recognition;
    }

    @Override
    public void fromXmlNode(Element element) {
        this.format = XmlParseUtil.getSubElementString(element, "format");
        this.mediaId = XmlParseUtil.getSubElementString(element, "mediaId");
        this.recognition = XmlParseUtil.getSubElementString(element, "recognition");
    }

    @Override
    public void toXmlNode(Element element) {

    }

}
