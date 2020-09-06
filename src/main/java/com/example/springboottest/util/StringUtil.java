package com.example.springboottest.util;

public class StringUtil {

    /**
     * 去掉特殊字符
     *
     * @param str 字符串
     * @return
     */
    public static String removeSpecial(String str) {
        String regEx = "[\n`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。， 、？]";

        String newString = str.replaceAll(regEx, "");
        return newString;
    }

    /**
     * 去掉 HTML 标签
     *
     * @param str
     * @return
     */
    public static String removeHTMLLabel(String str) {
        String newStr = str.replaceAll("\\&[a-zA-Z]{1,10};", "").replaceAll("<[^>]*>", "").replaceAll("[(/>)<]", "");
        return newStr;
    }


    /**
     * 去掉 指定的字符串  #  &  ; ?  空格 （中文 英文的）
     *
     * @param str
     * @return
     */
    public static String removeSpecifiedStr(String str) {

        String newStr = str.replaceAll("#", "").replaceAll("&", "").replaceAll(";", "")
                .replaceAll("&#", "").replaceAll("%3f", "").replaceAll("[?]", "").replaceAll(" ", "").replaceAll("  ", "")
                .replaceAll("ampnbsp", " ").replaceAll("     ", "").replaceAll("\r|\n", "");
        ;

        return newStr;
    }


}
