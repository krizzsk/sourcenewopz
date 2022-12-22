package com.appsflyer.internal;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.appsflyer.AFLogger;
import com.didi.sdk.apm.SystemUtils;

/* renamed from: com.appsflyer.internal.s */
public final class C1706s {

    /* renamed from: com.appsflyer.internal.s$d */
    public static final class C1708d {

        /* renamed from: ι */
        public static final C1706s f2023 = new C1706s();
    }

    C1706s() {
    }

    /* renamed from: ɩ */
    private static boolean m1688(NetworkInfo networkInfo) {
        return networkInfo != null && networkInfo.isConnectedOrConnecting();
    }

    /* renamed from: com.appsflyer.internal.s$a */
    public static final class C1707a {

        /* renamed from: ı */
        public final String f2020;

        /* renamed from: ɩ */
        public final String f2021;

        /* renamed from: ι */
        public final String f2022;

        C1707a(String str, String str2, String str3) {
            this.f2020 = str;
            this.f2021 = str2;
            this.f2022 = str3;
        }
    }

    /* renamed from: ǃ */
    public static C1707a m1687(Context context) {
        String str;
        String str2;
        String str3;
        String str4 = "unknown";
        String str5 = null;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null) {
                int i = 0;
                if (21 <= Build.VERSION.SDK_INT) {
                    Network[] allNetworks = connectivityManager.getAllNetworks();
                    int length = allNetworks.length;
                    while (true) {
                        if (i >= length) {
                            break;
                        }
                        NetworkInfo networkInfo = connectivityManager.getNetworkInfo(allNetworks[i]);
                        if (!m1688(networkInfo)) {
                            i++;
                        } else if (1 != networkInfo.getType()) {
                            if (networkInfo.getType() == 0) {
                            }
                        }
                    }
                } else if (!m1688(connectivityManager.getNetworkInfo(1))) {
                    if (!m1688(connectivityManager.getNetworkInfo(0))) {
                        NetworkInfo activeNetworkInfo = SystemUtils.getActiveNetworkInfo(connectivityManager);
                        if (m1688(activeNetworkInfo)) {
                            if (1 != activeNetworkInfo.getType()) {
                                if (activeNetworkInfo.getType() == 0) {
                                }
                            }
                        }
                    }
                    str4 = "MOBILE";
                }
                str4 = "WIFI";
            }
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            str = telephonyManager.getSimOperatorName();
            try {
                str2 = telephonyManager.getNetworkOperatorName();
                if ((str2 == null || str2.isEmpty()) && 2 == telephonyManager.getPhoneType()) {
                    str2 = "CDMA";
                }
            } catch (Throwable th) {
                th = th;
                String str6 = str;
                str3 = null;
                str5 = str6;
                AFLogger.afErrorLog("Exception while collecting network info. ", th);
                String str7 = str3;
                str = str5;
                str2 = str7;
                return new C1707a(str4, str2, str);
            }
        } catch (Throwable th2) {
            th = th2;
            str3 = null;
            AFLogger.afErrorLog("Exception while collecting network info. ", th);
            String str72 = str3;
            str = str5;
            str2 = str72;
            return new C1707a(str4, str2, str);
        }
        return new C1707a(str4, str2, str);
    }
}
