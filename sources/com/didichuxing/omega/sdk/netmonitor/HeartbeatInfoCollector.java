package com.didichuxing.omega.sdk.netmonitor;

import android.content.Context;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.telephony.gsm.GsmCellLocation;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.omega.sdk.common.utils.OLog;

public class HeartbeatInfoCollector {
    private static final String TAG = "HeartbeatInfoCollector";
    private static ConnectivityManager mConnectivityManager;
    private static Context mContext;
    private static LocationManager mLocationManager;
    private static NetworkInfo mNetworkInfo;
    private static TelephonyManager mTelephonyManager;

    public static void init(Context context) {
        mContext = context;
        try {
            mLocationManager = (LocationManager) context.getSystemService("location");
            ConnectivityManager connectivityManager = (ConnectivityManager) mContext.getSystemService("connectivity");
            mConnectivityManager = connectivityManager;
            if (connectivityManager != null) {
                mNetworkInfo = SystemUtils.getActiveNetworkInfo(connectivityManager);
            }
            mTelephonyManager = (TelephonyManager) mContext.getSystemService("phone");
        } catch (Throwable th) {
            SystemUtils.log(6, TAG, "init err:" + th.toString(), (Throwable) null, "com.didichuxing.omega.sdk.netmonitor.HeartbeatInfoCollector", 44);
        }
    }

    public static int getNetworkType() {
        try {
            if (mNetworkInfo == null || !mNetworkInfo.isConnected()) {
                return -1;
            }
            int type = mNetworkInfo.getType();
            int subtype = mNetworkInfo.getSubtype();
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
            OLog.m34770w("getNetworkType fail,", th);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0038 A[Catch:{ all -> 0x0056 }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0039 A[Catch:{ all -> 0x0056 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int getCarrier() {
        /*
            android.telephony.TelephonyManager r0 = mTelephonyManager
            r1 = -1
            if (r0 == 0) goto L_0x0066
            java.lang.String r0 = r0.getNetworkOperatorName()     // Catch:{ all -> 0x0056 }
            java.lang.String r2 = android.os.Build.PRODUCT     // Catch:{ all -> 0x0056 }
            java.lang.String r3 = "google_sdk"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x0056 }
            r3 = 1
            if (r2 != 0) goto L_0x0035
            java.lang.String r2 = android.os.Build.PRODUCT     // Catch:{ all -> 0x0056 }
            java.lang.String r4 = "sdk"
            boolean r2 = r2.equals(r4)     // Catch:{ all -> 0x0056 }
            if (r2 != 0) goto L_0x0035
            java.lang.String r2 = android.os.Build.PRODUCT     // Catch:{ all -> 0x0056 }
            java.lang.String r4 = "sdk_x86"
            boolean r2 = r2.equals(r4)     // Catch:{ all -> 0x0056 }
            if (r2 != 0) goto L_0x0035
            java.lang.String r2 = android.os.Build.FINGERPRINT     // Catch:{ all -> 0x0056 }
            java.lang.String r4 = "generic"
            boolean r2 = r2.startsWith(r4)     // Catch:{ all -> 0x0056 }
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
            boolean r2 = r0.contains(r2)     // Catch:{ all -> 0x0056 }
            if (r2 == 0) goto L_0x0042
            return r3
        L_0x0042:
            java.lang.String r2 = "中国电信"
            boolean r2 = r0.contains(r2)     // Catch:{ all -> 0x0056 }
            if (r2 == 0) goto L_0x004c
            r0 = 2
            return r0
        L_0x004c:
            java.lang.String r2 = "中国联通"
            boolean r0 = r0.contains(r2)     // Catch:{ all -> 0x0056 }
            if (r0 == 0) goto L_0x0066
            r0 = 3
            return r0
        L_0x0056:
            r0 = move-exception
            java.lang.String r4 = r0.toString()
            r2 = 6
            r5 = 0
            r7 = 156(0x9c, float:2.19E-43)
            java.lang.String r3 = "HeartbeatInfoCollector"
            java.lang.String r6 = "com.didichuxing.omega.sdk.netmonitor.HeartbeatInfoCollector"
            com.didi.sdk.apm.SystemUtils.log(r2, r3, r4, r5, r6, r7)
        L_0x0066:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.omega.sdk.netmonitor.HeartbeatInfoCollector.getCarrier():int");
    }

    public static GSMCellLocationInfo getGSMCellLocationInfo() {
        int i;
        int i2;
        int i3 = 0;
        if (Build.VERSION.SDK_INT >= 23) {
            try {
                GsmCellLocation gsmCellLocation = (GsmCellLocation) mTelephonyManager.getCellLocation();
                if (gsmCellLocation != null) {
                    i2 = gsmCellLocation.getLac();
                    try {
                        i = gsmCellLocation.getCid();
                        i3 = i2;
                    } catch (Exception e) {
                        e = e;
                        SystemUtils.log(6, TAG, "get cellLocation err:" + e.toString(), (Throwable) null, "com.didichuxing.omega.sdk.netmonitor.HeartbeatInfoCollector", 182);
                        i3 = i2;
                        i = 0;
                        return new GSMCellLocationInfo(i3, i);
                    }
                    return new GSMCellLocationInfo(i3, i);
                }
            } catch (Exception e2) {
                e = e2;
                i2 = 0;
                SystemUtils.log(6, TAG, "get cellLocation err:" + e.toString(), (Throwable) null, "com.didichuxing.omega.sdk.netmonitor.HeartbeatInfoCollector", 182);
                i3 = i2;
                i = 0;
                return new GSMCellLocationInfo(i3, i);
            }
        }
        i = 0;
        return new GSMCellLocationInfo(i3, i);
    }

    public static String getPackageName() {
        return mContext.getPackageName();
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
