package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzoj {
    public final zznu zzbih;
    public final zzoi zzbii;
    public final Object zzbij;
    public final zzia[] zzbik;

    public zzoj(zznu zznu, zzoi zzoi, Object obj, zzia[] zziaArr) {
        this.zzbih = zznu;
        this.zzbii = zzoi;
        this.zzbij = obj;
        this.zzbik = zziaArr;
    }

    public final boolean zza(zzoj zzoj, int i) {
        if (zzoj != null && zzpt.zza(this.zzbii.zzbh(i), zzoj.zzbii.zzbh(i)) && zzpt.zza(this.zzbik[i], zzoj.zzbik[i])) {
            return true;
        }
        return false;
    }
}
