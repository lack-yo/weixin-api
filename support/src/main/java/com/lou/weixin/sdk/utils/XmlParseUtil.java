package com.lou.weixin.sdk.utils;

import org.apache.commons.lang3.StringUtils;
import org.dom4j.Element;

import java.util.List;

/**
 * xml转换工具类
 *
 * @author loufeng
 * @date 2018/7/9 下午3:09.
 */
public class XmlParseUtil {
    public static String getSubElementString(Element element, String key) {
        @SuppressWarnings("unchecked")
        List<Object> elements = element.content();
        for (Object e : elements) {
            if (!(e instanceof Element)) {
                continue;
            }
            if (key.equalsIgnoreCase(((Element) e).getName())) {
                return trim(((Element) e).getText());
            }
        }
        return null;
    }

    public static Element getSubElement(Element element, String key) {
        @SuppressWarnings("unchecked")
        List<Object> elements = element.content();
        for (Object e : elements) {
            if (!(e instanceof Element)) {
                continue;
            }
            if (key.equalsIgnoreCase(((Element) e).getName())) {
                return (Element) e;
            }
        }
        return null;
    }

    private static String trim(String text) {
        if (StringUtils.isNotBlank(text)) {
            //替换中文空格
            text = text.replaceAll("　", " ");
            return text.trim();
        }
        return null;
    }
}
