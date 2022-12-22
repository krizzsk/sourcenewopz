package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.DeadObjectException;
import com.google.android.gms.common.internal.BaseGmsClient;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzajk implements BaseGmsClient.BaseConnectionCallbacks {
    private final /* synthetic */ zzbbe zzbwi;
    private final /* synthetic */ zzajg zzdjz;

    zzajk(zzajg zzajg, zzbbe zzbbe) {
        this.zzdjz = zzajg;
        this.zzbwi = zzbbe;
    }

    public final void onConnected(Bundle bundle) {
        try {
            this.zzbwi.set(this.zzdjz.zzdjx.zzun());
        } catch (DeadObjectException e) {
            this.zzbwi.setException(e);
        }
    }

    public final void onConnectionSuspended(int i) {
        zzbbe zzbbe = this.zzbwi;
        StringBuilder sb = new StringBuilder(34);
        sb.append("onConnectionSuspended: ");
        sb.append(i);
        zzbbe.setException(new RuntimeException(sb.toString()));
    }
}
