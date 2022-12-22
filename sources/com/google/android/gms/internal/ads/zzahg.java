package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.doubleclick.PublisherAdView;
import com.google.android.gms.ads.formats.OnPublisherAdViewLoadedListener;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public final class zzahg extends zzagj {
    /* access modifiers changed from: private */
    public final OnPublisherAdViewLoadedListener zzdhx;

    public zzahg(OnPublisherAdViewLoadedListener onPublisherAdViewLoadedListener) {
        this.zzdhx = onPublisherAdViewLoadedListener;
    }

    public final void zza(zzxq zzxq, IObjectWrapper iObjectWrapper) {
        if (zzxq != null && iObjectWrapper != null) {
            PublisherAdView publisherAdView = new PublisherAdView((Context) ObjectWrapper.unwrap(iObjectWrapper));
            AppEventListener appEventListener = null;
            try {
                if (zzxq.zzko() instanceof zzvj) {
                    zzvj zzvj = (zzvj) zzxq.zzko();
                    publisherAdView.setAdListener(zzvj != null ? zzvj.getAdListener() : null);
                }
            } catch (RemoteException e) {
                zzbao.zzc("", e);
            }
            try {
                if (zzxq.zzkn() instanceof zzvz) {
                    zzvz zzvz = (zzvz) zzxq.zzkn();
                    if (zzvz != null) {
                        appEventListener = zzvz.getAppEventListener();
                    }
                    publisherAdView.setAppEventListener(appEventListener);
                }
            } catch (RemoteException e2) {
                zzbao.zzc("", e2);
            }
            zzbae.zzaah.post(new zzahj(this, publisherAdView, zzxq));
        }
    }
}
