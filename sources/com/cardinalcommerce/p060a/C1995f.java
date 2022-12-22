package com.cardinalcommerce.p060a;

import com.google.common.primitives.Shorts;
import java.math.BigInteger;
import net.lingala.zip4j.util.InternalZipConstants;
import org.mozilla.classfile.ClassFileWriter;

/* renamed from: com.cardinalcommerce.a.f */
final class C1995f implements Cloneable {

    /* renamed from: a */
    static final byte[] f2531a = {0, 1, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8};

    /* renamed from: c */
    private static final short[] f2532c = {0, 1, 4, 5, 16, 17, 20, 21, 64, 65, 68, 69, 80, 81, 84, 85, ClassFileWriter.ACC_NATIVE, 257, 260, 261, 272, 273, 276, 277, 320, 321, 324, 325, 336, 337, 340, 341, ClassFileWriter.ACC_ABSTRACT, 1025, 1028, 1029, 1040, 1041, 1044, 1045, 1088, 1089, 1092, 1093, 1104, 1105, 1108, 1109, 1280, 1281, 1284, 1285, 1296, 1297, 1300, 1301, 1344, 1345, 1348, 1349, 1360, 1361, 1364, 1365, 4096, 4097, 4100, 4101, 4112, 4113, 4116, 4117, 4160, 4161, 4164, 4165, 4176, 4177, 4180, 4181, 4352, 4353, 4356, 4357, 4368, 4369, 4372, 4373, 4416, 4417, 4420, 4421, 4432, 4433, 4436, 4437, 5120, 5121, 5124, 5125, 5136, 5137, 5140, 5141, 5184, 5185, 5188, 5189, 5200, 5201, 5204, 5205, 5376, 5377, 5380, 5381, 5392, 5393, 5396, 5397, 5440, 5441, 5444, 5445, 5456, 5457, 5460, 5461, Shorts.MAX_POWER_OF_TWO, 16385, 16388, 16389, 16400, 16401, 16404, 16405, 16448, 16449, 16452, 16453, 16464, 16465, 16468, 16469, 16640, 16641, 16644, 16645, 16656, 16657, 16660, 16661, 16704, 16705, 16708, 16709, 16720, 16721, 16724, 16725, 17408, 17409, 17412, 17413, 17424, 17425, 17428, 17429, 17472, 17473, 17476, 17477, 17488, 17489, 17492, 17493, 17664, 17665, 17668, 17669, 17680, 17681, 17684, 17685, 17728, 17729, 17732, 17733, 17744, 17745, 17748, 17749, 20480, 20481, 20484, 20485, 20496, 20497, 20500, 20501, 20544, 20545, 20548, 20549, 20560, 20561, 20564, 20565, 20736, 20737, 20740, 20741, 20752, 20753, 20756, 20757, 20800, 20801, 20804, 20805, 20816, 20817, 20820, 20821, 21504, 21505, 21508, 21509, 21520, 21521, 21524, 21525, 21568, 21569, 21572, 21573, 21584, 21585, 21588, 21589, 21760, 21761, 21764, 21765, 21776, 21777, 21780, 21781, 21824, 21825, 21828, 21829, 21840, 21841, 21844, 21845};

    /* renamed from: b */
    long[] f2533b;

    private C1995f(int i) {
        this.f2533b = new long[i];
    }

