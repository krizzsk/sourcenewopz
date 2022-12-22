package com.didi.dimina.container.secondparty.permission.source;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

public class ActivitySource extends Source {

    /* renamed from: a */
    private final Activity f17413a;

    public ActivitySource(Activity activity) {
        this.f17413a = activity;
    }

    public Context getContext() {
        return this.f17413a;
    }

    public void startActivity(Intent intent) {
        Activity activity = this.f17413a;
        if (activity != null && !activity.isFinishing()) {
            this.f17413a.startActivity(intent);
        }
    }

    public void startActivityForResult(Intent intent, int i) {
        Activity activity = this.f17413a;
        if (activity != null && !activity.isFinishing()) {
            this.f17413a.startActivityForResult(intent, i);
        }
    }

    public boolean isShowRationalePermission(String str) {
        Activity activity;
        if (Build.VERSION.SDK_INT >= 23 && (activity = this.f17413a) != null && !activity.isFinishing()) {
            return this.f17413a.shouldShowRequestPermissionRationale(str);
        }
        return false;
    }
}
