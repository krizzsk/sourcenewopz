package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.overlay.zzl;
import com.google.android.gms.ads.internal.overlay.zzp;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.common.util.Clock;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbli implements zzp, zzbtp, zzbtq, zzqw {
    private final Clock zzbqq;
    private final zzbld zzfun;
    private final zzblg zzfuo;
    private final Set<zzbfi> zzfup = new HashSet();
    private final zzana<JSONObject, JSONObject> zzfuq;
    private final Executor zzfur;
    private final AtomicBoolean zzfus = new AtomicBoolean(false);
    private final zzblk zzfut = new zzblk();
    private boolean zzfuu = false;
    private WeakReference<?> zzfuv = new WeakReference<>(this);

    public zzbli(zzamx zzamx, zzblg zzblg, Executor executor, zzbld zzbld, Clock clock) {
        this.zzfun = zzbld;
        this.zzfuq = zzamx.zzb("google.afma.activeView.handleUpdate", zzamn.zzdma, zzamn.zzdma);
        this.zzfuo = zzblg;
        this.zzfur = executor;
        this.zzbqq = clock;
    }

    public final void onUserLeaveHint() {
    }

    public final void zza(zzl zzl) {
    }

    public final void zzvz() {
    }

    public final synchronized void zzajs() {
        if (!(this.zzfuv.get() != null)) {
            zzaju();
        } else if (!this.zzfuu && this.zzfus.get()) {
            try {
                this.zzfut.timestamp = this.zzbqq.elapsedRealtime();
                JSONObject zza = this.zzfuo.zzi(this.zzfut);
                for (zzbfi zzbll : this.zzfup) {
                    this.zzfur.execute(new zzbll(zzbll, zza));
                }
                zzbba.zzb(this.zzfuq.zzf(zza), "ActiveViewListener.callActiveViewJs");
            } catch (Exception e) {
                zzd.zza("Failed to call ActiveViewJS", e);
            }
        }
    }

    private final void zzajt() {
        for (zzbfi zzb : this.zzfup) {
            this.zzfun.zzb(zzb);
        }
        this.zzfun.zzajr();
    }

    public final synchronized void zzaju() {
        zzajt();
        this.zzfuu = true;
    }

    public final synchronized void zzc(zzbfi zzbfi) {
        this.zzfup.add(zzbfi);
        this.zzfun.zza(zzbfi);
    }

    public final void zzn(Object obj) {
        this.zzfuv = new WeakReference<>(obj);
    }

    public final synchronized void zza(zzqx zzqx) {
        this.zzfut.zzbrt = zzqx.zzbrt;
        this.zzfut.zzfva = zzqx;
        zzajs();
    }

    public final synchronized void zzce(Context context) {
        this.zzfut.zzfux = true;
        zzajs();
    }

    public final synchronized void zzcf(Context context) {
        this.zzfut.zzfux = false;
        zzajs();
    }

    public final synchronized void zzcg(Context context) {
        this.zzfut.zzfuz = "u";
        zzajs();
        zzajt();
        this.zzfuu = true;
    }

    public final synchronized void onPause() {
        this.zzfut.zzfux = true;
        zzajs();
    }

    public final synchronized void onResume() {
        this.zzfut.zzfux = false;
        zzajs();
    }

    public final synchronized void onAdImpression() {
        if (this.zzfus.compareAndSet(false, true)) {
            this.zzfun.zza(this);
            zzajs();
        }
    }
}
