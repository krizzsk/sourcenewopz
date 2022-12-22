package didinet;

import android.content.Context;
import android.util.Log;
import com.didi.sdk.apm.SystemUtils;
import java.io.File;
import utils.ContextUtil;
import utils.FileUtil;

public final class Logger {

    /* renamed from: a */
    private static final String f57078a = "didihttp";

    /* renamed from: b */
    private static int f57079b = 2;

    /* renamed from: c */
    private static final String f57080c = "loglevel.txt";

    private Logger() {
        throw new RuntimeException();
    }

    /* renamed from: v */
    public static int m40934v(String str, String str2) {
        if (f57079b > 2) {
            return 0;
        }
        return SystemUtils.log(2, str, str2, (Throwable) null, "didinet.Logger", 32);
    }

    /* renamed from: v */
    public static int m40935v(String str, String str2, Throwable th) {
        if (f57079b > 2) {
            return 0;
        }
        return SystemUtils.log(2, str, str2, th, "didinet.Logger", 45);
    }

    /* renamed from: d */
    public static int m40928d(String str, String str2) {
        if (f57079b > 3) {
            return 0;
        }
        return SystemUtils.log(3, str, str2, (Throwable) null, "didinet.Logger", 57);
    }

    /* renamed from: d */
    public static int m40929d(String str, String str2, Throwable th) {
        if (f57079b > 3) {
            return 0;
        }
        return SystemUtils.log(3, str, str2, th, "didinet.Logger", 70);
    }

    /* renamed from: i */
    public static int m40932i(String str, String str2) {
        if (f57079b > 4) {
            return 0;
        }
        return SystemUtils.log(4, str, str2, (Throwable) null, "didinet.Logger", 82);
    }

    /* renamed from: i */
    public static int m40933i(String str, String str2, Throwable th) {
        if (f57079b > 4) {
            return 0;
        }
        return SystemUtils.log(4, str, str2, th, "didinet.Logger", 95);
    }

    /* renamed from: w */
    public static int m40936w(String str, String str2) {
        if (f57079b > 5) {
            return 0;
        }
        return SystemUtils.log(5, str, str2, (Throwable) null, "didinet.Logger", 107);
    }

    /* renamed from: w */
    public static int m40937w(String str, String str2, Throwable th) {
        if (f57079b > 5) {
            return 0;
        }
        return SystemUtils.log(5, str, str2, th, "didinet.Logger", 120);
    }

    /* renamed from: w */
    public static int m40938w(String str, Throwable th) {
        if (f57079b > 5) {
            return 0;
        }
        return Log.w(str, th);
    }

    /* renamed from: e */
    public static int m40930e(String str, String str2) {
        if (f57079b > 6) {
            return 0;
        }
        return SystemUtils.log(6, str, str2, (Throwable) null, "didinet.Logger", 143);
    }

    /* renamed from: e */
    public static int m40931e(String str, String str2, Throwable th) {
        if (f57079b > 6) {
            return 0;
        }
        return SystemUtils.log(6, str, str2, th, "didinet.Logger", 156);
    }

    public static void logClassAndMethod(Object obj) {
        StringBuilder sb = new StringBuilder();
        sb.append(obj.hashCode());
        StackTraceElement[] stackTrace = new Throwable().fillInStackTrace().getStackTrace();
        if (!(stackTrace == null || stackTrace.length < 2 || stackTrace[1] == null)) {
            sb.append("|");
            sb.append(stackTrace[1].getMethodName());
        }
        m40928d(obj.getClass().getSimpleName(), sb.toString());
    }

    public static void setLevel(int i) {
        if (m40927b()) {
            f57079b = 2;
        } else {
            f57079b = i;
        }
    }

    /* renamed from: b */
    private static boolean m40927b() {
        Context applicationContext = ContextUtil.getApplicationContext();
        if (applicationContext != null && new File(applicationContext.getExternalFilesDir((String) null), f57080c).exists()) {
            return true;
        }
        return false;
    }

    @Deprecated
    /* renamed from: a */
    static boolean m40926a() {
        Context applicationContext = ContextUtil.getApplicationContext();
        if (applicationContext == null) {
            return false;
        }
        return FileUtil.createOrExistFile(new File(applicationContext.getExternalFilesDir((String) null), f57080c));
    }
}
