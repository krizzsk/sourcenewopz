package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzdbo implements zzebi<zzdcb> {
    private final /* synthetic */ zzazb zzhcr;
    private final /* synthetic */ zzdbf zzhcs;

    zzdbo(zzdbf zzdbf, zzazb zzazb) {
        this.zzhcs = zzdbf;
        this.zzhcr = zzazb;
    }

    public final void zzb(Throwable th) {
        try {
            zzazb zzazb = this.zzhcr;
            String valueOf = String.valueOf(th.getMessage());
            zzazb.onError(valueOf.length() != 0 ? "Internal error. ".concat(valueOf) : new String("Internal error. "));
        } catch (RemoteException e) {
            zzbao.zzc("", e);
        }
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        zzdcb zzdcb = (zzdcb) obj;
        try {
            if (((Boolean) zzww.zzra().zzd(zzabq.zzdaa)).booleanValue()) {
                if (this.zzhcs.zzbpj.zzekb >= ((Integer) zzww.zzra().zzd(zzabq.zzdac)).intValue()) {
                    if (zzdcb == null) {
                        this.zzhcr.zza((String) null, (String) null, (Bundle) null);
                        return;
                    } else {
                        this.zzhcr.zza(zzdcb.zzhda, zzdcb.zzhdb, zzdcb.zzhdc);
                        return;
                    }
                }
            }
            if (zzdcb == null) {
                this.zzhcr.zzj((String) null, (String) null);
            } else {
                this.zzhcr.zzj(zzdcb.zzhda, zzdcb.zzhdb);
            }
        } catch (RemoteException e) {
            zzbao.zzc("", e);
        }
    }
}
