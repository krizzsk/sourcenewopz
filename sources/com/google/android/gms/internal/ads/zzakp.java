package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.instream.InstreamAd;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public final class zzakp {
    private final Context context;
    private final zzxj zzacx;

    public zzakp(Context context2, String str) {
        this((Context) Preconditions.checkNotNull(context2, "context cannot be null"), zzww.zzqx().zzb(context2, str, new zzank()));
    }

    private zzakp(Context context2, zzxj zzxj) {
        this.context = context2;
        this.zzacx = zzxj;
    }

    public final zzakp zza(InstreamAd.InstreamAdLoadCallback instreamAdLoadCallback) {
        try {
            this.zzacx.zza((zzakg) new zzakn(instreamAdLoadCallback));
        } catch (RemoteException e) {
            zzbao.zze("#007 Could not call remote method.", e);
        }
        return this;
    }

    public final zzakp zza(zzakk zzakk) {
        try {
            this.zzacx.zza(new zzajy(zzakk));
        } catch (RemoteException e) {
            zzbao.zze("#007 Could not call remote method.", e);
        }
        return this;
    }

    public final zzakm zzus() {
        try {
            return new zzakm(this.context, this.zzacx.zzrf());
        } catch (RemoteException e) {
            zzbao.zze("#007 Could not call remote method.", e);
            return null;
        }
    }
}
