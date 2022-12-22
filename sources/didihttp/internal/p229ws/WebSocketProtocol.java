package didihttp.internal.p229ws;

import okio.ByteString;

/* renamed from: didihttp.internal.ws.WebSocketProtocol */
public final class WebSocketProtocol {

    /* renamed from: a */
    static final String f56936a = "258EAFA5-E914-47DA-95CA-C5AB0DC85B11";

    /* renamed from: b */
    static final int f56937b = 128;

    /* renamed from: c */
    static final int f56938c = 64;

    /* renamed from: d */
    static final int f56939d = 32;

    /* renamed from: e */
    static final int f56940e = 16;

    /* renamed from: f */
    static final int f56941f = 15;

    /* renamed from: g */
    static final int f56942g = 8;

    /* renamed from: h */
    static final int f56943h = 128;

    /* renamed from: i */
    static final int f56944i = 127;

    /* renamed from: j */
    static final int f56945j = 0;

    /* renamed from: k */
    static final int f56946k = 1;

    /* renamed from: l */
    static final int f56947l = 2;

    /* renamed from: m */
    static final int f56948m = 8;

    /* renamed from: n */
    static final int f56949n = 9;

    /* renamed from: o */
    static final int f56950o = 10;

    /* renamed from: p */
    static final long f56951p = 125;

    /* renamed from: q */
    static final long f56952q = 123;

    /* renamed from: r */
    static final int f56953r = 126;

    /* renamed from: s */
    static final long f56954s = 65535;

    /* renamed from: t */
    static final int f56955t = 127;

    /* renamed from: u */
    static final int f56956u = 1001;

    /* renamed from: v */
    static final int f56957v = 1002;

    /* renamed from: w */
    static final int f56958w = 1005;

    /* renamed from: x */
    static final int f56959x = 1006;

    /* renamed from: a */
    static void m40878a(byte[] bArr, long j, byte[] bArr2, long j2) {
        int length = bArr2.length;
        int i = 0;
        while (((long) i) < j) {
            bArr[i] = (byte) (bArr[i] ^ bArr2[(int) (j2 % ((long) length))]);
            i++;
            j2++;
        }
    }

    /* renamed from: a */
    static String m40877a(int i) {
        if (i < 1000 || i >= 5000) {
            return "Code must be in range [1000,5000): " + i;
        } else if ((i < 1004 || i > 1006) && (i < 1012 || i > 2999)) {
            return null;
        } else {
            return "Code " + i + " is reserved and may not be used.";
        }
    }

    /* renamed from: b */
    static void m40879b(int i) {
        String a = m40877a(i);
        if (a != null) {
            throw new IllegalArgumentException(a);
        }
    }

    public static String acceptHeader(String str) {
        return ByteString.encodeUtf8(str + f56936a).sha1().base64();
    }

    private WebSocketProtocol() {
        throw new AssertionError("No instances.");
    }
}
