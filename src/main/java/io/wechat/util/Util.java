package io.wechat.util;

import com.google.gson.Gson;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Util {
    public static String extractString(String p, String str) {
        Pattern pattern = Pattern.compile(p);
        Matcher m = pattern.matcher(str);
        if (m.find()) {
            return m.group(1);
        }
        return null;
    }

    public static String getCookie(List<String> cookies) {
        StringBuilder sBuffer = new StringBuilder();
        for (String value : cookies) {
            if (value == null) {
                continue;
            }
            String cookie = value.substring(0, value.indexOf(";") + 1);
            sBuffer.append(cookie);
        }
        return sBuffer.toString();
    }

    public static String toJson(Object object) {
        return new Gson().toJson(object);
    }

    public static <T> T fromJson(String json, Class<T> clazz) {
        return new Gson().fromJson(json, clazz);
    }
}
