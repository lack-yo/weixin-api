package com.lou.weixin.controller;

import com.lou.weixin.sdk.bean.msg.AuthorityMessage;
import com.lou.weixin.sdk.bean.sign.AesException;
import com.lou.weixin.sdk.bean.sign.WXBizMsgCrypt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * 作为微信开发消息处理
 *
 * @author loufeng
 * @date 2017/7/7 上午10:18.
 */
@Controller
public class CallBack {
    private static final Logger LOGGER = LoggerFactory.getLogger(CallBack.class);

    private static final String TEST_APPID = "xxx";

    @RequestMapping(value = "/open/{componentAppId}/auth")
    public void auth(@PathVariable String componentAppId, HttpServletRequest request, HttpServletResponse response) {
        LOGGER.info("开始进入auth检测！！！componentAppId:{}", componentAppId);
        response.setContentType("text/html;charset=UTF-8");

        String msgSignature = request.getParameter("msg_signature");
        String timestamp = request.getParameter("timestamp");
        String nonce = request.getParameter("nonce");
        try {
            String xml = parseInputStream2Str(request.getInputStream());
            LOGGER.info("加密xml内容为：" + xml);

            xml = decode(msgSignature, timestamp, nonce, xml, componentAppId);
            LOGGER.info("解密xml内容为：" + xml);
            AuthorityMessage wrapper = AuthorityMessage.parseToXml(xml);

            if (null != wrapper) {
                switch (wrapper.getInfoType()) {
                    case "component_verify_ticket":
                        LOGGER.info("COMPONENT_VERIFY_TICKET缓存");
                        break;
                    case "unauthorized":
                        LOGGER.info("unauthorized");
                        break;
                    case "authorized":
                        LOGGER.info("授权" + wrapper.getInfoType());
                        break;
                    case "updateauthorized":
                        LOGGER.info(wrapper.getInfoType());
                        break;
                    default:
                        break;
                }
            }

            response.getWriter().write("success");
        } catch (IOException e) {
            LOGGER.error("authority error: ", e);
        }
    }


    @RequestMapping(value = "/open/{componentAppId}/{appid}/callback")
    public void callback(@PathVariable String componentAppId, @PathVariable String appid, HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        LOGGER.info("开始进入callback检测！！！componentAppId:{},appId:{}", componentAppId, appid);
        response.setContentType("text/html;charset=UTF-8");
        if (TEST_APPID.equals(appid)) {
//            test4OpenPlatform(request, response);
            return;
        }

        LOGGER.info("callback检测结束！！！");
    }

    /**
     * 网络io转字符串
     *
     * @param inputStream io流
     * @return 内容
     */
    private String parseInputStream2Str(InputStream inputStream) {
        BufferedReader br = null;
        String inputString = "";
        try {
            br = new BufferedReader(new InputStreamReader(inputStream, "utf-8"));
            String line;
            while ((line = br.readLine()) != null) {
                inputString += line;
            }
        } catch (IOException e) {
            return null;
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException ignored) {

                }
            }
        }
        return inputString;
    }

    /**
     * 解密内容
     *
     * @param msgSignature   验签
     * @param timeStamp      时间戳
     * @param nonce          随机串
     * @param xml            待解密内容
     * @param componentAppId 第三方平台id
     * @return 解密后内容
     */
    private String decode(String msgSignature, String timeStamp, String nonce, String xml, String componentAppId) {
        try {
            WXBizMsgCrypt pc = new WXBizMsgCrypt("token", "VutXZHhSC5dVUwKCDDQLTlzCl7ODlCgY6Hqgi4p3Nxh", componentAppId);
            return pc.decryptMsg1(msgSignature, timeStamp, nonce, xml);
        } catch (AesException e) {
            LOGGER.error("decode error,", e);
        }
        return null;
    }

}

