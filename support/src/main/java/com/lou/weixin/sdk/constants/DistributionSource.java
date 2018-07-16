package com.lou.weixin.sdk.constants;

/**
 * 小程序访问来源
 *
 * @author loufeng
 * @date 2017/11/30 上午10:11.
 */
public enum DistributionSource {
    HISTORY(1, "小程序历史列表"),
    SEARCH(2, "搜索"),
    CHAT(3, "会话"),
    QRCODE(4, "二维码"),
    GZH_HOME(5, "公众号主页"),
    CHAT_TOP(6, "聊天顶部"),
    DESKTOP(7, "系统桌面"),
    XCX_HOME(8, "小程序主页"),
    NEAR_XCX(9, "附近的小程序"),
    OTHER(10, "其他"),
    TEMPLATE_MSG(11, "模板消息"),
    CUSTOMER_MSG(12, "客服消息"),
    GZH_MENU(13, "公众号菜单"),
    APP_SHARE(14, "APP分享"),
    PAY_SUCCESS(15, "支付完成页"),
    QRCODE_PRESS(16, "长按识别二维码"),
    QRCODE_IMG(17, "相册选取二维码"),
    GZH_ARTICLE(18, "公众号文章"),
    WALLET(19, "钱包"),
    CARD(20, "卡包"),
    XCX_CARD(21, "小程序内卡券"),
    OTHER_XCX(22, "其他小程序"),
    OTHER_XCX_RETURN(23, "其他小程序返回"),
    CARD_SHOP_LIST(24, "卡券适用门店列表"),
    SEARCH_OPEN(25, "搜索框快捷入口"),
    XCX_CUSTOMER_MSG(26, "小程序客服消息"),
    GZH_SEND(27, "公众号下发"),
    CHAT_MENU(28, "会话左下角菜单"),
    TASK_ITEM(29, "小程序任务栏");

    private int key;
    private String desc;

    DistributionSource(int key, String desc) {
        this.key = key;
        this.desc = desc;
    }

    public int getKey() {
        return key;
    }

    public String getDesc() {
        return desc;
    }

    public static DistributionSource find(int key) {
        for (DistributionSource s : DistributionSource.values()) {
            if (s.getKey() == key) {
                return s;
            }
        }
        return OTHER;
    }
}
