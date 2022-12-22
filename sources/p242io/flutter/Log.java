package p242io.flutter;

import com.didi.sdk.apm.SystemUtils;

/* renamed from: io.flutter.Log */
public class Log {
    public static int ASSERT = 7;
    public static int DEBUG = 3;
    public static int ERROR = 6;
    public static int INFO = 4;
    public static int VERBOSE = 2;
    public static int WARN = 5;

    /* renamed from: a */
    private static int f57307a = 3;

    /* renamed from: d */
    public static void m41134d(String str, String str2) {
    }

    /* renamed from: d */
    public static void m41135d(String str, String str2, Throwable th) {
    }

    /* renamed from: i */
    public static void m41138i(String str, String str2) {
    }

    /* renamed from: i */
    public static void m41139i(String str, String str2, Throwable th) {
    }

    public static void println(int i, String str, String str2) {
    }

    /* renamed from: v */
    public static void m41140v(String str, String str2) {
    }

    /* renamed from: v */
    public static void m41141v(String str, String str2, Throwable th) {
    }

    public static void setLogLevel(int i) {
        f57307a = i;
    }

    /* renamed from: w */
    public static void m41142w(String str, String str2) {
        SystemUtils.log(5, str, str2, (Throwable) null, "io.flutter.Log", 76);
    }

    /* renamed from: w */
    public static void m41143w(String str, String str2, Throwable th) {
        SystemUtils.log(5, str, str2, th, "io.flutter.Log", 80);
    }

    /* renamed from: e */
    public static void m41136e(String str, String str2) {
        SystemUtils.log(6, str, str2, (Throwable) null, "io.flutter.Log", 84);
    }

    /* renamed from: e */
    public static void m41137e(String str, String str2, Throwable th) {
        SystemUtils.log(6, str, str2, th, "io.flutter.Log", 88);
    }

    public static void wtf(String str, String str2) {
        android.util.Log.wtf(str, str2);
    }

    public static void wtf(String str, String str2, Throwable th) {
        android.util.Log.wtf(str, str2, th);
    }
}
