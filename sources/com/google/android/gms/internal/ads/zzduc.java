package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzduc implements zzdtw {
    private final zzdue zzgom;
    private final zzdug zzgoq;
    private final zzdtt zzhuv;

    public zzduc(zzdtt zzdtt, zzdug zzdug, zzdue zzdue) {
        this.zzhuv = zzdtt;
        this.zzgoq = zzdug;
        this.zzgom = zzdue;
    }

    public final void zzb(zzdtx zzdtx) {
        this.zzhuv.zzgw(zzc(zzdtx));
    }

    public final String zzc(zzdtx zzdtx) {
        zzdug zzdug = this.zzgoq;
        Map<String, String> zzlw = zzdtx.zzlw();
        this.zzgom.zzq(zzlw);
        return zzdug.zzr(zzlw);
    }
}
