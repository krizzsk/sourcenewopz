package com.didi.sdk.apm;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

class PreLoaders$2 implements Runnable {
    final /* synthetic */ Context val$context;

    PreLoaders$2(Context context) {
        this.val$context = context;
    }

    public void run() {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            AssetManager assets = this.val$context.getAssets();
            assets.getClass().getDeclaredMethod("isUpToDate", new Class[0]).invoke(assets, new Object[0]);
            Log.i("PreLoaders", "Assets preload time use " + (System.currentTimeMillis() - currentTimeMillis) + "ms");
        } catch (Throwable th) {
            C11888d.m24751b().error("AssetManager preload err: ", th);
        }
    }
}
