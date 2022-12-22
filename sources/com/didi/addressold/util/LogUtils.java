package com.didi.addressold.util;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import java.util.List;
import java.util.MissingFormatArgumentException;
import java.util.UnknownFormatConversionException;
import java.util.regex.Pattern;

public class LogUtils {
    public static final int DEBUG = 3;
    public static final int ERROR = 6;
    public static final int INFO = 4;
    public static final String RAY_TAG = "ray";
    public static final String TAG = "ONE-ADDRESS";
    public static final int VERBOSE = 2;
    public static final int WARN = 5;

    /* renamed from: a */
    private static final Logger f7782a = LoggerFactory.getLogger("sug-page");

    /* renamed from: b */
    private static final boolean f7783b = true;

    /* renamed from: c */
    private static final Pattern f7784c = Pattern.compile("GMT([-+]\\d{4})$");

    /* renamed from: d */
    private static final String f7785d = "account:";

    /* renamed from: e */
    private static int f7786e = 3;

    /* renamed from: f */
    private static Boolean f7787f = null;

    /* renamed from: g */
    private static boolean f7788g = false;

    public static boolean isLoggable(String str, int i) {
        return false;
    }

    public static void logInfo(String str) {
        f7782a.info(str, new Object[0]);
    }

    public static void logWarn(String str) {
        f7782a.warn(str, new Object[0]);
    }

    public static void setDebuggable(boolean z) {
        f7786e = z ? 2 : 4;
        f7788g = z;
    }

    public static boolean isDebuggable() {
        return f7788g;
    }

    public static void setDebugLoggingEnabledForTests(boolean z) {
        setDebugLoggingEnabledForTestsInternal(z);
    }

    protected static void setDebugLoggingEnabledForTestsInternal(boolean z) {
        f7787f = Boolean.valueOf(z);
    }

    public static boolean buildPreventsDebugLogging() {
        return f7786e > 2;
    }

    protected static boolean isDebugLoggingEnabled(String str) {
        if (buildPreventsDebugLogging()) {
            return false;
        }
        Boolean bool = f7787f;
        if (bool != null) {
            return bool.booleanValue();
        }
        if (Log.isLoggable(str, 3) || Log.isLoggable(TAG, 3)) {
            return true;
        }
        return false;
    }

    public static String contentUriToString(Uri uri) {
        return contentUriToString(TAG, uri);
    }

    public static String contentUriToString(String str, Uri uri) {
        if (isDebugLoggingEnabled(str)) {
            return uri.toString();
        }
        List<String> pathSegments = uri.getPathSegments();
        Uri.Builder appendPath = new Uri.Builder().scheme(uri.getScheme()).authority(uri.getAuthority()).query(uri.getQuery()).fragment(uri.getFragment()).appendPath(sanitizeAccountName(pathSegments.get(0)));
        for (int i = 1; i < pathSegments.size(); i++) {
            appendPath.appendPath(pathSegments.get(i));
        }
        return appendPath.toString();
    }

    public static String sanitizeAccountName(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return f7785d + sanitizeName(TAG, str);
    }

