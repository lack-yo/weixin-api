package com.lou.weixin.sdk.constants;

import org.apache.commons.lang3.StringUtils;

/**
 * 公众号消息event类型
 *
 * @author loufeng
 * @date 2018/7/4 下午4:02.
 */
public enum EventMsgType {
    /**
     * 上报地理位置事件
     */
    location,
    /**
     * 关注事件
     */
    subscribe,
    /**
     * 用户已关注时的扫描带参数二维码事件事件推送
     */
    scan,
    /**
     * 点击菜单拉取消息时的事件推送
     */
    click,
    /**
     * 点击菜单跳转链接时的事件推送
     */
    view,
    /**
     * 事件推送群发结果
     */
    masssendjobfinish,
    /**
     * 取消关注事件
     */
    unsubscribe,
    /**
     * 模板消息推送结果
     */
    templatesendjobfinish,
    /**
     * 小程序审核成功通知
     */
    weapp_audit_success,
    /**
     * 小程序审核失败通知
     */
    weapp_audit_fail,
    /**
     * 未知事件
     */
    unknow;

    public static EventMsgType parseFromStr(String str) {
        if (StringUtils.isEmpty(str)) {
            return EventMsgType.unknow;
        }

        for (EventMsgType type : EventMsgType.values()) {
            if (type.toString().equalsIgnoreCase(str)) {
                return type;
            }
        }

        return EventMsgType.unknow;
    }

    @Override
    public String toString() {
        switch (this) {
            case location:
                return "location";
            case subscribe:
                return "subscribe";
            case unsubscribe:
                return "unsubscribe";
            case scan:
                return "scan";
            case click:
                return "click";
            case view:
                return "view";
            case masssendjobfinish:
                return "masssendjobfinish";
            case templatesendjobfinish:
                return "templatesendjobfinish";
            case weapp_audit_success:
                return "weapp_audit_success";
            case weapp_audit_fail:
                return "weapp_audit_fail";
            default:
                return "unknow";
        }
    }
}
