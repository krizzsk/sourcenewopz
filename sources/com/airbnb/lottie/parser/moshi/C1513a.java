package com.airbnb.lottie.parser.moshi;

import org.osgi.framework.VersionRange;

/* renamed from: com.airbnb.lottie.parser.moshi.a */
/* compiled from: JsonScope */
final class C1513a {

    /* renamed from: a */
    static final int f1625a = 1;

    /* renamed from: b */
    static final int f1626b = 2;

    /* renamed from: c */
    static final int f1627c = 3;

    /* renamed from: d */
    static final int f1628d = 4;

    /* renamed from: e */
    static final int f1629e = 5;

    /* renamed from: f */
    static final int f1630f = 6;

    /* renamed from: g */
    static final int f1631g = 7;

    /* renamed from: h */
    static final int f1632h = 8;

    private C1513a() {
    }

    /* renamed from: a */
    static String m1437a(int i, int[] iArr, String[] strArr, int[] iArr2) {
        StringBuilder sb = new StringBuilder();
        sb.append('$');
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = iArr[i2];
            if (i3 == 1 || i3 == 2) {
                sb.append(VersionRange.LEFT_CLOSED);
                sb.append(iArr2[i2]);
                sb.append(VersionRange.RIGHT_CLOSED);
            } else if (i3 == 3 || i3 == 4 || i3 == 5) {
                sb.append('.');
                if (strArr[i2] != null) {
                    sb.append(strArr[i2]);
                }
            }
        }
        return sb.toString();
    }
}
