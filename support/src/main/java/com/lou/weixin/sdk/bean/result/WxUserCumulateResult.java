package com.lou.weixin.sdk.bean.result;

/**
 * 用户数据统计
 *
 * @author loufeng
 * @date 2018/7/9 下午2:11.
 */
public class WxUserCumulateResult {
    /**
     * 总用户量
     */
    private int cumulateUser;
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

    public int getCumulateUser() {
        return cumulateUser;
    }

    public void setCumulateUser(int cumulateUser) {
        this.cumulateUser = cumulateUser;
    }

    @Override
    public String toString() {
        return "WxUserCumulateResult{" +
                "cumulateUser=" + cumulateUser +
                ", refDate='" + refDate + '\'' +
                '}';
    }
}
