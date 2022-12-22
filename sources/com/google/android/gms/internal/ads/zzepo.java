package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
final class zzepo extends zzepu {
    private final /* synthetic */ zzepn zzixv;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private zzepo(zzepn zzepn) {
        super(zzepn, (zzepm) null);
        this.zzixv = zzepn;
    }

    public final Iterator<Map.Entry<K, V>> iterator() {
        return new zzepp(this.zzixv, (zzepm) null);
    }

    /* synthetic */ zzepo(zzepn zzepn, zzepm zzepm) {
        this(zzepn);
    }
}
