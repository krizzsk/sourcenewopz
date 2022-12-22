package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public final class zzui {
    private final byte[] zzbyv;
    private int zzbyw;
    private int zzbyx;
    private final /* synthetic */ zzue zzbyy;

    private zzui(zzue zzue, byte[] bArr) {
        this.zzbyy = zzue;
        this.zzbyv = bArr;
    }

    public final synchronized void log() {
        try {
            if (this.zzbyy.zzbyu) {
                this.zzbyy.zzbyt.zzc(this.zzbyv);
                this.zzbyy.zzbyt.zzt(this.zzbyw);
                this.zzbyy.zzbyt.zzu(this.zzbyx);
                this.zzbyy.zzbyt.zza((int[]) null);
                this.zzbyy.zzbyt.log();
            }
        } catch (RemoteException e) {
            zzbao.zzb("Clearcut log failed", e);
        }
    }

    public final zzui zzbx(int i) {
        this.zzbyw = i;
        return this;
    }

    public final zzui zzby(int i) {
        this.zzbyx = i;
        return this;
    }
}
