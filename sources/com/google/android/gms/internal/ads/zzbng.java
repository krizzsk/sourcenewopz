package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Iterator;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzbng extends zzbne {
    private final Context context;
    private final View view;
    private final zzbfi zzdkm;
    private final Executor zzfur;
    private final zzdow zzfvv;
    private final zzbpd zzfww;
    private final zzcdy zzfwx;
    private final zzbzp zzfwy;
    private final zzeru<zzczg> zzfwz;
    private zzvt zzfxa;

    zzbng(zzbpf zzbpf, Context context2, zzdow zzdow, View view2, zzbfi zzbfi, zzbpd zzbpd, zzcdy zzcdy, zzbzp zzbzp, zzeru<zzczg> zzeru, Executor executor) {
        super(zzbpf);
        this.context = context2;
        this.view = view2;
        this.zzdkm = zzbfi;
        this.zzfvv = zzdow;
        this.zzfww = zzbpd;
        this.zzfwx = zzcdy;
        this.zzfwy = zzbzp;
        this.zzfwz = zzeru;
        this.zzfur = executor;
    }

    public final View zzakl() {
        return this.view;
    }

    public final void zza(ViewGroup viewGroup, zzvt zzvt) {
        zzbfi zzbfi;
        if (viewGroup != null && (zzbfi = this.zzdkm) != null) {
            zzbfi.zza(zzbgx.zzb(zzvt));
            viewGroup.setMinimumHeight(zzvt.heightPixels);
            viewGroup.setMinimumWidth(zzvt.widthPixels);
            this.zzfxa = zzvt;
        }
    }

    public final zzzd getVideoController() {
        try {
            return this.zzfww.getVideoController();
        } catch (zzdpq unused) {
            return null;
        }
    }

    public final zzdow zzakk() {
        boolean z;
        zzvt zzvt = this.zzfxa;
        if (zzvt != null) {
            return zzdpr.zzh(zzvt);
        }
        if (this.zzeux.zzhmu) {
            Iterator<String> it = this.zzeux.zzhly.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                String next = it.next();
                if (next != null && next.contains("FirstParty")) {
                    z = true;
                    break;
                }
            }
            if (!z) {
                return new zzdow(this.view.getWidth(), this.view.getHeight(), false);
            }
        }
        return zzdpr.zza(this.zzeux.zzhmg, this.zzfvv);
    }

    public final zzdow zzakt() {
        return this.zzfvv;
    }

    public final int zzaku() {
        if (((Boolean) zzww.zzra().zzd(zzabq.zzdaf)).booleanValue() && this.zzeux.zzadh) {
            if (!((Boolean) zzww.zzra().zzd(zzabq.zzdag)).booleanValue()) {
                return 0;
            }
        }
        return this.zzftl.zzhnt.zzeuy.zzhnh;
    }

    public final void zzkj() {
        this.zzfwy.zzanl();
    }

    public final void zzakv() {
        this.zzfur.execute(new zzbnj(this));
        super.zzakv();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzakw() {
        if (this.zzfwx.zzapg() != null) {
            try {
                this.zzfwx.zzapg().zza(this.zzfwz.get(), ObjectWrapper.wrap(this.context));
            } catch (RemoteException e) {
                zzd.zzc("RemoteException when notifyAdLoad is called", e);
            }
        }
    }
}
