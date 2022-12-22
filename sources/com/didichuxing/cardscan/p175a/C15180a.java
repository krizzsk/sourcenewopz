package com.didichuxing.cardscan.p175a;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.content.res.TypedArray;
import android.os.Build;
import com.didi.sdk.apm.SystemUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* renamed from: com.didichuxing.cardscan.a.a */
public class C15180a {
    /* renamed from: a */
    public static void m33162a(Activity activity) {
        if (Build.VERSION.SDK_INT == 26 && m33163b(activity)) {
            boolean c = m33164c(activity);
            SystemUtils.log(3, "", "onCreate fixOrientation when Oreo, result = " + c, (Throwable) null, "com.didichuxing.cardscan.a.a", -1);
        }
    }

    /* renamed from: b */
    private static boolean m33163b(Activity activity) {
        boolean z;
        Exception e;
        try {
            TypedArray obtainStyledAttributes = activity.obtainStyledAttributes((int[]) Class.forName("com.android.internal.R$styleable").getField("Window").get((Object) null));
            Method method = ActivityInfo.class.getMethod("isTranslucentOrFloating", new Class[]{TypedArray.class});
            method.setAccessible(true);
            z = ((Boolean) method.invoke((Object) null, new Object[]{obtainStyledAttributes})).booleanValue();
            try {
                method.setAccessible(false);
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Exception e3) {
            e = e3;
            z = false;
            e.printStackTrace();
            return z;
        }
        return z;
    }

    /* renamed from: c */
    private static boolean m33164c(Activity activity) {
        try {
            Field declaredField = Activity.class.getDeclaredField("mActivityInfo");
            declaredField.setAccessible(true);
            ((ActivityInfo) declaredField.get(activity)).screenOrientation = -1;
            declaredField.setAccessible(false);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
