package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
final class zzwi extends zzwt<zzash> {
    private final /* synthetic */ Activity val$activity;
    private final /* synthetic */ zzwd zzcjp;

    zzwi(zzwd zzwd, Activity activity) {
        this.zzcjp = zzwd;
        this.val$activity = activity;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object zzqp() {
        zzwd.zza((Context) this.val$activity, "ad_overlay");
        return null;
    }

    public final /* synthetic */ Object zzqq() throws RemoteException {
        return this.zzcjp.zzcjk.zze(this.val$activity);
    }

    public final /* synthetic */ Object zza(zzxz zzxz) throws RemoteException {
        return zzxz.zzb(ObjectWrapper.wrap(this.val$activity));
    }
}
