package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
final class zzwq extends zzwt<zzxj> {
    private final /* synthetic */ Context val$context;
    private final /* synthetic */ String zzcjn;
    private final /* synthetic */ zzann zzcjo;
    private final /* synthetic */ zzwd zzcjp;

    zzwq(zzwd zzwd, Context context, String str, zzann zzann) {
        this.zzcjp = zzwd;
        this.val$context = context;
        this.zzcjn = str;
        this.zzcjo = zzann;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object zzqp() {
        zzwd.zza(this.val$context, "native_ad");
        return new zzaad();
    }

    public final /* synthetic */ Object zzqq() throws RemoteException {
        return this.zzcjp.zzcjf.zza(this.val$context, this.zzcjn, this.zzcjo);
    }

    public final /* synthetic */ Object zza(zzxz zzxz) throws RemoteException {
        return zzxz.zza(ObjectWrapper.wrap(this.val$context), this.zzcjn, this.zzcjo, 204890000);
    }
}
