package com.didi.sdk.util.tips;

import android.content.Context;
import android.content.SharedPreferences;
import com.didi.sdk.apm.SystemUtils;

public class StoreUtils {

    /* renamed from: a */
    private Context f37742a;

    public StoreUtils(Context context) {
        this.f37742a = context;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo97123a(int i) {
        SharedPreferences sharedPreferences = SystemUtils.getSharedPreferences(this.f37742a, "showtips", 0);
        return sharedPreferences.getBoolean("id" + i, false);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo97124b(int i) {
        SharedPreferences.Editor edit = SystemUtils.getSharedPreferences(this.f37742a, "showtips", 0).edit();
        edit.putBoolean("id" + i, true).apply();
    }
}
