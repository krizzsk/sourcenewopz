package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
public abstract class zzemb {
    int zzipo;
    int zzipp;
    int zzipq;
    zzemi zzipr;
    private boolean zzips;

    static zzemb zzb(byte[] bArr, int i, int i2, boolean z) {
        zzemd zzemd = new zzemd(bArr, i, i2, z);
        try {
            zzemd.zzgn(i2);
            return zzemd;
        } catch (zzenn e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static long zzfh(long j) {
        return (-(j & 1)) ^ (j >>> 1);
    }

    public static int zzgp(int i) {
        return (-(i & 1)) ^ (i >>> 1);
    }

    public abstract double readDouble() throws IOException;

    public abstract float readFloat() throws IOException;

    public abstract String readString() throws IOException;

    public abstract int zzbhr() throws IOException;

    public abstract long zzbhs() throws IOException;

    public abstract long zzbht() throws IOException;

    public abstract int zzbhu() throws IOException;

    public abstract long zzbhv() throws IOException;

    public abstract int zzbhw() throws IOException;

    public abstract boolean zzbhx() throws IOException;

    public abstract String zzbhy() throws IOException;

    public abstract zzelq zzbhz() throws IOException;

    public abstract int zzbia() throws IOException;

    public abstract int zzbib() throws IOException;

    public abstract int zzbic() throws IOException;

    public abstract long zzbid() throws IOException;

    public abstract int zzbie() throws IOException;

    public abstract long zzbif() throws IOException;

    /* access modifiers changed from: package-private */
    public abstract long zzbig() throws IOException;

    public abstract boolean zzbih() throws IOException;

    public abstract int zzbii();

    public abstract void zzgl(int i) throws zzenn;

    public abstract boolean zzgm(int i) throws IOException;

    public abstract int zzgn(int i) throws zzenn;

    public abstract void zzgo(int i);

    private zzemb() {
        this.zzipp = 100;
        this.zzipq = Integer.MAX_VALUE;
        this.zzips = false;
    }
}
