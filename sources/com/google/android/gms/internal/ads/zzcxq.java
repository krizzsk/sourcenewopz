package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.overlay.zzl;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzcxq extends zzavx {
    private final /* synthetic */ zzbur zzgyt;
    private final /* synthetic */ zzbst zzgyu;
    private final /* synthetic */ zzbty zzgyv;
    private final /* synthetic */ zzbzv zzgyw;

    zzcxq(zzcxm zzcxm, zzbur zzbur, zzbst zzbst, zzbty zzbty, zzbzv zzbzv) {
        this.zzgyt = zzbur;
        this.zzgyu = zzbst;
        this.zzgyv = zzbty;
        this.zzgyw = zzbzv;
    }

    public final void zzag(IObjectWrapper iObjectWrapper) {
    }

    public final void zzah(IObjectWrapper iObjectWrapper) {
    }

    public final void zzb(Bundle bundle) {
    }

    public final void zzd(IObjectWrapper iObjectWrapper, int i) {
    }

    public final void zze(IObjectWrapper iObjectWrapper, int i) {
    }

    public final void zzai(IObjectWrapper iObjectWrapper) {
        this.zzgyt.zzvz();
    }

    public final void zzak(IObjectWrapper iObjectWrapper) {
        this.zzgyt.zza(zzl.OTHER);
    }

    public final void zzal(IObjectWrapper iObjectWrapper) {
        this.zzgyu.onAdClicked();
    }

    public final void zzam(IObjectWrapper iObjectWrapper) {
        this.zzgyv.onAdLeftApplication();
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzavy zzavy) {
        this.zzgyw.zza(zzavy);
    }

    public final void zzaj(IObjectWrapper iObjectWrapper) {
        this.zzgyw.zzul();
    }

    public final void zzan(IObjectWrapper iObjectWrapper) throws RemoteException {
        this.zzgyv.onRewardedVideoCompleted();
    }
}
