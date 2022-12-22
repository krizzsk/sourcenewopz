package atd.p014c0;

import java.util.Arrays;

/* renamed from: atd.c0.e */
public final class C0975e {

    /* renamed from: a */
    private final byte[] f205a;

    /* renamed from: b */
    private final byte[] f206b;

    C0975e(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        if (bArr != null) {
            Arrays.copyOf(bArr, bArr.length);
        }
        byte[] bArr4 = null;
        this.f205a = bArr2 != null ? Arrays.copyOf(bArr2, bArr2.length) : null;
        this.f206b = bArr3 != null ? Arrays.copyOf(bArr3, bArr3.length) : bArr4;
    }

    /* renamed from: a */
    public byte[] mo13623a() {
        byte[] bArr = this.f206b;
        return Arrays.copyOf(bArr, bArr.length);
    }

    /* renamed from: b */
    public byte[] mo13624b() {
        byte[] bArr = this.f205a;
        return Arrays.copyOf(bArr, bArr.length);
    }
}
