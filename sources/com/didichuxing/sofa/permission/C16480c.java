package com.didichuxing.sofa.permission;

import android.app.Activity;
import android.content.Intent;
import androidx.fragment.app.Fragment;

/* renamed from: com.didichuxing.sofa.permission.c */
/* compiled from: IPermissionHelper */
abstract class C16480c {
    /* access modifiers changed from: package-private */
    public abstract void onActivityResult(Activity activity, Object obj, int i, int i2, Intent intent);

    /* access modifiers changed from: package-private */
    public abstract void onActivityResult(Fragment fragment, Object obj, int i, int i2, Intent intent);

    /* access modifiers changed from: package-private */
    public abstract void onRequestPermissionsResult(Activity activity, Object obj, int i, String[] strArr, int[] iArr);

    /* access modifiers changed from: package-private */
    public abstract void onRequestPermissionsResult(Fragment fragment, Object obj, int i, String[] strArr, int[] iArr);

    /* access modifiers changed from: package-private */
    public abstract void requestPermission(Activity activity, Object obj, String[] strArr);

    /* access modifiers changed from: package-private */
    public abstract void requestPermission(Fragment fragment, Object obj, String[] strArr);

    C16480c() {
    }
}
