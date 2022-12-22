package com.didi.dynamic.manager.utils;

import com.didi.raven.config.RavenKey;
import com.didi.sdk.apm.SystemUtils;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;

public final class Log {
    public static final int ASSERT = 7;
    public static final int DEBUG = 3;
    public static final int ERROR = 6;
    public static final int INFO = 4;
    public static final int VERBOSE = 2;
    public static final int WARN = 5;

    /* renamed from: a */
    private static final ConcurrentHashMap<String, Method> f19361a = new ConcurrentHashMap<>();

    private Log() {
    }

    /* renamed from: v */
    public static int m14490v(String str, String str2) {
        try {
            return ((Integer) m14483a(RavenKey.VERSION, String.class, String.class).invoke((Object) null, new Object[]{str, str2})).intValue();
        } catch (Throwable unused) {
            return SystemUtils.log(2, str, str2, (Throwable) null, "com.didi.dynamic.manager.utils.Log", 58);
        }
    }

    /* renamed from: v */
    public static int m14491v(String str, String str2, Throwable th) {
        try {
            return ((Integer) m14482a("v2", RavenKey.VERSION, String.class, String.class, Throwable.class).invoke((Object) null, new Object[]{str, str2, th})).intValue();
        } catch (Throwable unused) {
            return SystemUtils.log(2, str, str2, th, "com.didi.dynamic.manager.utils.Log", 74);
        }
    }

    /* renamed from: d */
    public static int m14484d(String str, String str2) {
        try {
            return ((Integer) m14483a("d", String.class, String.class).invoke((Object) null, new Object[]{str, str2})).intValue();
        } catch (Throwable unused) {
            return SystemUtils.log(3, str, str2, (Throwable) null, "com.didi.dynamic.manager.utils.Log", 89);
        }
    }

    /* renamed from: d */
    public static int m14485d(String str, String str2, Throwable th) {
        try {
            return ((Integer) m14482a("d2", "d", String.class, String.class, Throwable.class).invoke((Object) null, new Object[]{str, str2, th})).intValue();
        } catch (Throwable unused) {
            return SystemUtils.log(3, str, str2, th, "com.didi.dynamic.manager.utils.Log", 105);
        }
    }

    /* renamed from: i */
    public static int m14488i(String str, String str2) {
        try {
            return ((Integer) m14483a("i", String.class, String.class).invoke((Object) null, new Object[]{str, str2})).intValue();
        } catch (Throwable unused) {
            return SystemUtils.log(4, str, str2, (Throwable) null, "com.didi.dynamic.manager.utils.Log", 120);
        }
    }

    /* renamed from: i */
    public static int m14489i(String str, String str2, Throwable th) {
        try {
            return ((Integer) m14482a("i2", "i", String.class, String.class, Throwable.class).invoke((Object) null, new Object[]{str, str2, th})).intValue();
        } catch (Throwable unused) {
            return SystemUtils.log(4, str, str2, th, "com.didi.dynamic.manager.utils.Log", 136);
        }
    }

    /* renamed from: w */
    public static int m14492w(String str, String str2) {
        try {
            return ((Integer) m14483a("w", String.class, String.class).invoke((Object) null, new Object[]{str, str2})).intValue();
        } catch (Throwable unused) {
            return SystemUtils.log(5, str, str2, (Throwable) null, "com.didi.dynamic.manager.utils.Log", 151);
        }
    }

    /* renamed from: w */
    public static int m14493w(String str, String str2, Throwable th) {
        try {
            return ((Integer) m14482a("w2", "w", String.class, String.class, Throwable.class).invoke((Object) null, new Object[]{str, str2, th})).intValue();
        } catch (Throwable unused) {
            return SystemUtils.log(5, str, str2, th, "com.didi.dynamic.manager.utils.Log", 167);
        }
    }

    public static boolean isLoggable(String str, int i) {
        return android.util.Log.isLoggable(str, i);
    }

    /* renamed from: w */
    public static int m14494w(String str, Throwable th) {
        try {
            return ((Integer) m14482a("w3", "w", String.class, Throwable.class).invoke((Object) null, new Object[]{str, th})).intValue();
        } catch (Throwable unused) {
            return android.util.Log.w(str, th);
        }
    }

    /* renamed from: e */
    public static int m14486e(String str, String str2) {
        try {
            return ((Integer) m14483a("e", String.class, String.class).invoke((Object) null, new Object[]{str, str2})).intValue();
        } catch (Throwable unused) {
            return SystemUtils.log(6, str, str2, (Throwable) null, "com.didi.dynamic.manager.utils.Log", 221);
        }
    }

    /* renamed from: e */
    public static int m14487e(String str, String str2, Throwable th) {
        try {
            return ((Integer) m14482a("e2", "e", String.class, String.class, Throwable.class).invoke((Object) null, new Object[]{str, str2, th})).intValue();
        } catch (Throwable unused) {
            return SystemUtils.log(6, str, str2, th, "com.didi.dynamic.manager.utils.Log", 237);
        }
    }

    public static int wtf(String str, String str2) {
        try {
            return ((Integer) m14483a("wtf", String.class, String.class).invoke((Object) null, new Object[]{str, str2})).intValue();
        } catch (Throwable unused) {
            return android.util.Log.wtf(str, str2);
        }
    }

    public static int wtf(String str, Throwable th) {
        try {
            return ((Integer) m14482a("wtf2", "wtf", String.class, Throwable.class).invoke((Object) null, new Object[]{str, th})).intValue();
        } catch (Throwable unused) {
            return android.util.Log.wtf(str, th);
        }
    }

    public static int wtf(String str, String str2, Throwable th) {
        try {
            return ((Integer) m14482a("wtf3", "wtf", String.class, String.class, Throwable.class).invoke((Object) null, new Object[]{str, str2, th})).intValue();
        } catch (Throwable unused) {
            return android.util.Log.wtf(str, str2, th);
        }
    }

    public static String getStackTraceString(Throwable th) {
        return android.util.Log.getStackTraceString(th);
    }

    public static int println(int i, String str, String str2) {
        try {
            return ((Integer) m14483a("println", Integer.TYPE, String.class, String.class).invoke((Object) null, new Object[]{Integer.valueOf(i), str, str2})).intValue();
        } catch (Throwable unused) {
            return SystemUtils.log(i, str, str2, (Throwable) null, "com.didi.dynamic.manager.utils.Log", 311);
        }
    }

    /* renamed from: a */
    private static Method m14483a(String str, Class<?>... clsArr) throws Throwable {
        return m14482a(str, (String) null, clsArr);
    }

    /* renamed from: a */
    private static Method m14482a(String str, String str2, Class<?>... clsArr) throws Throwable {
        Method method = f19361a.get(str);
        if (method != null) {
            return method;
        }
        if (str2 == null) {
            str2 = str;
        }
        Method declaredMethod = android.util.Log.class.getDeclaredMethod(str2, clsArr);
        f19361a.put(str, declaredMethod);
        return declaredMethod;
    }
}
