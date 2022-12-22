package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.reward.AdMetadataListener;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzdop extends AdMetadataListener {
    private final /* synthetic */ zzxt zzhlv;
    private final /* synthetic */ zzdon zzhlw;

    zzdop(zzdon zzdon, zzxt zzxt) {
        this.zzhlw = zzdon;
        this.zzhlv = zzxt;
    }

    public final void onAdMetadataChanged() {
        if (this.zzhlw.zzhls != null) {
            try {
                this.zzhlv.onAdMetadataChanged();
            } catch (RemoteException e) {
                zzd.zze("#007 Could not call remote method.", e);
            }
        }
    }
}
