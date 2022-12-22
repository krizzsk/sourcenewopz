package com.didichuxing.foundation.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.didi.sdk.apm.SystemUtils;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public abstract class NetworkUtil {

    /* renamed from: a */
    private static final String f47646a = "unknown";

    /* renamed from: b */
    private static final String f47647b = "ethernet";

    /* renamed from: c */
    private static final String f47648c = "wifi";

    /* renamed from: d */
    private static final String f47649d = "2G";

    /* renamed from: e */
    private static final String f47650e = "3G";

    /* renamed from: f */
    private static final String f47651f = "4G";

    public interface InetAddressFilter {
        boolean accept(InetAddress inetAddress);
    }

    public interface NetworkInterfaceFilter {
        boolean accept(NetworkInterface networkInterface);
    }

    public static boolean isAvailable(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            return false;
        }
        try {
            NetworkInfo activeNetworkInfo = SystemUtils.getActiveNetworkInfo(connectivityManager);
            if (activeNetworkInfo != null) {
                return activeNetworkInfo.isAvailable();
            }
            return false;
        } catch (SecurityException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean isConnected(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            return false;
        }
        try {
            NetworkInfo activeNetworkInfo = SystemUtils.getActiveNetworkInfo(connectivityManager);
            if (activeNetworkInfo != null) {
                return activeNetworkInfo.isConnected();
            }
            return false;
        } catch (SecurityException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean isConnectedAndAvailable(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager != null) {
            try {
                NetworkInfo activeNetworkInfo = SystemUtils.getActiveNetworkInfo(connectivityManager);
                if (activeNetworkInfo == null || !activeNetworkInfo.isConnected() || !activeNetworkInfo.isAvailable()) {
                    return false;
                }
                return true;
            } catch (SecurityException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public static String getNetworkTypeString(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager != null) {
            try {
                NetworkInfo activeNetworkInfo = SystemUtils.getActiveNetworkInfo(connectivityManager);
                if (activeNetworkInfo != null) {
                    int type = activeNetworkInfo.getType();
                    if (type == 1) {
                        return "wifi";
                    }
                    if (type == 9) {
                        return "ethernet";
                    }
                }
            } catch (SecurityException e) {
                e.printStackTrace();
            }
        }
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager == null) {
            return "unknown";
        }
        switch (telephonyManager.getNetworkType()) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
                return "2G";
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
                return "3G";
            case 13:
                return "4G";
            default:
                return "unknown";
        }
    }

    public static final NetworkInterface[] listNetworkInterfaces() {
        try {
            ArrayList<T> list = Collections.list(NetworkInterface.getNetworkInterfaces());
            if (list == null) {
                return null;
            }
            return (NetworkInterface[]) list.toArray(new NetworkInterface[list.size()]);
        } catch (Exception unused) {
            return null;
        }
    }

    public static final NetworkInterface[] listNetworkInterfaces(NetworkInterfaceFilter networkInterfaceFilter) {
        NetworkInterface[] listNetworkInterfaces = listNetworkInterfaces();
        if (listNetworkInterfaces == null || networkInterfaceFilter == null) {
            return listNetworkInterfaces;
        }
        ArrayList arrayList = new ArrayList(1);
        for (NetworkInterface networkInterface : listNetworkInterfaces) {
            if (networkInterfaceFilter.accept(networkInterface)) {
                arrayList.add(networkInterface);
            }
        }
        return (NetworkInterface[]) arrayList.toArray(new NetworkInterface[arrayList.size()]);
    }

    public static final InetAddress[] listInetAddresses(NetworkInterface networkInterface) {
        try {
            ArrayList<T> list = Collections.list(networkInterface.getInetAddresses());
            if (list == null) {
                return null;
            }
            return (InetAddress[]) list.toArray(new InetAddress[list.size()]);
        } catch (Exception unused) {
            return null;
        }
    }

    public static final InetAddress[] listInetAddresses(NetworkInterface networkInterface, InetAddressFilter inetAddressFilter) {
        InetAddress[] listInetAddresses = listInetAddresses(networkInterface);
        if (listInetAddresses == null || inetAddressFilter == null) {
            return listInetAddresses;
        }
        ArrayList arrayList = new ArrayList();
        for (InetAddress inetAddress : listInetAddresses) {
            if (inetAddressFilter.accept(inetAddress)) {
                arrayList.add(inetAddress);
            }
        }
        return (InetAddress[]) arrayList.toArray(new InetAddress[arrayList.size()]);
    }

    public static InetAddress getIpv4Address() {
        NetworkInterface[] listNetworkInterfaces = listNetworkInterfaces(new NetworkInterfaceFilter() {
            public boolean accept(NetworkInterface networkInterface) {
                try {
                    return !networkInterface.isLoopback() && !networkInterface.isVirtual();
                } catch (SocketException unused) {
                    return false;
                }
            }
        });
        if (listNetworkInterfaces == null || listNetworkInterfaces.length <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (NetworkInterface listInetAddresses : listNetworkInterfaces) {
            arrayList.addAll(Arrays.asList(listInetAddresses(listInetAddresses, new InetAddressFilter() {
                public boolean accept(InetAddress inetAddress) {
                    return inetAddress instanceof Inet4Address;
                }
            })));
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return (InetAddress) arrayList.get(0);
    }

    private NetworkUtil() {
    }
}
