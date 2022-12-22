package com.didi.foundation.sdk.application;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import androidx.multidex.MultiDex;
import com.didi.flutter.nacho2.p115v2.NachoLifecycleManager;
import com.didi.foundation.sdk.service.LocaleService;
import com.didi.sdk.onehotpatch.ONEPatchFacade;
import com.didi.sofa.utils.ProcessUtils;
import java.lang.reflect.Method;
import java.util.HashMap;

public class FoundationApplication extends Application {

    /* renamed from: a */
    private static final String f21159a = "com.didi.foundation.sdk.application.LaunchApplicationListener";

    /* renamed from: b */
    private Object f21160b;

    /* renamed from: c */
    private HashMap<String, Method> f21161c = new HashMap<>();

    public boolean isMainProcess() {
        return ProcessUtils.isMainProcess(this);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (isMainProcess()) {
            m15577a(this.f21160b, "onConfigurationChanged", this, configuration);
        }
    }

    public void onCreate() {
        super.onCreate();
        if (isMainProcess()) {
            m15577a(this.f21160b, NachoLifecycleManager.LIFECYCLE_ON_CREATE, this);
        }
    }

    public void onLowMemory() {
        super.onLowMemory();
        if (isMainProcess()) {
            m15577a(this.f21160b, "onLowMemory", this);
        }
    }

    public void onTerminate() {
        super.onTerminate();
        if (isMainProcess()) {
            m15577a(this.f21160b, "onTerminate", this);
        }
    }

    public void onTrimMemory(int i) {
        super.onTrimMemory(i);
        if (isMainProcess()) {
            m15577a(this.f21160b, "onTrimMemory", this, Integer.valueOf(i));
        }
    }

    /* access modifiers changed from: protected */
    public void attachBaseContext(Context context) {
        super.attachBaseContext(LocaleService.getInstance().attachBaseContext(context));
        if (Build.VERSION.SDK_INT < 21) {
            MultiDex.install(this);
        }
        ONEPatchFacade.launch(this);
        m15576a();
        if (isMainProcess()) {
            m15577a(this.f21160b, "attachBaseContext", context);
        }
    }

    /* renamed from: a */
    private void m15576a() {
        try {
            Class<?> cls = Class.forName(f21159a, true, getClassLoader());
            this.f21160b = cls.newInstance();
            for (Method method : cls.getDeclaredMethods()) {
                this.f21161c.put(method.getName(), method);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    private void m15577a(Object obj, String str, Object... objArr) {
        try {
            Method method = this.f21161c.get(str);
            if (method != null) {
                method.setAccessible(true);
                method.invoke(obj, objArr);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
