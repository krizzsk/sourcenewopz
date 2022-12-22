package com.didi.sdk.splash;

import android.content.Context;
import android.content.SharedPreferences;
import com.didi.sdk.apm.SystemUtils;

/* renamed from: com.didi.sdk.splash.a */
/* compiled from: FirstStartCheckSp */
class C13140a {

    /* renamed from: a */
    private static final String f37529a = "first_start_check_sp";

    /* renamed from: b */
    private static final String f37530b = "is_first_start";

    /* renamed from: c */
    private final SharedPreferences f37531c;

    /* renamed from: d */
    private final SharedPreferences.Editor f37532d;

    C13140a(Context context) {
        SharedPreferences sharedPreferences = SystemUtils.getSharedPreferences(context, f37529a, 0);
        this.f37531c = sharedPreferences;
        this.f37532d = sharedPreferences.edit();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo96546a(boolean z) {
        this.f37532d.putBoolean(f37530b, z).apply();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo96547a() {
        return this.f37531c.getBoolean(f37530b, true);
    }
}
