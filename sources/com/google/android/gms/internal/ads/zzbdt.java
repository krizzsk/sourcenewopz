package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final /* synthetic */ class zzbdt implements zzoq {
    private final byte[] zzdyr;
    private final zzoq zzerg;

    zzbdt(zzoq zzoq, byte[] bArr) {
        this.zzerg = zzoq;
        this.zzdyr = bArr;
    }

    public final zzon zzit() {
        zzoq zzoq = this.zzerg;
        byte[] bArr = this.zzdyr;
        return new zzbea(new zzoo(bArr), bArr.length, zzoq.zzit());
    }
}
