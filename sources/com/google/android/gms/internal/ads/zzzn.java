package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.ads.admanager.AppEventListener;
import com.google.android.gms.ads.doubleclick.OnCustomRenderedAdLoadedListener;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public final class zzzn {
    private final zzvr zzacy;
    private boolean zzbns;
    private VideoOptions zzbog;
    private AppEventListener zzbtf;
    private String zzbvf;
    private OnPaidEventListener zzbvk;
    private zzxq zzbvo;
    private final zzank zzbvq;
    private zzve zzchr;
    private AdListener zzchw;
    private AdSize[] zzcjm;
    private final AtomicBoolean zzckr;
    /* access modifiers changed from: private */
    public final VideoController zzcks;
    private final zzwv zzckt;
    private com.google.android.gms.ads.doubleclick.AppEventListener zzcku;
    private OnCustomRenderedAdLoadedListener zzckv;
    private ViewGroup zzckw;
    private int zzckx;

    private static boolean zzcz(int i) {
        return i == 1;
    }

    public zzzn(ViewGroup viewGroup) {
        this(viewGroup, (AttributeSet) null, false, zzvr.zzciq, 0);
    }

    public zzzn(ViewGroup viewGroup, int i) {
        this(viewGroup, (AttributeSet) null, false, zzvr.zzciq, i);
    }

    public zzzn(ViewGroup viewGroup, AttributeSet attributeSet, boolean z) {
        this(viewGroup, attributeSet, z, zzvr.zzciq, 0);
    }

    public zzzn(ViewGroup viewGroup, AttributeSet attributeSet, boolean z, int i) {
        this(viewGroup, attributeSet, false, zzvr.zzciq, i);
    }

    private zzzn(ViewGroup viewGroup, AttributeSet attributeSet, boolean z, zzvr zzvr, zzxq zzxq, int i) {
        zzvt zzvt;
        this.zzbvq = new zzank();
        this.zzcks = new VideoController();
        this.zzckt = new zzzq(this);
        this.zzckw = viewGroup;
        this.zzacy = zzvr;
        this.zzbvo = null;
        this.zzckr = new AtomicBoolean(false);
        this.zzckx = i;
        if (attributeSet != null) {
            Context context = viewGroup.getContext();
            try {
                zzwe zzwe = new zzwe(context, attributeSet);
                this.zzcjm = zzwe.zzz(z);
                this.zzbvf = zzwe.getAdUnitId();
                if (viewGroup.isInEditMode()) {
                    zzbae zzqw = zzww.zzqw();
                    AdSize adSize = this.zzcjm[0];
                    int i2 = this.zzckx;
                    if (adSize.equals(AdSize.INVALID)) {
                        zzvt = zzvt.zzqn();
                    } else {
                        zzvt zzvt2 = new zzvt(context, adSize);
                        zzvt2.zzciu = zzcz(i2);
                        zzvt = zzvt2;
                    }
                    zzqw.zza(viewGroup, zzvt, "Ads by Google");
                }
            } catch (IllegalArgumentException e) {
                zzww.zzqw().zza(viewGroup, new zzvt(context, AdSize.BANNER), e.getMessage(), e.getMessage());
            }
        }
    }

    private zzzn(ViewGroup viewGroup, AttributeSet attributeSet, boolean z, zzvr zzvr, int i) {
        this(viewGroup, attributeSet, z, zzvr, (zzxq) null, i);
    }

    public final void destroy() {
        try {
            if (this.zzbvo != null) {
                this.zzbvo.destroy();
            }
        } catch (RemoteException e) {
            zzbao.zze("#007 Could not call remote method.", e);
        }
    }

    public final AdListener getAdListener() {
        return this.zzchw;
    }

    public final AdSize getAdSize() {
        zzvt zzkk;
        try {
            if (!(this.zzbvo == null || (zzkk = this.zzbvo.zzkk()) == null)) {
                return zzkk.zzqo();
            }
        } catch (RemoteException e) {
            zzbao.zze("#007 Could not call remote method.", e);
        }
        AdSize[] adSizeArr = this.zzcjm;
        if (adSizeArr != null) {
            return adSizeArr[0];
        }
        return null;
    }

    public final AdSize[] getAdSizes() {
        return this.zzcjm;
    }

    public final String getAdUnitId() {
        zzxq zzxq;
        if (this.zzbvf == null && (zzxq = this.zzbvo) != null) {
            try {
                this.zzbvf = zzxq.getAdUnitId();
            } catch (RemoteException e) {
                zzbao.zze("#007 Could not call remote method.", e);
            }
        }
        return this.zzbvf;
    }

    public final com.google.android.gms.ads.doubleclick.AppEventListener zzrx() {
        return this.zzcku;
    }

    public final AppEventListener getAppEventListener() {
        return this.zzbtf;
    }

    public final OnCustomRenderedAdLoadedListener getOnCustomRenderedAdLoadedListener() {
        return this.zzckv;
    }

    public final void zza(zzzl zzzl) {
        zzxq zzxq;
        try {
            if (this.zzbvo == null) {
                if ((this.zzcjm == null || this.zzbvf == null) && this.zzbvo == null) {
                    throw new IllegalStateException("The ad size and ad unit ID must be set before loadAd is called.");
                }
                Context context = this.zzckw.getContext();
                zzvt zza = zza(context, this.zzcjm, this.zzckx);
                if ("search_v2".equals(zza.zzadd)) {
                    zzxq = (zzxq) new zzwo(zzww.zzqx(), context, zza, this.zzbvf).zzd(context, false);
                } else {
                    zzxq = (zzxq) new zzwg(zzww.zzqx(), context, zza, this.zzbvf, this.zzbvq).zzd(context, false);
                }
                this.zzbvo = zzxq;
                zzxq.zza((zzxc) new zzvj(this.zzckt));
                if (this.zzchr != null) {
                    this.zzbvo.zza((zzwx) new zzvg(this.zzchr));
                }
                if (this.zzbtf != null) {
                    this.zzbvo.zza((zzxy) new zzrl(this.zzbtf));
                }
                if (this.zzcku != null) {
                    this.zzbvo.zza((zzxy) new zzvz(this.zzcku));
                }
                if (this.zzckv != null) {
                    this.zzbvo.zza((zzacm) new zzacr(this.zzckv));
                }
                if (this.zzbog != null) {
                    this.zzbvo.zza(new zzaaz(this.zzbog));
                }
                this.zzbvo.zza((zzyx) new zzaaq(this.zzbvk));
                this.zzbvo.setManualImpressionsEnabled(this.zzbns);
                try {
                    IObjectWrapper zzki = this.zzbvo.zzki();
                    if (zzki != null) {
                        this.zzckw.addView((View) ObjectWrapper.unwrap(zzki));
                    }
                } catch (RemoteException e) {
                    zzbao.zze("#007 Could not call remote method.", e);
                }
            }
            if (this.zzbvo.zza(zzvr.zza(this.zzckw.getContext(), zzzl))) {
                this.zzbvq.zzf(zzzl.zzrq());
            }
        } catch (RemoteException e2) {
            zzbao.zze("#007 Could not call remote method.", e2);
        }
    }

    public final void pause() {
        try {
            if (this.zzbvo != null) {
                this.zzbvo.pause();
            }
        } catch (RemoteException e) {
            zzbao.zze("#007 Could not call remote method.", e);
        }
    }

    public final void recordManualImpression() {
        if (!this.zzckr.getAndSet(true)) {
            try {
                if (this.zzbvo != null) {
                    this.zzbvo.zzkj();
                }
            } catch (RemoteException e) {
                zzbao.zze("#007 Could not call remote method.", e);
            }
        }
    }

    public final void resume() {
        try {
            if (this.zzbvo != null) {
                this.zzbvo.resume();
            }
        } catch (RemoteException e) {
            zzbao.zze("#007 Could not call remote method.", e);
        }
    }

    public final void setAdListener(AdListener adListener) {
        this.zzchw = adListener;
        this.zzckt.zza(adListener);
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

    public final void setAdSizes(AdSize... adSizeArr) {
        if (this.zzcjm == null) {
            zza(adSizeArr);
            return;
        }
        throw new IllegalStateException("The ad size can only be set once on AdView.");
    }

    public final void zza(AdSize... adSizeArr) {
        this.zzcjm = adSizeArr;
        try {
            if (this.zzbvo != null) {
                this.zzbvo.zza(zza(this.zzckw.getContext(), this.zzcjm, this.zzckx));
            }
        } catch (RemoteException e) {
            zzbao.zze("#007 Could not call remote method.", e);
        }
        this.zzckw.requestLayout();
    }

    public final void setAdUnitId(String str) {
        if (this.zzbvf == null) {
            this.zzbvf = str;
            return;
        }
        throw new IllegalStateException("The ad unit ID can only be set once on AdView.");
    }

    public final void setAppEventListener(AppEventListener appEventListener) {
        try {
            this.zzbtf = appEventListener;
            if (this.zzbvo != null) {
                this.zzbvo.zza((zzxy) appEventListener != null ? new zzrl(appEventListener) : null);
            }
        } catch (RemoteException e) {
            zzbao.zze("#007 Could not call remote method.", e);
        }
    }

    public final void zza(com.google.android.gms.ads.doubleclick.AppEventListener appEventListener) {
        try {
            this.zzcku = appEventListener;
            if (this.zzbvo != null) {
                this.zzbvo.zza((zzxy) appEventListener != null ? new zzvz(this.zzcku) : null);
            }
        } catch (RemoteException e) {
            zzbao.zze("#007 Could not call remote method.", e);
        }
    }

    public final void setOnCustomRenderedAdLoadedListener(OnCustomRenderedAdLoadedListener onCustomRenderedAdLoadedListener) {
        this.zzckv = onCustomRenderedAdLoadedListener;
        try {
            if (this.zzbvo != null) {
                this.zzbvo.zza((zzacm) onCustomRenderedAdLoadedListener != null ? new zzacr(onCustomRenderedAdLoadedListener) : null);
            }
        } catch (RemoteException e) {
            zzbao.zze("#007 Could not call remote method.", e);
        }
    }

    public final void setManualImpressionsEnabled(boolean z) {
        this.zzbns = z;
        try {
            if (this.zzbvo != null) {
                this.zzbvo.setManualImpressionsEnabled(z);
            }
        } catch (RemoteException e) {
            zzbao.zze("#007 Could not call remote method.", e);
        }
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

    public final boolean isLoading() {
        try {
            if (this.zzbvo != null) {
                return this.zzbvo.isLoading();
            }
            return false;
        } catch (RemoteException e) {
            zzbao.zze("#007 Could not call remote method.", e);
            return false;
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

    public final void setOnPaidEventListener(OnPaidEventListener onPaidEventListener) {
        try {
            this.zzbvk = onPaidEventListener;
            if (this.zzbvo != null) {
                this.zzbvo.zza((zzyx) new zzaaq(onPaidEventListener));
            }
        } catch (RemoteException e) {
            zzbao.zze("#008 Must be called on the main UI thread.", e);
        }
    }

    public final VideoController getVideoController() {
        return this.zzcks;
    }

    public final zzzd zzdz() {
        zzxq zzxq = this.zzbvo;
        if (zzxq == null) {
            return null;
        }
        try {
            return zzxq.getVideoController();
        } catch (RemoteException e) {
            zzbao.zze("#007 Could not call remote method.", e);
            return null;
        }
    }

    public final void setVideoOptions(VideoOptions videoOptions) {
        zzaaz zzaaz;
        this.zzbog = videoOptions;
        try {
            if (this.zzbvo != null) {
                zzxq zzxq = this.zzbvo;
                if (videoOptions == null) {
                    zzaaz = null;
                } else {
                    zzaaz = new zzaaz(videoOptions);
                }
                zzxq.zza(zzaaz);
            }
        } catch (RemoteException e) {
            zzbao.zze("#007 Could not call remote method.", e);
        }
    }

    public final VideoOptions getVideoOptions() {
        return this.zzbog;
    }

    public final boolean zza(zzxq zzxq) {
        if (zzxq == null) {
            return false;
        }
        try {
            IObjectWrapper zzki = zzxq.zzki();
            if (zzki == null || ((View) ObjectWrapper.unwrap(zzki)).getParent() != null) {
                return false;
            }
            this.zzckw.addView((View) ObjectWrapper.unwrap(zzki));
            this.zzbvo = zzxq;
            return true;
        } catch (RemoteException e) {
            zzbao.zze("#007 Could not call remote method.", e);
            return false;
        }
    }

    private static zzvt zza(Context context, AdSize[] adSizeArr, int i) {
        for (AdSize equals : adSizeArr) {
            if (equals.equals(AdSize.INVALID)) {
                return zzvt.zzqn();
            }
        }
        zzvt zzvt = new zzvt(context, adSizeArr);
        zzvt.zzciu = zzcz(i);
        return zzvt;
    }
}
