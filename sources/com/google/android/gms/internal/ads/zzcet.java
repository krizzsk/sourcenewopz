package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.zzd;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final /* synthetic */ class zzcet implements zzaig {
    private final zzceq zzgiu;
    private final zzagr zzgiv;

    zzcet(zzceq zzceq, zzagr zzagr) {
        this.zzgiu = zzceq;
        this.zzgiv = zzagr;
    }

    public final void zza(Object obj, Map map) {
        zzceq zzceq = this.zzgiu;
        zzagr zzagr = this.zzgiv;
        try {
            zzceq.zzgis = Long.valueOf(Long.parseLong((String) map.get("timestamp")));
        } catch (NumberFormatException unused) {
            zzd.zzex("Failed to call parse unconfirmedClickTimestamp.");
        }
        zzceq.zzgir = (String) map.get("id");
        String str = (String) map.get("asset_id");
        if (zzagr == null) {
            zzd.zzdz("Received unconfirmed click but UnconfirmedClickListener is null.");
            return;
        }
        try {
            zzagr.onUnconfirmedClickReceived(str);
        } catch (RemoteException e) {
            zzbao.zze("#007 Could not call remote method.", e);
        }
    }
}