    public static String sanitizeName(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return "";
        }
        if (isDebugLoggingEnabled(str)) {
            return str2;
        }
        return String.valueOf(str2.hashCode());
    }

    /* renamed from: v */
    public static int m4968v(String str, String str2, Object... objArr) {
        if (!isLoggable(str, 2)) {
            return 0;
        }
        return SystemUtils.log(2, str, format(str2, objArr), (Throwable) null, "com.didi.addressold.util.LogUtils", 214);
    }

    /* renamed from: v */
    public static int m4969v(String str, Throwable th, String str2, Object... objArr) {
        if (!isLoggable(str, 2)) {
            return 0;
        }
        return SystemUtils.log(2, str, format(str2, objArr), th, "com.didi.addressold.util.LogUtils", 232);
    }

    /* renamed from: d */
    public static int m4962d(String str, String str2, Object... objArr) {
        if (!isLoggable(str, 3)) {
            return 0;
        }
        return SystemUtils.log(3, str, format(str2, objArr), (Throwable) null, "com.didi.addressold.util.LogUtils", 249);
    }

    /* renamed from: d */
    public static int m4963d(String str, Throwable th, String str2, Object... objArr) {
        if (!isLoggable(str, 3)) {
            return 0;
        }
        return SystemUtils.log(3, str, format(str2, objArr), th, "com.didi.addressold.util.LogUtils", 267);
    }

    /* renamed from: i */
    public static int m4966i(String str, String str2, Object... objArr) {
        if (!isLoggable(str, 4)) {
            return 0;
        }
        return SystemUtils.log(4, str, format(str2, objArr), (Throwable) null, "com.didi.addressold.util.LogUtils", 284);
    }

    /* renamed from: i */
    public static int m4967i(String str, Throwable th, String str2, Object... objArr) {
        if (!isLoggable(str, 4)) {
            return 0;
        }
        return SystemUtils.log(4, str, format(str2, objArr), th, "com.didi.addressold.util.LogUtils", 302);
    }

    /* renamed from: w */
    public static int m4970w(String str, String str2, Object... objArr) {
        if (!isLoggable(str, 5)) {
            return 0;
        }
        return SystemUtils.log(5, str, format(str2, objArr), (Throwable) null, "com.didi.addressold.util.LogUtils", 319);
    }

    /* renamed from: w */
    public static int m4971w(String str, Throwable th, String str2, Object... objArr) {
        if (!isLoggable(str, 5)) {
            return 0;
        }
        return SystemUtils.log(5, str, format(str2, objArr), th, "com.didi.addressold.util.LogUtils", 337);
    }

    /* renamed from: e */
    public static int m4964e(String str, String str2, Object... objArr) {
        if (!isLoggable(str, 6)) {
            return 0;
        }
        return SystemUtils.log(6, str, format(str2, objArr), (Throwable) null, "com.didi.addressold.util.LogUtils", 354);
    }

    /* renamed from: e */
    public static int m4965e(String str, Throwable th, String str2, Object... objArr) {
        if (!isLoggable(str, 6)) {
            return 0;
        }
        return SystemUtils.log(6, str, format(str2, objArr), th, "com.didi.addressold.util.LogUtils", 372);
    }

    public static int wtf(String str, String str2, Object... objArr) {
        return Log.wtf(str, format(str2, objArr), new Error());
    }

    public static int wtf(String str, Throwable th, String str2, Object... objArr) {
        return Log.wtf(str, format(str2, objArr), th);
    }

    public static String cleanUpMimeDate(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        return f7784c.matcher(str).replaceFirst("$1");
    }

    public static String byteToHex(int i) {
        return byteToHex(new StringBuilder(), i).toString();
    }

    public static StringBuilder byteToHex(StringBuilder sb, int i) {
        int i2 = i & 255;
        sb.append(C2382a.f4810a.charAt(i2 >> 4));
        sb.append(C2382a.f4810a.charAt(i2 & 15));
        return sb;
    }

    /* renamed from: a */
    private static String m4961a(int i) {
        StackTraceElement stackTraceElement;
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        String str = "";
        if (stackTrace == null || stackTrace.length < i || (stackTraceElement = stackTrace[i]) == null) {
            return str;
        }
        String className = stackTraceElement.getClassName();
        int lastIndexOf = className.lastIndexOf(".");
        if (!TextUtils.isEmpty(className)) {
            str = className.substring(lastIndexOf + 1);
        }
        return stackTraceElement.getMethodName() + "(" + str + ".java:" + stackTraceElement.getLineNumber() + "),";
    }

    public static String format(String str, Object... objArr) {
        try {
            return m4961a(3) + String.format(str, objArr);
        } catch (MissingFormatArgumentException unused) {
            return "An error occurred when formatting log : MissingFormatArgumentException";
        } catch (UnknownFormatConversionException unused2) {
            return "An error occurred when formatting log : UnknownFormatConversionException";
        } catch (Exception unused3) {
            return "An error occurred when formatting log : Exception";
        }
    }
}
