package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.util.zzj;
import com.google.android.gms.ads.internal.zzr;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONObject;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzamt<I, O> implements zzamg<I, O> {
    private final zzale zzdme;
    /* access modifiers changed from: private */
    public final zzami<O> zzdmh;
    private final zzaml<I> zzdmi;
    private final String zzdmj;

    zzamt(zzale zzale, String str, zzaml<I> zzaml, zzami<O> zzami) {
        this.zzdme = zzale;
        this.zzdmj = str;
        this.zzdmi = zzaml;
        this.zzdmh = zzami;
    }

    public final zzebt<O> zzh(I i) {
        zzbbe zzbbe = new zzbbe();
        zzalv zzb = this.zzdme.zzb((zzei) null);
        zzb.zza(new zzams(this, zzb, i, zzbbe), new zzamv(this, zzbbe, zzb));
        return zzbbe;
    }

    /* access modifiers changed from: private */
    public final void zza(zzalv zzalv, zzamc zzamc, I i, zzbbe<O> zzbbe) {
        try {
            zzr.zzkv();
            String zzzr = zzj.zzzr();
            zzahr.zzdiv.zza(zzzr, (zzaiu) new zzamu(this, zzalv, zzbbe));
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", zzzr);
            jSONObject.put("args", this.zzdmi.zzi(i));
            zzamc.zzb(this.zzdmj, jSONObject);
        } catch (Exception e) {
            zzbbe.setException(e);
            zzd.zzc("Unable to invokeJavascript", e);
            zzalv.release();
        } catch (Throwable th) {
            zzalv.release();
            throw th;
        }
    }

    public final zzebt<O> zzf(I i) throws Exception {
        return zzh(i);
    }
}
