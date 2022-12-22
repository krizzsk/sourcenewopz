package com.google.android.gms.internal.ads;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzte implements BaseGmsClient.BaseOnConnectionFailedListener {
    private final /* synthetic */ zzta zzbvr;

    zzte(zzta zzta) {
        this.zzbvr = zzta;
    }

    public final void onConnectionFailed(ConnectionResult connectionResult) {
        synchronized (this.zzbvr.lock) {
            zztn unused = this.zzbvr.zzbvn = null;
            if (this.zzbvr.zzbvm != null) {
                zztj unused2 = this.zzbvr.zzbvm = null;
            }
            this.zzbvr.lock.notifyAll();
        }
    }
}
