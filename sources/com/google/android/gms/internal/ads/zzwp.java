package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
final class zzwp extends zzwt<zzyh> {
    private final /* synthetic */ Context val$context;
    private final /* synthetic */ zzwd zzcjp;

    zzwp(zzwd zzwd, Context context) {
        this.zzcjp = zzwd;
        this.val$context = context;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object zzqp() {
        zzwd.zza(this.val$context, "mobile_ads_settings");
        return new zzaaj();
    }

    public final /* synthetic */ Object zzqq() throws RemoteException {
        return this.zzcjp.zzcjg.zzh(this.val$context);
    }

    public final /* synthetic */ Object zza(zzxz zzxz) throws RemoteException {
        return zzxz.zza(ObjectWrapper.wrap(this.val$context), 204890000);
    }
}
