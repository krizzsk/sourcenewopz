package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzb;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.Executor;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzchu {
    private final Context context;
    private final zzbfq zzbqk;
    private final zzcmb zzdje;
    private final zzdtw zzdjf;
    private final zzcsh zzdji;
    private final zzbar zzdvi;
    private final zzei zzeus;
    private final zzdup zzftn;
    private final Executor zzfur;
    private final zzb zzgkn;
    /* access modifiers changed from: private */
    public final zzcic zzglg = new zzcic((zzchz) null);
    private final zzais zzglh;
    private zzebt<zzbfi> zzgli;

    zzchu(zzcih zzcih) {
        this.context = zzcih.context;
        this.zzfur = zzcih.zzfur;
        this.zzeus = zzcih.zzeus;
        this.zzdvi = zzcih.zzdvi;
        this.zzgkn = zzcih.zzgkn;
        this.zzbqk = zzcih.zzbqk;
        this.zzglh = new zzais();
        this.zzdji = zzcih.zzdji;
        this.zzftn = zzcih.zzftn;
        this.zzdje = zzcih.zzdje;
        this.zzdjf = zzcih.zzdjf;
    }

    public final synchronized void zzaqh() {
        zzebt<zzbfi> zzb = zzebh.zzb(zzbfq.zza(this.context, this.zzdvi, (String) zzww.zzra().zzd(zzabq.zzctp), this.zzeus, this.zzgkn), new zzchx(this), this.zzfur);
        this.zzgli = zzb;
        zzbba.zza(zzb, "NativeJavascriptExecutor.initializeEngine");
    }

    public final synchronized void destroy() {
        if (this.zzgli != null) {
            zzebh.zza(this.zzgli, new zzchz(this), this.zzfur);
            this.zzgli = null;
        }
    }

    public final synchronized zzebt<JSONObject> zzc(String str, JSONObject jSONObject) {
        if (this.zzgli == null) {
            return zzebh.zzag(null);
        }
        return zzebh.zzb(this.zzgli, new zzchw(this, str, jSONObject), this.zzfur);
    }

    public final synchronized void zza(String str, zzaig<Object> zzaig) {
        if (this.zzgli != null) {
            zzebh.zza(this.zzgli, new zzchy(this, str, zzaig), this.zzfur);
        }
    }

    public final synchronized void zzb(String str, zzaig<Object> zzaig) {
        if (this.zzgli != null) {
            zzebh.zza(this.zzgli, new zzcib(this, str, zzaig), this.zzfur);
        }
    }

    public final synchronized void zza(String str, Map<String, ?> map) {
        if (this.zzgli != null) {
            zzebh.zza(this.zzgli, new zzcia(this, str, map), this.zzfur);
        }
    }

    public final synchronized void zza(zzdot zzdot, zzdoy zzdoy) {
        if (this.zzgli != null) {
            zzebh.zza(this.zzgli, new zzcid(this, zzdot, zzdoy), this.zzfur);
        }
    }

    public final <T> void zza(WeakReference<T> weakReference, String str, zzaig<T> zzaig) {
        zza(str, (zzaig<Object>) new zzcig(this, weakReference, str, zzaig, (zzchz) null));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzebt zza(String str, JSONObject jSONObject, zzbfi zzbfi) throws Exception {
        return this.zzglh.zza(zzbfi, str, jSONObject);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzbfi zzj(zzbfi zzbfi) {
        zzbfi zzbfi2 = zzbfi;
        zzbfi2.zza("/result", (zzaig<? super zzbfi>) this.zzglh);
        zzbgu zzaef = zzbfi.zzaef();
        zzcic zzcic = this.zzglg;
        zza zza = new zza(this.context, (zzaxo) null, (zzatu) null);
        zzcsh zzcsh = this.zzdji;
        zzdup zzdup = this.zzftn;
        zzaef.zza((zzve) null, zzcic, zzcic, zzcic, zzcic, false, (zzaii) null, zza, (zzari) null, (zzaxo) null, zzcsh, zzdup, this.zzdje, this.zzdjf);
        return zzbfi2;
    }
}
