package com.didichuxing.foundation.util;

import android.os.Process;
import java.net.InetAddress;
import java.security.SecureRandom;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class UniqueIdGenerator {

    /* renamed from: a */
    private static final AtomicInteger f47653a = new AtomicInteger(new SecureRandom().nextInt());

    public static final String generate() {
        byte[] bArr;
        byte[] bArr2 = new byte[16];
        InetAddress ipv4Address = NetworkUtil.getIpv4Address();
        if (ipv4Address != null) {
            bArr = ipv4Address.getAddress();
        } else {
            bArr = new byte[4];
            new SecureRandom().nextBytes(bArr);
        }
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        int currentTimeMillis = (int) ((System.currentTimeMillis() / 1000) & -1);
        bArr2[4] = (byte) ((currentTimeMillis >> 24) & 255);
        bArr2[5] = (byte) ((currentTimeMillis >> 16) & 255);
        bArr2[6] = (byte) ((currentTimeMillis >> 8) & 255);
        bArr2[7] = (byte) (currentTimeMillis & 255);
        int myPid = Process.myPid();
        bArr2[8] = (byte) ((myPid >> 24) & 255);
        bArr2[9] = (byte) ((myPid >> 16) & 255);
        bArr2[10] = (byte) ((myPid >> 8) & 255);
        bArr2[11] = (byte) (myPid & 255);
        int andIncrement = f47653a.getAndIncrement();
        bArr2[12] = (byte) ((andIncrement >> 24) & 255);
        bArr2[13] = (byte) ((andIncrement >> 16) & 255);
        bArr2[14] = (byte) ((andIncrement >> 8) & 255);
        bArr2[15] = (byte) (andIncrement & 255);
        return AlgorithmUtil.toHexString(bArr2);
    }

    private UniqueIdGenerator() {
    }
}
