package com.lou.weixin.sdk.bean.result;

/**
 * 公众号关联小程序item
 *
 * @author loufeng
 * @date 2018/1/23 上午10:08.
 */
public class LinkApp {
    public static final int STATUS_SUCCESS = 1;
    public static final int STATUS_REJECT = 3;
    public static final int STATUS_LATE = 4;
    public static final int STATUS_ACCOUNT = 12;
    public static final int STATUS_MINA = 2;
    /**
     * 关联状态，
     * <p>
     * 1：已关联；
     * <p>
     * 2：等待小程序管理员确认中；
     * <p>
     * 3：小程序管理员拒绝关联
     * <p>
     * 12：等到公众号管理员确认中；
     */
    private int status;
    /**
     * 小程序gh_id
     */
    private String username = "";
    /**
     * 小程序邮箱
     */
    private String email;
    /**
     * 小程序名称
     */
    private String nickname;
    /**
     * 是否在公众号管理页展示中
     */
    private boolean selected;
    /**
     * 是否展示在附近的小程序中
     */
    private boolean nearbyDisplay;
    /**
     * 是否已经发布
     */
    private boolean released;


    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public boolean isNearbyDisplay() {
        return nearbyDisplay;
    }

    public void setNearbyDisplay(boolean nearbyDisplay) {
        this.nearbyDisplay = nearbyDisplay;
    }

    public boolean isReleased() {
        return released;
    }

    public void setReleased(boolean released) {
        this.released = released;
    }
}
