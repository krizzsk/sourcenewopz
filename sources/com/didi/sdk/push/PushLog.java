package com.didi.sdk.push;

import android.content.Context;
import android.util.Log;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import java.io.File;

public final class PushLog {
    private static final String PATH_FILE_NAME = ".loglevel";
    static final Logger mLogger = LoggerFactory.getLogger("pushSdk", "didiPush");
    private static int sLevel = 2;

    private PushLog() {
        throw new RuntimeException();
    }

    /* renamed from: v */
    public static int m26286v(String str, String str2) {
        if (sLevel > 2) {
            return 0;
        }
        return SystemUtils.log(2, str, str2, (Throwable) null, "com.didi.sdk.push.PushLog", 31);
    }

    /* renamed from: v */
    public static int m26287v(String str, String str2, Throwable th) {
        if (sLevel > 2) {
            return 0;
        }
        return SystemUtils.log(2, str, str2, th, "com.didi.sdk.push.PushLog", 43);
    }

    /* renamed from: d */
    public static int m26280d(String str, String str2) {
        if (sLevel > 3) {
            return 0;
        }
        return SystemUtils.log(3, str, str2, (Throwable) null, "com.didi.sdk.push.PushLog", 54);
    }

    /* renamed from: d */
    public static int m26281d(String str, String str2, Throwable th) {
        if (sLevel > 3) {
            return 0;
        }
        return SystemUtils.log(3, str, str2, th, "com.didi.sdk.push.PushLog", 66);
    }

    /* renamed from: i */
    public static int m26284i(String str, String str2) {
        if (sLevel > 4) {
            return 0;
        }
        return SystemUtils.log(4, str, str2, (Throwable) null, "com.didi.sdk.push.PushLog", 77);
    }

    /* renamed from: i */
    public static int m26285i(String str, String str2, Throwable th) {
        if (sLevel > 4) {
            return 0;
        }
        return SystemUtils.log(4, str, str2, th, "com.didi.sdk.push.PushLog", 89);
    }

    /* renamed from: w */
    public static int m26288w(String str, String str2) {
        if (sLevel > 5) {
            return 0;
        }
        return SystemUtils.log(5, str, str2, (Throwable) null, "com.didi.sdk.push.PushLog", 100);
    }

    /* renamed from: w */
    public static int m26289w(String str, String str2, Throwable th) {
        if (sLevel > 5) {
            return 0;
        }
        return SystemUtils.log(5, str, str2, th, "com.didi.sdk.push.PushLog", 112);
    }

    /* renamed from: w */
    public static int m26290w(String str, Throwable th) {
        if (sLevel > 5) {
            return 0;
        }
        return Log.w(str, th);
    }

    /* renamed from: e */
    public static int m26282e(String str, String str2) {
        if (sLevel > 6) {
            return 0;
        }
        return SystemUtils.log(6, str, str2, (Throwable) null, "com.didi.sdk.push.PushLog", 134);
    }

    /* renamed from: e */
    public static int m26283e(String str, String str2, Throwable th) {
        if (sLevel > 6) {
            return 0;
        }
        return SystemUtils.log(6, str, str2, th, "com.didi.sdk.push.PushLog", 146);
    }

    public static void setLevel(int i) {
        if (allowAllLevel()) {
            sLevel = 2;
        } else {
            sLevel = i;
        }
    }

    private static boolean allowAllLevel() {
        Context applicationContext = ContextUtil.getApplicationContext();
        if (applicationContext != null && new File(applicationContext.getExternalFilesDir((String) null), PATH_FILE_NAME).exists()) {
            return true;
        }
        return false;
    }
}
