package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
final class zzwh extends zzwt<zzazc> {
    private final /* synthetic */ Context val$context;
    private final /* synthetic */ zzann zzcjo;

    zzwh(zzwd zzwd, Context context, zzann zzann) {
        this.val$context = context;
        this.zzcjo = zzann;
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ Object zzqp() {
        return null;
    }

    /* access modifiers changed from: private */
    /* renamed from: zzqr */
    public final zzazc zzqq() {
        try {
            return ((zzazh) zzban.zza(this.val$context, "com.google.android.gms.ads.DynamiteSignalGeneratorCreatorImpl", zzwk.zzbys)).zze(ObjectWrapper.wrap(this.val$context), this.zzcjo, 204890000);
        } catch (RemoteException | zzbap | NullPointerException unused) {
            return null;
        }
    }

    public final /* synthetic */ Object zza(zzxz zzxz) throws RemoteException {
        return zzxz.zzb(ObjectWrapper.wrap(this.val$context), this.zzcjo, 204890000);
    }
}
