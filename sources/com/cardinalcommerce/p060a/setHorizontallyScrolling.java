package com.cardinalcommerce.p060a;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.p071io.IOUtils;
import org.osgi.framework.VersionRange;

/* renamed from: com.cardinalcommerce.a.setHorizontallyScrolling */
public abstract class setHorizontallyScrolling {

    /* renamed from: a */
    private static char f2800a = '0';

    /* renamed from: b */
    private static int f2801b = 0;

    /* renamed from: c */
    private static int f2802c = 1;

    static {
        boolean z = false;
        int i = (0 & -98) | ((~0) & 97);
        int i2 = (0 & 97) << 1;
        int i3 = (i ^ i2) + ((i & i2) << 1);
        f2802c = i3 % 128;
        if (i3 % 2 == 0) {
            z = true;
        }
        if (z) {
            Object obj = null;
            super.hashCode();
        }
    }

    public static boolean init(char[] cArr) {
        int i = f2802c;
        int i2 = ((i ^ 107) | (i & 107)) << 1;
        int i3 = -(((~i) & 107) | (i & -108));
        int i4 = (i2 ^ i3) + ((i3 & i2) << 1);
        f2801b = i4 % 128;
        int i5 = i4 % 2;
        if (!(cArr == null)) {
            int i6 = f2801b;
            int i7 = ((i6 ^ 93) | (i6 & 93)) << 1;
            int i8 = -(((~i6) & 93) | (i6 & -94));
            int i9 = (i7 ^ i8) + ((i8 & i7) << 1);
            f2802c = i9 % 128;
            int i10 = i9 % 2;
            if ((cArr.length == 0 ? '`' : VersionRange.RIGHT_OPEN) == ')') {
                int i11 = f2802c;
                int i12 = (i11 ^ 27) + ((i11 & 27) << 1);
                f2801b = i12 % 128;
                if (i12 % 2 == 0) {
                    return false;
                }
                Object obj = null;
                super.hashCode();
                return false;
            }
        }
        int i13 = f2802c;
        int i14 = i13 & 19;
        int i15 = ((i13 ^ 19) | i14) << 1;
        int i16 = -((i13 | 19) & (~i14));
        int i17 = (i15 & i16) + (i16 | i15);
        f2801b = i17 % 128;
        int i18 = i17 % 2;
        return true;
    }

    /* JADX WARNING: type inference failed for: r4v0, types: [java.lang.String] */
    public static String configure(char[] cArr) {
        int i = f2801b;
        int i2 = (i & 8) + (i | 8);
        int i3 = (i2 & -1) + (i2 | -1);
        f2802c = i3 % 128;
        int i4 = i3 % 2;
        char c = 'A';
        ? r4 = 0;
        if (cArr != null) {
            int i5 = f2801b;
            int i6 = i5 & 65;
            int i7 = (((i5 ^ 65) | i6) << 1) - ((i5 | 65) & (~i6));
            f2802c = i7 % 128;
            int i8 = i7 % 2;
            if (!(cArr.length == 0)) {
                String str = new String(cArr);
                int i9 = f2802c;
                int i10 = i9 & 125;
                int i11 = (i9 ^ 125) | i10;
                int i12 = (i10 ^ i11) + ((i11 & i10) << 1);
                f2801b = i12 % 128;
                if ((i12 % 2 != 0 ? 'V' : VersionRange.RIGHT_CLOSED) != 'V') {
                    return str;
                }
                int length = r4.length;
                return str;
            }
        }
        int i13 = f2802c + 3;
        f2801b = i13 % 128;
        if (i13 % 2 != 0) {
            c = IOUtils.DIR_SEPARATOR_WINDOWS;
        }
        if (c != '\\') {
            return r4;
        }
        int i14 = 1 / 0;
        return r4;
    }

