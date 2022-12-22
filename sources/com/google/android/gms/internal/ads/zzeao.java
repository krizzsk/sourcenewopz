package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzeao implements Runnable {
    private final /* synthetic */ zzeal zzicx;
    private final /* synthetic */ zzebt zzicy;
    private final /* synthetic */ int zzicz;

    zzeao(zzeal zzeal, zzebt zzebt, int i) {
        this.zzicx = zzeal;
        this.zzicy = zzebt;
        this.zzicz = i;
    }

    public final void run() {
        try {
            if (this.zzicy.isCancelled()) {
                zzdyv unused = this.zzicx.zzict = null;
                this.zzicx.cancel(false);
            } else {
                this.zzicx.zza(this.zzicz, this.zzicy);
            }
        } finally {
            this.zzicx.zza((zzdyv) null);
        }
    }
}
