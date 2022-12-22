package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcf;
import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzfu extends zzgn {
    private static volatile Long zzabe;
    private static final Object zzabf = new Object();

    public zzfu(zzfc zzfc, String str, String str2, zzcf.zza.zzb zzb, int i, int i2) {
        super(zzfc, str, str2, zzb, i, 44);
    }

    /* access modifiers changed from: protected */
    public final void zzcx() throws IllegalAccessException, InvocationTargetException {
        if (zzabe == null) {
            synchronized (zzabf) {
                if (zzabe == null) {
                    zzabe = (Long) this.zzabq.invoke((Object) null, new Object[0]);
                }
            }
        }
        synchronized (this.zzabg) {
            this.zzabg.zzbh(zzabe.longValue());
        }
    }
}
