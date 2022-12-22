package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zztr extends zzbbe<zztw> {
    private final /* synthetic */ zzto zzbwj;

    zztr(zzto zzto) {
        this.zzbwj = zzto;
    }

    public final boolean cancel(boolean z) {
        this.zzbwj.disconnect();
        return super.cancel(z);
    }
}
