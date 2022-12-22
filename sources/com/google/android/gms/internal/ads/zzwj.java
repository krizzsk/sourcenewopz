package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
final class zzwj extends zzwt<zzaru> {
    private final /* synthetic */ Context val$context;
    private final /* synthetic */ zzann zzcjo;

    zzwj(zzwd zzwd, Context context, zzann zzann) {
        this.val$context = context;
        this.zzcjo = zzann;
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ Object zzqp() {
        return null;
    }

    /* access modifiers changed from: private */
    /* renamed from: zzqs */
    public final zzaru zzqq() {
        try {
            return ((zzarz) zzban.zza(this.val$context, "com.google.android.gms.ads.DynamiteOfflineUtilsCreatorImpl", zzwm.zzbys)).zzc(ObjectWrapper.wrap(this.val$context), this.zzcjo, 204890000);
        } catch (RemoteException | zzbap | NullPointerException unused) {
            return null;
        }
    }

    public final /* synthetic */ Object zza(zzxz zzxz) throws RemoteException {
        return zzxz.zzc(ObjectWrapper.wrap(this.val$context), this.zzcjo, 204890000);
    }
}
