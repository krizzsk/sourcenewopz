package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzd;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final /* synthetic */ class zzcfh implements zzaig {
    static final zzaig zzdif = new zzcfh();

    private zzcfh() {
    }

    public final void zza(Object obj, Map map) {
        zzd.zzdz("Show native ad policy validator overlay.");
        ((zzbfi) obj).getView().setVisibility(0);
    }
}
