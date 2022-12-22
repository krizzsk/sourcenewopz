package com.android.didi.safetoolkit;

import android.app.ActivityManager;
import android.app.Application;
import android.os.Process;
import java.util.List;

public abstract class BaseApplication extends Application {
    /* access modifiers changed from: protected */
    public abstract void initAlways();

    /* access modifiers changed from: protected */
    public abstract void initOnMainProcess();

    /* access modifiers changed from: protected */
    @Deprecated
    public void initOnOtherProcess() {
    }

    /* access modifiers changed from: protected */
    public abstract void initOnOtherProcess(String str, int i);

    public final void onCreate() {
        super.onCreate();
        initAlways();
        if (isMainProcess()) {
            initOnMainProcess();
        } else {
            initOnOtherProcess(getCurrentProcessName(), Process.myPid());
        }
    }

    private boolean isMainProcess() {
        return getPackageName().equals(getCurrentProcessName());
    }

    /* access modifiers changed from: protected */
    public String getCurrentProcessName() {
        int myPid = Process.myPid();
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses == null || runningAppProcesses.isEmpty()) {
            return "";
        }
        for (ActivityManager.RunningAppProcessInfo next : runningAppProcesses) {
            if (next.pid == myPid) {
                return next.processName;
            }
        }
        return "";
    }
}
