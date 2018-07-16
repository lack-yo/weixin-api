package com.lou.weixin.sdk.bean.result;

/**
 * 群发消息result
 *
 * @author loufeng
 * @date 2018/1/23 上午9:58.
 */
public class WxMassStatusResult {
    /**
     * 群发消息后返回的消息id
     */
    private String msgId;
    /**
     * 消息发送后的状态，SEND_SUCCESS表示发送成功
     */
    private String msgStatus;

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    public String getMsgStatus() {
        return msgStatus;
    }

    public void setMsgStatus(String msgStatus) {
        this.msgStatus = msgStatus;
    }

    @Override
    public String toString() {
        return "WxMassStatusResult{" +
                "msgId='" + msgId + '\'' +
                ", msgStatus='" + msgStatus + '\'' +
                '}';
    }
}
