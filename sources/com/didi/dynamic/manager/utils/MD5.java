package com.didi.dynamic.manager.utils;

import com.google.common.base.Ascii;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import org.apache.commons.codec2.digest.MessageDigestAlgorithms;

public class MD5 {

    /* renamed from: a */
    static final int f19362a = 7;

    /* renamed from: b */
    static final int f19363b = 12;

    /* renamed from: c */
    static final int f19364c = 17;

    /* renamed from: d */
    static final int f19365d = 22;

    /* renamed from: e */
    static final int f19366e = 5;

    /* renamed from: f */
    static final int f19367f = 9;

    /* renamed from: g */
    static final int f19368g = 14;

    /* renamed from: h */
    static final int f19369h = 20;

    /* renamed from: i */
    static final int f19370i = 4;

    /* renamed from: j */
    static final int f19371j = 11;

    /* renamed from: k */
    static final int f19372k = 16;

    /* renamed from: l */
    static final int f19373l = 23;

    /* renamed from: m */
    static final int f19374m = 6;

    /* renamed from: n */
    static final int f19375n = 10;

    /* renamed from: o */
    static final int f19376o = 15;

    /* renamed from: p */
    static final int f19377p = 21;

    /* renamed from: q */
    static final byte[] f19378q = {Byte.MIN_VALUE, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    public String digestHexStr;

    /* renamed from: r */
    private long[] f19379r = new long[4];

    /* renamed from: s */
    private long[] f19380s = new long[2];

    /* renamed from: t */
    private byte[] f19381t = new byte[64];

    /* renamed from: u */
    private byte[] f19382u = new byte[16];

    /* renamed from: a */
    private long m14495a(long j, long j2, long j3) {
        return ((~j) & j3) | (j2 & j);
    }

    /* renamed from: b */
    private long m14504b(long j, long j2, long j3) {
        return (j & j3) | (j2 & (~j3));
    }

    public static long b2iu(byte b) {
        if (b < 0) {
            b &= 255;
        }
        return (long) b;
    }

    /* renamed from: c */
    private long m14507c(long j, long j2, long j3) {
        return (j ^ j2) ^ j3;
    }

    /* renamed from: d */
    private long m14509d(long j, long j2, long j3) {
        return (j | (~j3)) ^ j2;
    }

    public MD5() {
        m14497a();
    }

    public static String byteHEX(byte b) {
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        return new String(new char[]{cArr[(b >>> 4) & 15], cArr[b & Ascii.f53593SI]});
    }

    public static byte[] toMD5Byte(byte[] bArr) {
        return new MD5().getMD5(bArr);
    }

    public static byte[] toMD5Byte(String str) {
        byte[] bArr;
        try {
            bArr = str.getBytes("ISO8859_1");
        } catch (UnsupportedEncodingException unused) {
            bArr = str.getBytes();
        }
        return new MD5().getMD5(bArr);
    }

    public static byte[] toMD5Byte(InputStream inputStream, long j) {
        return new MD5().getMD5(inputStream, j);
    }

    public static String toMD5(byte[] bArr) {
        byte[] md5 = new MD5().getMD5(bArr);
        String str = "";
        for (int i = 0; i < 16; i++) {
            str = str + byteHEX(md5[i]);
        }
        return str;
    }

    public static String toMD5(String str) {
        byte[] bArr;
        try {
            bArr = str.getBytes("ISO8859_1");
        } catch (UnsupportedEncodingException unused) {
            bArr = str.getBytes();
        }
        byte[] md5 = new MD5().getMD5(bArr);
        String str2 = "";
        for (int i = 0; i < 16; i++) {
            str2 = str2 + byteHEX(md5[i]);
        }
        return str2;
    }

    public static String getMD5String(byte[] bArr) {
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            MessageDigest instance = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
            instance.update(bArr);
            byte[] digest = instance.digest();
            char[] cArr2 = new char[32];
            int i = 0;
            for (int i2 = 0; i2 < 16; i2++) {
                byte b = digest[i2];
                int i3 = i + 1;
                cArr2[i] = cArr[(b >>> 4) & 15];
                i = i3 + 1;
                cArr2[i3] = cArr[b & Ascii.f53593SI];
            }
            return new String(cArr2);
        } catch (Exception e) {
            Log.m14494w("System.err", (Throwable) e);
            return null;
        }
    }

