package com.didi.dqr.pdf417.decoder;

import com.didi.dqr.ChecksumException;
import com.didi.dqr.FormatException;
import com.didi.dqr.NotFoundException;
import com.didi.dqr.ResultPoint;
import com.didi.dqr.common.BitMatrix;
import com.didi.dqr.common.DecoderResult;
import com.didi.dqr.pdf417.PDF417Common;
import com.didi.dqr.pdf417.decoder.p109ec.ErrorCorrection;
import java.lang.reflect.Array;
import java.util.ArrayList;

public final class PDF417ScanningDecoder {

    /* renamed from: a */
    private static final int f18911a = 2;

    /* renamed from: b */
    private static final int f18912b = 3;

    /* renamed from: c */
    private static final int f18913c = 512;

    /* renamed from: d */
    private static final ErrorCorrection f18914d = new ErrorCorrection();

    /* renamed from: a */
    private static int m14052a(int i) {
        return 2 << i;
    }

    /* renamed from: a */
    private static boolean m14065a(int i, int i2, int i3) {
        return i2 + -2 <= i && i <= i3 + 2;
    }

    private PDF417ScanningDecoder() {
    }

    public static DecoderResult decode(BitMatrix bitMatrix, ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3, ResultPoint resultPoint4, int i, int i2) throws NotFoundException, FormatException, ChecksumException {
        C7880e a;
        C7882f fVar;
        int i3;
        int i4;
        int i5;
        C7883g gVar = null;
        C7883g gVar2 = null;
        C7878c cVar = new C7878c(bitMatrix, resultPoint, resultPoint2, resultPoint3, resultPoint4);
        boolean z = true;
        while (true) {
            if (resultPoint != null) {
                gVar = m14062a(bitMatrix, cVar, resultPoint, true, i, i2);
            }
            if (resultPoint3 != null) {
                gVar2 = m14062a(bitMatrix, cVar, resultPoint3, false, i, i2);
            }
            a = m14061a(gVar, gVar2);
            if (a != null) {
                C7878c e = a.mo58512e();
                if (!z || e == null || (e.mo58488c() >= cVar.mo58488c() && e.mo58489d() <= cVar.mo58489d())) {
                    a.mo58507a(cVar);
                    int b = a.mo58509b() + 1;
                    a.mo58506a(0, (C7882f) gVar);
                    a.mo58506a(b, (C7882f) gVar2);
                } else {
                    cVar = e;
                    z = false;
                }
            } else {
                throw NotFoundException.getNotFoundInstance();
            }
        }
        a.mo58507a(cVar);
        int b2 = a.mo58509b() + 1;
        a.mo58506a(0, (C7882f) gVar);
        a.mo58506a(b2, (C7882f) gVar2);
        boolean z2 = gVar != null;
        int i6 = i;
        int i7 = i2;
        for (int i8 = 1; i8 <= b2; i8++) {
            int i9 = z2 ? i8 : b2 - i8;
            if (a.mo58505a(i9) == null) {
                if (i9 == 0 || i9 == b2) {
                    fVar = new C7883g(cVar, i9 == 0);
                } else {
                    fVar = new C7882f(cVar);
                }
                a.mo58506a(i9, fVar);
                int i10 = -1;
                int c = cVar.mo58488c();
                int i11 = -1;
                while (c <= cVar.mo58489d()) {
                    int a2 = m14053a(a, i9, c, z2);
                    if (a2 >= 0 && a2 <= cVar.mo58487b()) {
                        i5 = a2;
                    } else if (i11 == i10) {
                        i4 = i11;
                        i3 = c;
                        i11 = i4;
                        c = i3 + 1;
                        i10 = -1;
                    } else {
                        i5 = i11;
                    }
                    i4 = i11;
                    int i12 = c;
                    C7879d a3 = m14060a(bitMatrix, cVar.mo58485a(), cVar.mo58487b(), z2, i5, i12, i6, i7);
                    i3 = i12;
                    if (a3 != null) {
                        fVar.mo58539a(i3, a3);
                        i6 = Math.min(i6, a3.mo58498c());
                        i7 = Math.max(i7, a3.mo58498c());
                        i11 = i5;
                        c = i3 + 1;
                        i10 = -1;
                    }
                    i11 = i4;
                    c = i3 + 1;
                    i10 = -1;
                }
            }
        }
        return m14057a(a);
    }

    /* renamed from: a */
    private static C7880e m14061a(C7883g gVar, C7883g gVar2) throws NotFoundException {
        C7876a b;
        if ((gVar == null && gVar2 == null) || (b = m14070b(gVar, gVar2)) == null) {
            return null;
        }
        return new C7880e(b, C7878c.m14082a(m14059a(gVar), m14059a(gVar2)));
    }

