package com.didiglobal.domainservice.utils;

import android.content.Context;
import android.content.SharedPreferences;
import com.didi.payment.wallet.global.prepaidcard.PrepaidConstant;
import com.didi.sdk.apm.SystemUtils;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

public class SharedPrefUtil {
    public static final String FILE_NAME = "share_data";

    public static boolean put(Context context, String str, Object obj) {
        if (obj == null || str == null || context == null) {
            return false;
        }
        SharedPreferences.Editor edit = SystemUtils.getSharedPreferences(context, "share_data", 0).edit();
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

    public static Object get(Context context, String str, Object obj) {
        if (context == null) {
            return null;
        }
        SharedPreferences sharedPreferences = SystemUtils.getSharedPreferences(context, "share_data", 0);
        if (obj instanceof String) {
            return sharedPreferences.getString(str, (String) obj);
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

    public static void remove(Context context, String str) {
        if (context != null) {
            SharedPreferences.Editor edit = SystemUtils.getSharedPreferences(context, "share_data", 0).edit();
            edit.remove(str);
            SharedPreferencesCompat.apply(edit);
        }
    }

    public static void clear(Context context) {
        if (context != null) {
            SharedPreferences.Editor edit = SystemUtils.getSharedPreferences(context, "share_data", 0).edit();
            edit.clear();
            SharedPreferencesCompat.apply(edit);
        }
    }

    public static boolean contains(Context context, String str) {
        if (context == null) {
            return false;
        }
        return SystemUtils.getSharedPreferences(context, "share_data", 0).contains(str);
    }

    public static Map<String, ?> getAll(Context context) {
        if (context == null) {
            return null;
        }
        return SystemUtils.getSharedPreferences(context, "share_data", 0).getAll();
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
