package com.google.android.gms.internal.ads;

import java.util.NoSuchElementException;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
final class zzelp extends zzelr {
    private final int limit = this.zzipb.size();
    private int position = 0;
    private final /* synthetic */ zzelq zzipb;

    zzelp(zzelq zzelq) {
        this.zzipb = zzelq;
    }

    public final boolean hasNext() {
        return this.position < this.limit;
    }

    public final byte nextByte() {
        int i = this.position;
        if (i < this.limit) {
            this.position = i + 1;
            return this.zzipb.zzgi(i);
        }
        throw new NoSuchElementException();
    }
}
