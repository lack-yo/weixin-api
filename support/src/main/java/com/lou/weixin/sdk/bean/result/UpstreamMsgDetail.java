package com.lou.weixin.sdk.bean.result;

/**
 * 公众号消息数据item
 *
 * @author loufeng
 * @date 2017/7/28 下午3:25.
 */
public class UpstreamMsgDetail {
    /**
     * 当前记录所在的日期
     */
    private String refDate;
    /**
     * 消息类型，代表含义如下：
     * 1代表文字 2代表图片 3代表语音 4代表视频 6代表第三方应用消息（链接消息）
     */
    private int msgType;
    /**
     * 上行用户数
     */
    private int msgUser;
    /**
     * 上行消息数
     */
    private int msgCount;

    public String getRefDate() {
        return refDate;
    }

    public void setRefDate(String refDate) {
        this.refDate = refDate;
    }

    public int getMsgType() {
        return msgType;
    }

    public void setMsgType(int msgType) {
        this.msgType = msgType;
    }

    public int getMsgUser() {
        return msgUser;
    }

    public void setMsgUser(int msgUser) {
        this.msgUser = msgUser;
    }

    public int getMsgCount() {
        return msgCount;
    }

    public void setMsgCount(int msgCount) {
        this.msgCount = msgCount;
    }
}
