package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzf;
import com.google.android.gms.ads.internal.zzr;
import java.lang.ref.WeakReference;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public class zzbhg {
    private final Context zzaai;
    private final zzbar zzbpj;
    private final WeakReference<Context> zzeyg;

    /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
    public static class zza {
        /* access modifiers changed from: private */
        public Context zzaai;
        /* access modifiers changed from: private */
        public zzbar zzbpj;
        /* access modifiers changed from: private */
        public WeakReference<Context> zzeyg;

        public final zza zza(zzbar zzbar) {
            this.zzbpj = zzbar;
            return this;
        }

        public final zza zzbz(Context context) {
            this.zzeyg = new WeakReference<>(context);
            if (context.getApplicationContext() != null) {
                context = context.getApplicationContext();
            }
            this.zzaai = context;
            return this;
        }
    }

    private zzbhg(zza zza2) {
        this.zzbpj = zza2.zzbpj;
        this.zzaai = zza2.zzaai;
        this.zzeyg = zza2.zzeyg;
    }

    /* access modifiers changed from: package-private */
    public final Context zzafp() {
        return this.zzaai;
    }

    /* access modifiers changed from: package-private */
    public final WeakReference<Context> zzafq() {
        return this.zzeyg;
    }

    /* access modifiers changed from: package-private */
    public final zzbar zzafr() {
        return this.zzbpj;
    }

    /* access modifiers changed from: package-private */
    public final String zzafs() {
        return zzr.zzkv().zzq(this.zzaai, this.zzbpj.zzbrz);
    }

    public final zzei zzaft() {
        return new zzei(new zzf(this.zzaai, this.zzbpj));
    }
}
