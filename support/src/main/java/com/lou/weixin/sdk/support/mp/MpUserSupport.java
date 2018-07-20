package com.lou.weixin.sdk.support.mp;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.internal.Streams;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.lou.weixin.sdk.bean.WxGroup;
import com.lou.weixin.sdk.bean.result.WxUser;
import com.lou.weixin.sdk.bean.result.WxUserListResult;
import com.lou.weixin.sdk.constants.LanguageType;
import com.lou.weixin.sdk.exception.WxErrorException;
import com.lou.weixin.sdk.utils.GsonConvertUtil;
import com.lou.weixin.sdk.utils.http.WxHttpUtil;
import com.lou.weixin.sdk.utils.json.WxGsonBuilder;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

/**
 * 用户管理
 *
 * @author loufeng
 * @date 2018/7/5 上午10:18.
 */
@SuppressWarnings("unused")
public class MpUserSupport {
    /**
     * 创建用户分组接口
     **/
    private static final String GROUPS_CREATE_URL = "https://api.weixin.qq.com/cgi-bin/groups/create?access_token=ACCESS_TOKEN";
    /**
     * 查询所有分组接口
     **/
    private static final String GROUPS_GET_URL = "https://api.weixin.qq.com/cgi-bin/groups/get?access_token=ACCESS_TOKEN";
    /**
     * 查询用户所在分组接口
     **/
    private static final String GROUPS_GET_ID_URL = "https://api.weixin.qq.com/cgi-bin/groups/getid?access_token=ACCESS_TOKEN";
    /**
     * 修改分组名称接口
     **/
    private static final String GROUPS_UPDATE_URL = "https://api.weixin.qq.com/cgi-bin/groups/update?access_token=ACCESS_TOKEN";
    /**
     * 移动用户分组接口
     **/
    private static final String GROUPS_MEMBER_UPDATE_URL = "https://api.weixin.qq.com/cgi-bin/groups/members/update?access_token=ACCESS_TOKEN";
    /**
     * 批量移动用户分组接口
     **/
    private static final String GROUPS_MEMBER_BATCH_UPDATE_URL = "https://api.weixin.qq.com/cgi-bin/groups/members/batchupdate?access_token=ACCESS_TOKEN";
    /**
     * 获取用户基本信息（包括UnionID机制）接口
     **/
    private static final String USER_INFO_GET_URL = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=OPENID&lang=LANG";
    /**
     * 获取用户列表接口
     **/
    private static final String USER_GET_URL = "https://api.weixin.qq.com/cgi-bin/user/get?access_token=ACCESS_TOKEN&next_openid=NEXT_OPENID";
    /**
     * 批量获取用户信息接口
     **/
    private static final String USER_INFO_BATCHGET = "https://api.weixin.qq.com/cgi-bin/user/info/batchget?access_token=ACCESS_TOKEN";


    /**
     * 拉取粉丝信息
     *
     * @param token  公众号token
     * @param openId 粉丝id
     * @param type   语言 {@link LanguageType}
     * @return 结果
     * @throws WxErrorException error
     */
    public static WxUser getUserInfo(String token, String openId, LanguageType type) throws WxErrorException {
        if (null == type) {
            type = LanguageType.zh_CN;
        }
        String url = USER_INFO_GET_URL
                .replace("ACCESS_TOKEN", token)
                .replace("OPENID", openId)
                .replace("LANG", type.toString());
        String responseContent = WxHttpUtil.get(url);
        return WxUser.fromJson(responseContent);
    }


    /**
     * 创建分组
     *
     * @param token 公众号token
     * @param name  组名
     * @return 结果
     * @throws WxErrorException error
     */
    public static WxGroup groupCreate(String token, String name) throws WxErrorException {
        String url = GROUPS_CREATE_URL.replace("ACCESS_TOKEN", token);
        JsonObject json = new JsonObject();
        JsonObject groupJson = new JsonObject();
        json.add("group", groupJson);
        groupJson.addProperty("name", name);

        String responseContent = WxHttpUtil.post(url, json);
        return WxGroup.fromJson(responseContent);
    }

