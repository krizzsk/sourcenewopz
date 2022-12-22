package com.google.android.gms.internal.ads;

import java.util.regex.Matcher;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzcot implements zzebi<zzdpi> {
    private final /* synthetic */ zzcoo zzgqx;

    zzcot(zzcoo zzcoo) {
        this.zzgqx = zzcoo;
    }

    public final void zzb(Throwable th) {
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcyt)).booleanValue()) {
            Matcher matcher = zzcoo.zzgqv.matcher(th.getMessage());
            if (matcher.matches()) {
                this.zzgqx.zzgqu.zzei(Integer.parseInt(matcher.group(1)));
            }
        }
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        zzdpi zzdpi = (zzdpi) obj;
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcyt)).booleanValue()) {
            this.zzgqx.zzgqu.zzei(zzdpi.zzhnt.zzeuy.responseCode);
            this.zzgqx.zzgqu.zzeo(zzdpi.zzhnt.zzeuy.zzgss);
        }
    }
}
