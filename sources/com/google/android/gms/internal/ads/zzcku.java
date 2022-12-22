package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzub;
import com.google.android.gms.internal.ads.zzuh;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcku implements zzbsz, zzbtq, zzbuj, zzbvm, zzbxn, zzve {
    private final zztz zzgnj;
    private boolean zzgnk = false;

    public zzcku(zztz zztz, @Nullable zzdmp zzdmp) {
        this.zzgnj = zztz;
        zztz.zza(zzub.zza.zzb.AD_REQUEST);
        if (zzdmp != null) {
            zztz.zza(zzub.zza.zzb.REQUEST_IS_PREFETCH);
        }
    }

    public final void zzd(zzauj zzauj) {
    }

    public final void zzd(zzdpi zzdpi) {
        this.zzgnj.zza((zzty) new zzckx(zzdpi));
    }

    public final void onAdLoaded() {
        this.zzgnj.zza(zzub.zza.zzb.AD_LOADED);
    }

    public final void zzd(zzvh zzvh) {
        switch (zzvh.errorCode) {
            case 1:
                this.zzgnj.zza(zzub.zza.zzb.AD_FAILED_TO_LOAD_INVALID_REQUEST);
                return;
            case 2:
                this.zzgnj.zza(zzub.zza.zzb.AD_FAILED_TO_LOAD_NETWORK_ERROR);
                return;
            case 3:
                this.zzgnj.zza(zzub.zza.zzb.AD_FAILED_TO_LOAD_NO_FILL);
                return;
            case 4:
                this.zzgnj.zza(zzub.zza.zzb.AD_FAILED_TO_LOAD_TIMEOUT);
                return;
            case 5:
                this.zzgnj.zza(zzub.zza.zzb.AD_FAILED_TO_LOAD_CANCELLED);
                return;
            case 6:
                this.zzgnj.zza(zzub.zza.zzb.AD_FAILED_TO_LOAD_NO_ERROR);
                return;
            case 7:
                this.zzgnj.zza(zzub.zza.zzb.AD_FAILED_TO_LOAD_NOT_FOUND);
                return;
            default:
                this.zzgnj.zza(zzub.zza.zzb.AD_FAILED_TO_LOAD);
                return;
        }
    }

    public final synchronized void onAdImpression() {
        this.zzgnj.zza(zzub.zza.zzb.AD_IMPRESSION);
    }

    public final synchronized void onAdClicked() {
        if (!this.zzgnk) {
            this.zzgnj.zza(zzub.zza.zzb.AD_FIRST_CLICK);
            this.zzgnk = true;
            return;
        }
        this.zzgnj.zza(zzub.zza.zzb.AD_SUBSEQUENT_CLICK);
    }

    public final void zzc(zzuh.zzb zzb) {
        this.zzgnj.zza((zzty) new zzckw(zzb));
        this.zzgnj.zza(zzub.zza.zzb.REQUEST_LOADED_FROM_CACHE);
    }

    public final void zzd(zzuh.zzb zzb) {
        this.zzgnj.zza((zzty) new zzckz(zzb));
        this.zzgnj.zza(zzub.zza.zzb.REQUEST_SAVED_TO_CACHE);
    }

    public final void zze(zzuh.zzb zzb) {
        this.zzgnj.zza((zzty) new zzcky(zzb));
        this.zzgnj.zza(zzub.zza.zzb.REQUEST_PREFETCH_INTERCEPTED);
    }

    public final void zzbj(boolean z) {
        zzub.zza.zzb zzb;
        zztz zztz = this.zzgnj;
        if (z) {
            zzb = zzub.zza.zzb.REQUESTED_CACHE_KEY_FROM_SERVICE_SUCCEEDED;
        } else {
            zzb = zzub.zza.zzb.REQUESTED_CACHE_KEY_FROM_SERVICE_FAILED;
        }
        zztz.zza(zzb);
    }

    public final void zzbk(boolean z) {
        zzub.zza.zzb zzb;
        zztz zztz = this.zzgnj;
        if (z) {
            zzb = zzub.zza.zzb.NOTIFIED_CACHE_HIT_TO_SERVICE_SUCCEEDED;
        } else {
            zzb = zzub.zza.zzb.NOTIFIED_CACHE_HIT_TO_SERVICE_FAILED;
        }
        zztz.zza(zzb);
    }

    public final void zzamr() {
        this.zzgnj.zza(zzub.zza.zzb.REQUEST_FAILED_TO_LOAD_FROM_CACHE);
    }
}
