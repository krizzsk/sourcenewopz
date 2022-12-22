package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.mediation.InitializationCompleteCallback;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
final class zzaop implements InitializationCompleteCallback {
    private final /* synthetic */ zzajo zzdph;

    zzaop(zzaon zzaon, zzajo zzajo) {
        this.zzdph = zzajo;
    }

    public final void onInitializationSucceeded() {
        try {
            this.zzdph.onInitializationSucceeded();
        } catch (RemoteException e) {
            zzbao.zzc("", e);
        }
    }

    public final void onInitializationFailed(String str) {
        try {
            this.zzdph.onInitializationFailed(str);
        } catch (RemoteException e) {
            zzbao.zzc("", e);
        }
    }
}
