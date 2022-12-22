package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzelf;
import com.google.android.gms.internal.ads.zzelg;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
public abstract class zzelf<MessageType extends zzelg<MessageType, BuilderType>, BuilderType extends zzelf<MessageType, BuilderType>> implements zzeom {
    /* access modifiers changed from: protected */
    public abstract BuilderType zza(MessageType messagetype);

    public abstract BuilderType zza(zzemb zzemb, zzemn zzemn) throws IOException;

    /* renamed from: zzbgx */
    public abstract BuilderType clone();

    public BuilderType zza(byte[] bArr, int i, int i2, zzemn zzemn) throws zzenn {
        try {
            zzemb zzb = zzemb.zzb(bArr, 0, i2, false);
            zza(zzb, zzemn);
            zzb.zzgl(0);
            return this;
        } catch (zzenn e) {
            throw e;
        } catch (IOException e2) {
            String name = getClass().getName();
            StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 60 + "byte array".length());
            sb.append("Reading ");
            sb.append(name);
            sb.append(" from a ");
            sb.append("byte array");
            sb.append(" threw an IOException (should never happen).");
            throw new RuntimeException(sb.toString(), e2);
        }
    }

    public final /* synthetic */ zzeom zzf(zzeon zzeon) {
        if (zzbjp().getClass().isInstance(zzeon)) {
            return zza((zzelg) zzeon);
        }
        throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
    }
}
