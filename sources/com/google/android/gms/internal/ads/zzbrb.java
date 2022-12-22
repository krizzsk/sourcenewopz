package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zza;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbrb implements zzesa<zza> {
    private final zzesn<Context> zzeyq;
    private final zzbqy zzfzz;
    private final zzesn<zzaxo> zzgaa;

    private zzbrb(zzbqy zzbqy, zzesn<Context> zzesn, zzesn<zzaxo> zzesn2) {
        this.zzfzz = zzbqy;
        this.zzeyq = zzesn;
        this.zzgaa = zzesn2;
    }

    public static zzbrb zza(zzbqy zzbqy, zzesn<Context> zzesn, zzesn<zzaxo> zzesn2) {
        return new zzbrb(zzbqy, zzesn, zzesn2);
    }

    public final /* synthetic */ Object get() {
        return (zza) zzesg.zzbd(new zza(this.zzeyq.get(), this.zzgaa.get(), (zzatu) null));
    }
}
