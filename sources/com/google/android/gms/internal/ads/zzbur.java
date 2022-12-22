package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzl;
import com.google.android.gms.ads.internal.overlay.zzp;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbur extends zzbxq<zzp> implements zzp {
    public zzbur(Set<zzbzl<zzp>> set) {
        super(set);
    }

    public final synchronized void zza(zzl zzl) {
        zza(new zzbuu(zzl));
    }

    public final synchronized void onUserLeaveHint() {
        zza(zzbut.zzgbn);
    }

    public final synchronized void onPause() {
        zza(zzbuw.zzgbn);
    }

    public final synchronized void onResume() {
        zza(zzbuv.zzgbn);
    }

    public final synchronized void zzvz() {
        zza(zzbuy.zzgbn);
    }
}
