package com.didi.foundation.sdk.utils;

import com.didichuxing.foundation.util.NetworkUtil;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;

public class NetUtil {
    public static InetAddress getIpv4Address() {
        InetAddress[] listInetAddresses;
        NetworkInterface[] listNetworkInterfaces = NetworkUtil.listNetworkInterfaces(new NetworkUtil.NetworkInterfaceFilter() {
            public boolean accept(NetworkInterface networkInterface) {
                try {
                    return !networkInterface.isLoopback() && !networkInterface.isVirtual();
                } catch (SocketException unused) {
                    return false;
                }
            }
        });
        if (listNetworkInterfaces == null || listNetworkInterfaces.length <= 0 || (listInetAddresses = NetworkUtil.listInetAddresses(listNetworkInterfaces[0], new NetworkUtil.InetAddressFilter() {
            public boolean accept(InetAddress inetAddress) {
                return inetAddress instanceof Inet4Address;
            }
        })) == null || listInetAddresses.length <= 0) {
            return null;
        }
        return listInetAddresses[0];
    }
}
