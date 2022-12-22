package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzeon;
import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public class zzecs<PrimitiveT, KeyProtoT extends zzeon> implements zzect<PrimitiveT> {
    private final zzecu<KeyProtoT> zziej;
    private final Class<PrimitiveT> zziek;

    public zzecs(zzecu<KeyProtoT> zzecu, Class<PrimitiveT> cls) {
        if (zzecu.zzbbl().contains(cls) || Void.class.equals(cls)) {
            this.zziej = zzecu;
            this.zziek = cls;
            return;
        }
        throw new IllegalArgumentException(String.format("Given internalKeyMananger %s does not support primitive class %s", new Object[]{zzecu.toString(), cls.getName()}));
    }

    public final PrimitiveT zzm(zzelq zzelq) throws GeneralSecurityException {
        try {
            return zzb(this.zziej.zzp(zzelq));
        } catch (zzenn e) {
            String valueOf = String.valueOf(this.zziej.zzbbj().getName());
            throw new GeneralSecurityException(valueOf.length() != 0 ? "Failures parsing proto of type ".concat(valueOf) : new String("Failures parsing proto of type "), e);
        }
    }

    public final PrimitiveT zza(zzeon zzeon) throws GeneralSecurityException {
        String valueOf = String.valueOf(this.zziej.zzbbj().getName());
        String concat = valueOf.length() != 0 ? "Expected proto of type ".concat(valueOf) : new String("Expected proto of type ");
        if (this.zziej.zzbbj().isInstance(zzeon)) {
            return zzb(zzeon);
        }
        throw new GeneralSecurityException(concat);
    }

    public final zzeon zzn(zzelq zzelq) throws GeneralSecurityException {
        try {
            return zzbbi().zzq(zzelq);
        } catch (zzenn e) {
            String valueOf = String.valueOf(this.zziej.zzbbn().zzbbo().getName());
            throw new GeneralSecurityException(valueOf.length() != 0 ? "Failures parsing proto of type ".concat(valueOf) : new String("Failures parsing proto of type "), e);
        }
    }

    public final String getKeyType() {
        return this.zziej.getKeyType();
    }

    public final zzeic zzo(zzelq zzelq) throws GeneralSecurityException {
        try {
            return (zzeic) ((zzena) zzeic.zzbey().zzhv(this.zziej.getKeyType()).zzag(zzbbi().zzq(zzelq).zzbgy()).zzb(this.zziej.zzbbk()).zzbjv());
        } catch (zzenn e) {
            throw new GeneralSecurityException("Unexpected proto", e);
        }
    }

    public final Class<PrimitiveT> zzbbh() {
        return this.zziek;
    }

    private final PrimitiveT zzb(KeyProtoT keyprotot) throws GeneralSecurityException {
        if (!Void.class.equals(this.zziek)) {
            this.zziej.zzc(keyprotot);
            return this.zziej.zza(keyprotot, this.zziek);
        }
        throw new GeneralSecurityException("Cannot create a primitive for Void");
    }

    private final zzecv<?, KeyProtoT> zzbbi() {
        return new zzecv<>(this.zziej.zzbbn());
    }
}
