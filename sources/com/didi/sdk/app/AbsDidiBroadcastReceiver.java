package com.didi.sdk.app;

import android.content.Intent;
import com.didi.sdk.app.BaseBusinessContext;

public abstract class AbsDidiBroadcastReceiver<T extends BaseBusinessContext> {
    /* access modifiers changed from: protected */
    public abstract void onReceive(T t, Intent intent);
}
