package com.google.android.gms.ads.internal.util;

import android.content.Context;
import com.google.android.gms.ads.internal.zzr;
import com.google.android.gms.internal.ads.zzbas;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbq extends zza {
    private final String url;
    private final zzbas zzeiw;

    public zzbq(Context context, String str, String str2) {
        this(str2, zzr.zzkv().zzq(context, str));
    }

    private zzbq(String str, String str2) {
        this.zzeiw = new zzbas(str2);
        this.url = str;
    }

    public final void zzwp() {
        this.zzeiw.zzen(this.url);
    }
}
