package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
final class zzwu extends zzwt<zzavg> {
    private final /* synthetic */ Context val$context;
    private final /* synthetic */ zzann zzcjo;
    private final /* synthetic */ zzwd zzcjp;

    zzwu(zzwd zzwd, Context context, zzann zzann) {
        this.zzcjp = zzwd;
        this.val$context = context;
        this.zzcjo = zzann;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object zzqp() {
        zzwd.zza(this.val$context, "rewarded_video");
        return new zzaap();
    }

    public final /* synthetic */ Object zzqq() throws RemoteException {
        return this.zzcjp.zzcji.zzc(this.val$context, this.zzcjo);
    }

    public final /* synthetic */ Object zza(zzxz zzxz) throws RemoteException {
        return zzxz.zza(ObjectWrapper.wrap(this.val$context), this.zzcjo, 204890000);
    }
}
