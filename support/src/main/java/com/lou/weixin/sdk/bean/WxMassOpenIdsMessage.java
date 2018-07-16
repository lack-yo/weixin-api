package com.lou.weixin.sdk.bean;


import com.lou.weixin.sdk.utils.json.WxGsonBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * 根据OpenId列表群发的消息
 *
 * @author loufeng
 * @date 2018/7/9 下午2:26.
 */
public class WxMassOpenIdsMessage extends WxMassMessage {
    /**
     * 群发消息时OpenId列表
     */
    private List<String> toUsers = new ArrayList<String>();

    public List<String> getToUsers() {
        return toUsers;
    }

    public void addUser(String openId) {
        this.toUsers.add(openId);
    }

    @Override
    public String toJson() {
        return WxGsonBuilder.INSTANCE.create().toJson(this);
    }
}
