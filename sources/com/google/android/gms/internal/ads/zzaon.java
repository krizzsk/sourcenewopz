package com.google.android.gms.internal.ads;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.View;
import com.didi.soda.customer.app.constant.Const;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.google.android.gms.ads.mediation.Adapter;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.MediationBannerAdConfiguration;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationConfiguration;
import com.google.android.gms.ads.mediation.MediationInterscrollerAd;
import com.google.android.gms.ads.mediation.MediationInterstitialAd;
import com.google.android.gms.ads.mediation.MediationInterstitialAdConfiguration;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationNativeAdConfiguration;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.MediationRewardedAd;
import com.google.android.gms.ads.mediation.MediationRewardedAdCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAdConfiguration;
import com.google.android.gms.ads.mediation.NativeAdMapper;
import com.google.android.gms.ads.mediation.NativeAppInstallAdMapper;
import com.google.android.gms.ads.mediation.NativeContentAdMapper;
import com.google.android.gms.ads.mediation.OnContextChangedListener;
import com.google.android.gms.ads.mediation.OnImmersiveModeUpdatedListener;
import com.google.android.gms.ads.mediation.UnifiedNativeAdMapper;
import com.google.android.gms.ads.reward.mediation.InitializableMediationRewardedVideoAdAdapter;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter;
import com.google.android.gms.ads.zza;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public final class zzaon extends zzanr {
    /* access modifiers changed from: private */
    public View view;
    /* access modifiers changed from: private */
    public final Object zzdoy;
    private zzaov zzdoz;
    private zzavu zzdpa;
    private IObjectWrapper zzdpb;
    /* access modifiers changed from: private */
    public MediationInterstitialAd zzdpc;
    /* access modifiers changed from: private */
    public UnifiedNativeAdMapper zzdpd;
    /* access modifiers changed from: private */
    public MediationRewardedAd zzdpe;
    /* access modifiers changed from: private */
    public MediationInterscrollerAd zzdpf;
    private String zzdpg = "";

    public zzaon(MediationAdapter mediationAdapter) {
        this.zzdoy = mediationAdapter;
    }

    public zzaon(Adapter adapter) {
        this.zzdoy = adapter;
    }

    public final IObjectWrapper zzve() throws RemoteException {
        Object obj = this.zzdoy;
        if (obj instanceof MediationBannerAdapter) {
            try {
                return ObjectWrapper.wrap(((MediationBannerAdapter) obj).getBannerView());
            } catch (Throwable th) {
                zzbao.zzc("", th);
                throw new RemoteException();
            }
        } else if (obj instanceof Adapter) {
            return ObjectWrapper.wrap(this.view);
        } else {
            String canonicalName = MediationBannerAdapter.class.getCanonicalName();
            String canonicalName2 = Adapter.class.getCanonicalName();
            String canonicalName3 = this.zzdoy.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 26 + String.valueOf(canonicalName2).length() + String.valueOf(canonicalName3).length());
            sb.append(canonicalName);
            sb.append(" or ");
            sb.append(canonicalName2);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName3);
            zzbao.zzez(sb.toString());
            throw new RemoteException();
        }
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzvt zzvt, zzvq zzvq, String str, zzant zzant) throws RemoteException {
        zza(iObjectWrapper, zzvt, zzvq, str, (String) null, zzant);
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzvt zzvt, zzvq zzvq, String str, String str2, zzant zzant) throws RemoteException {
        AdSize adSize;
        Date date;
        zzvt zzvt2 = zzvt;
        zzvq zzvq2 = zzvq;
        String str3 = str;
        String str4 = str2;
        zzant zzant2 = zzant;
        Object obj = this.zzdoy;
        if ((obj instanceof MediationBannerAdapter) || (obj instanceof Adapter)) {
            zzbao.zzdz("Requesting banner ad from adapter.");
            if (zzvt2.zzciy) {
                adSize = zza.zzb(zzvt2.width, zzvt2.height);
            } else {
                adSize = zza.zza(zzvt2.width, zzvt2.height, zzvt2.zzadd);
            }
            AdSize adSize2 = adSize;
            Object obj2 = this.zzdoy;
            if (obj2 instanceof MediationBannerAdapter) {
                try {
                    MediationBannerAdapter mediationBannerAdapter = (MediationBannerAdapter) obj2;
                    HashSet hashSet = zzvq2.zzcic != null ? new HashSet(zzvq2.zzcic) : null;
                    if (zzvq2.zzcia == -1) {
                        date = null;
                    } else {
                        date = new Date(zzvq2.zzcia);
                    }
                    mediationBannerAdapter.requestBannerAd((Context) ObjectWrapper.unwrap(iObjectWrapper), new zzaov(zzant2), zza(str3, zzvq2, str4), adSize2, new zzaok(date, zzvq2.zzcib, hashSet, zzvq2.zzng, zzc(zzvq), zzvq2.zzadv, zzvq2.zzcim, zzvq2.zzadw, zza(str3, zzvq2)), zzvq2.zzcih != null ? zzvq2.zzcih.getBundle(mediationBannerAdapter.getClass().getName()) : null);
                } catch (Throwable th) {
                    zzbao.zzc("", th);
                    throw new RemoteException();
                }
            } else if (obj2 instanceof Adapter) {
                try {
                    zzaoo zzaoo = new zzaoo(this, zzant2);
                    Bundle zza = zza(str3, zzvq2, str4);
                    Bundle zzd = zzd(zzvq2);
                    boolean zzc = zzc(zzvq);
                    Location location = zzvq2.zzng;
                    int i = zzvq2.zzadv;
                    int i2 = zzvq2.zzadw;
                    String zza2 = zza(str3, zzvq2);
                    String str5 = this.zzdpg;
                    MediationBannerAdConfiguration mediationBannerAdConfiguration = r2;
                    MediationBannerAdConfiguration mediationBannerAdConfiguration2 = new MediationBannerAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), "", zza, zzd, zzc, location, i, i2, zza2, adSize2, str5);
                    ((Adapter) obj2).loadBannerAd(mediationBannerAdConfiguration, zzaoo);
                } catch (Throwable th2) {
                    zzbao.zzc("", th2);
                    throw new RemoteException();
                }
            }
        } else {
            String canonicalName = MediationBannerAdapter.class.getCanonicalName();
            String canonicalName2 = Adapter.class.getCanonicalName();
            String canonicalName3 = this.zzdoy.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 26 + String.valueOf(canonicalName2).length() + String.valueOf(canonicalName3).length());
            sb.append(canonicalName);
            sb.append(" or ");
            sb.append(canonicalName2);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName3);
            zzbao.zzez(sb.toString());
            throw new RemoteException();
        }
    }

    public final Bundle zzvh() {
        Object obj = this.zzdoy;
        if (obj instanceof zzbhe) {
            return ((zzbhe) obj).zzvh();
        }
        String canonicalName = zzbhe.class.getCanonicalName();
        String canonicalName2 = this.zzdoy.getClass().getCanonicalName();
        StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
        sb.append(canonicalName);
        sb.append(" #009 Class mismatch: ");
        sb.append(canonicalName2);
        zzbao.zzez(sb.toString());
        return new Bundle();
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzvq zzvq, String str, zzant zzant) throws RemoteException {
        zza(iObjectWrapper, zzvq, str, (String) null, zzant);
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzvq zzvq, String str, String str2, zzant zzant) throws RemoteException {
        Date date;
        zzvq zzvq2 = zzvq;
        String str3 = str;
        String str4 = str2;
        zzant zzant2 = zzant;
        Object obj = this.zzdoy;
        if ((obj instanceof MediationInterstitialAdapter) || (obj instanceof Adapter)) {
            zzbao.zzdz("Requesting interstitial ad from adapter.");
            Object obj2 = this.zzdoy;
            if (obj2 instanceof MediationInterstitialAdapter) {
                try {
                    MediationInterstitialAdapter mediationInterstitialAdapter = (MediationInterstitialAdapter) obj2;
                    HashSet hashSet = zzvq2.zzcic != null ? new HashSet(zzvq2.zzcic) : null;
                    if (zzvq2.zzcia == -1) {
                        date = null;
                    } else {
                        date = new Date(zzvq2.zzcia);
                    }
                    mediationInterstitialAdapter.requestInterstitialAd((Context) ObjectWrapper.unwrap(iObjectWrapper), new zzaov(zzant2), zza(str3, zzvq2, str4), new zzaok(date, zzvq2.zzcib, hashSet, zzvq2.zzng, zzc(zzvq), zzvq2.zzadv, zzvq2.zzcim, zzvq2.zzadw, zza(str3, zzvq2)), zzvq2.zzcih != null ? zzvq2.zzcih.getBundle(mediationInterstitialAdapter.getClass().getName()) : null);
                } catch (Throwable th) {
                    zzbao.zzc("", th);
                    throw new RemoteException();
                }
            } else if (obj2 instanceof Adapter) {
                try {
                    ((Adapter) obj2).loadInterstitialAd(new MediationInterstitialAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), "", zza(str3, zzvq2, str4), zzd(zzvq2), zzc(zzvq), zzvq2.zzng, zzvq2.zzadv, zzvq2.zzadw, zza(str3, zzvq2), this.zzdpg), new zzaor(this, zzant2));
                } catch (Throwable th2) {
                    zzbao.zzc("", th2);
                    throw new RemoteException();
                }
            }
        } else {
            String canonicalName = MediationInterstitialAdapter.class.getCanonicalName();
            String canonicalName2 = Adapter.class.getCanonicalName();
            String canonicalName3 = this.zzdoy.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 26 + String.valueOf(canonicalName2).length() + String.valueOf(canonicalName3).length());
            sb.append(canonicalName);
            sb.append(" or ");
            sb.append(canonicalName2);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName3);
            zzbao.zzez(sb.toString());
            throw new RemoteException();
        }
    }

    public final Bundle getInterstitialAdapterInfo() {
        Object obj = this.zzdoy;
        if (obj instanceof zzbhf) {
            return ((zzbhf) obj).getInterstitialAdapterInfo();
        }
        String canonicalName = zzbhf.class.getCanonicalName();
        String canonicalName2 = this.zzdoy.getClass().getCanonicalName();
        StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
        sb.append(canonicalName);
        sb.append(" #009 Class mismatch: ");
        sb.append(canonicalName2);
        zzbao.zzez(sb.toString());
        return new Bundle();
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzvq zzvq, String str, String str2, zzant zzant, zzaei zzaei, List<String> list) throws RemoteException {
        Date date;
        zzvq zzvq2 = zzvq;
        String str3 = str;
        String str4 = str2;
        zzant zzant2 = zzant;
        Object obj = this.zzdoy;
        if ((obj instanceof MediationNativeAdapter) || (obj instanceof Adapter)) {
            zzbao.zzdz("Requesting native ad from adapter.");
            Object obj2 = this.zzdoy;
            if (obj2 instanceof MediationNativeAdapter) {
                try {
                    MediationNativeAdapter mediationNativeAdapter = (MediationNativeAdapter) obj2;
                    HashSet hashSet = zzvq2.zzcic != null ? new HashSet(zzvq2.zzcic) : null;
                    if (zzvq2.zzcia == -1) {
                        date = null;
                    } else {
                        date = new Date(zzvq2.zzcia);
                    }
                    zzaoz zzaoz = new zzaoz(date, zzvq2.zzcib, hashSet, zzvq2.zzng, zzc(zzvq), zzvq2.zzadv, zzaei, list, zzvq2.zzcim, zzvq2.zzadw, zza(str3, zzvq2));
                    Bundle bundle = zzvq2.zzcih != null ? zzvq2.zzcih.getBundle(mediationNativeAdapter.getClass().getName()) : null;
                    this.zzdoz = new zzaov(zzant2);
                    mediationNativeAdapter.requestNativeAd((Context) ObjectWrapper.unwrap(iObjectWrapper), this.zzdoz, zza(str3, zzvq2, str4), zzaoz, bundle);
                } catch (Throwable th) {
                    zzbao.zzc("", th);
                    throw new RemoteException();
                }
            } else if (obj2 instanceof Adapter) {
                try {
                    ((Adapter) obj2).loadNativeAd(new MediationNativeAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), "", zza(str3, zzvq2, str4), zzd(zzvq2), zzc(zzvq), zzvq2.zzng, zzvq2.zzadv, zzvq2.zzadw, zza(str3, zzvq2), this.zzdpg, zzaei), new zzaoq(this, zzant2));
                } catch (Throwable th2) {
                    zzbao.zzc("", th2);
                    throw new RemoteException();
                }
            }
        } else {
            String canonicalName = MediationNativeAdapter.class.getCanonicalName();
            String canonicalName2 = Adapter.class.getCanonicalName();
            String canonicalName3 = this.zzdoy.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 26 + String.valueOf(canonicalName2).length() + String.valueOf(canonicalName3).length());
            sb.append(canonicalName);
            sb.append(" or ");
            sb.append(canonicalName2);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName3);
            zzbao.zzez(sb.toString());
            throw new RemoteException();
        }
    }

    public final Bundle zzvi() {
        return new Bundle();
    }

    public final zzaob zzvf() {
        zzaov zzaov = this.zzdoz;
        if (zzaov == null) {
            return null;
        }
        NativeAdMapper zzvt = zzaov.zzvt();
        if (zzvt instanceof NativeAppInstallAdMapper) {
            return new zzaox((NativeAppInstallAdMapper) zzvt);
        }
        return null;
    }

    public final zzaoh zzvl() {
        UnifiedNativeAdMapper zzvu;
        Object obj = this.zzdoy;
        if (obj instanceof MediationNativeAdapter) {
            zzaov zzaov = this.zzdoz;
            if (zzaov == null || (zzvu = zzaov.zzvu()) == null) {
                return null;
            }
            return new zzapp(zzvu);
        } else if (!(obj instanceof Adapter) || this.zzdpd == null) {
            return null;
        } else {
            return new zzapp(this.zzdpd);
        }
    }

    public final zzaoc zzvg() {
        zzaov zzaov = this.zzdoz;
        if (zzaov == null) {
            return null;
        }
        NativeAdMapper zzvt = zzaov.zzvt();
        if (zzvt instanceof NativeContentAdMapper) {
            return new zzaow((NativeContentAdMapper) zzvt);
        }
        return null;
    }

    public final zzafo zzvk() {
        zzaov zzaov = this.zzdoz;
        if (zzaov == null) {
            return null;
        }
        NativeCustomTemplateAd zzvv = zzaov.zzvv();
        if (zzvv instanceof zzaft) {
            return ((zzaft) zzvv).zzub();
        }
        return null;
    }

    public final boolean zzvj() {
        return this.zzdoy instanceof InitializableMediationRewardedVideoAdAdapter;
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzvq zzvq, String str, zzavu zzavu, String str2) throws RemoteException {
        Bundle bundle;
        zzaok zzaok;
        Date date;
        zzvq zzvq2 = zzvq;
        zzavu zzavu2 = zzavu;
        String str3 = str2;
        Object obj = this.zzdoy;
        if (obj instanceof MediationRewardedVideoAdAdapter) {
            zzbao.zzdz("Initialize rewarded video adapter.");
            try {
                MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter = (MediationRewardedVideoAdAdapter) this.zzdoy;
                Bundle zza = zza(str3, zzvq2, (String) null);
                if (zzvq2 != null) {
                    HashSet hashSet = zzvq2.zzcic != null ? new HashSet(zzvq2.zzcic) : null;
                    if (zzvq2.zzcia == -1) {
                        date = null;
                    } else {
                        date = new Date(zzvq2.zzcia);
                    }
                    zzaok zzaok2 = new zzaok(date, zzvq2.zzcib, hashSet, zzvq2.zzng, zzc(zzvq), zzvq2.zzadv, zzvq2.zzcim, zzvq2.zzadw, zza(str3, zzvq2));
                    bundle = zzvq2.zzcih != null ? zzvq2.zzcih.getBundle(mediationRewardedVideoAdAdapter.getClass().getName()) : null;
                    zzaok = zzaok2;
                } else {
                    zzaok = null;
                    bundle = null;
                }
                mediationRewardedVideoAdAdapter.initialize((Context) ObjectWrapper.unwrap(iObjectWrapper), zzaok, str, new zzavz(zzavu2), zza, bundle);
            } catch (Throwable th) {
                zzbao.zzc("", th);
                throw new RemoteException();
            }
        } else if (obj instanceof Adapter) {
            this.zzdpb = iObjectWrapper;
            this.zzdpa = zzavu2;
            zzavu2.zzag(ObjectWrapper.wrap(obj));
        } else {
            String canonicalName = MediationRewardedVideoAdAdapter.class.getCanonicalName();
            String canonicalName2 = Adapter.class.getCanonicalName();
            String canonicalName3 = this.zzdoy.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 26 + String.valueOf(canonicalName2).length() + String.valueOf(canonicalName3).length());
            sb.append(canonicalName);
            sb.append(" or ");
            sb.append(canonicalName2);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName3);
            zzbao.zzez(sb.toString());
            throw new RemoteException();
        }
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzavu zzavu, List<String> list) throws RemoteException {
        if (this.zzdoy instanceof InitializableMediationRewardedVideoAdAdapter) {
            zzbao.zzdz("Initialize rewarded video adapter.");
            try {
                InitializableMediationRewardedVideoAdAdapter initializableMediationRewardedVideoAdAdapter = (InitializableMediationRewardedVideoAdAdapter) this.zzdoy;
                ArrayList arrayList = new ArrayList();
                for (String zza : list) {
                    arrayList.add(zza(zza, (zzvq) null, (String) null));
                }
                initializableMediationRewardedVideoAdAdapter.initialize((Context) ObjectWrapper.unwrap(iObjectWrapper), new zzavz(zzavu), arrayList);
            } catch (Throwable th) {
                zzbao.zzd("Could not initialize rewarded video adapter.", th);
                throw new RemoteException();
            }
        } else {
            String canonicalName = InitializableMediationRewardedVideoAdAdapter.class.getCanonicalName();
            String canonicalName2 = this.zzdoy.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
            sb.append(canonicalName);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName2);
            zzbao.zzez(sb.toString());
            throw new RemoteException();
        }
    }

    public final void zza(zzvq zzvq, String str) throws RemoteException {
        zza(zzvq, str, (String) null);
    }

    public final void zza(zzvq zzvq, String str, String str2) throws RemoteException {
        Date date;
        zzvq zzvq2 = zzvq;
        String str3 = str;
        Object obj = this.zzdoy;
        if (obj instanceof MediationRewardedVideoAdAdapter) {
            zzbao.zzdz("Requesting rewarded video ad from adapter.");
            try {
                MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter = (MediationRewardedVideoAdAdapter) this.zzdoy;
                Bundle bundle = null;
                HashSet hashSet = zzvq2.zzcic != null ? new HashSet(zzvq2.zzcic) : null;
                if (zzvq2.zzcia == -1) {
                    date = null;
                } else {
                    date = new Date(zzvq2.zzcia);
                }
                zzaok zzaok = new zzaok(date, zzvq2.zzcib, hashSet, zzvq2.zzng, zzc(zzvq), zzvq2.zzadv, zzvq2.zzcim, zzvq2.zzadw, zza(str3, zzvq2));
                if (zzvq2.zzcih != null) {
                    bundle = zzvq2.zzcih.getBundle(mediationRewardedVideoAdAdapter.getClass().getName());
                }
                mediationRewardedVideoAdAdapter.loadAd(zzaok, zza(str3, zzvq2, str2), bundle);
            } catch (Throwable th) {
                zzbao.zzc("", th);
                throw new RemoteException();
            }
        } else if (obj instanceof Adapter) {
            zzb(this.zzdpb, zzvq2, str3, new zzaou((Adapter) this.zzdoy, this.zzdpa));
        } else {
            String canonicalName = MediationRewardedVideoAdAdapter.class.getCanonicalName();
            String canonicalName2 = Adapter.class.getCanonicalName();
            String canonicalName3 = this.zzdoy.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 26 + String.valueOf(canonicalName2).length() + String.valueOf(canonicalName3).length());
            sb.append(canonicalName);
            sb.append(" or ");
            sb.append(canonicalName2);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName3);
            zzbao.zzez(sb.toString());
            throw new RemoteException();
        }
    }

    public final void showVideo() throws RemoteException {
        Object obj = this.zzdoy;
        if (obj instanceof MediationRewardedVideoAdAdapter) {
            zzbao.zzdz("Show rewarded video ad from adapter.");
            try {
                ((MediationRewardedVideoAdAdapter) this.zzdoy).showVideo();
            } catch (Throwable th) {
                zzbao.zzc("", th);
                throw new RemoteException();
            }
        } else if (obj instanceof Adapter) {
            MediationRewardedAd mediationRewardedAd = this.zzdpe;
            if (mediationRewardedAd != null) {
                mediationRewardedAd.showAd((Context) ObjectWrapper.unwrap(this.zzdpb));
            } else {
                zzbao.zzex("Can not show null mediated rewarded ad.");
                throw new RemoteException();
            }
        } else {
            String canonicalName = MediationRewardedVideoAdAdapter.class.getCanonicalName();
            String canonicalName2 = Adapter.class.getCanonicalName();
            String canonicalName3 = this.zzdoy.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 26 + String.valueOf(canonicalName2).length() + String.valueOf(canonicalName3).length());
            sb.append(canonicalName);
            sb.append(" or ");
            sb.append(canonicalName2);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName3);
            zzbao.zzez(sb.toString());
            throw new RemoteException();
        }
    }

    public final boolean isInitialized() throws RemoteException {
        Object obj = this.zzdoy;
        if (obj instanceof MediationRewardedVideoAdAdapter) {
            zzbao.zzdz("Check if adapter is initialized.");
            try {
                return ((MediationRewardedVideoAdAdapter) this.zzdoy).isInitialized();
            } catch (Throwable th) {
                zzbao.zzc("", th);
                throw new RemoteException();
            }
        } else if (obj instanceof Adapter) {
            return this.zzdpa != null;
        } else {
            String canonicalName = MediationRewardedVideoAdAdapter.class.getCanonicalName();
            String canonicalName2 = Adapter.class.getCanonicalName();
            String canonicalName3 = this.zzdoy.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 26 + String.valueOf(canonicalName2).length() + String.valueOf(canonicalName3).length());
            sb.append(canonicalName);
            sb.append(" or ");
            sb.append(canonicalName2);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName3);
            zzbao.zzez(sb.toString());
            throw new RemoteException();
        }
    }

    public final void zzb(IObjectWrapper iObjectWrapper, zzvq zzvq, String str, zzant zzant) throws RemoteException {
        zzvq zzvq2 = zzvq;
        String str2 = str;
        if (this.zzdoy instanceof Adapter) {
            zzbao.zzdz("Requesting rewarded ad from adapter.");
            try {
                MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> zza = zza(zzant);
                Bundle zza2 = zza(str2, zzvq2, (String) null);
                Bundle zzd = zzd(zzvq2);
                boolean zzc = zzc(zzvq);
                Location location = zzvq2.zzng;
                int i = zzvq2.zzadv;
                int i2 = zzvq2.zzadw;
                String zza3 = zza(str2, zzvq2);
                MediationRewardedAdConfiguration mediationRewardedAdConfiguration = r5;
                MediationRewardedAdConfiguration mediationRewardedAdConfiguration2 = new MediationRewardedAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), "", zza2, zzd, zzc, location, i, i2, zza3, "");
                ((Adapter) this.zzdoy).loadRewardedAd(mediationRewardedAdConfiguration, zza);
            } catch (Exception e) {
                zzbao.zzc("", e);
                throw new RemoteException();
            }
        } else {
            String canonicalName = Adapter.class.getCanonicalName();
            String canonicalName2 = this.zzdoy.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
            sb.append(canonicalName);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName2);
            zzbao.zzez(sb.toString());
            throw new RemoteException();
        }
    }

    public final void zzc(IObjectWrapper iObjectWrapper, zzvq zzvq, String str, zzant zzant) throws RemoteException {
        zzvq zzvq2 = zzvq;
        String str2 = str;
        if (this.zzdoy instanceof Adapter) {
            zzbao.zzdz("Requesting rewarded interstitial ad from adapter.");
            try {
                MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> zza = zza(zzant);
                Bundle zza2 = zza(str2, zzvq2, (String) null);
                Bundle zzd = zzd(zzvq2);
                boolean zzc = zzc(zzvq);
                Location location = zzvq2.zzng;
                int i = zzvq2.zzadv;
                int i2 = zzvq2.zzadw;
                String zza3 = zza(str2, zzvq2);
                MediationRewardedAdConfiguration mediationRewardedAdConfiguration = r5;
                MediationRewardedAdConfiguration mediationRewardedAdConfiguration2 = new MediationRewardedAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), "", zza2, zzd, zzc, location, i, i2, zza3, "");
                ((Adapter) this.zzdoy).loadRewardedInterstitialAd(mediationRewardedAdConfiguration, zza);
            } catch (Exception e) {
                zzbao.zzc("", e);
                throw new RemoteException();
            }
        } else {
            String canonicalName = Adapter.class.getCanonicalName();
            String canonicalName2 = this.zzdoy.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
            sb.append(canonicalName);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName2);
            zzbao.zzez(sb.toString());
            throw new RemoteException();
        }
    }

    public final void zzb(IObjectWrapper iObjectWrapper, zzvt zzvt, zzvq zzvq, String str, String str2, zzant zzant) throws RemoteException {
        zzvt zzvt2 = zzvt;
        zzvq zzvq2 = zzvq;
        String str3 = str;
        if (this.zzdoy instanceof Adapter) {
            zzbao.zzdz("Requesting interscroller ad from adapter.");
            try {
                Adapter adapter = (Adapter) this.zzdoy;
                zzaom zzaom = new zzaom(this, zzant, adapter);
                Bundle zza = zza(str3, zzvq2, str2);
                Bundle zzd = zzd(zzvq2);
                boolean zzc = zzc(zzvq);
                Location location = zzvq2.zzng;
                int i = zzvq2.zzadv;
                int i2 = zzvq2.zzadw;
                String zza2 = zza(str3, zzvq2);
                AdSize zzc2 = zza.zzc(zzvt2.width, zzvt2.height);
                MediationBannerAdConfiguration mediationBannerAdConfiguration = r6;
                MediationBannerAdConfiguration mediationBannerAdConfiguration2 = new MediationBannerAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), "", zza, zzd, zzc, location, i, i2, zza2, zzc2, "");
                adapter.loadInterscrollerAd(mediationBannerAdConfiguration, zzaom);
            } catch (Exception e) {
                zzbao.zzc("", e);
                throw new RemoteException();
            }
        } else {
            String canonicalName = Adapter.class.getCanonicalName();
            String canonicalName2 = this.zzdoy.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
            sb.append(canonicalName);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName2);
            zzbao.zzez(sb.toString());
            throw new RemoteException();
        }
    }

    public final zzanu zzvo() {
        if (this.zzdpf != null) {
            return new zzaos(this.zzdpf);
        }
        return null;
    }

    public final void zzt(IObjectWrapper iObjectWrapper) throws RemoteException {
        if (this.zzdoy instanceof Adapter) {
            zzbao.zzdz("Show rewarded ad from adapter.");
            MediationRewardedAd mediationRewardedAd = this.zzdpe;
            if (mediationRewardedAd != null) {
                mediationRewardedAd.showAd((Context) ObjectWrapper.unwrap(iObjectWrapper));
            } else {
                zzbao.zzex("Can not show null mediation rewarded ad.");
                throw new RemoteException();
            }
        } else {
            String canonicalName = Adapter.class.getCanonicalName();
            String canonicalName2 = this.zzdoy.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
            sb.append(canonicalName);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName2);
            zzbao.zzez(sb.toString());
            throw new RemoteException();
        }
    }

    public final void setImmersiveMode(boolean z) throws RemoteException {
        Object obj = this.zzdoy;
        if (!(obj instanceof OnImmersiveModeUpdatedListener)) {
            String canonicalName = OnImmersiveModeUpdatedListener.class.getCanonicalName();
            String canonicalName2 = this.zzdoy.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
            sb.append(canonicalName);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName2);
            zzbao.zzdz(sb.toString());
            return;
        }
        try {
            ((OnImmersiveModeUpdatedListener) obj).onImmersiveModeUpdated(z);
        } catch (Throwable th) {
            zzbao.zzc("", th);
        }
    }

    public final zzzd getVideoController() {
        Object obj = this.zzdoy;
        if (!(obj instanceof com.google.android.gms.ads.mediation.zza)) {
            return null;
        }
        try {
            return ((com.google.android.gms.ads.mediation.zza) obj).getVideoController();
        } catch (Throwable th) {
            zzbao.zzc("", th);
            return null;
        }
    }

    public final void zzu(IObjectWrapper iObjectWrapper) throws RemoteException {
        Object obj = this.zzdoy;
        if (!(obj instanceof Adapter) && !(obj instanceof MediationInterstitialAdapter)) {
            String canonicalName = MediationInterstitialAdapter.class.getCanonicalName();
            String canonicalName2 = Adapter.class.getCanonicalName();
            String canonicalName3 = this.zzdoy.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 26 + String.valueOf(canonicalName2).length() + String.valueOf(canonicalName3).length());
            sb.append(canonicalName);
            sb.append(" or ");
            sb.append(canonicalName2);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName3);
            zzbao.zzez(sb.toString());
            throw new RemoteException();
        } else if (this.zzdoy instanceof MediationInterstitialAdapter) {
            showInterstitial();
        } else {
            zzbao.zzdz("Show interstitial ad from adapter.");
            MediationInterstitialAd mediationInterstitialAd = this.zzdpc;
            if (mediationInterstitialAd != null) {
                mediationInterstitialAd.showAd((Context) ObjectWrapper.unwrap(iObjectWrapper));
            } else {
                zzbao.zzex("Can not show null mediation interstitial ad.");
                throw new RemoteException();
            }
        }
    }

    public final void showInterstitial() throws RemoteException {
        if (this.zzdoy instanceof MediationInterstitialAdapter) {
            zzbao.zzdz("Showing interstitial from adapter.");
            try {
                ((MediationInterstitialAdapter) this.zzdoy).showInterstitial();
            } catch (Throwable th) {
                zzbao.zzc("", th);
                throw new RemoteException();
            }
        } else {
            String canonicalName = MediationInterstitialAdapter.class.getCanonicalName();
            String canonicalName2 = this.zzdoy.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
            sb.append(canonicalName);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName2);
            zzbao.zzez(sb.toString());
            throw new RemoteException();
        }
    }

    public final void destroy() throws RemoteException {
        Object obj = this.zzdoy;
        if (obj instanceof MediationAdapter) {
            try {
                ((MediationAdapter) obj).onDestroy();
            } catch (Throwable th) {
                zzbao.zzc("", th);
                throw new RemoteException();
            }
        }
    }

    public final void pause() throws RemoteException {
        Object obj = this.zzdoy;
        if (obj instanceof MediationAdapter) {
            try {
                ((MediationAdapter) obj).onPause();
            } catch (Throwable th) {
                zzbao.zzc("", th);
                throw new RemoteException();
            }
        }
    }

    public final void resume() throws RemoteException {
        Object obj = this.zzdoy;
        if (obj instanceof MediationAdapter) {
            try {
                ((MediationAdapter) obj).onResume();
            } catch (Throwable th) {
                zzbao.zzc("", th);
                throw new RemoteException();
            }
        }
    }

    public final void zzs(IObjectWrapper iObjectWrapper) throws RemoteException {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        Object obj = this.zzdoy;
        if (obj instanceof OnContextChangedListener) {
            ((OnContextChangedListener) obj).onContextChanged(context);
        }
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzajo zzajo, List<zzajw> list) throws RemoteException {
        AdFormat adFormat;
        if (this.zzdoy instanceof Adapter) {
            zzaop zzaop = new zzaop(this, zzajo);
            ArrayList arrayList = new ArrayList();
            for (zzajw next : list) {
                String str = next.zzdke;
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
                } else if (c != 4) {
                    adFormat = null;
                } else {
                    adFormat = AdFormat.NATIVE;
                }
                if (adFormat != null) {
                    arrayList.add(new MediationConfiguration(adFormat, next.extras));
                }
            }
            ((Adapter) this.zzdoy).initialize((Context) ObjectWrapper.unwrap(iObjectWrapper), zzaop, arrayList);
            return;
        }
        throw new RemoteException();
    }

    public final zzaqr zzvm() {
        Object obj = this.zzdoy;
        if (!(obj instanceof Adapter)) {
            return null;
        }
        return zzaqr.zza(((Adapter) obj).getVersionInfo());
    }

    public final zzaqr zzvn() {
        Object obj = this.zzdoy;
        if (!(obj instanceof Adapter)) {
            return null;
        }
        return zzaqr.zza(((Adapter) obj).getSDKVersionInfo());
    }

    private final MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> zza(zzant zzant) {
        return new zzaot(this, zzant);
    }

    private final Bundle zza(String str, zzvq zzvq, String str2) throws RemoteException {
        String valueOf = String.valueOf(str);
        zzbao.zzdz(valueOf.length() != 0 ? "Server parameters: ".concat(valueOf) : new String("Server parameters: "));
        try {
            Bundle bundle = new Bundle();
            if (str != null) {
                JSONObject jSONObject = new JSONObject(str);
                Bundle bundle2 = new Bundle();
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    bundle2.putString(next, jSONObject.getString(next));
                }
                bundle = bundle2;
            }
            if (this.zzdoy instanceof AdMobAdapter) {
                bundle.putString("adJson", str2);
                if (zzvq != null) {
                    bundle.putInt("tagForChildDirectedTreatment", zzvq.zzadv);
                }
            }
            bundle.remove("max_ad_content_rating");
            return bundle;
        } catch (Throwable th) {
            zzbao.zzc("", th);
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
        if (zzvq.zzcih == null || (bundle = zzvq.zzcih.getBundle(this.zzdoy.getClass().getName())) == null) {
            return new Bundle();
        }
        return bundle;
    }
}
