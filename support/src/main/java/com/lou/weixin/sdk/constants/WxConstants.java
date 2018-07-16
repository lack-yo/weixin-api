package com.lou.weixin.sdk.constants;

/**
 * 公众号API
 *
 * @author loufeng
 * @date 2018/7/09 上午11:13.
 */
public class WxConstants {
    public static final String KEY_TOKEN = "ACCESS_TOKEN";
    /**
     * 多媒体文件下载接口
     **/
    public static final String MEDIA_DOWNLOAD_URL = "http://file.api.weixin.qq.com/cgi-bin/media/get?access_token=ACCESS_TOKEN&media_id=MEDIA_ID";
    /**
     * 获取jsapi ticket
     **/
    public static final String GET_JSAPI_TICKET_URL = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=ACCESS_TOKEN&type=jsapi";

    /**
     * 上传图文消息素材【订阅号与服务号认证后均可用】
     **/
    public static final String MEDIA_NEWS_UPLOAD_URL = "https://api.weixin.qq.com/cgi-bin/media/uploadnews?access_token=ACCESS_TOKEN";
    /**
     * 删除群发【订阅号与服务号认证后均可用】
     **/
    public static final String MESSAGE_MASS_DELETE_URL = "https://api.weixin.qq.com/cgi-bin/message/mass/delete?access_token=ACCESS_TOKEN";
    /**
     * 预览接口【订阅号与服务号认证后均可用】
     **/
    public static final String MESSAGE_MASS_PREVIEW_URL = "https://api.weixin.qq.com/cgi-bin/message/mass/preview?access_token=ACCESS_TOKEN";

    /**
     * 获取图文统计数据（getuserread）	 最大时间跨度3
     **/
    public static final String DATACUBE_GET_USER_READ = "https://api.weixin.qq.com/datacube/getarticletotal?access_token=ACCESS_TOKEN";
}
