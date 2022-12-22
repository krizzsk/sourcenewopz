package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzb;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcih implements Callable<zzchu> {
    /* access modifiers changed from: private */
    public final Context context;
    /* access modifiers changed from: private */
    public final zzbfq zzbqk;
    /* access modifiers changed from: private */
    public final zzcmb zzdje;
    /* access modifiers changed from: private */
    public final zzdtw zzdjf;
    /* access modifiers changed from: private */
    public final zzcsh zzdji;
    /* access modifiers changed from: private */
    public final zzbar zzdvi;
    /* access modifiers changed from: private */
    public final zzei zzeus;
    /* access modifiers changed from: private */
    public final zzdup zzftn;
    /* access modifiers changed from: private */
    public final Executor zzfur;
    /* access modifiers changed from: private */
    public final zzb zzgkn;

    public zzcih(Context context2, Executor executor, zzei zzei, zzbar zzbar, zzb zzb, zzbfq zzbfq, zzcsh zzcsh, zzdup zzdup, zzcmb zzcmb, zzdtw zzdtw) {
        this.context = context2;
        this.zzfur = executor;
        this.zzeus = zzei;
        this.zzdvi = zzbar;
        this.zzgkn = zzb;
        this.zzbqk = zzbfq;
        this.zzdji = zzcsh;
        this.zzftn = zzdup;
        this.zzdje = zzcmb;
        this.zzdjf = zzdtw;
    }

    public final /* synthetic */ Object call() throws Exception {
        zzchu zzchu = new zzchu(this);
        zzchu.zzaqh();
        return zzchu;
    }
}
