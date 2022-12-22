package com.didiglobal.xbanner.cache;

import android.content.Context;
import android.content.SharedPreferences;
import com.didi.sdk.apm.SystemUtils;

public class XBannerCache {

    /* renamed from: a */
    private static final String f51470a = "XBannerCache";

    /* renamed from: b */
    private static volatile XBannerCache f51471b = null;

    /* renamed from: c */
    private static final String f51472c = "X_BANNER_SHARED_PRES";

    /* renamed from: d */
    private SharedPreferences f51473d;

    private XBannerCache(Context context) {
        this.f51473d = SystemUtils.getSharedPreferences(context, f51472c, 0);
    }

    public static XBannerCache getInstance(Context context) {
        if (f51471b == null) {
            synchronized (XBannerCache.class) {
                if (f51471b == null) {
                    f51471b = new XBannerCache(context);
                }
            }
        }
        return f51471b;
    }

    public void setExpandNowCount(String str, int i) {
        int i2 = this.f51473d.getInt(str, 0);
        SystemUtils.log(6, f51470a, "displayCount:" + i + "count:" + i2, (Throwable) null, "com.didiglobal.xbanner.cache.XBannerCache", 33);
        int i3 = i == -1 ? i : i2 + 1;
        if (i3 <= i + 1) {
            this.f51473d.edit().putInt(str, i3).apply();
        }
    }

    public boolean isExpandNeedShow(String str, int i) {
        int i2 = this.f51473d.getInt(str, 0);
        SystemUtils.log(6, f51470a, "displayCount:" + i + "tempCount:" + i2, (Throwable) null, "com.didiglobal.xbanner.cache.XBannerCache", 42);
        if (i2 < 0 || i < 0) {
            return true;
        }
        if (i != 0 && i2 < i) {
            return true;
        }
        return false;
    }
}
