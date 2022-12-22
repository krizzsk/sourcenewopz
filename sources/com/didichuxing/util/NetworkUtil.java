package com.didichuxing.util;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Collections;

public final class NetworkUtil {

    public interface InetAddressFilter {
        boolean accept(InetAddress inetAddress);
    }

    public interface NetworkInterfaceFilter {
        boolean accept(NetworkInterface networkInterface);
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

    private NetworkUtil() {
    }
}
