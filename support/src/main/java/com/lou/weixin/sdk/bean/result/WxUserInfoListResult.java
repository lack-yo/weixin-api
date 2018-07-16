package com.lou.weixin.sdk.bean.result;

import java.util.List;

/**
 * 批量获取用户数据
 *
 * @author loufeng
 * @date 2018/7/9 下午2:11.
 */
public class WxUserInfoListResult {
    private List<WxUser> userInfoList;

    public List<WxUser> getUserInfoList() {
        return userInfoList;
    }

    public void setUserInfoList(List<WxUser> userInfoList) {
        this.userInfoList = userInfoList;
    }
}