    /* renamed from: a */
    private static C7878c m14059a(C7883g gVar) throws NotFoundException {
        int[] c;
        if (gVar == null || (c = gVar.mo58545c()) == null) {
            return null;
        }
        int a = m14054a(c);
        int i = 0;
        int i2 = 0;
        for (int i3 : c) {
            i2 += a - i3;
            if (i3 > 0) {
                break;
            }
        }
        C7879d[] b = gVar.mo58541b();
        int i4 = 0;
        while (i2 > 0 && b[i4] == null) {
            i2--;
            i4++;
        }
        for (int length = c.length - 1; length >= 0; length--) {
            i += a - c[length];
            if (c[length] > 0) {
                break;
            }
        }
        int length2 = b.length - 1;
        while (i > 0 && b[length2] == null) {
            i--;
            length2--;
        }
        return gVar.mo58537a().mo58486a(i2, i, gVar.mo58547e());
    }

    /* renamed from: a */
    private static int m14054a(int[] iArr) {
        int i = -1;
        for (int max : iArr) {
            i = Math.max(i, max);
        }
        return i;
    }

    /* renamed from: b */
    private static C7876a m14070b(C7883g gVar, C7883g gVar2) {
        C7876a d;
        C7876a d2;
        if (gVar == null || (d = gVar.mo58546d()) == null) {
            if (gVar2 == null) {
                return null;
            }
            return gVar2.mo58546d();
        } else if (gVar2 == null || (d2 = gVar2.mo58546d()) == null || d.mo58477a() == d2.mo58477a() || d.mo58478b() == d2.mo58478b() || d.mo58479c() == d2.mo58479c()) {
            return d;
        } else {
            return null;
        }
    }

    /* renamed from: a */
    private static C7883g m14062a(BitMatrix bitMatrix, C7878c cVar, ResultPoint resultPoint, boolean z, int i, int i2) {
        int i3;
        boolean z2 = z;
        C7883g gVar = new C7883g(cVar, z2);
        int i4 = 0;
        while (i4 < 2) {
            int i5 = i4 == 0 ? 1 : -1;
            int x = (int) resultPoint.getX();
            int y = (int) resultPoint.getY();
            while (y <= cVar.mo58489d() && y >= cVar.mo58488c()) {
                C7879d a = m14060a(bitMatrix, 0, bitMatrix.getWidth(), z, x, y, i, i2);
                if (a != null) {
                    gVar.mo58539a(y, a);
                    if (z2) {
                        i3 = a.mo58499d();
                    } else {
                        i3 = a.mo58500e();
                    }
                    x = i3;
                }
                y += i5;
            }
            i4++;
        }
        return gVar;
    }

    /* renamed from: a */
    private static void m14063a(C7880e eVar, C7877b[][] bVarArr) throws NotFoundException {
        C7877b bVar = bVarArr[0][1];
        int[] a = bVar.mo58483a();
        int b = (eVar.mo58509b() * eVar.mo58510c()) - m14052a(eVar.mo58511d());
        if (a.length == 0) {
            if (b < 1 || b > 928) {
                throw NotFoundException.getNotFoundInstance();
            }
            bVar.mo58482a(b);
        } else if (a[0] != b && b >= 1 && b <= 928) {
            bVar.mo58482a(b);
        }
    }

    /* renamed from: a */
    private static DecoderResult m14057a(C7880e eVar) throws FormatException, ChecksumException, NotFoundException {
        C7877b[][] b = m14072b(eVar);
        m14063a(eVar, b);
        ArrayList arrayList = new ArrayList();
        int[] iArr = new int[(eVar.mo58510c() * eVar.mo58509b())];
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (int i = 0; i < eVar.mo58510c(); i++) {
            int i2 = 0;
            while (i2 < eVar.mo58509b()) {
                int i3 = i2 + 1;
                int[] a = b[i][i3].mo58483a();
                int b2 = (eVar.mo58509b() * i) + i2;
                if (a.length == 0) {
                    arrayList.add(Integer.valueOf(b2));
                } else if (a.length == 1) {
                    iArr[b2] = a[0];
                } else {
                    arrayList3.add(Integer.valueOf(b2));
                    arrayList2.add(a);
                }
                i2 = i3;
            }
        }
        int size = arrayList2.size();
        int[][] iArr2 = new int[size][];
        for (int i4 = 0; i4 < size; i4++) {
            iArr2[i4] = (int[]) arrayList2.get(i4);
        }
        return m14056a(eVar.mo58511d(), iArr, PDF417Common.toIntArray(arrayList), PDF417Common.toIntArray(arrayList3), iArr2);
    }

