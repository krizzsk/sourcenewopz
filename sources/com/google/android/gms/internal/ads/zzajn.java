package com.google.android.gms.internal.ads;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzajn implements BaseGmsClient.BaseOnConnectionFailedListener {
    private final /* synthetic */ zzbbe zzbwi;

    zzajn(zzajg zzajg, zzbbe zzbbe) {
        this.zzbwi = zzbbe;
    }

    public final void onConnectionFailed(ConnectionResult connectionResult) {
        this.zzbwi.setException(new RuntimeException("Connection failed."));
    }
}
