package com.didi.sdk.util.config;

import android.content.SharedPreferences;
import com.didi.payment.wallet.global.prepaidcard.PrepaidConstant;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class SharedPreferencesCompat {

    /* renamed from: a */
    private static Method f37734a;

    static {
        try {
            f37734a = SharedPreferences.Editor.class.getMethod(PrepaidConstant.SCENE_APPLY, new Class[0]);
        } catch (NoSuchMethodException unused) {
            f37734a = null;
        }
    }

    public static void apply(SharedPreferences.Editor editor) {
        Method method = f37734a;
        if (method != null) {
            try {
                method.invoke(editor, new Object[0]);
                return;
            } catch (IllegalAccessException | InvocationTargetException unused) {
            }
        }
        editor.commit();
    }
}
