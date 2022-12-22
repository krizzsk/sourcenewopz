package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbeb implements zzbes {
    public final zzbek zza(zzbcs zzbcs, int i, String str, zzbcp zzbcp) {
        if (i <= 0) {
            return new zzber(zzbcs);
        }
        int zzadf = zzbdn.zzadf();
        if (zzadf < zzbcp.zzeno) {
            return new zzbev(zzbcs, zzbcp);
        }
        if (zzadf < zzbcp.zzeni) {
            return new zzbew(zzbcs, zzbcp);
        }
        return new zzbeu(zzbcs);
    }
}
