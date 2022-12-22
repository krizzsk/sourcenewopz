package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.widget.FrameLayout;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
final class zzws extends zzwt<zzaew> {
    private final /* synthetic */ Context val$context;
    private final /* synthetic */ zzwd zzcjp;
    private final /* synthetic */ FrameLayout zzcju;
    private final /* synthetic */ FrameLayout zzcjv;

    zzws(zzwd zzwd, FrameLayout frameLayout, FrameLayout frameLayout2, Context context) {
        this.zzcjp = zzwd;
        this.zzcju = frameLayout;
        this.zzcjv = frameLayout2;
        this.val$context = context;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object zzqp() {
        zzwd.zza(this.val$context, "native_ad_view_delegate");
        return new zzaal();
    }

    public final /* synthetic */ Object zzqq() throws RemoteException {
        return this.zzcjp.zzcjh.zzb(this.val$context, this.zzcju, this.zzcjv);
    }

    public final /* synthetic */ Object zza(zzxz zzxz) throws RemoteException {
        return zzxz.zza(ObjectWrapper.wrap(this.zzcju), ObjectWrapper.wrap(this.zzcjv));
    }
}
