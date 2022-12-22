package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzr;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzaut implements Callable<zzauo> {
    private final /* synthetic */ Context val$context;
    private final /* synthetic */ zzauq zzeai;

    zzaut(zzauq zzauq, Context context) {
        this.zzeai = zzauq;
        this.val$context = context;
    }

    public final /* synthetic */ Object call() throws Exception {
        zzauo zzauo;
        zzaus zzaus = (zzaus) this.zzeai.zzeaf.get(this.val$context);
        if (zzaus != null) {
            if (!(zzaus.zzeag + zzadf.zzdea.get().longValue() < zzr.zzlc().currentTimeMillis())) {
                zzauo = new zzaur(this.val$context, zzaus.zzeah).zzxd();
                this.zzeai.zzeaf.put(this.val$context, new zzaus(this.zzeai, zzauo));
                return zzauo;
            }
        }
        zzauo = new zzaur(this.val$context).zzxd();
        this.zzeai.zzeaf.put(this.val$context, new zzaus(this.zzeai, zzauo));
        return zzauo;
    }
}
