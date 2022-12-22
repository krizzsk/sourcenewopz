package com.google.android.gms.internal.ads;

import android.view.ViewGroup;
import android.view.ViewParent;
import com.google.android.gms.ads.internal.util.zzd;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzdle implements zzebi<zzbne> {
    private final /* synthetic */ zzdav zzhcc;
    private final /* synthetic */ zzboa zzhjm;
    final /* synthetic */ zzdlc zzhjn;

    zzdle(zzdlc zzdlc, zzdav zzdav, zzboa zzboa) {
        this.zzhjn = zzdlc;
        this.zzhcc = zzdav;
        this.zzhjm = zzboa;
    }

    public final void zzb(Throwable th) {
        zzvh zze = this.zzhjm.zzahd().zze(th);
        synchronized (this.zzhjn) {
            zzebt unused = this.zzhjn.zzhjl = null;
            this.zzhjm.zzahe().zzd(zze);
            if (((Boolean) zzww.zzra().zzd(zzabq.zzdas)).booleanValue()) {
                this.zzhjn.zzfur.execute(new zzdlg(this, zze));
            }
            this.zzhjn.zzhjk.zzef(60);
            zzdqa.zza(zze.errorCode, th, "BannerAdLoader.onFailure");
            this.zzhcc.zzatg();
        }
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        zzbne zzbne = (zzbne) obj;
        synchronized (this.zzhjn) {
            zzebt unused = this.zzhjn.zzhjl = null;
            this.zzhjn.zzfwu.removeAllViews();
            if (zzbne.zzakl() != null) {
                ViewParent parent = zzbne.zzakl().getParent();
                if (parent instanceof ViewGroup) {
                    String str = "";
                    if (zzbne.zzall() != null) {
                        str = zzbne.zzall().getMediationAdapterClassName();
                    }
                    StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 78);
                    sb.append("Banner view provided from ");
                    sb.append(str);
                    sb.append(" already has a parent view. Removing its old parent.");
                    zzd.zzez(sb.toString());
                    ((ViewGroup) parent).removeView(zzbne.zzakl());
                }
            }
            if (((Boolean) zzww.zzra().zzd(zzabq.zzdas)).booleanValue()) {
                zzbne.zzaln().zza(this.zzhjn.zzhas).zza(this.zzhjn.zzhji);
            }
            this.zzhjn.zzfwu.addView(zzbne.zzakl());
            this.zzhcc.onSuccess(zzbne);
            if (((Boolean) zzww.zzra().zzd(zzabq.zzdas)).booleanValue()) {
                Executor zzd = this.zzhjn.zzfur;
                zzczm zzc = this.zzhjn.zzhas;
                zzc.getClass();
                zzd.execute(zzdld.zzb(zzc));
            }
            this.zzhjn.zzhjk.zzef(zzbne.zzaku());
        }
    }
}
