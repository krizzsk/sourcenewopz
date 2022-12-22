package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.browser.customtabs.CustomTabsIntent;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzb;
import com.google.android.gms.ads.internal.overlay.zzv;
import com.google.android.gms.ads.internal.overlay.zzx;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.common.util.PlatformVersion;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcuk implements zzcsz<zzcaj> {
    private final Context context;
    private final zzdor zzfti;
    private final Executor zzfur;
    private final zzcbj zzgwq;

    public zzcuk(Context context2, Executor executor, zzcbj zzcbj, zzdor zzdor) {
        this.context = context2;
        this.zzgwq = zzcbj;
        this.zzfur = executor;
        this.zzfti = zzdor;
    }

    public final boolean zza(zzdpi zzdpi, zzdot zzdot) {
        return (this.context instanceof Activity) && PlatformVersion.isAtLeastIceCreamSandwichMR1() && zzacq.zzj(this.context) && !TextUtils.isEmpty(zzf(zzdot));
    }

    public final zzebt<zzcaj> zzb(zzdpi zzdpi, zzdot zzdot) {
        String zzf = zzf(zzdot);
        return zzebh.zzb(zzebh.zzag(null), new zzcun(this, zzf != null ? Uri.parse(zzf) : null, zzdpi, zzdot), this.zzfur);
    }

    private static String zzf(zzdot zzdot) {
        try {
            return zzdot.zzhmk.getString("tab_url");
        } catch (Exception unused) {
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzebt zza(Uri uri, zzdpi zzdpi, zzdot zzdot, Object obj) throws Exception {
        try {
            CustomTabsIntent build = new CustomTabsIntent.Builder().build();
            build.intent.setData(uri);
            zzb zzb = new zzb(build.intent, (zzv) null);
            zzbbe zzbbe = new zzbbe();
            zzcal zza = this.zzgwq.zza(new zzbps(zzdpi, zzdot, (String) null), new zzcak(new zzcum(zzbbe)));
            zzbbe.set(new AdOverlayInfoParcel(zzb, (zzve) null, zza.zzaiu(), (zzx) null, new zzbar(0, 0, false), (zzbfi) null));
            this.zzfti.zzyh();
            return zzebh.zzag(zza.zzait());
        } catch (Throwable th) {
            zzd.zzc("Error in CustomTabsAdRenderer", th);
            throw th;
        }
    }
}
