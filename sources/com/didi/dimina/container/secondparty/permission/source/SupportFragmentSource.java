package com.didi.dimina.container.secondparty.permission.source;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.fragment.app.Fragment;

public class SupportFragmentSource extends Source {

    /* renamed from: a */
    private final Fragment f17428a;

    public SupportFragmentSource(Fragment fragment) {
        this.f17428a = fragment;
    }

    public Context getContext() {
        return this.f17428a.getContext();
    }

    public void startActivity(Intent intent) {
        this.f17428a.startActivity(intent);
    }

    public void startActivityForResult(Intent intent, int i) {
        this.f17428a.startActivityForResult(intent, i);
    }

    public boolean isShowRationalePermission(String str) {
        if (Build.VERSION.SDK_INT < 23) {
            return false;
        }
        return this.f17428a.shouldShowRequestPermissionRationale(str);
    }
}
