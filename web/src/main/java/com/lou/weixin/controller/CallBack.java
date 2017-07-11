package com.lou.weixin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author loufeng
 * @date 2017/7/7 上午10:18.
 * 作为微信开发消息处理
 */
@Controller
public class CallBack {

    @RequestMapping(value = "/callback")
    @ResponseBody
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        //消息匹配和消息处理
        //match
        //handle
        return "success";
    }

}

