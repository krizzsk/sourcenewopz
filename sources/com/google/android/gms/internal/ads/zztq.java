package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.common.internal.BaseGmsClient;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zztq implements BaseGmsClient.BaseConnectionCallbacks {
    private final /* synthetic */ zzti zzbwh;
    private final /* synthetic */ zzbbe zzbwi;
    final /* synthetic */ zzto zzbwj;

    zztq(zzto zzto, zzti zzti, zzbbe zzbbe) {
        this.zzbwj = zzto;
        this.zzbwh = zzti;
        this.zzbwi = zzbbe;
    }

    public final void onConnectionSuspended(int i) {
    }

    public final void onConnected(Bundle bundle) {
        synchronized (this.zzbwj.lock) {
            if (!this.zzbwj.zzbwg) {
                boolean unused = this.zzbwj.zzbwg = true;
                zztj zzd = this.zzbwj.zzbvm;
                if (zzd != null) {
                    this.zzbwi.addListener(new zzts(this.zzbwi, zzbat.zzeke.zzg(new zztt(this, zzd, this.zzbwh, this.zzbwi))), zzbat.zzekj);
                }
            }
        }
    }
}
