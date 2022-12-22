package com.google.ads.mediation.customevent;

import android.app.Activity;
import android.view.View;
import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.mediation.MediationAdRequest;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.mediation.customevent.CustomEventExtras;
import com.google.android.gms.internal.ads.zzbao;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public final class CustomEventAdapter implements MediationBannerAdapter<CustomEventExtras, CustomEventServerParameters>, MediationInterstitialAdapter<CustomEventExtras, CustomEventServerParameters> {
    private View zznh;
    private CustomEventBanner zzni;
    private CustomEventInterstitial zznj;

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
    class zza implements CustomEventInterstitialListener {
        private final CustomEventAdapter zznk;
        private final MediationInterstitialListener zznl;

        public zza(CustomEventAdapter customEventAdapter, MediationInterstitialListener mediationInterstitialListener) {
            this.zznk = customEventAdapter;
            this.zznl = mediationInterstitialListener;
        }

        public final void onReceivedAd() {
            zzbao.zzdz("Custom event adapter called onReceivedAd.");
            this.zznl.onReceivedAd(CustomEventAdapter.this);
        }

        public final void onFailedToReceiveAd() {
            zzbao.zzdz("Custom event adapter called onFailedToReceiveAd.");
            this.zznl.onFailedToReceiveAd(this.zznk, AdRequest.ErrorCode.NO_FILL);
        }

        public final void onPresentScreen() {
            zzbao.zzdz("Custom event adapter called onPresentScreen.");
            this.zznl.onPresentScreen(this.zznk);
        }

        public final void onDismissScreen() {
            zzbao.zzdz("Custom event adapter called onDismissScreen.");
            this.zznl.onDismissScreen(this.zznk);
        }

        public final void onLeaveApplication() {
            zzbao.zzdz("Custom event adapter called onLeaveApplication.");
            this.zznl.onLeaveApplication(this.zznk);
        }
    }

    /* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
    static final class zzb implements CustomEventBannerListener {
        private final CustomEventAdapter zznk;
        private final MediationBannerListener zznn;

        public zzb(CustomEventAdapter customEventAdapter, MediationBannerListener mediationBannerListener) {
            this.zznk = customEventAdapter;
            this.zznn = mediationBannerListener;
        }

        public final void onReceivedAd(View view) {
            zzbao.zzdz("Custom event adapter called onReceivedAd.");
            this.zznk.zza(view);
            this.zznn.onReceivedAd(this.zznk);
        }

        public final void onFailedToReceiveAd() {
            zzbao.zzdz("Custom event adapter called onFailedToReceiveAd.");
            this.zznn.onFailedToReceiveAd(this.zznk, AdRequest.ErrorCode.NO_FILL);
        }

        public final void onClick() {
            zzbao.zzdz("Custom event adapter called onFailedToReceiveAd.");
            this.zznn.onClick(this.zznk);
        }

        public final void onPresentScreen() {
            zzbao.zzdz("Custom event adapter called onFailedToReceiveAd.");
            this.zznn.onPresentScreen(this.zznk);
        }

        public final void onDismissScreen() {
            zzbao.zzdz("Custom event adapter called onFailedToReceiveAd.");
            this.zznn.onDismissScreen(this.zznk);
        }

        public final void onLeaveApplication() {
            zzbao.zzdz("Custom event adapter called onFailedToReceiveAd.");
            this.zznn.onLeaveApplication(this.zznk);
        }
    }

    public final void destroy() {
        CustomEventBanner customEventBanner = this.zzni;
        if (customEventBanner != null) {
            customEventBanner.destroy();
        }
        CustomEventInterstitial customEventInterstitial = this.zznj;
        if (customEventInterstitial != null) {
            customEventInterstitial.destroy();
        }
    }

    public final Class<CustomEventExtras> getAdditionalParametersType() {
        return CustomEventExtras.class;
    }

    public final View getBannerView() {
        return this.zznh;
    }

    public final Class<CustomEventServerParameters> getServerParametersType() {
        return CustomEventServerParameters.class;
    }

    public final void requestBannerAd(MediationBannerListener mediationBannerListener, Activity activity, CustomEventServerParameters customEventServerParameters, AdSize adSize, MediationAdRequest mediationAdRequest, CustomEventExtras customEventExtras) {
        Object obj;
        CustomEventBanner customEventBanner = (CustomEventBanner) zzal(customEventServerParameters.className);
        this.zzni = customEventBanner;
        if (customEventBanner == null) {
            mediationBannerListener.onFailedToReceiveAd(this, AdRequest.ErrorCode.INTERNAL_ERROR);
            return;
        }
        if (customEventExtras == null) {
            obj = null;
        } else {
            obj = customEventExtras.getExtra(customEventServerParameters.label);
        }
        Activity activity2 = activity;
        this.zzni.requestBannerAd(new zzb(this, mediationBannerListener), activity2, customEventServerParameters.label, customEventServerParameters.parameter, adSize, mediationAdRequest, obj);
    }

    public final void requestInterstitialAd(MediationInterstitialListener mediationInterstitialListener, Activity activity, CustomEventServerParameters customEventServerParameters, MediationAdRequest mediationAdRequest, CustomEventExtras customEventExtras) {
        Object obj;
        CustomEventInterstitial customEventInterstitial = (CustomEventInterstitial) zzal(customEventServerParameters.className);
        this.zznj = customEventInterstitial;
        if (customEventInterstitial == null) {
            mediationInterstitialListener.onFailedToReceiveAd(this, AdRequest.ErrorCode.INTERNAL_ERROR);
            return;
        }
        if (customEventExtras == null) {
            obj = null;
        } else {
            obj = customEventExtras.getExtra(customEventServerParameters.label);
        }
        Activity activity2 = activity;
        this.zznj.requestInterstitialAd(new zza(this, mediationInterstitialListener), activity2, customEventServerParameters.label, customEventServerParameters.parameter, mediationAdRequest, obj);
    }

    public final void showInterstitial() {
        this.zznj.showInterstitial();
    }

    /* access modifiers changed from: private */
    public final void zza(View view) {
        this.zznh = view;
    }
}