    public static String getFileMD5(File file) throws FileNotFoundException {
        int i;
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] bArr = new byte[1024];
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            MessageDigest instance = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
            while (true) {
                int read = fileInputStream.read(bArr, 0, 1024);
                if (read == -1) {
                    break;
                }
                instance.update(bArr, 0, read);
            }
            fileInputStream.close();
            byte[] digest = instance.digest();
            char[] cArr2 = new char[32];
            int i2 = 0;
            for (i = 0; i < 16; i++) {
                byte b = digest[i];
                int i3 = i2 + 1;
                cArr2[i2] = cArr[(b >>> 4) & 15];
                i2 = i3 + 1;
                cArr2[i3] = cArr[b & Ascii.f53593SI];
            }
            return new String(cArr2);
        } catch (Exception e) {
            Log.m14494w("System.err", (Throwable) e);
            return null;
        }
    }

    public byte[] getMD5(byte[] bArr) {
        m14497a();
        m14503a((InputStream) new ByteArrayInputStream(bArr), (long) bArr.length);
        m14506b();
        return this.f19382u;
    }

    public byte[] getMD5(InputStream inputStream, long j) {
        m14497a();
        if (!m14503a(inputStream, j)) {
            return new byte[16];
        }
        m14506b();
        return this.f19382u;
    }

    /* renamed from: a */
    private void m14497a() {
        long[] jArr = this.f19380s;
        jArr[0] = 0;
        jArr[1] = 0;
        long[] jArr2 = this.f19379r;
        jArr2[0] = 1732584193;
        jArr2[1] = 4023233417L;
        jArr2[2] = 2562383102L;
        jArr2[3] = 271733878;
    }

    /* renamed from: a */
    private long m14496a(long j, long j2, long j3, long j4, long j5, long j6, long j7) {
        long j8 = j6;
        int a = (int) (m14495a(j2, j3, j4) + j5 + j7 + j);
        return ((long) ((a >>> ((int) (32 - j8))) | (a << ((int) j8)))) + j2;
    }

    /* renamed from: b */
    private long m14505b(long j, long j2, long j3, long j4, long j5, long j6, long j7) {
        long j8 = j6;
        int b = (int) (m14504b(j2, j3, j4) + j5 + j7 + j);
        return ((long) ((b >>> ((int) (32 - j8))) | (b << ((int) j8)))) + j2;
    }

    /* renamed from: c */
    private long m14508c(long j, long j2, long j3, long j4, long j5, long j6, long j7) {
        long j8 = j6;
        int c = (int) (m14507c(j2, j3, j4) + j5 + j7 + j);
        return ((long) ((c >>> ((int) (32 - j8))) | (c << ((int) j8)))) + j2;
    }

    /* renamed from: d */
    private long m14510d(long j, long j2, long j3, long j4, long j5, long j6, long j7) {
        long j8 = j6;
        int d = (int) (m14509d(j2, j3, j4) + j5 + j7 + j);
        return ((long) ((d >>> ((int) (32 - j8))) | (d << ((int) j8)))) + j2;
    }

    /* renamed from: a */
    private boolean m14503a(InputStream inputStream, long j) {
        int i;
        InputStream inputStream2 = inputStream;
        byte[] bArr = new byte[64];
        long[] jArr = this.f19380s;
        int i2 = ((int) (jArr[0] >>> 3)) & 63;
        long j2 = j << 3;
        long j3 = jArr[0] + j2;
        jArr[0] = j3;
        if (j3 < j2) {
            jArr[1] = jArr[1] + 1;
        }
        long[] jArr2 = this.f19380s;
        jArr2[1] = jArr2[1] + (j >>> 29);
        int i3 = 64 - i2;
        if (j >= ((long) i3)) {
            byte[] bArr2 = new byte[i3];
            try {
                inputStream.read(bArr2, 0, i3);
                m14500a(this.f19381t, bArr2, i2, 0, i3);
                m14498a(this.f19381t);
                while (((long) (i3 + 63)) < j) {
                    try {
                        inputStream.read(bArr);
                        m14498a(bArr);
                        i3 += 64;
                    } catch (Exception e) {
                        Log.m14494w("System.err", (Throwable) e);
                        return false;
                    }
                }
                i = 0;
            } catch (Exception e2) {
                Log.m14494w("System.err", (Throwable) e2);
                return false;
            }
        } else {
            i = i2;
            i3 = 0;
        }
        int i4 = (int) (j - ((long) i3));
        byte[] bArr3 = new byte[i4];
        try {
            inputStream.read(bArr3);
            m14500a(this.f19381t, bArr3, i, 0, i4);
            return true;
        } catch (Exception e3) {
            Log.m14494w("System.err", (Throwable) e3);
            return false;
        }
    }

    /* renamed from: a */
    private void m14499a(byte[] bArr, int i) {
        int i2;
        byte[] bArr2 = new byte[64];
        long[] jArr = this.f19380s;
        int i3 = ((int) (jArr[0] >>> 3)) & 63;
        long j = (long) (i << 3);
        long j2 = jArr[0] + j;
        jArr[0] = j2;
        if (j2 < j) {
            jArr[1] = jArr[1] + 1;
        }
        long[] jArr2 = this.f19380s;
        jArr2[1] = jArr2[1] + ((long) (i >>> 29));
        int i4 = 64 - i3;
        if (i >= i4) {
            m14500a(this.f19381t, bArr, i3, 0, i4);
            m14498a(this.f19381t);
            while (i4 + 63 < i) {
                m14500a(bArr2, bArr, 0, i4, 64);
                m14498a(bArr2);
                i4 += 64;
            }
            i2 = i4;
            i3 = 0;
        } else {
            i2 = 0;
        }
        m14500a(this.f19381t, bArr, i3, i2, i - i2);
    }

    /* renamed from: b */
    private void m14506b() {
        byte[] bArr = new byte[8];
        m14501a(bArr, this.f19380s, 8);
        int i = ((int) (this.f19380s[0] >>> 3)) & 63;
        m14499a(f19378q, i < 56 ? 56 - i : 120 - i);
        m14499a(bArr, 8);
        m14501a(this.f19382u, this.f19379r, 16);
    }

    /* renamed from: a */
    private void m14500a(byte[] bArr, byte[] bArr2, int i, int i2, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            bArr[i + i4] = bArr2[i2 + i4];
        }
    }

    /* renamed from: a */
    private void m14498a(byte[] bArr) {
        long[] jArr = this.f19379r;
        long j = jArr[0];
        long j2 = jArr[1];
        long j3 = jArr[2];
        long j4 = jArr[3];
        long[] jArr2 = new long[16];
        m14502a(jArr2, bArr, 64);
        long[] jArr3 = jArr2;
        long a = m14496a(j, j2, j3, j4, jArr2[0], 7, 3614090360L);
        long a2 = m14496a(j4, a, j2, j3, jArr3[1], 12, 3905402710L);
        long a3 = m14496a(j3, a2, a, j2, jArr3[2], 17, 606105819);
        long a4 = m14496a(j2, a3, a2, a, jArr3[3], 22, 3250441966L);
        long a5 = m14496a(a, a4, a3, a2, jArr3[4], 7, 4118548399L);
        long a6 = m14496a(a2, a5, a4, a3, jArr3[5], 12, 1200080426);
        long a7 = m14496a(a3, a6, a5, a4, jArr3[6], 17, 2821735955L);
        long a8 = m14496a(a4, a7, a6, a5, jArr3[7], 22, 4249261313L);
        long a9 = m14496a(a5, a8, a7, a6, jArr3[8], 7, 1770035416);
        long a10 = m14496a(a6, a9, a8, a7, jArr3[9], 12, 2336552879L);
        long a11 = m14496a(a7, a10, a9, a8, jArr3[10], 17, 4294925233L);
        long a12 = m14496a(a8, a11, a10, a9, jArr3[11], 22, 2304563134L);
        long a13 = m14496a(a9, a12, a11, a10, jArr3[12], 7, 1804603682);
        long a14 = m14496a(a10, a13, a12, a11, jArr3[13], 12, 4254626195L);
        long a15 = m14496a(a11, a14, a13, a12, jArr3[14], 17, 2792965006L);
        long a16 = m14496a(a12, a15, a14, a13, jArr3[15], 22, 1236535329);
        long b = m14505b(a13, a16, a15, a14, jArr3[1], 5, 4129170786L);
        long b2 = m14505b(a14, b, a16, a15, jArr3[6], 9, 3225465664L);
        long b3 = m14505b(a15, b2, b, a16, jArr3[11], 14, 643717713);
        long b4 = m14505b(a16, b3, b2, b, jArr3[0], 20, 3921069994L);
        long b5 = m14505b(b, b4, b3, b2, jArr3[5], 5, 3593408605L);
        long b6 = m14505b(b2, b5, b4, b3, jArr3[10], 9, 38016083);
        long b7 = m14505b(b3, b6, b5, b4, jArr3[15], 14, 3634488961L);
        long b8 = m14505b(b4, b7, b6, b5, jArr3[4], 20, 3889429448L);
        long b9 = m14505b(b5, b8, b7, b6, jArr3[9], 5, 568446438);
        long b10 = m14505b(b6, b9, b8, b7, jArr3[14], 9, 3275163606L);
        long b11 = m14505b(b7, b10, b9, b8, jArr3[3], 14, 4107603335L);
        long b12 = m14505b(b8, b11, b10, b9, jArr3[8], 20, 1163531501);
        long b13 = m14505b(b9, b12, b11, b10, jArr3[13], 5, 2850285829L);
        long b14 = m14505b(b10, b13, b12, b11, jArr3[2], 9, 4243563512L);
        long b15 = m14505b(b11, b14, b13, b12, jArr3[7], 14, 1735328473);
        long b16 = m14505b(b12, b15, b14, b13, jArr3[12], 20, 2368359562L);
        long c = m14508c(b13, b16, b15, b14, jArr3[5], 4, 4294588738L);
        long c2 = m14508c(b14, c, b16, b15, jArr3[8], 11, 2272392833L);
        long c3 = m14508c(b15, c2, c, b16, jArr3[11], 16, 1839030562);
        long c4 = m14508c(b16, c3, c2, c, jArr3[14], 23, 4259657740L);
        long c5 = m14508c(c, c4, c3, c2, jArr3[1], 4, 2763975236L);
        long c6 = m14508c(c2, c5, c4, c3, jArr3[4], 11, 1272893353);
        long c7 = m14508c(c3, c6, c5, c4, jArr3[7], 16, 4139469664L);
        long c8 = m14508c(c4, c7, c6, c5, jArr3[10], 23, 3200236656L);
        long c9 = m14508c(c5, c8, c7, c6, jArr3[13], 4, 681279174);
        long c10 = m14508c(c6, c9, c8, c7, jArr3[0], 11, 3936430074L);
        long c11 = m14508c(c7, c10, c9, c8, jArr3[3], 16, 3572445317L);
        long c12 = m14508c(c8, c11, c10, c9, jArr3[6], 23, 76029189);
        long c13 = m14508c(c9, c12, c11, c10, jArr3[9], 4, 3654602809L);
        long c14 = m14508c(c10, c13, c12, c11, jArr3[12], 11, 3873151461L);
        long c15 = m14508c(c11, c14, c13, c12, jArr3[15], 16, 530742520);
        long c16 = m14508c(c12, c15, c14, c13, jArr3[2], 23, 3299628645L);
        long d = m14510d(c13, c16, c15, c14, jArr3[0], 6, 4096336452L);
        long d2 = m14510d(c14, d, c16, c15, jArr3[7], 10, 1126891415);
        long d3 = m14510d(c15, d2, d, c16, jArr3[14], 15, 2878612391L);
        long d4 = m14510d(c16, d3, d2, d, jArr3[5], 21, 4237533241L);
        long d5 = m14510d(d, d4, d3, d2, jArr3[12], 6, 1700485571);
        long d6 = m14510d(d2, d5, d4, d3, jArr3[3], 10, 2399980690L);
        long d7 = m14510d(d3, d6, d5, d4, jArr3[10], 15, 4293915773L);
        long d8 = m14510d(d4, d7, d6, d5, jArr3[1], 21, 2240044497L);
        long d9 = m14510d(d5, d8, d7, d6, jArr3[8], 6, 1873313359);
        long d10 = m14510d(d6, d9, d8, d7, jArr3[15], 10, 4264355552L);
        long d11 = m14510d(d7, d10, d9, d8, jArr3[6], 15, 2734768916L);
        long d12 = m14510d(d8, d11, d10, d9, jArr3[13], 21, 1309151649);
        long d13 = m14510d(d9, d12, d11, d10, jArr3[4], 6, 4149444226L);
        long d14 = m14510d(d10, d13, d12, d11, jArr3[11], 10, 3174756917L);
        long d15 = m14510d(d11, d14, d13, d12, jArr3[2], 15, 718787259);
        long d16 = m14510d(d12, d15, d14, d13, jArr3[9], 21, 3951481745L);
        long[] jArr4 = this.f19379r;
        jArr4[0] = jArr4[0] + d13;
        jArr4[1] = jArr4[1] + d16;
        jArr4[2] = jArr4[2] + d15;
        jArr4[3] = jArr4[3] + d14;
    }

    /* renamed from: a */
    private void m14501a(byte[] bArr, long[] jArr, int i) {
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3 += 4) {
            bArr[i3] = (byte) ((int) (jArr[i2] & 255));
            bArr[i3 + 1] = (byte) ((int) ((jArr[i2] >>> 8) & 255));
            bArr[i3 + 2] = (byte) ((int) ((jArr[i2] >>> 16) & 255));
            bArr[i3 + 3] = (byte) ((int) ((jArr[i2] >>> 24) & 255));
            i2++;
        }
    }

    /* renamed from: a */
    private void m14502a(long[] jArr, byte[] bArr, int i) {
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3 += 4) {
            jArr[i2] = b2iu(bArr[i3]) | (b2iu(bArr[i3 + 1]) << 8) | (b2iu(bArr[i3 + 2]) << 16) | (b2iu(bArr[i3 + 3]) << 24);
            i2++;
        }
    }
}
