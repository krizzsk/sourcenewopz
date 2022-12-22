package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcf;
import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzfz extends zzgn {
    private long zzabi = -1;

    public zzfz(zzfc zzfc, String str, String str2, zzcf.zza.zzb zzb, int i, int i2) {
        super(zzfc, str, str2, zzb, i, 12);
    }

    /* access modifiers changed from: protected */
    public final void zzcx() throws IllegalAccessException, InvocationTargetException {
        this.zzabg.zzap(-1);
        this.zzabg.zzap(((Long) this.zzabq.invoke((Object) null, new Object[]{this.zzwh.getContext()})).longValue());
    }
}
