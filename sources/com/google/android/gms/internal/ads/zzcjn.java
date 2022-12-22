package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final /* synthetic */ class zzcjn implements zzbgt {
    private final zzbbe zzbwk;

    zzcjn(zzbbe zzbbe) {
        this.zzbwk = zzbbe;
    }

    public final void zzam(boolean z) {
        zzbbe zzbbe = this.zzbwk;
        if (z) {
            zzbbe.set(null);
        } else {
            zzbbe.setException(new Exception("Ad Web View failed to load."));
        }
    }
}
