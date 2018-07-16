package com.lou.weixin.sdk.bean.result.weapp;

import com.google.common.collect.Lists;
import org.springframework.beans.BeanUtils;

import java.util.List;

/**
 * 小程序浏览分布数据
 *
 * @author loufeng
 * @date 2017/11/30 下午2:57.
 */
public class IndexDistribution {
    private String index;
    private List<BaseDistributionItem> itemList;
    private final String TYPE_SOURCE = "access_source_session_cnt";
    private final String TYPE_DEPTH = "access_depth_info";
    private final String TYPE_TIME = "access_staytime_info";

    public IndexDistribution(String index, List<BaseDistributionItem> itemList) {
        this.index = index;
        List<BaseDistributionItem> newList = Lists.newArrayList();
        switch (index) {
            case TYPE_SOURCE:
                for (BaseDistributionItem s : itemList) {
                    SourceDistributionItem t = new SourceDistributionItem();
                    BeanUtils.copyProperties(s, t);
                    t.initDesc(t.getKey());
                    newList.add(t);
                }
                this.itemList = newList;
                break;
            case TYPE_DEPTH:
                for (BaseDistributionItem s : itemList) {
                    DepthDistributionItem t = new DepthDistributionItem();
                    BeanUtils.copyProperties(s, t);
                    t.initDesc(t.getKey());
                    newList.add(t);
                }
                this.itemList = newList;
                break;
            case TYPE_TIME:
                for (BaseDistributionItem s : itemList) {
                    TimeDistributionItem t = new TimeDistributionItem();
                    BeanUtils.copyProperties(s, t);
                    t.initDesc(t.getKey());
                    newList.add(t);
                }
                this.itemList = newList;
                break;
            default:
                break;
        }

    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public List<BaseDistributionItem> getItemList() {
        return itemList;
    }

    public void setItemList(List<BaseDistributionItem> itemList) {
        this.itemList = itemList;
    }
}