    /* renamed from: a */
    private static DecoderResult m14056a(int i, int[] iArr, int[] iArr2, int[] iArr3, int[][] iArr4) throws FormatException, ChecksumException {
        int length = iArr3.length;
        int[] iArr5 = new int[length];
        int i2 = 100;
        while (true) {
            int i3 = i2 - 1;
            if (i2 > 0) {
                for (int i4 = 0; i4 < length; i4++) {
                    iArr[iArr3[i4]] = iArr4[i4][iArr5[i4]];
                }
                try {
                    return m14058a(iArr, i, iArr2);
                } catch (ChecksumException unused) {
                    if (length != 0) {
                        int i5 = 0;
                        while (true) {
                            if (i5 >= length) {
                                break;
                            } else if (iArr5[i5] < iArr4[i5].length - 1) {
                                iArr5[i5] = iArr5[i5] + 1;
                                break;
                            } else {
                                iArr5[i5] = 0;
                                if (i5 != length - 1) {
                                    i5++;
                                } else {
                                    throw ChecksumException.getChecksumInstance();
                                }
                            }
                        }
                        i2 = i3;
                    } else {
                        throw ChecksumException.getChecksumInstance();
                    }
                }
            } else {
                throw ChecksumException.getChecksumInstance();
            }
        }
    }

    /* renamed from: b */
    private static C7877b[][] m14072b(C7880e eVar) {
        int h;
        int c = eVar.mo58510c();
        int[] iArr = new int[2];
        iArr[1] = eVar.mo58509b() + 2;
        iArr[0] = c;
        C7877b[][] bVarArr = (C7877b[][]) Array.newInstance(C7877b.class, iArr);
        for (int i = 0; i < bVarArr.length; i++) {
            for (int i2 = 0; i2 < bVarArr[i].length; i2++) {
                bVarArr[i][i2] = new C7877b();
            }
        }
        int i3 = 0;
        for (C7882f fVar : eVar.mo58508a()) {
            if (fVar != null) {
                for (C7879d dVar : fVar.mo58541b()) {
                    if (dVar != null && (h = dVar.mo58503h()) >= 0 && h < bVarArr.length) {
                        bVarArr[h][i3].mo58482a(dVar.mo58502g());
                    }
                }
            }
            i3++;
        }
        return bVarArr;
    }

    /* renamed from: a */
    private static boolean m14066a(C7880e eVar, int i) {
        return i >= 0 && i <= eVar.mo58509b() + 1;
    }

