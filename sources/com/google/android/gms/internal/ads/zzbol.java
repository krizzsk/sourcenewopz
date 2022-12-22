package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbol implements zzesa<Boolean> {
    private final zzesn<zzdpm> zzfxn;

    public zzbol(zzesn<zzdpm> zzesn) {
        this.zzfxn = zzesn;
    }

    public final /* synthetic */ Object get() {
        boolean z;
        if (this.zzfxn.get().zzawb() != null) {
            z = ((Boolean) zzww.zzra().zzd(zzabq.zzcqo)).booleanValue();
        } else {
            z = ((Boolean) zzww.zzra().zzd(zzabq.zzcxj)).booleanValue();
        }
        return Boolean.valueOf(z);
    }
}
