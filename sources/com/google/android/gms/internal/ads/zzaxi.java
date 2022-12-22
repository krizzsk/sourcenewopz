package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzaxi implements zzebi<Void> {
    private final /* synthetic */ zzebt zzebu;

    zzaxi(zzaxf zzaxf, zzebt zzebt) {
        this.zzebu = zzebt;
    }

    public final void zzb(Throwable th) {
        zzaxf.zzebi.remove(this.zzebu);
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        Void voidR = (Void) obj;
        zzaxf.zzebi.remove(this.zzebu);
    }
}
