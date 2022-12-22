package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.MobileAds;
import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeoutException;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzcwn implements zzebi<T> {
    private final /* synthetic */ zzdoy zzglq;
    private final /* synthetic */ long zzgyb;
    private final /* synthetic */ String zzgyc;
    private final /* synthetic */ zzdot zzgyd;
    private final /* synthetic */ zzcwk zzgye;

    zzcwn(zzcwk zzcwk, long j, String str, zzdot zzdot, zzdoy zzdoy) {
        this.zzgye = zzcwk;
        this.zzgyb = j;
        this.zzgyc = str;
        this.zzgyd = zzdot;
        this.zzglq = zzdoy;
    }

    public final void onSuccess(T t) {
        long elapsedRealtime = this.zzgye.zzbqq.elapsedRealtime() - this.zzgyb;
        this.zzgye.zza(this.zzgyc, 0, elapsedRealtime, this.zzgyd.zzhmx);
        if (this.zzgye.zzgya) {
            this.zzgye.zzgxy.zza(this.zzglq, this.zzgyd, 0, (zzctd) null, elapsedRealtime);
        }
        if (((Boolean) zzww.zzra().zzd(zzabq.zzdbb)).booleanValue()) {
            this.zzgye.zzfzp.zza(this.zzgyd, elapsedRealtime, (zzvh) null);
        }
    }

    public final void zzb(Throwable th) {
        int i;
        long elapsedRealtime = this.zzgye.zzbqq.elapsedRealtime() - this.zzgyb;
        if (th instanceof TimeoutException) {
            i = 2;
        } else if (th instanceof zzcwa) {
            i = 3;
        } else if (th instanceof CancellationException) {
            i = 4;
        } else if (th instanceof zzdpq) {
            i = 5;
        } else {
            i = (!(th instanceof zzcnp) || zzdqh.zzh(th).errorCode != 3) ? 6 : 1;
        }
        this.zzgye.zza(this.zzgyc, i, elapsedRealtime, this.zzgyd.zzhmx);
        if (this.zzgye.zzgya) {
            this.zzgye.zzgxy.zza(this.zzglq, this.zzgyd, i, th instanceof zzctd ? (zzctd) th : null, elapsedRealtime);
        }
        if (((Boolean) zzww.zzra().zzd(zzabq.zzdbb)).booleanValue()) {
            zzvh zzh = zzdqh.zzh(th);
            if ((zzh.errorCode == 3 || zzh.errorCode == 0) && zzh.zzchu != null && !zzh.zzchu.zzcht.equals(MobileAds.ERROR_DOMAIN)) {
                zzh = zzdqh.zzh(new zzctd(zzdqj.MEDIATION_NO_FILL, zzh.zzchu));
            }
            this.zzgye.zzfzp.zza(this.zzgyd, elapsedRealtime, zzh);
        }
    }
}
