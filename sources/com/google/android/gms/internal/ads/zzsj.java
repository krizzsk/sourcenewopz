package com.google.android.gms.internal.ads;

import java.util.Comparator;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzsj implements Comparator<zzrx> {
    public zzsj(zzsg zzsg) {
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        zzrx zzrx = (zzrx) obj;
        zzrx zzrx2 = (zzrx) obj2;
        if (zzrx.zzmv() < zzrx2.zzmv()) {
            return -1;
        }
        if (zzrx.zzmv() > zzrx2.zzmv()) {
            return 1;
        }
        if (zzrx.zzmu() < zzrx2.zzmu()) {
            return -1;
        }
        if (zzrx.zzmu() > zzrx2.zzmu()) {
            return 1;
        }
        float zzmx = (zzrx.zzmx() - zzrx.zzmv()) * (zzrx.zzmw() - zzrx.zzmu());
        float zzmx2 = (zzrx2.zzmx() - zzrx2.zzmv()) * (zzrx2.zzmw() - zzrx2.zzmu());
        if (zzmx > zzmx2) {
            return -1;
        }
        if (zzmx < zzmx2) {
            return 1;
        }
        return 0;
    }
}
