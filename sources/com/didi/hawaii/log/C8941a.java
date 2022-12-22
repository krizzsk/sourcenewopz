package com.didi.hawaii.log;

import android.text.TextUtils;
import com.didi.hawaii.basic.ApolloHawaii;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;

/* renamed from: com.didi.hawaii.log.a */
/* compiled from: HWBinaryLogger */
final class C8941a {

    /* renamed from: a */
    private static final String f23480a = "hawaiiPB";

    /* renamed from: b */
    private static final String f23481b = "{phonenumber}_binary_{hawaii}{date:yyyyMMdd}-{count}.txt";

    /* renamed from: c */
    private static final HWLogger2 f23482c = new HWLogger2(f23481b);

    /* renamed from: d */
    private static Logger f23483d = null;

    /* renamed from: a */
    private static byte[] m16769a(int i) {
        return new byte[]{(byte) i, (byte) (i >> 8), (byte) (i >> 16), (byte) (i >> 24)};
    }

    /* renamed from: a */
    private static byte[] m16770a(long j) {
        return new byte[]{(byte) ((int) j), (byte) ((int) (j >> 8)), (byte) ((int) (j >> 16)), (byte) ((int) (j >> 24)), (byte) ((int) (j >> 32)), (byte) ((int) (j >> 40)), (byte) ((int) (j >> 48)), (byte) ((int) (j >> 56))};
    }

    private C8941a() {
    }

    /* renamed from: a */
    static void m16767a(String str) {
        if (!TextUtils.isEmpty(str)) {
            f23482c.setPhoneNumber(str);
        }
    }

    /* renamed from: b */
    static void m16771b(String str) {
        if (!TextUtils.isEmpty(str)) {
            f23482c.setPath(str);
        }
    }

    /* renamed from: c */
    static void m16773c(String str) {
        if (!TextUtils.isEmpty(str)) {
            f23482c.setPackageName(str);
        }
    }

    /* renamed from: a */
    static void m16768a(byte[] bArr, byte b, long j) {
        byte[] b2 = m16772b(bArr, b, j);
        if (ApolloHawaii.useNewLogSDK()) {
            Logger a = m16766a();
            if (a != null) {
                a.write(b2);
                return;
            }
            return;
        }
        f23482c.log(b2);
    }

    /* renamed from: a */
    private static synchronized Logger m16766a() {
        synchronized (C8941a.class) {
            if (f23483d != null) {
                Logger logger = f23483d;
                return logger;
            }
            Logger logger2 = LoggerFactory.getLogger("", f23480a);
            f23483d = logger2;
            return logger2;
        }
    }

    /* renamed from: b */
    private static byte[] m16772b(byte[] bArr, byte b, long j) {
        int length = bArr.length + 9;
        byte[] bArr2 = new byte[(length + 4)];
        System.arraycopy(m16769a(length), 0, bArr2, 0, 4);
        bArr2[4] = b;
        System.arraycopy(m16770a(j), 0, bArr2, 5, 8);
        System.arraycopy(bArr, 0, bArr2, 13, bArr.length);
        return bArr2;
    }
}
