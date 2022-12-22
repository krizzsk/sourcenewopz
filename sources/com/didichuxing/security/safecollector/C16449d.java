package com.didichuxing.security.safecollector;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.BatteryManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.didi.hawaii.mapsdk.gesture.NNGestureClassfy;
import com.didi.sdk.apm.SystemUtils;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Locale;

/* renamed from: com.didichuxing.security.safecollector.d */
/* compiled from: DynamicData */
final class C16449d {

    /* renamed from: a */
    public static final String f49004a = "UNKNOWN";

    /* renamed from: b */
    public static final String f49005b = "WIFI";

    /* renamed from: c */
    public static final String f49006c = "2G";

    /* renamed from: d */
    public static final String f49007d = "3G";

    /* renamed from: e */
    public static final String f49008e = "4G";

    /* renamed from: f */
    public static final String f49009f = "5G";

    /* renamed from: g */
    private static final Object f49010g = new Object();

    /* renamed from: h */
    private static boolean f49011h = false;

    C16449d() {
    }

    /* renamed from: a */
    public static String m35252a(Context context) {
        String str;
        NetworkInfo networkInfo;
        NetworkInfo.State state;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            NetworkInfo activeNetworkInfo = SystemUtils.getActiveNetworkInfo(connectivityManager);
            if (activeNetworkInfo != null && 1 == activeNetworkInfo.getType()) {
                return "WIFI";
            }
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager == null) {
                return "UNKNOWN";
            }
            int networkType = telephonyManager.getNetworkType();
            if (networkType == 0 && (networkInfo = connectivityManager.getNetworkInfo(0)) != null && networkInfo.getState() != null && ((state = networkInfo.getState()) == NetworkInfo.State.CONNECTED || state == NetworkInfo.State.CONNECTING)) {
                networkType = networkInfo.getSubtype();
            }
            if (networkType != 20) {
                switch (networkType) {
                    case 1:
                    case 2:
                    case 4:
                    case 7:
                    case 11:
                        str = "2G";
                        break;
                    case 3:
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    case 10:
                    case 12:
                    case 14:
                    case 15:
                        str = "3G";
                        break;
                    case 13:
                        str = "4G";
                        break;
                    default:
                        return "UNKNOWN";
                }
            } else {
                str = "5G";
            }
            return str;
        } catch (Throwable unused) {
            return "UNKNOWN";
        }
    }

    /* renamed from: a */
    public static String m35251a() {
        String str = "";
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress nextElement = inetAddresses.nextElement();
                    if (!nextElement.isLoopbackAddress() && (nextElement instanceof Inet4Address)) {
                        str = nextElement.getHostAddress();
                    }
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
        return str;
    }

    /* renamed from: b */
    public static String m35254b(Context context) {
        Intent intent;
        String str = "";
        try {
            if (!f49011h) {
                synchronized (f49010g) {
                    if (!f49011h) {
                        intent = BatteryReceiver.init(context);
                        f49011h = true;
                    } else {
                        intent = null;
                    }
                }
                if (intent != null) {
                    int intExtra = intent.getIntExtra("level", 0);
                    int intExtra2 = intent.getIntExtra(NNGestureClassfy.SCALE_LABLE, 100);
                    if (intExtra > 0) {
                        String valueOf = String.valueOf((intExtra * 100) / intExtra2);
                        if (!TextUtils.isEmpty(valueOf)) {
                            return valueOf;
                        }
                    }
                }
            }
            str = BatteryReceiver.getBatteryPercent();
        } catch (Throwable unused) {
        }
        if (!TextUtils.isEmpty(str) || Build.VERSION.SDK_INT < 21) {
            return str;
        }
        try {
            return String.valueOf(((BatteryManager) context.getSystemService("batterymanager")).getIntProperty(4));
        } catch (Throwable unused2) {
            return str;
        }
    }

    /* renamed from: b */
    public static String m35253b() {
        try {
            return String.valueOf(System.currentTimeMillis());
        } catch (Throwable unused) {
            return "";
        }
    }

    /* renamed from: c */
    public static long m35255c() {
        try {
            return System.currentTimeMillis();
        } catch (Throwable unused) {
            return 0;
        }
    }

    /* renamed from: c */
    public static String m35256c(Context context) {
        try {
            if ((SystemUtils.getApplicationInfo(context.getPackageManager(), context.getPackageName(), 0).flags & 2) == 2) {
                return "1";
            }
            return "0";
        } catch (Throwable unused) {
            return "0";
        }
    }

    /* renamed from: d */
    public static boolean m35257d(Context context) {
        try {
            if ((SystemUtils.getApplicationInfo(context.getPackageManager(), context.getPackageName(), 0).flags & 2) == 2) {
                return true;
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* renamed from: e */
    public static String m35258e(Context context) {
        String str = "0";
        try {
            Iterator<ActivityManager.RunningAppProcessInfo> it = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses().iterator();
            while (true) {
                String str2 = str;
                while (true) {
                    try {
                        if (!it.hasNext()) {
                            return str2;
                        }
                        ActivityManager.RunningAppProcessInfo next = it.next();
                        if (next.processName.equals(context.getPackageName())) {
                            if (next.importance != 100) {
                                str2 = "1";
                            }
                        }
                    } catch (Throwable unused) {
                        str = str2;
                        return str;
                    }
                }
            }
        } catch (Throwable unused2) {
            return str;
        }
    }

    /* renamed from: f */
    public static String m35259f(Context context) {
        try {
            Locale locale = Locale.getDefault();
            return locale.getLanguage() + "-" + locale.getCountry();
        } catch (Throwable unused) {
            return "";
        }
    }
}
