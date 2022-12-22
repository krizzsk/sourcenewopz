package com.didichuxing.sofa.permission;

import android.app.Activity;
import androidx.fragment.app.Fragment;

/* renamed from: com.didichuxing.sofa.permission.b */
/* compiled from: FragmentPermissionRequest */
class C16479b extends PermissionRequest<Fragment> {
    C16479b(Fragment fragment, String[] strArr, int i) {
        super(fragment, strArr, i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo121148a(Fragment fragment, String[] strArr) {
        return C16482e.m35440a((Activity) fragment.getActivity(), strArr);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo121147a(Fragment fragment, String[] strArr, int i) {
        if (C16483f.m35447a(strArr[0])) {
            C16483f.m35445a(fragment, strArr[0], i);
        } else {
            fragment.requestPermissions(strArr, i);
        }
    }
}
