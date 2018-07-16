package com.lou.weixin.sdk.bean.msg.event;

import com.lou.weixin.sdk.bean.msg.EventMessage;
import com.lou.weixin.sdk.constants.EventMsgType;
import com.lou.weixin.sdk.utils.XmlParseUtil;
import org.apache.commons.lang3.StringUtils;
import org.dom4j.Element;

/**
 * 群发结果推送事件
 *
 * @author loufeng
 * @date 2018/7/9 下午3:22.
 */
public class MassSendJobFinishEventMsg extends EventMessage {

    private static final long serialVersionUID = 748772510517863111L;

    private String status;
    private int totalCount;
    private int filterCount;
    private int sentCount;
    private int errorCount;

    public MassSendJobFinishEventMsg() {
        this.setEventMsgType(EventMsgType.masssendjobfinish);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getFilterCount() {
        return filterCount;
    }

    public void setFilterCount(int filterCount) {
        this.filterCount = filterCount;
    }

    public int getSentCount() {
        return sentCount;
    }

    public void setSentCount(int sentCount) {
        this.sentCount = sentCount;
    }

    public int getErrorCount() {
        return errorCount;
    }

    public void setErrorCount(int errorCount) {
        this.errorCount = errorCount;
    }

    @Override
    public void fromXmlNode(Element element) {
        status = XmlParseUtil.getSubElementString(element, "status");
        if (StringUtils.isNotEmpty(XmlParseUtil.getSubElementString(element, "totalCount"))) {
            totalCount = Integer.valueOf(XmlParseUtil.getSubElementString(element, "totalCount"));
        }
        if (StringUtils.isNotEmpty(XmlParseUtil.getSubElementString(element, "filterCount"))) {
            filterCount = Integer.valueOf(XmlParseUtil.getSubElementString(element, "filterCount"));
        }
        if (StringUtils.isNotEmpty(XmlParseUtil.getSubElementString(element, "sentCount"))) {
            sentCount = Integer.valueOf(XmlParseUtil.getSubElementString(element, "sentCount"));
        }
        if (StringUtils.isNotEmpty(XmlParseUtil.getSubElementString(element, "errorCount"))) {
            errorCount = Integer.valueOf(XmlParseUtil.getSubElementString(element, "errorCount"));
        }
    }

    @Override
    public void toXmlNode(Element element) {

    }

    @Override
    public String toString() {
        return "MassSendJobFinishEventMsg[msgId=" + this.getMsgId() + ",msgType=" + (null == this.getMsgType() ? ""
                : this.getMsgType().toString()) + ",eventMsgType=" + (null == this.getEventMsgType() ? ""
                : this.getEventMsgType().toString()) + ",status=" + this.status
                + ",totalCount=" + this.totalCount + ",filterCount=" + this.filterCount + ",sentCount="
                + this.sentCount + ",errorCount=" + this.errorCount + "]";
    }
}
