package com.didi.map.sdk.navtracker;

import android.content.Context;
import android.content.SharedPreferences;
import com.didi.sdk.apm.SystemUtils;

public class TrackerPreference {

    /* renamed from: a */
    private static SharedPreferences f28559a = null;

    /* renamed from: b */
    private static final String f28560b = "MapTrackerPreference";

    /* renamed from: c */
    private static final String f28561c = "key_track_list_map";

    /* renamed from: d */
    private static final String f28562d = "key_track_list_nav";

    /* renamed from: e */
    private static final String f28563e = "key_track_user_info_country_code";

    /* renamed from: f */
    private static final String f28564f = "key_track_user_info_phone_num";

    /* renamed from: g */
    private static final String f28565g = "key_track_user_info_app_version";

    /* renamed from: h */
    private static final String f28566h = "key_track_user_info_user_id";

    public static String getMapTrackList(Context context) {
        if (f28559a == null) {
            f28559a = SystemUtils.getSharedPreferences(context, f28560b, 0);
        }
        SharedPreferences sharedPreferences = f28559a;
        if (sharedPreferences != null) {
            return sharedPreferences.getString(f28561c, "");
        }
        return "";
    }

    public static void setMapTrackList(String str, Context context) {
        if (f28559a == null) {
            f28559a = SystemUtils.getSharedPreferences(context, f28560b, 0);
        }
        SharedPreferences sharedPreferences = f28559a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString(f28561c, str).apply();
        }
    }

    public static String getNavTrackList(Context context) {
        if (f28559a == null) {
            f28559a = SystemUtils.getSharedPreferences(context, f28560b, 0);
        }
        SharedPreferences sharedPreferences = f28559a;
        if (sharedPreferences != null) {
            return sharedPreferences.getString(f28562d, "");
        }
        return "";
    }

    public static void setNavTrackList(String str, Context context) {
        if (f28559a == null) {
            f28559a = SystemUtils.getSharedPreferences(context, f28560b, 0);
        }
        SharedPreferences sharedPreferences = f28559a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString(f28562d, str).apply();
        }
    }

    public static String getCountryCode(Context context) {
        if (f28559a == null) {
            f28559a = SystemUtils.getSharedPreferences(context, f28560b, 0);
        }
        SharedPreferences sharedPreferences = f28559a;
        if (sharedPreferences != null) {
            return sharedPreferences.getString(f28563e, "");
        }
        return "";
    }

    public static void setCountryCode(String str, Context context) {
        if (f28559a == null) {
            f28559a = SystemUtils.getSharedPreferences(context, f28560b, 0);
        }
        SharedPreferences sharedPreferences = f28559a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString(f28563e, str).apply();
        }
    }

    public static String getPhoneNum(Context context) {
        if (f28559a == null) {
            f28559a = SystemUtils.getSharedPreferences(context, f28560b, 0);
        }
        SharedPreferences sharedPreferences = f28559a;
        if (sharedPreferences != null) {
            return sharedPreferences.getString(f28564f, "");
        }
        return "";
    }

    public static void setPhoneNum(String str, Context context) {
        if (f28559a == null) {
            f28559a = SystemUtils.getSharedPreferences(context, f28560b, 0);
        }
        SharedPreferences sharedPreferences = f28559a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString(f28564f, str).apply();
        }
    }

    public static String getAppVersion(Context context) {
        if (f28559a == null) {
            f28559a = SystemUtils.getSharedPreferences(context, f28560b, 0);
        }
        SharedPreferences sharedPreferences = f28559a;
        if (sharedPreferences != null) {
            return sharedPreferences.getString(f28565g, "");
        }
        return "";
    }

    public static void setAppVersion(String str, Context context) {
        if (f28559a == null) {
            f28559a = SystemUtils.getSharedPreferences(context, f28560b, 0);
        }
        SharedPreferences sharedPreferences = f28559a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString(f28565g, str).apply();
        }
    }

    public static String getUserId(Context context) {
        if (f28559a == null) {
            f28559a = SystemUtils.getSharedPreferences(context, f28560b, 0);
        }
        SharedPreferences sharedPreferences = f28559a;
        if (sharedPreferences != null) {
            return sharedPreferences.getString(f28566h, "");
        }
        return "";
    }

    public static void setUserId(String str, Context context) {
        if (f28559a == null) {
            f28559a = SystemUtils.getSharedPreferences(context, f28560b, 0);
        }
        SharedPreferences sharedPreferences = f28559a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString(f28566h, str).apply();
        }
    }
}
