package com.didi.sdk.util;

import android.content.Context;
import android.content.SharedPreferences;
import com.didi.sdk.apm.SystemUtils;

public class CacheSharedPreferences {

    /* renamed from: a */
    private static CacheSharedPreferences f37567a;

    /* renamed from: c */
    private static Context f37568c;

    /* renamed from: b */
    private String f37569b = "h5_native_cache";

    /* renamed from: d */
    private SharedPreferences f37570d;

    /* renamed from: e */
    private SharedPreferences.Editor f37571e;

    private CacheSharedPreferences() {
        SharedPreferences sharedPreferences = SystemUtils.getSharedPreferences(f37568c, "h5_native_cache", 0);
        this.f37570d = sharedPreferences;
        this.f37571e = sharedPreferences.edit();
    }

    public static synchronized CacheSharedPreferences getInstance() {
        CacheSharedPreferences cacheSharedPreferences;
        synchronized (CacheSharedPreferences.class) {
            if (f37567a == null) {
                f37567a = new CacheSharedPreferences();
            }
            cacheSharedPreferences = f37567a;
        }
        return cacheSharedPreferences;
    }

    public static void init(Context context) {
        f37568c = context;
    }

    public void setNativeCache(String str, String str2) {
        this.f37571e.putString(str, str2).apply();
    }

    public String getNativeCache(String str) {
        return this.f37570d.getString(str, "[]");
    }
}
