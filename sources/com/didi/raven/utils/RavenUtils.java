package com.didi.raven.utils;

import com.google.gson.Gson;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RavenUtils {

    /* renamed from: a */
    private static final Gson f33124a = new Gson();

    /* renamed from: a */
    private static String m23332a(StackTraceElement[] stackTraceElementArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (StackTraceElement append : stackTraceElementArr) {
            stringBuffer.append(append);
            stringBuffer.append("\n");
        }
        return stringBuffer.toString();
    }

    public static String[] getThrowableToStrings(Throwable th) {
        return new String[]{th.toString(), th.getLocalizedMessage(), m23332a(th.getStackTrace())};
    }

    public static String objectToUrl(Object obj) throws UnsupportedEncodingException {
        return stringToUrl(objectToJson(obj));
    }

    public static String stringToUrl(String str, String str2) throws UnsupportedEncodingException {
        return URLEncoder.encode(str, str2);
    }

    public static String stringToUrl(String str) throws UnsupportedEncodingException {
        return URLEncoder.encode(str, "UTF-8");
    }

    public static String objectToJson(Object obj) {
        return f33124a.toJson(obj);
    }

    public static String mapToJson(Map<String, Object> map) {
        return f33124a.toJson((Object) map);
    }

    public static void removeNullData(Map map) {
        if (map != null) {
            for (Map.Entry entry : map.entrySet()) {
                String str = (String) entry.getKey();
                if (entry.getValue() == null) {
                    map.put(str, "");
                }
            }
        }
    }

    public static List<Map<String, Object>> stringToList(String str) {
        try {
            return (List) f33124a.fromJson(str, List.class);
        } catch (Exception unused) {
            return new ArrayList();
        }
    }

    public static Map<String, Object> jsonToMap(String str) {
        return (Map) f33124a.fromJson(str, Map.class);
    }

    public static String listToJson(List<Map<String, Object>> list) {
        return f33124a.toJson((Object) list);
    }
}
