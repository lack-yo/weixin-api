package com.lou.weixin.sdk.constants;

/**
 * 小程序页面深度类型
 *
 * @author loufeng
 * @date 2017/11/30 上午10:30.
 */
public enum DepthInfoType {
    DEPTH1(1, "1页"),
    DEPTH2(2, "2页"),
    DEPTH3(3, "3页"),
    DEPTH4(4, "4页"),
    DEPTH5(5, "5页"),
    DEPTH6(6, "6-10页"),
    DEPTH7(7, ">10页"),
    OTHERS(0, "未知");;
    private int key;
    private String desc;

    DepthInfoType(int key, String desc) {
        this.key = key;
        this.desc = desc;
    }

    public int getKey() {
        return key;
    }

    public String getDesc() {
        return desc;
    }

    public static DepthInfoType find(int key) {
        for (DepthInfoType s : DepthInfoType.values()) {
            if (s.getKey() == key) {
                return s;
            }
        }
        return OTHERS;
    }
}
