package com.didi.sdk.connectivity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.didi.sdk.apm.SystemUtils;
import java.util.regex.Pattern;

/* renamed from: com.didi.sdk.connectivity.f */
/* compiled from: Utils */
class C12170f {

    /* renamed from: a */
    public static final int f35767a = 0;

    /* renamed from: b */
    public static final int f35768b = 1;

    /* renamed from: c */
    public static final int f35769c = 2;

    /* renamed from: d */
    public static final int f35770d = 3;

    /* renamed from: e */
    public static final int f35771e = 4;

    /* renamed from: f */
    public static final int f35772f = 5;

    C12170f() {
    }

    /* renamed from: a */
    static int m25335a(Context context) {
        NetworkInfo activeNetworkInfo;
        NetworkInfo.State state;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (!(connectivityManager == null || (activeNetworkInfo = SystemUtils.getActiveNetworkInfo(connectivityManager)) == null)) {
                if (activeNetworkInfo.isAvailable()) {
                    NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
                    if (networkInfo == null || networkInfo.getState() == null || ((state = networkInfo.getState()) != NetworkInfo.State.CONNECTED && state != NetworkInfo.State.CONNECTING)) {
                        NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(0);
                        if (!(networkInfo2 == null || networkInfo2.getState() == null)) {
                            NetworkInfo.State state2 = networkInfo2.getState();
                            String subtypeName = activeNetworkInfo.getSubtypeName();
                            if (state2 == NetworkInfo.State.CONNECTED || state2 == NetworkInfo.State.CONNECTING) {
                                switch (networkInfo2.getSubtype()) {
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
                                        if ("TD-SCDMA".equalsIgnoreCase(subtypeName) || "WCDMA".equalsIgnoreCase(subtypeName) || "CDMA2000".equalsIgnoreCase(subtypeName)) {
                                            return 5;
                                        }
                                        break;
                                }
                            }
                        }
                    } else {
                        return 1;
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return 0;
    }

    /* renamed from: b */
    static String m25337b(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getApplicationContext().getSystemService("phone");
        if (telephonyManager == null) {
            return "-1";
        }
        return telephonyManager.getSimOperator();
    }

    /* renamed from: c */
    static String m25338c(Context context) {
        WifiInfo connectionInfo;
        try {
            WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi");
            if (wifiManager == null || (connectionInfo = wifiManager.getConnectionInfo()) == null) {
                return "unknown-ssid";
            }
            return connectionInfo.getSSID();
        } catch (Exception unused) {
            return "unknown-ssid";
        }
    }

    /* renamed from: d */
    static boolean m25339d(Context context) {
        try {
            NetworkInfo activeNetworkInfo = SystemUtils.getActiveNetworkInfo((ConnectivityManager) context.getSystemService("connectivity"));
            if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                return false;
            }
            return true;
        } catch (Exception unused) {
        }
    }

    /* renamed from: a */
    static boolean m25336a(String str) {
        if (!TextUtils.isEmpty(str) && str.length() >= 7 && str.length() <= 15) {
            try {
                return Pattern.compile("(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)\\.(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)\\.(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)\\.(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)").matcher(str.trim()).find();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return false;
    }
}
