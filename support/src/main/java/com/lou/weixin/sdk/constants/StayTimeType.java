package com.lou.weixin.sdk.constants;

/**
 * 小程序留存时间
 *
 * @author loufeng
 * @date 2017/11/30 上午10:27.
 */
public enum StayTimeType {
    TIME1(1, "0-2s"),
    TIME2(2, "3-5s"),
    TIME3(3, "6-10s"),
    TIME4(4, "11-20s"),
    TIME5(5, "20-30s"),
    TIME6(6, "30-50s"),
    TIME7(7, "50-100s"),
    TIME8(8, ">100s"),
    OTHER(0, "其他");
    private int key;
    private String desc;

    StayTimeType(int key, String desc) {
        this.key = key;
        this.desc = desc;
    }

    public int getKey() {
        return key;
    }

    public String getDesc() {
        return desc;
    }

    public static StayTimeType find(int key) {
        for (StayTimeType s : StayTimeType.values()) {
            if (s.getKey() == key) {
                return s;
            }
        }
        return null;
    }
}
