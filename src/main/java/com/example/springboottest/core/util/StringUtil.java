package com.example.springboottest.core.util;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.log4j.Logger;

import java.util.regex.Pattern;

public class StringUtil {

    private static Logger logger = Logger.getLogger(StringUtil.class);

    /**
     * 替换路径中的空格为%20
     *
     * @param str
     * @return
     */
    public static String replaceSpace(StringBuffer str) {
        for (int k = 0; k < str.length(); k++) {
            char index = str.charAt(k);
            if (index == ' ') {
                str.replace(k, k + 1, "%20");
            }
        }

        return str.toString();
    }

    /**
     * MD5加密
     *
     * @param str 加密字符串
     * @return
     */
    public static String md5(String str) {
        String ret = "";
        try {
            ret = DigestUtils.md5Hex(str);

        } catch (Exception e) {
            logger.error("md5 error, exception:", e);
        }
        return ret;
    }

    /**
     * 判断浮点数整数 int 类型
     *
     * @param str
     * @return
     */
    public static boolean isInteger(String str) {
        if (null == str || "".equals(str)) {
            return false;
        }
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        return pattern.matcher(str).matches();
    }


    /**
     * 判断浮点数（double和float）
     */
    public static boolean isDouble(String str) {
        if (null == str || "".equals(str)) {
            return false;
        }
        Pattern pattern = Pattern.compile("^[-\\+]?[.\\d]*$");
        return pattern.matcher(str).matches();
    }
}
