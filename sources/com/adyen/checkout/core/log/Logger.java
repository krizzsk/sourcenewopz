package com.adyen.checkout.core.log;

import android.util.Log;
import com.adyen.checkout.core.exception.NoConstructorException;
import com.didi.sdk.apm.SystemUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class Logger {
    public static final int NONE = 8;

    /* renamed from: a */
    private static final int f939a = -1;

    /* renamed from: b */
    private static final int f940b = 2048;

    /* renamed from: c */
    private static int f941c = 8;

    @Retention(RetentionPolicy.SOURCE)
    public @interface LogLevel {
    }

    public static void setLogcatLevel(int i) {
        f941c = i;
    }

    /* renamed from: v */
    public static void m1082v(String str, String str2) {
        m1075a(2, str, str2, (Throwable) null);
    }

    /* renamed from: v */
    public static void m1083v(String str, String str2, Throwable th) {
        m1075a(2, str, str2, th);
    }

    /* renamed from: d */
    public static void m1076d(String str, String str2) {
        m1075a(3, str, str2, (Throwable) null);
    }

    /* renamed from: d */
    public static void m1077d(String str, String str2, Throwable th) {
        m1075a(3, str, str2, th);
    }

    /* renamed from: i */
    public static void m1080i(String str, String str2) {
        m1075a(4, str, str2, (Throwable) null);
    }

    /* renamed from: i */
    public static void m1081i(String str, String str2, Throwable th) {
        m1075a(4, str, str2, th);
    }

    /* renamed from: w */
    public static void m1084w(String str, String str2) {
        m1075a(5, str, str2, (Throwable) null);
    }

    /* renamed from: w */
    public static void m1085w(String str, String str2, Throwable th) {
        m1075a(5, str, str2, th);
    }

    /* renamed from: e */
    public static void m1078e(String str, String str2) {
        m1075a(6, str, str2, (Throwable) null);
    }

    /* renamed from: e */
    public static void m1079e(String str, String str2, Throwable th) {
        m1075a(6, str, str2, th);
    }

    public static void sensitiveLog(String str, String str2) {
        if (f941c == -1) {
            m1075a(-1, str, str2, (Throwable) null);
            return;
        }
        throw new SecurityException("Sensitive information should never be logged. Remove before committing.");
    }

    /* renamed from: a */
    private static void m1075a(int i, String str, String str2, Throwable th) {
        String str3;
        if (f941c <= i) {
            if (str2.length() > 2048) {
                int length = str2.length() / 2048;
                for (int i2 = 0; i2 <= length; i2++) {
                    if (i2 != length) {
                        str3 = str2.substring(i2 * 2048, (i2 + 1) * 2048);
                    } else {
                        str3 = str2.substring(i2 * 2048);
                    }
                    m1075a(i, str + "-" + i2, str3, th);
                }
            } else if (i != -1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i != 5) {
                                if (i == 6) {
                                    if (th == null) {
                                        SystemUtils.log(6, str, str2, (Throwable) null, "com.adyen.checkout.core.log.Logger", 164);
                                    } else {
                                        SystemUtils.log(6, str, str2, th, "com.adyen.checkout.core.log.Logger", 166);
                                    }
                                }
                            } else if (th == null) {
                                SystemUtils.log(5, str, str2, (Throwable) null, "com.adyen.checkout.core.log.Logger", 157);
                            } else {
                                SystemUtils.log(5, str, str2, th, "com.adyen.checkout.core.log.Logger", 159);
                            }
                        } else if (th == null) {
                            SystemUtils.log(4, str, str2, (Throwable) null, "com.adyen.checkout.core.log.Logger", 150);
                        } else {
                            SystemUtils.log(4, str, str2, th, "com.adyen.checkout.core.log.Logger", 152);
                        }
                    } else if (th == null) {
                        SystemUtils.log(3, str, str2, (Throwable) null, "com.adyen.checkout.core.log.Logger", 143);
                    } else {
                        SystemUtils.log(3, str, str2, th, "com.adyen.checkout.core.log.Logger", 145);
                    }
                } else if (th == null) {
                    SystemUtils.log(2, str, str2, (Throwable) null, "com.adyen.checkout.core.log.Logger", 136);
                } else {
                    SystemUtils.log(2, str, str2, th, "com.adyen.checkout.core.log.Logger", 138);
                }
            } else if (th == null) {
                Log.wtf(str, str2);
            } else {
                Log.wtf(str, str2, th);
            }
        }
    }

    private Logger() {
        throw new NoConstructorException();
    }
}
