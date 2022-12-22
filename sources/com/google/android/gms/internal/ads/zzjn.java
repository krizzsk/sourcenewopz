package com.google.android.gms.internal.ads;

import android.media.MediaCodec;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzjn {
    private final MediaCodec.CryptoInfo zzaoi;
    private final MediaCodec.CryptoInfo.Pattern zzaor;

    private zzjn(MediaCodec.CryptoInfo cryptoInfo) {
        this.zzaoi = cryptoInfo;
        this.zzaor = new MediaCodec.CryptoInfo.Pattern(0, 0);
    }

    /* access modifiers changed from: private */
    public final void set(int i, int i2) {
        this.zzaor.set(0, 0);
        this.zzaoi.setPattern(this.zzaor);
    }
}
