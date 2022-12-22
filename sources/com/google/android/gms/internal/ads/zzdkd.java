package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzl;
import com.google.android.gms.ads.internal.overlay.zzp;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzdkd implements zzp, zzbsz, zzbus, zzbvb, zzdmi {
    private final AtomicReference<zzyx> zzhax = new AtomicReference<>();
    private final zzdqs zzhis;
    private final AtomicReference<zzsq> zzhit = new AtomicReference<>();
    private final AtomicReference<zzsv> zzhiu = new AtomicReference<>();
    private final AtomicReference<zzsw> zzhiv = new AtomicReference<>();
    private final AtomicReference<zzbus> zzhiw = new AtomicReference<>();
    private final AtomicReference<zzp> zzhix = new AtomicReference<>();
    private zzdkd zzhiy = null;

    public zzdkd(zzdqs zzdqs) {
        this.zzhis = zzdqs;
    }

    public final void onPause() {
    }

    public final void onResume() {
    }

    public static zzdkd zzb(zzdkd zzdkd) {
        zzdkd zzdkd2 = new zzdkd(zzdkd.zzhis);
        zzdkd2.zzb((zzdmi) zzdkd);
        return zzdkd2;
    }

    public final void zzb(zzsq zzsq) {
        this.zzhit.set(zzsq);
    }

    public final void zzb(zzsv zzsv) {
        this.zzhiu.set(zzsv);
    }

    public final void zza(zzsw zzsw) {
        this.zzhiv.set(zzsw);
    }

    public final void zza(zzbus zzbus) {
        this.zzhiw.set(zzbus);
    }

    public final void zza(zzp zzp) {
        this.zzhix.set(zzp);
    }

    public final void zzb(zzyx zzyx) {
        this.zzhax.set(zzyx);
    }

    public final void zzb(zzvv zzvv) {
        zzdkd zzdkd = this;
        while (true) {
            zzdkd zzdkd2 = zzdkd.zzhiy;
            if (zzdkd2 != null) {
                zzdkd = zzdkd2;
            } else {
                zzdlx.zza(zzdkd.zzhax, new zzdkg(zzvv));
                return;
            }
        }
    }

    public final void zzb(zzsp zzsp) {
        zzdkd zzdkd = this;
        while (true) {
            zzdkd zzdkd2 = zzdkd.zzhiy;
            if (zzdkd2 != null) {
                zzdkd = zzdkd2;
            } else {
                zzdlx.zza(zzdkd.zzhit, new zzdkf(zzsp));
                return;
            }
        }
    }

    public final void zzd(zzvh zzvh) {
        zzdkd zzdkd = this;
        while (true) {
            zzdkd zzdkd2 = zzdkd.zzhiy;
            if (zzdkd2 != null) {
                zzdkd = zzdkd2;
            } else {
                zzdlx.zza(zzdkd.zzhit, new zzdkk(zzvh));
                zzdlx.zza(zzdkd.zzhit, new zzdkj(zzvh));
                return;
            }
        }
    }

    public final void onAdClosed() {
        zzdkd zzdkd = this;
        while (true) {
            zzdkd zzdkd2 = zzdkd.zzhiy;
            if (zzdkd2 != null) {
                zzdkd = zzdkd2;
            } else {
                zzdkd.zzhis.onAdClosed();
                zzdlx.zza(zzdkd.zzhiu, zzdkm.zzhbd);
                zzdlx.zza(zzdkd.zzhiv, zzdkl.zzhbd);
                return;
            }
        }
    }

    public final void zzamk() {
        zzdkd zzdkd = this;
        while (true) {
            zzdkd zzdkd2 = zzdkd.zzhiy;
            if (zzdkd2 != null) {
                zzdkd = zzdkd2;
            } else {
                zzdlx.zza(zzdkd.zzhiw, zzdko.zzhbd);
                return;
            }
        }
    }

    public final void zzvz() {
        zzdkd zzdkd = this;
        while (true) {
            zzdkd zzdkd2 = zzdkd.zzhiy;
            if (zzdkd2 != null) {
                zzdkd = zzdkd2;
            } else {
                zzdlx.zza(zzdkd.zzhix, zzdkn.zzhbd);
                zzdlx.zza(zzdkd.zzhiv, zzdkq.zzhbd);
                zzdlx.zza(zzdkd.zzhiv, zzdkp.zzhbd);
                return;
            }
        }
    }

    public final void zza(zzl zzl) {
        zzdkd zzdkd = this;
        while (true) {
            zzdkd zzdkd2 = zzdkd.zzhiy;
            if (zzdkd2 != null) {
                zzdkd = zzdkd2;
            } else {
                zzdlx.zza(zzdkd.zzhix, new zzdki(zzl));
                return;
            }
        }
    }

    public final void onUserLeaveHint() {
        zzdkd zzdkd = this;
        while (true) {
            zzdkd zzdkd2 = zzdkd.zzhiy;
            if (zzdkd2 != null) {
                zzdkd = zzdkd2;
            } else {
                zzdlx.zza(zzdkd.zzhix, zzdkh.zzhbd);
                return;
            }
        }
    }

    public final void zzb(zzdmi zzdmi) {
        this.zzhiy = (zzdkd) zzdmi;
    }
}
