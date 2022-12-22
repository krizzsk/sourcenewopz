package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzj;
import com.google.android.gms.ads.internal.zzr;
import java.util.concurrent.Executor;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzana<I, O> implements zzear<I, O> {
    /* access modifiers changed from: private */
    public final zzami<O> zzdmh;
    private final zzaml<I> zzdmi;
    private final String zzdmj;
    private final zzebt<zzamc> zzdmn;

    zzana(zzebt<zzamc> zzebt, String str, zzaml<I> zzaml, zzami<O> zzami) {
        this.zzdmn = zzebt;
        this.zzdmj = str;
        this.zzdmi = zzaml;
        this.zzdmh = zzami;
    }

    public final zzebt<O> zzf(I i) throws Exception {
        return zzebh.zzb(this.zzdmn, new zzand(this, i), (Executor) zzbat.zzekj);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzebt zza(Object obj, zzamc zzamc) throws Exception {
        zzbbe zzbbe = new zzbbe();
        zzr.zzkv();
        String zzzr = zzj.zzzr();
        zzahr.zzdiv.zza(zzzr, (zzaiu) new zzanc(this, zzbbe));
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("id", zzzr);
        jSONObject.put("args", this.zzdmi.zzi(obj));
        zzamc.zzb(this.zzdmj, jSONObject);
        return zzbbe;
    }
}
