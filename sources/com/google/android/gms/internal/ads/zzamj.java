package com.google.android.gms.internal.ads;

import android.content.Context;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzamj {
    private final Object zzdlv = new Object();
    private final Object zzdlw = new Object();
    private zzamo zzdlx;
    private zzamo zzdly;

    public final zzamo zza(Context context, zzbar zzbar) {
        zzamo zzamo;
        synchronized (this.zzdlw) {
            if (this.zzdly == null) {
                this.zzdly = new zzamo(zzl(context), zzbar, zzadv.zzdga.get());
            }
            zzamo = this.zzdly;
        }
        return zzamo;
    }

    public final zzamo zzb(Context context, zzbar zzbar) {
        zzamo zzamo;
        synchronized (this.zzdlv) {
            if (this.zzdlx == null) {
                this.zzdlx = new zzamo(zzl(context), zzbar, (String) zzww.zzra().zzd(zzabq.zzcms));
            }
            zzamo = this.zzdlx;
        }
        return zzamo;
    }

    private static Context zzl(Context context) {
        Context applicationContext = context.getApplicationContext();
        return applicationContext == null ? context : applicationContext;
    }
}
