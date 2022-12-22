package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcjt implements zzbtp {
    private final zzbfi zzdkm;

    zzcjt(zzbfi zzbfi) {
        this.zzdkm = !((Boolean) zzww.zzra().zzd(zzabq.zzcpt)).booleanValue() ? null : zzbfi;
    }

    public final void zzce(Context context) {
        zzbfi zzbfi = this.zzdkm;
        if (zzbfi != null) {
            zzbfi.onPause();
        }
    }

    public final void zzcf(Context context) {
        zzbfi zzbfi = this.zzdkm;
        if (zzbfi != null) {
            zzbfi.onResume();
        }
    }

    public final void zzcg(Context context) {
        zzbfi zzbfi = this.zzdkm;
        if (zzbfi != null) {
            zzbfi.destroy();
        }
    }
}
