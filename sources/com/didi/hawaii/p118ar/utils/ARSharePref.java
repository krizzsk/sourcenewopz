package com.didi.hawaii.p118ar.utils;

import android.content.Context;
import android.content.SharedPreferences;
import com.didi.sdk.apm.SystemUtils;

/* renamed from: com.didi.hawaii.ar.utils.ARSharePref */
public class ARSharePref {
    public static final int GUIDESHOWMOSTTIMES = 3;
    public static final String SHAREPRF_KEY = "com_didi_ar_key";

    /* renamed from: a */
    private static final String f23298a = "com.didi.ar.sharedpreference";

    /* renamed from: b */
    private static Context f23299b = null;

    /* renamed from: c */
    private static final String f23300c = "com_didi_ar_zg_launch_key";

    public static void init(Context context) {
        f23299b = context;
    }

    public static SharedPreferences getSharePreference() {
        Context context = f23299b;
        if (context != null) {
            return SystemUtils.getSharedPreferences(context, f23298a, 0);
        }
        return null;
    }

    public static boolean isARZGFirstLaunch() {
        Object hwShareParam = getHwShareParam(f23300c, false);
        if (hwShareParam == null || hwShareParam.getClass() != Boolean.class) {
            return false;
        }
        return ((Boolean) hwShareParam).booleanValue();
    }

    public static void setARZGLaunched() {
        setHwShareParam(f23300c, true);
    }

    public static int getGuideShowTimes() {
        return ((Integer) getHwShareParam(SHAREPRF_KEY, 0)).intValue();
    }

    public static void guideShowTimesIncrement() {
        setHwShareParam(SHAREPRF_KEY, Integer.valueOf(((Integer) getHwShareParam(SHAREPRF_KEY, 0)).intValue() + 1));
    }

    public static void setHwShareParam(String str, Object obj) {
        SharedPreferences sharePreference = getSharePreference();
        if (sharePreference != null) {
            SharedPreferences.Editor edit = sharePreference.edit();
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
            }
            edit.apply();
        }
    }

    public static Object getHwShareParam(String str, Object obj) {
        SharedPreferences sharePreference = getSharePreference();
        if (sharePreference == null) {
            return null;
        }
        if (obj instanceof String) {
            return sharePreference.getString(str, (String) obj);
        }
        if (obj instanceof Integer) {
            return Integer.valueOf(sharePreference.getInt(str, ((Integer) obj).intValue()));
        }
        if (obj instanceof Boolean) {
            return Boolean.valueOf(sharePreference.getBoolean(str, ((Boolean) obj).booleanValue()));
        }
        if (obj instanceof Float) {
            return Float.valueOf(sharePreference.getFloat(str, ((Float) obj).floatValue()));
        }
        if (obj instanceof Long) {
            return Long.valueOf(sharePreference.getLong(str, ((Long) obj).longValue()));
        }
        return null;
    }
}
