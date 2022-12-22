package com.didi.sdk.app.delegate;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Process;
import android.text.TextUtils;
import java.util.List;

public abstract class ApplicationDelegate {
    /* access modifiers changed from: protected */
    public Application mDIDIBaseApplication;

    public void onConfigurationChanged(Configuration configuration, Application application) {
    }

    public void onLoadForground(Application application) {
    }

    public void onLowMemory(Application application) {
    }

    public void onTrimMemory(Application application, int i) {
    }

    public void attachBaseContext(Application application) {
        this.mDIDIBaseApplication = application;
    }

    public void onCreate(Application application) {
        this.mDIDIBaseApplication = application;
    }

    public boolean isMainProcess(Context context) {
        return isMainProcess(context, Process.myPid());
    }

    public boolean isLoaddexProcess() {
        String curProcessName = getCurProcessName(this.mDIDIBaseApplication);
        if (!TextUtils.isEmpty(curProcessName)) {
            return curProcessName.contains(":loaddex");
        }
        return false;
    }

    public String getCurProcessName(Context context) {
        try {
            int myPid = Process.myPid();
            for (ActivityManager.RunningAppProcessInfo next : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
                if (next.pid == myPid) {
                    return next.processName;
                }
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean isMainProcess(Context context, int i) {
        try {
            String packageName = context.getPackageName();
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
            if (runningAppProcesses == null) {
                return false;
            }
            for (ActivityManager.RunningAppProcessInfo next : runningAppProcesses) {
                if (packageName.equals(next.processName)) {
                    if (next.pid == i) {
                        return true;
                    }
                    return false;
                }
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }
}
