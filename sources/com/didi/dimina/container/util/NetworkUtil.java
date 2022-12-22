package com.didi.dimina.container.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.didi.sdk.apm.SystemUtils;

public class NetworkUtil {
    public static final int NET_TYPE_2G = 2;
    public static final int NET_TYPE_3G = 3;
    public static final int NET_TYPE_4G = 5;
    public static final int NET_TYPE_5G = 6;
    public static final int NET_TYPE_MOBILE = 4;
    public static final int NET_TYPE_NONE = -1;
    public static final int NET_TYPE_UNKNOWN = -2;
    public static final int NET_TYPE_WIFI = 1;

    /* renamed from: a */
    private static final String f17951a = "NetworkUtil";

    /* renamed from: b */
    private static final boolean f17952b = false;

    /* renamed from: c */
    private static final int f17953c = 6;

    /* renamed from: d */
    private static final int f17954d = 9;

    /* renamed from: e */
    private static final int f17955e = 2;

    /* renamed from: f */
    private static final int f17956f = 7;

    /* renamed from: g */
    private static ConnectivityManager f17957g;

    public static class WsgNetWorkType {
        public static final String NETWORK_2G = "2G";
        public static final String NETWORK_3G = "3G";
        public static final String NETWORK_4G = "4G";
        public static final String NETWORK_5G = "5G";
        public static final String NETWORK_UNKNOWN = "UNKNOWN";
        public static final String NETWORK_WIFI = "WIFI";
    }

    /* renamed from: a */
    private static ConnectivityManager m13419a(Context context) {
        if (f17957g == null) {
            try {
                f17957g = (ConnectivityManager) context.getSystemService("connectivity");
            } catch (Exception unused) {
                f17957g = null;
            }
        }
        return f17957g;
    }

    public static int getNetworkType(Context context) {
        NetworkInfo activeNetworkInfo = SystemUtils.getActiveNetworkInfo((ConnectivityManager) context.getSystemService("connectivity"));
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            String typeName = activeNetworkInfo.getTypeName();
            if (typeName.equalsIgnoreCase("WIFI")) {
                return 1;
            }
            if (typeName.equalsIgnoreCase("MOBILE")) {
                return m13420b(context);
            }
        }
        return -1;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0060 A[RETURN] */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int m13420b(android.content.Context r5) {
        /*
            com.didi.dimina.container.Dimina$Config r0 = com.didi.dimina.container.Dimina.getConfig()
            com.didi.dimina.container.Dimina$AdapterConfig r0 = r0.getAdapterConfig()
            com.didi.dimina.container.service.WsgService r0 = r0.getWsgService()
            java.lang.String r5 = r0.getNetworkType(r5)
            int r0 = r5.hashCode()
            r1 = 1621(0x655, float:2.272E-42)
            r2 = 1
            r3 = 3
            r4 = 2
            if (r0 == r1) goto L_0x0046
            r1 = 1652(0x674, float:2.315E-42)
            if (r0 == r1) goto L_0x003c
            r1 = 1683(0x693, float:2.358E-42)
            if (r0 == r1) goto L_0x0032
            r1 = 1714(0x6b2, float:2.402E-42)
            if (r0 == r1) goto L_0x0028
            goto L_0x0050
        L_0x0028:
            java.lang.String r0 = "5G"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x0050
            r5 = 3
            goto L_0x0051
        L_0x0032:
            java.lang.String r0 = "4G"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x0050
            r5 = 2
            goto L_0x0051
        L_0x003c:
            java.lang.String r0 = "3G"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x0050
            r5 = 1
            goto L_0x0051
        L_0x0046:
            java.lang.String r0 = "2G"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x0050
            r5 = 0
            goto L_0x0051
        L_0x0050:
            r5 = -1
        L_0x0051:
            if (r5 == 0) goto L_0x0060
            if (r5 == r2) goto L_0x005f
            if (r5 == r4) goto L_0x005d
            if (r5 == r3) goto L_0x005b
            r5 = -2
            return r5
        L_0x005b:
            r5 = 6
            return r5
        L_0x005d:
            r5 = 5
            return r5
        L_0x005f:
            return r3
        L_0x0060:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.dimina.container.util.NetworkUtil.m13420b(android.content.Context):int");
    }

    public static int getSimpleNetworkType(Context context) {
        ConnectivityManager a = m13419a(context);
        if (a == null) {
            return -1;
        }
        NetworkInfo networkInfo = null;
        try {
            networkInfo = SystemUtils.getActiveNetworkInfo(a);
        } catch (Exception unused) {
        }
        if (networkInfo == null) {
            return -1;
        }
        int type = networkInfo.getType();
        if (type == 1 || type == 6 || type == 9) {
            return 1;
        }
        if (type == 0) {
            return 4;
        }
        if (type == 2 || type == 7) {
            return -1;
        }
        return 4;
    }

    public static boolean isAvailable(Context context) {
        NetworkInfo activeNetworkInfo = SystemUtils.getActiveNetworkInfo((ConnectivityManager) context.getSystemService("connectivity"));
        return activeNetworkInfo != null && activeNetworkInfo.isAvailable() && activeNetworkInfo.isConnected();
    }
}
