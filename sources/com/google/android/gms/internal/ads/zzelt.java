package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
final class zzelt extends zzema {
    private final int zzipf;
    private final int zzipg;

    zzelt(byte[] bArr, int i, int i2) {
        super(bArr);
        zzi(i, i + i2, bArr.length);
        this.zzipf = i;
        this.zzipg = i2;
    }

    public final byte zzgh(int i) {
        zzad(i, size());
        return this.zzipn[this.zzipf + i];
    }

    /* access modifiers changed from: package-private */
    public final byte zzgi(int i) {
        return this.zzipn[this.zzipf + i];
    }

    public final int size() {
        return this.zzipg;
    }

    /* access modifiers changed from: protected */
    public final int zzbho() {
        return this.zzipf;
    }

    /* access modifiers changed from: protected */
    public final void zzb(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.zzipn, zzbho() + i, bArr, i2, i3);
    }
}
