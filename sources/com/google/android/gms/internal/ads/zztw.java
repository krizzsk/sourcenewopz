package com.google.android.gms.internal.ads;

import java.io.InputStream;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zztw {
    private final InputStream zzbjk;
    private final boolean zzbvt;
    private final boolean zzbvu;
    private final long zzbvv;
    private final boolean zzbvw;

    private zztw(InputStream inputStream, boolean z, boolean z2, long j, boolean z3) {
        this.zzbjk = inputStream;
        this.zzbvt = z;
        this.zzbvw = z2;
        this.zzbvv = j;
        this.zzbvu = z3;
    }

    public static zztw zza(InputStream inputStream, boolean z, boolean z2, long j, boolean z3) {
        return new zztw(inputStream, z, z2, j, z3);
    }

    public final InputStream getInputStream() {
        return this.zzbjk;
    }

    public final boolean zznf() {
        return this.zzbvt;
    }

    public final boolean zzni() {
        return this.zzbvw;
    }

    public final long zznh() {
        return this.zzbvv;
    }

    public final boolean zzng() {
        return this.zzbvu;
    }
}
