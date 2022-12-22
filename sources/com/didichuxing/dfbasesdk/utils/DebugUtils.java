package com.didichuxing.dfbasesdk.utils;

import android.text.TextUtils;
import com.didichuxing.dfbasesdk.AppContextHolder;
import com.didichuxing.security.safecollector.WsgSecInfo;
import java.lang.reflect.Field;

public class DebugUtils {

    /* renamed from: a */
    private static Boolean f46721a;

    /* renamed from: b */
    private static String f46722b;

    public static void setAppPackage(String str) {
        f46722b = str;
    }

    public static boolean isDebug() {
        String str;
        if (f46721a == null) {
            try {
                if (TextUtils.isEmpty(f46722b)) {
                    str = WsgSecInfo.packageName(AppContextHolder.getAppContext());
                } else {
                    str = f46722b;
                }
                Field field = Class.forName(str + ".BuildConfig").getField("DEBUG");
                field.setAccessible(true);
                f46721a = Boolean.valueOf(field.getBoolean((Object) null));
            } catch (Throwable unused) {
                f46721a = false;
            }
        }
        return f46721a.booleanValue();
    }
}
