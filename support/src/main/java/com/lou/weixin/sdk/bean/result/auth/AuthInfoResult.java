package com.lou.weixin.sdk.bean.result.auth;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.lou.weixin.sdk.constants.FuncInfoType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @author loufeng
 * @date 2018/7/9 上午10:55.
 */
public class AuthInfoResult {
    private final static Logger LOGGER = LoggerFactory.getLogger(AuthInfoResult.class);
    private String appId;
    private AuthorizerInfo authorizerInfo;
    private List<FuncInfoType> funcInfo;
    private MiniProgramInfo miniProgramInfo;

    public AuthorizerInfo getAuthorizerInfo() {
        return authorizerInfo;
    }

    public void setAuthorizerInfo(AuthorizerInfo authorizerInfo) {
        this.authorizerInfo = authorizerInfo;
    }

    /**
     * 授权方认证类型，-1代表未认证，0代表微信认证，1代表新浪微博认证，
     * 2代表腾讯微博认证，
     * 3代表已资质认证通过但还未通过名称认证，
     * 4代表已资质认证通过、还未通过名称认证，但通过了新浪微博认证，
     * 5代表已资质认证通过、还未通过名称认证，但通过了腾讯微博认证
     *
     * @return
     */
    public Integer getVerifyType() {
        if (null != authorizerInfo) {
            return authorizerInfo.getVerifyTypeInfo();
        }
        return null;
    }

    /**
     * 是否认证
     *
     * @return
     */
    public boolean isVerify() {
        Integer result = getVerifyType();
        if (-1 == result) {
            return false;
        }
        return true;
    }

    /**
     * 授权方公众号类型，0代表订阅号，1代表由历史老帐号升级后的订阅号，2代表服务号
     *
     * @return 类型
     */
    public Integer getServiceType() {
        if (null != authorizerInfo) {
            return authorizerInfo.getServiceTypeInfo();
        }
        return null;
    }

    /**
     * 是否是服务号
     *
     * @return true/false
     */
    public boolean isServiceAccount() {
        if (getServiceType() == 2) {
            return true;
        }
        return false;
    }

    /**
     * 是否授权小程序管理权限
     *
     * @return true、false
     */
    public boolean authLink() {
        return funcInfo.contains(FuncInfoType.FUNC_LINK);
    }

    public List<FuncInfoType> getFuncInfo() {
        return funcInfo;
    }

    public void setFuncInfo(List<FuncInfoType> funcInfo) {
        this.funcInfo = funcInfo;
    }

    public MiniProgramInfo getMiniProgramInfo() {
        return miniProgramInfo;
    }

    public void setMiniProgramInfo(MiniProgramInfo miniProgramInfo) {
        this.miniProgramInfo = miniProgramInfo;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public List<FuncInfoType> getMiniFunc() {
        try {
            List<FuncInfoType> miniFunc = Lists.newArrayList();
            miniFunc.add(FuncInfoType.FUNC_MINA_ACCOUNT);
            miniFunc.add(FuncInfoType.FUNC_MINA_CUSTOMER);
            miniFunc.add(FuncInfoType.FUNC_MINA_DATA);
            miniFunc.add(FuncInfoType.FUNC_MINA_DEV);
            miniFunc.add(FuncInfoType.FUNC_MINA_LOGIN);
            miniFunc.add(FuncInfoType.FUNC_MINA_PLATFORM);
            if (funcInfo == null || funcInfo.isEmpty()) {
                return miniFunc;
            }
            LOGGER.info("授权的权限，appId," + appId + ", " + JSON.toJSONString(funcInfo));
            miniFunc.removeAll(funcInfo);
            return miniFunc;
        } catch (Exception e) {
            LOGGER.error("获取授权信息失败，", e);
            return Lists.newArrayList();
        }
    }
}
