package didihttp.internal.trace;

import android.os.Process;
import java.net.InetAddress;
import java.security.SecureRandom;
import java.util.concurrent.atomic.AtomicInteger;

public final class IdGenrator {

    /* renamed from: a */
    private static final AtomicInteger f56907a = new AtomicInteger(new SecureRandom().nextInt());

    public static final String generate(InetAddress inetAddress) {
        byte[] bArr;
        byte[] bArr2 = new byte[16];
        if (inetAddress != null) {
            bArr = inetAddress.getAddress();
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
        int andIncrement = f56907a.getAndIncrement();
        bArr2[12] = (byte) ((andIncrement >> 24) & 255);
        bArr2[13] = (byte) ((andIncrement >> 16) & 255);
        bArr2[14] = (byte) ((andIncrement >> 8) & 255);
        bArr2[15] = (byte) (andIncrement & 255);
        return m40857a(bArr2);
    }

    /* renamed from: a */
    private static String m40857a(byte[] bArr) {
        int length = bArr.length;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(String.format("%02x", new Object[]{Integer.valueOf(bArr[i] & 255)}));
        }
        return sb.toString();
    }
}
