package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcf;
import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzgg extends zzgn {
    private final boolean zzabm;

    public zzgg(zzfc zzfc, String str, String str2, zzcf.zza.zzb zzb, int i, int i2) {
        super(zzfc, str, str2, zzb, i, 61);
        this.zzabm = zzfc.zzcg();
    }

    /* access modifiers changed from: protected */
    public final void zzcx() throws IllegalAccessException, InvocationTargetException {
        long longValue = ((Long) this.zzabq.invoke((Object) null, new Object[]{this.zzwh.getContext(), Boolean.valueOf(this.zzabm)})).longValue();
        synchronized (this.zzabg) {
            this.zzabg.zzbo(longValue);
        }
    }
}
