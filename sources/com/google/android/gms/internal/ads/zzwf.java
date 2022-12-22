package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
final class zzwf extends zzwt<zzawf> {
    private final /* synthetic */ Context val$context;
    private final /* synthetic */ String zzcjn;
    private final /* synthetic */ zzann zzcjo;
    private final /* synthetic */ zzwd zzcjp;

    zzwf(zzwd zzwd, Context context, String str, zzann zzann) {
        this.zzcjp = zzwd;
        this.val$context = context;
        this.zzcjn = str;
        this.zzcjo = zzann;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object zzqp() {
        zzwd.zza(this.val$context, "rewarded");
        return new zzaan();
    }

    public final /* synthetic */ Object zzqq() throws RemoteException {
        return zzawv.zzd(this.val$context, this.zzcjn, this.zzcjo);
    }

    public final /* synthetic */ Object zza(zzxz zzxz) throws RemoteException {
        return zzxz.zzb(ObjectWrapper.wrap(this.val$context), this.zzcjn, this.zzcjo, 204890000);
    }
}
