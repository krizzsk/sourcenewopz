package com.didi.beatles.p099im.access.recorder;

/* renamed from: com.didi.beatles.im.access.recorder.IMOpenRecorderCallback */
public abstract class IMOpenRecorderCallback {
    public static final int ERROR_DURATION_TOO_SHORT = 1;
    public static final int ERROR_NO_PERMISSION = 2;
    public static final int ERROR_OTHER = -1;
    public static final int ERROR_SYSTEM_ERROR = 3;

    public void onRecorderError(int i) {
    }

    public void onRecorderFinish(String str, int i) {
    }

    public void onRecorderStart() {
    }
}
