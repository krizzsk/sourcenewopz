package com.didi.global.ninja.utils;

import android.content.Context;
import android.content.pm.PackageManager;
import com.didi.sdk.apm.SystemUtils;

public class SharedPreferencesUtils {

    /* renamed from: a */
    private static final String f22884a = "#";

    /* renamed from: b */
    private static final String f22885b = "ninja-sp";

    /* renamed from: e */
    private static volatile SharedPreferencesUtils f22886e;

    /* renamed from: c */
    private Context f22887c;

    /* renamed from: d */
    private String f22888d = "";

    private SharedPreferencesUtils(Context context) {
        this.f22887c = context.getApplicationContext();
        try {
            this.f22888d = SystemUtils.getPackageInfo(context.getPackageManager(), context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static SharedPreferencesUtils getInstance(Context context) {
        if (f22886e == null) {
            synchronized (SharedPreferencesUtils.class) {
                if (f22886e == null) {
                    f22886e = new SharedPreferencesUtils(context);
                }
            }
        }
        return f22886e;
    }

    public void writeSPInt(String str, int i) {
        SystemUtils.getSharedPreferences(this.f22887c, m16455a(), 0).edit().putInt(str, i).commit();
    }

    public int readSPInt(String str, int i) {
        return SystemUtils.getSharedPreferences(this.f22887c, m16455a(), 0).getInt(str, i);
    }

    public void writeSPLong(String str, long j) {
        SystemUtils.getSharedPreferences(this.f22887c, m16455a(), 0).edit().putLong(str, j).commit();
    }

    public long readSPLong(String str, long j) {
        return SystemUtils.getSharedPreferences(this.f22887c, m16455a(), 0).getLong(str, j);
    }

    /* renamed from: a */
    private String m16455a() {
        return "ninja-sp#" + this.f22888d;
    }
}
