package com.didi.map.google.util;

import android.text.TextUtils;
import android.util.Base64;
import org.json.JSONObject;

public class JsonParseHelper {
    public static Object parse(String str, String str2, boolean z) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (z) {
                str = new String(Base64.decode(str, 0), "UTF-8");
            }
            return new JSONObject(str).get(str2);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
