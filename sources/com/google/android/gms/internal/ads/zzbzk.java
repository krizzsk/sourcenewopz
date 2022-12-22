package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbzk extends zzbxq<zzqw> implements zzqw {
    private final Context context;
    private final zzdot zzeux;
    private Map<View, zzqs> zzgdg = new WeakHashMap(1);

    public zzbzk(Context context2, Set<zzbzl<zzqw>> set, zzdot zzdot) {
        super(set);
        this.context = context2;
        this.zzeux = zzdot;
    }

    public final synchronized void zza(zzqx zzqx) {
        zza(new zzbzn(zzqx));
    }

    public final synchronized void zzv(View view) {
        zzqs zzqs = this.zzgdg.get(view);
        if (zzqs == null) {
            zzqs = new zzqs(this.context, view);
            zzqs.zza((zzqw) this);
            this.zzgdg.put(view, zzqs);
        }
        if (this.zzeux != null && this.zzeux.zzdyk) {
            if (((Boolean) zzww.zzra().zzd(zzabq.zzcri)).booleanValue()) {
                zzqs.zzen(((Long) zzww.zzra().zzd(zzabq.zzcrh)).longValue());
                return;
            }
        }
        zzqs.zzlx();
    }

    public final synchronized void zzw(View view) {
        if (this.zzgdg.containsKey(view)) {
            this.zzgdg.get(view).zzb(this);
            this.zzgdg.remove(view);
        }
    }
}
