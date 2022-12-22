package com.didichuxing.dfbasesdk.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.didi.dimina.container.bridge.NetworkSubJSBridge;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.dfbasesdk.AppContextHolder;
import com.didichuxing.security.safecollector.WsgSecInfo;

public class NetworkUtils {
    public static boolean isWifi(Context context) {
        NetworkInfo activeNetworkInfo = SystemUtils.getActiveNetworkInfo((ConnectivityManager) context.getSystemService("connectivity"));
        if (activeNetworkInfo == null || activeNetworkInfo.getType() != 1) {
            return false;
        }
        return true;
    }

    public static boolean is4G(Context context) {
        NetworkInfo activeNetworkInfo = SystemUtils.getActiveNetworkInfo((ConnectivityManager) context.getSystemService("connectivity"));
        if (activeNetworkInfo == null || activeNetworkInfo.getType() != 0) {
            return false;
        }
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if ((telephonyManager != null ? telephonyManager.getNetworkType() : 0) == 13) {
            return true;
        }
        return false;
    }

    public static boolean isNetworkConnected(Context context) {
        NetworkInfo activeNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null || (activeNetworkInfo = SystemUtils.getActiveNetworkInfo(connectivityManager)) == null || !activeNetworkInfo.isConnected()) {
            return false;
        }
        return true;
    }

    @Deprecated
    public static boolean isNetworkOnline() {
        Context appContext = AppContextHolder.getAppContext();
        if (appContext == null) {
            return false;
        }
        return isNetworkConnected(appContext);
    }

    public static NetworkType getNetworkType(Context context) {
        String networkType = WsgSecInfo.networkType(context);
        if (networkType == null) {
            networkType = "unknown";
        }
        char c = 65535;
        int hashCode = networkType.hashCode();
        if (hashCode != 1621) {
            if (hashCode != 1652) {
                if (hashCode != 1683) {
                    if (hashCode != 1714) {
                        if (hashCode == 2664213 && networkType.equals("WIFI")) {
                            c = 0;
                        }
                    } else if (networkType.equals("5G")) {
                        c = 4;
                    }
                } else if (networkType.equals("4G")) {
                    c = 3;
                }
            } else if (networkType.equals("3G")) {
                c = 2;
            }
        } else if (networkType.equals("2G")) {
            c = 1;
        }
        if (c == 0) {
            return NetworkType.NETWORK_WIFI;
        }
        if (c == 1) {
            return NetworkType.NETWORK_2G;
        }
        if (c == 2) {
            return NetworkType.NETWORK_3G;
        }
        if (c == 3) {
            return NetworkType.NETWORK_4G;
        }
        if (c != 4) {
            return NetworkType.NETWORK_NONE;
        }
        return NetworkType.NETWORK_5G;
    }

    public enum NetworkType {
        NETWORK_NONE("none"),
        NETWORK_WIFI("wifi"),
        NETWORK_2G(NetworkSubJSBridge.NetworkType.TYPE_2G),
        NETWORK_3G(NetworkSubJSBridge.NetworkType.TYPE_3G),
        NETWORK_4G(NetworkSubJSBridge.NetworkType.TYPE_4G),
        NETWORK_5G(NetworkSubJSBridge.NetworkType.TYPE_5G),
        NETWORK_MOBILE("mobile");
        
        public final String type;

        private NetworkType(String str) {
            this.type = str;
        }

        public String toString() {
            return "Network type : " + this.type;
        }
    }
}
