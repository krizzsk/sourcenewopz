package com.didi.dimina.container.secondparty.permission.source;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

public class FragmentSource extends Source {

    /* renamed from: a */
    private final Fragment f17415a;

    public FragmentSource(Fragment fragment) {
        this.f17415a = fragment;
    }

    public Context getContext() {
        return this.f17415a.getActivity();
    }

    public void startActivity(Intent intent) {
        this.f17415a.startActivity(intent);
    }

    public void startActivityForResult(Intent intent, int i) {
        this.f17415a.startActivityForResult(intent, i);
    }

    public boolean isShowRationalePermission(String str) {
        if (Build.VERSION.SDK_INT < 23) {
            return false;
        }
        return this.f17415a.shouldShowRequestPermissionRationale(str);
    }
}
