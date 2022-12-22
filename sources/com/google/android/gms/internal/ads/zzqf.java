package com.google.android.gms.internal.ads;

import android.media.MediaCodec;
import android.os.Handler;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzqf implements MediaCodec.OnFrameRenderedListener {
    private final /* synthetic */ zzqe zzbmr;

    private zzqf(zzqe zzqe, MediaCodec mediaCodec) {
        this.zzbmr = zzqe;
        mediaCodec.setOnFrameRenderedListener(this, new Handler());
    }

    public final void onFrameRendered(MediaCodec mediaCodec, long j, long j2) {
        if (this == this.zzbmr.zzbmo) {
            this.zzbmr.zzjo();
        }
    }
}
