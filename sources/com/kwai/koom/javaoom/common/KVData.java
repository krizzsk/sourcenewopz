package com.kwai.koom.javaoom.common;

import android.app.Application;
import android.content.SharedPreferences;
import com.didi.sdk.apm.SystemUtils;
import com.kwai.koom.javaoom.common.KConstants;

public class KVData {

    /* renamed from: a */
    private static boolean f55607a;

    /* renamed from: b */
    private static SharedPreferences f55608b;

    /* renamed from: c */
    private static SharedPreferences f55609c;

    public static void init() {
        Application application = KGlobalConfig.getApplication();
        f55608b = SystemUtils.getSharedPreferences(application, KConstants.C20314SP.TRIGGER_TIMES_NAME, 0);
        f55609c = SystemUtils.getSharedPreferences(application, KConstants.C20314SP.FIRST_LAUNCH_TIME_NAME, 0);
        f55607a = true;
    }

    public static void addTriggerTime(String str) {
        if (!f55607a) {
            init();
        }
        f55608b.edit().putInt(str, getTriggerTimes(str) + 1).apply();
    }

    public static int getTriggerTimes(String str) {
        if (!f55607a) {
            init();
        }
        return f55608b.getInt(str, 0);
    }

    public static long firstLaunchTime(String str) {
        if (!f55607a) {
            init();
        }
        long j = f55609c.getLong(str, 0);
        if (j != 0) {
            return j;
        }
        long currentTimeMillis = System.currentTimeMillis();
        f55609c.edit().putLong(str, currentTimeMillis).apply();
        return currentTimeMillis;
    }
}
