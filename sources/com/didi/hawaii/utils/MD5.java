package com.didi.hawaii.utils;

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
    static final int f24199a = 7;

    /* renamed from: b */
    static final int f24200b = 12;

    /* renamed from: c */
    static final int f24201c = 17;

    /* renamed from: d */
    static final int f24202d = 22;

    /* renamed from: e */
    static final int f24203e = 5;

    /* renamed from: f */
    static final int f24204f = 9;

    /* renamed from: g */
    static final int f24205g = 14;

    /* renamed from: h */
    static final int f24206h = 20;

    /* renamed from: i */
    static final int f24207i = 4;

    /* renamed from: j */
    static final int f24208j = 11;

    /* renamed from: k */
    static final int f24209k = 16;

    /* renamed from: l */
    static final int f24210l = 23;

    /* renamed from: m */
    static final int f24211m = 6;

    /* renamed from: n */
    static final int f24212n = 10;

    /* renamed from: o */
    static final int f24213o = 15;

    /* renamed from: p */
    static final int f24214p = 21;

    /* renamed from: q */
    static final byte[] f24215q = {Byte.MIN_VALUE, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    public String digestHexStr;

    /* renamed from: r */
    private long[] f24216r = new long[4];

    /* renamed from: s */
    private long[] f24217s = new long[2];

    /* renamed from: t */
    private byte[] f24218t = new byte[64];

    /* renamed from: u */
    private byte[] f24219u = new byte[16];

    /* renamed from: a */
    private long m17263a(long j, long j2, long j3) {
        return ((~j) & j3) | (j2 & j);
    }

    /* renamed from: b */
    private long m17272b(long j, long j2, long j3) {
        return (j & j3) | (j2 & (~j3));
    }

    public static long b2iu(byte b) {
        if (b < 0) {
            b &= 255;
        }
        return (long) b;
    }

    /* renamed from: c */
    private long m17275c(long j, long j2, long j3) {
        return (j ^ j2) ^ j3;
    }

    /* renamed from: d */
    private long m17277d(long j, long j2, long j3) {
        return (j | (~j3)) ^ j2;
    }

    public byte[] getMD5(byte[] bArr) {
        m17265a();
        m17271a((InputStream) new ByteArrayInputStream(bArr), (long) bArr.length);
        m17274b();
        return this.f24219u;
    }

    public byte[] getMD5(InputStream inputStream, long j) {
        m17265a();
        if (!m17271a(inputStream, j)) {
            return new byte[16];
        }
        m17274b();
        return this.f24219u;
    }

    public MD5() {
        m17265a();
    }

    /* renamed from: a */
    private void m17265a() {
        long[] jArr = this.f24217s;
        jArr[0] = 0;
        jArr[1] = 0;
        long[] jArr2 = this.f24216r;
        jArr2[0] = 1732584193;
        jArr2[1] = 4023233417L;
        jArr2[2] = 2562383102L;
        jArr2[3] = 271733878;
    }

    /* renamed from: a */
    private long m17264a(long j, long j2, long j3, long j4, long j5, long j6, long j7) {
        long j8 = j6;
        int a = (int) (m17263a(j2, j3, j4) + j5 + j7 + j);
        return ((long) ((a >>> ((int) (32 - j8))) | (a << ((int) j8)))) + j2;
    }

    /* renamed from: b */
    private long m17273b(long j, long j2, long j3, long j4, long j5, long j6, long j7) {
        long j8 = j6;
        int b = (int) (m17272b(j2, j3, j4) + j5 + j7 + j);
        return ((long) ((b >>> ((int) (32 - j8))) | (b << ((int) j8)))) + j2;
    }

    /* renamed from: c */
    private long m17276c(long j, long j2, long j3, long j4, long j5, long j6, long j7) {
        long j8 = j6;
        int c = (int) (m17275c(j2, j3, j4) + j5 + j7 + j);
        return ((long) ((c >>> ((int) (32 - j8))) | (c << ((int) j8)))) + j2;
    }

    /* renamed from: d */
    private long m17278d(long j, long j2, long j3, long j4, long j5, long j6, long j7) {
        long j8 = j6;
        int d = (int) (m17277d(j2, j3, j4) + j5 + j7 + j);
        return ((long) ((d >>> ((int) (32 - j8))) | (d << ((int) j8)))) + j2;
    }

    /* renamed from: a */
    private boolean m17271a(InputStream inputStream, long j) {
        int i;
        InputStream inputStream2 = inputStream;
        byte[] bArr = new byte[64];
        long[] jArr = this.f24217s;
        int i2 = ((int) (jArr[0] >>> 3)) & 63;
        long j2 = j << 3;
        long j3 = jArr[0] + j2;
        jArr[0] = j3;
        if (j3 < j2) {
            jArr[1] = jArr[1] + 1;
        }
        long[] jArr2 = this.f24217s;
        jArr2[1] = jArr2[1] + (j >>> 29);
        int i3 = 64 - i2;
        if (j >= ((long) i3)) {
            byte[] bArr2 = new byte[i3];
            try {
                inputStream.read(bArr2, 0, i3);
                m17268a(this.f24218t, bArr2, i2, 0, i3);
                m17266a(this.f24218t);
                while (((long) (i3 + 63)) < j) {
                    try {
                        inputStream.read(bArr);
                        m17266a(bArr);
                        i3 += 64;
                    } catch (Exception e) {
                        e.printStackTrace();
                        return false;
                    }
                }
                i = 0;
            } catch (Exception e2) {
                e2.printStackTrace();
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
            m17268a(this.f24218t, bArr3, i, 0, i4);
            return true;
        } catch (Exception e3) {
            e3.printStackTrace();
            return false;
        }
    }

    /* renamed from: a */
    private void m17267a(byte[] bArr, int i) {
        int i2;
        byte[] bArr2 = new byte[64];
        long[] jArr = this.f24217s;
        int i3 = ((int) (jArr[0] >>> 3)) & 63;
        long j = (long) (i << 3);
        long j2 = jArr[0] + j;
        jArr[0] = j2;
        if (j2 < j) {
            jArr[1] = jArr[1] + 1;
        }
        long[] jArr2 = this.f24217s;
        jArr2[1] = jArr2[1] + ((long) (i >>> 29));
        int i4 = 64 - i3;
        if (i >= i4) {
            m17268a(this.f24218t, bArr, i3, 0, i4);
            m17266a(this.f24218t);
            while (i4 + 63 < i) {
                m17268a(bArr2, bArr, 0, i4, 64);
                m17266a(bArr2);
                i4 += 64;
            }
            i2 = i4;
            i3 = 0;
        } else {
            i2 = 0;
        }
        m17268a(this.f24218t, bArr, i3, i2, i - i2);
    }

    /* renamed from: b */
    private void m17274b() {
        byte[] bArr = new byte[8];
        m17269a(bArr, this.f24217s, 8);
        int i = ((int) (this.f24217s[0] >>> 3)) & 63;
        m17267a(f24215q, i < 56 ? 56 - i : 120 - i);
        m17267a(bArr, 8);
        m17269a(this.f24219u, this.f24216r, 16);
    }

    /* renamed from: a */
    private void m17268a(byte[] bArr, byte[] bArr2, int i, int i2, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            bArr[i + i4] = bArr2[i2 + i4];
        }
    }

    /* renamed from: a */
    private void m17266a(byte[] bArr) {
        long[] jArr = this.f24216r;
        long j = jArr[0];
        long j2 = jArr[1];
        long j3 = jArr[2];
        long j4 = jArr[3];
        long[] jArr2 = new long[16];
        m17270a(jArr2, bArr, 64);
        long[] jArr3 = jArr2;
        long a = m17264a(j, j2, j3, j4, jArr2[0], 7, 3614090360L);
        long a2 = m17264a(j4, a, j2, j3, jArr3[1], 12, 3905402710L);
        long a3 = m17264a(j3, a2, a, j2, jArr3[2], 17, 606105819);
        long a4 = m17264a(j2, a3, a2, a, jArr3[3], 22, 3250441966L);
        long a5 = m17264a(a, a4, a3, a2, jArr3[4], 7, 4118548399L);
        long a6 = m17264a(a2, a5, a4, a3, jArr3[5], 12, 1200080426);
        long a7 = m17264a(a3, a6, a5, a4, jArr3[6], 17, 2821735955L);
        long a8 = m17264a(a4, a7, a6, a5, jArr3[7], 22, 4249261313L);
        long a9 = m17264a(a5, a8, a7, a6, jArr3[8], 7, 1770035416);
        long a10 = m17264a(a6, a9, a8, a7, jArr3[9], 12, 2336552879L);
        long a11 = m17264a(a7, a10, a9, a8, jArr3[10], 17, 4294925233L);
        long a12 = m17264a(a8, a11, a10, a9, jArr3[11], 22, 2304563134L);
        long a13 = m17264a(a9, a12, a11, a10, jArr3[12], 7, 1804603682);
        long a14 = m17264a(a10, a13, a12, a11, jArr3[13], 12, 4254626195L);
        long a15 = m17264a(a11, a14, a13, a12, jArr3[14], 17, 2792965006L);
        long a16 = m17264a(a12, a15, a14, a13, jArr3[15], 22, 1236535329);
        long b = m17273b(a13, a16, a15, a14, jArr3[1], 5, 4129170786L);
        long b2 = m17273b(a14, b, a16, a15, jArr3[6], 9, 3225465664L);
        long b3 = m17273b(a15, b2, b, a16, jArr3[11], 14, 643717713);
        long b4 = m17273b(a16, b3, b2, b, jArr3[0], 20, 3921069994L);
        long b5 = m17273b(b, b4, b3, b2, jArr3[5], 5, 3593408605L);
        long b6 = m17273b(b2, b5, b4, b3, jArr3[10], 9, 38016083);
        long b7 = m17273b(b3, b6, b5, b4, jArr3[15], 14, 3634488961L);
        long b8 = m17273b(b4, b7, b6, b5, jArr3[4], 20, 3889429448L);
        long b9 = m17273b(b5, b8, b7, b6, jArr3[9], 5, 568446438);
        long b10 = m17273b(b6, b9, b8, b7, jArr3[14], 9, 3275163606L);
        long b11 = m17273b(b7, b10, b9, b8, jArr3[3], 14, 4107603335L);
        long b12 = m17273b(b8, b11, b10, b9, jArr3[8], 20, 1163531501);
        long b13 = m17273b(b9, b12, b11, b10, jArr3[13], 5, 2850285829L);
        long b14 = m17273b(b10, b13, b12, b11, jArr3[2], 9, 4243563512L);
        long b15 = m17273b(b11, b14, b13, b12, jArr3[7], 14, 1735328473);
        long b16 = m17273b(b12, b15, b14, b13, jArr3[12], 20, 2368359562L);
        long c = m17276c(b13, b16, b15, b14, jArr3[5], 4, 4294588738L);
        long c2 = m17276c(b14, c, b16, b15, jArr3[8], 11, 2272392833L);
        long c3 = m17276c(b15, c2, c, b16, jArr3[11], 16, 1839030562);
        long c4 = m17276c(b16, c3, c2, c, jArr3[14], 23, 4259657740L);
        long c5 = m17276c(c, c4, c3, c2, jArr3[1], 4, 2763975236L);
        long c6 = m17276c(c2, c5, c4, c3, jArr3[4], 11, 1272893353);
        long c7 = m17276c(c3, c6, c5, c4, jArr3[7], 16, 4139469664L);
        long c8 = m17276c(c4, c7, c6, c5, jArr3[10], 23, 3200236656L);
        long c9 = m17276c(c5, c8, c7, c6, jArr3[13], 4, 681279174);
        long c10 = m17276c(c6, c9, c8, c7, jArr3[0], 11, 3936430074L);
        long c11 = m17276c(c7, c10, c9, c8, jArr3[3], 16, 3572445317L);
        long c12 = m17276c(c8, c11, c10, c9, jArr3[6], 23, 76029189);
        long c13 = m17276c(c9, c12, c11, c10, jArr3[9], 4, 3654602809L);
        long c14 = m17276c(c10, c13, c12, c11, jArr3[12], 11, 3873151461L);
        long c15 = m17276c(c11, c14, c13, c12, jArr3[15], 16, 530742520);
        long c16 = m17276c(c12, c15, c14, c13, jArr3[2], 23, 3299628645L);
        long d = m17278d(c13, c16, c15, c14, jArr3[0], 6, 4096336452L);
        long d2 = m17278d(c14, d, c16, c15, jArr3[7], 10, 1126891415);
        long d3 = m17278d(c15, d2, d, c16, jArr3[14], 15, 2878612391L);
        long d4 = m17278d(c16, d3, d2, d, jArr3[5], 21, 4237533241L);
        long d5 = m17278d(d, d4, d3, d2, jArr3[12], 6, 1700485571);
        long d6 = m17278d(d2, d5, d4, d3, jArr3[3], 10, 2399980690L);
        long d7 = m17278d(d3, d6, d5, d4, jArr3[10], 15, 4293915773L);
        long d8 = m17278d(d4, d7, d6, d5, jArr3[1], 21, 2240044497L);
        long d9 = m17278d(d5, d8, d7, d6, jArr3[8], 6, 1873313359);
        long d10 = m17278d(d6, d9, d8, d7, jArr3[15], 10, 4264355552L);
        long d11 = m17278d(d7, d10, d9, d8, jArr3[6], 15, 2734768916L);
        long d12 = m17278d(d8, d11, d10, d9, jArr3[13], 21, 1309151649);
        long d13 = m17278d(d9, d12, d11, d10, jArr3[4], 6, 4149444226L);
        long d14 = m17278d(d10, d13, d12, d11, jArr3[11], 10, 3174756917L);
        long d15 = m17278d(d11, d14, d13, d12, jArr3[2], 15, 718787259);
        long d16 = m17278d(d12, d15, d14, d13, jArr3[9], 21, 3951481745L);
        long[] jArr4 = this.f24216r;
        jArr4[0] = jArr4[0] + d13;
        jArr4[1] = jArr4[1] + d16;
        jArr4[2] = jArr4[2] + d15;
        jArr4[3] = jArr4[3] + d14;
    }

    /* renamed from: a */
    private void m17269a(byte[] bArr, long[] jArr, int i) {
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
    private void m17270a(long[] jArr, byte[] bArr, int i) {
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3 += 4) {
            jArr[i2] = b2iu(bArr[i3]) | (b2iu(bArr[i3 + 1]) << 8) | (b2iu(bArr[i3 + 2]) << 16) | (b2iu(bArr[i3 + 3]) << 24);
            i2++;
        }
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
            e.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: finally extract failed */
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
            String str = new String(cArr2);
            C9266IO.safeClose(fileInputStream);
            return str;
        } catch (Exception e) {
            e.printStackTrace();
            C9266IO.safeClose(fileInputStream);
            return null;
        } catch (Throwable th) {
            C9266IO.safeClose(fileInputStream);
            throw th;
        }
    }
}
