package com.didi.remotereslibrary.utils;

import android.net.Uri;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

public class H5GenUtil {
    public static String link(String str, HashMap<String, Object> hashMap) {
        if (hashMap == null || TextUtils.isEmpty(str)) {
            return str;
        }
        Uri.Builder buildUpon = Uri.parse(str).buildUpon();
        for (Map.Entry next : hashMap.entrySet()) {
            buildUpon.appendQueryParameter((String) next.getKey(), next.getValue() == null ? "" : next.getValue().toString());
        }
        return buildUpon.toString();
    }
}
