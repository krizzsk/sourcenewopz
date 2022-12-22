package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zzj;
import com.google.android.gms.ads.internal.zzb;
import com.google.android.gms.ads.internal.zzm;
import com.google.android.gms.ads.internal.zzr;
import com.google.android.gms.common.util.Predicate;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONObject;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzakx implements zzakq, zzakv {
    private final zzbfi zzdkm;

    public zzakx(Context context, zzbar zzbar, zzei zzei, zzb zzb) throws zzbfu {
        zzr.zzkw();
        zzbfi zza = zzbfq.zza(context, zzbgx.zzafg(), "", false, false, zzei, (zzacv) null, zzbar, (zzach) null, (zzm) null, (zzb) null, zztz.zznl(), (zzdot) null, (zzdoy) null);
        this.zzdkm = zza;
        zza.getView().setWillNotDraw(true);
    }

    public final void zza(String str, Map map) {
        zzakt.zza((zzakq) this, str, map);
    }

    public final void zza(String str, JSONObject jSONObject) {
        zzakt.zzb(this, str, jSONObject);
    }

    public final void zzb(String str, JSONObject jSONObject) {
        zzakt.zza((zzakq) this, str, jSONObject);
    }

    public final void zzi(String str, String str2) {
        zzakt.zza((zzakq) this, str, str2);
    }

    private static void runOnUiThread(Runnable runnable) {
        zzww.zzqw();
        if (zzbae.zzaaq()) {
            runnable.run();
        } else {
            zzj.zzegq.post(runnable);
        }
    }

    public final void zzcv(String str) {
        runOnUiThread(new zzakw(this, str));
    }

    public final void zzcw(String str) {
        runOnUiThread(new zzakz(this, String.format("<!DOCTYPE html><html><head><script src=\"%s\"></script></head><body></body></html>", new Object[]{str})));
    }

    public final void zzcy(String str) {
        runOnUiThread(new zzaky(this, str));
    }

    public final void zzcx(String str) {
        runOnUiThread(new zzalb(this, str));
    }

    public final void zza(String str, zzaig<? super zzamc> zzaig) {
        this.zzdkm.zza(str, (zzaig<? super zzbfi>) new zzalc(this, zzaig));
    }

    public final void zzb(String str, zzaig<? super zzamc> zzaig) {
        this.zzdkm.zza(str, (Predicate<zzaig<? super zzbfi>>) new zzala(zzaig));
    }

    public final void zza(zzaku zzaku) {
        zzbgu zzaef = this.zzdkm.zzaef();
        zzaku.getClass();
        zzaef.zza(zzald.zzb(zzaku));
    }

    public final zzamf zzuu() {
        return new zzame(this);
    }

    public final void destroy() {
        this.zzdkm.destroy();
    }

    public final boolean isDestroyed() {
        return this.zzdkm.isDestroyed();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzcz(String str) {
        this.zzdkm.loadUrl(str);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzda(String str) {
        this.zzdkm.loadData(str, "text/html", "UTF-8");
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzdb(String str) {
        this.zzdkm.loadData(str, "text/html", "UTF-8");
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzdc(String str) {
        this.zzdkm.zzcv(str);
    }
}
