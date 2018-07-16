package com.lou.weixin.sdk.bean.result;

/**
 * 群发图文result
 *
 * @author loufeng
 * @date 2018/7/9 下午2:06.
 */
public class WxMessageSendResult extends Result {
    /**
     * 消息发送任务的ID
     */
    private String msgId;
    /**
     * 消息的数据ID，，该字段只有在群发图文消息时，才会出现。可以用于在图文分析数据接口中，获取到对应的图文消息的数据，是图文分析数据接口中的msgid字段中的前半部分，详见图文分析数据接口中的msgid字段的介绍。
     */
    private String msgDataId;

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    public String getMsgDataId() {
        return msgDataId;
    }

    public void setMsgDataId(String msgDataId) {
        this.msgDataId = msgDataId;
    }

    @Override
    public String toString() {
        return "WxMessageSendResult{" +
                "msgId='" + msgId + '\'' +
                ", msgDataId='" + msgDataId + '\'' +
                '}';
    }
}
