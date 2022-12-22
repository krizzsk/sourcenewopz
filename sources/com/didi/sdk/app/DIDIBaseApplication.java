package com.didi.sdk.app;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebView;
import com.didi.flutter.nacho2.p115v2.NachoLifecycleManager;
import com.didi.sdk.apm.instrumentation.InstrumentationHooker;
import com.didi.sdk.apm.utils.C11896Reflection;
import java.lang.reflect.Method;
import java.util.List;

public class DIDIBaseApplication extends Application implements Application.ActivityLifecycleCallbacks {
    private static final String TAG = "DIDIBaseApplication";
    private static Application appContext;
    public static long sTimeStamp;
    private Object applicationDelegate;
    private Class applicationDelegateClass;
    private boolean hotLaunch;
    private boolean isMainProcess;

    public void launchHotPatch(Context context) {
    }

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivityPaused(Activity activity) {
    }

    public void onActivityResumed(Activity activity) {
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
    }

    public void onActivityStopped(Activity activity) {
    }

    public static Application getAppContext() {
        return appContext;
    }

    private void checkAppDelegate() {
        if (this.applicationDelegateClass == null) {
            try {
                Class<?> cls = Class.forName("com.didi.sdk.app.DIDIApplicationDelegate", true, getClassLoader());
                this.applicationDelegateClass = cls;
                this.applicationDelegate = cls.newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void attachBaseContext(Context context) {
        String str;
        super.attachBaseContext(context);
        appContext = this;
        this.isMainProcess = isMainProcess(this, Process.myPid());
        if (!isLoaddexProcess()) {
            C12015g.m24931a(context);
            sTimeStamp = System.currentTimeMillis();
            launchHotPatch(context);
            try {
                checkAppDelegate();
                Method declaredMethod = this.applicationDelegateClass.getDeclaredMethod("attachBaseContext", new Class[]{Application.class});
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(this.applicationDelegate, new Object[]{this});
                initANR(context);
                executeHook();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else if (Build.VERSION.SDK_INT >= 28) {
            String curProcessName = getCurProcessName(context);
            if (!TextUtils.isEmpty(curProcessName)) {
                str = curProcessName + "_passenger_loaddex";
            } else {
                str = "passenger_loaddex";
            }
            WebView.setDataDirectorySuffix(str);
        }
    }

    private void initANR(Context context) {
        if (context != null) {
            try {
                boolean isOpen = ANRApolloHelper.isOpen(context);
                Log.d(TAG, "xcrash anr check open status:" + isOpen);
                if (isOpen) {
                    Log.d(TAG, "xcrash anr check open success");
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private void executeHook() {
        C11896Reflection.unseal();
        InstrumentationHooker.hook(appContext);
    }

    public void onCreate() {
        super.onCreate();
        if (this.isMainProcess) {
            try {
                checkAppDelegate();
                Method declaredMethod = this.applicationDelegateClass.getDeclaredMethod(NachoLifecycleManager.LIFECYCLE_ON_CREATE, new Class[]{Application.class});
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(this.applicationDelegate, new Object[]{this});
                registerActivityLifecycleCallbacks(this);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void onLowMemory() {
        super.onLowMemory();
        if (this.isMainProcess) {
            try {
                checkAppDelegate();
                Method declaredMethod = this.applicationDelegateClass.getDeclaredMethod("onLowMemory", new Class[]{Application.class});
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(this.applicationDelegate, new Object[]{this});
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void onTrimMemory(int i) {
        super.onTrimMemory(i);
        if (this.isMainProcess) {
            try {
                checkAppDelegate();
                Method declaredMethod = this.applicationDelegateClass.getDeclaredMethod("onTrimMemory", new Class[]{Application.class, Integer.TYPE});
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(this.applicationDelegate, new Object[]{this, Integer.valueOf(i)});
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public boolean isLoaddexProcess() {
        String curProcessName = getCurProcessName(this);
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

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        try {
            if (this.applicationDelegateClass != null) {
                Method declaredMethod = this.applicationDelegateClass.getDeclaredMethod("onConfigurationChanged", new Class[]{Configuration.class, Application.class});
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(this.applicationDelegate, new Object[]{configuration, this});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isHotLaunch() {
        return this.hotLaunch;
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        String name = activity.getClass().getName();
        if ("com.didi.sdk.app.MainActivityImpl".equals(name) || "com.didi.sdk.app.MainActivityImplV2".equals(name)) {
            this.hotLaunch = true;
        }
    }
}
