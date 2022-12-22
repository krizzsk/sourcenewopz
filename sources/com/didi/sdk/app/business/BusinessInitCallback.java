package com.didi.sdk.app.business;

import android.content.Context;

public abstract class BusinessInitCallback {
    public void onSwitchToBusiness(Context context, String str) {
    }

    public abstract void onSyncInit(Context context);
}
