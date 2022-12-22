package okhttp3.internal.p070ws;

import okio.Buffer;
import okio.ByteString;

/* renamed from: okhttp3.internal.ws.WebSocketProtocol */
public final class WebSocketProtocol {

    /* renamed from: a */
    static final String f5567a = "258EAFA5-E914-47DA-95CA-C5AB0DC85B11";

    /* renamed from: b */
    static final int f5568b = 128;

    /* renamed from: c */
    static final int f5569c = 64;

    /* renamed from: d */
    static final int f5570d = 32;

    /* renamed from: e */
    static final int f5571e = 16;

    /* renamed from: f */
    static final int f5572f = 15;

    /* renamed from: g */
    static final int f5573g = 8;

    /* renamed from: h */
    static final int f5574h = 128;

    /* renamed from: i */
    static final int f5575i = 127;

    /* renamed from: j */
    static final int f5576j = 0;

    /* renamed from: k */
    static final int f5577k = 1;

    /* renamed from: l */
    static final int f5578l = 2;

    /* renamed from: m */
    static final int f5579m = 8;

    /* renamed from: n */
    static final int f5580n = 9;

    /* renamed from: o */
    static final int f5581o = 10;

    /* renamed from: p */
    static final long f5582p = 125;

    /* renamed from: q */
    static final long f5583q = 123;

    /* renamed from: r */
    static final int f5584r = 126;

    /* renamed from: s */
    static final long f5585s = 65535;

    /* renamed from: t */
    static final int f5586t = 127;

    /* renamed from: u */
    static final int f5587u = 1001;

    /* renamed from: v */
    static final int f5588v = 1005;

    /* renamed from: a */
    static void m3590a(Buffer.UnsafeCursor unsafeCursor, byte[] bArr) {
        int length = bArr.length;
        int i = 0;
        do {
            byte[] bArr2 = unsafeCursor.data;
            int i2 = unsafeCursor.start;
            int i3 = unsafeCursor.end;
            while (i2 < i3) {
                int i4 = i % length;
                bArr2[i2] = (byte) (bArr2[i2] ^ bArr[i4]);
                i2++;
                i = i4 + 1;
            }
        } while (unsafeCursor.next() != -1);
    }

    /* renamed from: a */
    static String m3589a(int i) {
        if (i < 1000 || i >= 5000) {
            return "Code must be in range [1000,5000): " + i;
        } else if ((i < 1004 || i > 1006) && (i < 1012 || i > 2999)) {
            return null;
        } else {
            return "Code " + i + " is reserved and may not be used.";
        }
    }

    /* renamed from: b */
    static void m3591b(int i) {
        String a = m3589a(i);
        if (a != null) {
            throw new IllegalArgumentException(a);
        }
    }

    public static String acceptHeader(String str) {
        return ByteString.encodeUtf8(str + f5567a).sha1().base64();
    }

    private WebSocketProtocol() {
        throw new AssertionError("No instances.");
    }
}
