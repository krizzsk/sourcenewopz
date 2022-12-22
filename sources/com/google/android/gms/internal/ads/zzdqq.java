package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzdqq implements zzesa<Context> {
    private final zzesn<Context> zzece;
    private final zzdqo zzhpn;

    private zzdqq(zzdqo zzdqo, zzesn<Context> zzesn) {
        this.zzhpn = zzdqo;
        this.zzece = zzesn;
    }

    public static zzdqq zza(zzdqo zzdqo, zzesn<Context> zzesn) {
        return new zzdqq(zzdqo, zzesn);
    }

    public final /* synthetic */ Object get() {
        return (Context) zzesg.zzbd(this.zzece.get());
    }
}
