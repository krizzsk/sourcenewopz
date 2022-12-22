package com.didichuxing.mas.sdk.quality.collect.netmonitor;

import android.content.Context;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.telephony.gsm.GsmCellLocation;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.mas.sdk.quality.report.utils.OLog;

public class HeartbeatInfoCollector {

    /* renamed from: a */
    private static final String f48158a = "HeartbeatInfoCollector";

    /* renamed from: b */
    private static Context f48159b;

    /* renamed from: c */
    private static LocationManager f48160c;

    /* renamed from: d */
    private static ConnectivityManager f48161d;

    /* renamed from: e */
    private static NetworkInfo f48162e;

    /* renamed from: f */
    private static TelephonyManager f48163f;

    public static void init(Context context) {
        f48159b = context;
        try {
            f48160c = (LocationManager) context.getSystemService("location");
            ConnectivityManager connectivityManager = (ConnectivityManager) f48159b.getSystemService("connectivity");
            f48161d = connectivityManager;
            if (connectivityManager != null) {
                f48162e = SystemUtils.getActiveNetworkInfo(connectivityManager);
            }
            f48163f = (TelephonyManager) f48159b.getSystemService("phone");
        } catch (Throwable th) {
            SystemUtils.log(6, f48158a, "init err:" + th.toString(), (Throwable) null, "com.didichuxing.mas.sdk.quality.collect.netmonitor.HeartbeatInfoCollector", 41);
        }
    }

    public static int getNetworkType() {
        try {
            if (f48162e == null || !f48162e.isConnected()) {
                return -1;
            }
            int type = f48162e.getType();
            int subtype = f48162e.getSubtype();
            if (1 == type) {
                return 1;
            }
            if (type == 0) {
                switch (subtype) {
                    case 1:
                    case 2:
                    case 4:
                    case 7:
                    case 11:
                        return 2;
                    case 3:
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    case 10:
                    case 12:
                    case 14:
                    case 15:
                        return 3;
                    case 13:
                        return 4;
                    default:
                        return -1;
                }
            }
            return -1;
        } catch (Throwable th) {
            OLog.m34425w("getNetworkType fail,", th);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0038 A[Catch:{ all -> 0x0059 }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0039 A[Catch:{ all -> 0x0059 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int getCarrier() {
        /*
            android.telephony.TelephonyManager r0 = f48163f
            r1 = -1
            if (r0 == 0) goto L_0x0069
            java.lang.String r0 = r0.getNetworkOperatorName()     // Catch:{ all -> 0x0059 }
            java.lang.String r2 = android.os.Build.PRODUCT     // Catch:{ all -> 0x0059 }
            java.lang.String r3 = "google_sdk"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x0059 }
            r3 = 1
            if (r2 != 0) goto L_0x0035
            java.lang.String r2 = android.os.Build.PRODUCT     // Catch:{ all -> 0x0059 }
            java.lang.String r4 = "sdk"
            boolean r2 = r2.equals(r4)     // Catch:{ all -> 0x0059 }
            if (r2 != 0) goto L_0x0035
            java.lang.String r2 = android.os.Build.PRODUCT     // Catch:{ all -> 0x0059 }
            java.lang.String r4 = "sdk_x86"
            boolean r2 = r2.equals(r4)     // Catch:{ all -> 0x0059 }
            if (r2 != 0) goto L_0x0035
            java.lang.String r2 = android.os.Build.FINGERPRINT     // Catch:{ all -> 0x0059 }
            java.lang.String r4 = "generic"
            boolean r2 = r2.startsWith(r4)     // Catch:{ all -> 0x0059 }
            if (r2 == 0) goto L_0x0033
            goto L_0x0035
        L_0x0033:
            r2 = 0
            goto L_0x0036
        L_0x0035:
            r2 = 1
        L_0x0036:
            if (r2 == 0) goto L_0x0039
            return r1
        L_0x0039:
            java.lang.String r2 = "中国移动"
            boolean r2 = r0.contains(r2)     // Catch:{ all -> 0x0059 }
            if (r2 == 0) goto L_0x0043
            return r3
        L_0x0043:
            java.lang.String r2 = "中国电信"
            boolean r2 = r0.contains(r2)     // Catch:{ all -> 0x0059 }
            if (r2 == 0) goto L_0x004e
            r0 = 2
            return r0
        L_0x004e:
            java.lang.String r2 = "中国联通"
            boolean r0 = r0.contains(r2)     // Catch:{ all -> 0x0059 }
            if (r0 == 0) goto L_0x0069
            r0 = 3
            return r0
        L_0x0059:
            r0 = move-exception
            java.lang.String r4 = r0.toString()
            r2 = 6
            r5 = 0
            r7 = 158(0x9e, float:2.21E-43)
            java.lang.String r3 = "HeartbeatInfoCollector"
            java.lang.String r6 = "com.didichuxing.mas.sdk.quality.collect.netmonitor.HeartbeatInfoCollector"
            com.didi.sdk.apm.SystemUtils.log(r2, r3, r4, r5, r6, r7)
        L_0x0069:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.mas.sdk.quality.collect.netmonitor.HeartbeatInfoCollector.getCarrier():int");
    }

    public static GSMCellLocationInfo getGSMCellLocationInfo() {
        int i;
        int i2;
        int i3 = 0;
        if (Build.VERSION.SDK_INT >= 23) {
            try {
                GsmCellLocation gsmCellLocation = (GsmCellLocation) f48163f.getCellLocation();
                if (gsmCellLocation != null) {
                    i2 = gsmCellLocation.getLac();
                    try {
                        i = gsmCellLocation.getCid();
                        i3 = i2;
                    } catch (Exception e) {
                        e = e;
                        SystemUtils.log(6, f48158a, "get cellLocation err:" + e.toString(), (Throwable) null, "com.didichuxing.mas.sdk.quality.collect.netmonitor.HeartbeatInfoCollector", 185);
                        i3 = i2;
                        i = 0;
                        return new GSMCellLocationInfo(i3, i);
                    }
                    return new GSMCellLocationInfo(i3, i);
                }
            } catch (Exception e2) {
                e = e2;
                i2 = 0;
                SystemUtils.log(6, f48158a, "get cellLocation err:" + e.toString(), (Throwable) null, "com.didichuxing.mas.sdk.quality.collect.netmonitor.HeartbeatInfoCollector", 185);
                i3 = i2;
                i = 0;
                return new GSMCellLocationInfo(i3, i);
            }
        }
        i = 0;
        return new GSMCellLocationInfo(i3, i);
    }

    public static String getPackageName() {
        return f48159b.getPackageName();
    }

    public static class GSMCellLocationInfo {
        private int cellid;
        private int lac;

        private GSMCellLocationInfo(int i, int i2) {
            this.lac = i;
            this.cellid = i2;
        }

        public int getLac() {
            return this.lac;
        }

        public int getCellid() {
            return this.cellid;
        }
    }
}
