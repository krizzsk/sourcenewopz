package com.google.android.play.core.splitinstall;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.didi.sdk.apm.SystemUtils;
import java.io.File;

/* renamed from: com.google.android.play.core.splitinstall.y */
public final class C18609y {

    /* renamed from: a */
    private final Context f53410a;

    C18609y(Context context) {
        this.f53410a = context;
    }

    /* renamed from: a */
    static File m38215a(Context context) {
        String string;
        try {
            Bundle bundle = SystemUtils.getApplicationInfo(context.getPackageManager(), context.getPackageName(), 128).metaData;
            if (bundle == null || (string = bundle.getString("local_testing_dir")) == null) {
                return null;
            }
            return new File(context.getExternalFilesDir((String) null), string);
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final C18593t mo149316a() {
        return C18593t.m38179a(this.f53410a);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final Context mo149317b() {
        return this.f53410a;
    }
}
