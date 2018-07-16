package com.lou.weixin.sdk.bean.result.auth;

/**
 * 开通功能
 *
 * @author loufeng
 * @date 2018/1/22 上午10:55.
 */
public class BusinessInfo {
    private int openPay;//是否开通微信支付功能
    private int openShake;//是否开通微信摇一摇功能
    private int openScan;//是否开通微信扫商品功能
    private int openCard;//是否开通微信卡券功能
    private int openStore;//是否开通微信门店功能

    public int getOpenPay() {
        return openPay;
    }

    public void setOpenPay(int openPay) {
        this.openPay = openPay;
    }

    public int getOpenShake() {
        return openShake;
    }

    public void setOpenShake(int openShake) {
        this.openShake = openShake;
    }

    public int getOpenScan() {
        return openScan;
    }

    public void setOpenScan(int openScan) {
        this.openScan = openScan;
    }

    public int getOpenCard() {
        return openCard;
    }

    public void setOpenCard(int openCard) {
        this.openCard = openCard;
    }

    public int getOpenStore() {
        return openStore;
    }

    public void setOpenStore(int openStore) {
        this.openStore = openStore;
    }
}
