package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcf;
import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzgi extends zzgn {
    public zzgi(zzfc zzfc, String str, String str2, zzcf.zza.zzb zzb, int i, int i2) {
        super(zzfc, str, str2, zzb, i, 51);
    }

    /* access modifiers changed from: protected */
    public final void zzcx() throws IllegalAccessException, InvocationTargetException {
        synchronized (this.zzabg) {
            zzez zzez = new zzez((String) this.zzabq.invoke((Object) null, new Object[0]));
            this.zzabg.zzbj(zzez.zzyy.longValue());
            this.zzabg.zzbk(zzez.zzyz.longValue());
        }
    }
}
