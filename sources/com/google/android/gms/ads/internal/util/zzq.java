package com.google.android.gms.ads.internal.util;

import android.content.Context;
import com.google.android.gms.ads.internal.zzr;
import com.google.android.gms.internal.ads.zzbaf;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzq implements zzbaf {
    private final /* synthetic */ Context val$context;
    private final /* synthetic */ String zzegy;

    zzq(zzj zzj, Context context, String str) {
        this.val$context = context;
        this.zzegy = str;
    }

    public final void zzen(String str) {
        zzr.zzkv();
        zzj.zzb(this.val$context, this.zzegy, str);
    }
}
