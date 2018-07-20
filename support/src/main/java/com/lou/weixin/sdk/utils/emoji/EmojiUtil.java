package com.lou.weixin.sdk.utils.emoji;

import org.apache.commons.lang3.StringEscapeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author loufeng
 * @date 2018/7/9 下午3:03.
 */
@SuppressWarnings("unused")
public class EmojiUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(EmojiUtil.class);
    /**
     * emoji通常正则
     */
    private static final String REX = "[\ud83c\udc00-\ud83c\udfff]|[\ud83d\udc00-\ud83d\udfff]|[\u2600-\u27ff]";

    /**
     * 过滤字符串中的emoji表情，替换为空字符串
     *
     * @param str 待处理的字符串
     * @return 过滤后
     */
    public static String filter(String str) {
        if (null == str || "".equals(str)) {
            return "";
        }
        Pattern emoji =
                Pattern.compile(REX,
                        Pattern.UNICODE_CASE | Pattern.CASE_INSENSITIVE);
        Matcher emojiMatcher = emoji.matcher(str);
        return emojiMatcher.replaceAll("");
    }

    /**
     * 将带有emoji表情的字符串中的表情字符集encode为可存储的普通字符串
     *
     * @param str 待处理的字符串（含有emoji表情，case：😂）
     * @return 替换后的字符串（处理后，case：[[%F0%9F%98%82]]）
     */
    public static String encodeStr(String str) {
        String patternString = "([\\x{10000}-\\x{10ffff}\ud800-\udfff])";
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(str);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            try {
                matcher.appendReplacement(
                        sb,
                        "[["
                                + URLEncoder.encode(matcher.group(1),
                                "UTF-8") + "]]");
            } catch (UnsupportedEncodingException e) {
                LOGGER.error("encode error，str：" + str, e);
                return str;
            }
        }
        return matcher.appendTail(sb).toString();
    }

    /**
     * 将处理过的表情字符串中的表情decode为emoji表情字符集
     *
     * @param str 待处理的字符串（case：[[%F0%9F%98%82]]）
     * @return 替换后的字符串（case：😂）
     */
    public static String decodeStr(String str) {
        String patternString = "\\[\\[(.*?)\\]\\]";
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(str);

        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            try {
                matcher.appendReplacement(sb,
                        URLDecoder.decode(matcher.group(1), "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                LOGGER.error("decode error，str：" + str, e);
                return str;
            }
        }
        matcher.appendTail(sb);
        return sb.toString();
    }

    /**
     * 最优解，将字符串中的emoji表情替换为unicode字符串，可在mysql存储，无需转换即可使用
     *
     * @param string 含有emoji的字符串
     * @return 处理后的字符串(注意使用时可用StringEscapeUtils.unescapeJava将字符串中的unicode字符识别出来)
     */
    public static String parse2UnicodeStr(String string) {
        Pattern emoji =
                Pattern.compile(REX,
                        Pattern.UNICODE_CASE | Pattern.CASE_INSENSITIVE);

        Matcher emojiMatcher = emoji.matcher(string);
        StringBuffer result = new StringBuffer();
        while (emojiMatcher.find()) {
            String emojiStr = emojiMatcher.group();
            StringBuilder unicode = new StringBuilder();
            for (int i = 0; i < emojiStr.length(); i++) {
                unicode.append("\\\\u").append(Integer.toHexString((int) emojiStr.charAt(i)));
            }
            emojiMatcher.appendReplacement(result,
                    unicode.toString());
        }
        emojiMatcher.appendTail(result);
        return result.toString();
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        String emojiStr = "😂";
        System.out.println(emojiStr + ",length：" + emojiStr.length());
        System.out.println("----------------------------------");
        String unicodeStr = parse2UnicodeStr(emojiStr);
        System.out.println("转换成unicode字符串直接存储：" + unicodeStr + ",length：" + unicodeStr.length());
        System.out.println("unicode字符串转化为emoji：" + StringEscapeUtils.unescapeJava(unicodeStr));
        String encodeStr = encodeStr(emojiStr);
        String decodeStr = decodeStr(encodeStr);
        System.out.println("----------------------------------");
        System.out.println("emoji字符串encode-" + encodeStr + ",length：" + encodeStr.length());
        System.out.println("emoji字符串decode-" + decodeStr);
    }

}
