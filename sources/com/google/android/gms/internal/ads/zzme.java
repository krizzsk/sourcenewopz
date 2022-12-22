package com.google.android.gms.internal.ads;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzme implements zzmc {
    private final int zzbdp;
    private MediaCodecInfo[] zzbdq;

    public zzme(boolean z) {
        this.zzbdp = z ? 1 : 0;
    }

    public final boolean zzhp() {
        return true;
    }

    public final int getCodecCount() {
        zzhq();
        return this.zzbdq.length;
    }

    public final MediaCodecInfo getCodecInfoAt(int i) {
        zzhq();
        return this.zzbdq[i];
    }

    public final boolean zza(String str, MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("secure-playback");
    }

    private final void zzhq() {
        if (this.zzbdq == null) {
            this.zzbdq = new MediaCodecList(this.zzbdp).getCodecInfos();
        }
    }
}
