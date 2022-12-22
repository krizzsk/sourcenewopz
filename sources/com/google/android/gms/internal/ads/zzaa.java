package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzaa implements Runnable {
    private final /* synthetic */ String val$tag;
    private final /* synthetic */ long zzam;
    private final /* synthetic */ zzab zzan;

    zzaa(zzab zzab, String str, long j) {
        this.zzan = zzab;
        this.val$tag = str;
        this.zzam = j;
    }

    public final void run() {
        this.zzan.zzao.zza(this.val$tag, this.zzam);
        this.zzan.zzao.zzd(this.zzan.toString());
    }
}
