package com.google.ads.mediation;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.NativeAdView;
import com.google.android.gms.ads.formats.NativeAdViewHolder;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.google.android.gms.ads.formats.UnifiedNativeAd;
import com.google.android.gms.ads.formats.UnifiedNativeAdView;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.MediationNativeListener;
import com.google.android.gms.ads.mediation.NativeAdMapper;
import com.google.android.gms.ads.mediation.NativeAppInstallAdMapper;
import com.google.android.gms.ads.mediation.NativeContentAdMapper;
import com.google.android.gms.ads.mediation.NativeMediationAdRequest;
import com.google.android.gms.ads.mediation.OnImmersiveModeUpdatedListener;
import com.google.android.gms.ads.mediation.UnifiedNativeAdMapper;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener;
import com.google.android.gms.internal.ads.zzbae;
import com.google.android.gms.internal.ads.zzbao;
import com.google.android.gms.internal.ads.zzbhf;
import com.google.android.gms.internal.ads.zzve;
import com.google.android.gms.internal.ads.zzww;
import com.google.android.gms.internal.ads.zzzd;
import java.util.Date;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public abstract class AbstractAdViewAdapter implements MediationBannerAdapter, MediationNativeAdapter, OnImmersiveModeUpdatedListener, com.google.android.gms.ads.mediation.zza, MediationRewardedVideoAdAdapter, zzbhf {
    public static final String AD_UNIT_ID_PARAMETER = "pubid";
    private AdView zzmo;
    private InterstitialAd zzmp;
    private AdLoader zzmq;
    private Context zzmr;
    /* access modifiers changed from: private */
    public InterstitialAd zzms;
    /* access modifiers changed from: private */
    public MediationRewardedVideoAdListener zzmt;
    private final RewardedVideoAdListener zzmu = new zza(this);

    /* access modifiers changed from: protected */
    public abstract Bundle zza(Bundle bundle, Bundle bundle2);

    private final AdRequest zza(Context context, MediationAdRequest mediationAdRequest, Bundle bundle, Bundle bundle2) {
        AdRequest.Builder builder = new AdRequest.Builder();
        Date birthday = mediationAdRequest.getBirthday();
        if (birthday != null) {
            builder.setBirthday(birthday);
        }
        int gender = mediationAdRequest.getGender();
        if (gender != 0) {
            builder.setGender(gender);
        }
        Set<String> keywords = mediationAdRequest.getKeywords();
        if (keywords != null) {
            for (String addKeyword : keywords) {
                builder.addKeyword(addKeyword);
            }
        }
        Location location = mediationAdRequest.getLocation();
        if (location != null) {
            builder.setLocation(location);
        }
        if (mediationAdRequest.isTesting()) {
            zzww.zzqw();
            builder.addTestDevice(zzbae.zzbp(context));
        }
        if (mediationAdRequest.taggedForChildDirectedTreatment() != -1) {
            boolean z = true;
            if (mediationAdRequest.taggedForChildDirectedTreatment() != 1) {
                z = false;
            }
            builder.tagForChildDirectedTreatment(z);
        }
        builder.setIsDesignedForFamilies(mediationAdRequest.isDesignedForFamilies());
        builder.addNetworkExtrasBundle(AdMobAdapter.class, zza(bundle, bundle2));
        return builder.build();
    }

    /* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
    static final class zzd extends AdListener implements zzve {
        private final AbstractAdViewAdapter zzmy;
        private final MediationInterstitialListener zzmz;

        public zzd(AbstractAdViewAdapter abstractAdViewAdapter, MediationInterstitialListener mediationInterstitialListener) {
            this.zzmy = abstractAdViewAdapter;
            this.zzmz = mediationInterstitialListener;
        }

        public final void onAdLoaded() {
            this.zzmz.onAdLoaded(this.zzmy);
        }

        public final void onAdFailedToLoad(int i) {
            this.zzmz.onAdFailedToLoad((MediationInterstitialAdapter) this.zzmy, i);
        }

        public final void onAdOpened() {
            this.zzmz.onAdOpened(this.zzmy);
        }

        public final void onAdClosed() {
            this.zzmz.onAdClosed(this.zzmy);
        }

        public final void onAdLeftApplication() {
            this.zzmz.onAdLeftApplication(this.zzmy);
        }

        public final void onAdClicked() {
            this.zzmz.onAdClicked(this.zzmy);
        }
    }

    /* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
    static final class zze extends AdListener implements AppEventListener, zzve {
        private final AbstractAdViewAdapter zzmy;
        private final MediationBannerListener zzna;

        public zze(AbstractAdViewAdapter abstractAdViewAdapter, MediationBannerListener mediationBannerListener) {
            this.zzmy = abstractAdViewAdapter;
            this.zzna = mediationBannerListener;
        }

        public final void onAdLoaded() {
            this.zzna.onAdLoaded(this.zzmy);
        }

        public final void onAdFailedToLoad(int i) {
            this.zzna.onAdFailedToLoad((MediationBannerAdapter) this.zzmy, i);
        }

        public final void onAdOpened() {
            this.zzna.onAdOpened(this.zzmy);
        }

        public final void onAdClosed() {
            this.zzna.onAdClosed(this.zzmy);
        }

        public final void onAdLeftApplication() {
            this.zzna.onAdLeftApplication(this.zzmy);
        }

        public final void onAdClicked() {
            this.zzna.onAdClicked(this.zzmy);
        }

        public final void onAppEvent(String str, String str2) {
            this.zzna.zza(this.zzmy, str, str2);
        }
    }

    /* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
    static final class zzf extends AdListener implements NativeAppInstallAd.OnAppInstallAdLoadedListener, NativeContentAd.OnContentAdLoadedListener, NativeCustomTemplateAd.OnCustomClickListener, NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener, UnifiedNativeAd.OnUnifiedNativeAdLoadedListener {
        private final AbstractAdViewAdapter zzmy;
        private final MediationNativeListener zznb;

        public zzf(AbstractAdViewAdapter abstractAdViewAdapter, MediationNativeListener mediationNativeListener) {
            this.zzmy = abstractAdViewAdapter;
            this.zznb = mediationNativeListener;
        }

        public final void onAdLoaded() {
        }

        public final void onAdFailedToLoad(int i) {
            this.zznb.onAdFailedToLoad((MediationNativeAdapter) this.zzmy, i);
        }

        public final void onAdOpened() {
            this.zznb.onAdOpened(this.zzmy);
        }

        public final void onAdClosed() {
            this.zznb.onAdClosed(this.zzmy);
        }

        public final void onAdLeftApplication() {
            this.zznb.onAdLeftApplication(this.zzmy);
        }

        public final void onAdClicked() {
            this.zznb.onAdClicked(this.zzmy);
        }

        public final void onAdImpression() {
            this.zznb.onAdImpression(this.zzmy);
        }

        public final void onAppInstallAdLoaded(NativeAppInstallAd nativeAppInstallAd) {
            this.zznb.onAdLoaded((MediationNativeAdapter) this.zzmy, (NativeAdMapper) new zza(nativeAppInstallAd));
        }

        public final void onUnifiedNativeAdLoaded(UnifiedNativeAd unifiedNativeAd) {
            this.zznb.onAdLoaded((MediationNativeAdapter) this.zzmy, (UnifiedNativeAdMapper) new zzb(unifiedNativeAd));
        }

        public final void onContentAdLoaded(NativeContentAd nativeContentAd) {
            this.zznb.onAdLoaded((MediationNativeAdapter) this.zzmy, (NativeAdMapper) new zzc(nativeContentAd));
        }

        public final void onCustomTemplateAdLoaded(NativeCustomTemplateAd nativeCustomTemplateAd) {
            this.zznb.zza(this.zzmy, nativeCustomTemplateAd);
        }

        public final void onCustomClick(NativeCustomTemplateAd nativeCustomTemplateAd, String str) {
            this.zznb.zza(this.zzmy, nativeCustomTemplateAd, str);
        }
    }

    /* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
    static class zzc extends NativeContentAdMapper {
        private final NativeContentAd zzmx;

        public zzc(NativeContentAd nativeContentAd) {
            this.zzmx = nativeContentAd;
            setHeadline(nativeContentAd.getHeadline().toString());
            setImages(nativeContentAd.getImages());
            setBody(nativeContentAd.getBody().toString());
            if (nativeContentAd.getLogo() != null) {
                setLogo(nativeContentAd.getLogo());
            }
            setCallToAction(nativeContentAd.getCallToAction().toString());
            setAdvertiser(nativeContentAd.getAdvertiser().toString());
            setOverrideImpressionRecording(true);
            setOverrideClickHandling(true);
            zza(nativeContentAd.getVideoController());
        }

        public final void trackView(View view) {
            if (view instanceof NativeAdView) {
                ((NativeAdView) view).setNativeAd(this.zzmx);
            }
            NativeAdViewHolder nativeAdViewHolder = NativeAdViewHolder.zzbol.get(view);
            if (nativeAdViewHolder != null) {
                nativeAdViewHolder.setNativeAd((NativeAd) this.zzmx);
            }
        }
    }

    /* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
    private static class zzb extends UnifiedNativeAdMapper {
        private final UnifiedNativeAd zzmw;

        public zzb(UnifiedNativeAd unifiedNativeAd) {
            this.zzmw = unifiedNativeAd;
            setHeadline(unifiedNativeAd.getHeadline());
            setImages(unifiedNativeAd.getImages());
            setBody(unifiedNativeAd.getBody());
            setIcon(unifiedNativeAd.getIcon());
            setCallToAction(unifiedNativeAd.getCallToAction());
            setAdvertiser(unifiedNativeAd.getAdvertiser());
            setStarRating(unifiedNativeAd.getStarRating());
            setStore(unifiedNativeAd.getStore());
            setPrice(unifiedNativeAd.getPrice());
            zzm(unifiedNativeAd.zzka());
            setOverrideImpressionRecording(true);
            setOverrideClickHandling(true);
            zza(unifiedNativeAd.getVideoController());
        }

        public final void trackViews(View view, Map<String, View> map, Map<String, View> map2) {
            if (view instanceof UnifiedNativeAdView) {
                ((UnifiedNativeAdView) view).setNativeAd(this.zzmw);
                return;
            }
            NativeAdViewHolder nativeAdViewHolder = NativeAdViewHolder.zzbol.get(view);
            if (nativeAdViewHolder != null) {
                nativeAdViewHolder.setNativeAd(this.zzmw);
            }
        }
    }

    /* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
    static class zza extends NativeAppInstallAdMapper {
        private final NativeAppInstallAd zzmv;

        public zza(NativeAppInstallAd nativeAppInstallAd) {
            this.zzmv = nativeAppInstallAd;
            setHeadline(nativeAppInstallAd.getHeadline().toString());
            setImages(nativeAppInstallAd.getImages());
            setBody(nativeAppInstallAd.getBody().toString());
            setIcon(nativeAppInstallAd.getIcon());
            setCallToAction(nativeAppInstallAd.getCallToAction().toString());
            if (nativeAppInstallAd.getStarRating() != null) {
                setStarRating(nativeAppInstallAd.getStarRating().doubleValue());
            }
            if (nativeAppInstallAd.getStore() != null) {
                setStore(nativeAppInstallAd.getStore().toString());
            }
            if (nativeAppInstallAd.getPrice() != null) {
                setPrice(nativeAppInstallAd.getPrice().toString());
            }
            setOverrideImpressionRecording(true);
            setOverrideClickHandling(true);
            zza(nativeAppInstallAd.getVideoController());
        }

        public final void trackView(View view) {
            if (view instanceof NativeAdView) {
                ((NativeAdView) view).setNativeAd(this.zzmv);
            }
            NativeAdViewHolder nativeAdViewHolder = NativeAdViewHolder.zzbol.get(view);
            if (nativeAdViewHolder != null) {
                nativeAdViewHolder.setNativeAd((NativeAd) this.zzmv);
            }
        }
    }

    public void onDestroy() {
        AdView adView = this.zzmo;
        if (adView != null) {
            adView.destroy();
            this.zzmo = null;
        }
        if (this.zzmp != null) {
            this.zzmp = null;
        }
        if (this.zzmq != null) {
            this.zzmq = null;
        }
        if (this.zzms != null) {
            this.zzms = null;
        }
    }

    public void onPause() {
        AdView adView = this.zzmo;
        if (adView != null) {
            adView.pause();
        }
    }

    public void onResume() {
        AdView adView = this.zzmo;
        if (adView != null) {
            adView.resume();
        }
    }

    public String getAdUnitId(Bundle bundle) {
        return bundle.getString(AD_UNIT_ID_PARAMETER);
    }

    public void requestBannerAd(Context context, MediationBannerListener mediationBannerListener, Bundle bundle, AdSize adSize, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        AdView adView = new AdView(context);
        this.zzmo = adView;
        adView.setAdSize(new AdSize(adSize.getWidth(), adSize.getHeight()));
        this.zzmo.setAdUnitId(getAdUnitId(bundle));
        this.zzmo.setAdListener(new zze(this, mediationBannerListener));
        this.zzmo.loadAd(zza(context, mediationAdRequest, bundle2, bundle));
    }

    public View getBannerView() {
        return this.zzmo;
    }

    public void requestInterstitialAd(Context context, MediationInterstitialListener mediationInterstitialListener, Bundle bundle, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        InterstitialAd interstitialAd = new InterstitialAd(context);
        this.zzmp = interstitialAd;
        interstitialAd.setAdUnitId(getAdUnitId(bundle));
        this.zzmp.setAdListener(new zzd(this, mediationInterstitialListener));
        this.zzmp.loadAd(zza(context, mediationAdRequest, bundle2, bundle));
    }

    public void onImmersiveModeUpdated(boolean z) {
        InterstitialAd interstitialAd = this.zzmp;
        if (interstitialAd != null) {
            interstitialAd.setImmersiveMode(z);
        }
        InterstitialAd interstitialAd2 = this.zzms;
        if (interstitialAd2 != null) {
            interstitialAd2.setImmersiveMode(z);
        }
    }

    public zzzd getVideoController() {
        VideoController videoController;
        AdView adView = this.zzmo;
        if (adView == null || (videoController = adView.getVideoController()) == null) {
            return null;
        }
        return videoController.zzdz();
    }

    public void showInterstitial() {
        this.zzmp.show();
    }

    public Bundle getInterstitialAdapterInfo() {
        return new MediationAdapter.zza().zzed(1).zzafn();
    }

    public void requestNativeAd(Context context, MediationNativeListener mediationNativeListener, Bundle bundle, NativeMediationAdRequest nativeMediationAdRequest, Bundle bundle2) {
        zzf zzf2 = new zzf(this, mediationNativeListener);
        AdLoader.Builder withAdListener = new AdLoader.Builder(context, bundle.getString(AD_UNIT_ID_PARAMETER)).withAdListener(zzf2);
        withAdListener.withNativeAdOptions(nativeMediationAdRequest.getNativeAdOptions());
        withAdListener.withNativeAdOptions(nativeMediationAdRequest.getNativeAdRequestOptions());
        if (nativeMediationAdRequest.isUnifiedNativeAdRequested()) {
            withAdListener.forUnifiedNativeAd(zzf2);
        }
        if (nativeMediationAdRequest.isAppInstallAdRequested()) {
            withAdListener.forAppInstallAd(zzf2);
        }
        if (nativeMediationAdRequest.isContentAdRequested()) {
            withAdListener.forContentAd(zzf2);
        }
        if (nativeMediationAdRequest.zzvw()) {
            for (String next : nativeMediationAdRequest.zzvx().keySet()) {
                withAdListener.forCustomTemplateAd(next, zzf2, nativeMediationAdRequest.zzvx().get(next).booleanValue() ? zzf2 : null);
            }
        }
        AdLoader build = withAdListener.build();
        this.zzmq = build;
        build.loadAd(zza(context, nativeMediationAdRequest, bundle2, bundle));
    }

    public void initialize(Context context, MediationAdRequest mediationAdRequest, String str, MediationRewardedVideoAdListener mediationRewardedVideoAdListener, Bundle bundle, Bundle bundle2) {
        this.zzmr = context.getApplicationContext();
        this.zzmt = mediationRewardedVideoAdListener;
        mediationRewardedVideoAdListener.onInitializationSucceeded(this);
    }

    public void loadAd(MediationAdRequest mediationAdRequest, Bundle bundle, Bundle bundle2) {
        Context context = this.zzmr;
        if (context == null || this.zzmt == null) {
            zzbao.zzex("AdMobAdapter.loadAd called before initialize.");
            return;
        }
        InterstitialAd interstitialAd = new InterstitialAd(context);
        this.zzms = interstitialAd;
        interstitialAd.zze(true);
        this.zzms.setAdUnitId(getAdUnitId(bundle));
        this.zzms.setRewardedVideoAdListener(this.zzmu);
        this.zzms.setAdMetadataListener(new zzb(this));
        this.zzms.loadAd(zza(this.zzmr, mediationAdRequest, bundle2, bundle));
    }

    public void showVideo() {
        this.zzms.show();
    }

    public boolean isInitialized() {
        return this.zzmt != null;
    }
}
