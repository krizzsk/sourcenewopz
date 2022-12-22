package com.google.android.gms.internal.ads;

import android.os.Trace;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzpu {
    public static void beginSection(String str) {
        if (zzpt.SDK_INT >= 18) {
            Trace.beginSection(str);
        }
    }

    public static void endSection() {
        if (zzpt.SDK_INT >= 18) {
            Trace.endSection();
        }
    }
}
