package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.common.util.Clock;
import java.util.concurrent.Executor;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzblv implements zzqw {
    private final Clock zzbqq;
    private boolean zzbwt = false;
    private zzbfi zzdkm;
    private final zzblg zzfuo;
    private final Executor zzfur;
    private zzblk zzfut = new zzblk();
    private boolean zzfvo = false;

    public zzblv(Executor executor, zzblg zzblg, Clock clock) {
        this.zzfur = executor;
        this.zzfuo = zzblg;
        this.zzbqq = clock;
    }

    private final void zzajv() {
        try {
            JSONObject zza = this.zzfuo.zzi(this.zzfut);
            if (this.zzdkm != null) {
                this.zzfur.execute(new zzblu(this, zza));
            }
        } catch (JSONException e) {
            zzd.zza("Failed to call video active view js", e);
        }
    }

    public final void zza(zzqx zzqx) {
        this.zzfut.zzbrt = this.zzfvo ? false : zzqx.zzbrt;
        this.zzfut.timestamp = this.zzbqq.elapsedRealtime();
        this.zzfut.zzfva = zzqx;
        if (this.zzbwt) {
            zzajv();
        }
    }

    public final void zzd(zzbfi zzbfi) {
        this.zzdkm = zzbfi;
    }

    public final void disable() {
        this.zzbwt = false;
    }

    public final void enable() {
        this.zzbwt = true;
        zzajv();
    }

    public final void zzbi(boolean z) {
        this.zzfvo = z;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzj(JSONObject jSONObject) {
        this.zzdkm.zzb("AFMA_updateActiveView", jSONObject);
    }
}
