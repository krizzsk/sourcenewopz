package com.didi.trackupload.sdk.core;

import com.didi.trackupload.sdk.utils.TrackLog;

public class CrashRecoveryController {

    /* renamed from: a */
    private static final String f37004a = "TrackCrashRecovery";

    private CrashRecoveryController() {
    }

    private static class SingletonHolder {
        static CrashRecoveryController INSTANCE = new CrashRecoveryController();

        private SingletonHolder() {
        }
    }

    public static CrashRecoveryController getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public void init() {
        TrackLog.m31343d(f37004a, "run UploadCacheTask");
        CoreThread.post(new UploadCacheTask());
    }
}
