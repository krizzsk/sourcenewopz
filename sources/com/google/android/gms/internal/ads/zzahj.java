package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.doubleclick.PublisherAdView;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
final class zzahj implements Runnable {
    private final /* synthetic */ zzxq zzdhv;
    private final /* synthetic */ PublisherAdView zzdia;
    private final /* synthetic */ zzahg zzdib;

    zzahj(zzahg zzahg, PublisherAdView publisherAdView, zzxq zzxq) {
        this.zzdib = zzahg;
        this.zzdia = publisherAdView;
        this.zzdhv = zzxq;
    }

    public final void run() {
        if (this.zzdia.zza(this.zzdhv)) {
            this.zzdib.zzdhx.onPublisherAdViewLoaded(this.zzdia);
        } else {
            zzbao.zzez("Could not bind.");
        }
    }
}
