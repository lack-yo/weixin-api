package com.lou.weixin.sdk.bean.result;

import java.util.List;

/**
 * @author loufeng
 * @date 2018/7/9 上午11:32.
 */
public class WxArticleTotalResult {
    private List<DataList> list;

    public static class DataList {
        /**
         * 数据的日期，需在begin_date和end_date之间
         */
        private String refDate;
        /**
         * 请注意：这里的msgid实际上是由msgid
         * （图文消息id，这也就是群发接口调用后返回的msg_data_id）
         * 和index（消息次序索引）组成， 例如12003_3， 其中12003是msgid，
         * 即一次群发的消息的id； 3为index，假设该次群发的图文消息共5个文章
         * （因为可能为多图文），3表示5个中的第3个
         */
        private String msgid;
        private String title;
        private List<DataDetails> details;

        public String getRefDate() {
            return refDate;
        }

        public void setRefDate(String refDate) {
            this.refDate = refDate;
        }

        public String getMsgid() {
            return msgid;
        }

        public void setMsgid(String msgid) {
            this.msgid = msgid;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public List<DataDetails> getDetails() {
            return details;
        }

        public void setDetails(List<DataDetails> details) {
            this.details = details;
        }
    }

    public static class DataDetails {
        /**
         * 送达人数，一般约等于总粉丝数（需排除黑名单或其他异常情况下无法收到消息的粉丝）
         */
        private int targetUser;
        /**
         * 统计的日期，在getarticletotal接口中，ref_date指的是文章群发出日期， 而stat_date是数据统计日期
         */
        private String statDate;
        /**
         * 图文页（点击群发图文卡片进入的页面）的阅读人数
         */
        private int intPageReadUser;
        /**
         * 图文页的阅读次数
         */
        private int intPageReadCount;
        /**
         * 收藏的人数
         */
        private int addToFavUser;
        /**
         * 原文页（点击图文页“阅读原文”进入的页面）的阅读人数，无原文页时此处数据为0
         */
        private int oriPageReadUser;
        /**
         * 分享的人数
         */
        private int shareUser;
        /**
         * 公众号会话转发朋友圈人数
         */
        private int feedsharefromsessionuser;
        /**
         * 朋友圈转发朋友圈人数
         */
        private int feedsharefromfeeduser;
        /**
         * 其他场景转发朋友圈人数
         */
        private int feedsharefromotheruser;

        public int getTargetUser() {
            return targetUser;
        }

        public void setTargetUser(int targetUser) {
            this.targetUser = targetUser;
        }

        public String getStatDate() {
            return statDate;
        }

        public void setStatDate(String statDate) {
            this.statDate = statDate;
        }

        public int getIntPageReadUser() {
            return intPageReadUser;
        }

        public void setIntPageReadUser(int intPageReadUser) {
            this.intPageReadUser = intPageReadUser;
        }

        public int getIntPageReadCount() {
            return intPageReadCount;
        }

        public void setIntPageReadCount(int intPageReadCount) {
            this.intPageReadCount = intPageReadCount;
        }

        public int getAddToFavUser() {
            return addToFavUser;
        }

        public void setAddToFavUser(int addToFavUser) {
            this.addToFavUser = addToFavUser;
        }

        public int getOriPageReadUser() {
            return oriPageReadUser;
        }

        public void setOriPageReadUser(int oriPageReadUser) {
            this.oriPageReadUser = oriPageReadUser;
        }

        public int getShareUser() {
            return shareUser;
        }

        public void setShareUser(int shareUser) {
            this.shareUser = shareUser;
        }

        public int getFeedsharefromsessionuser() {
            return feedsharefromsessionuser;
        }

        public void setFeedsharefromsessionuser(int feedsharefromsessionuser) {
            this.feedsharefromsessionuser = feedsharefromsessionuser;
        }

        public int getFeedsharefromfeeduser() {
            return feedsharefromfeeduser;
        }

        public void setFeedsharefromfeeduser(int feedsharefromfeeduser) {
            this.feedsharefromfeeduser = feedsharefromfeeduser;
        }

        public int getFeedsharefromotheruser() {
            return feedsharefromotheruser;
        }

        public void setFeedsharefromotheruser(int feedsharefromotheruser) {
            this.feedsharefromotheruser = feedsharefromotheruser;
        }
    }

    public List<DataList> getList() {
        return list;
    }

    public void setList(List<DataList> list) {
        this.list = list;
    }

}
