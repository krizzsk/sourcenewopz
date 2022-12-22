package com.didichuxing.sofa.permission;

import android.app.Activity;
import androidx.core.app.ActivityCompat;

/* renamed from: com.didichuxing.sofa.permission.a */
/* compiled from: ActivityPermissionRequest */
class C16478a extends PermissionRequest<Activity> {
    C16478a(Activity activity, String[] strArr, int i) {
        super(activity, strArr, i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo121148a(Activity activity, String[] strArr) {
        return C16482e.m35440a(activity, strArr);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo121147a(Activity activity, String[] strArr, int i) {
        if (C16483f.m35447a(strArr[0])) {
            C16483f.m35444a(activity, strArr[0], i);
        } else {
            ActivityCompat.requestPermissions(activity, strArr, i);
        }
    }
}
