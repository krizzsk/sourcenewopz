package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.zzd;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzdaj implements zzve {
    private zzwx zzhbg;

    public final synchronized void zzb(zzwx zzwx) {
        this.zzhbg = zzwx;
    }

    public final synchronized void onAdClicked() {
        if (this.zzhbg != null) {
            try {
                this.zzhbg.onAdClicked();
            } catch (RemoteException e) {
                zzd.zzd("Remote Exception at onAdClicked.", e);
            }
        }
    }
}
