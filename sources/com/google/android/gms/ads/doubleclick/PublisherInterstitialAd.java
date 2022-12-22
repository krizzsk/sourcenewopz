package com.google.android.gms.ads.doubleclick;

import android.content.Context;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.Correlator;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzzp;

@Deprecated
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public final class PublisherInterstitialAd {
    private final zzzp zzadr;

    public PublisherInterstitialAd(Context context) {
        this.zzadr = new zzzp(context, this);
        Preconditions.checkNotNull(context, "Context cannot be null");
    }

    @Deprecated
    public final void setCorrelator(Correlator correlator) {
    }

    public final AdListener getAdListener() {
        return this.zzadr.getAdListener();
    }

    public final String getAdUnitId() {
        return this.zzadr.getAdUnitId();
    }

    public final AppEventListener getAppEventListener() {
        return this.zzadr.getAppEventListener();
    }

    public final OnCustomRenderedAdLoadedListener getOnCustomRenderedAdLoadedListener() {
        return this.zzadr.getOnCustomRenderedAdLoadedListener();
    }

    public final boolean isLoaded() {
        return this.zzadr.isLoaded();
    }

    public final boolean isLoading() {
        return this.zzadr.isLoading();
    }

    public final void loadAd(PublisherAdRequest publisherAdRequest) {
        this.zzadr.zza(publisherAdRequest.zzdt());
    }

    public final void setAdListener(AdListener adListener) {
        this.zzadr.setAdListener(adListener);
    }

    public final void setAdUnitId(String str) {
        this.zzadr.setAdUnitId(str);
    }

    public final void setAppEventListener(AppEventListener appEventListener) {
        this.zzadr.setAppEventListener(appEventListener);
    }

    public final void setOnCustomRenderedAdLoadedListener(OnCustomRenderedAdLoadedListener onCustomRenderedAdLoadedListener) {
        this.zzadr.setOnCustomRenderedAdLoadedListener(onCustomRenderedAdLoadedListener);
    }

    @Deprecated
    public final String getMediationAdapterClassName() {
        return this.zzadr.getMediationAdapterClassName();
    }

    public final void show() {
        this.zzadr.show();
    }

    public final void setImmersiveMode(boolean z) {
        this.zzadr.setImmersiveMode(z);
    }

    public final ResponseInfo getResponseInfo() {
        return this.zzadr.getResponseInfo();
    }
}
