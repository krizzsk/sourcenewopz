package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbgx {
    public final int heightPixels;
    private final int type;
    public final int widthPixels;

    public static zzbgx zzb(zzvt zzvt) {
        if (zzvt.zzcir) {
            return new zzbgx(3, 0, 0);
        }
        if (zzvt.zzcit) {
            return new zzbgx(2, 0, 0);
        }
        if (zzvt.zzbsb) {
            return zzafg();
        }
        return zzs(zzvt.widthPixels, zzvt.heightPixels);
    }

    public static zzbgx zzafg() {
        return new zzbgx(0, 0, 0);
    }

    public static zzbgx zzs(int i, int i2) {
        return new zzbgx(1, i, i2);
    }

    public static zzbgx zzafh() {
        return new zzbgx(4, 0, 0);
    }

    public static zzbgx zzafi() {
        return new zzbgx(5, 0, 0);
    }

    private zzbgx(int i, int i2, int i3) {
        this.type = i;
        this.widthPixels = i2;
        this.heightPixels = i3;
    }

    public final boolean isFluid() {
        return this.type == 2;
    }

    public final boolean zzafj() {
        return this.type == 3;
    }

    public final boolean zzafk() {
        return this.type == 0;
    }

    public final boolean zzafl() {
        return this.type == 4;
    }

    public final boolean zzafm() {
        return this.type == 5;
    }
}
