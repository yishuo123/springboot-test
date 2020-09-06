package com.example.springboottest.core.util;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    private static SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd");
    private static SimpleDateFormat sdfDateTime = new SimpleDateFormat("yyyyMMddHHmmss");
    private static SimpleDateFormat sdfDateTime2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * 获取永久时间2036年
     *
     * @return
     * @throws Exception
     */
    public static Date getPermanentDate() throws Exception {
        String permDate = "2036-11-26 00:00:00";

        Date date = sdfDateTime2.parse(permDate);

        return date;
    }


    /**
     * 字符串转换日期类型
     *
     * @return
     * @throws ParseException
     */
    public static Date dateStr(String str) throws Exception {
        return sdfDate.parse(str);
    }

    /**
     * 字符串转换日期类型
     *
     * @return
     * @throws ParseException
     */
    public static Date dateStr(String str, String pattern) throws Exception {
        if (StringUtils.isNotBlank(str)) {
            if (StringUtils.isNotBlank(pattern)) {

                SimpleDateFormat sdfPatDate = new SimpleDateFormat(pattern);
                return sdfPatDate.parse(str);
            } else {
                return dateStr(str);
            }
        } else {
            return null;
        }

    }

    /**
     * 转换日期类型为 yyyy-MM-dd HH:mm:ss
     *
     * @param date 日期
     * @return
     */
    public static String sdfDateTime2(Date date) {
        return sdfDateTime2.format(date);
    }

    /**
     * 转换日期类型为 yyyy-MM-dd
     *
     * @param date 日期类型
     * @return
     */
    public static String sdfDate(Date date) {
        return sdfDate.format(date);
    }

    /**
     * 转换日期为年-月-日 时：分：秒
     *
     * @param date
     * @return
     */
    public static String sdfDateTime(Date date) {
        return sdfDateTime.format(date);
    }

    /**
     * 获取当前时间
     *
     * @return
     */
    public static Date getDate() {
        return new Date();
    }

    /**
     * 计算用时
     *
     * @param beginDate
     * @param endDate
     * @return
     */
    public static long getBetweenDate(Date beginDate, Date endDate) {

        long beginTime = beginDate.getTime();
        long endTime = endDate.getTime();

        long between = (long) (endTime - beginTime);


        return between;
    }

    /**
     * 获取时间戳
     *
     * @return
     */
    public static long getTime() {
        return new Date().getTime();
    }

    /**
     * 获取自定义格式化后的字符串
     *
     * @param date
     * @param pattern
     * @return
     */
    public static String formatDate(Date date, String pattern) {
        String formatDate = null;
        if (StringUtils.isNotBlank(pattern)) {
            formatDate = DateFormatUtils.format(date, pattern);
        } else {
            formatDate = DateFormatUtils.format(date, "yyyy-MM-dd");
        }
        return formatDate;
    }

    /**
     * 判断一个字符串是不是一个合法的日期格式
     *
     * @param str     字符串
     * @param pattern
     * @return
     */
    public static boolean isValidDate(String str, String pattern) {
        boolean convertSuccess = true;
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        try {
            format.setLenient(false);
            format.parse(str);
        } catch (ParseException e) {
            convertSuccess = false;
        }
        return convertSuccess;
    }
}
