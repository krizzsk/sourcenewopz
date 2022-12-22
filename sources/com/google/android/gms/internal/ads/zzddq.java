package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzddq implements zzdhb<Bundle> {
    private final float zzdwd;
    private final int zzdyx;
    private final boolean zzdzf;
    private final boolean zzdzg;
    private final int zzdzk;
    private final int zzdzo;
    private final int zzdzp;
    private final boolean zzhef;

    public zzddq(int i, boolean z, boolean z2, int i2, int i3, int i4, float f, boolean z3) {
        this.zzdyx = i;
        this.zzdzf = z;
        this.zzdzg = z2;
        this.zzdzk = i2;
        this.zzdzo = i3;
        this.zzdzp = i4;
        this.zzdwd = f;
        this.zzhef = z3;
    }

    public final /* synthetic */ void zzr(Object obj) {
        Bundle bundle = (Bundle) obj;
        bundle.putInt("am", this.zzdyx);
        bundle.putBoolean("ma", this.zzdzf);
        bundle.putBoolean("sp", this.zzdzg);
        bundle.putInt("muv", this.zzdzk);
        bundle.putInt("rm", this.zzdzo);
        bundle.putInt("riv", this.zzdzp);
        bundle.putFloat("android_app_volume", this.zzdwd);
        bundle.putBoolean("android_app_muted", this.zzhef);
    }
}
