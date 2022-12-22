package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public abstract class zzhd implements zzhy, zzib {
    private int index;
    private int state;
    private final int zzaek;
    private zzia zzael;
    private zznn zzaem;
    private long zzaen;
    private boolean zzaeo = true;
    private boolean zzaep;

    public zzhd(int i) {
        this.zzaek = i;
    }

    /* access modifiers changed from: protected */
    public void onStarted() throws zzhe {
    }

    /* access modifiers changed from: protected */
    public void onStopped() throws zzhe {
    }

    public void zza(int i, Object obj) throws zzhe {
    }

    /* access modifiers changed from: protected */
    public void zza(long j, boolean z) throws zzhe {
    }

    /* access modifiers changed from: protected */
    public void zza(zzht[] zzhtArr, long j) throws zzhe {
    }

    public final zzib zzec() {
        return this;
    }

    public zzpk zzed() {
        return null;
    }

    public int zzej() throws zzhe {
        return 0;
    }

    /* access modifiers changed from: protected */
    public void zzek() {
    }

    /* access modifiers changed from: protected */
    public void zzf(boolean z) throws zzhe {
    }

    public final int getTrackType() {
        return this.zzaek;
    }

    public final void setIndex(int i) {
        this.index = i;
    }

    public final int getState() {
        return this.state;
    }

    public final void zza(zzia zzia, zzht[] zzhtArr, zznn zznn, long j, boolean z, long j2) throws zzhe {
        zzpg.checkState(this.state == 0);
        this.zzael = zzia;
        this.state = 1;
        zzf(z);
        zza(zzhtArr, zznn, j2);
        zza(j, z);
    }

    public final void start() throws zzhe {
        boolean z = true;
        if (this.state != 1) {
            z = false;
        }
        zzpg.checkState(z);
        this.state = 2;
        onStarted();
    }

    public final void zza(zzht[] zzhtArr, zznn zznn, long j) throws zzhe {
        zzpg.checkState(!this.zzaep);
        this.zzaem = zznn;
        this.zzaeo = false;
        this.zzaen = j;
        zza(zzhtArr, j);
    }

    public final zznn zzee() {
        return this.zzaem;
    }

    public final boolean zzef() {
        return this.zzaeo;
    }

    public final void zzeg() {
        this.zzaep = true;
    }

    public final boolean zzeh() {
        return this.zzaep;
    }

    public final void zzei() throws IOException {
        this.zzaem.zzhw();
    }

    public final void zzdm(long j) throws zzhe {
        this.zzaep = false;
        this.zzaeo = false;
        zza(j, false);
    }

    public final void stop() throws zzhe {
        zzpg.checkState(this.state == 2);
        this.state = 1;
        onStopped();
    }

    public final void disable() {
        boolean z = true;
        if (this.state != 1) {
            z = false;
        }
        zzpg.checkState(z);
        this.state = 0;
        this.zzaem = null;
        this.zzaep = false;
        zzek();
    }

    /* access modifiers changed from: protected */
    public final zzia zzel() {
        return this.zzael;
    }

    /* access modifiers changed from: protected */
    public final int getIndex() {
        return this.index;
    }

    /* access modifiers changed from: protected */
    public final int zza(zzhv zzhv, zzjp zzjp, boolean z) {
        int zzb = this.zzaem.zzb(zzhv, zzjp, z);
        if (zzb == -4) {
            if (zzjp.zzgm()) {
                this.zzaeo = true;
                if (this.zzaep) {
                    return -4;
                }
                return -3;
            }
            zzjp.zzaov += this.zzaen;
        } else if (zzb == -5) {
            zzht zzht = zzhv.zzaij;
            if (zzht.zzaid != Long.MAX_VALUE) {
                zzhv.zzaij = zzht.zzds(zzht.zzaid + this.zzaen);
            }
        }
        return zzb;
    }

    /* access modifiers changed from: protected */
    public final void zzdn(long j) {
        this.zzaem.zzeh(j - this.zzaen);
    }

    /* access modifiers changed from: protected */
    public final boolean zzem() {
        return this.zzaeo ? this.zzaep : this.zzaem.isReady();
    }
}
