package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzor implements zzol {
    private final boolean zzbin;
    private final int zzbio;
    private final byte[] zzbip;
    private final zzom[] zzbiq;
    private int zzbir;
    private int zzbis;
    private int zzbit;
    private zzom[] zzbiu;

    public zzor(boolean z, int i) {
        this(true, 65536, 0);
    }

    private zzor(boolean z, int i, int i2) {
        zzpg.checkArgument(true);
        zzpg.checkArgument(true);
        this.zzbin = true;
        this.zzbio = 65536;
        this.zzbit = 0;
        this.zzbiu = new zzom[100];
        this.zzbip = null;
        this.zzbiq = new zzom[1];
    }

    public final synchronized void reset() {
        if (this.zzbin) {
            zzbi(0);
        }
    }

    public final synchronized void zzbi(int i) {
        boolean z = i < this.zzbir;
        this.zzbir = i;
        if (z) {
            zzn();
        }
    }

    public final synchronized zzom zzir() {
        zzom zzom;
        this.zzbis++;
        if (this.zzbit > 0) {
            zzom[] zzomArr = this.zzbiu;
            int i = this.zzbit - 1;
            this.zzbit = i;
            zzom = zzomArr[i];
            this.zzbiu[i] = null;
        } else {
            zzom = new zzom(new byte[this.zzbio], 0);
        }
        return zzom;
    }

    public final synchronized void zza(zzom zzom) {
        this.zzbiq[0] = zzom;
        zza(this.zzbiq);
    }

    public final synchronized void zza(zzom[] zzomArr) {
        boolean z;
        if (this.zzbit + zzomArr.length >= this.zzbiu.length) {
            this.zzbiu = (zzom[]) Arrays.copyOf(this.zzbiu, Math.max(this.zzbiu.length << 1, this.zzbit + zzomArr.length));
        }
        for (zzom zzom : zzomArr) {
            if (zzom.data != null) {
                if (zzom.data.length != this.zzbio) {
                    z = false;
                    zzpg.checkArgument(z);
                    zzom[] zzomArr2 = this.zzbiu;
                    int i = this.zzbit;
                    this.zzbit = i + 1;
                    zzomArr2[i] = zzom;
                }
            }
            z = true;
            zzpg.checkArgument(z);
            zzom[] zzomArr22 = this.zzbiu;
            int i2 = this.zzbit;
            this.zzbit = i2 + 1;
            zzomArr22[i2] = zzom;
        }
        this.zzbis -= zzomArr.length;
        notifyAll();
    }

    public final synchronized void zzn() {
        int max = Math.max(0, zzpt.zzh(this.zzbir, this.zzbio) - this.zzbis);
        if (max < this.zzbit) {
            Arrays.fill(this.zzbiu, max, this.zzbit, (Object) null);
            this.zzbit = max;
        }
    }

    public final synchronized int zziu() {
        return this.zzbis * this.zzbio;
    }

    public final int zzis() {
        return this.zzbio;
    }
}
