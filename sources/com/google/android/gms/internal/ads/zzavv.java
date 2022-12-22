package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest;
import com.google.android.gms.ads.reward.AdMetadataListener;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public final class zzavv implements RewardedVideoAd {
    private final Context context;
    private final Object lock = new Object();
    private final zzavg zzeap;
    private final zzavq zzeaq = new zzavq((RewardedVideoAdListener) null);
    private String zzear;
    private String zzeas;

    public zzavv(Context context2, zzavg zzavg) {
        this.zzeap = zzavg == null ? new zzaap() : zzavg;
        this.context = context2.getApplicationContext();
    }

    private final void zza(String str, zzzl zzzl) {
        synchronized (this.lock) {
            if (this.zzeap != null) {
                try {
                    this.zzeap.zza(zzvr.zza(this.context, zzzl, str));
                } catch (RemoteException e) {
                    zzbao.zze("#007 Could not call remote method.", e);
                }
            }
        }
    }

    public final void loadAd(String str, AdRequest adRequest) {
        zza(str, adRequest.zzdt());
    }

    public final void loadAd(String str, PublisherAdRequest publisherAdRequest) {
        zza(str, publisherAdRequest.zzdt());
    }

    public final void show() {
        synchronized (this.lock) {
            if (this.zzeap != null) {
                try {
                    this.zzeap.show();
                } catch (RemoteException e) {
                    zzbao.zze("#007 Could not call remote method.", e);
                }
            }
        }
    }

    public final void setRewardedVideoAdListener(RewardedVideoAdListener rewardedVideoAdListener) {
        synchronized (this.lock) {
            this.zzeaq.setRewardedVideoAdListener(rewardedVideoAdListener);
            if (this.zzeap != null) {
                try {
                    this.zzeap.zza((zzavn) this.zzeaq);
                } catch (RemoteException e) {
                    zzbao.zze("#007 Could not call remote method.", e);
                }
            }
        }
    }

    public final void setAdMetadataListener(AdMetadataListener adMetadataListener) {
        synchronized (this.lock) {
            if (this.zzeap != null) {
                try {
                    this.zzeap.zza((zzxt) new zzvn(adMetadataListener));
                } catch (RemoteException e) {
                    zzbao.zze("#007 Could not call remote method.", e);
                }
            }
        }
    }

    public final Bundle getAdMetadata() {
        synchronized (this.lock) {
            if (this.zzeap != null) {
                try {
                    Bundle adMetadata = this.zzeap.getAdMetadata();
                    return adMetadata;
                } catch (RemoteException e) {
                    zzbao.zze("#007 Could not call remote method.", e);
                }
            }
            Bundle bundle = new Bundle();
            return bundle;
        }
    }

    public final void setUserId(String str) {
        synchronized (this.lock) {
            this.zzear = str;
            if (this.zzeap != null) {
                try {
                    this.zzeap.setUserId(str);
                } catch (RemoteException e) {
                    zzbao.zze("#007 Could not call remote method.", e);
                }
            }
        }
    }

    public final boolean isLoaded() {
        synchronized (this.lock) {
            if (this.zzeap == null) {
                return false;
            }
            try {
                boolean isLoaded = this.zzeap.isLoaded();
                return isLoaded;
            } catch (RemoteException e) {
                zzbao.zze("#007 Could not call remote method.", e);
                return false;
            }
        }
    }

    public final void pause() {
        pause((Context) null);
    }

    public final void pause(Context context2) {
        synchronized (this.lock) {
            if (this.zzeap != null) {
                try {
                    this.zzeap.zzj(ObjectWrapper.wrap(context2));
                } catch (RemoteException e) {
                    zzbao.zze("#007 Could not call remote method.", e);
                }
            }
        }
    }

    public final void resume() {
        resume((Context) null);
    }

    public final void resume(Context context2) {
        synchronized (this.lock) {
            if (this.zzeap != null) {
                try {
                    this.zzeap.zzk(ObjectWrapper.wrap(context2));
                } catch (RemoteException e) {
                    zzbao.zze("#007 Could not call remote method.", e);
                }
            }
        }
    }

    public final void destroy() {
        destroy((Context) null);
    }

    public final void destroy(Context context2) {
        synchronized (this.lock) {
            this.zzeaq.setRewardedVideoAdListener((RewardedVideoAdListener) null);
            if (this.zzeap != null) {
                try {
                    this.zzeap.zzl(ObjectWrapper.wrap(context2));
                } catch (RemoteException e) {
                    zzbao.zze("#007 Could not call remote method.", e);
                }
            }
        }
    }

    public final RewardedVideoAdListener getRewardedVideoAdListener() {
        RewardedVideoAdListener rewardedVideoAdListener;
        synchronized (this.lock) {
            rewardedVideoAdListener = this.zzeaq.getRewardedVideoAdListener();
        }
        return rewardedVideoAdListener;
    }

    public final String getUserId() {
        String str;
        synchronized (this.lock) {
            str = this.zzear;
        }
        return str;
    }

    public final String getMediationAdapterClassName() {
        try {
            if (this.zzeap != null) {
                return this.zzeap.getMediationAdapterClassName();
            }
            return null;
        } catch (RemoteException e) {
            zzbao.zze("#007 Could not call remote method.", e);
            return null;
        }
    }

    public final void setImmersiveMode(boolean z) {
        synchronized (this.lock) {
            if (this.zzeap != null) {
                try {
                    this.zzeap.setImmersiveMode(z);
                } catch (RemoteException e) {
                    zzbao.zze("#007 Could not call remote method.", e);
                }
            }
        }
    }

    public final void setCustomData(String str) {
        synchronized (this.lock) {
            if (this.zzeap != null) {
                try {
                    this.zzeap.setCustomData(str);
                    this.zzeas = str;
                } catch (RemoteException e) {
                    zzbao.zze("#007 Could not call remote method.", e);
                }
            }
        }
    }

    public final String getCustomData() {
        String str;
        synchronized (this.lock) {
            str = this.zzeas;
        }
        return str;
    }

    public final ResponseInfo getResponseInfo() {
        zzzc zzzc = null;
        try {
            if (this.zzeap != null) {
                zzzc = this.zzeap.zzkm();
            }
        } catch (RemoteException e) {
            zzbao.zze("#007 Could not call remote method.", e);
        }
        return ResponseInfo.zza(zzzc);
    }
}
