package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzeon;
import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public abstract class zzecx<KeyFormatProtoT extends zzeon, KeyT> {
    private final Class<KeyFormatProtoT> zziel;

    public zzecx(Class<KeyFormatProtoT> cls) {
        this.zziel = cls;
    }

    public abstract void zzd(KeyFormatProtoT keyformatprotot) throws GeneralSecurityException;

    public abstract KeyT zze(KeyFormatProtoT keyformatprotot) throws GeneralSecurityException;

    public abstract KeyFormatProtoT zzr(zzelq zzelq) throws zzenn;

    public final Class<KeyFormatProtoT> zzbbo() {
        return this.zziel;
    }
}
