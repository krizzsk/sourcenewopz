package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
final class zzely {
    private final byte[] buffer;
    private final zzemk zziph;

    private zzely(int i) {
        byte[] bArr = new byte[i];
        this.buffer = bArr;
        this.zziph = zzemk.zzv(bArr);
    }

    public final zzelq zzbhp() {
        this.zziph.zzbis();
        return new zzema(this.buffer);
    }

    public final zzemk zzbhq() {
        return this.zziph;
    }

    /* synthetic */ zzely(int i, zzelp zzelp) {
        this(i);
    }
}
