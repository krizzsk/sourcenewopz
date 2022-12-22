package com.google.android.gms.internal.ads;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zztu implements BaseGmsClient.BaseOnConnectionFailedListener {
    private final /* synthetic */ zzbbe zzbwi;
    private final /* synthetic */ zzto zzbwj;

    zztu(zzto zzto, zzbbe zzbbe) {
        this.zzbwj = zzto;
        this.zzbwi = zzbbe;
    }

    public final void onConnectionFailed(ConnectionResult connectionResult) {
        synchronized (this.zzbwj.lock) {
            this.zzbwi.setException(new RuntimeException("Connection failed."));
        }
    }
}