    public C1995f(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0) {
            throw new IllegalArgumentException("invalid F2m field value");
        }
        int i = 1;
        if (bigInteger.signum() == 0) {
            this.f2533b = new long[]{0};
            return;
        }
        byte[] byteArray = bigInteger.toByteArray();
        int length = byteArray.length;
        if (byteArray[0] == 0) {
            length--;
        } else {
            i = 0;
        }
        int i2 = (length + 7) / 8;
        this.f2533b = new long[i2];
        int i3 = i2 - 1;
        int i4 = (length % 8) + i;
        if (i < i4) {
            long j = 0;
            while (i < i4) {
                j = (j << 8) | ((long) (byteArray[i] & 255));
                i++;
            }
            this.f2533b[i3] = j;
            i3--;
        }
        while (i3 >= 0) {
            long j2 = 0;
            int i5 = 0;
            while (i5 < 8) {
                j2 = (j2 << 8) | ((long) (byteArray[i] & 255));
                i5++;
                i++;
            }
            this.f2533b[i3] = j2;
            i3--;
        }
    }

    public C1995f(long[] jArr) {
        this.f2533b = jArr;
    }

    public C1995f(long[] jArr, int i, int i2) {
        if (i2 == jArr.length) {
            this.f2533b = jArr;
            return;
        }
        long[] jArr2 = new long[i2];
        this.f2533b = jArr2;
        System.arraycopy(jArr, 0, jArr2, 0, i2);
    }

    /* JADX WARNING: type inference failed for: r3v11, types: [byte[]] */
    /* JADX WARNING: type inference failed for: r3v12, types: [byte] */
    /* JADX WARNING: Incorrect type for immutable var: ssa=byte, code=int, for r3v12, types: [byte] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int m1844a(long r3) {
        /*
            r0 = 32
            long r1 = r3 >>> r0
            int r2 = (int) r1
            if (r2 != 0) goto L_0x0009
            int r2 = (int) r3
            r0 = 0
        L_0x0009:
            int r3 = r2 >>> 16
            if (r3 != 0) goto L_0x001d
            int r3 = r2 >>> 8
            if (r3 != 0) goto L_0x0016
            byte[] r3 = f2531a
            byte r3 = r3[r2]
            goto L_0x002e
        L_0x0016:
            byte[] r4 = f2531a
            byte r3 = r4[r3]
            int r3 = r3 + 8
            goto L_0x002e
        L_0x001d:
            int r4 = r3 >>> 8
            if (r4 != 0) goto L_0x0028
            byte[] r4 = f2531a
            byte r3 = r4[r3]
            int r3 = r3 + 16
            goto L_0x002e
        L_0x0028:
            byte[] r3 = f2531a
            byte r3 = r3[r4]
            int r3 = r3 + 24
        L_0x002e:
            int r0 = r0 + r3
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.C1995f.m1844a(long):int");
    }

    /* renamed from: a */
    private static long m1846a(long[] jArr, int i, long[] jArr2, int i2, int i3, int i4) {
        int i5 = 64 - i4;
        long j = 0;
        for (int i6 = 0; i6 < i3; i6++) {
            long j2 = jArr[i + i6];
            jArr2[i2 + i6] = j | (j2 << i4);
            j = j2 >>> i5;
        }
        return j;
    }

    /* renamed from: a */
    private static void m1849a(long[] jArr, int i, int i2, int i3, int i4, int[] iArr) {
        int i5 = i3 >>> 6;
        int i6 = i2;
        while (true) {
            int i7 = i6 - 1;
            if (i7 <= i5) {
                break;
            }
            int i8 = i + i7;
            long j = jArr[i8];
            if (j != 0) {
                jArr[i8] = 0;
                m1851a(jArr, i, i7 << 6, j, i4, iArr);
            }
            i6 = i7;
        }
        int i9 = i3 & 63;
        int i10 = i + i5;
        long j2 = jArr[i10] >>> i9;
        if (j2 != 0) {
            jArr[i10] = jArr[i10] ^ (j2 << i9);
            m1851a(jArr, i, i3, j2, i4, iArr);
        }
    }

    /* renamed from: a */
    private static void m1850a(long[] jArr, int i, int i2, long j) {
        int i3 = i + (i2 >>> 6);
        int i4 = i2 & 63;
        if (i4 == 0) {
            jArr[i3] = jArr[i3] ^ j;
            return;
        }
        jArr[i3] = jArr[i3] ^ (j << i4);
        long j2 = j >>> (64 - i4);
        if (j2 != 0) {
            int i5 = i3 + 1;
            jArr[i5] = j2 ^ jArr[i5];
        }
    }

    /* renamed from: a */
    private static void m1851a(long[] jArr, int i, int i2, long j, int i3, int[] iArr) {
        int i4 = i2 - i3;
        int length = iArr.length;
        while (true) {
            length--;
            if (length >= 0) {
                m1850a(jArr, i, iArr[length] + i4, j);
            } else {
                m1850a(jArr, i, i4, j);
                return;
            }
        }
    }

    /* renamed from: a */
    private static void m1852a(long[] jArr, int i, long[] jArr2, int i2, long[] jArr3, int i3, int i4) {
        for (int i5 = 0; i5 < i4; i5++) {
            jArr3[i3 + i5] = jArr[i + i5] ^ jArr2[i2 + i5];
        }
    }

    /* renamed from: a */
    private static boolean m1853a(long[] jArr, int i, int i2) {
        return (jArr[i + (i2 >>> 6)] & (1 << (i2 & 63))) != 0;
    }

    /* renamed from: b */
    static long m1854b(int i) {
        short[] sArr = f2532c;
        short s = sArr[i & 255] | (sArr[(i >>> 8) & 255] << 16);
        short s2 = sArr[(i >>> 16) & 255];
        return (((long) s) & InternalZipConstants.ZIP_64_SIZE_LIMIT) | ((((long) ((sArr[i >>> 24] << 16) | s2)) & InternalZipConstants.ZIP_64_SIZE_LIMIT) << 32);
    }

    /* renamed from: b */
    private static long m1855b(long[] jArr, int i, long[] jArr2, int i2, int i3, int i4) {
        int i5 = 64 - i4;
        long j = 0;
        int i6 = i3;
        for (int i7 = 0; i7 < i6; i7++) {
            long j2 = jArr2[i2 + i7];
            int i8 = i + i7;
            jArr[i8] = (j | (j2 << i4)) ^ jArr[i8];
            j = j2 >>> i5;
        }
        return j;
    }

    /* renamed from: b */
    private static void m1856b(long[] jArr, int i, int i2, int i3, int i4, int[] iArr) {
        int i5 = (i3 << 6) - i4;
        int length = iArr.length;
        while (true) {
            length--;
            if (length >= 0) {
                m1861d(jArr, i, jArr, i + i3, i2 - i3, i5 + iArr[length]);
            } else {
                m1861d(jArr, i, jArr, i + i3, i2 - i3, i5);
                return;
            }
        }
    }

    /* renamed from: b */
    private static void m1858b(long[] jArr, int i, long[] jArr2, int i2, long[] jArr3, int i3, int i4) {
        for (int i5 = 0; i5 < i4; i5++) {
            int i6 = i + i5;
            jArr[i6] = jArr[i6] ^ (jArr2[i2 + i5] ^ jArr3[i3 + i5]);
        }
    }

    /* renamed from: c */
    private int m1859c(int i) {
        int i2 = (i + 62) >>> 6;
        while (i2 != 0) {
            i2--;
            long j = this.f2533b[i2];
            if (j != 0) {
                return (i2 << 6) + m1844a(j);
            }
        }
        return 0;
    }

    /* renamed from: c */
    private static long m1860c(long[] jArr, int i, long[] jArr2, int i2, int i3, int i4) {
        int i5 = 64 - i4;
        long j = 0;
        while (true) {
            i3--;
            if (i3 < 0) {
                return j;
            }
            long j2 = jArr2[i2 + i3];
            int i6 = i + i3;
            jArr[i6] = (j | (j2 >>> i4)) ^ jArr[i6];
            j = j2 << i5;
        }
    }

    /* renamed from: a */
    public final int mo18174a(int i) {
        long[] jArr = this.f2533b;
        int min = Math.min(i, jArr.length);
        if (min <= 0) {
            return 0;
        }
        if (jArr[0] != 0) {
            do {
                min--;
            } while (jArr[min] == 0);
            return min + 1;
        }
        do {
            min--;
            if (jArr[min] != 0) {
                return min + 1;
            }
        } while (min > 0);
        return 0;
    }

    /* renamed from: a */
    public final void mo18177a(int i, int[] iArr) {
        long[] jArr = this.f2533b;
        int a = m1845a(jArr, 0, jArr.length, i, iArr);
        if (a < jArr.length) {
            long[] jArr2 = new long[a];
            this.f2533b = jArr2;
            System.arraycopy(jArr, 0, jArr2, 0, a);
        }
    }

    /* renamed from: a */
    public final boolean mo18179a() {
        long[] jArr = this.f2533b;
        if (jArr[0] != 1) {
            return false;
        }
        for (int i = 1; i < jArr.length; i++) {
            if (jArr[i] != 0) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: b */
    public final C1995f mo18181b(C1995f fVar) {
        int i;
        int i2;
        C1995f fVar2;
        C1995f fVar3;
        int c = mo18183c();
        if (c == 0) {
            return this;
        }
        int c2 = fVar.mo18183c();
        if (c2 == 0) {
            return fVar;
        }
        if (c > c2) {
            i = c;
            i2 = c2;
            fVar3 = this;
            fVar2 = fVar;
        } else {
            i2 = c;
            i = c2;
            fVar2 = this;
            fVar3 = fVar;
        }
        int i3 = (i2 + 63) >>> 6;
        int i4 = (i + 63) >>> 6;
        int i5 = ((i2 + i) + 62) >>> 6;
        if (i3 == 1) {
            long j = fVar2.f2533b[0];
            if (j == 1) {
                return fVar3;
            }
            long[] jArr = new long[i5];
            m1847a(j, fVar3.f2533b, i4, jArr);
            return new C1995f(jArr, 0, i5);
        }
        int i6 = ((i + 7) + 63) >>> 6;
        int[] iArr = new int[16];
        int i7 = i6 << 4;
        long[] jArr2 = new long[i7];
        iArr[1] = i6;
        System.arraycopy(fVar3.f2533b, 0, jArr2, i6, i4);
        int i8 = i6;
        for (int i9 = 2; i9 < 16; i9++) {
            i8 += i6;
            iArr[i9] = i8;
            if ((i9 & 1) == 0) {
                m1846a(jArr2, i8 >>> 1, jArr2, i8, i6, 1);
            } else {
                m1852a(jArr2, i6, jArr2, i8 - i6, jArr2, i8, i6);
            }
        }
        long[] jArr3 = new long[i7];
        m1846a(jArr2, 0, jArr3, 0, i7, 4);
        long[] jArr4 = fVar2.f2533b;
        int i10 = i5 << 3;
        long[] jArr5 = new long[i10];
        for (int i11 = 0; i11 < i3; i11++) {
            long j2 = jArr4[i11];
            int i12 = i11;
            while (true) {
                long j3 = j2 >>> 4;
                m1858b(jArr5, i12, jArr2, iArr[((int) j2) & 15], jArr3, iArr[((int) j3) & 15], i6);
                j2 = j3 >>> 4;
                if (j2 == 0) {
                    break;
                }
                i12 += i5;
            }
        }
        while (true) {
            i10 -= i5;
            if (i10 == 0) {
                return new C1995f(jArr5, 0, i5);
            }
            m1855b(jArr5, i10 - i5, jArr5, i10, i5, 8);
            jArr5 = jArr5;
        }
    }

    /* renamed from: b */
    public final boolean mo18182b() {
        long[] jArr = this.f2533b;
        for (long j : jArr) {
            if (j != 0) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: c */
    public final int mo18183c() {
        int length = this.f2533b.length;
        while (length != 0) {
            length--;
            long j = this.f2533b[length];
            if (j != 0) {
                return (length << 6) + m1844a(j);
            }
        }
        return 0;
    }

    /* renamed from: c */
    public final C1995f mo18184c(int i, int[] iArr) {
        int c = mo18183c();
        if (c != 0) {
            int i2 = 1;
            if (c == 1) {
                return this;
            }
            int i3 = (i + 63) >>> 6;
            C1995f fVar = new C1995f(i3);
            m1857b(fVar.f2533b, 0, i, i, iArr);
            C1995f fVar2 = new C1995f(i3);
            fVar2.f2533b[0] = 1;
            C1995f fVar3 = new C1995f(i3);
            int[] iArr2 = {c, i + 1};
            C1995f[] fVarArr = {(C1995f) clone(), fVar};
            int[] iArr3 = {1, 0};
            C1995f[] fVarArr2 = {fVar2, fVar3};
            int i4 = iArr2[1];
            int i5 = iArr3[1];
            int i6 = i4 - iArr2[0];
            while (true) {
                if (i6 < 0) {
                    i6 = -i6;
                    iArr2[i2] = i4;
                    iArr3[i2] = i5;
                    int i7 = 1 - i2;
                    int i8 = iArr2[i7];
                    i5 = iArr3[i7];
                    int i9 = i8;
                    i2 = i7;
                    i4 = i9;
                }
                int i10 = 1 - i2;
                fVarArr[i2].m1848a(fVarArr[i10], iArr2[i10], i6);
                int c2 = fVarArr[i2].m1859c(i4);
                if (c2 == 0) {
                    return fVarArr2[i10];
                }
                int i11 = iArr3[i10];
                fVarArr2[i2].m1848a(fVarArr2[i10], i11, i6);
                int i12 = i11 + i6;
                if (i12 > i5) {
                    i5 = i12;
                } else if (i12 == i5) {
                    i5 = fVarArr2[i2].m1859c(i5);
                }
                i6 += c2 - i4;
                i4 = c2;
            }
        } else {
            throw new IllegalStateException();
        }
    }

    /* renamed from: d */
    public final boolean mo18186d() {
        long[] jArr = this.f2533b;
        return jArr.length > 0 && (1 & jArr[0]) != 0;
    }

    /* renamed from: a */
    private void m1848a(C1995f fVar, int i, int i2) {
        int i3 = (i + 63) >>> 6;
        int i4 = i2 >>> 6;
        int i5 = i2 & 63;
        if (i5 == 0) {
            long[] jArr = this.f2533b;
            long[] jArr2 = fVar.f2533b;
            for (int i6 = 0; i6 < i3; i6++) {
                int i7 = i4 + i6;
                jArr[i7] = jArr[i7] ^ jArr2[i6 + 0];
            }
            return;
        }
        long b = m1855b(this.f2533b, i4, fVar.f2533b, 0, i3, i5);
        if (b != 0) {
            long[] jArr3 = this.f2533b;
            int i8 = i3 + i4;
            jArr3[i8] = b ^ jArr3[i8];
        }
    }

    /* renamed from: a */
    public final void mo18178a(C1995f fVar) {
        int a = fVar.mo18174a(fVar.f2533b.length);
        if (a != 0) {
            long[] jArr = this.f2533b;
            if (a > jArr.length) {
                long[] jArr2 = new long[a];
                System.arraycopy(jArr, 0, jArr2, 0, Math.min(jArr.length, a));
                this.f2533b = jArr2;
            }
            long[] jArr3 = this.f2533b;
            long[] jArr4 = fVar.f2533b;
            for (int i = 0; i < a; i++) {
                int i2 = i + 0;
                jArr3[i2] = jArr3[i2] ^ jArr4[i2];
            }
        }
    }

    /* renamed from: a */
    private static void m1847a(long j, long[] jArr, int i, long[] jArr2) {
        int i2 = i;
        if ((j & 1) != 0) {
            for (int i3 = 0; i3 < i2; i3++) {
                int i4 = i3 + 0;
                jArr2[i4] = jArr2[i4] ^ jArr[i4];
            }
        }
        int i5 = 1;
        long j2 = j;
        while (true) {
            long j3 = j2 >>> 1;
            if (j3 != 0) {
                if ((j3 & 1) != 0) {
                    long b = m1855b(jArr2, 0, jArr, 0, i, i5);
                    if (b != 0) {
                        jArr2[i2] = b ^ jArr2[i2];
                    }
                }
                i5++;
                j2 = j3;
            } else {
                return;
            }
        }
    }

    /* renamed from: a */
    public final C1995f mo18176a(C1995f fVar, int i, int[] iArr) {
        int i2;
        int i3;
        C1995f fVar2;
        C1995f fVar3;
        long[] jArr;
        int i4 = i;
        int[] iArr2 = iArr;
        int c = mo18183c();
        if (c == 0) {
            return this;
        }
        int c2 = fVar.mo18183c();
        if (c2 == 0) {
            return fVar;
        }
        if (c > c2) {
            i2 = c;
            i3 = c2;
            fVar3 = this;
            fVar2 = fVar;
        } else {
            i3 = c;
            i2 = c2;
            fVar2 = this;
            fVar3 = fVar;
        }
        int i5 = (i3 + 63) >>> 6;
        int i6 = (i2 + 63) >>> 6;
        int i7 = ((i3 + i2) + 62) >>> 6;
        if (i5 == 1) {
            long j = fVar2.f2533b[0];
            if (j == 1) {
                return fVar3;
            }
            long[] jArr2 = new long[i7];
            m1847a(j, fVar3.f2533b, i6, jArr2);
            return new C1995f(jArr2, 0, m1845a(jArr2, 0, i7, i4, iArr2));
        }
        int i8 = ((i2 + 7) + 63) >>> 6;
        int[] iArr3 = new int[16];
        int i9 = i8 << 4;
        long[] jArr3 = new long[i9];
        iArr3[1] = i8;
        System.arraycopy(fVar3.f2533b, 0, jArr3, i8, i6);
        int i10 = i8;
        for (int i11 = 2; i11 < 16; i11++) {
            i10 += i8;
            iArr3[i11] = i10;
            if ((i11 & 1) == 0) {
                m1846a(jArr3, i10 >>> 1, jArr3, i10, i8, 1);
            } else {
                m1852a(jArr3, i8, jArr3, i10 - i8, jArr3, i10, i8);
            }
        }
        long[] jArr4 = new long[i9];
        m1846a(jArr3, 0, jArr4, 0, i9, 4);
        long[] jArr5 = fVar2.f2533b;
        int i12 = i7 << 3;
        long[] jArr6 = new long[i12];
        int i13 = 0;
        while (i13 < i5) {
            int i14 = i13;
            long j2 = jArr5[i13];
            while (true) {
                long j3 = j2 >>> 4;
                jArr = jArr5;
                m1858b(jArr6, i14, jArr3, iArr3[((int) j2) & 15], jArr4, iArr3[((int) j3) & 15], i8);
                j2 = j3 >>> 4;
                if (j2 == 0) {
                    break;
                }
                i14 += i7;
                jArr5 = jArr;
            }
            i13++;
            jArr5 = jArr;
        }
        while (true) {
            i12 -= i7;
            if (i12 != 0) {
                m1855b(jArr6, i12 - i7, jArr6, i12, i7, 8);
                jArr6 = jArr6;
            } else {
                long[] jArr7 = jArr6;
                return new C1995f(jArr7, 0, m1845a(jArr7, 0, i7, i4, iArr2));
            }
        }
    }

    /* renamed from: a */
    private static int m1845a(long[] jArr, int i, int i2, int i3, int[] iArr) {
        long[] jArr2 = jArr;
        int i4 = i2;
        int i5 = i3;
        int[] iArr2 = iArr;
        int i6 = (i5 + 63) >>> 6;
        if (i4 < i6) {
            return i4;
        }
        int i7 = i4 << 6;
        int min = Math.min(i7, (i5 << 1) - 1);
        int i8 = i7 - min;
        int i9 = i4;
        while (i8 >= 64) {
            i9--;
            i8 -= 64;
        }
        int length = iArr2.length;
        int i10 = iArr2[length - 1];
        int i11 = length > 1 ? iArr2[length - 2] : 0;
        int max = Math.max(i5, i10 + 64);
        int min2 = (i8 + Math.min(min - max, i5 - i11)) >> 6;
        if (min2 > 1) {
            int i12 = i9 - min2;
            m1856b(jArr, 0, i9, i12, i3, iArr);
            while (i9 > i12) {
                i9--;
                jArr2[i9 + 0] = 0;
            }
            min = i12 << 6;
        }
        if (min > max) {
            m1849a(jArr, 0, i9, max, i3, iArr);
        } else {
            max = min;
        }
        if (max > i5) {
            while (true) {
                max--;
                if (max < i5) {
                    break;
                } else if (m1853a(jArr, 0, max)) {
                    m1857b(jArr, 0, max, i5, iArr2);
                }
            }
        }
        return i6;
    }

    /* renamed from: b */
    private static void m1857b(long[] jArr, int i, int i2, int i3, int[] iArr) {
        int i4 = (i2 >>> 6) + i;
        jArr[i4] = (1 << (i2 & 63)) ^ jArr[i4];
        int i5 = i2 - i3;
        int length = iArr.length;
        while (true) {
            length--;
            if (length >= 0) {
                int i6 = iArr[length] + i5;
                int i7 = (i6 >>> 6) + i;
                jArr[i7] = (1 << (i6 & 63)) ^ jArr[i7];
            } else {
                int i8 = i + (i5 >>> 6);
                jArr[i8] = jArr[i8] ^ (1 << (i5 & 63));
                return;
            }
        }
    }

    /* renamed from: d */
    private static void m1861d(long[] jArr, int i, long[] jArr2, int i2, int i3, int i4) {
        int i5 = i + (i4 >>> 6);
        int i6 = i4 & 63;
        if (i6 == 0) {
            for (int i7 = 0; i7 < i3; i7++) {
                int i8 = i5 + i7;
                jArr[i8] = jArr[i8] ^ jArr2[i2 + i7];
            }
            return;
        }
        jArr[i5] = m1860c(jArr, i5 + 1, jArr2, i2, i3, 64 - i6) ^ jArr[i5];
    }

    /* renamed from: b */
    public final C1995f mo18180b(int i, int[] iArr) {
        int a = mo18174a(this.f2533b.length);
        if (a == 0) {
            return this;
        }
        int i2 = a << 1;
        long[] jArr = new long[i2];
        int i3 = 0;
        while (i3 < i2) {
            long j = this.f2533b[i3 >>> 1];
            int i4 = i3 + 1;
            jArr[i3] = m1854b((int) j);
            i3 = i4 + 1;
            jArr[i4] = m1854b((int) (j >>> 32));
        }
        return new C1995f(jArr, 0, m1845a(jArr, 0, i2, i, iArr));
    }

    /* renamed from: a */
    public final C1995f mo18175a(int i, int i2, int[] iArr) {
        int a = mo18174a(this.f2533b.length);
        if (a == 0) {
            return this;
        }
        int i3 = ((i2 + 63) >>> 6) << 1;
        long[] jArr = new long[i3];
        System.arraycopy(this.f2533b, 0, jArr, 0, a);
        while (true) {
            i--;
            if (i < 0) {
                return new C1995f(jArr, 0, a);
            }
            int i4 = a << 1;
            while (true) {
                a--;
                if (a < 0) {
                    break;
                }
                long j = jArr[a];
                int i5 = i4 - 1;
                jArr[i5] = m1854b((int) (j >>> 32));
                i4 = i5 - 1;
                jArr[i4] = m1854b((int) j);
            }
            a = m1845a(jArr, 0, i3, i2, iArr);
        }
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof C1995f)) {
            return false;
        }
        C1995f fVar = (C1995f) obj;
        int a = mo18174a(this.f2533b.length);
        if (fVar.mo18174a(fVar.f2533b.length) != a) {
            return false;
        }
        for (int i = 0; i < a; i++) {
            if (this.f2533b[i] != fVar.f2533b[i]) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int a = mo18174a(this.f2533b.length);
        int i = 1;
        for (int i2 = 0; i2 < a; i2++) {
            long j = this.f2533b[i2];
            i = (((i * 31) ^ ((int) j)) * 31) ^ ((int) (j >>> 32));
        }
        return i;
    }

    public final Object clone() {
        long[] jArr;
        long[] jArr2 = this.f2533b;
        if (jArr2 == null) {
            jArr = null;
        } else {
            long[] jArr3 = new long[jArr2.length];
            System.arraycopy(jArr2, 0, jArr3, 0, jArr2.length);
            jArr = jArr3;
        }
        return new C1995f(jArr);
    }

    public final String toString() {
        int a = mo18174a(this.f2533b.length);
        if (a == 0) {
            return "0";
        }
        int i = a - 1;
        StringBuffer stringBuffer = new StringBuffer(Long.toBinaryString(this.f2533b[i]));
        while (true) {
            i--;
            if (i < 0) {
                return stringBuffer.toString();
            }
            String binaryString = Long.toBinaryString(this.f2533b[i]);
            int length = binaryString.length();
            if (length < 64) {
                stringBuffer.append("0000000000000000000000000000000000000000000000000000000000000000".substring(length));
            }
            stringBuffer.append(binaryString);
        }
    }
}
