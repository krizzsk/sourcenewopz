package com.didi.beatles.p099im.utils;

import android.text.TextUtils;
import android.widget.TextView;
import java.util.Collection;
import java.util.Iterator;

/* renamed from: com.didi.beatles.im.utils.IMTextUtil */
public class IMTextUtil {

    /* renamed from: a */
    private static final String f9795a = "";

    public static boolean isEmpty(Object obj) {
        return obj == null;
    }

    public static boolean equals(String str, String str2) {
        if (isEmpty(str) || isEmpty(str2)) {
            return false;
        }
        return str.trim().equals(str2.trim());
    }

    public static boolean isEmpty(String str) {
        if (str == null) {
            return true;
        }
        String trim = str.trim();
        if (trim.length() == 0 || trim.equals("null")) {
            return true;
        }
        return false;
    }

    public static boolean isEmpty(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

    public static float getTextWidth(TextView textView, String str) {
        if (TextUtils.isEmpty(str)) {
            return 0.0f;
        }
        return textView.getPaint().measureText(str);
    }

    public static int getTextNum(String str) {
        int i = 0;
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        int i2 = 0;
        while (i < str.length()) {
            int i3 = i + 1;
            i2 = str.charAt(i) < 128 ? i2 + 1 : i2 + 2;
            i = i3;
        }
        return i2;
    }

    public static String getExceptionStack(Exception exc) {
        if (exc == null) {
            return "exception == null";
        }
        StringBuilder sb = new StringBuilder();
        StackTraceElement[] stackTrace = exc.getStackTrace();
        if (stackTrace == null || stackTrace.length == 0) {
            return "elements == null";
        }
        for (StackTraceElement stackTraceElement : stackTrace) {
            sb.append(stackTraceElement.toString());
            sb.append("\n");
        }
        return sb.toString();
    }

    public static String getExceptionStr(Exception exc) {
        if (exc == null) {
            return "exception == null";
        }
        return exc.toString() + "\n>>>stack>>>\n" + getExceptionStack(exc);
    }

    public static String join(Iterable<?> iterable, String str) {
        if (iterable == null) {
            return null;
        }
        return join(iterable.iterator(), str);
    }

    public static String join(Iterator<?> it, String str) {
        if (it == null) {
            return null;
        }
        if (!it.hasNext()) {
            return "";
        }
        Object next = it.next();
        if (it.hasNext()) {
            IMStringBuilder of = IMStringBuilder.m6646of();
            if (next != null) {
                of.append((Object) next);
            }
            while (it.hasNext()) {
                if (str != null) {
                    of.append(str);
                }
                Object next2 = it.next();
                if (next2 != null) {
                    of.append((Object) next2);
                }
            }
            return of.toString();
        } else if (next == null) {
            return "";
        } else {
            return next.toString();
        }
    }

    public static String join(Object[] objArr, String str) {
        if (objArr == null) {
            return null;
        }
        return join(objArr, str, 0, objArr.length);
    }

    public static String join(Object[] objArr, String str, int i, int i2) {
        if (objArr == null) {
            return null;
        }
        if (str == null || i2 - i <= 0) {
            str = "";
        }
        IMStringBuilder of = IMStringBuilder.m6646of();
        if (objArr[i] != null) {
            of.append(objArr[i]);
        }
        while (true) {
            i++;
            if (i >= i2) {
                return of.toString();
            }
            of.append(str);
            if (objArr[i] != null) {
                of.append(objArr[i]);
            }
        }
    }
}
