package com.didi.one.netdetect.util;

import android.content.Context;
import android.content.SharedPreferences;
import com.didi.sdk.apm.SystemUtils;

public class PrefUtil {
    public static final String KEY_PING_OUTPUT_TIME = "ping_output_time";
    public static final String KEY_TRACE_ROUTE_TIME = "trace_route_time";
    public static final String SHARED_PREFS_NAME = "net_detect";

    /* renamed from: a */
    private static SharedPreferences f29487a = null;

    /* renamed from: b */
    private static SharedPreferences.Editor f29488b = null;

    /* renamed from: c */
    private static boolean f29489c = false;

    /* renamed from: a */
    private static void m20766a(Context context) {
        if (!f29489c) {
            SharedPreferences sharedPreferences = SystemUtils.getSharedPreferences(context.getApplicationContext(), SHARED_PREFS_NAME, 0);
            f29487a = sharedPreferences;
            f29488b = sharedPreferences.edit();
            f29489c = true;
        }
    }

    public static void setTraceRouteTime(Context context, long j) {
        m20766a(context);
        f29488b.putLong(KEY_TRACE_ROUTE_TIME, j).commit();
    }

    public static long getTraceRouteTime(Context context) {
        m20766a(context);
        return f29487a.getLong(KEY_TRACE_ROUTE_TIME, 0);
    }

    public static void setPingOutputTime(Context context, long j) {
        m20766a(context);
        f29488b.putLong(KEY_PING_OUTPUT_TIME, j).commit();
    }

    public static long getPingOutputTime(Context context) {
        m20766a(context);
        return f29487a.getLong(KEY_PING_OUTPUT_TIME, 0);
    }
}
