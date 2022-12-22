package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.admanager.AdManagerAdView;
import com.google.android.gms.ads.admanager.AppEventListener;
import com.google.android.gms.ads.formats.OnAdManagerAdViewLoadedListener;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public final class zzahc extends zzagj {
    /* access modifiers changed from: private */
    public final OnAdManagerAdViewLoadedListener zzdhs;

    public zzahc(OnAdManagerAdViewLoadedListener onAdManagerAdViewLoadedListener) {
        this.zzdhs = onAdManagerAdViewLoadedListener;
    }

    public final void zza(zzxq zzxq, IObjectWrapper iObjectWrapper) {
        if (zzxq != null && iObjectWrapper != null) {
            AdManagerAdView adManagerAdView = new AdManagerAdView((Context) ObjectWrapper.unwrap(iObjectWrapper));
            AppEventListener appEventListener = null;
            try {
                if (zzxq.zzko() instanceof zzvj) {
                    zzvj zzvj = (zzvj) zzxq.zzko();
                    adManagerAdView.setAdListener(zzvj != null ? zzvj.getAdListener() : null);
                }
            } catch (RemoteException e) {
                zzbao.zzc("", e);
            }
            try {
                if (zzxq.zzkn() instanceof zzrl) {
                    zzrl zzrl = (zzrl) zzxq.zzkn();
                    if (zzrl != null) {
                        appEventListener = zzrl.getAppEventListener();
                    }
                    adManagerAdView.setAppEventListener(appEventListener);
                }
            } catch (RemoteException e2) {
                zzbao.zzc("", e2);
            }
            zzbae.zzaah.post(new zzahf(this, adManagerAdView, zzxq));
        }
    }
}
