package com.lou.weixin.sdk.support.mp;

import com.google.gson.JsonObject;
import com.lou.weixin.sdk.bean.result.*;
import com.lou.weixin.sdk.exception.WxErrorException;
import com.lou.weixin.sdk.utils.http.WxHttpUtil;
import com.lou.weixin.sdk.utils.json.WxGsonBuilder;

/**
 * 公众号数据API集成
 *
 * @author loufeng
 * @date 2018/7/5 上午10:19.
 */
@SuppressWarnings("unused")
public class MpDataSupport {
    /**
     * 获取消息数据，最大时间跨度7
     **/
    private static final String GET_UPSTREAM_MSG_URL = "https://api.weixin.qq.com/datacube/getupstreammsg?access_token=ACCESS_TOKEN";
    /**
     * 图文群发每日统计，最大时间跨度1
     **/
    private static final String GET_ARTICLE_SUMMARY = "https://api.weixin.qq.com/datacube/getarticlesummary?access_token=ACCESS_TOKEN";
    /**
     * 获取累计用户数据
     **/
    private static final String GET_USER_CUMULATE_URL = "https://api.weixin.qq.com/datacube/getusercumulate?access_token=ACCESS_TOKEN";
    /**
     * 获取用户增减数据
     **/
    private static final String GET_USER_SUMMARY_URL = "https://api.weixin.qq.com/datacube/getusersummary?access_token=ACCESS_TOKEN";
    /**
     * 获取图文群发总数据（getarticletotal） 最大时间跨度1
     **/
    private static final String DATACUBE_GET_ARTIVLE_TOTAL = "https://api.weixin.qq.com/datacube/getarticletotal?access_token=ACCESS_TOKEN";


    /**
     * 获取消息数据
     *
     * @param token     公众号token
     * @param beginDate 日期
     * @param endDate   日期
     * @return 结果
     * @throws WxErrorException error
     */
    public static UpstreamMsgResult getStreamMsg(String token, String beginDate, String endDate) throws WxErrorException {
        String url = GET_UPSTREAM_MSG_URL.replace("ACCESS_TOKEN", token);
        JsonObject json = new JsonObject();
        json.addProperty("begin_date", beginDate);
        json.addProperty("end_date", endDate);
        String result = WxHttpUtil.post(url, json);

        return WxGsonBuilder.create().fromJson(result, UpstreamMsgResult.class);
    }

    /**
     * 获取图文数据
     *
     * @param appId   公众号appId
     * @param token   公众号token
     * @param refDate 日期
     * @return 结果
     * @throws WxErrorException error
     */
    public static WxArticleSummaryResult getArticleSummary(String appId, String token, String refDate) throws WxErrorException {
        String url = GET_ARTICLE_SUMMARY.replace("ACCESS_TOKEN", token);
        JsonObject json = new JsonObject();
        json.addProperty("begin_date", refDate);
        json.addProperty("end_date", refDate);
        String result = WxHttpUtil.post(url, json);
        return WxGsonBuilder.create().fromJson(result, WxArticleSummaryResult.class);
    }

    /**
     * 获取粉丝累计数据
     *
     * @param token     公众号token
     * @param beginDate 开始日期
     * @param endDate   截止日期
     * @return 结果
     * @throws WxErrorException error
     */
    public static WxUserAnalyzeResult4Calculate getUserCumulate(String token, String beginDate, String endDate) throws WxErrorException {
        String url = GET_USER_CUMULATE_URL.replace("ACCESS_TOKEN", token);
        JsonObject json = new JsonObject();
        json.addProperty("begin_date", beginDate);
        json.addProperty("end_date", endDate);
        String result = WxHttpUtil.post(url, json);
        return WxGsonBuilder.create().fromJson(result, WxUserAnalyzeResult4Calculate.class);
    }

    /**
     * 获取粉丝新增数据
     *
     * @param token     公众号token
     * @param beginDate 开始日期
     * @param endDate   截止日期
     * @return 结果
     * @throws WxErrorException error
     */
    public static WxUserAnalyzeResult4Summary getUserSummary(String token, String beginDate, String endDate) throws WxErrorException {
        String url = GET_USER_SUMMARY_URL.replace("ACCESS_TOKEN", token);
        JsonObject json = new JsonObject();
        json.addProperty("begin_date", beginDate);
        json.addProperty("end_date", endDate);
        String result = WxHttpUtil.post(url, json);
        return WxGsonBuilder.create().fromJson(result, WxUserAnalyzeResult4Summary.class);
    }

    /**
     * 获取图文群发总数据
     *
     * @param token 公众号token
     * @param date  日期
     * @return 数据
     * @throws WxErrorException error
     */
    public static WxArticleTotalResult getArticleTotal(String token, String date) throws WxErrorException {
        String url = DATACUBE_GET_ARTIVLE_TOTAL.replace("ACCESS_TOKEN", token);
        JsonObject json = new JsonObject();
        json.addProperty("begin_date", date);
        json.addProperty("end_date", date);
        String result = WxHttpUtil.post(url, json);
        return WxGsonBuilder.create().fromJson(result, WxArticleTotalResult.class);
    }


}
