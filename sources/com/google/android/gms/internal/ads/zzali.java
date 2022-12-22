package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzj;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final /* synthetic */ class zzali implements zzaku {
    private final zzale zzdkv;
    private final zzalz zzdky;
    private final zzakv zzdkz;

    zzali(zzale zzale, zzalz zzalz, zzakv zzakv) {
        this.zzdkv = zzale;
        this.zzdky = zzalz;
        this.zzdkz = zzakv;
    }

    public final void zzut() {
        zzj.zzegq.postDelayed(new zzall(this.zzdkv, this.zzdky, this.zzdkz), (long) zzalt.zzdlj);
    }
}
