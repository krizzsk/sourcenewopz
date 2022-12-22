package com.yanzhenjie.permission.source;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

public class FragmentSource extends Source {

    /* renamed from: a */
    private Fragment f56255a;

    public FragmentSource(Fragment fragment) {
        this.f56255a = fragment;
    }

    public Context getContext() {
        return this.f56255a.getActivity();
    }

    public void startActivity(Intent intent) {
        this.f56255a.startActivity(intent);
    }

    public void startActivityForResult(Intent intent, int i) {
        this.f56255a.startActivityForResult(intent, i);
    }

    public boolean isShowRationalePermission(String str) {
        if (Build.VERSION.SDK_INT < 23) {
            return false;
        }
        return this.f56255a.shouldShowRequestPermissionRationale(str);
    }
}
