package com.didi.sdk.paxadsdk.admob;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.paxadsdk.AdAgency;
import com.didi.sdk.paxadsdk.AdLoadListenner;
import com.didi.sdk.paxadsdk.NativeAdStyle;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.ads.formats.MediaView;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.UnifiedNativeAd;
import com.google.android.gms.ads.formats.UnifiedNativeAdView;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.taxis99.R;
import java.util.HashMap;
import java.util.Map;

public class AdmobLoader implements AdAgency {

    /* renamed from: a */
    private Map<String, AdLoader> f36882a = new HashMap();
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Map<String, AdLoadListenner> f36883b = new HashMap();

    public String getName() {
        return "admob";
    }

    public void init(Context context) {
        final long currentTimeMillis = System.currentTimeMillis();
        MobileAds.initialize(context, (OnInitializationCompleteListener) new OnInitializationCompleteListener() {
            public void onInitializationComplete(InitializationStatus initializationStatus) {
                long currentTimeMillis = System.currentTimeMillis() - currentTimeMillis;
                SystemUtils.log(6, "admob", "AdMob init takes time: " + currentTimeMillis, (Throwable) null, "com.didi.sdk.paxadsdk.admob.AdmobLoader$1", 61);
                if (initializationStatus != null) {
                    SystemUtils.log(3, "admob", "AdMob init rst:" + initializationStatus.getAdapterStatusMap(), (Throwable) null, "com.didi.sdk.paxadsdk.admob.AdmobLoader$1", 63);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static Activity m26122b(Context context) {
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return m26122b(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    /* renamed from: a */
    private String m26120a(NativeAdStyle nativeAdStyle, String str) {
        return str + "_" + nativeAdStyle.name();
    }

    public void loadNativeAD(final Context context, final NativeAdStyle nativeAdStyle, String str, AdLoadListenner adLoadListenner) {
        NativeAdOptions nativeAdOptions;
        final String a = m26120a(nativeAdStyle, str);
        this.f36883b.put(a, adLoadListenner);
        if (!this.f36882a.containsKey(a)) {
            AdLoader.Builder builder = new AdLoader.Builder(context, str);
            builder.forUnifiedNativeAd(new UnifiedNativeAd.OnUnifiedNativeAdLoadedListener() {
                public void onUnifiedNativeAdLoaded(UnifiedNativeAd unifiedNativeAd) {
                    View view;
                    SystemUtils.log(3, "admob", "onUnifiedNativeAdLoaded: onsuccess ", (Throwable) null, "com.didi.sdk.paxadsdk.admob.AdmobLoader$2", 101);
                    if (unifiedNativeAd != null) {
                        Context context = context;
                        if (context == null) {
                            unifiedNativeAd.destroy();
                            return;
                        }
                        Activity a = AdmobLoader.m26122b(context);
                        if (a == null) {
                            unifiedNativeAd.destroy();
                            return;
                        }
                        boolean z = false;
                        if (Build.VERSION.SDK_INT >= 17) {
                            z = a.isDestroyed();
                        }
                        if (z || a.isFinishing() || a.isDestroyed() || a.isChangingConfigurations()) {
                            unifiedNativeAd.destroy();
                            return;
                        }
                        if (C127016.$SwitchMap$com$didi$sdk$paxadsdk$NativeAdStyle[nativeAdStyle.ordinal()] != 1) {
                            view = AdmobLoader.this.m26118a(context, unifiedNativeAd);
                        } else {
                            view = AdmobLoader.this.m26123b(context, unifiedNativeAd);
                        }
                        if (AdmobLoader.this.f36883b.get(a) != null) {
                            ((AdLoadListenner) AdmobLoader.this.f36883b.get(a)).onSuccess(view);
                        }
                    }
                }
            });
            builder.withAdListener(new AdListener() {
                public void onAdFailedToLoad(LoadAdError loadAdError) {
                    super.onAdFailedToLoad(loadAdError);
                    SystemUtils.log(3, "admob", "onAdFailedToLoad: " + loadAdError, (Throwable) null, "com.didi.sdk.paxadsdk.admob.AdmobLoader$3", 160);
                    if (AdmobLoader.this.f36883b.get(a) == null) {
                        return;
                    }
                    if (loadAdError != null) {
                        ((AdLoadListenner) AdmobLoader.this.f36883b.get(a)).onFailed(loadAdError.getCode() + "", loadAdError.getMessage(), "onAdFailedToLoad: " + loadAdError);
                        return;
                    }
                    ((AdLoadListenner) AdmobLoader.this.f36883b.get(a)).onFailed("-10001", "onAdFailedToLoad: empty loadAdError", "");
                }

                public void onAdClicked() {
                    SystemUtils.log(3, "admob", "onAdClicked: ", (Throwable) null, "com.didi.sdk.paxadsdk.admob.AdmobLoader$3", 173);
                    if (AdmobLoader.this.f36883b.get(a) != null) {
                        ((AdLoadListenner) AdmobLoader.this.f36883b.get(a)).onAdClicked();
                    }
                }

                public void onAdClosed() {
                    SystemUtils.log(3, "admob", "onAdClosed: ", (Throwable) null, "com.didi.sdk.paxadsdk.admob.AdmobLoader$3", 183);
                    if (AdmobLoader.this.f36883b.get(a) != null) {
                        ((AdLoadListenner) AdmobLoader.this.f36883b.get(a)).onAdClosed();
                    }
                }

                public void onAdImpression() {
                    SystemUtils.log(3, "admob", "onAdImpression: ", (Throwable) null, "com.didi.sdk.paxadsdk.admob.AdmobLoader$3", 193);
                    if (AdmobLoader.this.f36883b.get(a) != null) {
                        ((AdLoadListenner) AdmobLoader.this.f36883b.get(a)).onAdImpression();
                    }
                }

                public void onAdLoaded() {
                    SystemUtils.log(3, "admob", "onAdLoaded: ", (Throwable) null, "com.didi.sdk.paxadsdk.admob.AdmobLoader$3", 202);
                    if (AdmobLoader.this.f36883b.get(a) != null) {
                        ((AdLoadListenner) AdmobLoader.this.f36883b.get(a)).onAdLoaded();
                    }
                }

                public void onAdOpened() {
                    SystemUtils.log(3, "admob", "onAdOpened: ", (Throwable) null, "com.didi.sdk.paxadsdk.admob.AdmobLoader$3", 212);
                    if (AdmobLoader.this.f36883b.get(a) != null) {
                        ((AdLoadListenner) AdmobLoader.this.f36883b.get(a)).onAdOpened();
                    }
                }
            });
            VideoOptions build = new VideoOptions.Builder().setStartMuted(true).build();
            if (nativeAdStyle == NativeAdStyle.Dialog) {
                nativeAdOptions = new NativeAdOptions.Builder().setVideoOptions(build).setAdChoicesPlacement(2).build();
            } else {
                nativeAdOptions = new NativeAdOptions.Builder().setVideoOptions(build).build();
            }
            builder.withNativeAdOptions(nativeAdOptions);
            AdLoader build2 = builder.build();
            this.f36882a.put(a, build2);
            build2.loadAd(new AdRequest.Builder().build());
        } else if (!this.f36882a.get(a).isLoading()) {
            this.f36882a.get(a).loadAd(new AdRequest.Builder().build());
        }
    }

    /* renamed from: com.didi.sdk.paxadsdk.admob.AdmobLoader$6 */
    static /* synthetic */ class C127016 {
        static final /* synthetic */ int[] $SwitchMap$com$didi$sdk$paxadsdk$NativeAdStyle;

        static {
            int[] iArr = new int[NativeAdStyle.values().length];
            $SwitchMap$com$didi$sdk$paxadsdk$NativeAdStyle = iArr;
            try {
                iArr[NativeAdStyle.Dialog.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public View m26118a(Context context, UnifiedNativeAd unifiedNativeAd) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.pax_ad_native_small_card, (ViewGroup) null);
        UnifiedNativeAdView unifiedNativeAdView = (UnifiedNativeAdView) linearLayout.findViewById(R.id.ad_view);
        unifiedNativeAdView.setHeadlineView(unifiedNativeAdView.findViewById(R.id.ad_headline));
        unifiedNativeAdView.setBodyView(unifiedNativeAdView.findViewById(R.id.ad_body));
        unifiedNativeAdView.setCallToActionView(unifiedNativeAdView.findViewById(R.id.ad_call_to_action));
        unifiedNativeAdView.setIconView(unifiedNativeAdView.findViewById(R.id.ad_app_icon));
        unifiedNativeAdView.setStarRatingView(unifiedNativeAdView.findViewById(R.id.ad_stars));
        ((TextView) unifiedNativeAdView.getHeadlineView()).setText(unifiedNativeAd.getHeadline());
        if (unifiedNativeAd.getBody() == null) {
            unifiedNativeAdView.getBodyView().setVisibility(8);
        } else {
            unifiedNativeAdView.getBodyView().setVisibility(0);
            ((TextView) unifiedNativeAdView.getBodyView()).setText(unifiedNativeAd.getBody());
        }
        if (unifiedNativeAd.getCallToAction() == null) {
            unifiedNativeAdView.getCallToActionView().setVisibility(4);
        } else {
            unifiedNativeAdView.getCallToActionView().setVisibility(0);
            ((TextView) unifiedNativeAdView.getCallToActionView()).setText(unifiedNativeAd.getCallToAction());
        }
        if (unifiedNativeAd.getIcon() == null) {
            unifiedNativeAdView.getIconView().setVisibility(4);
        } else {
            ((ImageView) unifiedNativeAdView.getIconView()).setImageDrawable(unifiedNativeAd.getIcon().getDrawable());
            unifiedNativeAdView.getIconView().setVisibility(0);
        }
        if (unifiedNativeAd.getStarRating() == null) {
            unifiedNativeAdView.getStarRatingView().setVisibility(8);
        } else {
            ((RatingBar) unifiedNativeAdView.getStarRatingView()).setRating(unifiedNativeAd.getStarRating().floatValue());
            unifiedNativeAdView.getStarRatingView().setVisibility(0);
        }
        unifiedNativeAdView.setNativeAd(unifiedNativeAd);
        VideoController videoController = unifiedNativeAd.getVideoController();
        if (videoController.hasVideoContent()) {
            videoController.getAspectRatio();
            videoController.setVideoLifecycleCallbacks(new VideoController.VideoLifecycleCallbacks() {
                public void onVideoEnd() {
                    super.onVideoEnd();
                }
            });
        }
        return linearLayout;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public View m26123b(Context context, UnifiedNativeAd unifiedNativeAd) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.pax_ad_native_dialog, (ViewGroup) null);
        UnifiedNativeAdView unifiedNativeAdView = (UnifiedNativeAdView) linearLayout.findViewById(R.id.ad_view);
        unifiedNativeAdView.setMediaView((MediaView) unifiedNativeAdView.findViewById(R.id.ad_media));
        unifiedNativeAdView.setHeadlineView(unifiedNativeAdView.findViewById(R.id.ad_headline));
        unifiedNativeAdView.setBodyView(unifiedNativeAdView.findViewById(R.id.ad_body));
        unifiedNativeAdView.setCallToActionView(unifiedNativeAdView.findViewById(R.id.ad_call_to_action));
        unifiedNativeAdView.setIconView(unifiedNativeAdView.findViewById(R.id.ad_app_icon));
        unifiedNativeAdView.setStarRatingView(unifiedNativeAdView.findViewById(R.id.ad_stars));
        ((TextView) unifiedNativeAdView.getHeadlineView()).setText(unifiedNativeAd.getHeadline());
        unifiedNativeAdView.getMediaView().setMediaContent(unifiedNativeAd.getMediaContent());
        unifiedNativeAdView.getMediaView().setImageScaleType(ImageView.ScaleType.CENTER_CROP);
        if (unifiedNativeAd.getBody() == null) {
            unifiedNativeAdView.getBodyView().setVisibility(4);
        } else {
            unifiedNativeAdView.getBodyView().setVisibility(0);
            ((TextView) unifiedNativeAdView.getBodyView()).setText(unifiedNativeAd.getBody());
        }
        if (unifiedNativeAd.getCallToAction() == null) {
            unifiedNativeAdView.getCallToActionView().setVisibility(4);
        } else {
            unifiedNativeAdView.getCallToActionView().setVisibility(0);
            ((TextView) unifiedNativeAdView.getCallToActionView()).setText(unifiedNativeAd.getCallToAction());
        }
        if (unifiedNativeAd.getIcon() == null) {
            unifiedNativeAdView.findViewById(R.id.icon_wrapper).setVisibility(8);
            unifiedNativeAdView.getIconView().setVisibility(8);
        } else {
            unifiedNativeAdView.findViewById(R.id.icon_wrapper).setVisibility(0);
            ((ImageView) unifiedNativeAdView.getIconView()).setImageDrawable(unifiedNativeAd.getIcon().getDrawable());
            unifiedNativeAdView.getIconView().setVisibility(0);
        }
        if (unifiedNativeAd.getStarRating() == null) {
            unifiedNativeAdView.getStarRatingView().setVisibility(8);
        } else {
            ((RatingBar) unifiedNativeAdView.getStarRatingView()).setRating(unifiedNativeAd.getStarRating().floatValue());
            unifiedNativeAdView.getStarRatingView().setVisibility(0);
        }
        unifiedNativeAdView.setNativeAd(unifiedNativeAd);
        VideoController videoController = unifiedNativeAd.getVideoController();
        if (videoController.hasVideoContent()) {
            videoController.getAspectRatio();
            videoController.setVideoLifecycleCallbacks(new VideoController.VideoLifecycleCallbacks() {
                public void onVideoEnd() {
                    super.onVideoEnd();
                }
            });
        }
        return linearLayout;
    }

    public void release(NativeAdStyle nativeAdStyle, String str) {
        this.f36883b.put(m26120a(nativeAdStyle, str), (Object) null);
    }

    public void releaseAll() {
        this.f36883b.clear();
    }
}
