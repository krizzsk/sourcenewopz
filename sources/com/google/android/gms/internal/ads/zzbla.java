package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbla implements zzesa<zzbkz> {
    private final zzesn<Executor> zzeyl;
    private final zzesn<Context> zzeyq;
    private final zzesn<zzdun> zzffe;
    private final zzesn<zzacv> zzfft;
    private final zzesn<zzdpu> zzfij;
    private final zzesn<ScheduledExecutorService> zzfty;
    private final zzesn<zzdpi> zzftz;
    private final zzesn<zzdot> zzfua;
    private final zzesn<View> zzfub;
    private final zzesn<zzei> zzfuc;
    private final zzesn<zzacw> zzfud;

    private zzbla(zzesn<Context> zzesn, zzesn<Executor> zzesn2, zzesn<ScheduledExecutorService> zzesn3, zzesn<zzdpi> zzesn4, zzesn<zzdot> zzesn5, zzesn<zzdun> zzesn6, zzesn<zzdpu> zzesn7, zzesn<View> zzesn8, zzesn<zzei> zzesn9, zzesn<zzacv> zzesn10, zzesn<zzacw> zzesn11) {
        this.zzeyq = zzesn;
        this.zzeyl = zzesn2;
        this.zzfty = zzesn3;
        this.zzftz = zzesn4;
        this.zzfua = zzesn5;
        this.zzffe = zzesn6;
        this.zzfij = zzesn7;
        this.zzfub = zzesn8;
        this.zzfuc = zzesn9;
        this.zzfft = zzesn10;
        this.zzfud = zzesn11;
    }

    public static zzbla zza(zzesn<Context> zzesn, zzesn<Executor> zzesn2, zzesn<ScheduledExecutorService> zzesn3, zzesn<zzdpi> zzesn4, zzesn<zzdot> zzesn5, zzesn<zzdun> zzesn6, zzesn<zzdpu> zzesn7, zzesn<View> zzesn8, zzesn<zzei> zzesn9, zzesn<zzacv> zzesn10, zzesn<zzacw> zzesn11) {
        return new zzbla(zzesn, zzesn2, zzesn3, zzesn4, zzesn5, zzesn6, zzesn7, zzesn8, zzesn9, zzesn10, zzesn11);
    }

    public final /* synthetic */ Object get() {
        return new zzbkz(this.zzeyq.get(), this.zzeyl.get(), this.zzfty.get(), this.zzftz.get(), this.zzfua.get(), this.zzffe.get(), this.zzfij.get(), this.zzfub.get(), this.zzfuc.get(), this.zzfft.get(), this.zzfud.get());
    }
}
