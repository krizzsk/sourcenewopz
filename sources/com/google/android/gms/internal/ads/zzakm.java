package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public final class zzakm {
    private final Context context;
    private final zzvr zzacy;
    private final zzxi zzacz;

    zzakm(Context context2, zzxi zzxi) {
        this(context2, zzxi, zzvr.zzciq);
    }

    private zzakm(Context context2, zzxi zzxi, zzvr zzvr) {
        this.context = context2;
        this.zzacz = zzxi;
        this.zzacy = zzvr;
    }

    private final void zza(zzzl zzzl) {
        try {
            this.zzacz.zzb(zzvr.zza(this.context, zzzl));
        } catch (RemoteException e) {
            zzbao.zze("#007 Could not call remote method.", e);
        }
    }

    public final void loadAd(AdRequest adRequest) {
        zza(adRequest.zzdt());
    }

    public final void loadAd(PublisherAdRequest publisherAdRequest) {
        zza(publisherAdRequest.zzdt());
    }
}
