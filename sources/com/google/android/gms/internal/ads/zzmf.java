package com.google.android.gms.internal.ads;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import p055case.C1273goto;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzmf implements zzmc {
    private zzmf() {
    }

    public final boolean zzhp() {
        return false;
    }

    public final int getCodecCount() {
        return MediaCodecList.getCodecCount();
    }

    public final MediaCodecInfo getCodecInfoAt(int i) {
        return MediaCodecList.getCodecInfoAt(i);
    }

    public final boolean zza(String str, MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return C1273goto.f468do.equals(str);
    }
}
