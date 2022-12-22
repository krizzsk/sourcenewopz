package com.didi.sofa.utils;

import android.text.TextUtils;

public class CommonUtils {
    public static boolean equals(String str, String str2) {
        return (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) || equals((Object) str, (Object) str2);
    }

    public static boolean equals(Object obj, Object obj2) {
        return (obj == null && obj2 == null) || (obj != null && obj.equals(obj2));
    }
}
