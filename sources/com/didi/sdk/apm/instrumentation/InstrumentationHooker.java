package com.didi.sdk.apm.instrumentation;

import android.app.Application;
import android.app.Instrumentation;
import com.didi.sdk.apm.crash.AppCrashInterceptor;
import com.didi.sdk.apm.utils.ReflectUtils;

public class InstrumentationHooker {
    public static void hook() {
    }

    public static void hook(Application application) {
        Instrumentation instrumentation;
        boolean z = false;
        Object invokeStaticMethod = ReflectUtils.invokeStaticMethod("android.app.ActivityThread", "currentActivityThread", new Class[0], new Object[0]);
        if (invokeStaticMethod != null && (instrumentation = (Instrumentation) ReflectUtils.getFieldObject("android.app.ActivityThread", invokeStaticMethod, "mInstrumentation")) != null) {
            if (!(application.getApplicationInfo() == null || (application.getApplicationInfo().flags & 2) == 0)) {
                z = true;
            }
            ReflectUtils.setFieldObject("android.app.ActivityThread", "mInstrumentation", invokeStaticMethod, new DidiInstrumentation(instrumentation, z));
            AppCrashInterceptor.hookActivityThreadHandler(invokeStaticMethod);
            HookApolloHelper.m24762b(application);
            IActivityManagerHook.INSTANCE.iActivityManagerHook(application);
        }
    }
}
