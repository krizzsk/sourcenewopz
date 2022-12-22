package com.google.android.gms.internal.ads;

import java.util.ListIterator;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
final class zzdzm extends zzdzy<F, T> {
    private final /* synthetic */ zzdzj zzibg;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzdzm(zzdzj zzdzj, ListIterator listIterator) {
        super(listIterator);
        this.zzibg = zzdzj;
    }

    /* access modifiers changed from: package-private */
    public final T zzae(F f) {
        return this.zzibg.zzibe.apply(f);
    }
}
