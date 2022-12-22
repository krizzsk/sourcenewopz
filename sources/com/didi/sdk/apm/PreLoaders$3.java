package com.didi.sdk.apm;

import android.os.Environment;
import android.util.Log;

class PreLoaders$3 implements Runnable {
    PreLoaders$3() {
    }

    public void run() {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            boolean isExternalStorageEmulated = Environment.isExternalStorageEmulated();
            Log.d("PreLoaders", "preloadStorage is emulated: " + isExternalStorageEmulated);
            String externalStorageState = Environment.getExternalStorageState();
            Log.d("PreLoaders", "preloadStorage get state: " + externalStorageState);
            Log.i("PreLoaders", "Storage preload time use " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
        } catch (Throwable th) {
            C11888d.m24751b().error("Storage preload err: ", th);
        }
    }
}
