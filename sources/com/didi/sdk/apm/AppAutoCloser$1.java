package com.didi.sdk.apm;

import com.didi.sdk.apm.AppStateMonitor;

class AppAutoCloser$1 implements AppStateMonitor.StateListener {
    final /* synthetic */ C11877a this$0;

    AppAutoCloser$1(C11877a aVar) {
        this.this$0 = aVar;
    }

    public void onInForeground() {
        this.this$0.m24720d();
    }

    public void onInBackground() {
        this.this$0.m24719c();
    }
}
