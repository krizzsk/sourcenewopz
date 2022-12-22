package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzr;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzbbc implements zzebi<Object> {
    private final /* synthetic */ String zzekn;

    zzbbc(String str) {
        this.zzekn = str;
    }

    public final void onSuccess(Object obj) {
    }

    public final void zzb(Throwable th) {
        zzr.zzkz().zzb(th, this.zzekn);
    }
}
