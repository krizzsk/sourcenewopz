package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.TrafficStats;
import com.google.android.gms.ads.internal.util.zzbr;
import com.google.android.gms.ads.internal.zzb;
import com.google.android.gms.ads.internal.zzm;
import com.google.android.gms.ads.internal.zzr;
import java.util.concurrent.Executor;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbfq {
    public static zzebt<zzbfi> zza(Context context, zzbar zzbar, String str, zzei zzei, zzb zzb) {
        return zzebh.zzb(zzebh.zzag(null), new zzbfp(context, zzei, zzbar, zzb, str), (Executor) zzbat.zzeki);
    }

    public static zzbfi zza(Context context, zzbgx zzbgx, String str, boolean z, boolean z2, zzei zzei, zzacv zzacv, zzbar zzbar, zzach zzach, zzm zzm, zzb zzb, zztz zztz, zzdot zzdot, zzdoy zzdoy) throws zzbfu {
        zzabq.initialize(context);
        try {
            return (zzbfi) zzbr.zza(new zzbfs(context, zzbgx, str, z, z2, zzei, zzacv, zzbar, (zzach) null, zzm, zzb, zztz, zzdot, zzdoy));
        } catch (Throwable th) {
            throw new zzbfu("Webview initialization failed.", th);
        }
    }

    static final /* synthetic */ zzbfi zzb(Context context, zzbgx zzbgx, String str, boolean z, boolean z2, zzei zzei, zzacv zzacv, zzbar zzbar, zzach zzach, zzm zzm, zzb zzb, zztz zztz, zzdot zzdot, zzdoy zzdoy) {
        try {
            TrafficStats.setThreadStatsTag(264);
            zzbft zzbft = new zzbft(zzbfy.zzc(context, zzbgx, str, z, z2, zzei, zzacv, zzbar, zzach, zzm, zzb, zztz, zzdot, zzdoy));
            zzbft.setWebViewClient(zzr.zzkx().zza(zzbft, zztz, z2));
            zzbft.setWebChromeClient(new zzbfa(zzbft));
            return zzbft;
        } finally {
            TrafficStats.clearThreadStatsTag();
        }
    }
}
