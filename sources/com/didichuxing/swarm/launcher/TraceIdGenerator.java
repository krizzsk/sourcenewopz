package com.didichuxing.swarm.launcher;

import android.os.Process;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicInteger;

class TraceIdGenerator {

    /* renamed from: a */
    private static final AtomicInteger f49186a = new AtomicInteger(new SecureRandom().nextInt());

    /* renamed from: b */
    private static final InetAddress f49187b = m35469a();

    interface InetAddressFilter {
        boolean accept(InetAddress inetAddress);
    }

    interface NetworkInterfaceFilter {
        boolean accept(NetworkInterface networkInterface);
    }

    TraceIdGenerator() {
    }

    /* renamed from: a */
    public static String m35466a(int i) {
        return m35467a((int) (System.currentTimeMillis() / 1000), i);
    }

    /* renamed from: a */
    public static String m35467a(int i, int i2) {
        byte[] bArr;
        byte[] bArr2 = new byte[16];
        InetAddress inetAddress = f49187b;
        if (inetAddress == null) {
            inetAddress = m35469a();
        }
        if (inetAddress != null) {
            bArr = inetAddress.getAddress();
        } else {
            bArr = new byte[4];
            new SecureRandom().nextBytes(bArr);
        }
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        bArr2[4] = (byte) ((i >> 24) & 255);
        bArr2[5] = (byte) ((i >> 16) & 255);
        bArr2[6] = (byte) ((i >> 8) & 255);
        bArr2[7] = (byte) (i & 255);
        int myPid = Process.myPid() & 65535;
        bArr2[8] = 0;
        bArr2[9] = 0;
        bArr2[10] = (byte) ((myPid >> 8) & 255);
        bArr2[11] = (byte) (myPid & 255);
        int andIncrement = f49186a.getAndIncrement() & 16777215;
        bArr2[12] = (byte) ((andIncrement >> 16) & 255);
        bArr2[13] = (byte) ((andIncrement >> 8) & 255);
        bArr2[14] = (byte) (andIncrement & 255);
        bArr2[15] = (byte) (i2 & 255);
        return m35468a(bArr2);
    }

    /* renamed from: a */
    static String m35468a(byte[] bArr) {
        int length = bArr.length;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(String.format("%02x", new Object[]{Integer.valueOf(bArr[i] & 255)}));
        }
        return sb.toString();
    }

    /* renamed from: a */
    static InetAddress m35469a() {
        NetworkInterface[] a = m35472a((NetworkInterfaceFilter) new NetworkInterfaceFilter() {
            public boolean accept(NetworkInterface networkInterface) {
                try {
                    return !networkInterface.isLoopback() && !networkInterface.isVirtual();
                } catch (SocketException unused) {
                    return false;
                }
            }
        });
        if (a == null || a.length <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (NetworkInterface a2 : a) {
            arrayList.addAll(Arrays.asList(m35471a(a2, (InetAddressFilter) new InetAddressFilter() {
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

    /* renamed from: b */
    static final NetworkInterface[] m35473b() {
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

    /* renamed from: a */
    static final NetworkInterface[] m35472a(NetworkInterfaceFilter networkInterfaceFilter) {
        NetworkInterface[] b = m35473b();
        if (b == null || networkInterfaceFilter == null) {
            return b;
        }
        ArrayList arrayList = new ArrayList(1);
        for (NetworkInterface networkInterface : b) {
            if (networkInterfaceFilter.accept(networkInterface)) {
                arrayList.add(networkInterface);
            }
        }
        return (NetworkInterface[]) arrayList.toArray(new NetworkInterface[arrayList.size()]);
    }

    /* renamed from: a */
    static final InetAddress[] m35470a(NetworkInterface networkInterface) {
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

    /* renamed from: a */
    static final InetAddress[] m35471a(NetworkInterface networkInterface, InetAddressFilter inetAddressFilter) {
        InetAddress[] a = m35470a(networkInterface);
        if (a == null || inetAddressFilter == null) {
            return a;
        }
        ArrayList arrayList = new ArrayList();
        for (InetAddress inetAddress : a) {
            if (inetAddressFilter.accept(inetAddress)) {
                arrayList.add(inetAddress);
            }
        }
        return (InetAddress[]) arrayList.toArray(new InetAddress[arrayList.size()]);
    }
}
