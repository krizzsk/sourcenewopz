package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzbip implements zzdjy {
    private final /* synthetic */ zzbie zzfhy;
    private Context zzfob;
    private String zzfoc;

    private zzbip(zzbie zzbie) {
        this.zzfhy = zzbie;
    }

    public final zzdjv zzaic() {
        zzesg.zza(this.zzfob, Context.class);
        zzesg.zza(this.zzfoc, String.class);
        return new zzbis(this.zzfhy, this.zzfob, this.zzfoc);
    }

    public final /* synthetic */ zzdjy zzfp(String str) {
        this.zzfoc = (String) zzesg.checkNotNull(str);
        return this;
    }

    public final /* synthetic */ zzdjy zzca(Context context) {
        this.zzfob = (Context) zzesg.checkNotNull(context);
        return this;
    }
}
