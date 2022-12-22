package com.didi.sdk.apm;

import android.os.AsyncTask;
import android.text.TextUtils;
import com.didi.sdk.apm.utils.RemoteConfiguration;
import com.didi.sdk.logging.Logger;

class PreLoaders$4 implements Runnable {
    PreLoaders$4() {
    }

    public void run() {
        try {
            String str = (String) RemoteConfiguration.getConfig("global_app_preload_so", "so_list", "");
            C11888d.m24751b().info("start preload so config=" + str, new Object[0]);
            String trim = str.trim();
            if (!TextUtils.isEmpty(trim)) {
                for (String trim2 : trim.replace(";", ",").split(",")) {
                    final String trim3 = trim2.trim();
                    if (!TextUtils.isEmpty(trim3)) {
                        if (trim3.startsWith("lib")) {
                            if (trim3.endsWith(".so")) {
                                final String substring = trim3.substring(3, trim3.length() - 3);
                                AsyncTask.THREAD_POOL_EXECUTOR.execute(new Runnable() {
                                    public void run() {
                                        try {
                                            long currentTimeMillis = System.currentTimeMillis();
                                            System.loadLibrary(substring);
                                            Logger a = C11888d.m24751b();
                                            a.info(trim3 + " preload time use " + (System.currentTimeMillis() - currentTimeMillis) + " ms", new Object[0]);
                                        } catch (Throwable th) {
                                            Logger a2 = C11888d.m24751b();
                                            a2.error("loadLibrary for " + trim3 + " err: ", th);
                                        }
                                    }
                                });
                            }
                        }
                    }
                }
            }
        } catch (Throwable th) {
            C11888d.m24751b().error("So preload err: ", th);
        }
    }
}
