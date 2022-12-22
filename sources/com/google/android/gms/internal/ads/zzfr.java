package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcf;
import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzfr extends zzgn {
    public zzfr(zzfc zzfc, String str, String str2, zzcf.zza.zzb zzb, int i, int i2) {
        super(zzfc, str, str2, zzb, i, 5);
    }

    /* access modifiers changed from: protected */
    public final void zzcx() throws IllegalAccessException, InvocationTargetException {
        this.zzabg.zzam(-1);
        this.zzabg.zzan(-1);
        int[] iArr = (int[]) this.zzabq.invoke((Object) null, new Object[]{this.zzwh.getContext()});
        synchronized (this.zzabg) {
            this.zzabg.zzam((long) iArr[0]);
            this.zzabg.zzan((long) iArr[1]);
            if (iArr[2] != Integer.MIN_VALUE) {
                this.zzabg.zzbm((long) iArr[2]);
            }
        }
    }
}
