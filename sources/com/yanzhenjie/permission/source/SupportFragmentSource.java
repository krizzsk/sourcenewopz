package com.yanzhenjie.permission.source;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.fragment.app.Fragment;

public class SupportFragmentSource extends Source {

    /* renamed from: a */
    private Fragment f56268a;

    public SupportFragmentSource(Fragment fragment) {
        this.f56268a = fragment;
    }

    public Context getContext() {
        return this.f56268a.getContext();
    }

    public void startActivity(Intent intent) {
        this.f56268a.startActivity(intent);
    }

    public void startActivityForResult(Intent intent, int i) {
        this.f56268a.startActivityForResult(intent, i);
    }

    public boolean isShowRationalePermission(String str) {
        if (Build.VERSION.SDK_INT < 23) {
            return false;
        }
        return this.f56268a.shouldShowRequestPermissionRationale(str);
    }
}
