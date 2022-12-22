package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.appopen.AppOpenAd;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public final class zztb {
    private final Context context;
    private final int orientation;
    private final zzvr zzacy;
    private final zzzl zzadb;
    private final String zzbvf;
    private zzxq zzbvo;
    private final AppOpenAd.AppOpenAdLoadCallback zzbvp;
    private final zzank zzbvq = new zzank();

    public zztb(Context context2, String str, zzzl zzzl, int i, AppOpenAd.AppOpenAdLoadCallback appOpenAdLoadCallback) {
        this.context = context2;
        this.zzbvf = str;
        this.zzadb = zzzl;
        this.orientation = i;
        this.zzbvp = appOpenAdLoadCallback;
        this.zzacy = zzvr.zzciq;
    }

    public final void zznb() {
        try {
            this.zzbvo = zzww.zzqx().zza(this.context, zzvt.zzqm(), this.zzbvf, this.zzbvq);
            this.zzbvo.zza(new zzwc(this.orientation));
            this.zzbvo.zza((zzsq) new zzsl(this.zzbvp, this.zzbvf));
            this.zzbvo.zza(zzvr.zza(this.context, this.zzadb));
        } catch (RemoteException e) {
            zzbao.zze("#007 Could not call remote method.", e);
        }
    }
}
