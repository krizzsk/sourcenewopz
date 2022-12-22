package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzeon;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzedj<PrimitiveT, KeyProtoT extends zzeon, PublicKeyProtoT extends zzeon> extends zzecs<PrimitiveT, KeyProtoT> implements zzect<PrimitiveT> {
    private final zzedi<KeyProtoT, PublicKeyProtoT> zzifa;
    private final zzecu<PublicKeyProtoT> zzifb;

    public zzedj(zzedi<KeyProtoT, PublicKeyProtoT> zzedi, zzecu<PublicKeyProtoT> zzecu, Class<PrimitiveT> cls) {
        super(zzedi, cls);
        this.zzifa = zzedi;
        this.zzifb = zzecu;
    }
}
