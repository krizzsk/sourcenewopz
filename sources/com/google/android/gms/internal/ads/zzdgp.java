package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zzj;
import com.google.android.gms.ads.internal.zzr;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzdgp implements zzdhe<zzdgq> {
    private final Context context;
    private final zzbar zzbpx;
    private final zzebs zzgka;

    public zzdgp(zzebs zzebs, Context context2, zzbar zzbar) {
        this.zzgka = zzebs;
        this.context = context2;
        this.zzbpx = zzbar;
    }

    public final zzebt<zzdgq> zzatu() {
        return this.zzgka.zze(new zzdgs(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdgq zzaun() throws Exception {
        boolean isCallerInstantApp = Wrappers.packageManager(this.context).isCallerInstantApp();
        zzr.zzkv();
        boolean zzax = zzj.zzax(this.context);
        String str = this.zzbpx.zzbrz;
        zzr.zzkx();
        boolean zzzx = com.google.android.gms.ads.internal.util.zzr.zzzx();
        zzr.zzkv();
        return new zzdgq(isCallerInstantApp, zzax, str, zzzx, zzj.zzau(this.context), DynamiteModule.getRemoteVersion(this.context, ModuleDescriptor.MODULE_ID), DynamiteModule.getLocalVersion(this.context, ModuleDescriptor.MODULE_ID));
    }
}
