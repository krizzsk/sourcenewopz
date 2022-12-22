package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzqq implements Runnable {
    private final /* synthetic */ zzqj zzbnk;
    private final /* synthetic */ int zzbno;
    private final /* synthetic */ int zzbnp;
    private final /* synthetic */ int zzbnq;
    private final /* synthetic */ float zzbnr;

    zzqq(zzqj zzqj, int i, int i2, int i3, float f) {
        this.zzbnk = zzqj;
        this.zzbno = i;
        this.zzbnp = i2;
        this.zzbnq = i3;
        this.zzbnr = f;
    }

    public final void run() {
        this.zzbnk.zzbnj.zzb(this.zzbno, this.zzbnp, this.zzbnq, this.zzbnr);
    }
}
