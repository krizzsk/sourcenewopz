package com.didi.sdk.app;

import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.appsflyer.internal.referrer.Payload;
import java.lang.reflect.Field;

public class ActivityLeakForHuaWei {
    /* renamed from: a */
    private static void m24777a(Context context) {
        InputMethodManager inputMethodManager;
        if (context != null) {
            try {
                inputMethodManager = (InputMethodManager) context.getSystemService("input_method");
            } catch (Throwable th) {
                th.printStackTrace();
                inputMethodManager = null;
            }
            if (inputMethodManager != null) {
                try {
                    Field declaredField = inputMethodManager.getClass().getDeclaredField("mLastSrvView");
                    if (declaredField != null) {
                        if (!declaredField.isAccessible()) {
                            declaredField.setAccessible(true);
                        }
                        Object obj = declaredField.get(inputMethodManager);
                        if (obj == null) {
                            return;
                        }
                        if (obj instanceof View) {
                            if (((View) obj).getContext() == context) {
                                declaredField.set(inputMethodManager, (Object) null);
                            }
                        }
                    }
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
        }
    }

    /* renamed from: b */
    private static void m24778b(Context context) {
        try {
            Class<?> cls = Class.forName("android.gestureboost.GestureBoostManager");
            Field declaredField = cls.getDeclaredField("sGestureBoostManager");
            declaredField.setAccessible(true);
            Field declaredField2 = cls.getDeclaredField("mContext");
            declaredField2.setAccessible(true);
            declaredField2.set(declaredField.get((Object) null), context.getApplicationContext());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void doWorkaroundIfNeed(Context context) {
        String lowerCase = Build.BRAND.toLowerCase();
        if (lowerCase.contains(Payload.SOURCE_HUAWEI) || lowerCase.contains("honor")) {
            m24778b(context);
            m24777a(context);
        }
    }
}
