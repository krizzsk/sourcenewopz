package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzfg implements Runnable {
    private final /* synthetic */ zzfc zzzt;

    zzfg(zzfc zzfc) {
        this.zzzt = zzfc;
    }

    public final void run() {
        zzabq.initialize(this.zzzt.context);
    }
}
