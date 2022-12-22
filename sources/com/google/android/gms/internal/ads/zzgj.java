package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcf;
import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzgj extends zzgn {
    public zzgj(zzfc zzfc, String str, String str2, zzcf.zza.zzb zzb, int i, int i2) {
        super(zzfc, str, str2, zzb, i, 48);
    }

    /* access modifiers changed from: protected */
    public final void zzcx() throws IllegalAccessException, InvocationTargetException {
        this.zzabg.zzf(zzcq.ENUM_FAILURE);
        boolean booleanValue = ((Boolean) this.zzabq.invoke((Object) null, new Object[]{this.zzwh.getContext()})).booleanValue();
        synchronized (this.zzabg) {
            if (booleanValue) {
                this.zzabg.zzf(zzcq.ENUM_TRUE);
            } else {
                this.zzabg.zzf(zzcq.ENUM_FALSE);
            }
        }
    }
}
