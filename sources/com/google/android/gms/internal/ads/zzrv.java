package com.google.android.gms.internal.ads;

import android.webkit.ValueCallback;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzrv implements ValueCallback<String> {
    private final /* synthetic */ zzrs zzbul;

    zzrv(zzrs zzrs) {
        this.zzbul = zzrs;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        this.zzbul.zzbuh.zza(this.zzbul.zzbue, this.zzbul.zzbuf, (String) obj, this.zzbul.zzbug);
    }
}
