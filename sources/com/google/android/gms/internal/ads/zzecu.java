package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzeic;
import com.google.android.gms.internal.ads.zzeon;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public abstract class zzecu<KeyProtoT extends zzeon> {
    private final Class<KeyProtoT> zziel;
    private final Map<Class<?>, zzecw<?, KeyProtoT>> zziem;
    private final Class<?> zzien;

    @SafeVarargs
    protected zzecu(Class<KeyProtoT> cls, zzecw<?, KeyProtoT>... zzecwArr) {
        this.zziel = cls;
        HashMap hashMap = new HashMap();
        int length = zzecwArr.length;
        int i = 0;
        while (i < length) {
            zzecw<?, KeyProtoT> zzecw = zzecwArr[i];
            if (hashMap.containsKey(zzecw.zzbbh())) {
                String valueOf = String.valueOf(zzecw.zzbbh().getCanonicalName());
                throw new IllegalArgumentException(valueOf.length() != 0 ? "KeyTypeManager constructed with duplicate factories for primitive ".concat(valueOf) : new String("KeyTypeManager constructed with duplicate factories for primitive "));
            } else {
                hashMap.put(zzecw.zzbbh(), zzecw);
                i++;
            }
        }
        if (zzecwArr.length > 0) {
            this.zzien = zzecwArr[0].zzbbh();
        } else {
            this.zzien = Void.class;
        }
        this.zziem = Collections.unmodifiableMap(hashMap);
    }

    public abstract String getKeyType();

    public abstract zzeic.zza zzbbk();

    public abstract void zzc(KeyProtoT keyprotot) throws GeneralSecurityException;

    public abstract KeyProtoT zzp(zzelq zzelq) throws zzenn;

    public final Class<KeyProtoT> zzbbj() {
        return this.zziel;
    }

    public final <P> P zza(KeyProtoT keyprotot, Class<P> cls) throws GeneralSecurityException {
        zzecw zzecw = this.zziem.get(cls);
        if (zzecw != null) {
            return zzecw.zzah(keyprotot);
        }
        String canonicalName = cls.getCanonicalName();
        StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 41);
        sb.append("Requested primitive class ");
        sb.append(canonicalName);
        sb.append(" not supported.");
        throw new IllegalArgumentException(sb.toString());
    }

    public final Set<Class<?>> zzbbl() {
        return this.zziem.keySet();
    }

    /* access modifiers changed from: package-private */
    public final Class<?> zzbbm() {
        return this.zzien;
    }

    public zzecx<?, KeyProtoT> zzbbn() {
        throw new UnsupportedOperationException("Creating keys is not supported.");
    }
}
