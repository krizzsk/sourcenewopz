package com.didi.hawaii.basic;

import android.content.Context;
import android.content.SharedPreferences;
import com.didi.sdk.apm.SystemUtils;

public class HWSharedPreference {
    private static final String HAWAII_SHARED = "com.didi.hawaii.sharedpreference";

    public static class LOG {
        public static final String KEY_SHARED_LOG_PATH = "logger.path";
        public static final String KEY_SHARED_PACKAGENAME = "logger.packagename";
        public static final String KEY_SHARED_PHONE_NUMBER = "logger.phonenumber";

        private LOG() {
        }
    }

    public static SharedPreferences getSharePreference() {
        Context context = HWContextProvider.getContext();
        if (context != null) {
            return SystemUtils.getSharedPreferences(context, HAWAII_SHARED, 0);
        }
        return null;
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
