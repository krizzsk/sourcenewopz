package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzeon;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public abstract class zzedi<KeyProtoT extends zzeon, PublicKeyProtoT extends zzeon> extends zzecu<KeyProtoT> {
    private final Class<PublicKeyProtoT> zziez;

    @SafeVarargs
    protected zzedi(Class<KeyProtoT> cls, Class<PublicKeyProtoT> cls2, zzecw<?, KeyProtoT>... zzecwArr) {
        super(cls, zzecwArr);
        this.zziez = cls2;
    }
}
