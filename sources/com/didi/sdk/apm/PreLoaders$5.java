package com.didi.sdk.apm;

import android.content.Context;

class PreLoaders$5 implements Runnable {
    final /* synthetic */ String val$aSyncConfig;
    final /* synthetic */ Context val$context;

    PreLoaders$5(String str, Context context) {
        this.val$aSyncConfig = str;
        this.val$context = context;
    }

    public void run() {
        for (String sharedPreferences : this.val$aSyncConfig.split(";")) {
            SystemUtils.getSharedPreferences(this.val$context, sharedPreferences, 0);
        }
    }
}
