package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcf;
import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzgb extends zzgn {
    public zzgb(zzfc zzfc, String str, String str2, zzcf.zza.zzb zzb, int i, int i2) {
        super(zzfc, str, str2, zzb, i, 3);
    }

    /* access modifiers changed from: protected */
    public final void zzcx() throws IllegalAccessException, InvocationTargetException {
        boolean booleanValue = ((Boolean) zzww.zzra().zzd(zzabq.zzcsw)).booleanValue();
        zzem zzem = new zzem((String) this.zzabq.invoke((Object) null, new Object[]{this.zzwh.getContext(), Boolean.valueOf(booleanValue)}));
        synchronized (this.zzabg) {
            this.zzabg.zzal(zzem.zzyl);
            this.zzabg.zzbn(zzem.zzym);
        }
    }
}
