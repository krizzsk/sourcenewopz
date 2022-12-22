package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzamv implements zzbbg {
    private final /* synthetic */ zzbbe zzdjs;
    private final /* synthetic */ zzalv zzdmf;

    zzamv(zzamt zzamt, zzbbe zzbbe, zzalv zzalv) {
        this.zzdjs = zzbbe;
        this.zzdmf = zzalv;
    }

    public final void run() {
        this.zzdjs.setException(new zzamh("Unable to obtain a JavascriptEngine."));
        this.zzdmf.release();
    }
}
