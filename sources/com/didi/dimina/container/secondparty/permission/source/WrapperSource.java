package com.didi.dimina.container.secondparty.permission.source;

import android.content.Context;
import android.content.Intent;

public class WrapperSource extends Source {

    /* renamed from: a */
    private final Source f17429a;

    public WrapperSource(Source source) {
        this.f17429a = source;
    }

    public Context getContext() {
        return this.f17429a.getContext();
    }

    public void startActivity(Intent intent) {
        this.f17429a.startActivity(intent);
    }

    public void startActivityForResult(Intent intent, int i) {
        this.f17429a.startActivityForResult(intent, i);
    }

    public boolean isShowRationalePermission(String str) {
        return this.f17429a.isShowRationalePermission(str);
    }
}
