package com.lou.weixin.sdk.support.mp;


import com.lou.weixin.sdk.bean.WxMenu;
import com.lou.weixin.sdk.exception.WxErrorException;
import com.lou.weixin.sdk.utils.http.WxHttpUtil;

/**
 * 菜单管理
 *
 * @author loufeng
 * @date 2018/7/5 上午10:18.
 */
@SuppressWarnings("unused")
public class MpMenuSupport {
    /**
     * 自定义菜单创建接口
     **/
    private static final String MENU_CREATE_URL = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
    /**
     * 自定义菜单查询接口
     **/
    private static final String MENU_GET_URL = "https://api.weixin.qq.com/cgi-bin/menu/get?access_token=ACCESS_TOKEN";
    /**
     * 自定义菜单删除接口
     **/
    private static final String MENU_DELETE_URL = "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=ACCESS_TOKEN";
    /**
     * 个性化菜单查询接口
     */
    private static final String CURRENT_MENU_GET_URL = "https://api.weixin.qq.com/cgi-bin/get_current_selfmenu_info?access_token=ACCESS_TOKEN";


    /**
     * 创建菜单
     *
     * @param token 公众号token
     * @param menu  菜单
     * @throws WxErrorException error
     */
    public static void menuCreate(String token, WxMenu menu) throws WxErrorException {
        String url = MENU_CREATE_URL.replace("ACCESS_TOKEN", token);
        WxHttpUtil.post(url, menu.toJson());
    }


    /**
     * 删除菜单
     *
     * @param token 公众号token
     * @throws WxErrorException error
     */
    public static void menuDelete(String token) throws WxErrorException {
        String url = MENU_DELETE_URL.replace("ACCESS_TOKEN", token);
        WxHttpUtil.get(url);
    }

    /**
     * 获取菜单
     *
     * @param token 公众号token
     * @return 结果
     * @throws WxErrorException error
     */
    public static WxMenu menuGet(String token) throws WxErrorException {
        String url = MENU_GET_URL.replace("ACCESS_TOKEN", token);
        String result = WxHttpUtil.get(url);
        return WxMenu.fromJson(result);
    }

    /**
     * 获取个性化菜单
     *
     * @param token 公众号token
     * @return 结果
     * @throws WxErrorException error
     */
    public static WxMenu currentMenuGet(String token) throws WxErrorException {
        String url = CURRENT_MENU_GET_URL.replace("ACCESS_TOKEN", token);
        String result = WxHttpUtil.get(url);
        return WxMenu.fromJson(result);
    }
}
