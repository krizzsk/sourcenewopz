package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public abstract class zzecw<PrimitiveT, KeyT> {
    private final Class<PrimitiveT> zziel;

    public zzecw(Class<PrimitiveT> cls) {
        this.zziel = cls;
    }

    public abstract PrimitiveT zzah(KeyT keyt) throws GeneralSecurityException;

    /* access modifiers changed from: package-private */
    public final Class<PrimitiveT> zzbbh() {
        return this.zziel;
    }
}
