package com.lou.weixin.constants;

/**
 * @author loufeng
 * @date 2017/7/11 下午3:45.
 */
public class WxUrl {
    /**
     * 获取access token接口
     **/
    public static final String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
    /**
     * 多媒体文件上传接口
     **/
    public static final String MEDIA_UPLOAD_URL = "http://file.api.weixin.qq.com/cgi-bin/media/upload?access_token=ACCESS_TOKEN&type=TYPE";
    /**
     * 多媒体文件下载接口
     **/
    public static final String MEDIA_DOWNLOAD_URL = "http://file.api.weixin.qq.com/cgi-bin/media/get?access_token=ACCESS_TOKEN&media_id=MEDIA_ID";

    /**
     * 获取jsapi ticket
     **/
    public static final String GET_JSAPI_TICKET_URL = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=ACCESS_TOKEN&type=jsapi";
    /**
     * 客服消息发送接口
     **/
    public static final String MESSAGE_CUSTOM_SEND_URL = "https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=ACCESS_TOKEN";
    /**
     * 二维码ticket创建接口
     **/
    // 注意,坑爹微信原始接口是https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=TOKEN
    // 为了统一，将TOKEN改为ACCESS_TOKEN
    public static final String QRCODE_CREATE_URL = "https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=ACCESS_TOKEN";
    /**
     * 长链接转化为短链接
     **/
    public static final String SHORT_URL = "https://api.weixin.qq.com/cgi-bin/shorturl?access_token=ACCESS_TOKEN";

    // /////////////////////
    // 微信高级群发接口相关
    // /////////////////////
    /**
     * 上传图文消息素材【订阅号与服务号认证后均可用】
     **/
    public static final String MEDIA_NEWS_UPLOAD_URL = "https://api.weixin.qq.com/cgi-bin/media/uploadnews?access_token=ACCESS_TOKEN";
    /**
     * 根据分组进行群发【订阅号与服务号认证后均可用】
     **/
    public static final String MESSAGE_MASS_SENDALL_URL = "https://api.weixin.qq.com/cgi-bin/message/mass/sendall?access_token=ACCESS_TOKEN";
    /**
     * 根据OpenID列表群发【订阅号不可用，服务号认证后可用】
     **/
    public static final String MESSAGE_MASS_SEND_URL = "https://api.weixin.qq.com/cgi-bin/message/mass/send?access_token=ACCESS_TOKEN";
    /**
     * 删除群发【订阅号与服务号认证后均可用】
     **/
    public static final String MESSAGE_MASS_DELETE_URL = "https://api.weixin.qq.com/cgi-bin/message/mass/delete?access_token=ACCESS_TOKEN";
    /**
     * 预览接口【订阅号与服务号认证后均可用】
     **/
    public static final String MESSAGE_MASS_PREVIEW_URL = "https://api.weixin.qq.com/cgi-bin/message/mass/preview?access_token=ACCESS_TOKEN";
    /**
     * 查询群发消息发送状态【订阅号与服务号认证后均可用】
     **/
    public static final String MESSAGE_MASS_GET_URL = "https://api.weixin.qq.com/cgi-bin/message/mass/get?access_token=ACCESS_TOKEN";
    /**
     * 批量获取用户信息接口
     **/
    public static final String USER_INFO_BATCHGET = "https://api.weixin.qq.com/cgi-bin/user/info/batchget?access_token=ACCESS_TOKEN";

    // /////////////////////
    // 微信用户管理接口相关
    // /////////////////////
    /**
     * 创建用户分组接口
     **/
    public static final String GROUPS_CREATE_URL = "https://api.weixin.qq.com/cgi-bin/groups/create?access_token=ACCESS_TOKEN";
    /**
     * 查询所有分组接口
     **/
    public static final String GROUPS_GET_URL = "https://api.weixin.qq.com/cgi-bin/groups/get?access_token=ACCESS_TOKEN";
    /**
     * 查询用户所在分组接口
     **/
    public static final String GROUPS_GET_ID_URL = "https://api.weixin.qq.com/cgi-bin/groups/getid?access_token=ACCESS_TOKEN";
    /**
     * 修改分组名称接口
     **/
    public static final String GROUPS_UPDATE_URL = "https://api.weixin.qq.com/cgi-bin/groups/update?access_token=ACCESS_TOKEN";
    /**
     * 移动用户分组接口
     **/
    public static final String GROUPS_MEMBER_UPDATE_URL = "https://api.weixin.qq.com/cgi-bin/groups/members/update?access_token=ACCESS_TOKEN";
    /**
     * 批量移动用户分组接口
     **/
    public static final String GROUPS_MEMBER_BATCH_UPDATE_URL = "https://api.weixin.qq.com/cgi-bin/groups/members/batchupdate?access_token=ACCESS_TOKEN";
    /**
     * 获取用户基本信息（包括UnionID机制）接口
     **/
    public static final String USER_INFO_GET_URL = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=OPENID&lang=LANG";
    /**
     * 获取用户列表接口
     **/
    public static final String USER_GET_URL = "https://api.weixin.qq.com/cgi-bin/user/get?access_token=ACCESS_TOKEN&next_openid=NEXT_OPENID";


