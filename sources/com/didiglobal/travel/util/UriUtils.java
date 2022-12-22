package com.didiglobal.travel.util;

import android.net.Uri;
import android.text.TextUtils;
import java.util.Map;
import java.util.Objects;

public class UriUtils {
    public static Uri appendParameter(String str, String str2, String str3) {
        Uri parse = Uri.parse((String) Objects.requireNonNull(str));
        return (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) ? parse : parse.buildUpon().appendQueryParameter(str2, str3).build();
    }

    public static Uri appendParameters(String str, Map<String, Object> map) {
        Uri parse = Uri.parse((String) Objects.requireNonNull(str));
        if (CollectionUtils.isEmpty((Map<?, ?>) map)) {
            return parse;
        }
        Uri.Builder buildUpon = parse.buildUpon();
        for (Map.Entry entry : ((Map) Objects.requireNonNull(map)).entrySet()) {
            String str2 = (String) entry.getKey();
            Object value = entry.getValue();
            if (!TextUtils.isEmpty(str2) && !Preconditions.isNull(value)) {
                if (!(value instanceof String) || !TextUtils.isEmpty((String) value)) {
                    buildUpon.appendQueryParameter(str2, value.toString());
                }
            }
        }
        return buildUpon.build();
    }
}
