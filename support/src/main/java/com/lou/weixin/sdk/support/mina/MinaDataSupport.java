package com.lou.weixin.sdk.support.mina;

import com.google.gson.JsonObject;
import com.lou.weixin.sdk.bean.result.weapp.*;
import com.lou.weixin.sdk.exception.WxErrorException;
import com.lou.weixin.sdk.utils.http.WxHttpUtil;
import com.lou.weixin.sdk.utils.json.WxGsonBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 小程序数据API集成
 *
 * @author loufeng
 * @date 2018/7/5 上午10:15.
 */
@SuppressWarnings("unused")
public class MinaDataSupport {
    private static final Logger LOGGER = LoggerFactory.getLogger(MinaDataSupport.class);
    /**
     * 小程序概况趋势，post
     */
    private static final String URL_DATA_SUMMARY = "https://api.weixin.qq.com/datacube/getweanalysisappiddailysummarytrend?access_token=ACCESS_TOKEN";
    /**
     * 小程序访问日趋势，post
     */
    private static final String URL_DATA_VISIT = "https://api.weixin.qq.com/datacube/getweanalysisappiddailyvisittrend?access_token=ACCESS_TOKEN";
    /**
     * 小程序访问周趋势，post
     */
    private static final String URL_DATA_WEEK_VISIT = "https://api.weixin.qq.com/datacube/getweanalysisappidweeklyvisittrend?access_token=ACCESS_TOKEN";
    /**
     * 小程序访问月趋势，post
     */
    private static final String URL_DATA_MONTH_VISIT = "https://api.weixin.qq.com/datacube/getweanalysisappidmonthlyvisittrend?access_token=ACCESS_TOKEN";

    /**
     * 小程序访问分布
     */
    private static final String URL_DATA_VISIT_DISTRIBUTION = "https://api.weixin.qq.com/datacube/getweanalysisappidvisitdistribution?access_token=ACCESS_TOKEN";
    /**
     * 小程序日留存
     */
    private static final String URL_DATA_RETAIN_INFO = "https://api.weixin.qq.com/datacube/getweanalysisappiddailyretaininfo?access_token=ACCESS_TOKEN";
    /**
     * 小程序周留存
     */
    private static final String URL_DATA_WEEK_RETAIN_INFO = "https://api.weixin.qq.com/datacube/getweanalysisappidweeklyretaininfo?access_token=ACCESS_TOKEN";
    /**
     * 小程序月留存
     */
    private static final String URL_DATA_MONTH_RETAIN_INFO = "https://api.weixin.qq.com/datacube/getweanalysisappidmonthlyretaininfo?access_token=ACCESS_TOKEN";
    /**
     * 小程序访问页面
     */
    private static final String URL_DATA_VISIT_PAGE = "https://api.weixin.qq.com/datacube/getweanalysisappidvisitpage?access_token=ACCESS_TOKEN";
    /**
     * 小程序用户画像
     */
    private static final String URL_DATA_USER = "https://api.weixin.qq.com/datacube/getweanalysisappiduserportrait?access_token=ACCESS_TOKEN";


    /**
     * 获取小程序每日概况
     *
     * @param token   小程序token
     * @param refDate 查询日期，如20170312
     * @return 查询的概况数据
     * @throws WxErrorException 微信异常
     */
    public static DailySummary getDailySummary(String token, String refDate) throws WxErrorException {
        String url = URL_DATA_SUMMARY.replace("ACCESS_TOKEN", token);
        JsonObject params = new JsonObject();
        params.addProperty("begin_date", refDate);
        params.addProperty("end_date", refDate);
        String result = WxHttpUtil.post(url, params);
        return WxGsonBuilder.INSTANCE.create().fromJson(result, DailySummary.class);
    }

    /**
     * 获取小程序日访问趋势
     *
     * @param token 小程序token
     * @param start 开始日期，为周一日期，如20170306
     * @param end   结束日期，为周日日期，如20170312
     * @return 日访问趋势
     * @throws WxErrorException 微信异常
     */
    public static DailyVisit getMINAVisit(String token, String start, String end) throws WxErrorException {
        String url = URL_DATA_VISIT.replace("ACCESS_TOKEN", token);
        JsonObject params = new JsonObject();
        params.addProperty("begin_date", start);
        params.addProperty("end_date", end);
        String result = WxHttpUtil.post(url, params);
        return WxGsonBuilder.INSTANCE.create().fromJson(result, DailyVisit.class);
    }

    /**
     * 获取小程序访问分布数据
     *
     * @param token   小程序token
     * @param refDate 查询的日期，如20170313
     * @return 小程序访问分布数据
     * @throws WxErrorException 微信异常
     */
    public static VisitDistributionResult getMINAVisitDistribution(String appId, String token, String refDate) throws WxErrorException {
        String url = URL_DATA_VISIT_DISTRIBUTION.replace("ACCESS_TOKEN", token);
        JsonObject params = new JsonObject();
        params.addProperty("begin_date", refDate);
        params.addProperty("end_date", refDate);
        String result = WxHttpUtil.post(url, params);
        LOGGER.info("获取绑定小程序访问分布，时间跨度：{}--{}，appId：{},result:{} ", refDate, refDate, appId, result);
        return WxGsonBuilder.INSTANCE.create().fromJson(result, VisitDistributionResult.class);
    }

    /**
     * 获取小程序日留存
     *
     * @param token 小程序token
     * @param start 开始日期，为周一日期，如20170306
     * @param end   结束日期，为周日日期，如20170312
     * @return 小程序日留存
     * @throws WxErrorException 微信异常
     */
    public static RetainInfo getMINARetainInfo(String token, String start, String end) throws WxErrorException {
        String url = URL_DATA_RETAIN_INFO.replace("ACCESS_TOKEN", token);
        JsonObject params = new JsonObject();
        params.addProperty("begin_date", start);
        params.addProperty("end_date", end);
        String result = WxHttpUtil.post(url, params);
        return WxGsonBuilder.INSTANCE.create().fromJson(result, RetainInfo.class);
    }

    /**
     * 查询小程序访问页面数据
     *
     * @param token   小程序token
     * @param refDate 查询日期
     * @return 访问页面数据
     * @throws WxErrorException 微信异常
     */
    public static VisitPageResult getMINAVisitPage(String token, String refDate) throws WxErrorException {
        String url = URL_DATA_VISIT_PAGE.replace("ACCESS_TOKEN", token);
        JsonObject params = new JsonObject();
        params.addProperty("begin_date", refDate);
        params.addProperty("end_date", refDate);
        String result = WxHttpUtil.post(url, params);
        return WxGsonBuilder.INSTANCE.create().fromJson(result, VisitPageResult.class);
    }

    /**
     * 获取小程序用户画像，开始日期与结束日期相差的天数限定为0/6/29
     * 分别表示查询最近1/7/30天数据，end_date允许设置的最大值为昨日
     *
     * @param token 小程序token
     * @param start 开始日期
     * @param end   结束日期
     * @return 小程序用户画像
     * @throws WxErrorException 微信异常
     */
    public static UserPortrait getUserPortrait(String token, String start, String end) throws WxErrorException {
        String url = URL_DATA_USER.replace("ACCESS_TOKEN", token);
        JsonObject params = new JsonObject();
        params.addProperty("begin_date", start);
        params.addProperty("end_date", end);
        String result = WxHttpUtil.post(url, params);
        return WxGsonBuilder.INSTANCE.create().fromJson(result, UserPortrait.class);
    }

}
