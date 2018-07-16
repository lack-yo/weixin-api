package com.lou.weixin.sdk.bean.result;

import java.util.List;

/**
 * 关注用户列表
 *
 * @author loufeng
 * @date 2018/7/9 下午2:11.
 */
public class WxUserListResult {
    private int total;
    private int count;
    private OpenIdArray data;
    private String nextOpenid;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public OpenIdArray getData() {
        return data;
    }

    public void setData(OpenIdArray data) {
        this.data = data;
    }

    public String getNextOpenid() {
        return nextOpenid;
    }

    public void setNextOpenid(String nextOpenid) {
        this.nextOpenid = nextOpenid;
    }

    public static class OpenIdArray {
        private List<String> openid;

        public List<String> getOpenid() {
            return openid;
        }

        public void setOpenid(List<String> openid) {
            this.openid = openid;
        }

        @Override
        public String toString() {
            return "OpenIdArray [openid=" + openid.toString() + "]";
        }
    }

    @Override
    public String toString() {
        return "WxUserListResult{" +
                "total=" + total +
                ", count=" + count +
                ", data=" + data +
                ", nextOpenid='" + nextOpenid + '\'' +
                '}';
    }
}
