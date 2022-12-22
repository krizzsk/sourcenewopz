package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
final class zzwr extends zzwt<zzafd> {
    private final /* synthetic */ zzwd zzcjp;
    private final /* synthetic */ View zzcjr;
    private final /* synthetic */ HashMap zzcjs;
    private final /* synthetic */ HashMap zzcjt;

    zzwr(zzwd zzwd, View view, HashMap hashMap, HashMap hashMap2) {
        this.zzcjp = zzwd;
        this.zzcjr = view;
        this.zzcjs = hashMap;
        this.zzcjt = hashMap2;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object zzqp() {
        zzwd.zza(this.zzcjr.getContext(), "native_ad_view_holder_delegate");
        return new zzaak();
    }

    public final /* synthetic */ Object zzqq() throws RemoteException {
        return this.zzcjp.zzcjl.zzb(this.zzcjr, this.zzcjs, this.zzcjt);
    }

    public final /* synthetic */ Object zza(zzxz zzxz) throws RemoteException {
        return zzxz.zza(ObjectWrapper.wrap(this.zzcjr), ObjectWrapper.wrap(this.zzcjs), ObjectWrapper.wrap(this.zzcjt));
    }
}