    /**
     * 获取所有分组
     *
     * @param token 公众号token
     * @return 分组列表
     * @throws WxErrorException error
     */
    public static List<WxGroup> groupGet(String token) throws WxErrorException {
        String url = GROUPS_GET_URL.replace("ACCESS_TOKEN", token);
        String responseContent = WxHttpUtil.get(url);
        /*
         * 操蛋的微信API，创建时返回的是 { group : { id : ..., name : ...} } 查询时返回的是 { groups
         * : [ { id : ..., name : ..., count : ... }, ... ] }
         */
        JsonElement tmpJsonElement = Streams.parse(new JsonReader(new StringReader(responseContent)));
        return WxGsonBuilder.INSTANCE.create().fromJson(tmpJsonElement.getAsJsonObject().get("groups"),
                new TypeToken<List<WxGroup>>() {
                }.getType());
    }

    /**
     * 获取用户所在分组
     *
     * @param token  公众号token
     * @param openId 粉丝id
     * @return 结果
     * @throws WxErrorException error
     */
    public static Long userGetGroup(String token, String openId) throws WxErrorException {
        String url = GROUPS_GET_ID_URL.replace("ACCESS_TOKEN", token);
        JsonObject o = new JsonObject();
        o.addProperty("openid", openId);
        String responseContent = WxHttpUtil.post(url, o);
        JsonElement tmpJsonElement = Streams.parse(new JsonReader(new StringReader(responseContent)));
        JsonObject jo = tmpJsonElement.getAsJsonObject();
        if (jo != null) {
            return GsonConvertUtil.getAsLong(jo.get("groupid"));
        }
        return null;
    }

    /**
     * 更新分组
     *
     * @param token 公众号token
     * @param group 分组
     * @throws WxErrorException error
     */
    public static void groupUpdate(String token, WxGroup group) throws WxErrorException {
        String url = GROUPS_UPDATE_URL.replace("ACCESS_TOKEN", token);
        WxHttpUtil.post(url, group);
    }

    /**
     * 更新用户分组
     *
     * @param token     公众号token
     * @param openId    粉丝id
     * @param toGroupId 分配的分组id
     * @throws WxErrorException error
     */
    public static void userUpdateGroup(String token, String openId, long toGroupId) throws WxErrorException {
        String url = GROUPS_MEMBER_UPDATE_URL.replace("ACCESS_TOKEN", token);
        JsonObject json = new JsonObject();
        json.addProperty("openid", openId);
        json.addProperty("to_groupid", toGroupId);
        WxHttpUtil.post(url, json);
    }

    /**
     * 获取关注用户列表
     *
     * @param token      公众号token
     * @param nextOpenId 下一个用户id
     * @return 用户列表
     * @throws WxErrorException error
     */
    public static WxUserListResult getConcernUserList(String token, String nextOpenId) throws WxErrorException {
        String url = USER_GET_URL.replace("ACCESS_TOKEN", token).replace("NEXT_OPENID", nextOpenId);
        String responseContent = WxHttpUtil.get(url);
        return WxGsonBuilder.create().fromJson(responseContent, WxUserListResult.class);
    }

    /**
     * 批量获取用户信息
     *
     * @param token   公众号token
     * @param openIds 用户id列表
     * @return 用户信息列表
     */
    public static List<WxUser> batchGetUserInfo(String token, List<String> openIds, LanguageType type) throws WxErrorException {
        String url = USER_INFO_BATCHGET.replace("ACCESS_TOKEN", token);
        Map<String, Object> map = Maps.newHashMap();
        List<Map<String, String>> array = Lists.newArrayList();
        for (String openId : openIds) {
            Map<String, String> json = Maps.newHashMap();
            json.put("openid", openId);
            json.put("lang", type.toString());
            array.add(json);
        }
        map.put("user_list", array);
        String result = WxHttpUtil.post(url, map);

        JsonElement tmpJsonElement = Streams.parse(new JsonReader(new StringReader(result)));
        return WxGsonBuilder.INSTANCE.create().fromJson(tmpJsonElement.getAsJsonObject().get("user_info_list"),
                new TypeToken<List<WxUser>>() {
                }.getType());
    }


}