    public static String configure(List<char[]> list) {
        StringBuilder sb = new StringBuilder();
        Iterator<char[]> it = list.iterator();
        int i = f2802c;
        int i2 = ((i | 73) << 1) - (i ^ 73);
        f2801b = i2 % 128;
        int i3 = i2 % 2;
        while (true) {
            if (it.hasNext()) {
                int i4 = f2802c;
                int i5 = i4 & 103;
                int i6 = (i4 | 103) & (~i5);
                int i7 = -(-(i5 << 1));
                int i8 = (i6 & i7) + (i6 | i7);
                f2801b = i8 % 128;
                if ((i8 % 2 != 0 ? ':' : 3) != ':') {
                    sb.append(it.next());
                } else {
                    sb.append(it.next());
                    Object[] objArr = null;
                    int length = objArr.length;
                }
                int i9 = ((f2802c + 57) - 1) - 1;
                f2801b = i9 % 128;
                int i10 = i9 % 2;
            } else {
                String obj = sb.toString();
                int i11 = f2801b;
                int i12 = ((i11 ^ 103) - (~(-(-((i11 & 103) << 1))))) - 1;
                f2802c = i12 % 128;
                int i13 = i12 % 2;
                return obj;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0036, code lost:
        if ((!r2) != false) goto L_0x0046;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0044, code lost:
        if ((r4.isEmpty()) != true) goto L_0x0046;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static char[] getInstance(java.lang.String r4) {
        /*
            int r0 = f2802c
            int r0 = r0 + 55
            int r1 = r0 % 128
            f2801b = r1
            int r0 = r0 % 2
            r0 = 0
            r1 = 1
            if (r4 == 0) goto L_0x0010
            r2 = 1
            goto L_0x0011
        L_0x0010:
            r2 = 0
        L_0x0011:
            if (r2 == r1) goto L_0x0014
            goto L_0x0065
        L_0x0014:
            int r2 = f2802c
            r3 = r2 ^ 15
            r2 = r2 & 15
            int r2 = r2 << r1
            int r3 = r3 + r2
            int r2 = r3 % 128
            f2801b = r2
            int r3 = r3 % 2
            if (r3 == 0) goto L_0x0026
            r2 = 0
            goto L_0x0027
        L_0x0026:
            r2 = 1
        L_0x0027:
            if (r2 == r1) goto L_0x003b
            boolean r2 = r4.isEmpty()
            r3 = 0
            super.hashCode()     // Catch:{ all -> 0x0039 }
            if (r2 == 0) goto L_0x0035
            r2 = 0
            goto L_0x0036
        L_0x0035:
            r2 = 1
        L_0x0036:
            if (r2 == 0) goto L_0x0065
            goto L_0x0046
        L_0x0039:
            r4 = move-exception
            throw r4
        L_0x003b:
            boolean r2 = r4.isEmpty()
            if (r2 == 0) goto L_0x0043
            r2 = 1
            goto L_0x0044
        L_0x0043:
            r2 = 0
        L_0x0044:
            if (r2 == r1) goto L_0x0065
        L_0x0046:
            char[] r4 = r4.toCharArray()
            int r2 = f2801b
            int r2 = r2 + 13
            int r2 = r2 - r1
            int r2 = r2 - r1
            int r1 = r2 % 128
            f2802c = r1
            int r2 = r2 % 2
            r1 = 85
            if (r2 != 0) goto L_0x005c
            r2 = 4
            goto L_0x005e
        L_0x005c:
            r2 = 85
        L_0x005e:
            if (r2 == r1) goto L_0x0064
            int r1 = r1 / r0
            return r4
        L_0x0062:
            r4 = move-exception
            throw r4
        L_0x0064:
            return r4
        L_0x0065:
            char[] r4 = new char[r0]
            int r0 = f2802c
            r2 = r0 & 71
            int r3 = ~r2
            r0 = r0 | 71
            r0 = r0 & r3
            int r1 = r2 << 1
            int r1 = -r1
            int r1 = -r1
            r2 = r0 & r1
            r0 = r0 | r1
            int r2 = r2 + r0
            int r0 = r2 % 128
            f2801b = r0
            int r2 = r2 % 2
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.setHorizontallyScrolling.getInstance(java.lang.String):char[]");
    }

    public static char[] getInstance(char[] cArr) {
        int i = f2801b;
        int i2 = (i ^ 66) + ((i & 66) << 1);
        int i3 = (i2 ^ -1) + ((i2 & -1) << 1);
        f2802c = i3 % 128;
        int i4 = i3 % 2;
        if (!(init(cArr))) {
            Arrays.fill(cArr, f2800a);
            int i5 = f2802c;
            int i6 = i5 & 83;
            int i7 = (i5 | 83) & (~i6);
            int i8 = i6 << 1;
            int i9 = ((i7 | i8) << 1) - (i7 ^ i8);
            f2801b = i9 % 128;
            int i10 = i9 % 2;
            return cArr;
        }
        int i11 = f2802c;
        int i12 = i11 & 25;
        int i13 = (i11 ^ 25) | i12;
        int i14 = (i12 ^ i13) + ((i13 & i12) << 1);
        f2801b = i14 % 128;
        int i15 = i14 % 2;
        char[] cArr2 = new char[0];
        int i16 = (f2802c + 36) - 1;
        f2801b = i16 % 128;
        int i17 = i16 % 2;
        return cArr2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x003d, code lost:
        r1 = r6.iterator();
        r2 = f2801b;
        r4 = r2 & 57;
        r2 = (r2 ^ 57) | r4;
        r5 = ((r4 | r2) << 1) - (r2 ^ r4);
        f2802c = r5 % 128;
        r5 = r5 % 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0053, code lost:
        r4 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0058, code lost:
        if (r1.hasNext() == false) goto L_0x005c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x005a, code lost:
        r2 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x005c, code lost:
        r2 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x005d, code lost:
        if (r2 == true) goto L_0x0073;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x005f, code lost:
        r1 = f2802c;
        r0 = ((r1 | 45) << 1) - (((~r1) & 45) | (r1 & -46));
        f2801b = r0 % 128;
        r0 = r0 % 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0072, code lost:
        return r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0073, code lost:
        r2 = f2802c;
        r5 = ((r2 | 45) << 1) - (r2 ^ 45);
        f2801b = r5 % 128;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0081, code lost:
        if ((r5 % 2) == 0) goto L_0x0084;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0084, code lost:
        r4 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0085, code lost:
        if (r4 == false) goto L_0x0091;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0087, code lost:
        getInstance(r1.next());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0091, code lost:
        getInstance(r1.next());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        r2 = r3.length;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x009b, code lost:
        r2 = f2801b;
        r5 = r2 & 101;
        r4 = ((((r2 ^ 101) | r5) << 1) - (~(-((r2 | 101) & (~r5))))) - 1;
        f2802c = r4 % 128;
        r4 = r4 % 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001c, code lost:
        if (r6 == null) goto L_0x0022;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0020, code lost:
        if (r6 == null) goto L_0x0022;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.List<char[]> init(java.util.List<char[]> r6) {
        /*
            int r0 = f2802c
            r1 = r0 & 107(0x6b, float:1.5E-43)
            r0 = r0 | 107(0x6b, float:1.5E-43)
            int r0 = ~r0
            int r1 = r1 - r0
            r0 = 1
            int r1 = r1 - r0
            int r2 = r1 % 128
            f2801b = r2
            int r1 = r1 % 2
            r2 = 91
            if (r1 == 0) goto L_0x0017
            r1 = 91
            goto L_0x0019
        L_0x0017:
            r1 = 51
        L_0x0019:
            r3 = 0
            if (r1 == r2) goto L_0x001f
            if (r6 != 0) goto L_0x003d
            goto L_0x0022
        L_0x001f:
            int r1 = r3.length     // Catch:{ all -> 0x00b4 }
            if (r6 != 0) goto L_0x003d
        L_0x0022:
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            int r1 = f2801b
            r2 = r1 & 13
            r1 = r1 ^ 13
            r1 = r1 | r2
            int r1 = -r1
            int r1 = -r1
            r3 = r2 ^ r1
            r1 = r1 & r2
            int r0 = r1 << 1
            int r3 = r3 + r0
            int r0 = r3 % 128
            f2802c = r0
            int r3 = r3 % 2
            return r6
        L_0x003d:
            java.util.Iterator r1 = r6.iterator()
            int r2 = f2801b
            r4 = r2 & 57
            r2 = r2 ^ 57
            r2 = r2 | r4
            r5 = r4 | r2
            int r5 = r5 << r0
            r2 = r2 ^ r4
            int r5 = r5 - r2
            int r2 = r5 % 128
            f2802c = r2
            int r5 = r5 % 2
        L_0x0053:
            boolean r2 = r1.hasNext()
            r4 = 0
            if (r2 == 0) goto L_0x005c
            r2 = 1
            goto L_0x005d
        L_0x005c:
            r2 = 0
        L_0x005d:
            if (r2 == r0) goto L_0x0073
            int r1 = f2802c
            r2 = r1 | 45
            int r0 = r2 << 1
            r2 = r1 & -46
            int r1 = ~r1
            r1 = r1 & 45
            r1 = r1 | r2
            int r0 = r0 - r1
            int r1 = r0 % 128
            f2801b = r1
            int r0 = r0 % 2
            return r6
        L_0x0073:
            int r2 = f2802c
            r5 = r2 | 45
            int r5 = r5 << r0
            r2 = r2 ^ 45
            int r5 = r5 - r2
            int r2 = r5 % 128
            f2801b = r2
            int r5 = r5 % 2
            if (r5 == 0) goto L_0x0084
            goto L_0x0085
        L_0x0084:
            r4 = 1
        L_0x0085:
            if (r4 == 0) goto L_0x0091
            java.lang.Object r2 = r1.next()
            char[] r2 = (char[]) r2
            getInstance((char[]) r2)
            goto L_0x009b
        L_0x0091:
            java.lang.Object r2 = r1.next()
            char[] r2 = (char[]) r2
            getInstance((char[]) r2)
            int r2 = r3.length     // Catch:{ all -> 0x00b2 }
        L_0x009b:
            int r2 = f2801b
            r4 = r2 ^ 101(0x65, float:1.42E-43)
            r5 = r2 & 101(0x65, float:1.42E-43)
            r4 = r4 | r5
            int r4 = r4 << r0
            int r5 = ~r5
            r2 = r2 | 101(0x65, float:1.42E-43)
            r2 = r2 & r5
            int r2 = -r2
            int r2 = ~r2
            int r4 = r4 - r2
            int r4 = r4 - r0
            int r2 = r4 % 128
            f2802c = r2
            int r4 = r4 % 2
            goto L_0x0053
        L_0x00b2:
            r6 = move-exception
            throw r6
        L_0x00b4:
            r6 = move-exception
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.setHorizontallyScrolling.init(java.util.List):java.util.List");
    }
}
