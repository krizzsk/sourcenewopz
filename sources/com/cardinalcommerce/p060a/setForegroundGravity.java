package com.cardinalcommerce.p060a;

import com.cardinalcommerce.p060a.DSASigner;
import com.didichuxing.bigdata.p173dp.locsdk.Const;

/* renamed from: com.cardinalcommerce.a.setForegroundGravity */
public final class setForegroundGravity {

    /* renamed from: a */
    private int[] f2784a;

    public setForegroundGravity(byte[] bArr) {
        if (bArr.length > 4) {
            int Cardinal = DSASigner.dsaSha3_384.Cardinal(bArr, 0);
            int init = setForeground.init(Cardinal - 1);
            if (bArr.length == (Cardinal * init) + 4) {
                this.f2784a = new int[Cardinal];
                for (int i = 0; i < Cardinal; i++) {
                    this.f2784a[i] = DSASigner.dsaSha3_384.Cardinal(bArr, (i * init) + 4, init);
                }
                if (!m1984a(this.f2784a)) {
                    throw new IllegalArgumentException("invalid encoding");
                }
                return;
            }
            throw new IllegalArgumentException("invalid encoding");
        }
        throw new IllegalArgumentException("invalid encoding");
    }

    /* renamed from: a */
    private static boolean m1984a(int[] iArr) {
        int length = iArr.length;
        boolean[] zArr = new boolean[length];
        for (int i = 0; i < length; i++) {
            if (iArr[i] < 0 || iArr[i] >= length || zArr[iArr[i]]) {
                return false;
            }
            zArr[iArr[i]] = true;
        }
        return true;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof setForegroundGravity)) {
            return false;
        }
        return DSASigner.dsaSha3_384.getInstance(this.f2784a, ((setForegroundGravity) obj).f2784a);
    }

    public final int hashCode() {
        return setForegroundTintBlendMode.cca_continue(this.f2784a);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(Const.jaLeft);
        sb.append(this.f2784a[0]);
        String obj = sb.toString();
        for (int i = 1; i < this.f2784a.length; i++) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(obj);
            sb2.append(", ");
            sb2.append(this.f2784a[i]);
            obj = sb2.toString();
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append(obj);
        sb3.append(Const.jaRight);
        return sb3.toString();
    }

    public final byte[] init() {
        int length = this.f2784a.length;
        int init = setForeground.init(length - 1);
        byte[] bArr = new byte[((length * init) + 4)];
        DSASigner.dsaSha3_384.cca_continue(length, bArr, 0);
        for (int i = 0; i < length; i++) {
            int i2 = this.f2784a[i];
            int i3 = (i * init) + 4;
            for (int i4 = init - 1; i4 >= 0; i4--) {
                bArr[i3 + i4] = (byte) (i2 >>> (i4 << 3));
            }
        }
        return bArr;
    }
}
