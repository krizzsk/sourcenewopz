package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcf;
import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzgh extends zzgn {
    private long zzaar;
    private final zzfj zzxo;

    public zzgh(zzfc zzfc, String str, String str2, zzcf.zza.zzb zzb, int i, int i2, zzfj zzfj) {
        super(zzfc, str, str2, zzb, i, 53);
        this.zzxo = zzfj;
        if (zzfj != null) {
            this.zzaar = zzfj.zzcv();
        }
    }

    /* access modifiers changed from: protected */
    public final void zzcx() throws IllegalAccessException, InvocationTargetException {
        if (this.zzxo != null) {
            this.zzabg.zzbl(((Long) this.zzabq.invoke((Object) null, new Object[]{Long.valueOf(this.zzaar)})).longValue());
        }
    }
}