    // /////////////////////
    // 微信自定义菜单管理接口相关
    // /////////////////////
    /**
     * 自定义菜单创建接口
     **/
    public static final String MENU_CREATE_URL = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
    /**
     * 自定义菜单查询接口
     **/
    public static final String MENU_GET_URL = "https://api.weixin.qq.com/cgi-bin/menu/get?access_token=ACCESS_TOKEN";
    /**
     * 自定义菜单删除接口
     **/
    public static final String MENU_DELETE_URL = "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=ACCESS_TOKEN";

    // /////////////////////
    // 微信数据统计接口相关
    // /////////////////////
    // 用户分析数据接口
    /**
     * 获取用户增减数据
     **/
    public static final String GET_USER_SUMMARY_URL = "https://api.weixin.qq.com/datacube/getusersummary?access_token=ACCESS_TOKEN";
    /**
     * 获取累计用户数据
     **/
    public static final String GET_USER_CUMULATE_URL = "https://api.weixin.qq.com/datacube/getusercumulate?access_token=ACCESS_TOKEN";

    // 消息分析数据接口
    /**
     * 获取消息数据，最大时间跨度7
     **/
    public static final String GET_UPSTREAM_MSG_URL = "https://api.weixin.qq.com/datacube/getupstreammsg?access_token=ACCESS_TOKEN";
    /**
     * 图文群发每日统计，最大时间跨度1
     **/
    public static final String GET_ARTICLE_SUMMARY = "https://api.weixin.qq.com/datacube/getarticlesummary?access_token=ACCESS_TOKEN";
    // /////////////////////
    // 微信模板消息接口相关
    // /////////////////////
    /**
     * 设置所属行业
     **/
    public static final String TEMPLATE_SET_INDUSTRY_URL = "https://api.weixin.qq.com/cgi-bin/template/api_set_industry?access_token=ACCESS_TOKEN";
    /**
     * 获得模板ID
     **/
    public static final String TEMPLATE_ADD_URL = "https://api.weixin.qq.com/cgi-bin/template/api_add_template?access_token=ACCESS_TOKEN";
    /**
     * 获取模板列表
     **/
    public static final String TEMPLATE_GET_ALL_PRIVATE_URL = "https://api.weixin.qq.com/cgi-bin/template/get_all_private_template?access_token=ACCESS_TOKEN";
    /**
     * 发送模板消息
     **/
    public static final String TEMPLATE_MESSAGE_SEND_URL = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=ACCESS_TOKEN";
    /**
     * 获取设置的行业信息
     **/
    public static final String TEMPLATE_GET_INDUSTRY_URL = "https://api.weixin.qq.com/cgi-bin/template/get_industry?access_token=ACCESS_TOKEN";
    // /////////////////////
    // 图文素材接口
    // /////////////////////
    /**
     * 上传图文消息
     **/
    public static final String MATERIAL_ADD_NEWS = "https://api.weixin.qq.com/cgi-bin/material/add_news?access_token=ACCESS_TOKEN";
    /**
     * 获取素材列表
     **/
    public static final String MATERIAL_BATCH_GET_MATERIAL = "https://api.weixin.qq.com/cgi-bin/material/batchget_material?access_token=ACCESS_TOKEN";
    /**
     * 获取永久素材
     **/
    public static final String MATERIAL_GET_MATERIAL = "https://api.weixin.qq.com/cgi-bin/material/get_material?access_token=ACCESS_TOKEN";
    /**
     * 删除永久素材
     **/
    public static final String MATERIAL_DEL_MATERIAL = "https://api.weixin.qq.com/cgi-bin/material/del_material?access_token=ACCESS_TOKEN";
    /**
     * 获取图文群发总数据（getarticletotal） 最大时间跨度1
     **/
    public static final String DATACUBE_GET_ARTIVLE_TOTAL = "https://api.weixin.qq.com/datacube/getarticletotal?access_token=ACCESS_TOKEN";
    /**
     * 获取图文统计数据（getuserread）	 最大时间跨度3
     **/
    public static final String DATACUBE_GET_USER_READ = "https://api.weixin.qq.com/datacube/getarticletotal?access_token=ACCESS_TOKEN";
    /**
     * 新增其他类型永久素材
     **/
    public static final String MATERIAL_ADD_MATERIAL = "https://api.weixin.qq.com/cgi-bin/material/add_material?access_token=ACCESS_TOKEN&type=TYPE";
    /**
     * 上传图文消息内的图片获取URL
     **/
    public static final String MEDIA_UPLOADIMG = "https://api.weixin.qq.com/cgi-bin/media/uploadimg?access_token=ACCESS_TOKEN";

    public static final String OAUTH2_URL =
            "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";
    public static final String REFRESH_OAUTH2_URL =
            "https://api.weixin.qq.com/sns/oauth2/refresh_token?appid=APPID&grant_type=refresh_token&refresh_token=REFRESH_TOKEN ";

    public static final String GET_USER_INFO_URL = "https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";
}
