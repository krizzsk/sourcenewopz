package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
public final class zzdww extends Exception {
    private final int zzhxu;

    public zzdww(int i, String str) {
        super(str);
        this.zzhxu = i;
    }

    public zzdww(int i, Throwable th) {
        super(th);
        this.zzhxu = i;
    }

    public final int zzazt() {
        return this.zzhxu;
    }
}
