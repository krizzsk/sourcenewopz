package p241in.srain.cube.views.ptr.util;

import android.util.Log;
import com.didi.sdk.apm.SystemUtils;

/* renamed from: in.srain.cube.views.ptr.util.PtrCLog */
public class PtrCLog {
    public static final int LEVEL_DEBUG = 1;
    public static final int LEVEL_ERROR = 4;
    public static final int LEVEL_FATAL = 5;
    public static final int LEVEL_INFO = 2;
    public static final int LEVEL_VERBOSE = 0;
    public static final int LEVEL_WARNING = 3;
    private static int sLevel;

    public static void setLogLevel(int i) {
        sLevel = i;
    }

    /* renamed from: v */
    public static void m41126v(String str, String str2) {
        if (sLevel <= 0) {
            SystemUtils.log(2, str, str2, (Throwable) null, "in.srain.cube.views.ptr.util.PtrCLog", 40);
        }
    }

    /* renamed from: v */
    public static void m41127v(String str, String str2, Throwable th) {
        if (sLevel <= 0) {
            SystemUtils.log(2, str, str2, th, "in.srain.cube.views.ptr.util.PtrCLog", 54);
        }
    }

    /* renamed from: v */
    public static void m41128v(String str, String str2, Object... objArr) {
        if (sLevel <= 0) {
            if (objArr.length > 0) {
                str2 = String.format(str2, objArr);
            }
            SystemUtils.log(2, str, str2, (Throwable) null, "in.srain.cube.views.ptr.util.PtrCLog", 71);
        }
    }

    /* renamed from: d */
    public static void m41114d(String str, String str2) {
        if (sLevel <= 1) {
            SystemUtils.log(3, str, str2, (Throwable) null, "in.srain.cube.views.ptr.util.PtrCLog", 84);
        }
    }

    /* renamed from: d */
    public static void m41116d(String str, String str2, Object... objArr) {
        if (sLevel <= 1) {
            if (objArr.length > 0) {
                str2 = String.format(str2, objArr);
            }
            SystemUtils.log(3, str, str2, (Throwable) null, "in.srain.cube.views.ptr.util.PtrCLog", 101);
        }
    }

    /* renamed from: d */
    public static void m41115d(String str, String str2, Throwable th) {
        if (sLevel <= 1) {
            SystemUtils.log(3, str, str2, th, "in.srain.cube.views.ptr.util.PtrCLog", 115);
        }
    }

    /* renamed from: i */
    public static void m41123i(String str, String str2) {
        if (sLevel <= 2) {
            SystemUtils.log(4, str, str2, (Throwable) null, "in.srain.cube.views.ptr.util.PtrCLog", 128);
        }
    }

    /* renamed from: i */
    public static void m41125i(String str, String str2, Object... objArr) {
        if (sLevel <= 2) {
            if (objArr.length > 0) {
                str2 = String.format(str2, objArr);
            }
            SystemUtils.log(4, str, str2, (Throwable) null, "in.srain.cube.views.ptr.util.PtrCLog", 145);
        }
    }

    /* renamed from: i */
    public static void m41124i(String str, String str2, Throwable th) {
        if (sLevel <= 2) {
            SystemUtils.log(4, str, str2, th, "in.srain.cube.views.ptr.util.PtrCLog", 158);
        }
    }

    /* renamed from: w */
    public static void m41129w(String str, String str2) {
        if (sLevel <= 3) {
            SystemUtils.log(5, str, str2, (Throwable) null, "in.srain.cube.views.ptr.util.PtrCLog", 171);
        }
    }

    /* renamed from: w */
    public static void m41131w(String str, String str2, Object... objArr) {
        if (sLevel <= 3) {
            if (objArr.length > 0) {
                str2 = String.format(str2, objArr);
            }
            SystemUtils.log(5, str, str2, (Throwable) null, "in.srain.cube.views.ptr.util.PtrCLog", 188);
        }
    }

    /* renamed from: w */
    public static void m41130w(String str, String str2, Throwable th) {
        if (sLevel <= 3) {
            SystemUtils.log(5, str, str2, th, "in.srain.cube.views.ptr.util.PtrCLog", 202);
        }
    }

    /* renamed from: e */
    public static void m41117e(String str, String str2) {
        if (sLevel <= 4) {
            SystemUtils.log(6, str, str2, (Throwable) null, "in.srain.cube.views.ptr.util.PtrCLog", 215);
        }
    }

    /* renamed from: e */
    public static void m41119e(String str, String str2, Object... objArr) {
        if (sLevel <= 4) {
            if (objArr.length > 0) {
                str2 = String.format(str2, objArr);
            }
            SystemUtils.log(6, str, str2, (Throwable) null, "in.srain.cube.views.ptr.util.PtrCLog", 232);
        }
    }

    /* renamed from: e */
    public static void m41118e(String str, String str2, Throwable th) {
        if (sLevel <= 4) {
            SystemUtils.log(6, str, str2, th, "in.srain.cube.views.ptr.util.PtrCLog", 246);
        }
    }

    /* renamed from: f */
    public static void m41120f(String str, String str2) {
        if (sLevel <= 5) {
            Log.wtf(str, str2);
        }
    }

    /* renamed from: f */
    public static void m41122f(String str, String str2, Object... objArr) {
        if (sLevel <= 5) {
            if (objArr.length > 0) {
                str2 = String.format(str2, objArr);
            }
            Log.wtf(str, str2);
        }
    }

    /* renamed from: f */
    public static void m41121f(String str, String str2, Throwable th) {
        if (sLevel <= 5) {
            Log.wtf(str, str2, th);
        }
    }
}
