package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public abstract class zzoh {
    private zzok zzbif;

    public abstract zzoj zza(zzib[] zzibArr, zznu zznu) throws zzhe;

    public abstract void zzd(Object obj);

    public final void zza(zzok zzok) {
        this.zzbif = zzok;
    }

    /* access modifiers changed from: protected */
    public final void invalidate() {
        zzok zzok = this.zzbif;
        if (zzok != null) {
            zzok.zzet();
        }
    }
}
