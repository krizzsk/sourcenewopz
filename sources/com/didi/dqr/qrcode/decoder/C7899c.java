package com.didi.dqr.qrcode.decoder;

/* renamed from: com.didi.dqr.qrcode.decoder.c */
/* compiled from: FormatInformation */
final class C7899c {

    /* renamed from: a */
    private static final int f19036a = 21522;

    /* renamed from: b */
    private static final int[][] f19037b = {new int[]{21522, 0}, new int[]{20773, 1}, new int[]{24188, 2}, new int[]{23371, 3}, new int[]{17913, 4}, new int[]{16590, 5}, new int[]{20375, 6}, new int[]{19104, 7}, new int[]{30660, 8}, new int[]{29427, 9}, new int[]{32170, 10}, new int[]{30877, 11}, new int[]{26159, 12}, new int[]{25368, 13}, new int[]{27713, 14}, new int[]{26998, 15}, new int[]{5769, 16}, new int[]{5054, 17}, new int[]{7399, 18}, new int[]{6608, 19}, new int[]{1890, 20}, new int[]{597, 21}, new int[]{3340, 22}, new int[]{2107, 23}, new int[]{13663, 24}, new int[]{12392, 25}, new int[]{16177, 26}, new int[]{14854, 27}, new int[]{9396, 28}, new int[]{8579, 29}, new int[]{11994, 30}, new int[]{11245, 31}};

    /* renamed from: c */
    private final ErrorCorrectionLevel f19038c;

    /* renamed from: d */
    private final byte f19039d;

    private C7899c(int i) {
        this.f19038c = ErrorCorrectionLevel.forBits((i >> 3) & 3);
        this.f19039d = (byte) (i & 7);
    }

    /* renamed from: a */
    static int m14226a(int i, int i2) {
        return Integer.bitCount(i ^ i2);
    }

    /* renamed from: b */
    static C7899c m14227b(int i, int i2) {
        C7899c c = m14228c(i, i2);
        if (c != null) {
            return c;
        }
        return m14228c(i ^ 21522, i2 ^ 21522);
    }

    /* renamed from: c */
    private static C7899c m14228c(int i, int i2) {
        int a;
        int i3 = Integer.MAX_VALUE;
        int i4 = 0;
        for (int[] iArr : f19037b) {
            int i5 = iArr[0];
            if (i5 == i || i5 == i2) {
                return new C7899c(iArr[1]);
            }
            int a2 = m14226a(i, i5);
            if (a2 < i3) {
                i4 = iArr[1];
                i3 = a2;
            }
            if (i != i2 && (a = m14226a(i2, i5)) < i3) {
                i4 = iArr[1];
                i3 = a;
            }
        }
        if (i3 <= 3) {
            return new C7899c(i4);
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public ErrorCorrectionLevel mo58603a() {
        return this.f19038c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public byte mo58604b() {
        return this.f19039d;
    }

    public int hashCode() {
        return (this.f19038c.ordinal() << 3) | this.f19039d;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C7899c)) {
            return false;
        }
        C7899c cVar = (C7899c) obj;
        if (this.f19038c == cVar.f19038c && this.f19039d == cVar.f19039d) {
            return true;
        }
        return false;
    }
}
