package com.didi.payment.base.utils;

import android.util.Log;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.logging.LoggerFactory;
import com.didichuxing.bigdata.p173dp.locsdk.Const;
import java.util.Map;

public class PayLogUtils {

    /* renamed from: a */
    private static final boolean f30010a = true;

    /* renamed from: b */
    private static boolean f30011b = false;

    /* renamed from: c */
    private static String f30012c = "PayLog";

    /* renamed from: a */
    private static void m21012a(int i, String str, String str2) {
    }

    /* renamed from: v */
    public static void m21020v(String str, String str2, String str3) {
        String format = String.format("[%s] %s", new Object[]{str2, str3});
        m21012a(2, str, format);
        LoggerFactory.getLogger(f30012c).trace("[%s] %s", str, format);
    }

    /* renamed from: d */
    public static void m21013d(String str, String str2) {
        m21014d(str, "", str2);
    }

    /* renamed from: d */
    public static void m21014d(String str, String str2, String str3) {
        String format = String.format("[%s] %s", new Object[]{str2, str3});
        m21012a(3, str, format);
        LoggerFactory.getLogger(f30012c).debug("[%s] %s", str, format);
    }

    /* renamed from: i */
    public static void m21019i(String str, String str2, String str3) {
        String format = String.format("[%s] %s", new Object[]{str2, str3});
        m21012a(4, str, format);
        LoggerFactory.getLogger(f30012c).info("[%s] %s", str, format);
    }

    /* renamed from: w */
    public static void m21021w(String str, String str2, String str3) {
        String format = String.format("[%s] %s", new Object[]{str2, str3});
        m21012a(5, str, format);
        LoggerFactory.getLogger(f30012c).warn("[%s] %s", str, format);
    }

    /* renamed from: e */
    public static void m21016e(String str, String str2) {
        m21017e(str, "", str2);
    }

    /* renamed from: e */
    public static void m21017e(String str, String str2, String str3) {
        String format = String.format("[%s] %s", new Object[]{str2, str3});
        m21012a(6, str, format);
        LoggerFactory.getLogger(f30012c).error("[%s] %s", str, format);
    }

    /* renamed from: e */
    public static void m21018e(String str, String str2, String str3, Throwable th) {
        String format = String.format("[%s] %s %s", new Object[]{str2, str3, Log.getStackTraceString(th)});
        m21012a(6, str, format);
        LoggerFactory.getLogger(f30012c).error("[%s] %s", str, format);
    }

    /* renamed from: d */
    public static void m21015d(String str, Map<String, Object> map) {
        StringBuilder sb = new StringBuilder();
        sb.append(Const.joLeft);
        if (map != null && !map.isEmpty()) {
            for (Map.Entry next : map.entrySet()) {
                Object key = next.getKey();
                Object value = next.getValue();
                sb.append(key);
                sb.append(":");
                sb.append(value);
                sb.append(",");
            }
            sb.deleteCharAt(sb.length() - 1);
        }
        sb.append("}");
        String sb2 = sb.toString();
        m21012a(3, str, sb2);
        LoggerFactory.getLogger(f30012c).debug("[%s] %s", str, sb2);
    }

    public static void setDebug(boolean z) {
        String str = f30012c;
        SystemUtils.log(4, str, "set debug to " + z, (Throwable) null, "com.didi.payment.base.utils.PayLogUtils", 113);
        f30011b = z;
    }
}
