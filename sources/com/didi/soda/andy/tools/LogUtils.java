package com.didi.soda.andy.tools;

import android.util.Log;
import com.didichuxing.bigdata.p173dp.locsdk.Const;
import org.osgi.framework.VersionRange;

public final class LogUtils {
    public static boolean S_OPEN_LOG = true;

    /* renamed from: a */
    static volatile long f38808a = System.currentTimeMillis();

    /* renamed from: b */
    static volatile int f38809b = 0;

    /* renamed from: c */
    private static final String f38810c = "_AndyTest_";

    private LogUtils() {
    }

    /* renamed from: d */
    public static void m27507d(String str, CharSequence charSequence) {
        m27508d(str, charSequence, 2);
    }

    /* renamed from: d */
    public static void m27509d(String str, CharSequence charSequence, Object... objArr) {
        m27508d(str, (CharSequence) charSequence.toString() + objArr, 2);
    }

    /* renamed from: d */
    public static void m27508d(String str, CharSequence charSequence, int i) {
        if (S_OPEN_LOG) {
            Log.d(str, m27503a(charSequence, new Throwable().getStackTrace()[i]));
        }
    }

    /* renamed from: d */
    public static void m27506d(CharSequence charSequence) {
        if (S_OPEN_LOG) {
            Log.d(f38810c, m27503a(charSequence, new Throwable().getStackTrace()[1]));
        }
    }

    /* renamed from: i */
    public static void m27514i(String str, CharSequence charSequence, int i) {
        if (S_OPEN_LOG) {
            Log.i(str, m27503a(charSequence, new Throwable().getStackTrace()[i]));
        }
    }

    /* renamed from: i */
    public static void m27513i(String str, CharSequence charSequence) {
        m27514i(str, charSequence, 2);
    }

    /* renamed from: v */
    public static void m27517v(String str, CharSequence charSequence, int i) {
        if (S_OPEN_LOG) {
            Log.v(str, m27503a(charSequence, new Throwable().getStackTrace()[i]));
        }
    }

    /* renamed from: v */
    public static void m27516v(String str, CharSequence charSequence) {
        m27517v(str, charSequence, 2);
    }

    /* renamed from: w */
    public static void m27518w(String str, CharSequence charSequence) {
        if (S_OPEN_LOG) {
            Log.w(str, m27504a(str, charSequence, new Throwable().getStackTrace()[1]));
        }
    }

    /* renamed from: e */
    public static void m27512e(String str, Throwable th) {
        if (S_OPEN_LOG) {
            Log.e(str, m27505a(str, "", new Throwable().getStackTrace()[1], th), th);
        }
    }

    /* renamed from: e */
    public static void m27510e(String str, CharSequence charSequence) {
        if (S_OPEN_LOG) {
            Log.e(str, m27504a(str, charSequence, new Throwable().getStackTrace()[1]));
        }
    }

    /* renamed from: e */
    public static void m27511e(String str, CharSequence charSequence, Throwable th) {
        if (S_OPEN_LOG) {
            Log.d(str, m27504a(str, charSequence, new Throwable().getStackTrace()[1]), th);
        }
    }

    /* renamed from: t */
    public static void m27515t(String str, CharSequence charSequence) {
        if (S_OPEN_LOG) {
            StackTraceElement[] stackTrace = new Throwable().getStackTrace();
            StringBuilder sb = new StringBuilder();
            if (stackTrace.length > 0) {
                sb.append(m27503a(charSequence, stackTrace[1]));
                sb.append(10);
            } else {
                sb.append(charSequence);
            }
            for (int i = 2; i < stackTrace.length; i++) {
                sb.append(stackTrace[i]);
                sb.append(10);
            }
            Log.i(str, sb.toString());
        }
    }

    public static void timeSinceLast() {
        StringBuilder sb = new StringBuilder();
        sb.append("⚠️");
        int i = f38809b;
        f38809b = i + 1;
        sb.append(i);
        sb.append("spend:");
        sb.append(System.currentTimeMillis() - f38808a);
        sb.append(" ");
        m27508d(f38810c, (CharSequence) sb.toString(), 2);
        f38808a = System.currentTimeMillis();
    }

    public static String getLineText(String str, int i) {
        return S_OPEN_LOG ? m27503a(str, new Throwable().getStackTrace()[i]) : str;
    }

    public static String getLineText(String str) {
        return S_OPEN_LOG ? m27503a(str, new Throwable().getStackTrace()[1]) : str;
    }

    /* renamed from: a */
    private static String m27503a(CharSequence charSequence, StackTraceElement stackTraceElement) {
        StringBuilder sb = new StringBuilder();
        sb.append(Const.jaLeft);
        sb.append(Thread.currentThread().getId());
        sb.append(Const.jaRight);
        if (stackTraceElement.isNativeMethod()) {
            sb.append("(Native Method)");
        } else {
            String fileName = stackTraceElement.getFileName();
            if (fileName == null) {
                sb.append("(Unknown Source)");
            } else {
                int lineNumber = stackTraceElement.getLineNumber();
                sb.append(VersionRange.LEFT_OPEN);
                sb.append(fileName);
                if (lineNumber >= 0) {
                    sb.append(':');
                    sb.append(lineNumber);
                }
                sb.append("):");
            }
        }
        sb.append(charSequence);
        return sb.toString();
    }

    /* renamed from: a */
    private static String m27504a(String str, CharSequence charSequence, StackTraceElement stackTraceElement) {
        return Const.jaLeft + str + Const.jaRight + m27503a(charSequence, stackTraceElement);
    }

    /* renamed from: a */
    private static String m27505a(String str, CharSequence charSequence, StackTraceElement stackTraceElement, Throwable th) {
        return Const.jaLeft + str + Const.jaRight + stackTraceElement.toString() + ":" + charSequence + "\r\n" + "e:" + th.getMessage();
    }
}
