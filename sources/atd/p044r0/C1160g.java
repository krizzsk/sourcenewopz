package atd.p044r0;

import atd.p046s0.C1172a;
import java.nio.charset.Charset;
import java.util.Random;

/* renamed from: atd.r0.g */
public final class C1160g {
    static {
        C1172a.m764a(-728079014382254L);
    }

    /* renamed from: a */
    public static String m734a(String str) {
        C1154a a = C1154a.m709a();
        Charset b = a.mo13921b();
        String[] split = a.mo13923c(str).split(C1172a.m764a(-728070424447662L));
        return new String(m736a(a.mo13923c(split[0]).getBytes(b), a.mo13923c(split[1]).getBytes(b)), b);
    }

    /* renamed from: b */
    public static String m737b(String str) {
        C1154a a = C1154a.m709a();
        byte[] bytes = str.getBytes(a.mo13921b());
        byte[] a2 = m735a(bytes.length);
        byte[] a3 = m736a(bytes, a2);
        String d = a.mo13926d(a2);
        String d2 = a.mo13926d(a3);
        return a.mo13925d(d + C1172a.m764a(-728061834513070L) + d2);
    }

    /* renamed from: a */
    private static byte[] m736a(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[bArr.length];
        for (int i = 0; i < bArr.length; i++) {
            bArr3[i] = (byte) (bArr[i] ^ bArr2[i % bArr2.length]);
        }
        return bArr3;
    }

    /* renamed from: a */
    private static byte[] m735a(int i) {
        byte[] bArr = new byte[i];
        new Random(System.currentTimeMillis()).nextBytes(bArr);
        for (int i2 = 0; i2 < i; i2++) {
            bArr[i2] = (byte) (Math.abs(bArr[i2]) % 127);
        }
        return bArr;
    }
}
