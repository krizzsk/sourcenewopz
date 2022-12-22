package com.google.android.gms.internal.ads;

import java.io.File;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
public final class zzdwm {
    private final zzgv zzhxe;
    private final File zzhxf;
    private final File zzhxg;
    private final File zzhxh;
    private byte[] zzhxi;

    public zzdwm(zzgv zzgv, File file, File file2, File file3) {
        this.zzhxe = zzgv;
        this.zzhxf = file;
        this.zzhxg = file3;
        this.zzhxh = file2;
    }

    public final zzgv zzazj() {
        return this.zzhxe;
    }

    public final File zzazk() {
        return this.zzhxf;
    }

    public final File zzazl() {
        return this.zzhxg;
    }

    public final byte[] zzazm() {
        if (this.zzhxi == null) {
            this.zzhxi = zzdwo.zzf(this.zzhxh);
        }
        byte[] bArr = this.zzhxi;
        if (bArr == null) {
            return null;
        }
        return Arrays.copyOf(bArr, bArr.length);
    }

    public final boolean zzfg(long j) {
        return this.zzhxe.zzdj() - (System.currentTimeMillis() / 1000) < 3600;
    }
}
