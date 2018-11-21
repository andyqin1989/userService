package com.user.user_service.util;

public class StringUtil {
    public static boolean isEmpty(String src) {
        return src == null || src.isEmpty();
    }

    public static String getNameError(String name) {
        if (name.isEmpty()) {
            return "昵称不能为空";
        }
        return "";
    }

    public static boolean isNotPhoneNum(String phone) {
        boolean result = false;
        if (StringUtil.isEmpty(phone)) {
            result = true;
        }

        if (phone.length() != 11) {
            result = true;
        }

        for (int i = 0; i < phone.length(); i++) {
            if (phone.charAt(i) > '9' || phone.charAt(i) < '0') {
                result = true;
            }
        }
        return result;
    }

    public static String getPhoneNumError(String phone) {
        String result = "";
        if (StringUtil.isEmpty(phone)) {
            result = "电话号码不能为空";
        }

        if (phone.length() != 11) {
            result = "电话号码格式不正确";
        }

        for (int i = 0; i < phone.length(); i++) {
            if (phone.charAt(i) > '9' || phone.charAt(i) < '0') {
                result = "电话号码格式不正确";
            }
        }
        return result;
    }

    public static boolean isNotPassWord(String passWord) {
        return passWord.isEmpty() || passWord.length() < 6 || passWord.length() > 8;
    }

    public static String getPassWordError(String passWord) {
        String result = "";
        if (passWord.isEmpty()) {
            result = "密码不能为空";
        }

        if (passWord.length() < 6 || passWord.length() > 8) {
            result = "密码长度为6至8位";
        }
        return result;
    }
}