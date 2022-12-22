package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzccd implements zzesa<zzccb> {
    private final zzccb zzgee;

    private zzccd(zzccb zzccb) {
        this.zzgee = zzccb;
    }

    public static zzccd zze(zzccb zzccb) {
        return new zzccd(zzccb);
    }

    public final /* synthetic */ Object get() {
        zzccb zzccb = this.zzgee;
        if (zzccb != null) {
            return (zzccb) zzesg.zzbd(zzccb);
        }
        throw null;
    }
}
