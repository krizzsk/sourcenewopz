package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.doubleclick.OnCustomRenderedAdLoadedListener;
import com.google.android.gms.ads.doubleclick.PublisherInterstitialAd;
import com.google.android.gms.ads.reward.AdMetadataListener;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public final class zzzp {
    private final Context context;
    private final zzvr zzacy;
    private AppEventListener zzboo;
    private String zzbvf;
    private OnPaidEventListener zzbvk;
    private zzxq zzbvo;
    private final zzank zzbvq;
    private zzve zzchr;
    private AdListener zzchw;
    private AdMetadataListener zzchz;
    private OnCustomRenderedAdLoadedListener zzckv;
    private RewardedVideoAdListener zzclc;
    private boolean zzcld;
    private Boolean zzcle;

    public zzzp(Context context2) {
        this(context2, zzvr.zzciq, (PublisherInterstitialAd) null);
    }

    public zzzp(Context context2, PublisherInterstitialAd publisherInterstitialAd) {
        this(context2, zzvr.zzciq, publisherInterstitialAd);
    }

    private zzzp(Context context2, zzvr zzvr, PublisherInterstitialAd publisherInterstitialAd) {
        this.zzbvq = new zzank();
        this.context = context2;
        this.zzacy = zzvr;
    }

    public final AdListener getAdListener() {
        return this.zzchw;
    }

    public final String getAdUnitId() {
        return this.zzbvf;
    }

    public final AppEventListener getAppEventListener() {
        return this.zzboo;
    }

    public final OnCustomRenderedAdLoadedListener getOnCustomRenderedAdLoadedListener() {
        return this.zzckv;
    }

    public final boolean isLoaded() {
        try {
            if (this.zzbvo == null) {
                return false;
            }
            return this.zzbvo.isReady();
        } catch (RemoteException e) {
            zzbao.zze("#007 Could not call remote method.", e);
            return false;
        }
    }

    public final boolean isLoading() {
        try {
            if (this.zzbvo == null) {
                return false;
            }
            return this.zzbvo.isLoading();
        } catch (RemoteException e) {
            zzbao.zze("#007 Could not call remote method.", e);
            return false;
        }
    }

    public final void zza(zzzl zzzl) {
        try {
            if (this.zzbvo == null) {
                if (this.zzbvf == null) {
                    zzcn("loadAd");
                }
                zzxq zzb = zzww.zzqx().zzb(this.context, this.zzcld ? zzvt.zzql() : new zzvt(), this.zzbvf, this.zzbvq);
                this.zzbvo = zzb;
                if (this.zzchw != null) {
                    zzb.zza((zzxc) new zzvj(this.zzchw));
                }
                if (this.zzchr != null) {
                    this.zzbvo.zza((zzwx) new zzvg(this.zzchr));
                }
                if (this.zzchz != null) {
                    this.zzbvo.zza((zzxt) new zzvn(this.zzchz));
                }
                if (this.zzboo != null) {
                    this.zzbvo.zza((zzxy) new zzvz(this.zzboo));
                }
                if (this.zzckv != null) {
                    this.zzbvo.zza((zzacm) new zzacr(this.zzckv));
                }
                if (this.zzclc != null) {
                    this.zzbvo.zza((zzavn) new zzavq(this.zzclc));
                }
                this.zzbvo.zza((zzyx) new zzaaq(this.zzbvk));
                if (this.zzcle != null) {
                    this.zzbvo.setImmersiveMode(this.zzcle.booleanValue());
                }
            }
            if (this.zzbvo.zza(zzvr.zza(this.context, zzzl))) {
                this.zzbvq.zzf(zzzl.zzrq());
            }
        } catch (RemoteException e) {
            zzbao.zze("#007 Could not call remote method.", e);
        }
    }

    public final void setAdListener(AdListener adListener) {
        try {
            this.zzchw = adListener;
            if (this.zzbvo != null) {
                this.zzbvo.zza((zzxc) adListener != null ? new zzvj(adListener) : null);
            }
        } catch (RemoteException e) {
            zzbao.zze("#007 Could not call remote method.", e);
        }
    }

    public final void zza(zzve zzve) {
        try {
            this.zzchr = zzve;
            if (this.zzbvo != null) {
                this.zzbvo.zza((zzwx) zzve != null ? new zzvg(zzve) : null);
            }
        } catch (RemoteException e) {
            zzbao.zze("#007 Could not call remote method.", e);
        }
    }

    public final void setAdUnitId(String str) {
        if (this.zzbvf == null) {
            this.zzbvf = str;
            return;
        }
        throw new IllegalStateException("The ad unit ID can only be set once on InterstitialAd.");
    }

    public final void setAdMetadataListener(AdMetadataListener adMetadataListener) {
        try {
            this.zzchz = adMetadataListener;
            if (this.zzbvo != null) {
                this.zzbvo.zza((zzxt) adMetadataListener != null ? new zzvn(adMetadataListener) : null);
            }
        } catch (RemoteException e) {
            zzbao.zze("#007 Could not call remote method.", e);
        }
    }

    public final Bundle getAdMetadata() {
        try {
            if (this.zzbvo != null) {
                return this.zzbvo.getAdMetadata();
            }
        } catch (RemoteException e) {
            zzbao.zze("#007 Could not call remote method.", e);
        }
        return new Bundle();
    }

    public final void setAppEventListener(AppEventListener appEventListener) {
        try {
            this.zzboo = appEventListener;
            if (this.zzbvo != null) {
                this.zzbvo.zza((zzxy) appEventListener != null ? new zzvz(appEventListener) : null);
            }
        } catch (RemoteException e) {
            zzbao.zze("#007 Could not call remote method.", e);
        }
    }

    public final void setOnCustomRenderedAdLoadedListener(OnCustomRenderedAdLoadedListener onCustomRenderedAdLoadedListener) {
        try {
            this.zzckv = onCustomRenderedAdLoadedListener;
            if (this.zzbvo != null) {
                this.zzbvo.zza((zzacm) onCustomRenderedAdLoadedListener != null ? new zzacr(onCustomRenderedAdLoadedListener) : null);
            }
        } catch (RemoteException e) {
            zzbao.zze("#007 Could not call remote method.", e);
        }
    }

    public final void setRewardedVideoAdListener(RewardedVideoAdListener rewardedVideoAdListener) {
        try {
            this.zzclc = rewardedVideoAdListener;
            if (this.zzbvo != null) {
                this.zzbvo.zza((zzavn) rewardedVideoAdListener != null ? new zzavq(rewardedVideoAdListener) : null);
            }
        } catch (RemoteException e) {
            zzbao.zze("#007 Could not call remote method.", e);
        }
    }

    public final void zze(boolean z) {
        this.zzcld = true;
    }

    public final String getMediationAdapterClassName() {
        try {
            if (this.zzbvo != null) {
                return this.zzbvo.zzkl();
            }
            return null;
        } catch (RemoteException e) {
            zzbao.zze("#007 Could not call remote method.", e);
            return null;
        }
    }

    public final ResponseInfo getResponseInfo() {
        zzzc zzzc = null;
        try {
            if (this.zzbvo != null) {
                zzzc = this.zzbvo.zzkm();
            }
        } catch (RemoteException e) {
            zzbao.zze("#007 Could not call remote method.", e);
        }
        return ResponseInfo.zza(zzzc);
    }

    public final void show() {
        try {
            zzcn("show");
            this.zzbvo.showInterstitial();
        } catch (RemoteException e) {
            zzbao.zze("#007 Could not call remote method.", e);
        }
    }

    public final void setImmersiveMode(boolean z) {
        try {
            this.zzcle = Boolean.valueOf(z);
            if (this.zzbvo != null) {
                this.zzbvo.setImmersiveMode(z);
            }
        } catch (RemoteException e) {
            zzbao.zze("#007 Could not call remote method.", e);
        }
    }

    public final void setOnPaidEventListener(OnPaidEventListener onPaidEventListener) {
        try {
            this.zzbvk = onPaidEventListener;
            if (this.zzbvo != null) {
                this.zzbvo.zza((zzyx) new zzaaq(onPaidEventListener));
            }
        } catch (RemoteException e) {
            zzbao.zze("#007 Could not call remote method.", e);
        }
    }

    private final void zzcn(String str) {
        if (this.zzbvo == null) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 63);
            sb.append("The ad unit ID must be set on InterstitialAd before ");
            sb.append(str);
            sb.append(" is called.");
            throw new IllegalStateException(sb.toString());
        }
    }
}
