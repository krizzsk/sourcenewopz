package com.didi.dqr.oned;

import com.didi.dqr.BarcodeFormat;
import com.didi.dqr.NotFoundException;
import com.didi.dqr.Result;
import com.didi.dqr.ResultMetadataType;
import com.didi.dqr.ResultPoint;
import com.didi.dqr.common.BitArray;
import java.util.EnumMap;
import java.util.Map;

/* renamed from: com.didi.dqr.oned.c */
/* compiled from: UPCEANExtension5Support */
final class C7852c {

    /* renamed from: a */
    private static final int[] f18770a = {24, 20, 18, 17, 12, 6, 3, 10, 9, 5};

    /* renamed from: b */
    private final int[] f18771b = new int[4];

    /* renamed from: c */
    private final StringBuilder f18772c = new StringBuilder();

    C7852c() {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Result mo58379a(int i, BitArray bitArray, int[] iArr) throws NotFoundException {
        StringBuilder sb = this.f18772c;
        sb.setLength(0);
        int a = m13933a(bitArray, iArr, sb);
        String sb2 = sb.toString();
        Map<ResultMetadataType, Object> a2 = m13935a(sb2);
        float f = (float) i;
        Result result = new Result(sb2, (byte[]) null, new ResultPoint[]{new ResultPoint(((float) (iArr[0] + iArr[1])) / 2.0f, f), new ResultPoint((float) a, f)}, BarcodeFormat.UPC_EAN_EXTENSION);
        if (a2 != null) {
            result.putAllMetadata(a2);
        }
        return result;
    }

    /* renamed from: a */
    private int m13933a(BitArray bitArray, int[] iArr, StringBuilder sb) throws NotFoundException {
        int[] iArr2 = this.f18771b;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int size = bitArray.getSize();
        int i = iArr[1];
        int i2 = 0;
        for (int i3 = 0; i3 < 5 && i < size; i3++) {
            int a = UPCEANReader.m13917a(bitArray, iArr2, i, UPCEANReader.f18757f);
            sb.append((char) ((a % 10) + 48));
            for (int i4 : iArr2) {
                i += i4;
            }
            if (a >= 10) {
                i2 |= 1 << (4 - i3);
            }
            if (i3 != 4) {
                i = bitArray.getNextUnset(bitArray.getNextSet(i));
            }
        }
        if (sb.length() == 5) {
            if (m13934a((CharSequence) sb.toString()) == m13932a(i2)) {
                return i;
            }
            throw NotFoundException.getNotFoundInstance();
        }
        throw NotFoundException.getNotFoundInstance();
    }

    /* renamed from: a */
    private static int m13934a(CharSequence charSequence) {
        int length = charSequence.length();
        int i = 0;
        for (int i2 = length - 2; i2 >= 0; i2 -= 2) {
            i += charSequence.charAt(i2) - '0';
        }
        int i3 = i * 3;
        for (int i4 = length - 1; i4 >= 0; i4 -= 2) {
            i3 += charSequence.charAt(i4) - '0';
        }
        return (i3 * 3) % 10;
    }

    /* renamed from: a */
    private static int m13932a(int i) throws NotFoundException {
        for (int i2 = 0; i2 < 10; i2++) {
            if (i == f18770a[i2]) {
                return i2;
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    /* renamed from: a */
    private static Map<ResultMetadataType, Object> m13935a(String str) {
        String b;
        if (str.length() != 5 || (b = m13936b(str)) == null) {
            return null;
        }
        EnumMap enumMap = new EnumMap(ResultMetadataType.class);
        enumMap.put(ResultMetadataType.SUGGESTED_PRICE, b);
        return enumMap;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0039, code lost:
        if (r6.equals("90000") != false) goto L_0x003d;
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String m13936b(java.lang.String r6) {
        /*
            r0 = 0
            char r1 = r6.charAt(r0)
            r2 = 48
            java.lang.String r3 = ""
            r4 = 1
            if (r1 == r2) goto L_0x004f
            r2 = 53
            if (r1 == r2) goto L_0x004c
            r2 = 57
            if (r1 == r2) goto L_0x0015
            goto L_0x0052
        L_0x0015:
            r1 = -1
            int r2 = r6.hashCode()
            r5 = 2
            switch(r2) {
                case 54118329: goto L_0x0033;
                case 54395376: goto L_0x0029;
                case 54395377: goto L_0x001f;
                default: goto L_0x001e;
            }
        L_0x001e:
            goto L_0x003c
        L_0x001f:
            java.lang.String r0 = "99991"
            boolean r0 = r6.equals(r0)
            if (r0 == 0) goto L_0x003c
            r0 = 1
            goto L_0x003d
        L_0x0029:
            java.lang.String r0 = "99990"
            boolean r0 = r6.equals(r0)
            if (r0 == 0) goto L_0x003c
            r0 = 2
            goto L_0x003d
        L_0x0033:
            java.lang.String r2 = "90000"
            boolean r2 = r6.equals(r2)
            if (r2 == 0) goto L_0x003c
            goto L_0x003d
        L_0x003c:
            r0 = -1
        L_0x003d:
            if (r0 == 0) goto L_0x004a
            if (r0 == r4) goto L_0x0047
            if (r0 == r5) goto L_0x0044
            goto L_0x0052
        L_0x0044:
            java.lang.String r6 = "Used"
            return r6
        L_0x0047:
            java.lang.String r6 = "0.00"
            return r6
        L_0x004a:
            r6 = 0
            return r6
        L_0x004c:
            java.lang.String r3 = "$"
            goto L_0x0052
        L_0x004f:
            java.lang.String r3 = "£"
        L_0x0052:
            java.lang.String r6 = r6.substring(r4)
            int r6 = java.lang.Integer.parseInt(r6)
            int r0 = r6 / 100
            java.lang.String r0 = java.lang.String.valueOf(r0)
            int r6 = r6 % 100
            r1 = 10
            if (r6 >= r1) goto L_0x0078
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "0"
            r1.append(r2)
            r1.append(r6)
            java.lang.String r6 = r1.toString()
            goto L_0x007c
        L_0x0078:
            java.lang.String r6 = java.lang.String.valueOf(r6)
        L_0x007c:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r3)
            r1.append(r0)
            r0 = 46
            r1.append(r0)
            r1.append(r6)
            java.lang.String r6 = r1.toString()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.dqr.oned.C7852c.m13936b(java.lang.String):java.lang.String");
    }
}
