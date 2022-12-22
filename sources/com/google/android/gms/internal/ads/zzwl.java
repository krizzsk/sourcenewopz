package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.firebase.analytics.FirebaseAnalytics;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
final class zzwl extends zzwt<zzxq> {
    private final /* synthetic */ Context val$context;
    private final /* synthetic */ String zzcjn;
    private final /* synthetic */ zzann zzcjo;
    private final /* synthetic */ zzwd zzcjp;
    private final /* synthetic */ zzvt zzcjq;

    zzwl(zzwd zzwd, Context context, zzvt zzvt, String str, zzann zzann) {
        this.zzcjp = zzwd;
        this.val$context = context;
        this.zzcjq = zzvt;
        this.zzcjn = str;
        this.zzcjo = zzann;
    }

    public final /* synthetic */ Object zzqp() {
        zzwd.zza(this.val$context, FirebaseAnalytics.Event.APP_OPEN);
        return new zzaah();
    }

    public final /* synthetic */ Object zzqq() throws RemoteException {
        return this.zzcjp.zzcje.zza(this.val$context, this.zzcjq, this.zzcjn, this.zzcjo, 4);
    }

    public final /* synthetic */ Object zza(zzxz zzxz) throws RemoteException {
        return zzxz.zzc(ObjectWrapper.wrap(this.val$context), this.zzcjq, this.zzcjn, this.zzcjo, 204890000);
    }
}
