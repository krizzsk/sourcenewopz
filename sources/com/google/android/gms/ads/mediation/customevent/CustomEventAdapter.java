package com.google.android.gms.ads.mediation.customevent;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.MediationNativeListener;
import com.google.android.gms.ads.mediation.NativeAdMapper;
import com.google.android.gms.ads.mediation.NativeMediationAdRequest;
import com.google.android.gms.ads.mediation.UnifiedNativeAdMapper;
import com.google.android.gms.internal.ads.zzbao;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public final class CustomEventAdapter implements MediationBannerAdapter, MediationInterstitialAdapter, MediationNativeAdapter {
    private static final AdError zzexw = new AdError(0, "Could not instantiate custom event adapter", MobileAds.ERROR_DOMAIN);
    private CustomEventBanner zzexx;
    private CustomEventInterstitial zzexy;
    private CustomEventNative zzexz;
    private View zznh;

    private static <T> T zzal(String str) {
        try {
            return Class.forName(str).newInstance();
        } catch (Throwable th) {
            String message = th.getMessage();
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 46 + String.valueOf(message).length());
            sb.append("Could not instantiate custom event adapter: ");
            sb.append(str);
            sb.append(". ");
            sb.append(message);
            zzbao.zzez(sb.toString());
            return null;
        }
    }

    /* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
    static final class zza implements CustomEventBannerListener {
        private final CustomEventAdapter zzexu;
        private final MediationBannerListener zzexv;

        public zza(CustomEventAdapter customEventAdapter, MediationBannerListener mediationBannerListener) {
            this.zzexu = customEventAdapter;
            this.zzexv = mediationBannerListener;
        }

        public final void onAdLoaded(View view) {
            zzbao.zzdz("Custom event adapter called onAdLoaded.");
            this.zzexu.zza(view);
            this.zzexv.onAdLoaded(this.zzexu);
        }

        public final void onAdFailedToLoad(int i) {
            zzbao.zzdz("Custom event adapter called onAdFailedToLoad.");
            this.zzexv.onAdFailedToLoad((MediationBannerAdapter) this.zzexu, i);
        }

        public final void onAdFailedToLoad(AdError adError) {
            zzbao.zzdz("Custom event adapter called onAdFailedToLoad.");
            this.zzexv.onAdFailedToLoad((MediationBannerAdapter) this.zzexu, adError);
        }

        public final void onAdClicked() {
            zzbao.zzdz("Custom event adapter called onAdClicked.");
            this.zzexv.onAdClicked(this.zzexu);
        }

        public final void onAdOpened() {
            zzbao.zzdz("Custom event adapter called onAdOpened.");
            this.zzexv.onAdOpened(this.zzexu);
        }

        public final void onAdClosed() {
            zzbao.zzdz("Custom event adapter called onAdClosed.");
            this.zzexv.onAdClosed(this.zzexu);
        }

        public final void onAdLeftApplication() {
            zzbao.zzdz("Custom event adapter called onAdLeftApplication.");
            this.zzexv.onAdLeftApplication(this.zzexu);
        }
    }

    /* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
    static class zzb implements CustomEventNativeListener {
        private final CustomEventAdapter zzexu;
        private final MediationNativeListener zzeya;

        public zzb(CustomEventAdapter customEventAdapter, MediationNativeListener mediationNativeListener) {
            this.zzexu = customEventAdapter;
            this.zzeya = mediationNativeListener;
        }

        public final void onAdLoaded(NativeAdMapper nativeAdMapper) {
            zzbao.zzdz("Custom event adapter called onAdLoaded.");
            this.zzeya.onAdLoaded((MediationNativeAdapter) this.zzexu, nativeAdMapper);
        }

        public final void onAdLoaded(UnifiedNativeAdMapper unifiedNativeAdMapper) {
            zzbao.zzdz("Custom event adapter called onAdLoaded.");
            this.zzeya.onAdLoaded((MediationNativeAdapter) this.zzexu, unifiedNativeAdMapper);
        }

        public final void onAdFailedToLoad(int i) {
            zzbao.zzdz("Custom event adapter called onAdFailedToLoad.");
            this.zzeya.onAdFailedToLoad((MediationNativeAdapter) this.zzexu, i);
        }

        public final void onAdFailedToLoad(AdError adError) {
            zzbao.zzdz("Custom event adapter called onAdFailedToLoad.");
            this.zzeya.onAdFailedToLoad((MediationNativeAdapter) this.zzexu, adError);
        }

        public final void onAdOpened() {
            zzbao.zzdz("Custom event adapter called onAdOpened.");
            this.zzeya.onAdOpened(this.zzexu);
        }

        public final void onAdClicked() {
            zzbao.zzdz("Custom event adapter called onAdClicked.");
            this.zzeya.onAdClicked(this.zzexu);
        }

        public final void onAdClosed() {
            zzbao.zzdz("Custom event adapter called onAdClosed.");
            this.zzeya.onAdClosed(this.zzexu);
        }

        public final void onAdLeftApplication() {
            zzbao.zzdz("Custom event adapter called onAdLeftApplication.");
            this.zzeya.onAdLeftApplication(this.zzexu);
        }

        public final void onAdImpression() {
            zzbao.zzdz("Custom event adapter called onAdImpression.");
            this.zzeya.onAdImpression(this.zzexu);
        }
    }

    /* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
    class zzc implements CustomEventInterstitialListener {
        private final CustomEventAdapter zzexu;
        private final MediationInterstitialListener zzeyb;

        public zzc(CustomEventAdapter customEventAdapter, MediationInterstitialListener mediationInterstitialListener) {
            this.zzexu = customEventAdapter;
            this.zzeyb = mediationInterstitialListener;
        }

        public final void onAdLoaded() {
            zzbao.zzdz("Custom event adapter called onReceivedAd.");
            this.zzeyb.onAdLoaded(CustomEventAdapter.this);
        }

        public final void onAdFailedToLoad(int i) {
            zzbao.zzdz("Custom event adapter called onFailedToReceiveAd.");
            this.zzeyb.onAdFailedToLoad((MediationInterstitialAdapter) this.zzexu, i);
        }

        public final void onAdFailedToLoad(AdError adError) {
            zzbao.zzdz("Custom event adapter called onFailedToReceiveAd.");
            this.zzeyb.onAdFailedToLoad((MediationInterstitialAdapter) this.zzexu, adError);
        }

        public final void onAdClicked() {
            zzbao.zzdz("Custom event adapter called onAdClicked.");
            this.zzeyb.onAdClicked(this.zzexu);
        }

        public final void onAdOpened() {
            zzbao.zzdz("Custom event adapter called onAdOpened.");
            this.zzeyb.onAdOpened(this.zzexu);
        }

        public final void onAdClosed() {
            zzbao.zzdz("Custom event adapter called onAdClosed.");
            this.zzeyb.onAdClosed(this.zzexu);
        }

        public final void onAdLeftApplication() {
            zzbao.zzdz("Custom event adapter called onAdLeftApplication.");
            this.zzeyb.onAdLeftApplication(this.zzexu);
        }
    }

    public final void onDestroy() {
        CustomEventBanner customEventBanner = this.zzexx;
        if (customEventBanner != null) {
            customEventBanner.onDestroy();
        }
        CustomEventInterstitial customEventInterstitial = this.zzexy;
        if (customEventInterstitial != null) {
            customEventInterstitial.onDestroy();
        }
        CustomEventNative customEventNative = this.zzexz;
        if (customEventNative != null) {
            customEventNative.onDestroy();
        }
    }

    public final void onPause() {
        CustomEventBanner customEventBanner = this.zzexx;
        if (customEventBanner != null) {
            customEventBanner.onPause();
        }
        CustomEventInterstitial customEventInterstitial = this.zzexy;
        if (customEventInterstitial != null) {
            customEventInterstitial.onPause();
        }
        CustomEventNative customEventNative = this.zzexz;
        if (customEventNative != null) {
            customEventNative.onPause();
        }
    }

    public final void onResume() {
        CustomEventBanner customEventBanner = this.zzexx;
        if (customEventBanner != null) {
            customEventBanner.onResume();
        }
        CustomEventInterstitial customEventInterstitial = this.zzexy;
        if (customEventInterstitial != null) {
            customEventInterstitial.onResume();
        }
        CustomEventNative customEventNative = this.zzexz;
        if (customEventNative != null) {
            customEventNative.onResume();
        }
    }

    public final View getBannerView() {
        return this.zznh;
    }

    public final void requestBannerAd(Context context, MediationBannerListener mediationBannerListener, Bundle bundle, AdSize adSize, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        Bundle bundle3;
        CustomEventBanner customEventBanner = (CustomEventBanner) zzal(bundle.getString("class_name"));
        this.zzexx = customEventBanner;
        if (customEventBanner == null) {
            mediationBannerListener.onAdFailedToLoad((MediationBannerAdapter) this, zzexw);
            return;
        }
        if (bundle2 == null) {
            bundle3 = null;
        } else {
            bundle3 = bundle2.getBundle(bundle.getString("class_name"));
        }
        Context context2 = context;
        this.zzexx.requestBannerAd(context2, new zza(this, mediationBannerListener), bundle.getString("parameter"), adSize, mediationAdRequest, bundle3);
    }

    public final void requestInterstitialAd(Context context, MediationInterstitialListener mediationInterstitialListener, Bundle bundle, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        Bundle bundle3;
        CustomEventInterstitial customEventInterstitial = (CustomEventInterstitial) zzal(bundle.getString("class_name"));
        this.zzexy = customEventInterstitial;
        if (customEventInterstitial == null) {
            mediationInterstitialListener.onAdFailedToLoad((MediationInterstitialAdapter) this, zzexw);
            return;
        }
        if (bundle2 == null) {
            bundle3 = null;
        } else {
            bundle3 = bundle2.getBundle(bundle.getString("class_name"));
        }
        Context context2 = context;
        this.zzexy.requestInterstitialAd(context2, new zzc(this, mediationInterstitialListener), bundle.getString("parameter"), mediationAdRequest, bundle3);
    }

    public final void requestNativeAd(Context context, MediationNativeListener mediationNativeListener, Bundle bundle, NativeMediationAdRequest nativeMediationAdRequest, Bundle bundle2) {
        Bundle bundle3;
        CustomEventNative customEventNative = (CustomEventNative) zzal(bundle.getString("class_name"));
        this.zzexz = customEventNative;
        if (customEventNative == null) {
            mediationNativeListener.onAdFailedToLoad((MediationNativeAdapter) this, zzexw);
            return;
        }
        if (bundle2 == null) {
            bundle3 = null;
        } else {
            bundle3 = bundle2.getBundle(bundle.getString("class_name"));
        }
        Context context2 = context;
        this.zzexz.requestNativeAd(context2, new zzb(this, mediationNativeListener), bundle.getString("parameter"), nativeMediationAdRequest, bundle3);
    }

    public final void showInterstitial() {
        this.zzexy.showInterstitial();
    }

    /* access modifiers changed from: private */
    public final void zza(View view) {
        this.zznh = view;
    }
}
