package com.lou.weixin.sdk.constants;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 公众号&小程序权限集
 *
 * @author loufeng
 * @date 2018/1/4 下午4:12.
 */
public enum FuncInfoType {
    //消息管理权限
    FUNC_MSG(1, "消息管理权限"),

    //用户管理权限
    FUNC_USER(2, "用户管理权限"),

    //帐号服务权限
    FUNC_ACCOUNT(3, "帐号服务权限"),

    //网页服务权限
    FUNC_WEB(4, "网页服务权限"),

    //微信小店权限
    FUNC_SMALL_SHOP(5, "微信小店权限"),

    //微信多客服权限
    FUNC_CUSTOMER(6, "微信多客服权限"),

    //群发与通知权限
    FUNC_SEND(7, "群发与通知权限"),

    //微信卡券权限
    FUNC_CARD(8, "微信卡券权限"),

    //微信扫一扫权限
    FUNC_SCAN(9, "微信扫一扫权限"),

    //微信连WIFI权限
    FUNC_WIFI(10, "微信连WIFI权限"),

    //素材管理权限
    FUNC_MEDIA(11, "素材管理权限"),

    //微信摇周边权限
    FUNC_SHAKE(12, "微信摇周边权限"),

    //微信门店权限
    FUNC_SHOP(13, "微信门店权限"),

    //微信支付权限
    FUNC_PAY(14, "微信支付权限"),

    //自定义菜单权限
    FUNC_MENU(15, "自定义菜单权限"),

    //获取认证状态及信息
    FUNC_AUTH(16, "获取认证状态及信息"),

    //帐号管理权限（小程序）
    FUNC_MINA_ACCOUNT(17, "帐号管理权限"),

    //开发管理与数据分析权限（小程序）
    FUNC_MINA_DEV(18, "开发管理与数据分析权限"),

    //客服消息管理权限（小程序）
    FUNC_MINA_CUSTOMER(19, "客服消息管理权限"),

    //小程序基本信息设置权限（小程序）
    FUNC_MINA_LOGIN(30, "小程序基本信息设置权限"),

    //小程序认证权限（小程序）
    FUNC_MINA_DATA(31, "小程序认证权限"),

    //城市服务接口权限
    FUNC_CITY(22, "城市服务接口权限"),

    //广告管理权限
    FUNC_AD(23, "广告管理权限"),

    //开放平台帐号管理权限
    FUNC_PLATFORM(24, "开放平台帐号管理权限"),

    //开放平台帐号管理权限（小程序）
    FUNC_MINA_PLATFORM(25, "开放平台帐号管理权限"),

    //微信电子发票权限
    FUNC_BILL(26, "微信电子发票权限"),

    //小程序管理
    FUNC_LINK(33, "小程序管理权限");

    private int id;
    private String desc;
    private static final Logger LOGGER = LoggerFactory.getLogger(FuncInfoType.class);

    FuncInfoType(int id, String desc) {
        this.id = id;
        this.desc = desc;
    }

    public int getId() {
        return id;
    }

    public String getDesc() {
        return desc;
    }

    public static FuncInfoType find(int id) {
        for (FuncInfoType t : FuncInfoType.values()) {
            if (t.getId() == id) {
                return t;
            }
        }
        LOGGER.info("无法匹配权限id，" + id);
        return null;
    }


}
