package com.yanzhenjie.permission.source;

import android.content.Context;
import android.content.Intent;

public class WrapperSource extends Source {

    /* renamed from: a */
    private Source f56269a;

    public WrapperSource(Source source) {
        this.f56269a = source;
    }

    public Context getContext() {
        return this.f56269a.getContext();
    }

    public void startActivity(Intent intent) {
        this.f56269a.startActivity(intent);
    }

    public void startActivityForResult(Intent intent, int i) {
        this.f56269a.startActivityForResult(intent, i);
    }

    public boolean isShowRationalePermission(String str) {
        return this.f56269a.isShowRationalePermission(str);
    }
}
