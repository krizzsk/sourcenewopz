package com.google.android.gms.internal.ads;

import android.view.View;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public class zzbnl {
    private final View view;
    private final zzbfi zzdkm;
    private final zzdow zzfvv;
    private final zzbpd zzfww;

    public zzbnl(View view2, zzbfi zzbfi, zzbpd zzbpd, zzdow zzdow) {
        this.view = view2;
        this.zzdkm = zzbfi;
        this.zzfww = zzbpd;
        this.zzfvv = zzdow;
    }

    public final zzbfi zzajy() {
        return this.zzdkm;
    }

    public final View zzakl() {
        return this.view;
    }

    public final zzbpd zzakx() {
        return this.zzfww;
    }

    public final zzdow zzaky() {
        return this.zzfvv;
    }

    public zzbui zza(Set<zzbzl<zzbuj>> set) {
        return new zzbui(set);
    }
}
