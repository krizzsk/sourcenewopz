package com.didi.dynamic.manager.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.didi.sdk.apm.SystemUtils;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class NetworkUtil {
    public static final int NET_TYPE_2G = 2;
    public static final int NET_TYPE_3G = 3;
    public static final int NET_TYPE_4G = 5;
    public static final int NET_TYPE_MOBILE = 4;
    public static final int NET_TYPE_NONE = -1;
    public static final int NET_TYPE_WIFI = 1;

    /* renamed from: a */
    private static final String f19383a = "DM.NetworkUtil";

    /* renamed from: b */
    private static final boolean f19384b = false;

    /* renamed from: c */
    private static final int f19385c = 6;

    /* renamed from: d */
    private static final int f19386d = 9;

    /* renamed from: e */
    private static final int f19387e = 2;

    /* renamed from: f */
    private static final int f19388f = 7;

    /* renamed from: g */
    private static final int f19389g = 12;

    /* renamed from: h */
    private static final int f19390h = 13;

    /* renamed from: i */
    private static final int f19391i = 14;

    /* renamed from: j */
    private static final int f19392j = 15;

    /* renamed from: k */
    private static ConnectivityManager f19393k = null;

    /* renamed from: l */
    private static volatile int f19394l = -1;

    /* renamed from: a */
    private static ConnectivityManager m14511a(Context context) {
        if (f19393k == null) {
            f19393k = (ConnectivityManager) context.getSystemService("connectivity");
        }
        return f19393k;
    }

    public static int getNetworkType(Context context) {
        ConnectivityManager a = m14511a(context);
        if (a == null) {
            f19394l = -1;
            return -1;
        }
        NetworkInfo networkInfo = null;
        try {
            networkInfo = SystemUtils.getActiveNetworkInfo(a);
        } catch (Exception unused) {
        }
        if (networkInfo != null) {
            int type = networkInfo.getType();
            int subtype = networkInfo.getSubtype();
            if (type == 1 || type == 6 || type == 9) {
                f19394l = 1;
                return 1;
            } else if (type == 0 || (type == 7 && subtype > 0)) {
                if (subtype == 3 || subtype == 5 || subtype == 6 || subtype == 8 || subtype == 9 || subtype == 10 || subtype == 12 || subtype == 14 || subtype == 15) {
                    f19394l = 3;
                    return 3;
                } else if (subtype == 13) {
                    f19394l = 5;
                    return 5;
                } else {
                    f19394l = 2;
                    return 2;
                }
            } else if (type == 2 || type == 7) {
                f19394l = -1;
                return -1;
            } else {
                f19394l = 2;
                return 2;
            }
        } else {
            f19394l = -1;
            return -1;
        }
    }

    public static int getSimpleNetworkType(Context context) {
        ConnectivityManager a = m14511a(context);
        if (a == null) {
            f19394l = -1;
            return -1;
        }
        NetworkInfo networkInfo = null;
        try {
            networkInfo = SystemUtils.getActiveNetworkInfo(a);
        } catch (Exception unused) {
        }
        if (networkInfo != null) {
            int type = networkInfo.getType();
            if (type == 1 || type == 6 || type == 9) {
                f19394l = 1;
                return 1;
            } else if (type == 0) {
                f19394l = 4;
                return 4;
            } else if (type == 2 || type == 7) {
                f19394l = -1;
                return -1;
            } else {
                f19394l = 4;
                return 4;
            }
        } else {
            f19394l = -1;
            return -1;
        }
    }

    public static boolean isNetworkAvaialble(Context context) {
        ConnectivityManager a = m14511a(context);
        if (a == null) {
            return false;
        }
        NetworkInfo networkInfo = null;
        try {
            networkInfo = SystemUtils.getActiveNetworkInfo(a);
        } catch (Exception e) {
            Log.m14494w(f19383a, (Throwable) e);
        }
        if (networkInfo == null || !networkInfo.isConnected()) {
            return false;
        }
        return true;
    }

    /* renamed from: b */
    private static String m14512b(Context context) {
        NetworkInfo networkInfo;
        ConnectivityManager a = m14511a(context);
        if (a == null) {
            return null;
        }
        try {
            networkInfo = SystemUtils.getActiveNetworkInfo(a);
        } catch (Exception unused) {
            networkInfo = null;
        }
        if (networkInfo != null && networkInfo.isConnected()) {
            try {
                Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
                while (networkInterfaces.hasMoreElements()) {
                    Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                    while (true) {
                        if (inetAddresses.hasMoreElements()) {
                            InetAddress nextElement = inetAddresses.nextElement();
                            String hostAddress = nextElement.getHostAddress();
                            if (!nextElement.isLoopbackAddress() && !TextUtils.isEmpty(hostAddress)) {
                                return hostAddress;
                            }
                        }
                    }
                }
            } catch (SocketException e) {
                Log.m14492w(f19383a, "Failed to get network IP with exception: " + e);
            }
        }
        return null;
    }

    /* renamed from: c */
    private static boolean m14513c(Context context) {
        ConnectivityManager a = m14511a(context);
        if (a == null) {
            return false;
        }
        NetworkInfo networkInfo = null;
        try {
            networkInfo = SystemUtils.getActiveNetworkInfo(a);
        } catch (Exception unused) {
        }
        if (networkInfo == null || networkInfo.getType() != 0) {
            return false;
        }
        return true;
    }

    public static boolean isNetworkWifi(Context context) {
        return getSimpleNetworkType(context) == 1;
    }

    public static int getLastNetworkType() {
        return f19394l;
    }
}