    /* renamed from: a */
    private static int m14053a(C7880e eVar, int i, int i2, boolean z) {
        int i3 = z ? 1 : -1;
        C7879d dVar = null;
        int i4 = i - i3;
        if (m14066a(eVar, i4)) {
            dVar = eVar.mo58505a(i4).mo58542c(i2);
        }
        if (dVar != null) {
            return z ? dVar.mo58500e() : dVar.mo58499d();
        }
        C7879d a = eVar.mo58505a(i).mo58538a(i2);
        if (a != null) {
            return z ? a.mo58499d() : a.mo58500e();
        }
        if (m14066a(eVar, i4)) {
            a = eVar.mo58505a(i4).mo58538a(i2);
        }
        if (a != null) {
            return z ? a.mo58500e() : a.mo58499d();
        }
        int i5 = 0;
        while (true) {
            i -= i3;
            if (m14066a(eVar, i)) {
                for (C7879d dVar2 : eVar.mo58505a(i).mo58541b()) {
                    if (dVar2 != null) {
                        return (z ? dVar2.mo58500e() : dVar2.mo58499d()) + (i3 * i5 * (dVar2.mo58500e() - dVar2.mo58499d()));
                    }
                }
                i5++;
            } else {
                C7878c e = eVar.mo58512e();
                return z ? e.mo58485a() : e.mo58487b();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0040, code lost:
        r7 = com.didi.dqr.pdf417.decoder.C7884h.m14156a(r7);
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.didi.dqr.pdf417.decoder.C7879d m14060a(com.didi.dqr.common.BitMatrix r7, int r8, int r9, boolean r10, int r11, int r12, int r13, int r14) {
        /*
            int r11 = m14068b(r7, r8, r9, r10, r11, r12)
            r0 = r7
            r1 = r8
            r2 = r9
            r3 = r10
            r4 = r11
            r5 = r12
            int[] r7 = m14067a((com.didi.dqr.common.BitMatrix) r0, (int) r1, (int) r2, (boolean) r3, (int) r4, (int) r5)
            r8 = 0
            if (r7 != 0) goto L_0x0012
            return r8
        L_0x0012:
            int r9 = com.didi.dqr.common.detector.MathUtils.sum(r7)
            if (r10 == 0) goto L_0x001b
            int r10 = r11 + r9
            goto L_0x0039
        L_0x001b:
            r10 = 0
        L_0x001c:
            int r12 = r7.length
            int r12 = r12 / 2
            if (r10 >= r12) goto L_0x0034
            r12 = r7[r10]
            int r0 = r7.length
            int r0 = r0 + -1
            int r0 = r0 - r10
            r0 = r7[r0]
            r7[r10] = r0
            int r0 = r7.length
            int r0 = r0 + -1
            int r0 = r0 - r10
            r7[r0] = r12
            int r10 = r10 + 1
            goto L_0x001c
        L_0x0034:
            int r10 = r11 - r9
            r6 = r11
            r11 = r10
            r10 = r6
        L_0x0039:
            boolean r9 = m14065a((int) r9, (int) r13, (int) r14)
            if (r9 != 0) goto L_0x0040
            return r8
        L_0x0040:
            int r7 = com.didi.dqr.pdf417.decoder.C7884h.m14156a(r7)
            int r9 = com.didi.dqr.pdf417.PDF417Common.getCodeword(r7)
            r12 = -1
            if (r9 != r12) goto L_0x004c
            return r8
        L_0x004c:
            com.didi.dqr.pdf417.decoder.d r8 = new com.didi.dqr.pdf417.decoder.d
            int r7 = m14073c(r7)
            r8.<init>(r11, r10, r7, r9)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.dqr.pdf417.decoder.PDF417ScanningDecoder.m14060a(com.didi.dqr.common.BitMatrix, int, int, boolean, int, int, int, int):com.didi.dqr.pdf417.decoder.d");
    }

    /* renamed from: a */
    private static int[] m14067a(BitMatrix bitMatrix, int i, int i2, boolean z, int i3, int i4) {
        int[] iArr = new int[8];
        int i5 = z ? 1 : -1;
        int i6 = 0;
        boolean z2 = z;
        while (true) {
            if (!z) {
                if (i3 < i) {
                    break;
                }
            } else if (i3 >= i2) {
                break;
            }
            if (i6 >= 8) {
                break;
            } else if (bitMatrix.get(i3, i4) == z2) {
                iArr[i6] = iArr[i6] + 1;
                i3 += i5;
            } else {
                i6++;
                z2 = !z2;
            }
        }
        if (i6 != 8) {
            if (z) {
                i = i2;
            }
            if (!(i3 == i && i6 == 7)) {
                return null;
            }
        }
        return iArr;
    }

    /* renamed from: b */
    private static int m14068b(BitMatrix bitMatrix, int i, int i2, boolean z, int i3, int i4) {
        int i5 = z ? -1 : 1;
        int i6 = i3;
        for (int i7 = 0; i7 < 2; i7++) {
            while (true) {
                if (!z) {
                    if (i6 >= i2) {
                        continue;
                        break;
                    }
                } else if (i6 < i) {
                    continue;
                    break;
                }
                if (z != bitMatrix.get(i6, i4)) {
                    continue;
                    break;
                } else if (Math.abs(i3 - i6) > 2) {
                    return i3;
                } else {
                    i6 += i5;
                }
            }
            i5 = -i5;
            z = !z;
        }
        return i6;
    }

    /* renamed from: a */
    private static DecoderResult m14058a(int[] iArr, int i, int[] iArr2) throws FormatException, ChecksumException {
        if (iArr.length != 0) {
            int i2 = 1 << (i + 1);
            int a = m14055a(iArr, iArr2, i2);
            m14064a(iArr, i2);
            DecoderResult a2 = DecodedBitStreamParser.m14048a(iArr, String.valueOf(i));
            a2.setErrorsCorrected(Integer.valueOf(a));
            a2.setErasures(Integer.valueOf(iArr2.length));
            return a2;
        }
        throw FormatException.getFormatInstance();
    }

    /* renamed from: a */
    private static int m14055a(int[] iArr, int[] iArr2, int i) throws ChecksumException {
        if ((iArr2 == null || iArr2.length <= (i / 2) + 3) && i >= 0 && i <= 512) {
            return f18914d.decode(iArr, i, iArr2);
        }
        throw ChecksumException.getChecksumInstance();
    }

    /* renamed from: a */
    private static void m14064a(int[] iArr, int i) throws FormatException {
        if (iArr.length >= 4) {
            int i2 = iArr[0];
            if (i2 > iArr.length) {
                throw FormatException.getFormatInstance();
            } else if (i2 != 0) {
            } else {
                if (i < iArr.length) {
                    iArr[0] = iArr.length - i;
                    return;
                }
                throw FormatException.getFormatInstance();
            }
        } else {
            throw FormatException.getFormatInstance();
        }
    }

    /* renamed from: b */
    private static int[] m14071b(int i) {
        int[] iArr = new int[8];
        int i2 = 0;
        int i3 = 7;
        while (true) {
            int i4 = i & 1;
            if (i4 != i2) {
                i3--;
                if (i3 < 0) {
                    return iArr;
                }
                i2 = i4;
            }
            iArr[i3] = iArr[i3] + 1;
            i >>= 1;
        }
    }

    /* renamed from: c */
    private static int m14073c(int i) {
        return m14069b(m14071b(i));
    }

    /* renamed from: b */
    private static int m14069b(int[] iArr) {
        return ((((iArr[0] - iArr[2]) + iArr[4]) - iArr[6]) + 9) % 9;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0069, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x006e, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x006f, code lost:
        r9.addSuppressed(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0072, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String toString(com.didi.dqr.pdf417.decoder.C7877b[][] r9) {
        /*
            java.util.Formatter r0 = new java.util.Formatter
            r0.<init>()
            r1 = 0
            r2 = 0
        L_0x0007:
            int r3 = r9.length     // Catch:{ all -> 0x0067 }
            if (r2 >= r3) goto L_0x005f
            java.lang.String r3 = "Row %2d: "
            r4 = 1
            java.lang.Object[] r5 = new java.lang.Object[r4]     // Catch:{ all -> 0x0067 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x0067 }
            r5[r1] = r6     // Catch:{ all -> 0x0067 }
            r0.format(r3, r5)     // Catch:{ all -> 0x0067 }
            r3 = 0
        L_0x0019:
            r5 = r9[r2]     // Catch:{ all -> 0x0067 }
            int r5 = r5.length     // Catch:{ all -> 0x0067 }
            if (r3 >= r5) goto L_0x0055
            r5 = r9[r2]     // Catch:{ all -> 0x0067 }
            r5 = r5[r3]     // Catch:{ all -> 0x0067 }
            int[] r6 = r5.mo58483a()     // Catch:{ all -> 0x0067 }
            int r6 = r6.length     // Catch:{ all -> 0x0067 }
            if (r6 != 0) goto L_0x0032
            java.lang.String r5 = "        "
            r6 = 0
            java.lang.Object[] r6 = (java.lang.Object[]) r6     // Catch:{ all -> 0x0067 }
            r0.format(r5, r6)     // Catch:{ all -> 0x0067 }
            goto L_0x0052
        L_0x0032:
            java.lang.String r6 = "%4d(%2d)"
            r7 = 2
            java.lang.Object[] r7 = new java.lang.Object[r7]     // Catch:{ all -> 0x0067 }
            int[] r8 = r5.mo58483a()     // Catch:{ all -> 0x0067 }
            r8 = r8[r1]     // Catch:{ all -> 0x0067 }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x0067 }
            r7[r1] = r8     // Catch:{ all -> 0x0067 }
            int[] r8 = r5.mo58483a()     // Catch:{ all -> 0x0067 }
            r8 = r8[r1]     // Catch:{ all -> 0x0067 }
            java.lang.Integer r5 = r5.mo58484b(r8)     // Catch:{ all -> 0x0067 }
            r7[r4] = r5     // Catch:{ all -> 0x0067 }
            r0.format(r6, r7)     // Catch:{ all -> 0x0067 }
        L_0x0052:
            int r3 = r3 + 1
            goto L_0x0019
        L_0x0055:
            java.lang.String r3 = "%n"
            java.lang.Object[] r4 = new java.lang.Object[r1]     // Catch:{ all -> 0x0067 }
            r0.format(r3, r4)     // Catch:{ all -> 0x0067 }
            int r2 = r2 + 1
            goto L_0x0007
        L_0x005f:
            java.lang.String r9 = r0.toString()     // Catch:{ all -> 0x0067 }
            r0.close()
            return r9
        L_0x0067:
            r9 = move-exception
            throw r9     // Catch:{ all -> 0x0069 }
        L_0x0069:
            r1 = move-exception
            r0.close()     // Catch:{ all -> 0x006e }
            goto L_0x0072
        L_0x006e:
            r0 = move-exception
            r9.addSuppressed(r0)
        L_0x0072:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.dqr.pdf417.decoder.PDF417ScanningDecoder.toString(com.didi.dqr.pdf417.decoder.b[][]):java.lang.String");
    }
}
