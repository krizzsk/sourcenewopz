package com.adyen.checkout.core.log;

import android.os.Build;
import com.adyen.checkout.core.exception.NoConstructorException;
import com.adyen.checkout.core.util.KotlinBase;

public final class LogUtil {

    /* renamed from: a */
    private static final String f936a = "CO.";

    /* renamed from: b */
    private static final String f937b = "?Unknown?";

    /* renamed from: c */
    private static final int f938c = 23;

    static {
        KotlinBase.log();
    }

    public static String getTag() {
        return getTag(f936a);
    }

    public static String getTag(String str) {
        String str2 = str + m1072a();
        return (Build.VERSION.SDK_INT > 23 || str2.length() <= 23) ? str2 : str2.substring(0, 23);
    }

    /* renamed from: a */
    private static String m1072a() {
        return m1073a(m1074b());
    }

    /* renamed from: b */
    private static String m1074b() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        for (int i = 1; i < stackTrace.length; i++) {
            String className = stackTrace[i].getClassName();
            if (!className.equals(LogUtil.class.getName()) && className.indexOf("java.lang.Thread") != 0) {
                return className;
            }
        }
        return f937b;
    }

    /* renamed from: a */
    private static String m1073a(String str) {
        String[] split = str.split("\\.");
        if (split.length == 0) {
            return str;
        }
        return split[split.length - 1];
    }

    private LogUtil() {
        throw new NoConstructorException();
    }
}
