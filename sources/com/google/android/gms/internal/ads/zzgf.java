package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcf;
import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzgf extends zzgn {
    private final StackTraceElement[] zzabl;

    public zzgf(zzfc zzfc, String str, String str2, zzcf.zza.zzb zzb, int i, int i2, StackTraceElement[] stackTraceElementArr) {
        super(zzfc, str, str2, zzb, i, 45);
        this.zzabl = stackTraceElementArr;
    }

    /* access modifiers changed from: protected */
    public final void zzcx() throws IllegalAccessException, InvocationTargetException {
        zzcq zzcq;
        if (this.zzabl != null) {
            zzey zzey = new zzey((String) this.zzabq.invoke((Object) null, new Object[]{this.zzabl}));
            synchronized (this.zzabg) {
                this.zzabg.zzbi(zzey.zzyv.longValue());
                if (zzey.zzyw.booleanValue()) {
                    zzcf.zza.zzb zzb = this.zzabg;
                    if (zzey.zzyx.booleanValue()) {
                        zzcq = zzcq.ENUM_FALSE;
                    } else {
                        zzcq = zzcq.ENUM_TRUE;
                    }
                    zzb.zzh(zzcq);
                } else {
                    this.zzabg.zzh(zzcq.ENUM_FAILURE);
                }
            }
        }
    }
}
