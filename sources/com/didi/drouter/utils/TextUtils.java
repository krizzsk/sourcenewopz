package com.didi.drouter.utils;

import android.net.Uri;
import android.os.Bundle;
import androidx.collection.ArrayMap;
import com.didi.hawaii.mapsdkv2.HWMapConstant;
import java.util.Collections;
import java.util.Map;
import rui.config.RConfigConstants;

public class TextUtils {
    /* renamed from: a */
    private static String m14413a(String str) {
        return str == null ? "" : str;
    }

    public static boolean isEmpty(CharSequence charSequence) {
        return charSequence == null || charSequence.length() == 0;
    }

    public static Uri getUriKey(String str) {
        if (str == null) {
            return Uri.parse(HWMapConstant.HTTP.SEPARATOR);
        }
        return getUriKey(Uri.parse(str));
    }

    public static Uri getUriKey(Uri uri) {
        if (uri == null) {
            return Uri.parse(HWMapConstant.HTTP.SEPARATOR);
        }
        return Uri.parse(m14413a(uri.getScheme()).toLowerCase() + HWMapConstant.HTTP.SEPARATOR + m14413a(uri.getHost()).toLowerCase() + m14413a(uri.getPath()).toLowerCase());
    }

    public static boolean isRegex(String str) {
        return str != null && !str.matches("[\\w/]*");
    }

    public static String getPath(String str) {
        if (str == null) {
            return null;
        }
        int indexOf = str.indexOf("?");
        return indexOf != -1 ? str.substring(0, indexOf) : str;
    }

    public static Map<String, String> getQuery(Uri uri) {
        if (uri == null) {
            return Collections.emptyMap();
        }
        return getQuery(uri.toString());
    }

    public static Map<String, String> getQuery(String str) {
        String str2;
        if (str == null) {
            return Collections.emptyMap();
        }
        int indexOf = str.indexOf("?");
        if (indexOf != -1) {
            str = str.substring(indexOf + 1);
        }
        int indexOf2 = str.indexOf(RConfigConstants.KEYWORD_COLOR_SIGN);
        int i = 0;
        if (indexOf2 != -1) {
            str = str.substring(0, indexOf2);
        }
        ArrayMap arrayMap = new ArrayMap();
        do {
            int indexOf3 = str.indexOf(38, i);
            if (indexOf3 == -1) {
                indexOf3 = str.length();
            }
            int indexOf4 = str.indexOf(61, i);
            if (indexOf4 > indexOf3 || indexOf4 == -1) {
                indexOf4 = indexOf3;
            }
            String substring = str.substring(i, indexOf4);
            if (!android.text.TextUtils.isEmpty(substring)) {
                if (indexOf4 == indexOf3) {
                    str2 = "";
                } else {
                    str2 = str.substring(indexOf4 + 1, indexOf3);
                }
                arrayMap.put(substring, str2);
            }
            i = indexOf3 + 1;
        } while (i < str.length());
        return Collections.unmodifiableMap(arrayMap);
    }

    public static void appendExtra(Bundle bundle, Map<String, String> map) {
        for (Map.Entry next : map.entrySet()) {
            bundle.putString((String) next.getKey(), (String) next.getValue());
        }
    }
}
