package didihttpdns.net;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import android.util.Log;
import com.didi.sdk.apm.SystemUtils;
import didinet.Logger;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.regex.Pattern;

public final class NetUtils {
    public static final int NETWORK_2G = 2;
    public static final int NETWORK_3G = 3;
    public static final int NETWORK_4G = 4;
    public static final int NETWORK_MOBILE = 5;
    public static final int NETWORK_NONE = 0;
    public static final int NETWORK_WIFI = 1;

    private NetUtils() {
        throw new AssertionError();
    }

    public static boolean isNetAvailable(Context context) {
        try {
            NetworkInfo activeNetworkInfo = SystemUtils.getActiveNetworkInfo((ConnectivityManager) context.getSystemService("connectivity"));
            if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                return false;
            }
            return true;
        } catch (Exception unused) {
        }
    }

    public static String getHostName(String str) {
        int indexOf;
        int indexOf2;
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("url is empty");
        } else if (str.startsWith("http://") && (indexOf2 = str.indexOf("/", 7)) > 7) {
            return str.substring(7, indexOf2);
        } else {
            if (str.startsWith("https://") && (indexOf = str.indexOf("/", 8)) > 8) {
                return str.substring(8, indexOf);
            }
            throw new IllegalArgumentException("url(" + str + ") is illegal");
        }
    }

    public static boolean isIpv4(String str) {
        if (!TextUtils.isEmpty(str) && str.length() >= 7 && str.length() <= 15) {
            try {
                return Pattern.compile("(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)\\.(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)\\.(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)\\.(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)").matcher(str.trim()).find();
            } catch (Throwable th) {
                Logger.m40928d("NetUtils", "isIpv4: " + Log.getStackTraceString(th));
            }
        }
        return false;
    }

    public static String getWifiIp(Context context) {
        WifiInfo connectionInfo;
        try {
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            if (!wifiManager.isWifiEnabled() || (connectionInfo = wifiManager.getConnectionInfo()) == null) {
                return null;
            }
            int ipAddress = connectionInfo.getIpAddress();
            return (ipAddress & 255) + "." + ((ipAddress >> 8) & 255) + "." + ((ipAddress >> 16) & 255) + "." + ((ipAddress >> 24) & 255);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String getMobileIp() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            if (networkInterfaces == null) {
                return null;
            }
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                if (inetAddresses != null) {
                    while (inetAddresses.hasMoreElements()) {
                        InetAddress nextElement = inetAddresses.nextElement();
                        if (!nextElement.isLoopbackAddress() && (nextElement instanceof Inet4Address)) {
                            String hostAddress = nextElement.getHostAddress();
                            if (hostAddress.indexOf(58) < 0) {
                                Logger.m40932i("HttpDNS", "ipv4:" + hostAddress);
                                return hostAddress;
                            }
                        }
                    }
                    continue;
                }
            }
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses2 = networkInterfaces.nextElement().getInetAddresses();
                if (inetAddresses2 != null) {
                    while (inetAddresses2.hasMoreElements()) {
                        InetAddress nextElement2 = inetAddresses2.nextElement();
                        if (!nextElement2.isLoopbackAddress() && (nextElement2 instanceof Inet6Address)) {
                            String hostAddress2 = nextElement2.getHostAddress();
                            if (!(hostAddress2.indexOf(58) < 0)) {
                                int indexOf = hostAddress2.indexOf(37);
                                String upperCase = indexOf < 0 ? hostAddress2.toUpperCase() : hostAddress2.substring(0, indexOf).toUpperCase();
                                Logger.m40932i("HttpDNS", "ipv6:" + upperCase);
                                return upperCase;
                            }
                        }
                    }
                    continue;
                }
            }
            return null;
        } catch (Throwable th) {
            Logger.m40928d("NetUtils", "getMobileIp: " + Log.getStackTraceString(th));
        }
    }

    public static int getNetworkType(Context context) {
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

    public static String getIp(Context context) {
        int networkType = getNetworkType(context);
        if (networkType == 0) {
            return null;
        }
        if (networkType != 1) {
            return getMobileIp();
        }
        return getWifiIp(context);
    }
}
