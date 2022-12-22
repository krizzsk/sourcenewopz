package com.didi.sdk.appupdate;

import android.content.Context;
import android.content.SharedPreferences;
import com.didi.sdk.apm.SystemUtils;

public class AppUpdateSharedPreferences {

    /* renamed from: a */
    private static final String f35256a = "app_update_sp";

    /* renamed from: b */
    private static final String f35257b = "app_update_sp_last_time";

    /* renamed from: c */
    private final Context f35258c;

    /* renamed from: d */
    private final SharedPreferences f35259d;

    /* renamed from: e */
    private final SharedPreferences.Editor f35260e;

    public AppUpdateSharedPreferences(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.f35258c = applicationContext;
        SharedPreferences sharedPreferences = SystemUtils.getSharedPreferences(applicationContext, f35256a, 0);
        this.f35259d = sharedPreferences;
        this.f35260e = sharedPreferences.edit();
    }

    public void setAppUpdateLastTime(long j) {
        this.f35260e.putLong(f35257b, j).commit();
    }

    public long getAppUpdateLastTime() {
        return this.f35259d.getLong(f35257b, 0);
    }
}
