package com.lou.weixin.sdk.bean.result;

import java.util.List;

/**
 * 素材列表获取result
 *
 * @author loufeng
 * @date 2018/7/9 下午2:01.
 */
public class WxMaterialListResult {
    /**
     * 数量
     */
    private int totalCount;
    /**
     * 当前数量
     */
    private int itemCount;
    /**
     * 素材
     */
    private List<ItemResult> item;

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getItemCount() {
        return itemCount;
    }

    public void setItemCount(int itemCount) {
        this.itemCount = itemCount;
    }

    public List<ItemResult> getItem() {
        return item;
    }

    public void setItem(List<ItemResult> item) {
        this.item = item;
    }

    public static class ItemResult {
        /**
         * 素材id
         */
        private String mediaId;
        /**
         * 素材内容
         */
        private ContentResult content;
        /**
         * 更新时间
         */
        private String updateTime;

        public String getMediaId() {
            return mediaId;
        }

        public void setMediaId(String mediaId) {
            this.mediaId = mediaId;
        }

        public ContentResult getContent() {
            return content;
        }

        public void setContent(ContentResult content) {
            this.content = content;
        }

        public String getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(String updateTime) {
            this.updateTime = updateTime;
        }
    }

    public static class ContentResult {
        /**
         * 图文素材详情
         */
        List<MaterialResult> newsItem;
        /**
         * 更新时间
         */
        private String updateTime;

        public List<MaterialResult> getNewsItem() {
            return newsItem;
        }

        public void setNewsItem(List<MaterialResult> newsItem) {
            this.newsItem = newsItem;
        }

        public String getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(String updateTime) {
            this.updateTime = updateTime;
        }
    }

    @Override
    public String toString() {
        return "WxMaterialListResult{" +
                "totalCount='" + totalCount + '\'' +
                ", itemCount='" + itemCount + '\'' +
                ", item=" + item +
                '}';
    }
}
