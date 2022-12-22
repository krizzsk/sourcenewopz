package com.didi.sdk.apm.crash;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.didi.sdk.apm.utils.ReflectUtils;
import com.didi.sdk.apm.utils.RemoteConfiguration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AppCrashInterceptor implements Handler.Callback {

    /* renamed from: a */
    private static final String f34990a = "AppCrashInterceptor";

    /* renamed from: b */
    private static final String f34991b = "global_app_system_crash_intercept";

    /* renamed from: c */
    private static final String f34992c = "systemError";

    /* renamed from: d */
    private static AppCrashInterceptor f34993d = new AppCrashInterceptor();

    /* renamed from: e */
    private static boolean f34994e = false;

    /* renamed from: f */
    private static int f34995f = 134;

    /* renamed from: g */
    private static Handler.Callback f34996g;

    /* renamed from: h */
    private static List<String> f34997h;

    /* renamed from: i */
    private static String[] f34998i = {"can't deliver broadcast"};

    public static synchronized void init() {
        synchronized (AppCrashInterceptor.class) {
            if (!f34994e) {
                f34994e = true;
                try {
                    m24745a();
                } catch (Exception unused) {
                }
            }
        }
    }

    /* renamed from: a */
    private static synchronized void m24745a() {
        synchronized (AppCrashInterceptor.class) {
            if (RemoteConfiguration.isOpen(f34991b, true)) {
                List<String> splittableConfig = RemoteConfiguration.getSplittableConfig(f34991b, f34992c);
                f34997h = splittableConfig;
                if (splittableConfig == null) {
                    f34997h = new ArrayList();
                }
                f34997h.addAll(Arrays.asList(f34998i));
            }
        }
    }

    public static void hookActivityThreadHandler(Object obj) {
        try {
            f34995f = ((Integer) ReflectUtils.getFieldObject("android.app.ActivityThread$H", (Object) null, "SCHEDULE_CRASH")).intValue();
            Handler handler = (Handler) ReflectUtils.getFieldObject("android.app.ActivityThread", obj, "mH");
            f34996g = (Handler.Callback) ReflectUtils.getFieldObject("android.os.Handler", handler, "mCallback");
            ReflectUtils.setFieldObject("android.os.Handler", "mCallback", handler, f34993d);
            Log.w(f34990a, "hookActivityThread success ");
        } catch (Exception e) {
            Log.w(f34990a, "hookActivityThread failed ", e);
        }
    }

    public boolean handleMessage(Message message) {
        if (m24746a(message)) {
            return true;
        }
        Handler.Callback callback = f34996g;
        if (callback == null || !callback.handleMessage(message)) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    private boolean m24746a(Message message) {
        List<String> list;
        if (message.what != f34995f || !(message.obj instanceof String) || (list = f34997h) == null || list.size() <= 0) {
            return false;
        }
        String str = (String) message.obj;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        for (String next : f34997h) {
            if (!TextUtils.isEmpty(next) && str.startsWith(next)) {
                Log.w(f34990a, "Intercepted an error from system, error = " + str);
                return true;
            }
        }
        return false;
    }
}
