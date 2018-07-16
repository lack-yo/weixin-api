package com.lou.weixin.sdk.bean.result.weapp;


import com.lou.weixin.sdk.constants.StayTimeType;

/**
 * 小程序停留时间数据
 * @author loufeng
 * @date 2017/11/30 上午10:09.
 */
public class TimeDistributionItem extends BaseDistributionItem {
    void initDesc(int key) {
        StayTimeType source = StayTimeType.find(key);
        if (source != null) {
            super.setDesc(source.getDesc());
        }
    }
}
