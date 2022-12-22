package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcf;
import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzfy extends zzgn {
    private static final Object zzabf = new Object();
    private static volatile Long zzabh;

    public zzfy(zzfc zzfc, String str, String str2, zzcf.zza.zzb zzb, int i, int i2) {
        super(zzfc, str, str2, zzb, i, 22);
    }

    /* access modifiers changed from: protected */
    public final void zzcx() throws IllegalAccessException, InvocationTargetException {
        if (zzabh == null) {
            synchronized (zzabf) {
                if (zzabh == null) {
                    zzabh = (Long) this.zzabq.invoke((Object) null, new Object[0]);
                }
            }
        }
        synchronized (this.zzabg) {
            this.zzabg.zzav(zzabh.longValue());
        }
    }
}
