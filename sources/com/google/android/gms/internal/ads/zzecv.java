package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzeon;
import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzecv<KeyFormatProtoT extends zzeon, KeyProtoT extends zzeon> {
    private final zzecx<KeyFormatProtoT, KeyProtoT> zzieo;

    zzecv(zzecx<KeyFormatProtoT, KeyProtoT> zzecx) {
        this.zzieo = zzecx;
    }

    /* access modifiers changed from: package-private */
    public final KeyProtoT zzq(zzelq zzelq) throws GeneralSecurityException, zzenn {
        KeyFormatProtoT zzr = this.zzieo.zzr(zzelq);
        this.zzieo.zzd(zzr);
        return (zzeon) this.zzieo.zze(zzr);
    }
}
