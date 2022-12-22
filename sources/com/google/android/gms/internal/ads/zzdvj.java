package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.internal.ads.zzdvq;
import com.google.android.gms.internal.ads.zzdvx;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
public final class zzdvj {
    private final Context context;
    private final Looper zzhwb;

    public zzdvj(Context context2, Looper looper) {
        this.context = context2;
        this.zzhwb = looper;
    }

    public final void zzhg(String str) {
        new zzdvi(this.context, this.zzhwb, (zzdvx) ((zzena) zzdvx.zzazb().zzhj(this.context.getPackageName()).zzb(zzdvx.zza.BLOCKED_IMPRESSION).zza(zzdvq.zzayz().zzhi(str).zzb(zzdvq.zza.BLOCKED_REASON_BACKGROUND)).zzbjv())).zzayu();
    }
}
