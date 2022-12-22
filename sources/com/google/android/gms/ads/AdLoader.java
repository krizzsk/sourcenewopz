package com.google.android.gms.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.admanager.AdManagerAdRequest;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest;
import com.google.android.gms.ads.formats.AdManagerAdViewOptions;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.google.android.gms.ads.formats.OnAdManagerAdViewLoadedListener;
import com.google.android.gms.ads.formats.OnPublisherAdViewLoadedListener;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;
import com.google.android.gms.ads.formats.UnifiedNativeAd;
import com.google.android.gms.ads.nativead.NativeAd;
import com.google.android.gms.ads.nativead.NativeCustomFormatAd;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzaei;
import com.google.android.gms.internal.ads.zzafs;
import com.google.android.gms.internal.ads.zzafx;
import com.google.android.gms.internal.ads.zzagl;
import com.google.android.gms.internal.ads.zzagy;
import com.google.android.gms.internal.ads.zzahc;
import com.google.android.gms.internal.ads.zzahe;
import com.google.android.gms.internal.ads.zzahg;
import com.google.android.gms.internal.ads.zzahh;
import com.google.android.gms.internal.ads.zzahi;
import com.google.android.gms.internal.ads.zzank;
import com.google.android.gms.internal.ads.zzarp;
import com.google.android.gms.internal.ads.zzars;
import com.google.android.gms.internal.ads.zzbao;
import com.google.android.gms.internal.ads.zzvj;
import com.google.android.gms.internal.ads.zzvr;
import com.google.android.gms.internal.ads.zzvt;
import com.google.android.gms.internal.ads.zzww;
import com.google.android.gms.internal.ads.zzxc;
import com.google.android.gms.internal.ads.zzxi;
import com.google.android.gms.internal.ads.zzxj;
import com.google.android.gms.internal.ads.zzzl;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public class AdLoader {
    private final Context context;
    private final zzvr zzacy;
    private final zzxi zzacz;

    /* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
    public static class Builder {
        private final Context context;
        private final zzxj zzacx;

        @Deprecated
        public Builder withCorrelator(Correlator correlator) {
            return this;
        }

        public Builder(Context context2, String str) {
            this((Context) Preconditions.checkNotNull(context2, "context cannot be null"), zzww.zzqx().zzb(context2, str, new zzank()));
        }

        private Builder(Context context2, zzxj zzxj) {
            this.context = context2;
            this.zzacx = zzxj;
        }

        @Deprecated
        public Builder forContentAd(NativeContentAd.OnContentAdLoadedListener onContentAdLoadedListener) {
            try {
                this.zzacx.zza((zzafx) new zzahh(onContentAdLoadedListener));
            } catch (RemoteException e) {
                zzbao.zzd("Failed to add content ad listener", e);
            }
            return this;
        }

        @Deprecated
        public Builder forAppInstallAd(NativeAppInstallAd.OnAppInstallAdLoadedListener onAppInstallAdLoadedListener) {
            try {
                this.zzacx.zza((zzafs) new zzahe(onAppInstallAdLoadedListener));
            } catch (RemoteException e) {
                zzbao.zzd("Failed to add app install ad listener", e);
            }
            return this;
        }

        @Deprecated
        public Builder forUnifiedNativeAd(UnifiedNativeAd.OnUnifiedNativeAdLoadedListener onUnifiedNativeAdLoadedListener) {
            try {
                this.zzacx.zza((zzagl) new zzahi(onUnifiedNativeAdLoadedListener));
            } catch (RemoteException e) {
                zzbao.zzd("Failed to add google native ad listener", e);
            }
            return this;
        }

        public Builder forNativeAd(NativeAd.OnNativeAdLoadedListener onNativeAdLoadedListener) {
            try {
                this.zzacx.zza((zzagl) new zzars(onNativeAdLoadedListener));
            } catch (RemoteException e) {
                zzbao.zzd("Failed to add google native ad listener", e);
            }
            return this;
        }

        @Deprecated
        public Builder forCustomTemplateAd(String str, NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener onCustomTemplateAdLoadedListener, NativeCustomTemplateAd.OnCustomClickListener onCustomClickListener) {
            zzagy zzagy = new zzagy(onCustomTemplateAdLoadedListener, onCustomClickListener);
            try {
                this.zzacx.zza(str, zzagy.zzuf(), zzagy.zzug());
            } catch (RemoteException e) {
                zzbao.zzd("Failed to add custom template ad listener", e);
            }
            return this;
        }

        public Builder forCustomFormatAd(String str, NativeCustomFormatAd.OnCustomFormatAdLoadedListener onCustomFormatAdLoadedListener, NativeCustomFormatAd.OnCustomClickListener onCustomClickListener) {
            zzarp zzarp = new zzarp(onCustomFormatAdLoadedListener, onCustomClickListener);
            try {
                this.zzacx.zza(str, zzarp.zzwd(), zzarp.zzug());
            } catch (RemoteException e) {
                zzbao.zzd("Failed to add custom format ad listener", e);
            }
            return this;
        }

        @Deprecated
        public Builder forPublisherAdView(OnPublisherAdViewLoadedListener onPublisherAdViewLoadedListener, AdSize... adSizeArr) {
            if (adSizeArr == null || adSizeArr.length <= 0) {
                throw new IllegalArgumentException("The supported ad sizes must contain at least one valid ad size.");
            }
            try {
                this.zzacx.zza(new zzahg(onPublisherAdViewLoadedListener), new zzvt(this.context, adSizeArr));
            } catch (RemoteException e) {
                zzbao.zzd("Failed to add publisher banner ad listener", e);
            }
            return this;
        }

        public Builder forAdManagerAdView(OnAdManagerAdViewLoadedListener onAdManagerAdViewLoadedListener, AdSize... adSizeArr) {
            if (adSizeArr == null || adSizeArr.length <= 0) {
                throw new IllegalArgumentException("The supported ad sizes must contain at least one valid ad size.");
            }
            try {
                this.zzacx.zza(new zzahc(onAdManagerAdViewLoadedListener), new zzvt(this.context, adSizeArr));
            } catch (RemoteException e) {
                zzbao.zzd("Failed to add Google Ad Manager banner ad listener", e);
            }
            return this;
        }

        public Builder withAdListener(AdListener adListener) {
            try {
                this.zzacx.zzb((zzxc) new zzvj(adListener));
            } catch (RemoteException e) {
                zzbao.zzd("Failed to set AdListener.", e);
            }
            return this;
        }

        @Deprecated
        public Builder withNativeAdOptions(NativeAdOptions nativeAdOptions) {
            try {
                this.zzacx.zza(new zzaei(nativeAdOptions));
            } catch (RemoteException e) {
                zzbao.zzd("Failed to specify native ad options", e);
            }
            return this;
        }

        public Builder withNativeAdOptions(com.google.android.gms.ads.nativead.NativeAdOptions nativeAdOptions) {
            try {
                this.zzacx.zza(new zzaei(nativeAdOptions));
            } catch (RemoteException e) {
                zzbao.zzd("Failed to specify native ad options", e);
            }
            return this;
        }

        @Deprecated
        public Builder withPublisherAdViewOptions(PublisherAdViewOptions publisherAdViewOptions) {
            try {
                this.zzacx.zza(publisherAdViewOptions);
            } catch (RemoteException e) {
                zzbao.zzd("Failed to specify Ad Manager banner ad options", e);
            }
            return this;
        }

        public Builder withAdManagerAdViewOptions(AdManagerAdViewOptions adManagerAdViewOptions) {
            try {
                this.zzacx.zza(adManagerAdViewOptions);
            } catch (RemoteException e) {
                zzbao.zzd("Failed to specify Ad Manager banner ad options", e);
            }
            return this;
        }

        public AdLoader build() {
            try {
                return new AdLoader(this.context, this.zzacx.zzrf());
            } catch (RemoteException e) {
                zzbao.zzc("Failed to build AdLoader.", e);
                return null;
            }
        }
    }

    AdLoader(Context context2, zzxi zzxi) {
        this(context2, zzxi, zzvr.zzciq);
    }

    private AdLoader(Context context2, zzxi zzxi, zzvr zzvr) {
        this.context = context2;
        this.zzacz = zzxi;
        this.zzacy = zzvr;
    }

    private final void zza(zzzl zzzl) {
        try {
            this.zzacz.zzb(zzvr.zza(this.context, zzzl));
        } catch (RemoteException e) {
            zzbao.zzc("Failed to load ad.", e);
        }
    }

    public void loadAd(AdRequest adRequest) {
        zza(adRequest.zzdt());
    }

    @Deprecated
    public void loadAd(PublisherAdRequest publisherAdRequest) {
        zza(publisherAdRequest.zzdt());
    }

    public void loadAd(AdManagerAdRequest adManagerAdRequest) {
        zza(adManagerAdRequest.zzdt());
    }

    public void loadAds(AdRequest adRequest, int i) {
        try {
            this.zzacz.zza(zzvr.zza(this.context, adRequest.zzdt()), i);
        } catch (RemoteException e) {
            zzbao.zzc("Failed to load ads.", e);
        }
    }

    @Deprecated
    public String getMediationAdapterClassName() {
        try {
            return this.zzacz.zzkl();
        } catch (RemoteException e) {
            zzbao.zzd("Failed to get the mediation adapter class name.", e);
            return null;
        }
    }

    public boolean isLoading() {
        try {
            return this.zzacz.isLoading();
        } catch (RemoteException e) {
            zzbao.zzd("Failed to check if ad is loading.", e);
            return false;
        }
    }
}
