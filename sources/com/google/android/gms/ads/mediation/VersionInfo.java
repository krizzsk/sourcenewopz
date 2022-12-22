package com.google.android.gms.ads.mediation;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public final class VersionInfo {
    private final int zzexr;
    private final int zzexs;
    private final int zzext;

    public VersionInfo(int i, int i2, int i3) {
        this.zzexr = i;
        this.zzexs = i2;
        this.zzext = i3;
    }

    public final int getMajorVersion() {
        return this.zzexr;
    }

    public final int getMinorVersion() {
        return this.zzexs;
    }

    public final int getMicroVersion() {
        return this.zzext;
    }
}
