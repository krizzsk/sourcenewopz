package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.DeadObjectException;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.common.internal.BaseGmsClient;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zztf implements BaseGmsClient.BaseConnectionCallbacks {
    private final /* synthetic */ zzta zzbvr;

    zztf(zzta zzta) {
        this.zzbvr = zzta;
    }

    public final void onConnected(Bundle bundle) {
        synchronized (this.zzbvr.lock) {
            try {
                if (this.zzbvr.zzbvm != null) {
                    zztn unused = this.zzbvr.zzbvn = this.zzbvr.zzbvm.zznj();
                }
            } catch (DeadObjectException e) {
                zzd.zzc("Unable to obtain a cache service instance.", e);
                this.zzbvr.disconnect();
            }
            this.zzbvr.lock.notifyAll();
        }
    }

    public final void onConnectionSuspended(int i) {
        synchronized (this.zzbvr.lock) {
            zztn unused = this.zzbvr.zzbvn = null;
            this.zzbvr.lock.notifyAll();
        }
    }
}
