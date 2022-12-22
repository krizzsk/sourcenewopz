package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzede<P> {
    private final P zziet;
    private final byte[] zzieu;
    private final zzeid zziev;
    private final zzeiw zziew;
    private final int zziex;

    zzede(P p, byte[] bArr, zzeid zzeid, zzeiw zzeiw, int i) {
        this.zziet = p;
        this.zzieu = Arrays.copyOf(bArr, bArr.length);
        this.zziev = zzeid;
        this.zziew = zzeiw;
        this.zziex = i;
    }

    public final P zzbbq() {
        return this.zziet;
    }

    public final zzeid zzbbr() {
        return this.zziev;
    }

    public final zzeiw zzbbs() {
        return this.zziew;
    }

    public final byte[] zzbbt() {
        byte[] bArr = this.zzieu;
        if (bArr == null) {
            return null;
        }
        return Arrays.copyOf(bArr, bArr.length);
    }
}
