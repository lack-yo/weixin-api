package com.lou.weixin.sdk.bean;


import com.lou.weixin.sdk.utils.json.WxGsonBuilder;

/**
 * 消息发送构造
 *
 * @author loufeng
 * @date 2018/7/9 下午2:26.
 */
public class WxMassGroupMessage extends WxMassMessage {

    /**
     * 用于设定是否向全部用户发送，值为true或false，选择true该消息群发给所有用户，选择false可根据group_id发送给指定群组的用户
     */
    private Boolean isToAll;

    /**
     * 群发到的分组的group_id，参加用户管理中用户分组接口，若is_to_all值为true，可不填写group_id
     */
    private String groupId;

    public Boolean getIsToAll() {
        return isToAll;
    }

    public void setIsToAll(Boolean isToAll) {
        this.isToAll = isToAll;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    @Override
    public String toJson() {
        return WxGsonBuilder.INSTANCE.create().toJson(this);
    }
}
