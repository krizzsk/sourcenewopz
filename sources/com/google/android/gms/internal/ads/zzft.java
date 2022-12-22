package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcf;
import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzft extends zzgn {
    private long startTime;

    public zzft(zzfc zzfc, String str, String str2, zzcf.zza.zzb zzb, long j, int i, int i2) {
        super(zzfc, str, str2, zzb, i, 25);
        this.startTime = j;
    }

    /* access modifiers changed from: protected */
    public final void zzcx() throws IllegalAccessException, InvocationTargetException {
        long longValue = ((Long) this.zzabq.invoke((Object) null, new Object[0])).longValue();
        synchronized (this.zzabg) {
            this.zzabg.zzbr(longValue);
            if (this.startTime != 0) {
                this.zzabg.zzat(longValue - this.startTime);
                this.zzabg.zzaw(this.startTime);
            }
        }
    }
}
