package com.yanzhenjie.permission.source;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

public class ActivitySource extends Source {

    /* renamed from: a */
    private Activity f56253a;

    public ActivitySource(Activity activity) {
        this.f56253a = activity;
    }

    public Context getContext() {
        return this.f56253a;
    }

    public void startActivity(Intent intent) {
        this.f56253a.startActivity(intent);
    }

    public void startActivityForResult(Intent intent, int i) {
        this.f56253a.startActivityForResult(intent, i);
    }

    public boolean isShowRationalePermission(String str) {
        if (Build.VERSION.SDK_INT < 23) {
            return false;
        }
        return this.f56253a.shouldShowRequestPermissionRationale(str);
    }
}
