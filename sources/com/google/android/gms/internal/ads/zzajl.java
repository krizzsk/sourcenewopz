package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzajl implements Runnable {
    private final /* synthetic */ zzajg zzdjz;

    zzajl(zzajg zzajg) {
        this.zzdjz = zzajg;
    }

    public final void run() {
        this.zzdjz.disconnect();
    }
}
