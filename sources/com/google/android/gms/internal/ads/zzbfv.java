package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzbfv implements Runnable {
    private final /* synthetic */ zzbft zzeuo;

    zzbfv(zzbft zzbft) {
        this.zzeuo = zzbft;
    }

    public final void run() {
        this.zzeuo.zzeul.destroy();
    }
}
