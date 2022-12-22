package com.didiglobal.privacysdk.law.prepose;

import android.content.Context;
import android.content.SharedPreferences;
import com.didi.payment.wallet.global.prepaidcard.PrepaidConstant;
import com.didi.sdk.apm.SystemUtils;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

class LawPreposeSPUtils {

    /* renamed from: a */
    public static final String f50663a = "law_share_data";

    LawPreposeSPUtils() {
    }

    /* renamed from: a */
    public static boolean m36376a(Context context, String str, Object obj) {
        if (obj == null || str == null) {
            return false;
        }
        SharedPreferences.Editor edit = SystemUtils.getSharedPreferences(context, f50663a, 0).edit();
        if (obj instanceof String) {
            edit.putString(str, (String) obj);
        } else if (obj instanceof Integer) {
            edit.putInt(str, ((Integer) obj).intValue());
        } else if (obj instanceof Boolean) {
            edit.putBoolean(str, ((Boolean) obj).booleanValue());
        } else if (obj instanceof Float) {
            edit.putFloat(str, ((Float) obj).floatValue());
        } else if (obj instanceof Long) {
            edit.putLong(str, ((Long) obj).longValue());
        } else {
            edit.putString(str, obj.toString());
        }
        SharedPreferencesCompat.apply(edit);
        return true;
    }

    /* renamed from: b */
    public static Object m36377b(Context context, String str, Object obj) {
        SharedPreferences sharedPreferences = SystemUtils.getSharedPreferences(context, f50663a, 0);
        if (obj instanceof String) {
            return sharedPreferences.getString(str, (String) null);
        }
        if (obj instanceof Integer) {
            return Integer.valueOf(sharedPreferences.getInt(str, ((Integer) obj).intValue()));
        }
        if (obj instanceof Boolean) {
            return Boolean.valueOf(sharedPreferences.getBoolean(str, ((Boolean) obj).booleanValue()));
        }
        if (obj instanceof Float) {
            return Float.valueOf(sharedPreferences.getFloat(str, ((Float) obj).floatValue()));
        }
        if (obj instanceof Long) {
            return Long.valueOf(sharedPreferences.getLong(str, ((Long) obj).longValue()));
        }
        return null;
    }

    /* renamed from: a */
    public static void m36375a(Context context, String str) {
        SharedPreferences.Editor edit = SystemUtils.getSharedPreferences(context, f50663a, 0).edit();
        edit.remove(str);
        SharedPreferencesCompat.apply(edit);
    }

    /* renamed from: a */
    public static void m36374a(Context context) {
        SharedPreferences.Editor edit = SystemUtils.getSharedPreferences(context, f50663a, 0).edit();
        edit.clear();
        SharedPreferencesCompat.apply(edit);
    }

    /* renamed from: b */
    public static boolean m36379b(Context context, String str) {
        return SystemUtils.getSharedPreferences(context, f50663a, 0).contains(str);
    }

    /* renamed from: b */
    public static Map<String, ?> m36378b(Context context) {
        return SystemUtils.getSharedPreferences(context, f50663a, 0).getAll();
    }

    private static class SharedPreferencesCompat {
        private static final Method sApplyMethod = findApplyMethod();

        private SharedPreferencesCompat() {
        }

        private static Method findApplyMethod() {
            try {
                return SharedPreferences.Editor.class.getMethod(PrepaidConstant.SCENE_APPLY, new Class[0]);
            } catch (NoSuchMethodException unused) {
                return null;
            }
        }

        public static void apply(SharedPreferences.Editor editor) {
            try {
                if (sApplyMethod != null) {
                    sApplyMethod.invoke(editor, new Object[0]);
                    return;
                }
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException unused) {
            }
            editor.apply();
        }
    }
}
