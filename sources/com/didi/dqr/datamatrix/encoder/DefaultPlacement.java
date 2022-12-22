package com.didi.dqr.datamatrix.encoder;

import java.util.Arrays;

public class DefaultPlacement {

    /* renamed from: a */
    private final CharSequence f18611a;

    /* renamed from: b */
    private final int f18612b;

    /* renamed from: c */
    private final int f18613c;

    /* renamed from: d */
    private final byte[] f18614d;

    public DefaultPlacement(CharSequence charSequence, int i, int i2) {
        this.f18611a = charSequence;
        this.f18613c = i;
        this.f18612b = i2;
        byte[] bArr = new byte[(i * i2)];
        this.f18614d = bArr;
        Arrays.fill(bArr, (byte) -1);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final int mo58322a() {
        return this.f18612b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final int mo58323b() {
        return this.f18613c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final byte[] mo58324c() {
        return this.f18614d;
    }

    public final boolean getBit(int i, int i2) {
        return this.f18614d[(i2 * this.f18613c) + i] == 1;
    }

    /* renamed from: a */
    private void m13800a(int i, int i2, boolean z) {
        this.f18614d[(i2 * this.f18613c) + i] = z ? (byte) 1 : 0;
    }

    /* renamed from: a */
    private boolean m13801a(int i, int i2) {
        return this.f18614d[(i2 * this.f18613c) + i] < 0;
    }

    public final void place() {
        int i;
        int i2;
        int i3 = 0;
        int i4 = 0;
        int i5 = 4;
        while (true) {
            if (i5 == this.f18612b && i3 == 0) {
                m13797a(i4);
                i4++;
            }
            if (i5 == this.f18612b - 2 && i3 == 0 && this.f18613c % 4 != 0) {
                m13802b(i4);
                i4++;
            }
            if (i5 == this.f18612b - 2 && i3 == 0 && this.f18613c % 8 == 4) {
                m13803c(i4);
                i4++;
            }
            if (i5 == this.f18612b + 4 && i3 == 2 && this.f18613c % 8 == 0) {
                m13804d(i4);
                i4++;
            }
            do {
                if (i5 < this.f18612b && i3 >= 0 && m13801a(i3, i5)) {
                    m13798a(i5, i3, i4);
                    i4++;
                }
                i5 -= 2;
                i3 += 2;
                if (i5 < 0 || i3 >= this.f18613c) {
                    int i6 = i5 + 1;
                    int i7 = i3 + 3;
                }
                m13798a(i5, i3, i4);
                i4++;
                i5 -= 2;
                i3 += 2;
                break;
            } while (i3 >= this.f18613c);
            int i62 = i5 + 1;
            int i72 = i3 + 3;
            do {
                if (i62 >= 0 && i72 < this.f18613c && m13801a(i72, i62)) {
                    m13798a(i62, i72, i4);
                    i4++;
                }
                i62 += 2;
                i72 -= 2;
                if (i62 >= this.f18612b) {
                    break;
                }
            } while (i72 >= 0);
            i5 = i62 + 3;
            i3 = i72 + 1;
            i = this.f18612b;
            if (i5 >= i && i3 >= (i2 = this.f18613c)) {
                break;
            }
        }
        if (m13801a(i2 - 1, i - 1)) {
            m13800a(this.f18613c - 1, this.f18612b - 1, true);
            m13800a(this.f18613c - 2, this.f18612b - 2, true);
        }
    }

    /* renamed from: a */
    private void m13799a(int i, int i2, int i3, int i4) {
        if (i < 0) {
            int i5 = this.f18612b;
            i += i5;
            i2 += 4 - ((i5 + 4) % 8);
        }
        if (i2 < 0) {
            int i6 = this.f18613c;
            i2 += i6;
            i += 4 - ((i6 + 4) % 8);
        }
        boolean z = true;
        if ((this.f18611a.charAt(i3) & (1 << (8 - i4))) == 0) {
            z = false;
        }
        m13800a(i2, i, z);
    }

    /* renamed from: a */
    private void m13798a(int i, int i2, int i3) {
        int i4 = i - 2;
        int i5 = i2 - 2;
        m13799a(i4, i5, i3, 1);
        int i6 = i2 - 1;
        m13799a(i4, i6, i3, 2);
        int i7 = i - 1;
        m13799a(i7, i5, i3, 3);
        m13799a(i7, i6, i3, 4);
        m13799a(i7, i2, i3, 5);
        m13799a(i, i5, i3, 6);
        m13799a(i, i6, i3, 7);
        m13799a(i, i2, i3, 8);
    }

    /* renamed from: a */
    private void m13797a(int i) {
        m13799a(this.f18612b - 1, 0, i, 1);
        m13799a(this.f18612b - 1, 1, i, 2);
        m13799a(this.f18612b - 1, 2, i, 3);
        m13799a(0, this.f18613c - 2, i, 4);
        m13799a(0, this.f18613c - 1, i, 5);
        m13799a(1, this.f18613c - 1, i, 6);
        m13799a(2, this.f18613c - 1, i, 7);
        m13799a(3, this.f18613c - 1, i, 8);
    }

    /* renamed from: b */
    private void m13802b(int i) {
        m13799a(this.f18612b - 3, 0, i, 1);
        m13799a(this.f18612b - 2, 0, i, 2);
        m13799a(this.f18612b - 1, 0, i, 3);
        m13799a(0, this.f18613c - 4, i, 4);
        m13799a(0, this.f18613c - 3, i, 5);
        m13799a(0, this.f18613c - 2, i, 6);
        m13799a(0, this.f18613c - 1, i, 7);
        m13799a(1, this.f18613c - 1, i, 8);
    }

    /* renamed from: c */
    private void m13803c(int i) {
        m13799a(this.f18612b - 3, 0, i, 1);
        m13799a(this.f18612b - 2, 0, i, 2);
        m13799a(this.f18612b - 1, 0, i, 3);
        m13799a(0, this.f18613c - 2, i, 4);
        m13799a(0, this.f18613c - 1, i, 5);
        m13799a(1, this.f18613c - 1, i, 6);
        m13799a(2, this.f18613c - 1, i, 7);
        m13799a(3, this.f18613c - 1, i, 8);
    }

    /* renamed from: d */
    private void m13804d(int i) {
        m13799a(this.f18612b - 1, 0, i, 1);
        m13799a(this.f18612b - 1, this.f18613c - 1, i, 2);
        m13799a(0, this.f18613c - 3, i, 3);
        m13799a(0, this.f18613c - 2, i, 4);
        m13799a(0, this.f18613c - 1, i, 5);
        m13799a(1, this.f18613c - 3, i, 6);
        m13799a(1, this.f18613c - 2, i, 7);
        m13799a(1, this.f18613c - 1, i, 8);
    }
}
