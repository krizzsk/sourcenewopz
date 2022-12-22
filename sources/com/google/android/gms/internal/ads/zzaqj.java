package com.google.android.gms.internal.ads;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.os.RemoteException;
import com.didi.soda.customer.app.constant.Const;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationBannerAdConfiguration;
import com.google.android.gms.ads.mediation.MediationConfiguration;
import com.google.android.gms.ads.mediation.MediationInterstitialAd;
import com.google.android.gms.ads.mediation.MediationInterstitialAdConfiguration;
import com.google.android.gms.ads.mediation.MediationNativeAdConfiguration;
import com.google.android.gms.ads.mediation.MediationRewardedAd;
import com.google.android.gms.ads.mediation.MediationRewardedAdCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAdConfiguration;
import com.google.android.gms.ads.mediation.rtb.RtbAdapter;
import com.google.android.gms.ads.mediation.rtb.RtbSignalData;
import com.google.android.gms.ads.zza;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public final class zzaqj extends zzaqd {
    /* access modifiers changed from: private */
    public MediationInterstitialAd zzdpc;
    /* access modifiers changed from: private */
    public MediationRewardedAd zzdpe;
    private String zzdpg = "";
    private final RtbAdapter zzdqb;

    public zzaqj(RtbAdapter rtbAdapter) {
        this.zzdqb = rtbAdapter;
    }

    public final void zza(String[] strArr, Bundle[] bundleArr) {
    }

    public final void zzz(IObjectWrapper iObjectWrapper) {
    }

    public final void zza(String str, String str2, zzvq zzvq, IObjectWrapper iObjectWrapper, zzapo zzapo, zzant zzant, zzvt zzvt) throws RemoteException {
        zzvq zzvq2 = zzvq;
        zzvt zzvt2 = zzvt;
        try {
            zzaqi zzaqi = new zzaqi(this, zzapo, zzant);
            RtbAdapter rtbAdapter = this.zzdqb;
            Bundle zzdq = zzdq(str2);
            Bundle zzd = zzd(zzvq2);
            boolean zzc = zzc(zzvq);
            Location location = zzvq2.zzng;
            int i = zzvq2.zzadv;
            int i2 = zzvq2.zzadw;
            String zza = zza(str2, zzvq);
            AdSize zza2 = zza.zza(zzvt2.width, zzvt2.height, zzvt2.zzadd);
            String str3 = this.zzdpg;
            MediationBannerAdConfiguration mediationBannerAdConfiguration = r5;
            MediationBannerAdConfiguration mediationBannerAdConfiguration2 = new MediationBannerAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), str, zzdq, zzd, zzc, location, i, i2, zza, zza2, str3);
            rtbAdapter.loadRtbBannerAd(mediationBannerAdConfiguration, zzaqi);
        } catch (Throwable th) {
            zzbao.zzc("Adapter failed to render banner ad.", th);
            throw new RemoteException();
        }
    }

    public final void zzb(String str, String str2, zzvq zzvq, IObjectWrapper iObjectWrapper, zzapo zzapo, zzant zzant, zzvt zzvt) throws RemoteException {
        zzvq zzvq2 = zzvq;
        zzvt zzvt2 = zzvt;
        try {
            zzaql zzaql = new zzaql(this, zzapo, zzant);
            RtbAdapter rtbAdapter = this.zzdqb;
            Bundle zzdq = zzdq(str2);
            Bundle zzd = zzd(zzvq2);
            boolean zzc = zzc(zzvq);
            Location location = zzvq2.zzng;
            int i = zzvq2.zzadv;
            int i2 = zzvq2.zzadw;
            String zza = zza(str2, zzvq);
            AdSize zza2 = zza.zza(zzvt2.width, zzvt2.height, zzvt2.zzadd);
            String str3 = this.zzdpg;
            MediationBannerAdConfiguration mediationBannerAdConfiguration = r5;
            MediationBannerAdConfiguration mediationBannerAdConfiguration2 = new MediationBannerAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), str, zzdq, zzd, zzc, location, i, i2, zza, zza2, str3);
            rtbAdapter.loadRtbInterscrollerAd(mediationBannerAdConfiguration, zzaql);
        } catch (Throwable th) {
            zzbao.zzc("Adapter failed to render interscroller ad.", th);
            throw new RemoteException();
        }
    }

    public final void zza(String str, String str2, zzvq zzvq, IObjectWrapper iObjectWrapper, zzapt zzapt, zzant zzant) throws RemoteException {
        zzvq zzvq2 = zzvq;
        try {
            this.zzdqb.loadRtbInterstitialAd(new MediationInterstitialAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), str, zzdq(str2), zzd(zzvq2), zzc(zzvq), zzvq2.zzng, zzvq2.zzadv, zzvq2.zzadw, zza(str2, zzvq), this.zzdpg), new zzaqk(this, zzapt, zzant));
        } catch (Throwable th) {
            zzbao.zzc("Adapter failed to render interstitial ad.", th);
            throw new RemoteException();
        }
    }

    public final void zza(String str, String str2, zzvq zzvq, IObjectWrapper iObjectWrapper, zzapz zzapz, zzant zzant) throws RemoteException {
        zzvq zzvq2 = zzvq;
        try {
            this.zzdqb.loadRtbRewardedAd(new MediationRewardedAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), str, zzdq(str2), zzd(zzvq2), zzc(zzvq), zzvq2.zzng, zzvq2.zzadv, zzvq2.zzadw, zza(str2, zzvq), this.zzdpg), zza(zzapz, zzant));
        } catch (Throwable th) {
            zzbao.zzc("Adapter failed to render rewarded ad.", th);
            throw new RemoteException();
        }
    }

    public final void zzb(String str, String str2, zzvq zzvq, IObjectWrapper iObjectWrapper, zzapz zzapz, zzant zzant) throws RemoteException {
        zzvq zzvq2 = zzvq;
        try {
            this.zzdqb.loadRtbRewardedInterstitialAd(new MediationRewardedAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), str, zzdq(str2), zzd(zzvq2), zzc(zzvq), zzvq2.zzng, zzvq2.zzadv, zzvq2.zzadw, zza(str2, zzvq), this.zzdpg), zza(zzapz, zzant));
        } catch (Throwable th) {
            zzbao.zzc("Adapter failed to render rewarded interstitial ad.", th);
            throw new RemoteException();
        }
    }

    public final void zza(String str, String str2, zzvq zzvq, IObjectWrapper iObjectWrapper, zzapu zzapu, zzant zzant) throws RemoteException {
        zza(str, str2, zzvq, iObjectWrapper, zzapu, zzant, (zzaei) null);
    }

    public final void zza(String str, String str2, zzvq zzvq, IObjectWrapper iObjectWrapper, zzapu zzapu, zzant zzant, zzaei zzaei) throws RemoteException {
        zzvq zzvq2 = zzvq;
        try {
            zzaqn zzaqn = new zzaqn(this, zzapu, zzant);
            RtbAdapter rtbAdapter = this.zzdqb;
            MediationNativeAdConfiguration mediationNativeAdConfiguration = r4;
            MediationNativeAdConfiguration mediationNativeAdConfiguration2 = new MediationNativeAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), str, zzdq(str2), zzd(zzvq2), zzc(zzvq), zzvq2.zzng, zzvq2.zzadv, zzvq2.zzadw, zza(str2, zzvq), this.zzdpg, zzaei);
            rtbAdapter.loadRtbNativeAd(mediationNativeAdConfiguration, zzaqn);
        } catch (Throwable th) {
            zzbao.zzc("Adapter failed to render native ad.", th);
            throw new RemoteException();
        }
    }

    public final boolean zzaa(IObjectWrapper iObjectWrapper) throws RemoteException {
        MediationInterstitialAd mediationInterstitialAd = this.zzdpc;
        if (mediationInterstitialAd == null) {
            return false;
        }
        try {
            mediationInterstitialAd.showAd((Context) ObjectWrapper.unwrap(iObjectWrapper));
            return true;
        } catch (Throwable th) {
            zzbao.zzc("", th);
            return true;
        }
    }

    public final boolean zzab(IObjectWrapper iObjectWrapper) throws RemoteException {
        MediationRewardedAd mediationRewardedAd = this.zzdpe;
        if (mediationRewardedAd == null) {
            return false;
        }
        try {
            mediationRewardedAd.showAd((Context) ObjectWrapper.unwrap(iObjectWrapper));
            return true;
        } catch (Throwable th) {
            zzbao.zzc("", th);
            return true;
        }
    }

    public final zzzd getVideoController() {
        RtbAdapter rtbAdapter = this.zzdqb;
        if (!(rtbAdapter instanceof com.google.android.gms.ads.mediation.zza)) {
            return null;
        }
        try {
            return ((com.google.android.gms.ads.mediation.zza) rtbAdapter).getVideoController();
        } catch (Throwable th) {
            zzbao.zzc("", th);
            return null;
        }
    }

    public final void zza(IObjectWrapper iObjectWrapper, String str, Bundle bundle, Bundle bundle2, zzvt zzvt, zzaqf zzaqf) throws RemoteException {
        AdFormat adFormat;
        try {
            zzaqm zzaqm = new zzaqm(this, zzaqf);
            RtbAdapter rtbAdapter = this.zzdqb;
            char c = 65535;
            switch (str.hashCode()) {
                case -1396342996:
                    if (str.equals(Const.ComponentType.BANNER)) {
                        c = 0;
                        break;
                    }
                    break;
                case -1052618729:
                    if (str.equals("native")) {
                        c = 4;
                        break;
                    }
                    break;
                case -239580146:
                    if (str.equals("rewarded")) {
                        c = 2;
                        break;
                    }
                    break;
                case 604727084:
                    if (str.equals("interstitial")) {
                        c = 1;
                        break;
                    }
                    break;
                case 1911491517:
                    if (str.equals("rewarded_interstitial")) {
                        c = 3;
                        break;
                    }
                    break;
            }
            if (c == 0) {
                adFormat = AdFormat.BANNER;
            } else if (c == 1) {
                adFormat = AdFormat.INTERSTITIAL;
            } else if (c == 2) {
                adFormat = AdFormat.REWARDED;
            } else if (c == 3) {
                adFormat = AdFormat.REWARDED_INTERSTITIAL;
            } else if (c == 4) {
                adFormat = AdFormat.NATIVE;
            } else {
                throw new IllegalArgumentException("Internal Error");
            }
            MediationConfiguration mediationConfiguration = new MediationConfiguration(adFormat, bundle2);
            ArrayList arrayList = new ArrayList();
            arrayList.add(mediationConfiguration);
            rtbAdapter.collectSignals(new RtbSignalData((Context) ObjectWrapper.unwrap(iObjectWrapper), arrayList, bundle, zza.zza(zzvt.width, zzvt.height, zzvt.zzadd)), zzaqm);
        } catch (Throwable th) {
            zzbao.zzc("Error generating signals for RTB", th);
            throw new RemoteException();
        }
    }

    public final zzaqr zzvm() throws RemoteException {
        return zzaqr.zza(this.zzdqb.getVersionInfo());
    }

    public final zzaqr zzvn() throws RemoteException {
        return zzaqr.zza(this.zzdqb.getSDKVersionInfo());
    }

    public final void zzdn(String str) {
        this.zzdpg = str;
    }

    private final MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> zza(zzapz zzapz, zzant zzant) {
        return new zzaqp(this, zzapz, zzant);
    }

    private static Bundle zzdq(String str) throws RemoteException {
        String valueOf = String.valueOf(str);
        zzbao.zzez(valueOf.length() != 0 ? "Server parameters: ".concat(valueOf) : new String("Server parameters: "));
        try {
            Bundle bundle = new Bundle();
            if (str == null) {
                return bundle;
            }
            JSONObject jSONObject = new JSONObject(str);
            Bundle bundle2 = new Bundle();
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                bundle2.putString(next, jSONObject.getString(next));
            }
            return bundle2;
        } catch (JSONException e) {
            zzbao.zzc("", e);
            throw new RemoteException();
        }
    }

    private static boolean zzc(zzvq zzvq) {
        if (zzvq.zzcid) {
            return true;
        }
        zzww.zzqw();
        return zzbae.zzaap();
    }

    private static String zza(String str, zzvq zzvq) {
        try {
            return new JSONObject(str).getString("max_ad_content_rating");
        } catch (JSONException unused) {
            return zzvq.zzadx;
        }
    }

    private final Bundle zzd(zzvq zzvq) {
        Bundle bundle;
        if (zzvq.zzcih == null || (bundle = zzvq.zzcih.getBundle(this.zzdqb.getClass().getName())) == null) {
            return new Bundle();
        }
        return bundle;
    }
}
