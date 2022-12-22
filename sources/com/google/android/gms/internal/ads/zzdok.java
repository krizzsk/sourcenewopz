package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.reward.AdMetadataListener;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzdok extends AdMetadataListener {
    private final /* synthetic */ zzdoh zzhlt;
    private final /* synthetic */ zzyw zzhlu;

    zzdok(zzdoh zzdoh, zzyw zzyw) {
        this.zzhlt = zzdoh;
        this.zzhlu = zzyw;
    }

    public final void onAdMetadataChanged() {
        if (this.zzhlt.zzhls != null) {
            try {
                this.zzhlu.onAdMetadataChanged();
            } catch (RemoteException e) {
                zzd.zze("#007 Could not call remote method.", e);
            }
        }
    }
}
