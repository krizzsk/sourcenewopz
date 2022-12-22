package didihttp.internal.http2;

import didihttp.internal.C20747Util;
import java.io.IOException;
import okio.ByteString;

public final class Http2 {

    /* renamed from: a */
    static final ByteString f56743a = ByteString.encodeUtf8("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");

    /* renamed from: b */
    static final int f56744b = 16384;

    /* renamed from: c */
    static final byte f56745c = 0;

    /* renamed from: d */
    static final byte f56746d = 1;

    /* renamed from: e */
    static final byte f56747e = 2;

    /* renamed from: f */
    static final byte f56748f = 3;

    /* renamed from: g */
    static final byte f56749g = 4;

    /* renamed from: h */
    static final byte f56750h = 5;

    /* renamed from: i */
    static final byte f56751i = 6;

    /* renamed from: j */
    static final byte f56752j = 7;

    /* renamed from: k */
    static final byte f56753k = 8;

    /* renamed from: l */
    static final byte f56754l = 9;

    /* renamed from: m */
    static final byte f56755m = 0;

    /* renamed from: n */
    static final byte f56756n = 1;

    /* renamed from: o */
    static final byte f56757o = 1;

    /* renamed from: p */
    static final byte f56758p = 4;

    /* renamed from: q */
    static final byte f56759q = 4;

    /* renamed from: r */
    static final byte f56760r = 8;

    /* renamed from: s */
    static final byte f56761s = 32;

    /* renamed from: t */
    static final byte f56762t = 32;

    /* renamed from: u */
    static final String[] f56763u = new String[64];

    /* renamed from: v */
    static final String[] f56764v = new String[256];

    /* renamed from: w */
    private static final String[] f56765w = {"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};

    static {
        int i = 0;
        int i2 = 0;
        while (true) {
            String[] strArr = f56764v;
            if (i2 >= strArr.length) {
                break;
            }
            strArr[i2] = C20747Util.format("%8s", Integer.toBinaryString(i2)).replace(' ', '0');
            i2++;
        }
        String[] strArr2 = f56763u;
        strArr2[0] = "";
        strArr2[1] = "END_STREAM";
        int[] iArr = {1};
        strArr2[8] = "PADDED";
        for (int i3 = 0; i3 < 1; i3++) {
            int i4 = iArr[i3];
            f56763u[i4 | 8] = f56763u[i4] + "|PADDED";
        }
        String[] strArr3 = f56763u;
        strArr3[4] = "END_HEADERS";
        strArr3[32] = "PRIORITY";
        strArr3[36] = "END_HEADERS|PRIORITY";
        int[] iArr2 = {4, 32, 36};
        for (int i5 = 0; i5 < 3; i5++) {
            int i6 = iArr2[i5];
            for (int i7 = 0; i7 < 1; i7++) {
                int i8 = iArr[i7];
                String[] strArr4 = f56763u;
                int i9 = i8 | i6;
                strArr4[i9] = f56763u[i8] + '|' + f56763u[i6];
                f56763u[i9 | 8] = f56763u[i8] + '|' + f56763u[i6] + "|PADDED";
            }
        }
        while (true) {
            String[] strArr5 = f56763u;
            if (i < strArr5.length) {
                if (strArr5[i] == null) {
                    strArr5[i] = f56764v[i];
                }
                i++;
            } else {
                return;
            }
        }
    }

    private Http2() {
    }

    /* renamed from: a */
    static IllegalArgumentException m40722a(String str, Object... objArr) {
        throw new IllegalArgumentException(C20747Util.format(str, objArr));
    }

    /* renamed from: b */
    static IOException m40725b(String str, Object... objArr) throws IOException {
        throw new IOException(C20747Util.format(str, objArr));
    }

    /* renamed from: a */
    static String m40724a(boolean z, int i, int i2, byte b, byte b2) {
        String[] strArr = f56765w;
        String format = b < strArr.length ? strArr[b] : C20747Util.format("0x%02x", Byte.valueOf(b));
        String a = m40723a(b, b2);
        Object[] objArr = new Object[5];
        objArr[0] = z ? "<<" : ">>";
        objArr[1] = Integer.valueOf(i);
        objArr[2] = Integer.valueOf(i2);
        objArr[3] = format;
        objArr[4] = a;
        return C20747Util.format("%s 0x%08x %5d %-13s %s", objArr);
    }

    /* renamed from: a */
    static String m40723a(byte b, byte b2) {
        if (b2 == 0) {
            return "";
        }
        if (!(b == 2 || b == 3)) {
            if (b == 4 || b == 6) {
                return b2 == 1 ? "ACK" : f56764v[b2];
            }
            if (!(b == 7 || b == 8)) {
                String[] strArr = f56763u;
                String str = b2 < strArr.length ? strArr[b2] : f56764v[b2];
                if (b == 5 && (b2 & 4) != 0) {
                    return str.replace("HEADERS", "PUSH_PROMISE");
                }
                if (b != 0 || (b2 & 32) == 0) {
                    return str;
                }
                return str.replace("PRIORITY", "COMPRESSED");
            }
        }
        return f56764v[b2];
    }
}
