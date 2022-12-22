package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
final class zzwn extends zzwt<zzxq> {
    private final /* synthetic */ Context val$context;
    private final /* synthetic */ String zzcjn;
    private final /* synthetic */ zzann zzcjo;
    private final /* synthetic */ zzwd zzcjp;
    private final /* synthetic */ zzvt zzcjq;

    zzwn(zzwd zzwd, Context context, zzvt zzvt, String str, zzann zzann) {
        this.zzcjp = zzwd;
        this.val$context = context;
        this.zzcjq = zzvt;
        this.zzcjn = str;
        this.zzcjo = zzann;
    }

    public final /* synthetic */ Object zzqp() {
        zzwd.zza(this.val$context, "interstitial");
        return new zzaah();
    }

    public final /* synthetic */ Object zzqq() throws RemoteException {
        return this.zzcjp.zzcje.zza(this.val$context, this.zzcjq, this.zzcjn, this.zzcjo, 2);
    }

    public final /* synthetic */ Object zza(zzxz zzxz) throws RemoteException {
        return zzxz.zzb(ObjectWrapper.wrap(this.val$context), this.zzcjq, this.zzcjn, this.zzcjo, 204890000);
    }
}
