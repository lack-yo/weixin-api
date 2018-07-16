package com.lou.weixin.sdk.bean.result;

/**
 * 用户数据来源统计
 *
 * @author loufeng
 * @date 2018/7/9 下午2:11.
 */
public class WxUserSummaryResult {
    /**
     * 用户的渠道，数值代表的含义如下：
     * 0代表其他合计
     * 1代表公众号搜索
     * 17代表名片分享
     * 30代表扫描二维码
     * 43代表图文页右上角菜单
     * 51代表支付后关注（在支付完成页）
     * 57代表图文页内公众号名称
     * 75代表公众号文章广告
     * 78代表朋友圈广告
     */
    private String userSource;
    /**
     * 新增的用户数量
     */
    private int newUser;
    /**
     * 取消关注的用户数量
     */
    private int cancelUser;

    /**
     * 数据的日期
     */
    private String refDate;

    public String getRefDate() {
        return refDate;
    }

    public void setRefDate(String refDate) {
        this.refDate = refDate;
    }

    public String getUserSource() {
        return userSource;
    }

    public void setUserSource(String userSource) {
        this.userSource = userSource;
    }

    public int getNewUser() {
        return newUser;
    }

    public void setNewUser(int newUser) {
        this.newUser = newUser;
    }

    public int getCancelUser() {
        return cancelUser;
    }

    public void setCancelUser(int cancelUser) {
        this.cancelUser = cancelUser;
    }

    public boolean isSummary() {
        if (null != userSource && "0".equals(userSource)) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "WxUserSummaryResult{" +
                "userSource='" + userSource + '\'' +
                ", newUser=" + newUser +
                ", cancelUser=" + cancelUser +
                ", refDate='" + refDate + '\'' +
                '}';
    }
}
