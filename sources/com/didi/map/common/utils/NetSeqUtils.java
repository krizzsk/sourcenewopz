package com.didi.map.common.utils;

import com.didi.hawaii.utils.Md5Util;
import java.util.concurrent.atomic.AtomicInteger;

public final class NetSeqUtils {

    /* renamed from: a */
    private static final int f24685a = 10;

    /* renamed from: b */
    private static String f24686b;

    /* renamed from: c */
    private static boolean f24687c;

    /* renamed from: d */
    private static AtomicInteger f24688d;

    private NetSeqUtils() {
    }

    public static void init() {
        f24686b = m17571a();
        f24688d = new AtomicInteger(0);
        f24687c = true;
    }

    public static boolean isInited() {
        return f24687c;
    }

    /* renamed from: a */
    private static String m17571a() {
        String obtainIMei = SystemUtil.obtainIMei();
        StringBuilder sb = new StringBuilder(obtainIMei.length() + 20);
        sb.append(obtainIMei);
        String l = Long.toString(System.currentTimeMillis());
        int length = l.length();
        sb.append(l.substring(length - 10, length));
        sb.append((int) (((Math.random() * 9.0d) + 1.0d) * 1.0E9d));
        return Md5Util.getMD5(sb.toString());
    }

    public static String getSessionId() {
        return f24686b;
    }

    public static String getSeqNumber() {
        if (f24688d == null) {
            return "";
        }
        return f24688d.incrementAndGet() + "";
    }
}
