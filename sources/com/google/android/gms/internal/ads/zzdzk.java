package com.google.android.gms.internal.ads;

import java.util.ListIterator;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
final class zzdzk extends zzdzy<F, T> {
    private final /* synthetic */ zzdzh zzibf;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzdzk(zzdzh zzdzh, ListIterator listIterator) {
        super(listIterator);
        this.zzibf = zzdzh;
    }

    /* access modifiers changed from: package-private */
    public final T zzae(F f) {
        return this.zzibf.zzibe.apply(f);
    }
}
