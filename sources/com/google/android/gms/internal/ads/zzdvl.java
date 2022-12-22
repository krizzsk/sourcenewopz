package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.internal.ads.zzcf;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
public final class zzdvl {
    private final Context context;
    private final Executor executor;
    private final zzdvr zzhwd;
    private final zzdvr zzhwe;
    private Task<zzcf.zza> zzhwf;
    private Task<zzcf.zza> zzhwg;
    private final zzduv zzvx;
    private final zzduz zzys;

    private zzdvl(Context context2, Executor executor2, zzduv zzduv, zzduz zzduz, zzdvp zzdvp, zzdvo zzdvo) {
        this.context = context2;
        this.executor = executor2;
        this.zzvx = zzduv;
        this.zzys = zzduz;
        this.zzhwd = zzdvp;
        this.zzhwe = zzdvo;
    }

    public static zzdvl zza(Context context2, Executor executor2, zzduv zzduv, zzduz zzduz) {
        zzdvl zzdvl = new zzdvl(context2, executor2, zzduv, zzduz, new zzdvp(), new zzdvo());
        if (zzdvl.zzys.zzayp()) {
            zzdvl.zzhwf = zzdvl.zzd(new zzdvk(zzdvl));
        } else {
            zzdvl.zzhwf = Tasks.forResult(zzdvl.zzhwd.zzayy());
        }
        zzdvl.zzhwg = zzdvl.zzd(new zzdvn(zzdvl));
        return zzdvl;
    }

    public final zzcf.zza zzayv() {
        return zza(this.zzhwf, this.zzhwd.zzayy());
    }

    public final zzcf.zza zzcp() {
        return zza(this.zzhwg, this.zzhwe.zzayy());
    }

    private final Task<zzcf.zza> zzd(Callable<zzcf.zza> callable) {
        return Tasks.call(this.executor, callable).addOnFailureListener(this.executor, (OnFailureListener) new zzdvm(this));
    }

    private static zzcf.zza zza(Task<zzcf.zza> task, zzcf.zza zza) {
        if (!task.isSuccessful()) {
            return zza;
        }
        return task.getResult();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzc(Exception exc) {
        if (exc instanceof InterruptedException) {
            Thread.currentThread().interrupt();
        }
        this.zzvx.zza(2025, -1, exc);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzcf.zza zzayw() throws Exception {
        return this.zzhwe.zzco(this.context);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzcf.zza zzayx() throws Exception {
        return this.zzhwd.zzco(this.context);
    }
}
