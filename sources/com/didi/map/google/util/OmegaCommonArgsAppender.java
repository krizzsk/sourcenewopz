package com.didi.map.google.util;

import android.text.TextUtils;
import com.didi.map.google.model.OmegaTraceEvent;
import java.util.Map;

public class OmegaCommonArgsAppender {
    /* renamed from: a */
    private static int m19915a(int i, boolean z) {
        if (i == 3) {
            return z ? 1 : 0;
        }
        return 2;
    }

    public static void append(Map<String, Object> map, int i, String str, String str2, String str3) {
        if (map != null) {
            map.put("timestamp", Long.valueOf(System.currentTimeMillis()));
            map.put("page", str2);
            if (i >= 0) {
                map.put("product_id", String.valueOf(i));
            }
            if (!TextUtils.isEmpty(str)) {
                map.put("user_type", str);
            }
            if (!TextUtils.isEmpty(str3)) {
                map.put("entrance", str3);
            }
        }
    }

    public static void append(Map<String, Object> map, String str, String str2, int i, boolean z, int i2, String str3, String str4, String str5) {
        if (map != null) {
            map.put("uid", str);
            map.put("order_id", str2);
            map.put("timestamp", Long.valueOf(System.currentTimeMillis()));
            map.put(OmegaTraceEvent.CommentParamNames.TRIP_STEP, Integer.valueOf(m19915a(i, z)));
            map.put("page", str4);
            if (i2 >= 0) {
                map.put("product_id", String.valueOf(i2));
            }
            if (!TextUtils.isEmpty(str3)) {
                map.put("user_type", str3);
            }
            if (!TextUtils.isEmpty(str5)) {
                map.put("entrance", str5);
            }
        }
    }
}
