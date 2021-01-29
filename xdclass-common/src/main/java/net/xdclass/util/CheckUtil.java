package net.xdclass.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 小滴课堂,愿景：让技术不再难学
 *
 * @Description
 * @Author 二当家小D
 * @Remark 有问题直接联系我，源码-笔记-技术交流群
 * @Version 1.0
 **/

public class CheckUtil {


    /**
     * 邮箱正则
     */
    private static final Pattern MAIL_PATTERN = Pattern.compile("^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$");

    /**
     * 手机号正则，暂时未用
     */
    private static final Pattern PHONE_PATTERN = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");

    /**
     * @param email
     * @return
     */
    public static  boolean isEmail(String email) {
        if (null == email || "".equals(email)) {
            return false;
        }
        Matcher m = MAIL_PATTERN.matcher(email);
        return m.matches();
    }

    /**
     * 暂时未用
     * @param phone
     * @return
     */
    public static boolean isPhone(String phone) {
        if (null == phone || "".equals(phone)) {
            return false;
        }
        Matcher m = PHONE_PATTERN.matcher(phone);
        return m.matches();

    }
}
