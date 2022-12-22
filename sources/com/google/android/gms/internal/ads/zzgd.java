package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcf;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzgd extends zzgn {
    private List<Long> zzabk = null;

    public zzgd(zzfc zzfc, String str, String str2, zzcf.zza.zzb zzb, int i, int i2) {
        super(zzfc, str, str2, zzb, i, 31);
    }

    /* access modifiers changed from: protected */
    public final void zzcx() throws IllegalAccessException, InvocationTargetException {
        this.zzabg.zzax(-1);
        this.zzabg.zzay(-1);
        if (this.zzabk == null) {
            this.zzabk = (List) this.zzabq.invoke((Object) null, new Object[]{this.zzwh.getContext()});
        }
        List<Long> list = this.zzabk;
        if (list != null && list.size() == 2) {
            synchronized (this.zzabg) {
                this.zzabg.zzax(this.zzabk.get(0).longValue());
                this.zzabg.zzay(this.zzabk.get(1).longValue());
            }
        }
    }
}
